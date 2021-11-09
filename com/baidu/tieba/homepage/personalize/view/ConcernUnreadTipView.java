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
import b.a.e.e.p.l;
import b.a.q0.s.e0.b;
import b.a.r0.h1.h.j.e;
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
/* loaded from: classes9.dex */
public class ConcernUnreadTipView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49709e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f49710f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49711g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49712h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f49713i;
    public BdUniqueId j;
    public int k;
    public int l;
    public ImageView mClose;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.k = l.g(getContext(), R.dimen.tbds94);
            this.l = 0 - l.g(getContext(), R.dimen.tbds18);
            LayoutInflater.from(context).inflate(R.layout.concern_unread_tip_view_layout, (ViewGroup) this, true);
            this.f49709e = (TextView) findViewById(R.id.concern_unread_tip_title);
            this.mClose = (ImageView) findViewById(R.id.concern_unread_tip_close);
            this.f49710f = (LinearLayout) findViewById(R.id.concern_unread_tip_header_box);
            this.f49711g = (TextView) findViewById(R.id.concern_unread_tip_info);
            this.f49712h = (TextView) findViewById(R.id.concern_unread_tip_show);
            this.f49713i = (ImageView) findViewById(R.id.concern_unread_tip_show_arrow);
            setPadding(0, 0, 0, l.g(context, R.dimen.tbds44));
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f49709e, R.color.CAM_X0105);
            SkinManager.setImageResource(this.mClose, R.drawable.icon_home_card_delete);
            SkinManager.setViewTextColor(this.f49711g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f49712h, R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f49713i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
            this.mClose.setOnClickListener(onClickListener);
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
        if (eVar.f17453c > 0) {
            b.j().w(b.n("concern_unread_tip_next_show_time"), System.currentTimeMillis() + eVar.f17453c);
        }
        if (this.f49711g != null && !StringUtils.isNull(eVar.f17454d)) {
            this.f49711g.setText(eVar.f17454d);
        }
        LinearLayout linearLayout = this.f49710f;
        if (linearLayout == null || eVar.f17452b == null) {
            return;
        }
        linearLayout.removeAllViews();
        List<String> list = eVar.f17452b;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (!StringUtils.isNull(str)) {
                FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.concern_unread_tip_head_group, null);
                int i3 = this.k;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                if (i2 > 0) {
                    layoutParams.leftMargin = this.l;
                }
                frameLayout.setLayoutParams(layoutParams);
                HeadImageView headImageView = (HeadImageView) frameLayout.findViewById(R.id.inner_img);
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(false);
                SkinManager.setImageResource((ImageView) frameLayout.findViewById(R.id.out_img), R.drawable.bg_unread_tip_head_border);
                this.f49710f.addView(frameLayout);
                headImageView.setPageId(this.j);
                headImageView.startLoad(str, 12, false);
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernUnreadTipView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
