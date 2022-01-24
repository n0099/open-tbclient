package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.s0.s.q.x0;
import c.a.t0.k.c;
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
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class NEGFeedBackView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TID = "tid";
    public static final int MIN_CLICK_ENABLE_DELAY = 500;
    public static final int NEG_FEEDBACK_LIST_ITEM_DYNAMIC_TIME = 300;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f41653e;

    /* renamed from: f  reason: collision with root package name */
    public long f41654f;

    /* renamed from: g  reason: collision with root package name */
    public int f41655g;

    /* renamed from: h  reason: collision with root package name */
    public int f41656h;

    /* renamed from: i  reason: collision with root package name */
    public int f41657i;

    /* renamed from: j  reason: collision with root package name */
    public int f41658j;
    public int k;
    public c l;
    public View.OnClickListener m;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NEGFeedBackView f41659e;

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
            this.f41659e = nEGFeedBackView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(j.a(this.f41659e.getContext()), null)) {
                return;
            }
            this.f41659e.dismissPopupWindow();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f41659e.f41654f > 500) {
                this.f41659e.i(view);
            }
            this.f41659e.f41654f = currentTimeMillis;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var);

        void onNEGFeedbackWindowShow(x0 x0Var);
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
        this.f41654f = 0L;
        this.f41658j = R.drawable.icon_pure_card_more22;
        this.k = R.color.CAM_X0111;
        this.m = new a(this);
        this.f41653e = tbPageContext.getPageActivity();
        h(tbPageContext);
    }

    public void attachToViewUpperRightConner(ViewGroup viewGroup, int i2, int i3) {
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

    public void attachToViewUpperRightConnerFromFrsLive(ViewGroup viewGroup, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, i3) == null) {
            int f2 = n.f(this.f41653e, R.dimen.tbds24);
            setPadding(i3, 0, i3, 0);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i2);
                layoutParams.addRule(11);
                layoutParams.addRule(15);
                layoutParams.rightMargin = f2;
                viewGroup.addView(this, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
                layoutParams2.gravity = 53;
                viewGroup.addView(this, layoutParams2);
            }
        }
    }

    public void dismissPopupWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.l.l();
        }
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            this.l = new c(tbPageContext, this);
            setOnClickListener(this.m);
            setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            onChangeSkinType();
        }
    }

    public final void i(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.l.B(view);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setImageDrawable(WebPManager.getPureDrawable(this.f41658j, SkinManager.getColor(this.k), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            this.l.r();
        }
    }

    public void resetWebPResId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i2 = R.drawable.icon_pure_card_more22;
            this.f41658j = i2;
            int i3 = R.color.CAM_X0111;
            this.k = i3;
            setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void setACRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void setAutoProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l.u(z);
        }
    }

    public void setCWRotateAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void setData(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, x0Var) == null) {
            this.l.v(x0Var);
        }
    }

    public void setDefaultLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            onChangeSkinType();
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, strArr) == null) {
            this.l.w(strArr);
        }
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.l.x(bVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.l.y(z);
        }
    }

    public void setHeadText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.l.z(str);
        }
    }

    public void setLeftPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f41655g = i2;
            setPadding(i2, this.f41657i, this.f41656h, 0);
        }
    }

    public void setRightPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f41656h = i2;
            setPadding(this.f41655g, this.f41657i, i2, 0);
        }
    }

    public void setTopPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f41657i = i2;
            setPadding(this.f41655g, i2, this.f41656h, 0);
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) {
            this.l.A(bdUniqueId);
        }
    }

    public void setWebPResId(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            this.f41658j = i2;
            this.k = i3;
            setImageDrawable(WebPManager.getPureDrawable(i2, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void showWithNone(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.l.C(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackView(TbPageContext tbPageContext, AttributeSet attributeSet) {
        super(tbPageContext.getPageActivity(), attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, attributeSet};
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
        this.f41654f = 0L;
        this.f41658j = R.drawable.icon_pure_card_more22;
        this.k = R.color.CAM_X0111;
        this.m = new a(this);
        this.f41653e = tbPageContext.getPageActivity();
        h(tbPageContext);
    }

    public void attachToViewUpperRightConner(ViewGroup viewGroup, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, i3, i4) == null) && (viewGroup instanceof FrameLayout)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
            layoutParams.rightMargin = i3;
            layoutParams.bottomMargin = i4;
            layoutParams.gravity = 85;
            viewGroup.addView(this, layoutParams);
        }
    }
}
