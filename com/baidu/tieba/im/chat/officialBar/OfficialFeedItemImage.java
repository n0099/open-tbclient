package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.s0.s1.i.a.b.b;
import c.a.s0.s1.l.c.a;
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
/* loaded from: classes12.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f46413e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f46414f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f46415g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46416h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46417i;

    /* renamed from: j  reason: collision with root package name */
    public View f46418j;

    /* renamed from: k  reason: collision with root package name */
    public View f46419k;
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
            LayoutInflater.from(this.f46413e).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
            this.f46414f = (TbImageView) findViewById(R.id.message_image);
            this.f46415g = (ImageView) findViewById(R.id.message_read_icon);
            this.f46416h = (TextView) findViewById(R.id.message_read_count);
            this.f46417i = (TextView) findViewById(R.id.message_title);
            this.f46418j = findViewById(R.id.black_mask);
            this.f46414f.setConrers(15);
            this.f46414f.setRadius(m.f(this.f46413e, R.dimen.tbds21));
            this.f46419k = findViewById(R.id.image_container);
            this.l = findViewById(R.id.msg_read_container);
            onSkinTypeChange();
        }
    }

    public void adjustForSingleForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f46414f.setRadius(m.f(this.f46413e, R.dimen.tbds31));
            this.f46414f.setConrers(3);
            ViewGroup.LayoutParams layoutParams = this.f46419k.getLayoutParams();
            layoutParams.height = m.f(this.f46413e, R.dimen.tbds579);
            this.f46419k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.leftMargin = m.f(this.f46413e, R.dimen.tbds27);
            this.l.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f46417i.getLayoutParams();
            layoutParams3.leftMargin = m.f(this.f46413e, R.dimen.tbds30);
            layoutParams3.bottomMargin = m.f(this.f46413e, R.dimen.tbds27);
            this.f46417i.setLayoutParams(layoutParams3);
        }
    }

    public void onSkinTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f46415g, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
            if (this.m) {
                gradientLinear.into(this.f46418j);
            } else {
                gradientLinear.blRadius(m.f(getContext(), R.dimen.tbds21)).brRadius(m.f(getContext(), R.dimen.tbds21)).into(this.f46418j);
            }
            SkinManager.setViewTextColor(this.f46416h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f46417i, R.color.CAM_X0101);
        }
    }

    public void setData(a.C1326a c1326a, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, c1326a, i2, bVar) == null) {
            this.f46414f.startLoad(c1326a.f22268c, 10, false);
            this.f46417i.setText(c1326a.a);
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
                this.f46416h.setText(this.f46413e.getString(R.string.person_view_num, StringHelper.numberUniformFormatExtraWithRound(i2)));
                this.f46416h.setVisibility(0);
                this.f46415g.setVisibility(0);
                return;
            }
            this.f46416h.setVisibility(8);
            this.f46415g.setVisibility(8);
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
        this.f46413e = context;
        a();
    }
}
