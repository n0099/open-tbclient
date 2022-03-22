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
import c.a.o0.r.j0.b;
import c.a.o0.r.v.c;
import c.a.p0.f1.a;
import c.a.p0.f1.v2.e;
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
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class FrsMoveAreaChooseView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f32952b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f32953c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f32954d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f32955e;

    /* renamed from: f  reason: collision with root package name */
    public FrsMoveAreaChooseAdapter f32956f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f32957g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f32958h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsMoveAreaChooseView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            setGravity(80);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0342, this);
            this.f32952b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090b8a);
            this.f32953c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090b8e);
            this.f32954d = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090b8c);
            this.f32957g = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090b8b);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f090b8d);
            this.f32955e = recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            this.f32955e.addItemDecoration(new GridSpacingItemDecoration(3, n.f(getContext(), R.dimen.M_W_X004), n.f(getContext(), R.dimen.M_H_X003), false));
            FrsMoveAreaChooseAdapter frsMoveAreaChooseAdapter = new FrsMoveAreaChooseAdapter(this);
            this.f32956f = frsMoveAreaChooseAdapter;
            this.f32955e.setAdapter(frsMoveAreaChooseAdapter);
            this.f32952b.setOnClickListener(this);
            this.f32954d.setOnClickListener(this);
            this.f32957g.setOnClickListener(this);
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f32956f.e() >= 0) {
                this.f32954d.setAlpha(1.0f);
            } else {
                this.f32954d.setAlpha(0.5f);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0605);
            c d2 = c.d(this.f32952b);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f32953c, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f32954d, (int) R.color.CAM_X0304);
            b();
            SkinManager.setBackgroundColor(this.f32955e, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.f32957g, R.color.CAM_X0107);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getTag() instanceof Integer) {
                b();
            } else if (view == this.f32954d) {
                if (this.a == null || getParent() == null || this.f32956f.e() < 0) {
                    return;
                }
                boolean h2 = b.k().h("key_frs_move_area_tip", true);
                List<FrsTabInfo> g2 = a.h().g();
                FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(g2, this.f32956f.d());
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(g2, this.f32956f.e());
                if (frsTabInfo == null || frsTabInfo2 == null) {
                    return;
                }
                if (h2) {
                    e.a(this.a, frsTabInfo, frsTabInfo2);
                } else {
                    a.h().m(frsTabInfo.tab_id.intValue(), frsTabInfo2.tab_id.intValue());
                }
                if (this.f32958h != null) {
                    view.setTag("choose_done");
                    this.f32958h.onClick(view);
                }
            } else if (view != this.f32957g || this.f32958h == null) {
            } else {
                view.setTag("cancel_view");
                this.f32958h.onClick(view);
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f32958h = onClickListener;
            super.setOnClickListener(onClickListener);
        }
    }
}
