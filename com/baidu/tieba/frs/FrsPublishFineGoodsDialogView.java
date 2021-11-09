package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.q0.s.w.b.d;
import b.a.r0.x0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f48301e;

    /* renamed from: f  reason: collision with root package name */
    public Context f48302f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48303g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48304h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48305i;
    public LocalBannerLayout j;
    public d k;

    /* loaded from: classes9.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsPublishFineGoodsDialogView f48306a;

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
            this.f48306a = frsPublishFineGoodsDialogView;
        }

        @Override // b.a.q0.s.w.b.d
        public void a(int i2, b.a.q0.s.w.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                this.f48306a.c(i2);
            }
        }

        @Override // b.a.q0.s.w.b.d
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
        this.f48302f = context;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.frs_publish_major_fine_goods_dialog, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
            this.f48301e = linearLayout;
            this.f48303g = (TextView) linearLayout.findViewById(R.id.frs_shop_guide_title);
            this.f48304h = (TextView) this.f48301e.findViewById(R.id.frs_shop_guide_content);
            this.j = (LocalBannerLayout) this.f48301e.findViewById(R.id.banner_layout);
            TextView textView = (TextView) this.f48301e.findViewById(R.id.to_next_tv);
            this.f48305i = textView;
            textView.setText(R.string.forum_broadcast_major_history_known);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide1)));
            arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide2)));
            arrayList.add(new h(String.valueOf(R.drawable.pic_good_guide3)));
            this.j.setData(arrayList);
            this.j.setOnCoverViewCallback(this.k);
            SkinManager.setViewTextColor(this.f48303g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f48304h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f48305i, R.color.CAM_X0302);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(l.g(this.f48302f, R.dimen.tbds30)).brRadius(l.g(this.f48302f, R.dimen.tbds30)).tlRadius(l.g(this.f48302f, R.dimen.tbds32)).trRadius(l.g(this.f48302f, R.dimen.tbds32)).into(this.f48301e);
        }
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == 0 || i2 == 3) {
                this.f48303g.setText(getResources().getString(R.string.frs_goods_dialog_first_title));
                this.f48304h.setText(getResources().getString(R.string.frs_goods_dialog_first_content));
            } else if (i2 == 1) {
                this.f48303g.setText(getResources().getString(R.string.frs_goods_dialog_second_title));
                this.f48304h.setText(getResources().getString(R.string.frs_goods_dialog_second_content));
            } else if (i2 == 2) {
                this.f48303g.setText(getResources().getString(R.string.frs_goods_dialog_third_title));
                this.f48304h.setText(getResources().getString(R.string.frs_goods_dialog_third_content));
            }
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f48305i.setOnClickListener(onClickListener);
    }
}
