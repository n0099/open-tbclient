package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.s.w.b.d;
import c.a.r0.x0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f50942e;

    /* renamed from: f  reason: collision with root package name */
    public Context f50943f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50944g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50945h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50946i;

    /* renamed from: j  reason: collision with root package name */
    public LocalBannerLayout f50947j;
    public d k;

    /* loaded from: classes7.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsPublishFineGoodsDialogView f50948a;

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
            this.f50948a = frsPublishFineGoodsDialogView;
        }

        @Override // c.a.q0.s.w.b.d
        public void a(int i2, c.a.q0.s.w.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                this.f50948a.c(i2);
            }
        }

        @Override // c.a.q0.s.w.b.d
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
        this.f50943f = context;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
            this.f50942e = linearLayout;
            this.f50944g = (TextView) linearLayout.findViewById(R.id.frs_shop_guide_title);
            this.f50945h = (TextView) this.f50942e.findViewById(R.id.frs_shop_guide_content);
            this.f50947j = (LocalBannerLayout) this.f50942e.findViewById(R.id.banner_layout);
            TextView textView = (TextView) this.f50942e.findViewById(R.id.to_next_tv);
            this.f50946i = textView;
            textView.setText(R.string.forum_broadcast_major_history_known);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
            arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
            arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
            this.f50947j.setData(arrayList);
            this.f50947j.setOnCoverViewCallback(this.k);
            SkinManager.setViewTextColor(this.f50944g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f50945h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f50946i, R.color.CAM_X0302);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f50943f, R.dimen.tbds30)).brRadius(l.g(this.f50943f, R.dimen.tbds30)).tlRadius(l.g(this.f50943f, R.dimen.tbds32)).trRadius(l.g(this.f50943f, R.dimen.tbds32)).into(this.f50942e);
        }
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == 0 || i2 == 3) {
                this.f50944g.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
                this.f50945h.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
            } else if (i2 == 1) {
                this.f50944g.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
                this.f50945h.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
            } else if (i2 == 2) {
                this.f50944g.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
                this.f50945h.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
            }
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f50946i.setOnClickListener(onClickListener);
    }
}
