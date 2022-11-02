package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class au7 extends fu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public ImageView c;

    public au7(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908bc);
        this.b = textView;
        textView.setText(str);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908bd);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0107, i);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_02, i);
            }
            View view2 = this.a;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, i);
            }
        }
    }

    public final void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int j = xi.j(TbadkCoreApplication.getInst());
            if (j <= 0) {
                i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
            } else {
                i = (int) (j * 0.11d);
            }
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.c.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
