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
import d.a.d.a.j;
import d.a.d.e.p.l;
import d.a.p0.s.q.w0;
import d.a.q0.h.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class NEGFeedBackView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13705e;

    /* renamed from: f  reason: collision with root package name */
    public long f13706f;

    /* renamed from: g  reason: collision with root package name */
    public int f13707g;

    /* renamed from: h  reason: collision with root package name */
    public int f13708h;

    /* renamed from: i  reason: collision with root package name */
    public int f13709i;
    public int j;
    public int k;
    public c l;
    public View.OnClickListener m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NEGFeedBackView f13710e;

        public a(NEGFeedBackView nEGFeedBackView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nEGFeedBackView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13710e = nEGFeedBackView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(j.a(this.f13710e.getContext()), null)) {
                return;
            }
            this.f13710e.o();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f13710e.f13706f > 500) {
                this.f13710e.r(view);
            }
            this.f13710e.f13706f = currentTimeMillis;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var);

        void onNEGFeedbackWindowShow(w0 w0Var);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13706f = 0L;
        this.j = R.drawable.icon_pure_card_more22;
        this.k = R.color.CAM_X0111;
        this.m = new a(this);
        this.f13705e = tbPageContext.getPageActivity();
        p(tbPageContext);
    }

    public void l(ViewGroup viewGroup, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, viewGroup, i2, i3) == null) {
            setPadding(0, i3, i3, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void n(ViewGroup viewGroup, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, i3) == null) {
            int g2 = l.g(this.f13705e, R.dimen.tbds24);
            setPadding(i3, 0, i3, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i2);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                layoutParams.rightMargin = g2;
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.l();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            this.l.r();
        }
    }

    public final void p(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.l = new c(tbPageContext, this);
            setOnClickListener(this.m);
            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            q();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setImageDrawable(WebPManager.getPureDrawable(this.j, SkinManager.getColor(this.k), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.l.B(view);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l.C(z);
        }
    }

    public void setACRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void setAutoProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.l.u(z);
        }
    }

    public void setCWRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void setData(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, w0Var) == null) {
            this.l.v(w0Var);
        }
    }

    public void setDefaultLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, strArr) == null) {
            this.l.w(strArr);
        }
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.l.x(bVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.l.y(z);
        }
    }

    public void setHeadText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.l.z(str);
        }
    }

    public void setLeftPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f13707g = i2;
            setPadding(i2, this.f13709i, this.f13708h, 0);
        }
    }

    public void setRightPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f13708h = i2;
            setPadding(this.f13707g, this.f13709i, i2, 0);
        }
    }

    public void setTopPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f13709i = i2;
            setPadding(this.f13707g, i2, this.f13708h, 0);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.l.A(bdUniqueId);
        }
    }

    public void setWebPResId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            this.j = i2;
            this.k = i3;
            setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }
}
