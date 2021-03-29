package com.baidu.tieba.homepage.hotTopic.tab;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.google.android.material.tabs.TabLayout;
import d.b.h0.m.f;
import d.b.h0.r.u.c;
import d.b.i0.x.p;
import d.b.i0.z0.e.a.e.d;
import d.b.i0.z0.e.a.g.a;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
/* loaded from: classes3.dex */
public class HotTopicHeaderView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17156e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f17157f;

    /* renamed from: g  reason: collision with root package name */
    public HotTopicTabRankListLayout f17158g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f17159h;
    public EMTextView i;
    public EMTextView j;
    public a k;
    public p l;
    public f m;
    public LinearLayout n;

    public HotTopicHeaderView(Context context) {
        super(context);
        this.f17156e = 3;
        b();
    }

    public final String a(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public final void b() {
        setOrientation(1);
        this.f17157f = new RelativeLayout(getContext());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        EMTextView eMTextView = new EMTextView(getContext());
        this.f17159h = eMTextView;
        eMTextView.setId(R.id.title_id);
        c a2 = c.a(this.f17159h);
        a2.n(R.color.CAM_X0105);
        a2.r(R.dimen.T_X07);
        a2.s(R.string.F_X02);
        this.f17159h.setText(a(R.string.hot_topic_tab_rank_list_title));
        this.f17159h.setMaxLines(1);
        this.f17159h.setEllipsize(TextUtils.TruncateAt.END);
        this.f17159h.setPadding(dimenPixelSize4, dimenPixelSize5, dimenPixelSize4, dimenPixelSize6);
        this.f17157f.addView(this.f17159h, new RelativeLayout.LayoutParams(-1, -2));
        this.f17158g = new HotTopicTabRankListLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.title_id);
        this.f17157f.addView(this.f17158g, layoutParams);
        c a3 = c.a(this.f17157f);
        a3.h(R.string.J_X06);
        a3.c(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.f17157f.setPadding(0, 0, 0, dimenPixelSize6);
        addView(this.f17157f, layoutParams2);
        p pVar = new p(getContext());
        this.l = pVar;
        pVar.setFrom("from_hottop");
        this.l.f("2");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds5);
        addView(this.l.b(), layoutParams3);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.n = linearLayout;
        linearLayout.setOrientation(0);
        EMTextView eMTextView2 = new EMTextView(getContext());
        c a4 = c.a(eMTextView2);
        a4.r(R.dimen.T_X07);
        a4.n(R.color.CAM_X0105);
        a4.s(R.string.F_X02);
        eMTextView2.setText(a(R.string.hot_topic_hot_tie_title));
        eMTextView2.setMaxLines(1);
        eMTextView2.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView2.setPadding(dimenPixelSize3 - dimenPixelSize2, 0, dimenPixelSize, 0);
        this.n.addView(eMTextView2);
        this.i = eMTextView2;
        EMTextView eMTextView3 = new EMTextView(getContext());
        c a5 = c.a(eMTextView3);
        a5.r(R.dimen.T_X09);
        a5.n(R.color.CAM_X0109);
        a5.s(R.string.F_X01);
        eMTextView3.setText(a(R.string.hot_topic_hot_tie_sub_title));
        eMTextView3.setMaxLines(1);
        eMTextView3.setEllipsize(TextUtils.TruncateAt.END);
        eMTextView3.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize5, 0, 0);
        this.n.addView(eMTextView3);
        this.j = eMTextView3;
        this.n.setPadding(0, dimenPixelSize5, 0, dimenPixelSize6);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        addView(this.n, layoutParams4);
        a aVar = new a(getContext());
        this.k = aVar;
        addView(aVar.b());
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.k.b().getLayoutParams();
        layoutParams5.weight = -1.0f;
        layoutParams5.height = UtilHelper.getDimenPixelSize(R.dimen.tbds106);
        this.k.b().requestLayout();
    }

    public void c(int i) {
        if (this.f17156e == i) {
            return;
        }
        this.f17156e = i;
        SkinManager.setViewTextColor(this.f17159h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
        c a2 = c.a(this.f17157f);
        a2.h(R.string.J_X06);
        a2.c(R.color.CAM_X0205);
        HotTopicTabRankListLayout hotTopicTabRankListLayout = this.f17158g;
        if (hotTopicTabRankListLayout != null) {
            hotTopicTabRankListLayout.d(i);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.d(i);
        }
        p pVar = this.l;
        if (pVar != null) {
            pVar.e(i);
        }
    }

    public void setData(HotThreadListResIdl hotThreadListResIdl) {
        DataRes dataRes;
        DataRes dataRes2;
        if (hotThreadListResIdl != null && (dataRes2 = hotThreadListResIdl.data) != null && !ListUtils.isEmpty(dataRes2.topic_list)) {
            this.f17159h.setVisibility(0);
            this.f17158g.setVisibility(0);
            this.f17158g.setOnItemCoverListener(this.m);
            this.f17158g.b(new d(hotThreadListResIdl.data.topic_list));
        } else {
            this.f17159h.setVisibility(8);
            this.f17158g.setVisibility(8);
        }
        p pVar = this.l;
        if (pVar != null) {
            pVar.b().setVisibility(0);
        }
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.k.f(d.b.i0.z0.e.a.c.e((hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null) ? null : dataRes.hot_thread_tab_info).a());
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setOnItemCoverListener(f fVar) {
        this.m = fVar;
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.k.e(onTabSelectedListener);
    }

    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17156e = 3;
        b();
    }

    public HotTopicHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17156e = 3;
        b();
    }
}
