package com.baidu.tieba.forumMember.tbtitle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoHttpResponsedMessage;
import com.baidu.tieba.forumMember.tbtitle.model.res.GetLevelInfoSocketResponsedMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.e.p.j;
import d.a.o0.e3.w;
import d.a.o0.p0.d.a.a;
import tbclient.GetLevelInfo.DataRes;
/* loaded from: classes4.dex */
public class TbTitleActivity extends BaseActivity<TbTitleActivity> {
    public String mForumId;
    public String mForumName;
    public d.a.o0.p0.d.a.a<TbTitleActivity> mGetLevelInfoModel;
    public LikeModel mLikeModel;
    public d.a.o0.p0.d.b.a mView;
    public a.c mLevelInfoModelCallback = new a();
    public View.OnClickListener mCommonListener = new b();
    public NoNetworkView.b mNoNetworkChangeListener = new d();
    public d.a.c.a.e mLikeCallback = new e();

    /* loaded from: classes4.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.a.o0.p0.d.a.a.c
        public void a(DataRes dataRes, boolean z, int i2, String str) {
            if (z) {
                if (i2 != 0 || dataRes == null) {
                    TbTitleActivity.this.mGetLevelInfoModel.c(d.a.c.e.m.b.d(TbTitleActivity.this.mForumId, 0));
                    return;
                }
                TbTitleActivity.this.mView.h();
                TbTitleActivity.this.mView.i();
                TbTitleActivity.this.mView.e(dataRes);
                TbTitleActivity.this.mView.f(dataRes.level_info);
            } else if (i2 != 0 || dataRes == null) {
                TbTitleActivity.this.mView.h();
                TbTitleActivity.this.mView.q(str);
            } else {
                TbTitleActivity.this.mView.h();
                TbTitleActivity.this.mView.i();
                TbTitleActivity.this.mView.e(dataRes);
                TbTitleActivity.this.mView.f(dataRes.level_info);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.tbtile_like_btn && TbTitleActivity.this.checkUpIsLogin()) {
                if (j.z()) {
                    TbTitleActivity.this.mLikeModel.L(TbTitleActivity.this.mForumName, TbTitleActivity.this.mForumId);
                } else {
                    TbTitleActivity.this.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f15140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f15141b;

        public c(String str, boolean z) {
            this.f15140a = str;
            this.f15141b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.f15140a)) {
                return null;
            }
            d.a.o0.f1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f15140a), this.f15141b);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NoNetworkView.b {
        public d() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                TbTitleActivity.this.mView.p();
                TbTitleActivity.this.mGetLevelInfoModel.d(d.a.c.e.m.b.d(TbTitleActivity.this.mForumId, 0));
            }
            TbTitleActivity.this.mView.m(z);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.a.e {
        public e() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            boolean z = false;
            if (obj != null && (obj instanceof w)) {
                d.a.o0.e3.e.i().n(TbTitleActivity.this.mForumName, false);
                z = true;
            }
            if (!z) {
                if (TbTitleActivity.this.mLikeModel.getErrorCode() != 22) {
                    if (AntiHelper.m(TbTitleActivity.this.mLikeModel.getErrorCode(), TbTitleActivity.this.mLikeModel.getErrorString())) {
                        AntiHelper.u(TbTitleActivity.this.getPageContext().getPageActivity(), TbTitleActivity.this.mLikeModel.getErrorString());
                        return;
                    } else {
                        TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.mLikeModel.getErrorString());
                        return;
                    }
                }
                TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.had_liked_forum));
                return;
            }
            TbTitleActivity.this.getPageContext().showToast(TbTitleActivity.this.getPageContext().getString(R.string.attention_success));
            TbadkCoreApplication.getInst().addLikeForum(TbTitleActivity.this.mForumName);
            TbTitleActivity tbTitleActivity = TbTitleActivity.this;
            tbTitleActivity.saveAcceptNotify(true, tbTitleActivity.mForumId);
            w wVar = (w) obj;
            if (wVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
            if (TbTitleActivity.this.mView.k != null) {
                TbTitleActivity.this.mView.k.setVisibility(8);
            }
            wVar.v(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    private void initLikeModel() {
        LikeModel likeModel = new LikeModel(getPageContext());
        this.mLikeModel = likeModel;
        likeModel.setLoadDataCallBack(this.mLikeCallback);
    }

    private void registerTask() {
        d.a.o0.e3.d0.a.c(301005, CmdConfigHttp.CMD_GET_LEVLE_INFO, TbConfig.GET_LEVEL_INFO_URL, GetLevelInfoHttpResponsedMessage.class, false, false, true, false);
        d.a.o0.e3.d0.a.f(301005, GetLevelInfoSocketResponsedMessage.class, false);
        d.a.o0.e3.d0.a.b(2003007, d.a.o0.p0.d.a.b.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAcceptNotify(boolean z, String str) {
        new c(str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.l(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.o0.p0.d.b.a aVar = new d.a.o0.p0.d.b.a(this, this.mCommonListener);
        this.mView = aVar;
        aVar.o(this.mNoNetworkChangeListener);
        initLikeModel();
        this.mGetLevelInfoModel = new d.a.o0.p0.d.a.a<>(this.mLevelInfoModelCallback, this);
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumId = intent.getStringExtra(TbTitleActivityConfig.FORUM_ID);
            this.mForumName = intent.getStringExtra("forumName");
        }
        if (!TextUtils.isEmpty(this.mForumId) && !TextUtils.isEmpty(this.mForumName)) {
            registerTask();
            this.mView.p();
            this.mGetLevelInfoModel.d(d.a.c.e.m.b.d(this.mForumId, 0));
            return;
        }
        this.mView.q("");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.z()) {
            this.mView.p();
            this.mGetLevelInfoModel.d(d.a.c.e.m.b.d(this.mForumId, 0));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
