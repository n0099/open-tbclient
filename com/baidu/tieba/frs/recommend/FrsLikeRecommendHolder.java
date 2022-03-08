package com.baidu.tieba.frs.recommend;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.r.l0.n.b;
import c.a.r0.y3.c;
import c.a.r0.y3.m;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SymbolEMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsLikeRecommendHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final BarImageView f42339b;

    /* renamed from: c  reason: collision with root package name */
    public final SymbolEMTextView f42340c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f42341d;

    /* renamed from: e  reason: collision with root package name */
    public final TBSpecificationBtn f42342e;

    /* renamed from: f  reason: collision with root package name */
    public final String f42343f;

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
        this.f42343f = str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.frs_like_recommend_item_root);
        this.a = linearLayout;
        this.f42339b = (BarImageView) linearLayout.findViewById(R.id.forum_head_image);
        this.f42340c = (SymbolEMTextView) this.a.findViewById(R.id.forum_name_tv);
        this.f42341d = (TextView) this.a.findViewById(R.id.forum_member_like_des_tv);
        this.f42342e = (TBSpecificationBtn) this.a.findViewById(R.id.forum_like_btn);
        BarImageView barImageView = this.f42339b;
        if (barImageView != null) {
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            BarImageView barImageView2 = this.f42339b;
            barImageView2.setContentDescription(barImageView2.getResources().getString(R.string.bar_header));
            this.f42339b.setStrokeColorResId(R.color.CAM_X0401);
            BarImageView barImageView3 = this.f42339b;
            barImageView3.setStrokeWith(n.f(barImageView3.getContext(), R.dimen.tbds3));
            this.f42339b.setShowOval(true);
            this.f42339b.setPlaceHolder(1);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f42342e;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setTextSize(R.dimen.T_X08);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void bind(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mVar) == null) {
            BarImageView barImageView = this.f42339b;
            if (barImageView != null) {
                barImageView.startLoad(mVar.f25082f, 10, false);
            }
            SymbolEMTextView symbolEMTextView = this.f42340c;
            if (symbolEMTextView != null) {
                symbolEMTextView.setText(mVar.f25083g + this.f42340c.getContext().getString(R.string.forum));
            }
            TextView textView = this.f42341d;
            if (textView != null) {
                textView.setText(mVar.f25084h);
            }
            if (this.f42342e != null) {
                if (mVar.f25085i) {
                    b bVar = new b();
                    bVar.p(R.color.CAM_X0903, R.color.CAM_X0109);
                    this.f42342e.setConfig(bVar);
                    TBSpecificationBtn tBSpecificationBtn = this.f42342e;
                    tBSpecificationBtn.setText(tBSpecificationBtn.getContext().getString(R.string.followed));
                    return;
                }
                b bVar2 = new b();
                bVar2.s(c.e(this.f42343f));
                this.f42342e.setConfig(bVar2);
                TBSpecificationBtn tBSpecificationBtn2 = this.f42342e;
                tBSpecificationBtn2.setText(tBSpecificationBtn2.getContext().getString(R.string.frs_like_forum));
            }
        }
    }

    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = this.a;
            if (linearLayout != null) {
                c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(linearLayout);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0201);
            }
            SymbolEMTextView symbolEMTextView = this.f42340c;
            if (symbolEMTextView != null) {
                c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(symbolEMTextView);
                d3.A(R.string.F_X01);
                d3.v(R.color.CAM_X0105);
            }
            TextView textView = this.f42341d;
            if (textView != null) {
                c.a.q0.r.v.c.d(textView).v(R.color.CAM_X0109);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f42342e;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    public void setLikeClickListener(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (tBSpecificationBtn = this.f42342e) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }
}
