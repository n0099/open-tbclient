package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.x.b.d;
import c.a.p0.f1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsPublishFineGoodsDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public Context f32305b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32306c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32307d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32308e;

    /* renamed from: f  reason: collision with root package name */
    public LocalBannerLayout f32309f;

    /* renamed from: g  reason: collision with root package name */
    public d f32310g;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsPublishFineGoodsDialogView;
        }

        @Override // c.a.o0.r.x.b.d
        public void a(int i, c.a.o0.r.x.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, aVar) == null) {
                this.a.c(i);
            }
        }

        @Override // c.a.o0.r.x.b.d
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32310g = new a(this);
        this.f32305b = context;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d034b, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090ad2);
            this.a = linearLayout;
            this.f32306c = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090bcc);
            this.f32307d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bcb);
            this.f32309f = (LocalBannerLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090300);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092082);
            this.f32308e = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0645);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h(String.valueOf((int) R.drawable.pic_good_guide1)));
            arrayList.add(new h(String.valueOf((int) R.drawable.pic_good_guide2)));
            arrayList.add(new h(String.valueOf((int) R.drawable.pic_good_guide3)));
            this.f32309f.setData(arrayList);
            this.f32309f.setOnCoverViewCallback(this.f32310g);
            SkinManager.setViewTextColor(this.f32306c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f32307d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f32308e, (int) R.color.CAM_X0302);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(n.f(this.f32305b, R.dimen.tbds30)).brRadius(n.f(this.f32305b, R.dimen.tbds30)).tlRadius(n.f(this.f32305b, R.dimen.tbds32)).trRadius(n.f(this.f32305b, R.dimen.tbds32)).into(this.a);
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 0 || i == 3) {
                this.f32306c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06e4));
                this.f32307d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06e3));
            } else if (i == 1) {
                this.f32306c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06e6));
                this.f32307d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06e5));
            } else if (i == 2) {
                this.f32306c.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06e8));
                this.f32307d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f06e7));
            }
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f32308e.setOnClickListener(onClickListener);
    }
}
