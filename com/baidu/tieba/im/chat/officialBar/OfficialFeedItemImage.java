package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.j1.i.a.b.b;
import c.a.q0.j1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52860e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52861f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f52862g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52863h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52864i;

    /* renamed from: j  reason: collision with root package name */
    public View f52865j;
    public View k;
    public View l;
    public boolean m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = z;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f52860e).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
            this.f52861f = (TbImageView) findViewById(R.id.message_image);
            this.f52862g = (ImageView) findViewById(R.id.message_read_icon);
            this.f52863h = (TextView) findViewById(R.id.message_read_count);
            this.f52864i = (TextView) findViewById(R.id.message_title);
            this.f52865j = findViewById(R.id.black_mask);
            this.f52861f.setConrers(15);
            this.f52861f.setRadius(l.g(this.f52860e, R.dimen.tbds21));
            this.k = findViewById(R.id.image_container);
            this.l = findViewById(R.id.msg_read_container);
            onSkinTypeChange();
        }
    }

    public void adjustForSingleForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f52861f.setRadius(l.g(this.f52860e, R.dimen.tbds31));
            this.f52861f.setConrers(3);
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.height = l.g(this.f52860e, R.dimen.tbds579);
            this.k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.leftMargin = l.g(this.f52860e, R.dimen.tbds27);
            this.l.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f52864i.getLayoutParams();
            layoutParams3.leftMargin = l.g(this.f52860e, R.dimen.tbds30);
            layoutParams3.bottomMargin = l.g(this.f52860e, R.dimen.tbds27);
            this.f52864i.setLayoutParams(layoutParams3);
        }
    }

    public void onSkinTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f52862g, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
            if (this.m) {
                gradientLinear.into(this.f52865j);
            } else {
                gradientLinear.blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).into(this.f52865j);
            }
            SkinManager.setViewTextColor(this.f52863h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f52864i, R.color.CAM_X0101);
        }
    }

    public void setData(a.C0970a c0970a, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, c0970a, i2, bVar) == null) {
            this.f52861f.startLoad(c0970a.f20910c, 10, false);
            this.f52864i.setText(c0970a.f20908a);
            if (bVar != null) {
                i2 = bVar.i();
            }
            updateReadCount(i2);
        }
    }

    public void updateReadCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 > 0) {
                this.f52863h.setText(this.f52860e.getString(R.string.person_view_num, StringHelper.numberUniformFormatExtraWithRound(i2)));
                this.f52863h.setVisibility(0);
                this.f52862g.setVisibility(0);
                return;
            }
            this.f52863h.setVisibility(8);
            this.f52862g.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52860e = context;
        a();
    }
}
