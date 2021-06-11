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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardTopicSubNode;
import d.a.c.e.k.b;
import java.util.List;
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b<CardFrsGameSpecialTopicItemView> f14307e;

    /* renamed from: f  reason: collision with root package name */
    public int f14308f;

    /* renamed from: g  reason: collision with root package name */
    public int f14309g;

    /* renamed from: h  reason: collision with root package name */
    public int f14310h;

    /* renamed from: i  reason: collision with root package name */
    public final ViewGroup.OnHierarchyChangeListener f14311i;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof CardFrsGameSpecialTopicItemView) || CardFrsGameSpecialTopicLayout.this.f14307e == null) {
                return;
            }
            CardFrsGameSpecialTopicLayout.this.f14307e.e((CardFrsGameSpecialTopicItemView) view2);
        }
    }

    public CardFrsGameSpecialTopicLayout(Context context) {
        super(context);
        this.f14307e = null;
        this.f14311i = new a();
        b();
    }

    public final void b() {
        setOrientation(0);
        setGravity(17);
    }

    public final void c(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameSpecialTopicItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i3, -1);
        } else {
            layoutParams.width = i3;
        }
        if (i2 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f14308f;
        }
        cardFrsGameSpecialTopicItemView.setLayoutParams(layoutParams);
    }

    public final void d(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, FeatureCardTopicSubNode featureCardTopicSubNode) {
        if (featureCardTopicSubNode == null) {
            return;
        }
        cardFrsGameSpecialTopicItemView.getSpecialTopicPicView().U(featureCardTopicSubNode.image, 10, false);
        cardFrsGameSpecialTopicItemView.getSpecialTopicNameView().setText(featureCardTopicSubNode.title);
        cardFrsGameSpecialTopicItemView.getSpecialTopicDscView().setText(getContext().getResources().getString(R.string.frs_game_special_card_article_num, String.valueOf(featureCardTopicSubNode.article_num)));
        cardFrsGameSpecialTopicItemView.getSpecialTopicUpdateTimeView().setText(getContext().getString(R.string.frs_game_special_card_last_update_time, StringHelper.getTimeInterval(featureCardTopicSubNode.update_time)));
        cardFrsGameSpecialTopicItemView.setTag(featureCardTopicSubNode.url);
        cardFrsGameSpecialTopicItemView.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        return this.f14310h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.f14311i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setData(List<FeatureCardTopicSubNode> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f14310h = this.f14309g + this.f14308f;
        int i2 = 0;
        int childCount = getChildCount();
        while (i2 < childCount && i2 < list.size()) {
            if (getChildAt(i2) instanceof CardFrsGameSpecialTopicItemView) {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = (CardFrsGameSpecialTopicItemView) getChildAt(i2);
                c(cardFrsGameSpecialTopicItemView, i2, this.f14309g);
                d(cardFrsGameSpecialTopicItemView, list.get(i2));
            }
            i2++;
        }
        while (i2 < childCount) {
            removeViewAt(i2);
            i2++;
        }
        while (i2 < list.size()) {
            CardFrsGameSpecialTopicItemView b2 = this.f14307e.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i2, this.f14309g);
            d(b2, list.get(i2));
            addView(b2);
            i2++;
        }
    }

    public void setItemSpace(int i2) {
        this.f14308f = i2;
    }

    public void setItemWidth(int i2) {
        this.f14309g = i2;
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setViewPool(b<CardFrsGameSpecialTopicItemView> bVar) {
        this.f14307e = bVar;
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14307e = null;
        this.f14311i = new a();
        b();
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14307e = null;
        this.f14311i = new a();
        b();
    }
}
