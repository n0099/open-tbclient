package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.google.android.material.appbar.AppBarLayout;
@CoordinatorLayout.DefaultBehavior(StickyAppBarLayoutBehavior.class)
/* loaded from: classes4.dex */
public class StickyAppBarLayout extends AppBarLayout {

    /* renamed from: e  reason: collision with root package name */
    public StickyAppBarLayoutBehavior f17081e;

    /* renamed from: f  reason: collision with root package name */
    public b f17082f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f17083g;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                StickyAppBarLayout.this.f();
            } else if (StickyAppBarLayout.this.d()) {
            } else {
                StickyAppBarLayout.this.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z);
    }

    public StickyAppBarLayout(Context context) {
        super(context);
        this.f17083g = new a(2921441);
    }

    public final boolean b() {
        if (this.f17081e == null) {
            c();
        }
        StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior = this.f17081e;
        if (stickyAppBarLayoutBehavior != null) {
            stickyAppBarLayoutBehavior.i();
            return true;
        }
        return false;
    }

    public final void c() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) getLayoutParams()).getBehavior();
            if (behavior instanceof StickyAppBarLayoutBehavior) {
                this.f17081e = (StickyAppBarLayoutBehavior) behavior;
            }
        }
    }

    public boolean d() {
        if (this.f17081e == null) {
            c();
        }
        StickyAppBarLayoutBehavior stickyAppBarLayoutBehavior = this.f17081e;
        if (stickyAppBarLayoutBehavior != null) {
            return stickyAppBarLayoutBehavior.isSticky();
        }
        return false;
    }

    public final void e() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public boolean f() {
        if (this.f17081e == null) {
            c();
        }
        if (this.f17081e != null) {
            if (d() && this.f17081e.h() != null && this.f17081e.h().getVisibility() == 0) {
                e();
            }
            this.f17081e.l();
            return true;
        }
        return false;
    }

    public b getOnHeaderStickyListener() {
        return this.f17082f;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.f17083g);
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.f17083g);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public void setOnHeaderStickyListener(b bVar) {
        this.f17082f = bVar;
    }

    public StickyAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17083g = new a(2921441);
    }
}
