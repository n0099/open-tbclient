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
import d.b.c.e.p.l;
import d.b.i0.r.d0.b;
import d.b.i0.r.u.c;
import d.b.j0.q0.a;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16407e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16408f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f16409g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16410h;
    public RecyclerView i;
    public FrsMoveAreaChooseAdapter j;
    public EMTextView k;
    public View.OnClickListener l;

    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.f16407e = tbPageContext;
        a();
    }

    public final void a() {
        setOrientation(1);
        setGravity(80);
        LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_choose_layout, this);
        this.f16408f = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
        this.f16409g = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
        this.f16410h = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
        this.k = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
        this.i = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.i.addItemDecoration(new GridSpacingItemDecoration(3, l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_H_X003), false));
        FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter = new FrsMoveAreaChooseAdapter(this);
        this.j = frsMoveAreaChooseAdapter;
        this.i.setAdapter(frsMoveAreaChooseAdapter);
        this.f16408f.setOnClickListener(this);
        this.f16410h.setOnClickListener(this);
        this.k.setOnClickListener(this);
        c();
    }

    public final void b() {
        if (this.j.n() >= 0) {
            this.f16410h.setAlpha(1.0f);
        } else {
            this.f16410h.setAlpha(0.5f);
        }
    }

    public void c() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0605);
        c d2 = c.d(this.f16408f);
        d2.k(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f16409g, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f16410h, R.color.CAM_X0304);
        b();
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.k, R.color.CAM_X0107);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            b();
        } else if (view == this.f16410h) {
            if (this.f16407e == null || getParent() == null || this.j.n() < 0) {
                return;
            }
            boolean g2 = b.j().g("key_frs_move_area_tip", true);
            List<FrsTabInfo> g3 = a.h().g();
            FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(g3, this.j.m());
            FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(g3, this.j.n());
            if (frsTabInfo == null || frsTabInfo2 == null) {
                return;
            }
            if (g2) {
                new d.b.j0.q0.r2.c().h(this.f16407e, frsTabInfo, frsTabInfo2);
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
