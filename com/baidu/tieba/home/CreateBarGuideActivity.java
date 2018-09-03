package com.baidu.tieba.home;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.f;
import com.baidu.tieba.home.BfbInfoModel;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    private a dRW;
    private BfbInfoModel dRX;
    private BfbInfoModel.a dRY = new BfbInfoModel.a() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.1
        @Override // com.baidu.tieba.home.BfbInfoModel.a
        public void a(int i, String str, UserBfbInfo userBfbInfo) {
            CreateBarGuideActivity.this.hideLoadingView(CreateBarGuideActivity.this.dRW.getRootView());
            CreateBarGuideActivity.this.dRW.aCZ();
            if (i == 0) {
                CreateBarGuideActivity.this.dRW.a(CreateBarGuideActivity.this.forumName, userBfbInfo);
                return;
            }
            CreateBarGuideActivity.this.showToast(str);
            if (i == 260211) {
                CreateBarGuideActivity.this.ns(null);
            }
        }
    };
    private String forumName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.forumName = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        if (!TextUtils.isEmpty(this.forumName) && this.forumName.length() > 30) {
            this.forumName = this.forumName.substring(0, 30);
        }
        this.dRX = new BfbInfoModel(this);
        this.dRX.a(this.dRY);
        this.dRW = new a(this);
        this.dRW.aCY();
        showLoadingView(this.dRW.getRootView());
        this.dRX.LoadData();
        TiebaStatic.log("c11222");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(String str) {
        if (StringUtils.isNull(str)) {
            str = getResources().getString(f.j.tips_version_low);
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.dA(str);
        aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                CreateBarGuideActivity.this.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(CreateBarGuideActivity.this.getPageContext().getPageActivity())));
            }
        });
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(getPageContext());
        aVar.xe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dRW = null;
        this.dRX.aCU();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.dRW != null) {
            this.dRW.FG();
        }
    }
}
