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
import c.a.d.f.p.n;
import c.a.o0.r.j0.b;
import c.a.p0.q1.i.j.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33395b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f33396c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33397d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33398e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33399f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f33400g;

    /* renamed from: h  reason: collision with root package name */
    public int f33401h;
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f33401h = n.f(getContext(), R.dimen.tbds94);
            this.i = 0 - n.f(getContext(), R.dimen.tbds18);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0200, (ViewGroup) this, true);
            this.f33395b = (TextView) findViewById(R.id.obfuscated_res_0x7f0906b4);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906af);
            this.f33396c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906b0);
            this.f33397d = (TextView) findViewById(R.id.obfuscated_res_0x7f0906b1);
            this.f33398e = (TextView) findViewById(R.id.obfuscated_res_0x7f0906b2);
            this.f33399f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906b3);
            setPadding(0, 0, 0, n.f(context, R.dimen.tbds44));
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f33395b, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.a, R.drawable.icon_home_card_delete);
            SkinManager.setViewTextColor(this.f33397d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f33398e, (int) R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33399f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f33400g = bdUniqueId;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
            this.a.setOnClickListener(onClickListener);
        }
    }

    public void setData(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) || eVar == null) {
            return;
        }
        if (!eVar.a()) {
            setVisibility(8);
            return;
        }
        if (eVar.f17445c > 0) {
            b.k().x(b.o("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.f17445c);
        }
        if (this.f33397d != null && !StringUtils.isNull(eVar.f17446d)) {
            this.f33397d.setText(eVar.f17446d);
        }
        LinearLayout linearLayout = this.f33396c;
        if (linearLayout == null || eVar.f17444b == null) {
            return;
        }
        linearLayout.removeAllViews();
        List<String> list = eVar.f17444b;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!StringUtils.isNull(str)) {
                FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d01ff, null);
                int i2 = this.f33401h;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                if (i > 0) {
                    layoutParams.leftMargin = this.i;
                }
                frameLayout.setLayoutParams(layoutParams);
                HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f090efa);
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(false);
                SkinManager.setImageResource((ImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091629), R.drawable.bg_unread_tip_head_border);
                this.f33396c.addView(frameLayout);
                headImageView.setPageId(this.f33400g);
                headImageView.J(str, 12, false);
            }
        }
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
}
