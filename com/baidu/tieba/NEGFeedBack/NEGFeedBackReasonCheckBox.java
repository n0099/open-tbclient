package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import c.a.e.e.p.l;
import c.a.r0.j3.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49055e;

    /* renamed from: f  reason: collision with root package name */
    public int f49056f;

    /* renamed from: g  reason: collision with root package name */
    public GradientDrawable f49057g;

    /* renamed from: h  reason: collision with root package name */
    public GradientDrawable f49058h;

    /* renamed from: i  reason: collision with root package name */
    public GradientDrawable f49059i;

    /* renamed from: j  reason: collision with root package name */
    public StateListDrawable f49060j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NEGFeedBackReasonCheckBox f49061a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nEGFeedBackReasonCheckBox, Integer.valueOf(i2)};
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
            this.f49061a = nEGFeedBackReasonCheckBox;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f49061a.changeSkinType();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackReasonCheckBox(Context context) {
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
        this.f49055e = null;
        this.f49056f = 3;
        this.k = new a(this, 2001304);
        this.f49055e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int g2 = l.g(this.f49055e, R.dimen.ds24);
            setPadding(g2, 0, g2, 0);
            setButtonDrawable((Drawable) null);
        }
    }

    public final void b(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i2).split(",")[0]);
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.f49057g = gradientDrawable;
            gradientDrawable.setShape(0);
            float f2 = parseInt;
            this.f49057g.setCornerRadius(f2);
            this.f49057g.setStroke(i3, SkinManager.getColor(i4));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.f49058h = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.f49058h.setCornerRadius(f2);
            this.f49058h.setStroke(i3, c.a(SkinManager.getColor(i5), SkinManager.RESOURCE_ALPHA_PRESS));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            this.f49059i = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.f49059i.setCornerRadius(f2);
            this.f49059i.setStroke(i3, c.a(SkinManager.getColor(i6), SkinManager.RESOURCE_ALPHA_DISABLE));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f49060j = stateListDrawable;
            stateListDrawable.addState(new int[]{16842912}, this.f49058h);
            this.f49060j.addState(new int[]{-16842910}, this.f49059i);
            this.f49060j.addState(new int[0], this.f49057g);
            setBackgroundDrawable(this.f49060j);
        }
    }

    public void changeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f49056f) {
            return;
        }
        b(R.string.J_X07, l.g(this.f49055e, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0302, R.color.CAM_X0902);
        SkinManager.setViewCheckedTextColorSelector(this, R.color.CAM_X0105, R.color.CAM_X0302, R.color.CAM_X0105);
        this.f49056f = skinType;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet) {
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
        this.f49055e = null;
        this.f49056f = 3;
        this.k = new a(this, 2001304);
        this.f49055e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet, int i2) {
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
        this.f49055e = null;
        this.f49056f = 3;
        this.k = new a(this, 2001304);
        this.f49055e = context;
        a();
    }
}
