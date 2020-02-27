package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.g;
import com.baidu.live.data.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<g> XV;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void e(h hVar) {
        this.XV = new ArrayList();
        if (hVar != null && hVar.getList() != null && !hVar.getList().isEmpty()) {
            for (g gVar : hVar.getList()) {
                if (gVar != null && gVar.XQ != null) {
                    this.XV.add(gVar);
                }
            }
        }
    }

    public boolean b(g gVar) {
        if (gVar == null || gVar.XQ == null) {
            return false;
        }
        if (this.XV == null) {
            return false;
        }
        if (this.XV.size() == 0) {
            this.XV.add(gVar);
            return true;
        }
        for (g gVar2 : this.XV) {
            if (gVar2 != null && gVar2.XQ != null && gVar.XQ.userId == gVar2.XQ.userId) {
                return false;
            }
        }
        this.XV.add(gVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XV == null) {
            return 0;
        }
        return this.XV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XV == null) {
            return null;
        }
        return this.XV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0455a c0455a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0455a c0455a2 = new C0455a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0455a2.eTq.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0455a2.eTq.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0455a2.eTq.setIsRound(true);
            c0455a2.eTq.setDrawBorder(true);
            c0455a2.eTq.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0455a2.eTq.setAutoChangeStyle(false);
            c0455a2.eTq.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0455a2.eTr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0455a2);
            c0455a = c0455a2;
        } else {
            c0455a = (C0455a) view.getTag();
        }
        g gVar = (g) getItem(i);
        c0455a.eTq.setDrawBorder(true);
        if (gVar.XT == 1 && gVar.XQ.totalPrice > 0) {
            c0455a.eTr.setVisibility(0);
            c0455a.eTr.setImageResource(a.f.pic_live_top1);
            c0455a.eTs.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (gVar.XT == 2 && gVar.XQ.totalPrice > 0) {
            c0455a.eTr.setVisibility(0);
            c0455a.eTr.setImageResource(a.f.pic_live_top2);
            c0455a.eTs.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (gVar.XT == 3 && gVar.XQ.totalPrice > 0) {
            c0455a.eTr.setVisibility(0);
            c0455a.eTr.setImageResource(a.f.pic_live_top3);
            c0455a.eTs.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0455a.eTr.setVisibility(8);
            c0455a.eTs.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0455a.eTs.setText(StringHelper.formatForHeaderDayCharmValue(gVar.XQ.totalPrice));
        if (gVar.XQ.totalPrice <= 0) {
            c0455a.eTs.setVisibility(4);
        } else {
            c0455a.eTs.setVisibility(0);
        }
        k.a(c0455a.eTq, gVar.XQ.portrait, true, !StringUtils.isNull(gVar.XQ.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0455a {
        public HeadImageView eTq;
        public ImageView eTr;
        public TextView eTs;
        public View rootView;

        public C0455a(View view) {
            this.rootView = view;
            this.eTq = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.eTr = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.eTs = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
