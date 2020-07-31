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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<j> ayH;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(k kVar) {
        this.ayH = new ArrayList();
        if (kVar != null && kVar.getList() != null && !kVar.getList().isEmpty()) {
            for (j jVar : kVar.getList()) {
                if (jVar != null && jVar.ayC != null) {
                    this.ayH.add(jVar);
                }
            }
        }
    }

    public boolean b(j jVar) {
        if (jVar == null || jVar.ayC == null) {
            return false;
        }
        if (this.ayH == null) {
            return false;
        }
        if (this.ayH.size() == 0) {
            this.ayH.add(jVar);
            return true;
        }
        for (j jVar2 : this.ayH) {
            if (jVar2 != null && jVar2.ayC != null && jVar.ayC.userId == jVar2.ayC.userId) {
                return false;
            }
        }
        this.ayH.add(jVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ayH == null) {
            return 0;
        }
        return this.ayH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ayH == null) {
            return null;
        }
        return this.ayH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0576a c0576a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0576a c0576a2 = new C0576a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0576a2.gcT.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0576a2.gcT.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0576a2.gcT.setIsRound(true);
            c0576a2.gcT.setDrawBorder(true);
            c0576a2.gcT.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0576a2.gcT.setAutoChangeStyle(false);
            c0576a2.gcT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0576a2.gcU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0576a2);
            c0576a = c0576a2;
        } else {
            c0576a = (C0576a) view.getTag();
        }
        j jVar = (j) getItem(i);
        c0576a.gcT.setDrawBorder(true);
        if (jVar.ayF == 1 && jVar.ayC.totalPrice > 0) {
            c0576a.gcU.setVisibility(0);
            c0576a.gcU.setImageResource(a.f.pic_live_top1);
            c0576a.gcV.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (jVar.ayF == 2 && jVar.ayC.totalPrice > 0) {
            c0576a.gcU.setVisibility(0);
            c0576a.gcU.setImageResource(a.f.pic_live_top2);
            c0576a.gcV.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (jVar.ayF == 3 && jVar.ayC.totalPrice > 0) {
            c0576a.gcU.setVisibility(0);
            c0576a.gcU.setImageResource(a.f.pic_live_top3);
            c0576a.gcV.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0576a.gcU.setVisibility(8);
            c0576a.gcV.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0576a.gcV.setText(StringHelper.formatForHeaderDayCharmValue(jVar.ayC.totalPrice));
        if (jVar.ayC.totalPrice <= 0) {
            c0576a.gcV.setVisibility(4);
        } else {
            c0576a.gcV.setVisibility(0);
        }
        com.baidu.live.utils.k.a(c0576a.gcT, jVar.ayC.portrait, true, !StringUtils.isNull(jVar.ayC.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0576a {
        public HeadImageView gcT;
        public ImageView gcU;
        public TextView gcV;
        public View rootView;

        public C0576a(View view) {
            this.rootView = view;
            this.gcT = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.gcU = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.gcV = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
