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
import d.b.j0.b0.e;
import d.b.j0.i0.k.c.f;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f15176e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15177f;

    /* renamed from: g  reason: collision with root package name */
    public ForumTestView f15178g;

    /* renamed from: h  reason: collision with root package name */
    public e f15179h;
    public boolean i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921385) {
                return;
            }
            if (RecommendForumHeaderView.this.f15178g == null || RecommendForumHeaderView.this.f15178g.getVisibility() == 8) {
                RecommendForumHeaderView.this.i = false;
            } else {
                RecommendForumHeaderView.this.h();
            }
        }
    }

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f15176e = 3;
        this.i = true;
        this.j = new a(2921386);
        this.k = new b(2921385);
        this.f15177f = tbPageContext;
        e();
    }

    public void d() {
        e eVar = this.f15179h;
        if (eVar != null) {
            eVar.H();
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
        this.f15178g = forumTestView;
        forumTestView.setOnClickListener(this);
        f();
    }

    public void f() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15176e) {
            return;
        }
        this.f15176e = skinType;
        ForumTestView forumTestView = this.f15178g;
        if (forumTestView != null) {
            forumTestView.N();
        }
    }

    public final void h() {
        if (this.f15179h == null) {
            e eVar = new e(this.f15177f, this.f15178g);
            this.f15179h = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up);
            this.f15179h.N(32);
            this.f15179h.d0(true);
            this.f15179h.M(3000);
            this.f15179h.g0(0);
            this.f15179h.L(this);
            this.f15179h.i0(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f15178g || this.f15179h == null) {
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
            this.f15178g.setVisibility(8);
            return;
        }
        this.f15178g.setVisibility(0);
        this.f15178g.setData(list);
        if (this.i) {
            return;
        }
        h();
        this.i = true;
    }

    public void setOnSecectedListener(ForumTestView.c cVar) {
        ForumTestView forumTestView = this.f15178g;
        if (forumTestView != null) {
            forumTestView.setOnSecectedListener(cVar);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        ForumTestView forumTestView = this.f15178g;
        if (forumTestView != null) {
            forumTestView.setPageId(bdUniqueId);
        }
        this.k.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k);
        this.j.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
    }
}
