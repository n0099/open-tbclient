package com.baidu.tieba.frs.itemtab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.s.v.c;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class FrsItemAcceleratorView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PLACE_HOLDER_WEIGHT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f43894e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43895f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f43896g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43897h;

    /* renamed from: i  reason: collision with root package name */
    public View f43898i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f43899j;
    public String k;
    public CustomMessageListener l;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsItemAcceleratorView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrsItemAcceleratorView frsItemAcceleratorView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsItemAcceleratorView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && !l.z()) {
                this.a.changeBtnDescNormal();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f();
            c();
            b();
            e();
            d();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f43895f = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(n.f(getContext(), d1.M_W_X004), 0, 0, 0);
            this.f43895f.setLayoutParams(layoutParams);
            c.d(this.f43895f).z(d1.T_X07);
            this.f43895f.setText(i1.accelerator_desc);
            addView(this.f43895f);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43894e = new ImageView(getContext());
            this.f43894e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            WebPManager.setMaskDrawable(this.f43894e, e1.icon_mask_wo_list_speed26android, null);
            addView(this.f43894e);
        }
    }

    public void changeBtnDescDoing() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (textView = this.f43897h) == null) {
            return;
        }
        textView.setText(i1.accelerator_btn_desc_doing);
    }

    public void changeBtnDescNormal() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (textView = this.f43897h) == null) {
            return;
        }
        textView.setText(i1.accelerator_btn_desc_normal);
    }

    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (StringUtils.isNull(this.k)) {
                c d2 = c.d(this.f43896g);
                d2.n(i1.J_X07);
                d2.f(c1.CAM_X0303);
            } else {
                c d3 = c.d(this.f43896g);
                d3.n(i1.J_X07);
                d3.g(c.a.u0.z3.c.e(this.k));
            }
            c.d(this.f43897h).x(c1.CAM_X0101);
            c.d(this.f43898i).f(c1.CAM_X0617);
            c d4 = c.d(this);
            d4.n(i1.J_X06);
            d4.f(c1.CAM_X0201);
            c.d(this.f43895f).v(c1.CAM_X0105);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f43896g = new LinearLayout(getContext());
            this.f43896g.setLayoutParams(new LinearLayout.LayoutParams(-2, n.f(getContext(), d1.tbds75)));
            this.f43896g.setOrientation(0);
            this.f43896g.setGravity(16);
            addView(this.f43896g);
            this.f43897h = new TextView(getContext());
            this.f43897h.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.f43897h.setGravity(16);
            this.f43897h.setPadding(n.f(getContext(), d1.M_W_X006), 0, n.f(getContext(), d1.M_W_X005), 0);
            c.d(this.f43897h).z(d1.T_X08);
            this.f43897h.setText(i1.accelerator_btn_desc_normal);
            this.f43896g.addView(this.f43897h);
            this.f43898i = new View(getContext());
            this.f43898i.setLayoutParams(new LinearLayout.LayoutParams(n.f(getContext(), d1.tbds3), n.f(getContext(), d1.tbds29)));
            this.f43896g.addView(this.f43898i);
            this.f43899j = new ImageView(getContext());
            this.f43899j.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.f43899j.setPadding(n.f(getContext(), d1.M_W_X005), 0, n.f(getContext(), d1.M_W_X006), 0);
            WebPManager.setPureDrawable(this.f43899j, e1.icon_pure_unfold10, c1.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.f43896g.addView(this.f43899j);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View view = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            addView(view);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n.f(getContext(), d1.tbds146));
            layoutParams.setMargins(0, n.f(getContext(), d1.M_H_X003), 0, 0);
            setLayoutParams(layoutParams);
            setGravity(16);
            setPadding(n.f(getContext(), d1.M_W_X005), 0, n.f(getContext(), d1.M_W_X005), 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.l);
            if (l.z()) {
                return;
            }
            changeBtnDescNormal();
            TbSingleton.getInstance().acceleratorItemId = -1L;
            TbSingleton.getInstance().acceleratorData = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void setBtnColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.k = str;
        }
    }

    public void setBtnDescClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f43897h.setOnClickListener(onClickListener);
        }
    }

    public void setBtnImgClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.f43899j.setOnClickListener(onClickListener);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsItemAcceleratorView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.l = new a(this, 2000994);
        a();
    }
}
