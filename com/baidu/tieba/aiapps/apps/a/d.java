package com.baidu.tieba.aiapps.apps.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.common.util.CommonParam;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.ao.w;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.bdprivate.a.aa;
import com.baidu.swan.bdprivate.a.ab;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.a.z;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.d.a;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.e;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.bdprivate.a.a.a {
    private com.baidu.swan.apps.res.widget.dialog.c gnD;

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.bQj().a(context, bundle, aVar);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public boolean isLogin(Context context) {
        return a.bQj().isLogin();
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getBduss(Context context) {
        return a.bQj().getBduss();
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(String str, ArrayList<String> arrayList, b.a aVar) {
        a.bQj().b(str, arrayList, aVar);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getUid(Context context) {
        return a.bQj().getUid();
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getCuid(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
        String string = sharedPreferences.getString("uid_v3", "");
        if (TextUtils.isEmpty(string)) {
            String generateUID = generateUID(context);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("uid_v3", generateUID);
            edit.apply();
            return generateUID;
        }
        return string;
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public aa ej(Context context) {
        aa aaVar = new aa();
        aaVar.displayName = a.bQj().getDisplayName();
        aaVar.aWS = a.bQj().Ga();
        return aaVar;
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void b(com.baidu.swan.apps.a.c cVar) {
        a.bQj().a(cVar);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(final l.a aVar, String str, List<String> list) {
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.tieba.aiapps.apps.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                if (aVar != null) {
                    l lVar = new l();
                    if (getTplStokenResult != null) {
                        lVar.mStokens = getTplStokenResult.tplStokenMap;
                        lVar.mErrCode = getTplStokenResult.getResultCode();
                        lVar.mErrMsg = getTplStokenResult.getResultMsg();
                        if (getTplStokenResult.failureType != null) {
                            lVar.mFailureType = getTplStokenResult.failureType.name();
                        }
                    }
                    aVar.a(lVar);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (aVar != null) {
                    l lVar = new l();
                    if (getTplStokenResult != null) {
                        lVar.mStokens = getTplStokenResult.tplStokenMap;
                        lVar.mErrCode = getTplStokenResult.getResultCode();
                        lVar.mErrMsg = getTplStokenResult.getResultMsg();
                        if (getTplStokenResult.failureType != null) {
                            lVar.mFailureType = getTplStokenResult.failureType.name();
                        }
                    }
                    aVar.b(lVar);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                if (aVar != null) {
                    aVar.onStart();
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                if (aVar != null) {
                    aVar.onFinish();
                }
            }
        }, str, list);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String eg(Context context) {
        return h.aPH().getString("bd_box_ptoken", "");
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public String getZid(Context context) {
        return FH.gz(AppRuntime.getAppContext());
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.a.d$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass2 extends SmsViewLoginCallback {
        final /* synthetic */ SwanAppPhoneLoginDialog.a gnG;
        final /* synthetic */ Context val$context;

        AnonymousClass2(SwanAppPhoneLoginDialog.a aVar, Context context) {
            this.gnG = aVar;
            this.val$context = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            this.gnG.onCheckCodeViewShow();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            this.gnG.onCheckCodeViewHide();
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            w.forceHiddenSoftInput(this.val$context, ((FragmentActivity) this.val$context).getWindow().getDecorView().getWindowToken());
            String string = this.val$context.getResources().getString(b.g.account_login_dialog_needback_other);
            String string2 = this.val$context.getResources().getString(b.g.account_login_dialog_needback_positive_btn_login);
            if (webAuthResult.getResultCode() == 12) {
                string = this.val$context.getResources().getString(b.g.account_login_dialog_needback_phone);
                string2 = this.val$context.getResources().getString(b.g.account_login_dialog_needback_positive_btn_register);
            }
            new g.a(this.val$context).f(this.val$context.getResources().getString(b.g.account_login_dialog_needback_title)).sp(string).a(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.a.d.2.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.bdprivate.a.a.a((Activity) ((FragmentActivity) AnonymousClass2.this.val$context), false, (Bundle) null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.tieba.aiapps.apps.a.d.2.2.1
                        @Override // com.baidu.swan.apps.a.a
                        public void onResult(int i2) {
                            if (i2 == 0) {
                                AnonymousClass2.this.gnG.onSuccess();
                            } else {
                                AnonymousClass2.this.gnG.onFailure();
                            }
                        }
                    });
                }
            }).b(this.val$context.getResources().getString(b.g.account_login_dialog_needback_negative_btn), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.a.d.2.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).aLx();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            a.bQj().h(new com.baidu.swan.apps.a.a() { // from class: com.baidu.tieba.aiapps.apps.a.d.2.3
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (AnonymousClass2.this.gnG != null) {
                        if (i == 0) {
                            AnonymousClass2.this.gnG.onSuccess();
                        } else {
                            AnonymousClass2.this.gnG.onFailure();
                        }
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            this.gnG.onFailure();
        }
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, SwanAppPhoneLoginDialog.a aVar, String str) {
        PassportSDK.getInstance().startSmsViewLogin(new AnonymousClass2(aVar, context), str);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(final Activity activity, String str, final e eVar) {
        fO(activity);
        PassportSDK.getInstance().loadOneKeyLogin(activity, aQ(activity, str), new OneKeyLoginCallback() { // from class: com.baidu.tieba.aiapps.apps.a.d.3
            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                a.bQj().h(new com.baidu.swan.apps.a.a() { // from class: com.baidu.tieba.aiapps.apps.a.d.3.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        if (i == 0) {
                            eVar.onResult(0);
                        } else {
                            eVar.onResult(-1);
                        }
                        d.this.fP(activity);
                    }
                });
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                eVar.onResult(-1);
                d.this.fP(activity);
            }

            @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
            public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
                eVar.onResult(-1);
                d.this.fP(activity);
            }
        });
    }

    private void fO(Context context) {
        this.gnD = new com.baidu.swan.apps.res.widget.dialog.c(context, 16973833);
        Window window = this.gnD.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
            attributes.width = -1;
            window.setAttributes(attributes);
        }
        this.gnD.setCanceledOnTouchOutside(false);
        this.gnD.setCancelable(false);
        this.gnD.gP(true);
        this.gnD.setContentView(R.layout.loading_layout);
        View findViewById = this.gnD.findViewById(R.id.root_container);
        ProgressBar progressBar = (ProgressBar) this.gnD.findViewById(R.id.loading_bar);
        TextView textView = (TextView) this.gnD.findViewById(R.id.message);
        if (findViewById != null) {
            findViewById.setBackground(findViewById.getResources().getDrawable(R.drawable.novel_loading_bg));
        }
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(progressBar.getResources().getDrawable(R.drawable.loading_progress_animation));
        }
        if (textView != null) {
            textView.setTextColor(textView.getResources().getColor(R.color.loading_text_color));
            textView.setText(R.string.account_onekey_loading);
        }
        this.gnD.show();
    }

    public void fP(Context context) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && this.gnD != null) {
            this.gnD.dismiss();
        }
    }

    private static String aQ(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        return str.substring(0, 8) + com.baidu.swan.c.e.toMd5((str.substring(8, str.length()) + com.baidu.swan.c.e.toMd5(SapiUtils.getClientId(context).toUpperCase().getBytes(), false)).getBytes(), false);
    }

    private static String generateUID(Context context) {
        return CommonParam.getCUID(context);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Activity activity, String str, String str2, final ab abVar) {
        FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
        faceIDVerifyDTO.businessSence = str;
        faceIDVerifyDTO.bduss = str2;
        PassportSDK.getInstance().verifyUserFaceId(activity, new VerifyUserFaceIDCallback() { // from class: com.baidu.tieba.aiapps.apps.a.d.4
            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onSuccess(SapiResult sapiResult) {
                z zVar = new z();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    zVar.callbackkey = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    abVar.a(zVar);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    zVar.callbackkey = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    abVar.a(zVar);
                }
            }

            @Override // com.baidu.sapi2.callback.FaceIDCallback
            public void onFailure(SapiResult sapiResult) {
                abVar.onFailure(sapiResult.getResultMsg());
            }
        }, faceIDVerifyDTO);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void b(Activity activity, String str, String str2, final ab abVar) {
        RealNameDTO realNameDTO = new RealNameDTO();
        realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        realNameDTO.scene = str;
        realNameDTO.needCbKey = true;
        PassportSDK.getInstance().loadAccountRealName(activity, new AccountRealNameCallback() { // from class: com.baidu.tieba.aiapps.apps.a.d.5
            @Override // com.baidu.sapi2.callback.AccountRealNameCallback
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    z zVar = new z();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        zVar.callbackkey = accountRealNameResult.callbackkey;
                        zVar.seniorRealNameSuc = true;
                        abVar.a(zVar);
                        return;
                    }
                }
                abVar.onFailure(accountRealNameResult.getResultMsg());
            }
        }, realNameDTO);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, a.InterfaceC0505a interfaceC0505a) {
        a.bQj().a(context, "1", interfaceC0505a);
    }

    @Override // com.baidu.swan.bdprivate.a.a.a
    public void a(Context context, a.InterfaceC0507a interfaceC0507a) {
        a.bQj().a(context, "1", interfaceC0507a);
    }
}
