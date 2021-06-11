package com.baidu.tieba.enterForum.recommend.view;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import d.a.n0.d0.e;
import d.a.n0.j0.k.c.f;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f14581e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f14582f;

    /* renamed from: g  reason: collision with root package name */
    public ForumTestView f14583g;

    /* renamed from: h  reason: collision with root package name */
    public e f14584h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f14585i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921386) {
                return;
            }
            RecommendForumHeaderView.this.d();
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
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921385) {
                return;
            }
            if (RecommendForumHeaderView.this.f14583g == null || RecommendForumHeaderView.this.f14583g.getVisibility() == 8) {
                RecommendForumHeaderView.this.f14585i = false;
            } else {
                RecommendForumHeaderView.this.h();
            }
        }
    }

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f14581e = 3;
        this.f14585i = true;
        this.j = new a(2921386);
        this.k = new b(2921385);
        this.f14582f = tbPageContext;
        e();
    }

    public void d() {
        e eVar = this.f14584h;
        if (eVar != null) {
            eVar.I();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.recom_forum_header_layout, (ViewGroup) this, true);
        ForumTestView forumTestView = (ForumTestView) findViewById(R.id.recommend_forum_header_test_view);
        this.f14583g = forumTestView;
        forumTestView.setOnClickListener(this);
        f();
    }

    public void f() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f14581e) {
            return;
        }
        this.f14581e = skinType;
        ForumTestView forumTestView = this.f14583g;
        if (forumTestView != null) {
            forumTestView.N();
        }
    }

    public final void h() {
        if (this.f14584h == null) {
            e eVar = new e(this.f14582f, this.f14583g);
            this.f14584h = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up);
            this.f14584h.O(32);
            this.f14584h.h0(true);
            this.f14584h.N(3000);
            this.f14584h.k0(0);
            this.f14584h.M(this);
            this.f14584h.m0(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f14583g || this.f14584h == null) {
            return;
        }
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.k);
        super.onDetachedFromWindow();
    }

    public void setData(List<f> list) {
        if (ListUtils.isEmpty(list)) {
            this.f14583g.setVisibility(8);
            return;
        }
        this.f14583g.setVisibility(0);
        this.f14583g.setData(list);
        if (this.f14585i) {
            return;
        }
        h();
        this.f14585i = true;
    }

    public void setOnSecectedListener(ForumTestView.c cVar) {
        ForumTestView forumTestView = this.f14583g;
        if (forumTestView != null) {
            forumTestView.setOnSecectedListener(cVar);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        ForumTestView forumTestView = this.f14583g;
        if (forumTestView != null) {
            forumTestView.setPageId(bdUniqueId);
        }
        this.k.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k);
        this.j.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
    }
}
