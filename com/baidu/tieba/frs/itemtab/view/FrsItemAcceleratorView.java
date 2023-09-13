package com.baidu.tieba.frs.itemtab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsItemAcceleratorView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public View e;
    public ImageView f;
    public String g;
    public CustomMessageListener h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemAcceleratorView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsItemAcceleratorView frsItemAcceleratorView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemAcceleratorView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsItemAcceleratorView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && !BdNetTypeUtil.isNetWorkAvailable()) {
                this.a.b();
                TbSingleton.getInstance().acceleratorItemId = -1L;
                TbSingleton.getInstance().acceleratorData = null;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.h = new a(this, 2000994);
        d();
    }

    public void a() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (textView = this.d) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f005b);
        }
    }

    public void b() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (textView = this.d) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f005c);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i();
            f();
            e();
            h();
            g();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View view2 = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            view2.setLayoutParams(layoutParams);
            addView(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (StringUtils.isNull(this.g)) {
                EMManager.from(this.c).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0303);
            } else {
                EMManager.from(this.c).setCorner(R.string.J_X07).setBackGroundRealColor(zfa.f(this.g));
            }
            EMManager.from(this.d).setTextSelectorColor(R.color.CAM_X0101);
            EMManager.from(this.e).setBackGroundColor(R.color.CAM_X0617);
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.b).setTextColor(R.color.CAM_X0105);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), 0, 0, 0);
            this.b.setLayoutParams(layoutParams);
            EMManager.from(this.b).setTextSize(R.dimen.T_X07);
            this.b.setText(R.string.obfuscated_res_0x7f0f0061);
            addView(this.b);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.tbds146));
            layoutParams.setMargins(0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003), 0, 0);
            setLayoutParams(layoutParams);
            setGravity(16);
            setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), 0);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = new ImageView(getContext());
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            WebPManager.setMaskDrawable(this.a, R.drawable.obfuscated_res_0x7f080a64, null);
            addView(this.a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.h);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                b();
                TbSingleton.getInstance().acceleratorItemId = -1L;
                TbSingleton.getInstance().acceleratorData = null;
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = new LinearLayout(getContext());
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds75)));
            this.c.setOrientation(0);
            this.c.setGravity(16);
            addView(this.c);
            this.d = new TextView(getContext());
            this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.d.setGravity(16);
            this.d.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), 0);
            EMManager.from(this.d).setTextSize(R.dimen.T_X08);
            this.d.setText(R.string.obfuscated_res_0x7f0f005c);
            this.c.addView(this.d);
            this.e = new View(getContext());
            this.e.setLayoutParams(new LinearLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds3), BdUtilHelper.getDimens(getContext(), R.dimen.tbds29)));
            this.c.addView(this.e);
            this.f = new ImageView(getContext());
            this.f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.f.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005), 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), 0);
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080c43, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.c.addView(this.f);
        }
    }

    public void setBtnColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.g = str;
        }
    }

    public void setBtnDescClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void setBtnImgClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.f.setOnClickListener(onClickListener);
        }
    }
}
