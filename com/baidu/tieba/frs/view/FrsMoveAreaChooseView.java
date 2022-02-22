package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.t0.s.j0.b;
import c.a.t0.s.v.c;
import c.a.u0.e1.a;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import c.a.u0.e1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes12.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f44087e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f44088f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f44089g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f44090h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f44091i;

    /* renamed from: j  reason: collision with root package name */
    public FrsMoveAreaChooseAdapter f44092j;
    public EMTextView k;
    public View.OnClickListener l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44087e = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setGravity(80);
            LayoutInflater.from(getContext()).inflate(g1.frs_move_area_choose_layout, this);
            this.f44088f = (RelativeLayout) findViewById(f1.frs_move_area_choose_bar);
            this.f44089g = (EMTextView) findViewById(f1.frs_move_area_choose_title);
            this.f44090h = (EMTextView) findViewById(f1.frs_move_area_choose_done);
            this.k = (EMTextView) findViewById(f1.frs_move_area_choose_cancel);
            RecyclerView recyclerView = (RecyclerView) findViewById(f1.frs_move_area_choose_list);
            this.f44091i = recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            this.f44091i.addItemDecoration(new GridSpacingItemDecoration(3, n.f(getContext(), d1.M_W_X004), n.f(getContext(), d1.M_H_X003), false));
            FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter = new FrsMoveAreaChooseAdapter(this);
            this.f44092j = frsMoveAreaChooseAdapter;
            this.f44091i.setAdapter(frsMoveAreaChooseAdapter);
            this.f44088f.setOnClickListener(this);
            this.f44090h.setOnClickListener(this);
            this.k.setOnClickListener(this);
            onChangeSkinType();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f44092j.getSelectPos() >= 0) {
                this.f44090h.setAlpha(1.0f);
            } else {
                this.f44090h.setAlpha(0.5f);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, c1.CAM_X0605);
            c d2 = c.d(this.f44088f);
            d2.n(i1.J_X14);
            d2.f(c1.CAM_X0204);
            SkinManager.setViewTextColor(this.f44089g, c1.CAM_X0108);
            SkinManager.setViewTextColor(this.f44090h, c1.CAM_X0304);
            b();
            SkinManager.setBackgroundColor(this.f44091i, c1.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.k, c1.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getTag() instanceof Integer) {
                b();
            } else if (view == this.f44090h) {
                if (this.f44087e == null || getParent() == null || this.f44092j.getSelectPos() < 0) {
                    return;
                }
                boolean h2 = b.k().h("key_frs_move_area_tip", true);
                List<FrsTabInfo> g2 = a.h().g();
                FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(g2, this.f44092j.getCurPos());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(g2, this.f44092j.getSelectPos());
                if (frsTabInfo == null || frsTabInfo2 == null) {
                    return;
                }
                if (h2) {
                    c.a.u0.e1.f3.c.a(this.f44087e, frsTabInfo, frsTabInfo2);
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
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.l = onClickListener;
            super.setOnClickListener(onClickListener);
        }
    }
}
