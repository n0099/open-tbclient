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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes23.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    private LikeModel fgf;
    private a iQd;
    private com.baidu.tieba.forumMember.tbtitle.model.a<TbTitleActivity> iQe;
    private String mForumId;
    private String mForumName;
    private a.InterfaceC0737a iQf = new a.InterfaceC0737a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.1
        @Override // com.baidu.tieba.forumMember.tbtitle.model.a.InterfaceC0737a
        public void a(DataRes dataRes, boolean z, int i, String str) {
            if (z) {
                if (i != 0 || dataRes == null) {
                    TbTitleActivity.this.iQe.zz(b.toInt(TbTitleActivity.this.mForumId, 0));
                    return;
                }
                TbTitleActivity.this.iQd.cAI();
                TbTitleActivity.this.iQd.cAH();
                TbTitleActivity.this.iQd.a(dataRes);
                TbTitleActivity.this.iQd.de(dataRes.level_info);
            } else if (i != 0 || dataRes == null) {
                TbTitleActivity.this.iQd.cAI();
                TbTitleActivity.this.iQd.KD(str);
            } else {
                TbTitleActivity.this.iQd.cAI();
                TbTitleActivity.this.iQd.cAH();
                TbTitleActivity.this.iQd.a(dataRes);
                TbTitleActivity.this.iQd.de(dataRes.level_info);
            }
        }
    };
    private View.OnClickListener iQg = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tbtile_like_btn && TbTitleActivity.this.checkUpIsLogin()) {
                if (j.isNetWorkAvailable()) {
                    TbTitleActivity.this.fgf.gu(TbTitleActivity.this.mForumName, TbTitleActivity.this.mForumId);
                } else {
                    TbTitleActivity.this.showToast(R.string.neterror);
                }
            }
        }
    };
    private NoNetworkView.a iQh = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                TbTitleActivity.this.iQd.showLoadingView();
                TbTitleActivity.this.iQe.zy(b.toInt(TbTitleActivity.this.mForumId, 0));
            }
            TbTitleActivity.this.iQd.pM(z);
        }
    };
    private d fgk = new d() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.5
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj != null && (obj instanceof w)) {
                e.dOg().bd(TbTitleActivity.this.mForumName, false);
                z = true;
            }
            if (!z) {
                if (TbTitleActivity.this.fgf.getErrorCode() != 22) {
                    if (AntiHelper.bP(TbTitleActivity.this.fgf.getErrorCode(), TbTitleActivity.this.fgf.getErrorString())) {
                        AntiHelper.bn(TbTitleActivity.this.getPageContext().getPageActivity(), TbTitleActivity.this.fgf.getErrorString());
                        return;
                    } else {
                        TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.fgf.getErrorString());
                        return;
                    }
                }
                TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.had_liked_forum));
                return;
            }
            TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.attention_success));
            TbadkCoreApplication.getInst().addLikeForum(TbTitleActivity.this.mForumName);
            TbTitleActivity.this.s(true, TbTitleActivity.this.mForumId);
            w wVar = (w) obj;
            if (wVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
            }
            if (TbTitleActivity.this.iQd.iQr != null) {
                TbTitleActivity.this.iQd.iQr.setVisibility(8);
            }
            wVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
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
        this.iQd = new com.baidu.tieba.forumMember.tbtitle.a.a(this, this.iQg);
        this.iQd.g(this.iQh);
        bSO();
        this.iQe = new com.baidu.tieba.forumMember.tbtitle.model.a<>(this.iQf, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
            this.mForumName = intent.getStringExtra(TbTitleActivityConfig.FORUM_NAME);
        }
        if (TextUtils.isEmpty(this.mForumId) || TextUtils.isEmpty(this.mForumName)) {
            this.iQd.KD("");
            return;
        }
        registerTask();
        this.iQd.showLoadingView();
        this.iQe.zy(b.toInt(this.mForumId, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cZZ().B(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void bSO() {
        this.fgf = new LikeModel(getPageContext());
        this.fgf.setLoadDataCallBack(this.fgk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iQd.onSkinTypeChanged(i);
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
            this.iQd.showLoadingView();
            this.iQe.zy(b.toInt(this.mForumId, 0));
        }
    }
}
