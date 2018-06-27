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
import com.baidu.tieba.d;
import com.baidu.tieba.home.BfbInfoModel;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    private a dPo;
    private BfbInfoModel dPp;
    private BfbInfoModel.a dPq = new BfbInfoModel.a() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.1
        @Override // com.baidu.tieba.home.BfbInfoModel.a
        public void a(int i, String str, UserBfbInfo userBfbInfo) {
            CreateBarGuideActivity.this.hideLoadingView(CreateBarGuideActivity.this.dPo.getRootView());
            CreateBarGuideActivity.this.dPo.aCt();
            if (i == 0) {
                CreateBarGuideActivity.this.dPo.a(CreateBarGuideActivity.this.forumName, userBfbInfo);
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
        this.dPp = new BfbInfoModel(this);
        this.dPp.a(this.dPq);
        this.dPo = new a(this);
        this.dPo.aCs();
        showLoadingView(this.dPo.getRootView());
        this.dPp.LoadData();
        TiebaStatic.log("c11222");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ns(String str) {
        if (StringUtils.isNull(str)) {
            str = getResources().getString(d.k.tips_version_low);
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.dD(str);
        aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                CreateBarGuideActivity.this.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(CreateBarGuideActivity.this.getPageContext().getPageActivity())));
            }
        });
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.home.CreateBarGuideActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(getPageContext());
        aVar.xn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dPo = null;
        this.dPp.aCo();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.dPo != null) {
            this.dPo.FK();
        }
    }
}
