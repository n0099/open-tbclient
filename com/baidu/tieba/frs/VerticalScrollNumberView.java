package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.digest4util.Sha2Crypt;
/* loaded from: classes4.dex */
public class VerticalScrollNumberView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollNumberView(Context context) {
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
        this.a = null;
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            this.b = fj.f(context, R.dimen.obfuscated_res_0x7f070201);
            this.c = fj.f(this.a, R.dimen.obfuscated_res_0x7f070225);
            this.d = fj.f(this.a, R.dimen.obfuscated_res_0x7f0701d4);
            this.e = fj.f(this.a, R.dimen.obfuscated_res_0x7f070302);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        b(context);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ScrollTextView scrollTextView = new ScrollTextView(this.a);
            scrollTextView.setText(str);
            scrollTextView.setGravity(17);
            SkinManager.setBackgroundResource(scrollTextView, R.drawable.lottery_number_bg);
            SkinManager.setViewTextColor(scrollTextView, (int) R.color.CAM_X0111);
            scrollTextView.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9));
            scrollTextView.setTypeface(null, 1);
            scrollTextView.setMinLines(1);
            scrollTextView.setMaxLines(1);
            scrollTextView.setContinuousScrolling(false);
            scrollTextView.setSpeed((float) ((Math.random() * 5.0d) + 10.0d));
            scrollTextView.setWidth(this.b);
            scrollTextView.setHeight(this.c);
            addView(scrollTextView);
        }
    }

    public void setData(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (getChildCount() > 0) {
                removeAllViews();
            }
            if (i < 0) {
                i = 0;
            }
            if (i > 999999999) {
                i = Sha2Crypt.ROUNDS_MAX;
            }
            String valueOf = String.valueOf(i);
            for (int i2 = 0; i2 != valueOf.length(); i2++) {
                a(StringUtils.string("0\n", Character.valueOf(valueOf.charAt(i2))));
            }
            int i3 = 0;
            for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
                if (getChildAt(childCount) instanceof ScrollTextView) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i3 == 2) {
                        layoutParams.setMargins(this.e, 0, 0, 0);
                        i3 = 0;
                    } else {
                        layoutParams.setMargins(this.d, 0, 0, 0);
                        i3++;
                    }
                    getChildAt(childCount).setLayoutParams(layoutParams);
                }
            }
        }
    }
}
