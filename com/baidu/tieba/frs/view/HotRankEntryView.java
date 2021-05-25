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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
import tbclient.HotUserRankEntry;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class HotRankEntryView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f15894e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f15895f;

    /* renamed from: g  reason: collision with root package name */
    public ImageOverlayView f15896g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15897h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f15898i;
    public boolean j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f15899e;

        public a(Context context) {
            this.f15899e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotUserRankActivityConfig(this.f15899e)));
        }
    }

    public HotRankEntryView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hot_rank_entry, (ViewGroup) this, true);
        this.f15895f = (ImageView) findViewById(R.id.first_tag);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        ImageOverlayView imageOverlayView = (ImageOverlayView) findViewById(R.id.image_group);
        this.f15896g = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f15896g.setStrokeStyle(1);
        this.f15896g.setLoadImageType(12);
        this.f15897h = (TextView) findViewById(R.id.entry_describe);
        this.f15898i = (ImageView) findViewById(R.id.arrow);
        setOnClickListener(new a(context));
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b(int i2) {
        if (i2 != this.f15894e) {
            this.f15894e = i2;
            SkinManager.setBackgroundResource(this, this.j ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f15895f, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            this.f15896g.d();
            SkinManager.setViewTextColor(this.f15897h, R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.f15898i, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void setData(HotUserRankEntry hotUserRankEntry, boolean z) {
        List<ShortUserInfo> list;
        if (hotUserRankEntry == null || (list = hotUserRankEntry.hot_user) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ShortUserInfo shortUserInfo : hotUserRankEntry.hot_user) {
            if (shortUserInfo != null) {
                arrayList.add(shortUserInfo.portrait);
            }
        }
        this.f15896g.setData(arrayList);
        this.j = z;
        this.f15897h.setText(!k.isEmpty(hotUserRankEntry.module_name) ? hotUserRankEntry.module_name : getResources().getString(R.string.hot_rank));
        SkinManager.setBackgroundResource(this, z ? R.drawable.frs_red_list_entrance_bg_black : R.drawable.frs_red_list_entrance_bg_white);
    }

    public HotRankEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f15894e = 3;
        a(context);
    }
}
