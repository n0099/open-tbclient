package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.j;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private List<j> aDJ;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(k kVar) {
        this.aDJ = new ArrayList();
        if (kVar != null && kVar.getList() != null && !kVar.getList().isEmpty()) {
            for (j jVar : kVar.getList()) {
                if (jVar != null && jVar.aDE != null) {
                    this.aDJ.add(jVar);
                }
            }
        }
    }

    public boolean b(j jVar) {
        if (jVar == null || jVar.aDE == null) {
            return false;
        }
        if (this.aDJ == null) {
            return false;
        }
        if (this.aDJ.size() == 0) {
            this.aDJ.add(jVar);
            return true;
        }
        for (j jVar2 : this.aDJ) {
            if (jVar2 != null && jVar2.aDE != null && jVar.aDE.userId == jVar2.aDE.userId) {
                return false;
            }
        }
        this.aDJ.add(jVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDJ == null) {
            return 0;
        }
        return this.aDJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aDJ == null) {
            return null;
        }
        return this.aDJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0623a c0623a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0623a c0623a2 = new C0623a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0623a2.gpb.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0623a2.gpb.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0623a2.gpb.setIsRound(true);
            c0623a2.gpb.setDrawBorder(true);
            c0623a2.gpb.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0623a2.gpb.setAutoChangeStyle(false);
            c0623a2.gpb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0623a2.gpc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0623a2);
            c0623a = c0623a2;
        } else {
            c0623a = (C0623a) view.getTag();
        }
        j jVar = (j) getItem(i);
        c0623a.gpb.setDrawBorder(true);
        if (jVar.aDH == 1 && jVar.aDE.totalPrice > 0) {
            c0623a.gpc.setVisibility(0);
            c0623a.gpc.setImageResource(a.f.pic_live_top1);
            c0623a.gpd.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (jVar.aDH == 2 && jVar.aDE.totalPrice > 0) {
            c0623a.gpc.setVisibility(0);
            c0623a.gpc.setImageResource(a.f.pic_live_top2);
            c0623a.gpd.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (jVar.aDH == 3 && jVar.aDE.totalPrice > 0) {
            c0623a.gpc.setVisibility(0);
            c0623a.gpc.setImageResource(a.f.pic_live_top3);
            c0623a.gpd.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0623a.gpc.setVisibility(8);
            c0623a.gpd.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0623a.gpd.setText(StringHelper.formatForHeaderDayCharmValue(jVar.aDE.totalPrice));
        if (jVar.aDE.totalPrice <= 0) {
            c0623a.gpd.setVisibility(4);
        } else {
            c0623a.gpd.setVisibility(0);
        }
        com.baidu.live.utils.k.a(c0623a.gpb, jVar.aDE.portrait, true, !StringUtils.isNull(jVar.aDE.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0623a {
        public HeadImageView gpb;
        public ImageView gpc;
        public TextView gpd;
        public View rootView;

        public C0623a(View view) {
            this.rootView = view;
            this.gpb = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.gpc = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.gpd = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
