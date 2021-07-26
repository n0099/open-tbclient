package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotUserRankEntry;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class HotRankEntryView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16271e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16272f;

    /* renamed from: g  reason: collision with root package name */
    public ImageOverlayView f16273g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16274h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f16275i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f16276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HotRankEntryView f16277f;

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
            this.f16277f = hotRankEntryView;
            this.f16276e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotUserRankActivityConfig(this.f16276e)));
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
            LayoutInflater.from(context).inflate(R.layout.hot_rank_entry, (ViewGroup) this, true);
            this.f16272f = (ImageView) findViewById(R.id.first_tag);
            int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
            int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
            int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
            ImageOverlayView imageOverlayView = (ImageOverlayView) findViewById(R.id.image_group);
            this.f16273g = imageOverlayView;
            imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
            this.f16273g.setStrokeStyle(1);
            this.f16273g.setLoadImageType(12);
            this.f16274h = (TextView) findViewById(R.id.entry_describe);
            this.f16275i = (ImageView) findViewById(R.id.arrow);
            setOnClickListener(new a(this, context));
            b(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f16271e) {
            return;
        }
        this.f16271e = i2;
        SkinManager.setBackgroundResource(this, this.j ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f16272f, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
        this.f16273g.d();
        SkinManager.setViewTextColor(this.f16274h, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f16275i, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        this.f16273g.setData(arrayList);
        this.j = z;
        this.f16274h.setText(!k.isEmpty(hotUserRankEntry.module_name) ? hotUserRankEntry.module_name : getResources().getString(R.string.hot_rank));
        SkinManager.setBackgroundResource(this, z ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
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
        this.f16271e = 3;
        a(context);
    }
}
