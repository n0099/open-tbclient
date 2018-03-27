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
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes3.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    private LikeModel ccX;
    private a dCr;
    private com.baidu.tieba.forumMember.tbtitle.model.a<TbTitleActivity> dCs;
    private a.InterfaceC0148a dCt = new a.InterfaceC0148a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.1
        @Override // com.baidu.tieba.forumMember.tbtitle.model.a.InterfaceC0148a
        public void a(DataRes dataRes, boolean z, int i, String str) {
            if (z) {
                if (i != 0 || dataRes == null) {
                    TbTitleActivity.this.dCs.mK(b.h(TbTitleActivity.this.mForumId, 0));
                    return;
                }
                TbTitleActivity.this.dCr.aug();
                TbTitleActivity.this.dCr.auf();
                TbTitleActivity.this.dCr.a(dataRes);
                TbTitleActivity.this.dCr.bj(dataRes.level_info);
            } else if (i != 0 || dataRes == null) {
                TbTitleActivity.this.dCr.aug();
                TbTitleActivity.this.dCr.lC(str);
            } else {
                TbTitleActivity.this.dCr.aug();
                TbTitleActivity.this.dCr.auf();
                TbTitleActivity.this.dCr.a(dataRes);
                TbTitleActivity.this.dCr.bj(dataRes.level_info);
            }
        }
    };
    private View.OnClickListener dCu = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.tbtile_like_btn && TbTitleActivity.this.checkUpIsLogin()) {
                if (j.oJ()) {
                    TbTitleActivity.this.ccX.cc(TbTitleActivity.this.mForumName, TbTitleActivity.this.mForumId);
                } else {
                    TbTitleActivity.this.showToast(d.j.neterror);
                }
            }
        }
    };
    private NoNetworkView.a dCv = new NoNetworkView.a() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                TbTitleActivity.this.dCr.VU();
                TbTitleActivity.this.dCs.mJ(b.h(TbTitleActivity.this.mForumId, 0));
            }
            TbTitleActivity.this.dCr.fH(z);
        }
    };
    private com.baidu.adp.base.d dCw = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.5
        @Override // com.baidu.adp.base.d
        public void ak(Object obj) {
            boolean z = false;
            if (obj != null && (obj instanceof s)) {
                c.buI().Y(TbTitleActivity.this.mForumName, false);
                z = true;
            }
            if (!z) {
                if (TbTitleActivity.this.ccX.getErrorCode() != 22) {
                    if (AntiHelper.vR(TbTitleActivity.this.ccX.getErrorCode())) {
                        AntiHelper.ar(TbTitleActivity.this.getPageContext().getPageActivity(), TbTitleActivity.this.ccX.getErrorString());
                        return;
                    } else {
                        TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.ccX.getErrorString());
                        return;
                    }
                }
                TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(d.j.had_liked_forum));
                return;
            }
            TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(d.j.attention_success));
            TbadkCoreApplication.getInst().addLikeForum(TbTitleActivity.this.mForumName);
            TbTitleActivity.this.f(true, TbTitleActivity.this.mForumId);
            s sVar = (s) obj;
            if (sVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
            }
            if (TbTitleActivity.this.dCr.dCH != null) {
                TbTitleActivity.this.dCr.dCH.setVisibility(8);
            }
            sVar.setLike(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, sVar));
        }
    };
    private String mForumId;
    private String mForumName;

    private void HQ() {
        com.baidu.tieba.tbadkCore.a.a.a(301005, CmdConfigHttp.CMD_GET_LEVLE_INFO, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
        com.baidu.tieba.tbadkCore.a.a.c(301005, GetLevelInfoSocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.b(2003007, com.baidu.tieba.forumMember.tbtitle.model.cache.b.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dCr = new com.baidu.tieba.forumMember.tbtitle.a.a(this, this.dCu);
        this.dCr.h(this.dCv);
        Xy();
        this.dCs = new com.baidu.tieba.forumMember.tbtitle.model.a<>(this.dCt, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
            this.mForumName = intent.getStringExtra(TbTitleActivityConfig.FORUM_NAME);
        }
        if (TextUtils.isEmpty(this.mForumId) || TextUtils.isEmpty(this.mForumName)) {
            this.dCr.lC("");
            return;
        }
        HQ();
        this.dCr.VU();
        this.dCs.mJ(b.h(this.mForumId, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z, final String str) {
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aLW().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), z);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Xy() {
        this.ccX = new LikeModel(getPageContext());
        this.ccX.setLoadDataCallBack(this.dCw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dCr.gi(i);
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
        if (j.oJ()) {
            this.dCr.VU();
            this.dCs.mJ(b.h(this.mForumId, 0));
        }
    }
}
