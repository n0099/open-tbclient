package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bk5 extends zj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NestedScrollView a;
    public LinearLayout b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TBSpecificationBtn f;
    public LinearLayout g;
    public int h;
    public Rect i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk5 a;

        public a(bk5 bk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(-1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk5(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 0;
        this.i = new Rect();
        this.a = (NestedScrollView) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0921de);
        this.b = (LinearLayout) this.attachedView.findViewById(R.id.obfuscated_res_0x7f0907f7);
        this.c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        e65 e65Var = new e65();
        e65Var.s(R.color.CAM_X0304, R.color.CAM_X0905);
        this.f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f.setTextSize(R.dimen.tbds42);
        this.f.setConfig(e65Var);
        this.f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.h <= 0) {
                this.h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            NestedScrollView nestedScrollView = this.a;
            if (nestedScrollView == null) {
                return;
            }
            if (i == 0) {
                nestedScrollView.post(new a(this));
            }
            if (!this.a.getLocalVisibleRect(this.i)) {
                return;
            }
            int i2 = this.i.bottom;
            int abs = Math.abs(this.b.getTop());
            int abs2 = i2 - Math.abs(this.b.getBottom());
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = this.h;
            if (abs < i3) {
                marginLayoutParams.topMargin = i3;
                this.b.setLayoutParams(marginLayoutParams);
            } else if (abs == i3) {
                if (abs2 > i3) {
                    marginLayoutParams.topMargin = i3 + ((abs2 - i3) / 2);
                    this.b.setLayoutParams(marginLayoutParams);
                }
            } else if (abs > i3) {
                if (abs2 < i3) {
                    marginLayoutParams.topMargin = i3;
                } else if (abs2 == i3) {
                    marginLayoutParams.topMargin = i3;
                } else if (abs2 > i3) {
                    marginLayoutParams.topMargin = (abs + abs2) / 2;
                }
                this.b.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || str == null) {
            return;
        }
        this.f.setText(str);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str == null) {
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.d.setText(str);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || str == null) {
            return;
        }
        this.e.setText(str);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0109, 1);
        }
    }

    public View getAttachedView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.attachedView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zj5
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.zj5
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onViewDettached();
            this.c.setImageResource(0);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.c, R.drawable.new_pic_emotion_08);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0107, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            TBSpecificationBtn tBSpecificationBtn = this.f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }
}
