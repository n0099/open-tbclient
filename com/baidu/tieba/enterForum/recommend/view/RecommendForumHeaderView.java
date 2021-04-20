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
import d.b.i0.b0.e;
import d.b.i0.i0.k.c.f;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendForumHeaderView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f15168e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f15169f;

    /* renamed from: g  reason: collision with root package name */
    public ForumTestView f15170g;

    /* renamed from: h  reason: collision with root package name */
    public e f15171h;
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
            if (RecommendForumHeaderView.this.f15170g == null || RecommendForumHeaderView.this.f15170g.getVisibility() == 8) {
                RecommendForumHeaderView.this.i = false;
            } else {
                RecommendForumHeaderView.this.h();
            }
        }
    }

    public RecommendForumHeaderView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f15168e = 3;
        this.i = true;
        this.j = new a(2921386);
        this.k = new b(2921385);
        this.f15169f = tbPageContext;
        e();
    }

    public void d() {
        e eVar = this.f15171h;
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
        this.f15170g = forumTestView;
        forumTestView.setOnClickListener(this);
        f();
    }

    public void f() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15168e) {
            return;
        }
        this.f15168e = skinType;
        ForumTestView forumTestView = this.f15170g;
        if (forumTestView != null) {
            forumTestView.N();
        }
    }

    public final void h() {
        if (this.f15171h == null) {
            e eVar = new e(this.f15169f, this.f15170g);
            this.f15171h = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up);
            this.f15171h.N(32);
            this.f15171h.d0(true);
            this.f15171h.M(3000);
            this.f15171h.g0(0);
            this.f15171h.L(this);
            this.f15171h.i0(getContext().getString(R.string.recommend_tab_click_to_test), "key_recommend_tab_click_to_test_tip");
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f15170g || this.f15171h == null) {
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
            this.f15170g.setVisibility(8);
            return;
        }
        this.f15170g.setVisibility(0);
        this.f15170g.setData(list);
        if (this.i) {
            return;
        }
        h();
        this.i = true;
    }

    public void setOnSecectedListener(ForumTestView.c cVar) {
        ForumTestView forumTestView = this.f15170g;
        if (forumTestView != null) {
            forumTestView.setOnSecectedListener(cVar);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        ForumTestView forumTestView = this.f15170g;
        if (forumTestView != null) {
            forumTestView.setPageId(bdUniqueId);
        }
        this.k.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k);
        this.j.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
    }
}
