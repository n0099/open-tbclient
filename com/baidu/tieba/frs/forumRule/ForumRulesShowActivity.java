package com.baidu.tieba.frs.forumRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.view.BdTopToast;
import d.a.j0.b1.m.f;
import d.a.k0.q0.q1.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public String mFrom;
    public ForumRulesShowModel mModel;
    public c mView;
    public d.a.k0.q0.q1.b.a callback = new a();
    public CustomMessageListener richTextIntentClickListener = new b(2001332);

    /* loaded from: classes4.dex */
    public class a implements d.a.k0.q0.q1.b.a {
        public a() {
        }

        @Override // d.a.k0.q0.q1.b.a
        public void b() {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.m();
                ForumRulesShowActivity.this.mView.x();
                ForumRulesShowActivity forumRulesShowActivity = ForumRulesShowActivity.this;
                forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.mView.k(), "");
            }
        }

        @Override // d.a.k0.q0.q1.b.a
        public void c(d.a.k0.q0.q1.c.a aVar) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.f(aVar);
            }
        }

        @Override // d.a.k0.q0.q1.b.a
        public void d(List<d.a.k0.q0.q1.c.c> list) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.g(list);
            }
        }

        @Override // d.a.k0.q0.q1.b.a
        public void e(boolean z, String str) {
            if (ForumRulesShowActivity.this.mView == null) {
                return;
            }
            if (z) {
                ForumRulesShowActivity.this.mView.z(str);
            } else {
                ForumRulesShowActivity.this.mView.p();
            }
        }

        @Override // d.a.k0.q0.q1.b.a
        public void f(d.a.k0.q0.q1.c.b bVar) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.e(bVar);
            }
        }

        @Override // d.a.k0.q0.q1.b.a
        public void finish() {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity forumRulesShowActivity = ForumRulesShowActivity.this;
                forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.mView.k());
                ForumRulesShowActivity.this.mView.n();
                ForumRulesShowActivity.this.mView.w();
                ForumRulesShowActivity.this.mView.t();
            }
        }

        @Override // d.a.k0.q0.q1.b.a
        public void g(String str) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.h(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            f.b(ForumRulesShowActivity.this.getPageContext(), aVar.f49104a, aVar.f49105b, aVar.f49106c);
        }
    }

    private void initData(Bundle bundle) {
        this.mModel = new ForumRulesShowModel(this);
        setModelCallback();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        c cVar = new c(this, this.mFrom);
        this.mView = cVar;
        cVar.u(getRefreshView());
    }

    private void setModelCallback() {
        this.mModel.E(this.callback);
    }

    public d.a.c.e.k.b<GifView> getGifViewPool() {
        return null;
    }

    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        return null;
    }

    public ListView getListView() {
        return null;
    }

    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        return null;
    }

    public int getRichTextViewId() {
        return 0;
    }

    public d.a.c.e.k.b<TextView> getTextViewPool() {
        return null;
    }

    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        return null;
    }

    public c getView() {
        return this.mView;
    }

    public d.a.c.e.k.b<View> getVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.mView.s();
                this.mView.r.clear();
                this.mModel.D();
            }
            BdTopToast bdTopToast = new BdTopToast(this, 3000);
            bdTopToast.i(true);
            bdTopToast.h(stringExtra);
            bdTopToast.j(this.mView.l());
        }
    }

    public void onAtClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        c cVar = this.mView;
        if (cVar != null) {
            cVar.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initView();
        this.mModel.y(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ForumRulesShowModel forumRulesShowModel = this.mModel;
        if (forumRulesShowModel != null) {
            forumRulesShowModel.destory();
        }
        c cVar = this.mView;
        if (cVar != null) {
            cVar.j();
        }
    }

    public void onLinkButtonClicked(Context context, String str) {
    }

    public void onLinkClicked(Context context, String str, boolean z) {
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.richTextIntentClickListener);
    }

    public void onSongClicked(Context context, String str) {
    }

    public void onVideoClicked(Context context, String str) {
    }

    public void onVideoP2PClicked(Context context, String str) {
    }

    public void requestNet() {
        ForumRulesShowModel forumRulesShowModel = this.mModel;
        if (forumRulesShowModel != null) {
            forumRulesShowModel.D();
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        c cVar = this.mView;
        if (cVar != null) {
            cVar.setFrom(str);
        }
    }
}
