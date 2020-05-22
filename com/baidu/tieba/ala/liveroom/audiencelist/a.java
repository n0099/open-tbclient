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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<j> avo;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(k kVar) {
        this.avo = new ArrayList();
        if (kVar != null && kVar.getList() != null && !kVar.getList().isEmpty()) {
            for (j jVar : kVar.getList()) {
                if (jVar != null && jVar.avj != null) {
                    this.avo.add(jVar);
                }
            }
        }
    }

    public boolean b(j jVar) {
        if (jVar == null || jVar.avj == null) {
            return false;
        }
        if (this.avo == null) {
            return false;
        }
        if (this.avo.size() == 0) {
            this.avo.add(jVar);
            return true;
        }
        for (j jVar2 : this.avo) {
            if (jVar2 != null && jVar2.avj != null && jVar.avj.userId == jVar2.avj.userId) {
                return false;
            }
        }
        this.avo.add(jVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avo == null) {
            return 0;
        }
        return this.avo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.avo == null) {
            return null;
        }
        return this.avo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0558a c0558a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0558a c0558a2 = new C0558a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0558a2.fMC.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0558a2.fMC.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0558a2.fMC.setIsRound(true);
            c0558a2.fMC.setDrawBorder(true);
            c0558a2.fMC.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0558a2.fMC.setAutoChangeStyle(false);
            c0558a2.fMC.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0558a2.fMD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0558a2);
            c0558a = c0558a2;
        } else {
            c0558a = (C0558a) view.getTag();
        }
        j jVar = (j) getItem(i);
        c0558a.fMC.setDrawBorder(true);
        if (jVar.avm == 1 && jVar.avj.totalPrice > 0) {
            c0558a.fMD.setVisibility(0);
            c0558a.fMD.setImageResource(a.f.pic_live_top1);
            c0558a.fME.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (jVar.avm == 2 && jVar.avj.totalPrice > 0) {
            c0558a.fMD.setVisibility(0);
            c0558a.fMD.setImageResource(a.f.pic_live_top2);
            c0558a.fME.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (jVar.avm == 3 && jVar.avj.totalPrice > 0) {
            c0558a.fMD.setVisibility(0);
            c0558a.fMD.setImageResource(a.f.pic_live_top3);
            c0558a.fME.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0558a.fMD.setVisibility(8);
            c0558a.fME.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0558a.fME.setText(StringHelper.formatForHeaderDayCharmValue(jVar.avj.totalPrice));
        if (jVar.avj.totalPrice <= 0) {
            c0558a.fME.setVisibility(4);
        } else {
            c0558a.fME.setVisibility(0);
        }
        com.baidu.live.utils.k.a(c0558a.fMC, jVar.avj.portrait, true, !StringUtils.isNull(jVar.avj.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0558a {
        public HeadImageView fMC;
        public ImageView fMD;
        public TextView fME;
        public View rootView;

        public C0558a(View view) {
            this.rootView = view;
            this.fMC = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.fMD = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.fME = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
