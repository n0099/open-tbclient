package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.s.x.b.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f43361e;

    /* renamed from: f  reason: collision with root package name */
    public Context f43362f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43363g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43364h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43365i;

    /* renamed from: j  reason: collision with root package name */
    public LocalBannerLayout f43366j;
    public d k;

    /* loaded from: classes12.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsPublishFineGoodsDialogView a;

        public a(FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPublishFineGoodsDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsPublishFineGoodsDialogView;
        }

        @Override // c.a.t0.s.x.b.d
        public void a(int i2, c.a.t0.s.x.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                this.a.c(i2);
            }
        }

        @Override // c.a.t0.s.x.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPublishFineGoodsDialogView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.k = new a(this);
        this.f43362f = context;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(h.frs_publish_major_fine_goods_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(g.frs_broadcast_guide_main);
            this.f43361e = linearLayout;
            this.f43363g = (TextView) linearLayout.findViewById(g.frs_shop_guide_title);
            this.f43364h = (TextView) this.f43361e.findViewById(g.frs_shop_guide_content);
            this.f43366j = (LocalBannerLayout) this.f43361e.findViewById(g.banner_layout);
            TextView textView = (TextView) this.f43361e.findViewById(g.to_next_tv);
            this.f43365i = textView;
            textView.setText(j.forum_broadcast_major_history_known);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.u0.e1.h(String.valueOf(f.pic_good_guide1)));
            arrayList.add(new c.a.u0.e1.h(String.valueOf(f.pic_good_guide2)));
            arrayList.add(new c.a.u0.e1.h(String.valueOf(f.pic_good_guide3)));
            this.f43366j.setData(arrayList);
            this.f43366j.setOnCoverViewCallback(this.k);
            SkinManager.setViewTextColor(this.f43363g, c.a.u0.a4.d.CAM_X0105);
            SkinManager.setViewTextColor(this.f43364h, c.a.u0.a4.d.CAM_X0109);
            SkinManager.setViewTextColor(this.f43365i, c.a.u0.a4.d.CAM_X0302);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(c.a.u0.a4.d.CAM_X0211).blRadius(n.f(this.f43362f, e.tbds30)).brRadius(n.f(this.f43362f, e.tbds30)).tlRadius(n.f(this.f43362f, e.tbds32)).trRadius(n.f(this.f43362f, e.tbds32)).into(this.f43361e);
        }
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == 0 || i2 == 3) {
                this.f43363g.setText(getResources().getString(j.frs_goods_dialog_first_title));
                this.f43364h.setText(getResources().getString(j.frs_goods_dialog_first_content));
            } else if (i2 == 1) {
                this.f43363g.setText(getResources().getString(j.frs_goods_dialog_second_title));
                this.f43364h.setText(getResources().getString(j.frs_goods_dialog_second_content));
            } else if (i2 == 2) {
                this.f43363g.setText(getResources().getString(j.frs_goods_dialog_third_title));
                this.f43364h.setText(getResources().getString(j.frs_goods_dialog_third_content));
            }
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f43365i.setOnClickListener(onClickListener);
    }
}
