package com.baidu.tieba.frs.recommend;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.s.l0.n.b;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import c.a.u0.z3.c;
import c.a.u0.z3.m;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsLikeRecommendHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final BarImageView f43936b;

    /* renamed from: c  reason: collision with root package name */
    public final SymbolEMTextView f43937c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f43938d;

    /* renamed from: e  reason: collision with root package name */
    public final TBSpecificationBtn f43939e;

    /* renamed from: f  reason: collision with root package name */
    public final String f43940f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendHolder(View view, String str) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43940f = str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(f1.frs_like_recommend_item_root);
        this.a = linearLayout;
        this.f43936b = (BarImageView) linearLayout.findViewById(f1.forum_head_image);
        this.f43937c = (SymbolEMTextView) this.a.findViewById(f1.forum_name_tv);
        this.f43938d = (TextView) this.a.findViewById(f1.forum_member_like_des_tv);
        this.f43939e = (TBSpecificationBtn) this.a.findViewById(f1.forum_like_btn);
        BarImageView barImageView = this.f43936b;
        if (barImageView != null) {
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            BarImageView barImageView2 = this.f43936b;
            barImageView2.setContentDescription(barImageView2.getResources().getString(i1.bar_header));
            this.f43936b.setStrokeColorResId(c1.CAM_X0401);
            BarImageView barImageView3 = this.f43936b;
            barImageView3.setStrokeWith(n.f(barImageView3.getContext(), d1.tbds3));
            this.f43936b.setShowOval(true);
            this.f43936b.setPlaceHolder(1);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f43939e;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setTextSize(d1.T_X08);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void bind(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
            BarImageView barImageView = this.f43936b;
            if (barImageView != null) {
                barImageView.startLoad(mVar.f26262f, 10, false);
            }
            SymbolEMTextView symbolEMTextView = this.f43937c;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(mVar.f26263g + this.f43937c.getContext().getString(i1.forum));
            }
            TextView textView = this.f43938d;
            if (textView != null) {
                textView.setText(mVar.f26264h);
            }
            if (this.f43939e != null) {
                if (mVar.f26265i) {
                    b bVar = new b();
                    bVar.p(c1.CAM_X0903, c1.CAM_X0109);
                    this.f43939e.setConfig(bVar);
                    TBSpecificationBtn tBSpecificationBtn = this.f43939e;
                    tBSpecificationBtn.setText(tBSpecificationBtn.getContext().getString(i1.followed));
                    return;
                }
                b bVar2 = new b();
                bVar2.s(c.e(this.f43940f));
                this.f43939e.setConfig(bVar2);
                TBSpecificationBtn tBSpecificationBtn2 = this.f43939e;
                tBSpecificationBtn2.setText(tBSpecificationBtn2.getContext().getString(i1.frs_like_forum));
            }
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(linearLayout);
                d2.n(i1.J_X05);
                d2.f(c1.CAM_X0201);
            }
            SymbolEMTextView symbolEMTextView = this.f43937c;
            if (symbolEMTextView != null) {
                c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(symbolEMTextView);
                d3.A(i1.F_X01);
                d3.v(c1.CAM_X0105);
            }
            TextView textView = this.f43938d;
            if (textView != null) {
                c.a.t0.s.v.c.d(textView).v(c1.CAM_X0109);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f43939e;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void setLikeClickListener(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (tBSpecificationBtn = this.f43939e) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }
}
