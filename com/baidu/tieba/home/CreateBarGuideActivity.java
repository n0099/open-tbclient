package com.baidu.tieba.home;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.home.BfbInfoModel;
import tbclient.UserBfbInfo;
/* loaded from: classes18.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    private String forumName;
    private a iFt;
    private BfbInfoModel iFu;
    private BfbInfoModel.a iFv = new BfbInfoModel.a() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.1
        @Override // com.baidu.tieba.home.BfbInfoModel.a
        public void a(int i, String str, UserBfbInfo userBfbInfo) {
            CreateBarGuideActivity.this.hideLoadingView(CreateBarGuideActivity.this.iFt.getRootView());
            CreateBarGuideActivity.this.iFt.cvV();
            if (i == 0) {
                CreateBarGuideActivity.this.iFt.a(CreateBarGuideActivity.this.forumName, userBfbInfo);
                return;
            }
            CreateBarGuideActivity.this.showToast(str);
            if (i == 260211) {
                CreateBarGuideActivity.this.Jy(null);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.forumName = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        if (!TextUtils.isEmpty(this.forumName) && this.forumName.length() > 30) {
            this.forumName = this.forumName.substring(0, 30);
        }
        this.iFu = new BfbInfoModel(this);
        this.iFu.a(this.iFv);
        this.iFt = new a(this);
        this.iFt.cvU();
        showLoadingView(this.iFt.getRootView());
        this.iFu.LoadData();
        TiebaStatic.log("c11222");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy(String str) {
        if (StringUtils.isNull(str)) {
            str = getResources().getString(R.string.tips_version_low);
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.zy(str);
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                CreateBarGuideActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AboutActivityConfig(CreateBarGuideActivity.this.getPageContext().getPageActivity())));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(getPageContext());
        aVar.bhg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iFt = null;
        this.iFu.cvQ();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.iFt != null) {
            this.iFt.bpH();
        }
    }
}
