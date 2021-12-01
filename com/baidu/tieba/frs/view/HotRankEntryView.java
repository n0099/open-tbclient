package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotUserRankEntry;
import tbclient.ShortUserInfo;
/* loaded from: classes10.dex */
public class HotRankEntryView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44839e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f44840f;

    /* renamed from: g  reason: collision with root package name */
    public ImageOverlayView f44841g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44842h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f44843i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f44844j;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotRankEntryView f44846f;

        public a(HotRankEntryView hotRankEntryView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotRankEntryView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44846f = hotRankEntryView;
            this.f44845e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotUserRankActivityConfig(this.f44845e)));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HotRankEntryView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(g1.hot_rank_entry, (ViewGroup) this, true);
            this.f44840f = (ImageView) findViewById(f1.first_tag);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds62);
            int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds1);
            int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d1.tbds20);
            ImageOverlayView imageOverlayView = (ImageOverlayView) findViewById(f1.image_group);
            this.f44841g = imageOverlayView;
            imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, c1.CAM_X0618, dimensionPixelOffset3);
            this.f44841g.setStrokeStyle(1);
            this.f44841g.setLoadImageType(12);
            this.f44842h = (TextView) findViewById(f1.entry_describe);
            this.f44843i = (ImageView) findViewById(f1.arrow);
            setOnClickListener(new a(this, context));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f44839e) {
            return;
        }
        this.f44839e = i2;
        SkinManager.setBackgroundResource(this, this.f44844j ? e1.frs_red_list_entrance_bg_black : e1.frs_red_list_entrance_bg_white);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f44840f, e1.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
        this.f44841g.onChangeSkinType();
        SkinManager.setViewTextColor(this.f44842h, c1.CAM_X0101);
        WebPManager.setPureDrawable(this.f44843i, e1.icon_pure_arrow12_right, c1.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
    }

    public void setData(HotUserRankEntry hotUserRankEntry, boolean z) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hotUserRankEntry, z) == null) || hotUserRankEntry == null || (list = hotUserRankEntry.hot_user) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ShortUserInfo shortUserInfo : hotUserRankEntry.hot_user) {
            if (shortUserInfo != null) {
                arrayList.add(shortUserInfo.portrait);
            }
        }
        this.f44841g.setData(arrayList);
        this.f44844j = z;
        this.f44842h.setText(!k.isEmpty(hotUserRankEntry.module_name) ? hotUserRankEntry.module_name : getResources().getString(i1.hot_rank));
        SkinManager.setBackgroundResource(this, z ? e1.frs_red_list_entrance_bg_black : e1.frs_red_list_entrance_bg_white);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotRankEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44839e = 3;
        a(context);
    }
}
