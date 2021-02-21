package com.baidu.tieba.forumMember.tbtitle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.a.a;
import com.baidu.tieba.forumMember.tbtitle.model.a;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes8.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    private LikeModel fnw;
    private a jdD;
    private com.baidu.tieba.forumMember.tbtitle.model.a<TbTitleActivity> jdE;
    private String mForumId;
    private String mForumName;
    private a.InterfaceC0721a jdF = new a.InterfaceC0721a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.1
        @Override // com.baidu.tieba.forumMember.tbtitle.model.a.InterfaceC0721a
        public void a(DataRes dataRes, boolean z, int i, String str) {
            if (z) {
                if (i != 0 || dataRes == null) {
                    TbTitleActivity.this.jdE.yq(b.toInt(TbTitleActivity.this.mForumId, 0));
                    return;
                }
                TbTitleActivity.this.jdD.cBc();
                TbTitleActivity.this.jdD.cBb();
                TbTitleActivity.this.jdD.a(dataRes);
                TbTitleActivity.this.jdD.dg(dataRes.level_info);
            } else if (i != 0 || dataRes == null) {
                TbTitleActivity.this.jdD.cBc();
                TbTitleActivity.this.jdD.Kb(str);
            } else {
                TbTitleActivity.this.jdD.cBc();
                TbTitleActivity.this.jdD.cBb();
                TbTitleActivity.this.jdD.a(dataRes);
                TbTitleActivity.this.jdD.dg(dataRes.level_info);
            }
        }
    };
    private View.OnClickListener jdG = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tbtile_like_btn && TbTitleActivity.this.checkUpIsLogin()) {
                if (j.isNetWorkAvailable()) {
                    TbTitleActivity.this.fnw.gy(TbTitleActivity.this.mForumName, TbTitleActivity.this.mForumId);
                } else {
                    TbTitleActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private NoNetworkView.a jdH = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                TbTitleActivity.this.jdD.showLoadingView();
                TbTitleActivity.this.jdE.yp(b.toInt(TbTitleActivity.this.mForumId, 0));
            }
            TbTitleActivity.this.jdD.qp(z);
        }
    };
    private e fnB = new e() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.5
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj != null && (obj instanceof w)) {
                com.baidu.tieba.tbadkCore.e.dMA().bd(TbTitleActivity.this.mForumName, false);
                z = true;
            }
            if (!z) {
                if (TbTitleActivity.this.fnw.getErrorCode() != 22) {
                    if (AntiHelper.bX(TbTitleActivity.this.fnw.getErrorCode(), TbTitleActivity.this.fnw.getErrorString())) {
                        AntiHelper.bq(TbTitleActivity.this.getPageContext().getPageActivity(), TbTitleActivity.this.fnw.getErrorString());
                        return;
                    } else {
                        TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.fnw.getErrorString());
                        return;
                    }
                }
                TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.had_liked_forum));
                return;
            }
            TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.attention_success));
            TbadkCoreApplication.getInst().addLikeForum(TbTitleActivity.this.mForumName);
            TbTitleActivity.this.z(true, TbTitleActivity.this.mForumId);
            w wVar = (w) obj;
            if (wVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
            }
            if (TbTitleActivity.this.jdD.jdR != null) {
                TbTitleActivity.this.jdD.jdR.setVisibility(8);
            }
            wVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
        }
    };

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LEVEL_INFO, 1001710, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_GET_LEVEL_INFO, GetLevelInfoSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.CMD_GET_LEVEL_INFO_CACHE, com.baidu.tieba.forumMember.tbtitle.model.cache.b.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jdD = new com.baidu.tieba.forumMember.tbtitle.a.a(this, this.jdG);
        this.jdD.g(this.jdH);
        bSl();
        this.jdE = new com.baidu.tieba.forumMember.tbtitle.model.a<>(this.jdF, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
            this.mForumName = intent.getStringExtra(TbTitleActivityConfig.FORUM_NAME);
        }
        if (TextUtils.isEmpty(this.mForumId) || TextUtils.isEmpty(this.mForumName)) {
            this.jdD.Kb("");
            return;
        }
        registerTask();
        this.jdD.showLoadingView();
        this.jdE.yp(b.toInt(this.mForumId, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    d.cYa().D(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void bSl() {
        this.fnw = new LikeModel(getPageContext());
        this.fnw.setLoadDataCallBack(this.fnB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jdD.onSkinTypeChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            this.jdD.showLoadingView();
            this.jdE.yp(b.toInt(this.mForumId, 0));
        }
    }
}
