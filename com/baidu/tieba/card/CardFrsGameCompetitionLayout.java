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
import d.a.c.e.k.b;
import java.util.List;
/* loaded from: classes4.dex */
public class CardFrsGameCompetitionLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b<CardFrsGameCompetitionItemView> f15008e;

    /* renamed from: f  reason: collision with root package name */
    public int f15009f;

    /* renamed from: g  reason: collision with root package name */
    public int f15010g;

    /* renamed from: h  reason: collision with root package name */
    public int f15011h;

    /* renamed from: i  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f15012i;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof CardFrsGameCompetitionItemView) || CardFrsGameCompetitionLayout.this.f15008e == null) {
                return;
            }
            CardFrsGameCompetitionLayout.this.f15008e.e((CardFrsGameCompetitionItemView) view2);
        }
    }

    public CardFrsGameCompetitionLayout(Context context) {
        super(context);
        this.f15008e = null;
        this.f15012i = new a();
        b();
    }

    public final void b() {
        setOrientation(0);
        setGravity(17);
    }

    public final void c(CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameCompetitionItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i3, -1);
        } else {
            layoutParams.width = i3;
        }
        if (i2 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f15009f;
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
        return this.f15011h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.f15012i);
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
        this.f15011h = this.f15010g + this.f15009f;
        int i2 = 0;
        int childCount = getChildCount();
        while (i2 < childCount && i2 < list.size()) {
            if (getChildAt(i2) instanceof CardFrsGameCompetitionItemView) {
                CardFrsGameCompetitionItemView cardFrsGameCompetitionItemView = (CardFrsGameCompetitionItemView) getChildAt(i2);
                c(cardFrsGameCompetitionItemView, i2, this.f15010g);
                d(cardFrsGameCompetitionItemView, list.get(i2));
            }
            i2++;
        }
        while (i2 < childCount) {
            removeViewAt(i2);
            i2++;
        }
        while (i2 < list.size()) {
            CardFrsGameCompetitionItemView b2 = this.f15008e.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i2, this.f15010g);
            d(b2, list.get(i2));
            addView(b2);
            i2++;
        }
    }

    public void setItemSpace(int i2) {
        this.f15009f = i2;
    }

    public void setItemWidth(int i2) {
        this.f15010g = i2;
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setViewPool(b<CardFrsGameCompetitionItemView> bVar) {
        this.f15008e = bVar;
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15008e = null;
        this.f15012i = new a();
        b();
    }

    public CardFrsGameCompetitionLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15008e = null;
        this.f15012i = new a();
        b();
    }
}
