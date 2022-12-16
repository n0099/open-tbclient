package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.q57;
import com.baidu.tieba.ry4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public BdUniqueId g;
    public int h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipView(Context context) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipView(Context context, AttributeSet attributeSet, int i) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.h = yi.g(getContext(), R.dimen.tbds94);
            this.i = 0 - yi.g(getContext(), R.dimen.tbds18);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01fb, (ViewGroup) this, true);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0906e9);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906e4);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906e5);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0906e6);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0906e7);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906e8);
            setPadding(0, 0, 0, yi.g(context, R.dimen.tbds44));
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.a, R.drawable.icon_home_card_delete);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.g = bdUniqueId;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setData(q57 q57Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, q57Var) != null) || q57Var == null) {
            return;
        }
        if (!q57Var.a()) {
            setVisibility(8);
            return;
        }
        if (q57Var.c > 0) {
            ry4.l().y(ry4.p("concern_unread_tip_next_show_time"), System.currentTimeMillis() + q57Var.c);
        }
        if (this.d != null && !StringUtils.isNull(q57Var.d)) {
            this.d.setText(q57Var.d);
        }
        LinearLayout linearLayout = this.c;
        if (linearLayout != null && q57Var.b != null) {
            linearLayout.removeAllViews();
            List<String> list = q57Var.b;
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!StringUtils.isNull(str)) {
                    FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d01fa, null);
                    int i2 = this.h;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                    if (i > 0) {
                        layoutParams.leftMargin = this.i;
                    }
                    frameLayout.setLayoutParams(layoutParams);
                    HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f090fb8);
                    headImageView.setIsRound(true);
                    headImageView.setDrawBorder(false);
                    SkinManager.setImageResource((ImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091817), R.drawable.bg_unread_tip_head_border);
                    this.c.addView(frameLayout);
                    headImageView.setPageId(this.g);
                    headImageView.K(str, 12, false);
                }
            }
        }
    }
}
