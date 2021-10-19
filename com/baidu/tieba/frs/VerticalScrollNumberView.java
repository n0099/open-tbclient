package com.baidu.tieba.frs;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ScrollTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.digest4util.Sha2Crypt;
/* loaded from: classes7.dex */
public class VerticalScrollNumberView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String START_NUMBER = "0\n";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51001e;

    /* renamed from: f  reason: collision with root package name */
    public int f51002f;

    /* renamed from: g  reason: collision with root package name */
    public int f51003g;

    /* renamed from: h  reason: collision with root package name */
    public int f51004h;

    /* renamed from: i  reason: collision with root package name */
    public int f51005i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollNumberView(Context context) {
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
        this.f51001e = null;
        b(context);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ScrollTextView scrollTextView = new ScrollTextView(this.f51001e);
            scrollTextView.setText(str);
            scrollTextView.setGravity(17);
            SkinManager.setBackgroundResource(scrollTextView, R.drawable.lottery_number_bg);
            SkinManager.setViewTextColor(scrollTextView, R.color.CAM_X0111);
            scrollTextView.setTextSize(0, getResources().getDimension(R.dimen.ds28));
            scrollTextView.setTypeface(null, 1);
            scrollTextView.setMinLines(1);
            scrollTextView.setMaxLines(1);
            scrollTextView.setContinuousScrolling(false);
            scrollTextView.setSpeed((float) ((Math.random() * 5.0d) + 10.0d));
            scrollTextView.setWidth(this.f51002f);
            scrollTextView.setHeight(this.f51003g);
            addView(scrollTextView);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f51001e = context;
            this.f51002f = l.g(context, R.dimen.ds30);
            this.f51003g = l.g(this.f51001e, R.dimen.ds40);
            this.f51004h = l.g(this.f51001e, R.dimen.ds2);
            this.f51005i = l.g(this.f51001e, R.dimen.ds8);
        }
    }

    public void setData(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (getChildCount() > 0) {
                removeAllViews();
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 999999999) {
                i2 = Sha2Crypt.ROUNDS_MAX;
            }
            String valueOf = String.valueOf(i2);
            for (int i3 = 0; i3 != valueOf.length(); i3++) {
                a(StringUtils.string(START_NUMBER, Character.valueOf(valueOf.charAt(i3))));
            }
            int i4 = 0;
            for (int childCount = getChildCount() - 1; childCount != 0; childCount--) {
                if (getChildAt(childCount) instanceof ScrollTextView) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i4 == 2) {
                        layoutParams.setMargins(this.f51005i, 0, 0, 0);
                        i4 = 0;
                    } else {
                        layoutParams.setMargins(this.f51004h, 0, 0, 0);
                        i4++;
                    }
                    getChildAt(childCount).setLayoutParams(layoutParams);
                }
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51001e = null;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalScrollNumberView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51001e = null;
        b(context);
    }
}
