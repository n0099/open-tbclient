package com.baidu.tieba.forumMember.bawu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BawuManagerApplyInfoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f43971e;

    /* renamed from: f  reason: collision with root package name */
    public View f43972f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43973g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43974h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f43975i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuManagerApplyInfoView(Context context) {
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
        this.f43971e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f43971e).inflate(R.layout.bawu_manager_apply_layout, this);
            this.f43972f = inflate;
            this.f43973g = (TextView) inflate.findViewById(R.id.imageview_apply_btn);
            this.f43974h = (TextView) this.f43972f.findViewById(R.id.textview_manager_apply);
            this.f43975i = (TextView) this.f43972f.findViewById(R.id.textview_manager_left_num);
        }
    }

    public void fillView(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            this.f43974h.setText(str);
            this.f43973g.setBackgroundDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_ba_add_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS_DISABLE));
            if (i2 > 0) {
                this.f43975i.setText(String.format(this.f43971e.getResources().getString(R.string.apply_left_num_tip), StringHelper.numberUniformFormat(i2)));
                this.f43973g.setEnabled(true);
                this.f43973g.setClickable(true);
                SkinManager.setViewTextColor(this.f43974h, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.f43975i, R.color.CAM_X0305, 1);
                return;
            }
            this.f43975i.setText(this.f43971e.getResources().getString(R.string.apply_no_left_tip));
            this.f43973g.setEnabled(false);
            this.f43973g.setClickable(false);
            SkinManager.setViewTextColor(this.f43974h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.f43975i, R.color.CAM_X0109, 1);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f43973g.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet) {
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
        this.f43971e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuManagerApplyInfoView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f43971e = context;
        a();
    }
}
