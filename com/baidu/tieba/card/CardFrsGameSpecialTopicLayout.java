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
import d.b.b.e.k.b;
import java.util.List;
/* loaded from: classes4.dex */
public class CardFrsGameSpecialTopicLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public b<CardFrsGameSpecialTopicItemView> f15253e;

    /* renamed from: f  reason: collision with root package name */
    public int f15254f;

    /* renamed from: g  reason: collision with root package name */
    public int f15255g;

    /* renamed from: h  reason: collision with root package name */
    public int f15256h;
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
            if (!(view2 instanceof CardFrsGameSpecialTopicItemView) || CardFrsGameSpecialTopicLayout.this.f15253e == null) {
                return;
            }
            CardFrsGameSpecialTopicLayout.this.f15253e.e((CardFrsGameSpecialTopicItemView) view2);
        }
    }

    public CardFrsGameSpecialTopicLayout(Context context) {
        super(context);
        this.f15253e = null;
        this.i = new a();
        b();
    }

    public final void b() {
        setOrientation(0);
        setGravity(17);
    }

    public final void c(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardFrsGameSpecialTopicItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i2, -1);
        } else {
            layoutParams.width = i2;
        }
        if (i == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f15254f;
        }
        cardFrsGameSpecialTopicItemView.setLayoutParams(layoutParams);
    }

    public final void d(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView, FeatureCardTopicSubNode featureCardTopicSubNode) {
        if (featureCardTopicSubNode == null) {
            return;
        }
        cardFrsGameSpecialTopicItemView.getSpecialTopicPicView().W(featureCardTopicSubNode.image, 10, false);
        cardFrsGameSpecialTopicItemView.getSpecialTopicNameView().setText(featureCardTopicSubNode.title);
        cardFrsGameSpecialTopicItemView.getSpecialTopicDscView().setText(getContext().getResources().getString(R.string.frs_game_special_card_article_num, String.valueOf(featureCardTopicSubNode.article_num)));
        cardFrsGameSpecialTopicItemView.getSpecialTopicUpdateTimeView().setText(getContext().getString(R.string.frs_game_special_card_last_update_time, StringHelper.getTimeInterval(featureCardTopicSubNode.update_time)));
        cardFrsGameSpecialTopicItemView.setTag(featureCardTopicSubNode.url);
        cardFrsGameSpecialTopicItemView.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public int getChildItemWidth() {
        return this.f15256h;
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

    public void setData(List<FeatureCardTopicSubNode> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f15256h = this.f15255g + this.f15254f;
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount && i < list.size()) {
            if (getChildAt(i) instanceof CardFrsGameSpecialTopicItemView) {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = (CardFrsGameSpecialTopicItemView) getChildAt(i);
                c(cardFrsGameSpecialTopicItemView, i, this.f15255g);
                d(cardFrsGameSpecialTopicItemView, list.get(i));
            }
            i++;
        }
        while (i < childCount) {
            removeViewAt(i);
            i++;
        }
        while (i < list.size()) {
            CardFrsGameSpecialTopicItemView b2 = this.f15253e.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            c(b2, i, this.f15255g);
            d(b2, list.get(i));
            addView(b2);
            i++;
        }
    }

    public void setItemSpace(int i) {
        this.f15254f = i;
    }

    public void setItemWidth(int i) {
        this.f15255g = i;
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setViewPool(b<CardFrsGameSpecialTopicItemView> bVar) {
        this.f15253e = bVar;
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15253e = null;
        this.i = new a();
        b();
    }

    public CardFrsGameSpecialTopicLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15253e = null;
        this.i = new a();
        b();
    }
}
