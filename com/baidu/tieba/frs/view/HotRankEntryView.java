package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
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
/* loaded from: classes9.dex */
public class HotRankEntryView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49159e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49160f;

    /* renamed from: g  reason: collision with root package name */
    public ImageOverlayView f49161g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49162h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f49163i;
    public boolean j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotRankEntryView f49165f;

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
            this.f49165f = hotRankEntryView;
            this.f49164e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotUserRankActivityConfig(this.f49164e)));
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
            LayoutInflater.from(context).inflate(f1.hot_rank_entry, (ViewGroup) this, true);
            this.f49160f = (ImageView) findViewById(e1.first_tag);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(c1.tbds62);
            int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(c1.tbds1);
            int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(c1.tbds20);
            ImageOverlayView imageOverlayView = (ImageOverlayView) findViewById(e1.image_group);
            this.f49161g = imageOverlayView;
            imageOverlayView.init(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, b1.CAM_X0618, dimensionPixelOffset3);
            this.f49161g.setStrokeStyle(1);
            this.f49161g.setLoadImageType(12);
            this.f49162h = (TextView) findViewById(e1.entry_describe);
            this.f49163i = (ImageView) findViewById(e1.arrow);
            setOnClickListener(new a(this, context));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f49159e) {
            return;
        }
        this.f49159e = i2;
        SkinManager.setBackgroundResource(this, this.j ? d1.frs_red_list_entrance_bg_black : d1.frs_red_list_entrance_bg_white);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f49160f, d1.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
        this.f49161g.onChangeSkinType();
        SkinManager.setViewTextColor(this.f49162h, b1.CAM_X0101);
        WebPManager.setPureDrawable(this.f49163i, d1.icon_pure_arrow12_right, b1.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        this.f49161g.setData(arrayList);
        this.j = z;
        this.f49162h.setText(!k.isEmpty(hotUserRankEntry.module_name) ? hotUserRankEntry.module_name : getResources().getString(h1.hot_rank));
        SkinManager.setBackgroundResource(this, z ? d1.frs_red_list_entrance_bg_black : d1.frs_red_list_entrance_bg_white);
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
        this.f49159e = 3;
        a(context);
    }
}
