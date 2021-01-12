package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private List<q> aFN;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(r rVar) {
        this.aFN = new ArrayList();
        if (rVar != null && rVar.getList() != null && !rVar.getList().isEmpty()) {
            for (q qVar : rVar.getList()) {
                if (qVar != null && qVar.aFH != null) {
                    this.aFN.add(qVar);
                }
            }
        }
    }

    public boolean b(q qVar) {
        if (qVar == null || qVar.aFH == null) {
            return false;
        }
        if (this.aFN == null) {
            return false;
        }
        if (this.aFN.size() == 0) {
            this.aFN.add(qVar);
            return true;
        }
        for (q qVar2 : this.aFN) {
            if (qVar2 != null && qVar2.aFH != null && qVar.aFH.userId == qVar2.aFH.userId) {
                return false;
            }
        }
        this.aFN.add(qVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFN == null) {
            return 0;
        }
        return this.aFN.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aFN == null) {
            return null;
        }
        return this.aFN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0655a c0655a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_audience_header_image, (ViewGroup) null);
            C0655a c0655a2 = new C0655a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0655a2.hpn.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0655a2.hpn.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0655a2.hpn.setIsRound(true);
            c0655a2.hpn.setDrawBorder(true);
            c0655a2.hpn.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0655a2.hpn.setAutoChangeStyle(false);
            c0655a2.hpn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0655a2.hpo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0655a2);
            c0655a = c0655a2;
        } else {
            c0655a = (C0655a) view.getTag();
        }
        q qVar = (q) getItem(i);
        c0655a.hpn.setDrawBorder(true);
        if (qVar.aFK == 1 && qVar.aFH.totalPrice > 0) {
            c0655a.hpo.setVisibility(0);
            c0655a.hpo.setImageResource(a.e.pic_live_top1);
            c0655a.hpp.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (qVar.aFK == 2 && qVar.aFH.totalPrice > 0) {
            c0655a.hpo.setVisibility(0);
            c0655a.hpo.setImageResource(a.e.pic_live_top2);
            c0655a.hpp.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (qVar.aFK == 3 && qVar.aFH.totalPrice > 0) {
            c0655a.hpo.setVisibility(0);
            c0655a.hpo.setImageResource(a.e.pic_live_top3);
            c0655a.hpp.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0655a.hpo.setVisibility(8);
            c0655a.hpp.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0655a.hpp.setText(StringHelper.formatForHeaderDayCharmValue(qVar.aFH.totalPrice));
        if (qVar.aFH.totalPrice <= 0) {
            c0655a.hpp.setVisibility(4);
        } else {
            c0655a.hpp.setVisibility(0);
        }
        m.a(c0655a.hpn, qVar.aFH.portrait, true, !StringUtils.isNull(qVar.aFH.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0655a {
        public HeadImageView hpn;
        public ImageView hpo;
        public TextView hpp;
        public View rootView;

        public C0655a(View view) {
            this.rootView = view;
            this.hpn = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.hpo = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.hpp = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
