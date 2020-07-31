package com.baidu.tieba.forumMember.tbtitle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.d;
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
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes17.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    private LikeModel emT;
    private a hCG;
    private com.baidu.tieba.forumMember.tbtitle.model.a<TbTitleActivity> hCH;
    private String mForumId;
    private String mForumName;
    private a.InterfaceC0626a hCI = new a.InterfaceC0626a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.1
        @Override // com.baidu.tieba.forumMember.tbtitle.model.a.InterfaceC0626a
        public void a(DataRes dataRes, boolean z, int i, String str) {
            if (z) {
                if (i != 0 || dataRes == null) {
                    TbTitleActivity.this.hCH.uw(b.toInt(TbTitleActivity.this.mForumId, 0));
                    return;
                }
                TbTitleActivity.this.hCG.bZZ();
                TbTitleActivity.this.hCG.bZY();
                TbTitleActivity.this.hCG.a(dataRes);
                TbTitleActivity.this.hCG.cy(dataRes.level_info);
            } else if (i != 0 || dataRes == null) {
                TbTitleActivity.this.hCG.bZZ();
                TbTitleActivity.this.hCG.FK(str);
            } else {
                TbTitleActivity.this.hCG.bZZ();
                TbTitleActivity.this.hCG.bZY();
                TbTitleActivity.this.hCG.a(dataRes);
                TbTitleActivity.this.hCG.cy(dataRes.level_info);
            }
        }
    };
    private View.OnClickListener hCJ = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tbtile_like_btn && TbTitleActivity.this.checkUpIsLogin()) {
                if (j.isNetWorkAvailable()) {
                    TbTitleActivity.this.emT.fz(TbTitleActivity.this.mForumName, TbTitleActivity.this.mForumId);
                } else {
                    TbTitleActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private NoNetworkView.a hCK = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                TbTitleActivity.this.hCG.showLoadingView();
                TbTitleActivity.this.hCH.uv(b.toInt(TbTitleActivity.this.mForumId, 0));
            }
            TbTitleActivity.this.hCG.nu(z);
        }
    };
    private d emY = new d() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.5
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj != null && (obj instanceof u)) {
                e.dki().aS(TbTitleActivity.this.mForumName, false);
                z = true;
            }
            if (!z) {
                if (TbTitleActivity.this.emT.getErrorCode() != 22) {
                    if (AntiHelper.bB(TbTitleActivity.this.emT.getErrorCode(), TbTitleActivity.this.emT.getErrorString())) {
                        AntiHelper.aW(TbTitleActivity.this.getPageContext().getPageActivity(), TbTitleActivity.this.emT.getErrorString());
                        return;
                    } else {
                        TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.emT.getErrorString());
                        return;
                    }
                }
                TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.had_liked_forum));
                return;
            }
            TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.attention_success));
            TbadkCoreApplication.getInst().addLikeForum(TbTitleActivity.this.mForumName);
            TbTitleActivity.this.p(true, TbTitleActivity.this.mForumId);
            u uVar = (u) obj;
            if (uVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
            }
            if (TbTitleActivity.this.hCG.hCU != null) {
                TbTitleActivity.this.hCG.hCU.setVisibility(8);
            }
            uVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
        }
    };

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_LEVEL_INFO, 1001710, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_GET_LEVEL_INFO, GetLevelInfoSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_GET_LEVEL_INFO_CACHE, com.baidu.tieba.forumMember.tbtitle.model.cache.b.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hCG = new com.baidu.tieba.forumMember.tbtitle.a.a(this, this.hCJ);
        this.hCG.g(this.hCK);
        bxF();
        this.hCH = new com.baidu.tieba.forumMember.tbtitle.model.a<>(this.hCI, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
            this.mForumName = intent.getStringExtra(TbTitleActivityConfig.FORUM_NAME);
        }
        if (TextUtils.isEmpty(this.mForumId) || TextUtils.isEmpty(this.mForumName)) {
            this.hCG.FK("");
            return;
        }
        registerTask();
        this.hCG.showLoadingView();
        this.hCH.uv(b.toInt(this.mForumId, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cxs().A(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void bxF() {
        this.emT = new LikeModel(getPageContext());
        this.emT.setLoadDataCallBack(this.emY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hCG.onSkinTypeChanged(i);
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
            this.hCG.showLoadingView();
            this.hCH.uv(b.toInt(this.mForumId, 0));
        }
    }
}
