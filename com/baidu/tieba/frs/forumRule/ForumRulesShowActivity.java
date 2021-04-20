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
import d.b.h0.b1.m.f;
import d.b.i0.q0.q1.f.c;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public String mFrom;
    public ForumRulesShowModel mModel;
    public c mView;
    public d.b.i0.q0.q1.b.a callback = new a();
    public CustomMessageListener richTextIntentClickListener = new b(2001332);

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.q0.q1.b.a {
        public a() {
        }

        @Override // d.b.i0.q0.q1.b.a
        public void a() {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.m();
                ForumRulesShowActivity.this.mView.z();
                ForumRulesShowActivity forumRulesShowActivity = ForumRulesShowActivity.this;
                forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.mView.k(), "");
            }
        }

        @Override // d.b.i0.q0.q1.b.a
        public void b(boolean z, String str) {
            if (ForumRulesShowActivity.this.mView == null) {
                return;
            }
            if (z) {
                ForumRulesShowActivity.this.mView.B(str);
            } else {
                ForumRulesShowActivity.this.mView.q();
            }
        }

        @Override // d.b.i0.q0.q1.b.a
        public void c(d.b.i0.q0.q1.c.b bVar) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.e(bVar);
            }
        }

        @Override // d.b.i0.q0.q1.b.a
        public void d(d.b.i0.q0.q1.c.a aVar) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.f(aVar);
            }
        }

        @Override // d.b.i0.q0.q1.b.a
        public void e(List<d.b.i0.q0.q1.c.c> list) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.g(list);
            }
        }

        @Override // d.b.i0.q0.q1.b.a
        public void f(String str) {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity.this.mView.h(str);
            }
        }

        @Override // d.b.i0.q0.q1.b.a
        public void finish() {
            if (ForumRulesShowActivity.this.mView != null) {
                ForumRulesShowActivity forumRulesShowActivity = ForumRulesShowActivity.this;
                forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.mView.k());
                ForumRulesShowActivity.this.mView.n();
                ForumRulesShowActivity.this.mView.y();
                ForumRulesShowActivity.this.mView.v();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            f.b(ForumRulesShowActivity.this.getPageContext(), aVar.f50372a, aVar.f50373b, aVar.f50374c);
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
        cVar.w(getRefreshView());
    }

    private void setModelCallback() {
        this.mModel.E(this.callback);
    }

    public d.b.c.e.k.b<GifView> getGifViewPool() {
        return null;
    }

    public d.b.c.e.k.b<ImageView> getImageViewPool() {
        return null;
    }

    public ListView getListView() {
        return null;
    }

    public d.b.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        return null;
    }

    public int getRichTextViewId() {
        return 0;
    }

    public d.b.c.e.k.b<TextView> getTextViewPool() {
        return null;
    }

    public d.b.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        return null;
    }

    public c getView() {
        return this.mView;
    }

    public d.b.c.e.k.b<View> getVoiceViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.mView.u();
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
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        c cVar = this.mView;
        if (cVar != null) {
            cVar.onChangeSkinType(i);
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
            cVar.i();
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
