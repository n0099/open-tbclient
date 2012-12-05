package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import com.baidu.loginshare.ILoginShareListener;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.LoginShareEvent;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class AccountShareHelper {
    private static AccountShareHelper mHelper = null;
    private LoginShareData mLoginShareData = null;
    private LoginShareListener mListener = null;

    public static AccountShareHelper getInstance() {
        if (mHelper == null) {
            mHelper = new AccountShareHelper();
        }
        return mHelper;
    }

    private AccountShareHelper() {
    }

    public void valid() {
        try {
            if (!TiebaApplication.isBaiduAccountManager()) {
                Token token = new Token();
                String st = TiebaApplication.getCurrentBduss();
                if (st != null) {
                    remove();
                    String[] splits = st.split("[|]");
                    if (splits != null && splits.length == 2) {
                        token.mBduss = splits[0];
                        token.mPtoken = splits[1];
                        if (token.mPtoken != null && token.mPtoken.length() > 0) {
                            token.mUsername = TiebaApplication.getCurrentAccountName();
                            LoginShareAssistant.getInstance().valid(token);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "valid", ex.getMessage());
        }
    }

    public void invalid(String st) {
        String[] splits;
        try {
            if (!TiebaApplication.isBaiduAccountManager()) {
                Token token = new Token();
                if (st != null && (splits = st.split("[|]")) != null && splits.length == 2) {
                    token.mBduss = splits[0];
                    token.mPtoken = splits[1];
                    if (token.mPtoken != null && token.mPtoken.length() > 0) {
                        LoginShareAssistant.getInstance().invalid(token);
                    }
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "invalid", ex.getMessage());
        }
    }

    public void invalid(Token token) {
        if (token != null) {
            try {
                if (!TiebaApplication.isBaiduAccountManager()) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "invalid", ex.getMessage());
            }
        }
    }

    public void onActivityCreate() {
        try {
            if (!TiebaApplication.isBaiduAccountManager()) {
                LoginShareAssistant.getInstance().onActivityCreate();
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "onActivityCreate", ex.getMessage());
        }
    }

    public void prepare() {
        String st;
        try {
            if (!TiebaApplication.isBaiduAccountManager() && (st = TiebaApplication.app.loginShareRead()) != null) {
                this.mLoginShareData = new LoginShareData();
                String[] splits = st.split(":");
                int num = splits.length;
                if (num >= 1) {
                    if (NetWorkCore.NET_TYPE_NET.equals(splits[0])) {
                        this.mLoginShareData.isLogin = true;
                    } else {
                        this.mLoginShareData.isLogin = false;
                    }
                }
                if (num >= 2) {
                    this.mLoginShareData.bduss = splits[1];
                }
                if (num >= 3) {
                    this.mLoginShareData.ptoken = splits[2];
                }
                if (num >= 4) {
                    if (splits[3] == null || splits[3].equalsIgnoreCase("null")) {
                        this.mLoginShareData.name = null;
                    } else {
                        this.mLoginShareData.name = splits[3];
                    }
                }
                if (this.mLoginShareData != null && !this.mLoginShareData.isLogin) {
                    DatabaseService.clearActiveAccount();
                    TiebaApplication.setCurrentAccount(null);
                    remove();
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "prepare", ex.getMessage());
        }
    }

    public static Token parseBDUSS(String bduss) {
        String[] splits;
        Token token = null;
        try {
            if (TiebaApplication.isBaiduAccountManager() || bduss == null || (splits = bduss.split("[|]")) == null || splits.length != 2) {
                return null;
            }
            Token token2 = new Token();
            try {
                token2.mBduss = splits[0];
                token2.mPtoken = splits[1];
                return token2;
            } catch (Exception e) {
                ex = e;
                token = token2;
                TiebaLog.e("AccountShareHelper", "parseBDUSS", ex.getMessage());
                return token;
            }
        } catch (Exception e2) {
            ex = e2;
        }
    }

    public void remove() {
        this.mLoginShareData = null;
        TiebaApplication.app.loginShareRemove();
    }

    public void cancel() {
        this.mLoginShareData = null;
    }

    public void relogin(Activity context) {
        String name;
        if (this.mLoginShareData != null && this.mLoginShareData.isLogin && TiebaApplication.getCurrentAccount() == null && ((name = TiebaApplication.getCurrentAccountName()) == null || !name.equals(this.mLoginShareData.name))) {
            ReLoginShareActivity.startActivity(context, this.mLoginShareData.name, this.mLoginShareData.bduss, this.mLoginShareData.ptoken);
        }
        cancel();
    }

    public void init(Context context) {
        try {
            LoginShareAssistant assistant = LoginShareAssistant.getInstance();
            assistant.initial(context, "tb", "1536");
            this.mListener = new LoginShareListener(this, null);
            assistant.setLoginShareListener(this.mListener);
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "init", ex.getMessage());
        }
    }

    public void loginShareChange(boolean login, String bduss, String ptoken, String name) {
        String data = "1:";
        if (!login) {
            data = "2:";
        }
        TiebaApplication.app.loginShareSave(String.valueOf(data) + bduss + ":" + ptoken + ":" + name);
    }

    /* loaded from: classes.dex */
    public class LoginShareData {
        public boolean isLogin = false;
        public String bduss = null;
        public String ptoken = null;
        public String name = null;

        public LoginShareData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LoginShareListener implements ILoginShareListener {
        private LoginShareListener() {
        }

        /* synthetic */ LoginShareListener(AccountShareHelper accountShareHelper, LoginShareListener loginShareListener) {
            this();
        }

        @Override // com.baidu.loginshare.ILoginShareListener
        public void onLoginShareEvent(Token model) {
            if (model != null) {
                LoginShareEvent event = model.mEvent;
                String username = model.mUsername;
                String bduss = model.mBduss;
                String ptoken = model.mPtoken;
                TiebaLog.d(getClass().getName(), "onLoginShareEvent", "bduss = " + bduss);
                TiebaLog.d(getClass().getName(), "onLoginShareEvent", "username = " + username);
                TiebaLog.d(getClass().getName(), "onLoginShareEvent", "ptoken = " + ptoken);
                if (event == LoginShareEvent.VALID) {
                    if (bduss != null && ptoken != null) {
                        TiebaLog.d(getClass().getName(), "onLoginShareEvent", Config.ST_TYPE_LOGIN);
                        AccountShareHelper.this.loginShareChange(true, bduss, ptoken, username);
                        return;
                    }
                    return;
                }
                TiebaLog.d(getClass().getName(), "onLoginShareEvent", "logout");
                AccountShareHelper.this.loginShareChange(false, null, null, null);
            }
        }
    }
}
