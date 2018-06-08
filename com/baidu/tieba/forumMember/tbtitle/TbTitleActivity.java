package com.baidu.tieba.forumMember.tbtitle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.a.a;
import com.baidu.tieba.forumMember.tbtitle.model.a;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.c;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes3.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    private LikeModel bvr;
    private a dfu;
    private com.baidu.tieba.forumMember.tbtitle.model.a<TbTitleActivity> dfv;
    private a.InterfaceC0149a dfw = new a.InterfaceC0149a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.1
        @Override // com.baidu.tieba.forumMember.tbtitle.model.a.InterfaceC0149a
        public void a(DataRes dataRes, boolean z, int i, String str) {
            if (z) {
                if (i != 0 || dataRes == null) {
                    TbTitleActivity.this.dfv.jY(b.g(TbTitleActivity.this.mForumId, 0));
                    return;
                }
                TbTitleActivity.this.dfu.asz();
                TbTitleActivity.this.dfu.asy();
                TbTitleActivity.this.dfu.a(dataRes);
                TbTitleActivity.this.dfu.bj(dataRes.level_info);
            } else if (i != 0 || dataRes == null) {
                TbTitleActivity.this.dfu.asz();
                TbTitleActivity.this.dfu.mp(str);
            } else {
                TbTitleActivity.this.dfu.asz();
                TbTitleActivity.this.dfu.asy();
                TbTitleActivity.this.dfu.a(dataRes);
                TbTitleActivity.this.dfu.bj(dataRes.level_info);
            }
        }
    };
    private View.OnClickListener dfx = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.tbtile_like_btn && TbTitleActivity.this.checkUpIsLogin()) {
                if (j.jD()) {
                    TbTitleActivity.this.bvr.cj(TbTitleActivity.this.mForumName, TbTitleActivity.this.mForumId);
                } else {
                    TbTitleActivity.this.showToast(d.k.neterror);
                }
            }
        }
    };
    private NoNetworkView.a dfy = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                TbTitleActivity.this.dfu.showLoadingView();
                TbTitleActivity.this.dfv.jX(b.g(TbTitleActivity.this.mForumId, 0));
            }
            TbTitleActivity.this.dfu.fr(z);
        }
    };
    private com.baidu.adp.base.d dfz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.5
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            boolean z = false;
            if (obj != null && (obj instanceof r)) {
                c.buO().T(TbTitleActivity.this.mForumName, false);
                z = true;
            }
            if (!z) {
                if (TbTitleActivity.this.bvr.getErrorCode() != 22) {
                    if (AntiHelper.tE(TbTitleActivity.this.bvr.getErrorCode())) {
                        AntiHelper.ao(TbTitleActivity.this.getPageContext().getPageActivity(), TbTitleActivity.this.bvr.getErrorString());
                        return;
                    } else {
                        TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.bvr.getErrorString());
                        return;
                    }
                }
                TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(d.k.had_liked_forum));
                return;
            }
            TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(d.k.attention_success));
            TbadkCoreApplication.getInst().addLikeForum(TbTitleActivity.this.mForumName);
            TbTitleActivity.this.i(true, TbTitleActivity.this.mForumId);
            r rVar = (r) obj;
            if (rVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
            }
            if (TbTitleActivity.this.dfu.dfK != null) {
                TbTitleActivity.this.dfu.dfK.setVisibility(8);
            }
            rVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
        }
    };
    private String mForumId;
    private String mForumName;

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(301005, CmdConfigHttp.CMD_GET_LEVLE_INFO, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.c(301005, GetLevelInfoSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.b(2003007, com.baidu.tieba.forumMember.tbtitle.model.cache.b.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dfu = new com.baidu.tieba.forumMember.tbtitle.a.a(this, this.dfx);
        this.dfu.h(this.dfy);
        Tt();
        this.dfv = new com.baidu.tieba.forumMember.tbtitle.model.a<>(this.dfw, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
            this.mForumName = intent.getStringExtra(TbTitleActivityConfig.FORUM_NAME);
        }
        if (TextUtils.isEmpty(this.mForumId) || TextUtils.isEmpty(this.mForumName)) {
            this.dfu.mp("");
            return;
        }
        registerTask();
        this.dfu.showLoadingView();
        this.dfv.jX(b.g(this.mForumId, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aLP().i(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Tt() {
        this.bvr = new LikeModel(getPageContext());
        this.bvr.setLoadDataCallBack(this.dfz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dfu.dk(i);
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
        if (j.jD()) {
            this.dfu.showLoadingView();
            this.dfv.jX(b.g(this.mForumId, 0));
        }
    }
}
