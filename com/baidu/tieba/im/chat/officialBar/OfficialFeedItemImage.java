package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.l;
import b.a.r0.l1.i.a.b.b;
import b.a.r0.l1.l.c.a;
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
/* loaded from: classes9.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f50311e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f50312f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f50313g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50314h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50315i;
    public View j;
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
            LayoutInflater.from(this.f50311e).inflate(R.layout.official_feed_item_image, (ViewGroup) this, true);
            this.f50312f = (TbImageView) findViewById(R.id.message_image);
            this.f50313g = (ImageView) findViewById(R.id.message_read_icon);
            this.f50314h = (TextView) findViewById(R.id.message_read_count);
            this.f50315i = (TextView) findViewById(R.id.message_title);
            this.j = findViewById(R.id.black_mask);
            this.f50312f.setConrers(15);
            this.f50312f.setRadius(l.g(this.f50311e, R.dimen.tbds21));
            this.k = findViewById(R.id.image_container);
            this.l = findViewById(R.id.msg_read_container);
            onSkinTypeChange();
        }
    }

    public void adjustForSingleForum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f50312f.setRadius(l.g(this.f50311e, R.dimen.tbds31));
            this.f50312f.setConrers(3);
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.height = l.g(this.f50311e, R.dimen.tbds579);
            this.k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams2.leftMargin = l.g(this.f50311e, R.dimen.tbds27);
            this.l.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f50315i.getLayoutParams();
            layoutParams3.leftMargin = l.g(this.f50311e, R.dimen.tbds30);
            layoutParams3.bottomMargin = l.g(this.f50311e, R.dimen.tbds27);
            this.f50315i.setLayoutParams(layoutParams3);
        }
    }

    public void onSkinTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50313g, R.drawable.icon_pure_broadcast_read16_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
            if (this.m) {
                gradientLinear.into(this.j);
            } else {
                gradientLinear.blRadius(l.g(getContext(), R.dimen.tbds21)).brRadius(l.g(getContext(), R.dimen.tbds21)).into(this.j);
            }
            SkinManager.setViewTextColor(this.f50314h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f50315i, R.color.CAM_X0101);
        }
    }

    public void setData(a.C1004a c1004a, int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, c1004a, i2, bVar) == null) {
            this.f50312f.startLoad(c1004a.f20259c, 10, false);
            this.f50315i.setText(c1004a.f20257a);
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
                this.f50314h.setText(this.f50311e.getString(R.string.person_view_num, StringHelper.numberUniformFormatExtraWithRound(i2)));
                this.f50314h.setVisibility(0);
                this.f50313g.setVisibility(0);
                return;
            }
            this.f50314h.setVisibility(8);
            this.f50313g.setVisibility(8);
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
        this.f50311e = context;
        a();
    }
}
