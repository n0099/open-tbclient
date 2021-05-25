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
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGameSubNode;
import d.a.c.e.k.b;
import java.util.List;
/* loaded from: classes4.dex */
public class CardFrsGameRecommendGameLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b<CardFrsGameRecommendGameItemView> f14238e;

    /* renamed from: f  reason: collision with root package name */
    public int f14239f;

    /* renamed from: g  reason: collision with root package name */
    public int f14240g;

    /* renamed from: h  reason: collision with root package name */
    public int f14241h;

    /* renamed from: i  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f14242i;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof CardFrsGameRecommendGameItemView) || CardFrsGameRecommendGameLayout.this.f14238e == null) {
                return;
            }
            CardFrsGameRecommendGameLayout.this.f14238e.e((CardFrsGameRecommendGameItemView) view2);
        }
    }

    public CardFrsGameRecommendGameLayout(Context context) {
        super(context);
        this.f14238e = null;
        this.f14242i = new a();
        b();
    }

    public final void b() {
        setOrientation(0);
        setGravity(17);
    }

    public final void c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameRecommendGameItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i3, -1);
        } else {
            layoutParams.width = i3;
        }
        if (i2 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f14239f;
        }
        cardFrsGameRecommendGameItemView.setLayoutParams(layoutParams);
    }

    public final void d(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, FeatureCardGameSubNode featureCardGameSubNode) {
        if (featureCardGameSubNode == null) {
            return;
        }
        cardFrsGameRecommendGameItemView.getGamePicView().V(featureCardGameSubNode.image, 10, false);
        cardFrsGameRecommendGameItemView.getGameNameView().setText(featureCardGameSubNode.name);
        cardFrsGameRecommendGameItemView.getGameDscView().setText(featureCardGameSubNode.title);
        cardFrsGameRecommendGameItemView.setTag(featureCardGameSubNode.url);
        cardFrsGameRecommendGameItemView.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        return this.f14241h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.f14242i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setData(List<FeatureCardGameSubNode> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f14241h = this.f14240g + this.f14239f;
        int i2 = 0;
        int childCount = getChildCount();
        while (i2 < childCount && i2 < list.size()) {
            if (getChildAt(i2) instanceof CardFrsGameRecommendGameItemView) {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i2);
                c(cardFrsGameRecommendGameItemView, i2, this.f14240g);
                d(cardFrsGameRecommendGameItemView, list.get(i2));
            }
            i2++;
        }
        while (i2 < childCount) {
            removeViewAt(i2);
            i2++;
        }
        while (i2 < list.size()) {
            CardFrsGameRecommendGameItemView b2 = this.f14238e.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i2, this.f14240g);
            d(b2, list.get(i2));
            addView(b2);
            i2++;
        }
    }

    public void setItemSpace(int i2) {
        this.f14239f = i2;
    }

    public void setItemWidth(int i2) {
        this.f14240g = i2;
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setViewPool(b<CardFrsGameRecommendGameItemView> bVar) {
        this.f14238e = bVar;
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14238e = null;
        this.f14242i = new a();
        b();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14238e = null;
        this.f14242i = new a();
        b();
    }
}
