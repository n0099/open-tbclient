package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h9;
import com.repackage.hj5;
import com.repackage.kp4;
import com.repackage.pi;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NEGFeedBackView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public hj5 h;
    public View.OnClickListener i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NEGFeedBackView a;

        public a(NEGFeedBackView nEGFeedBackView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nEGFeedBackView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nEGFeedBackView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(h9.a(this.a.getContext()), null)) {
                return;
            }
            this.a.o();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a.b > 500) {
                this.a.s(view2);
            }
            this.a.b = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<Integer> arrayList, String str, kp4 kp4Var);

        void b(kp4 kp4Var, CompoundButton compoundButton, boolean z);

        void c(kp4 kp4Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.b = 0L;
        this.f = R.drawable.obfuscated_res_0x7f0808f9;
        this.g = R.color.CAM_X0111;
        this.i = new a(this);
        this.a = tbPageContext.getPageActivity();
        p(tbPageContext);
    }

    public void m(ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, viewGroup, i, i2) == null) {
            setPadding(0, i2, i2, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void n(ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, i2) == null) {
            int f = pi.f(this.a, R.dimen.tbds24);
            setPadding(i2, 0, i2, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                layoutParams.rightMargin = f;
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h.l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.h.r();
        }
    }

    public final void p(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.h = new hj5(tbPageContext, this);
            setOnClickListener(this.i);
            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            q();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setImageDrawable(WebPManager.getPureDrawable(this.f, SkinManager.getColor(this.g), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            this.h.B(view2);
        }
    }

    public void setACRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void setAutoProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h.u(z);
        }
    }

    public void setCWRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void setData(kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kp4Var) == null) {
            this.h.v(kp4Var);
        }
    }

    public void setDefaultLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            q();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, strArr) == null) {
            this.h.w(strArr);
        }
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.h.x(bVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.h.y(z);
        }
    }

    public void setHeadText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.h.z(str);
        }
    }

    public void setLeftPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.c = i;
            setPadding(i, this.e, this.d, 0);
        }
    }

    public void setRightPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.d = i;
            setPadding(this.c, this.e, i, 0);
        }
    }

    public void setTopPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.e = i;
            setPadding(this.c, i, this.d, 0);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            this.h.A(bdUniqueId);
        }
    }

    public void setWebPResId(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            this.f = i;
            this.g = i2;
            setImageDrawable(WebPManager.getPureDrawable(i, SkinManager.getColor(i2), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.h.C(z);
        }
    }
}
