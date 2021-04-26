package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import d.a.c.e.p.e;
import d.a.i0.r.f0.q.c;
import java.util.List;
import java.util.Locale;
/* loaded from: classes4.dex */
public class UserRecommendLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16707e;

    /* renamed from: f  reason: collision with root package name */
    public int f16708f;

    /* renamed from: g  reason: collision with root package name */
    public int f16709g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f16710h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f16711i;
    public d.a.c.e.k.b<UserRecommendItemView> j;
    public final ViewGroup.OnHierarchyChangeListener k;

    /* loaded from: classes4.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public a() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view2 instanceof UserRecommendItemView) || UserRecommendLayout.this.j == null) {
                return;
            }
            UserRecommendItemView userRecommendItemView = (UserRecommendItemView) view2;
            if (userRecommendItemView.getTag() instanceof c) {
                ((c) userRecommendItemView.getTag()).s(UserRecommendLayout.this.f16707e.getUniqueId());
            }
            UserRecommendLayout.this.j.e(userRecommendItemView);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CommonUserLikeButton.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserRecommendItemView f16713a;

        public b(UserRecommendItemView userRecommendItemView) {
            this.f16713a = userRecommendItemView;
        }

        @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton.a
        public void a(int i2) {
            this.f16713a.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", StringHelper.numFormatOverWanNa(i2)));
        }
    }

    public UserRecommendLayout(Context context) {
        super(context);
        this.f16709g = 0;
        this.f16710h = null;
        this.f16711i = null;
        this.j = null;
        this.k = new a();
        c();
    }

    public final void c() {
        setOrientation(0);
    }

    public final void d(UserRecommendItemView userRecommendItemView, int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) userRecommendItemView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i3, -1);
        } else {
            layoutParams.width = i3;
        }
        if (i2 == 0) {
            layoutParams.leftMargin = 0;
        } else {
            layoutParams.leftMargin = this.f16709g;
        }
        userRecommendItemView.setLayoutParams(layoutParams);
    }

    public final void e(UserRecommendItemView userRecommendItemView, MetaData metaData) {
        c cVar;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        userRecommendItemView.getFansNum().setText(String.format(Locale.CHINA, "%s粉丝", StringHelper.numFormatOverWanNa(metaData.getFansNum())));
        userRecommendItemView.getUsername().setText(metaData.getName_show());
        userRecommendItemView.getLikeBtn().setFanNumCallBack(new b(userRecommendItemView));
        if (userRecommendItemView.getLikeBtn().getTag() instanceof c) {
            cVar = (c) userRecommendItemView.getLikeBtn().getTag();
        } else {
            cVar = new c(this.f16707e, userRecommendItemView.getLikeBtn());
        }
        cVar.m("7");
        userRecommendItemView.getLikeBtn().setTag(cVar);
        cVar.n(metaData);
        userRecommendItemView.getLikeBtn().setAfterOnClickListener(this.f16710h);
        userRecommendItemView.getHeaderView().setData(metaData);
        userRecommendItemView.getHeaderView().setAfterClickListener(this.f16711i);
        userRecommendItemView.setIsGod(metaData.isGod());
        userRecommendItemView.c(skinType);
    }

    public int getChildItemWidth() {
        return this.f16708f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnHierarchyChangeListener(this.k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnHierarchyChangeListener(null);
    }

    public void setAfterHeaderLickListener(View.OnClickListener onClickListener) {
        this.f16711i = onClickListener;
    }

    public void setAfterLikeBtnClickListener(View.OnClickListener onClickListener) {
        this.f16710h = onClickListener;
    }

    public void setData(List<MetaData> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        int a2 = e.a(getContext()) - (getPaddingLeft() * 2);
        int i2 = this.f16709g;
        int i3 = (a2 - (i2 * 2)) / 3;
        this.f16708f = i2 + i3;
        int i4 = 0;
        int childCount = getChildCount();
        while (i4 < childCount && i4 < list.size()) {
            if (getChildAt(i4) instanceof UserRecommendItemView) {
                UserRecommendItemView userRecommendItemView = (UserRecommendItemView) getChildAt(i4);
                d(userRecommendItemView, i4, i3);
                e(userRecommendItemView, list.get(i4));
            }
            i4++;
        }
        while (i4 < childCount) {
            removeViewAt(i4);
            i4++;
        }
        while (i4 < list.size()) {
            UserRecommendItemView b2 = this.j.b();
            if (b2.getParent() != null) {
                ((ViewGroup) b2.getParent()).removeView(b2);
            }
            d(b2, i4, i3);
            e(b2, list.get(i4));
            addView(b2);
            i4++;
        }
    }

    public void setItemSpace(int i2) {
        this.f16709g = i2;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f16707e = tbPageContext;
    }

    public void setViewPool(d.a.c.e.k.b<UserRecommendItemView> bVar) {
        this.j = bVar;
    }

    public UserRecommendLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16709g = 0;
        this.f16710h = null;
        this.f16711i = null;
        this.j = null;
        this.k = new a();
        c();
    }
}
