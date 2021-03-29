package com.baidu.tieba.frs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.r.d0.b;
import d.b.h0.r.u.c;
import d.b.i0.p0.a;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16738e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16739f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f16740g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16741h;
    public RecyclerView i;
    public FrsMoveAreaChooseAdapter j;
    public EMTextView k;
    public View.OnClickListener l;

    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f16738e = tbPageContext;
        a();
    }

    public final void a() {
        setOrientation(1);
        setGravity(80);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_choose_layout, this);
        this.f16739f = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.f16740g = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.f16741h = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.k = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.i.addItemDecoration(new GridSpacingItemDecoration(3, l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_H_X003), false));
        FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter = new FrsMoveAreaChooseAdapter(this);
        this.j = frsMoveAreaChooseAdapter;
        this.i.setAdapter(frsMoveAreaChooseAdapter);
        this.f16739f.setOnClickListener(this);
        this.f16741h.setOnClickListener(this);
        this.k.setOnClickListener(this);
        c();
    }

    public final void b() {
        if (this.j.n() >= 0) {
            this.f16741h.setAlpha(1.0f);
        } else {
            this.f16741h.setAlpha(0.5f);
        }
    }

    public void c() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0605);
        c a2 = c.a(this.f16739f);
        a2.h(R.string.J_X14);
        a2.c(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f16740g, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f16741h, R.color.CAM_X0304);
        b();
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.k, R.color.CAM_X0107);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            b();
        } else if (view == this.f16741h) {
            if (this.f16738e == null || getParent() == null || this.j.n() < 0) {
                return;
            }
            boolean g2 = b.i().g("key_frs_move_area_tip", true);
            List<FrsTabInfo> g3 = a.h().g();
            FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(g3, this.j.m());
            FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(g3, this.j.n());
            if (frsTabInfo == null || frsTabInfo2 == null) {
                return;
            }
            if (g2) {
                new d.b.i0.p0.q2.c().h(this.f16738e, frsTabInfo, frsTabInfo2);
            } else {
                a.h().m(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
            }
            if (this.l != null) {
                view.setTag("choose_done");
                this.l.onClick(view);
            }
        } else if (view != this.k || this.l == null) {
        } else {
            view.setTag("cancel_view");
            this.l.onClick(view);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.l = onClickListener;
        super.setOnClickListener(onClickListener);
    }
}
