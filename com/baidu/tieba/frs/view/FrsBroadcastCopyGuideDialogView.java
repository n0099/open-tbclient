package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsBroadcastCopyGuideDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public Context f32929b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32930c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32931d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f32932e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32933f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsBroadcastCopyGuideDialogView(Context context) {
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
        this.f32929b = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0309, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090ad2);
            this.a = linearLayout;
            this.f32930c = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090ad3);
            this.f32931d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090ad1);
            this.f32932e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d01);
            this.f32933f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092082);
            this.f32930c.setText(R.string.obfuscated_res_0x7f0f063f);
            this.f32931d.setText(R.string.obfuscated_res_0x7f0f063e);
            this.f32933f.setText(R.string.obfuscated_res_0x7f0f03fa);
            SkinManager.setViewTextColor(this.f32930c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f32931d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f32933f, (int) R.color.CAM_X0302);
            SkinManager.setImageResource(this.f32932e, R.drawable.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(n.f(this.f32929b, R.dimen.tbds30)).brRadius(n.f(this.f32929b, R.dimen.tbds30)).tlRadius(n.f(this.f32929b, R.dimen.tbds32)).trRadius(n.f(this.f32929b, R.dimen.tbds32)).into(this.a);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.f32933f.setOnClickListener(onClickListener);
    }
}
