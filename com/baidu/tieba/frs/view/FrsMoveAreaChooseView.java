package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.d0.b;
import d.a.r0.r.u.c;
import d.a.s0.u0.a;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f16137e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16138f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f16139g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16140h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f16141i;
    public FrsMoveAreaChooseAdapter j;
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
        this.f16137e = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setGravity(80);
            LayoutInflater.from(getContext()).inflate(R.layout.frs_move_area_choose_layout, this);
            this.f16138f = (RelativeLayout) findViewById(R.id.frs_move_area_choose_bar);
            this.f16139g = (EMTextView) findViewById(R.id.frs_move_area_choose_title);
            this.f16140h = (EMTextView) findViewById(R.id.frs_move_area_choose_done);
            this.k = (EMTextView) findViewById(R.id.frs_move_area_choose_cancel);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.frs_move_area_choose_list);
            this.f16141i = recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            this.f16141i.addItemDecoration(new GridSpacingItemDecoration(3, l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_H_X003), false));
            FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter = new FrsMoveAreaChooseAdapter(this);
            this.j = frsMoveAreaChooseAdapter;
            this.f16141i.setAdapter(frsMoveAreaChooseAdapter);
            this.f16138f.setOnClickListener(this);
            this.f16140h.setOnClickListener(this);
            this.k.setOnClickListener(this);
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.j.n() >= 0) {
                this.f16140h.setAlpha(1.0f);
            } else {
                this.f16140h.setAlpha(0.5f);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0605);
            c d2 = c.d(this.f16138f);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f16139g, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f16140h, R.color.CAM_X0304);
            b();
            SkinManager.setBackgroundColor(this.f16141i, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.k, R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getTag() instanceof Integer) {
                b();
            } else if (view == this.f16140h) {
                if (this.f16137e == null || getParent() == null || this.j.n() < 0) {
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
                    d.a.s0.u0.r2.c.a(this.f16137e, frsTabInfo, frsTabInfo2);
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
