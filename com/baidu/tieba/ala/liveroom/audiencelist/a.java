package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<f> VU;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void e(g gVar) {
        this.VU = new ArrayList();
        if (gVar != null && gVar.getList() != null && !gVar.getList().isEmpty()) {
            for (f fVar : gVar.getList()) {
                if (fVar != null && fVar.VP != null) {
                    this.VU.add(fVar);
                }
            }
        }
    }

    public boolean b(f fVar) {
        if (fVar == null || fVar.VP == null) {
            return false;
        }
        if (this.VU == null) {
            return false;
        }
        if (this.VU.size() == 0) {
            this.VU.add(fVar);
            return true;
        }
        for (f fVar2 : this.VU) {
            if (fVar2 != null && fVar2.VP != null && fVar.VP.userId == fVar2.VP.userId) {
                return false;
            }
        }
        this.VU.add(fVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.VU == null) {
            return 0;
        }
        return this.VU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.VU == null) {
            return null;
        }
        return this.VU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0441a c0441a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0441a c0441a2 = new C0441a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0441a2.eNQ.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0441a2.eNQ.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0441a2.eNQ.setIsRound(true);
            c0441a2.eNQ.setDrawBorder(true);
            c0441a2.eNQ.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0441a2.eNQ.setAutoChangeStyle(false);
            c0441a2.eNQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0441a2.eNR.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0441a2);
            c0441a = c0441a2;
        } else {
            c0441a = (C0441a) view.getTag();
        }
        f fVar = (f) getItem(i);
        c0441a.eNQ.setDrawBorder(true);
        if (fVar.VS == 1 && fVar.VP.totalPrice > 0) {
            c0441a.eNR.setVisibility(0);
            c0441a.eNR.setImageResource(a.f.pic_live_top1);
            c0441a.eNS.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (fVar.VS == 2 && fVar.VP.totalPrice > 0) {
            c0441a.eNR.setVisibility(0);
            c0441a.eNR.setImageResource(a.f.pic_live_top2);
            c0441a.eNS.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (fVar.VS == 3 && fVar.VP.totalPrice > 0) {
            c0441a.eNR.setVisibility(0);
            c0441a.eNR.setImageResource(a.f.pic_live_top3);
            c0441a.eNS.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0441a.eNR.setVisibility(8);
            c0441a.eNS.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0441a.eNS.setText(StringHelper.formatForHeaderDayCharmValue(fVar.VP.totalPrice));
        if (fVar.VP.totalPrice <= 0) {
            c0441a.eNS.setVisibility(4);
        } else {
            c0441a.eNS.setVisibility(0);
        }
        k.a(c0441a.eNQ, fVar.VP.portrait, true, !StringUtils.isNull(fVar.VP.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0441a {
        public HeadImageView eNQ;
        public ImageView eNR;
        public TextView eNS;
        public View rootView;

        public C0441a(View view) {
            this.rootView = view;
            this.eNQ = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.eNR = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.eNS = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
