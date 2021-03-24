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
import d.b.b.e.k.b;
import java.util.List;
/* loaded from: classes4.dex */
public class CardFrsGameRecommendGameLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b<CardFrsGameRecommendGameItemView> f15242e;

    /* renamed from: f  reason: collision with root package name */
    public int f15243f;

    /* renamed from: g  reason: collision with root package name */
    public int f15244g;

    /* renamed from: h  reason: collision with root package name */
    public int f15245h;
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
            if (!(view2 instanceof CardFrsGameRecommendGameItemView) || CardFrsGameRecommendGameLayout.this.f15242e == null) {
                return;
            }
            CardFrsGameRecommendGameLayout.this.f15242e.e((CardFrsGameRecommendGameItemView) view2);
        }
    }

    public CardFrsGameRecommendGameLayout(Context context) {
        super(context);
        this.f15242e = null;
        this.i = new a();
        b();
    }

    public final void b() {
        setOrientation(0);
        setGravity(17);
    }

    public final void c(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameRecommendGameItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f15243f;
        }
        cardFrsGameRecommendGameItemView.setLayoutParams(layoutParams);
    }

    public final void d(CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView, FeatureCardGameSubNode featureCardGameSubNode) {
        if (featureCardGameSubNode == null) {
            return;
        }
        cardFrsGameRecommendGameItemView.getGamePicView().W(featureCardGameSubNode.image, 10, false);
        cardFrsGameRecommendGameItemView.getGameNameView().setText(featureCardGameSubNode.name);
        cardFrsGameRecommendGameItemView.getGameDscView().setText(featureCardGameSubNode.title);
        cardFrsGameRecommendGameItemView.setTag(featureCardGameSubNode.url);
        cardFrsGameRecommendGameItemView.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        return this.f15245h;
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

    public void setData(List<FeatureCardGameSubNode> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f15245h = this.f15244g + this.f15243f;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount && i < list.size()) {
            if (getChildAt(i) instanceof CardFrsGameRecommendGameItemView) {
                CardFrsGameRecommendGameItemView cardFrsGameRecommendGameItemView = (CardFrsGameRecommendGameItemView) getChildAt(i);
                c(cardFrsGameRecommendGameItemView, i, this.f15244g);
                d(cardFrsGameRecommendGameItemView, list.get(i));
            }
            i++;
        }
        while (i < childCount) {
            removeViewAt(i);
            i++;
        }
        while (i < list.size()) {
            CardFrsGameRecommendGameItemView b2 = this.f15242e.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i, this.f15244g);
            d(b2, list.get(i));
            addView(b2);
            i++;
        }
    }

    public void setItemSpace(int i) {
        this.f15243f = i;
    }

    public void setItemWidth(int i) {
        this.f15244g = i;
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setViewPool(b<CardFrsGameRecommendGameItemView> bVar) {
        this.f15242e = bVar;
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15242e = null;
        this.i = new a();
        b();
    }

    public CardFrsGameRecommendGameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15242e = null;
        this.i = new a();
        b();
    }
}
