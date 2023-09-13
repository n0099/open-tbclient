package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
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
    public Context b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;

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
        this.b = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0358, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_broadcast_guide_main);
            this.a = linearLayout;
            this.c = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090c7a);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c78);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090edb);
            this.f = (TextView) this.a.findViewById(R.id.to_next_tv);
            this.c.setText(R.string.obfuscated_res_0x7f0f0782);
            this.d.setText(R.string.obfuscated_res_0x7f0f0781);
            this.f.setText(R.string.obfuscated_res_0x7f0f048e);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0302);
            SkinManager.setImageResource(this.e, R.drawable.pic_frs_guide_copylink);
            TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.CAM_X0211).blRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds30)).brRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds30)).tlRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds32)).trRadius(BdUtilHelper.getDimens(this.b, R.dimen.tbds32)).into(this.a);
        }
    }

    public void setConfirmButtonListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) && onClickListener != null) {
            this.f.setOnClickListener(onClickListener);
        }
    }
}
