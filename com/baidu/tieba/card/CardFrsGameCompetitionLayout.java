package com.baidu.tieba.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetitionSubNode;
import d.b.c.e.k.b;
import java.util.List;
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b<CardFrsGameCompetitionItemView> f14896e;

    /* renamed from: f  reason: collision with root package name */
    public int f14897f;

    /* renamed from: g  reason: collision with root package name */
    public int f14898g;

    /* renamed from: h  reason: collision with root package name */
    public int f14899h;
    public final ViewGroup.OnHierarchyChangeListener i;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof CardFrsGameCompetitionItemView) || CardFrsGameCompetitionLayout.this.f14896e == null) {
                return;
            }
            CardFrsGameCompetitionLayout.this.f14896e.e((CardFrsGameCompetitionItemView) view2);
        }
    }

    public CardFrsGameCompetitionLayout(Context context) {
        super(context);
        this.f14896e = null;
        this.i = new a();
        b();
    }

    public final void b() {
        setOrientation(0);
        setGravity(17);
    }

    public final void c(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameCompetitionItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f14897f;
        }
        cardFrsGameCompetitionItemView.setLayoutParams(layoutParams);
    }

    public final void d(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView, FeatureCardCompetitionSubNode featureCardCompetitionSubNode) {
        if (featureCardCompetitionSubNode == null) {
            return;
        }
        cardFrsGameCompetitionItemView.b(featureCardCompetitionSubNode);
        cardFrsGameCompetitionItemView.setTag(featureCardCompetitionSubNode.url);
        cardFrsGameCompetitionItemView.d(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        return this.f14899h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setData(List<FeatureCardCompetitionSubNode> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f14899h = this.f14898g + this.f14897f;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount && i < list.size()) {
            if (getChildAt(i) instanceof CardFrsGameCompetitionItemView) {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = (CardFrsGameCompetitionItemView) getChildAt(i);
                c(cardFrsGameCompetitionItemView, i, this.f14898g);
                d(cardFrsGameCompetitionItemView, list.get(i));
            }
            i++;
        }
        while (i < childCount) {
            removeViewAt(i);
            i++;
        }
        while (i < list.size()) {
            CardFrsGameCompetitionItemView b2 = this.f14896e.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i, this.f14898g);
            d(b2, list.get(i));
            addView(b2);
            i++;
        }
    }

    public void setItemSpace(int i) {
        this.f14897f = i;
    }

    public void setItemWidth(int i) {
        this.f14898g = i;
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setViewPool(b<CardFrsGameCompetitionItemView> bVar) {
        this.f14896e = bVar;
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14896e = null;
        this.i = new a();
        b();
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14896e = null;
        this.i = new a();
        b();
    }
}
