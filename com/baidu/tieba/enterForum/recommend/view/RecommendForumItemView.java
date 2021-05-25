package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.j0.k.c.b;
/* loaded from: classes4.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public View f14531e;

    /* renamed from: f  reason: collision with root package name */
    public View f14532f;

    /* renamed from: g  reason: collision with root package name */
    public BarImageView f14533g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14534h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14535i;
    public TextView j;
    public TextView k;
    public TBSpecificationBtn l;
    public a m;
    public b n;

    /* loaded from: classes4.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13374");
        statisticItem.param("obj_type", String.valueOf(bVar.f56010h));
        statisticItem.param("fid", bVar.f56004b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        TiebaStatic.log(statisticItem);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.recommend_forum_item_layout, this);
        View rootView = getRootView();
        this.f14531e = rootView.findViewById(R.id.view_top);
        this.f14532f = rootView.findViewById(R.id.view_bottom);
        this.f14533g = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.f14534h = (TextView) rootView.findViewById(R.id.forum_name);
        this.f14535i = (TextView) rootView.findViewById(R.id.forum_attention);
        this.j = (TextView) rootView.findViewById(R.id.forum_thread);
        this.k = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.l = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        bVar.q(R.color.CAM_X0302);
        this.l.setConfig(bVar);
        this.l.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.f14533g.setPlaceHolder(1);
        this.f14533g.setOnClickListener(this);
        this.l.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void c(b bVar) {
        if (bVar == null) {
            return;
        }
        this.n = bVar;
        this.f14533g.V(bVar.f56003a, 15, false);
        this.f14533g.setStrokeColorResId(R.color.CAM_X0201);
        this.f14533g.setStrokeWith(3);
        this.f14533g.setShowOval(true);
        String str = bVar.f56005c;
        if (k.isEmpty(str)) {
            str = "";
        }
        this.f14534h.setText(str);
        String numFormatOverWan = StringHelper.numFormatOverWan(bVar.f56007e);
        TextView textView = this.f14535i;
        textView.setText("关注 " + numFormatOverWan);
        String numFormatOverWan2 = StringHelper.numFormatOverWan((long) bVar.f56008f);
        TextView textView2 = this.j;
        textView2.setText("贴子 " + numFormatOverWan2);
        if (!k.isEmpty(bVar.f56009g)) {
            this.k.setText(bVar.f56009g);
        } else {
            this.k.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
        }
        e(bVar.f56006d);
        DrawableSelector.make().tlRadius(l.g(getContext(), R.dimen.tbds10)).trRadius(l.g(getContext(), R.dimen.tbds10)).defaultColor(R.color.CAM_X0901).into(this.f14531e);
        TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(getContext(), R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.NO_TOP).setShadowRadius(l.g(getContext(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(getContext(), R.dimen.tbds5)).into(this.f14532f);
        a(bVar);
    }

    public void d() {
        SkinManager.setViewTextColor(this.f14534h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f14535i, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0107);
    }

    public void e(boolean z) {
        if (z) {
            d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
            bVar.r(R.color.CAM_X0109);
            this.l.setConfig(bVar);
            this.l.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.l.setClickState(false);
        } else {
            d.a.m0.r.f0.m.b bVar2 = new d.a.m0.r.f0.m.b();
            bVar2.q(R.color.CAM_X0302);
            this.l.setConfig(bVar2);
            this.l.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.l.setClickState(true);
        }
        this.n.f56006d = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.l) {
            b bVar = this.n;
            if (bVar.f56006d) {
                this.m.b(bVar);
                return;
            } else {
                this.m.a(bVar);
                return;
            }
        }
        this.m.b(this.n);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.m = aVar;
        }
    }

    public RecommendForumItemView(Context context) {
        super(context);
        b(context);
    }
}
