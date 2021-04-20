package com.baidu.tieba.home;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.home.BfbInfoModel;
import d.b.h0.r.s.a;
import tbclient.UserBfbInfo;
/* loaded from: classes4.dex */
public class CreateBarGuideActivity extends BaseActivity<CreateBarGuideActivity> {
    public static final int LOW_VERSION_ERRCODE = 260211;
    public static final int MAX_LENGTH = 30;
    public String forumName;
    public BfbInfoModel.b mCallback = new a();
    public BfbInfoModel mModel;
    public d.b.i0.y0.a mView;

    /* loaded from: classes4.dex */
    public class a implements BfbInfoModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.home.BfbInfoModel.b
        public void a(int i, String str, UserBfbInfo userBfbInfo) {
            CreateBarGuideActivity createBarGuideActivity = CreateBarGuideActivity.this;
            createBarGuideActivity.hideLoadingView(createBarGuideActivity.mView.d());
            CreateBarGuideActivity.this.mView.g();
            if (i == 0) {
                CreateBarGuideActivity.this.mView.h(CreateBarGuideActivity.this.forumName, userBfbInfo);
                return;
            }
            CreateBarGuideActivity.this.showToast(str);
            if (i == 260211) {
                CreateBarGuideActivity.this.showUpdateDialog(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f16631e;

        public b(d.b.h0.r.s.a aVar) {
            this.f16631e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f16631e.dismiss();
            CreateBarGuideActivity.this.sendMessage(new CustomMessage(2002001, new AboutActivityConfig(CreateBarGuideActivity.this.getPageContext().getPageActivity())));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f16633e;

        public c(d.b.h0.r.s.a aVar) {
            this.f16633e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f16633e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateDialog(String str) {
        if (StringUtils.isNull(str)) {
            str = getResources().getString(R.string.tips_version_low);
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getActivity());
        aVar.setTitle(str);
        aVar.setPositiveButton(R.string.confirm, new b(aVar));
        aVar.setNegativeButton(R.string.cancel, new c(aVar));
        aVar.create(getPageContext());
        aVar.show();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        d.b.i0.y0.a aVar = this.mView;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(CreateBarGuideActivityConfig.EXTRA_KEY_FORUM_NAME);
        this.forumName = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && this.forumName.length() > 30) {
            this.forumName = this.forumName.substring(0, 30);
        }
        BfbInfoModel bfbInfoModel = new BfbInfoModel(this);
        this.mModel = bfbInfoModel;
        bfbInfoModel.w(this.mCallback);
        d.b.i0.y0.a aVar = new d.b.i0.y0.a(this);
        this.mView = aVar;
        aVar.e();
        showLoadingView(this.mView.d());
        this.mModel.LoadData();
        TiebaStatic.log("c11222");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mView = null;
        this.mModel.s();
    }
}
