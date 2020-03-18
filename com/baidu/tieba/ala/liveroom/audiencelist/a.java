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
    private List<g> Yf;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void e(h hVar) {
        this.Yf = new ArrayList();
        if (hVar != null && hVar.getList() != null && !hVar.getList().isEmpty()) {
            for (g gVar : hVar.getList()) {
                if (gVar != null && gVar.Ya != null) {
                    this.Yf.add(gVar);
                }
            }
        }
    }

    public boolean b(g gVar) {
        if (gVar == null || gVar.Ya == null) {
            return false;
        }
        if (this.Yf == null) {
            return false;
        }
        if (this.Yf.size() == 0) {
            this.Yf.add(gVar);
            return true;
        }
        for (g gVar2 : this.Yf) {
            if (gVar2 != null && gVar2.Ya != null && gVar.Ya.userId == gVar2.Ya.userId) {
                return false;
            }
        }
        this.Yf.add(gVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Yf == null) {
            return 0;
        }
        return this.Yf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Yf == null) {
            return null;
        }
        return this.Yf.get(i);
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
                c0455a2.eUc.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0455a2.eUc.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0455a2.eUc.setIsRound(true);
            c0455a2.eUc.setDrawBorder(true);
            c0455a2.eUc.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0455a2.eUc.setAutoChangeStyle(false);
            c0455a2.eUc.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0455a2.eUd.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0455a2);
            c0455a = c0455a2;
        } else {
            c0455a = (C0455a) view.getTag();
        }
        g gVar = (g) getItem(i);
        c0455a.eUc.setDrawBorder(true);
        if (gVar.Yd == 1 && gVar.Ya.totalPrice > 0) {
            c0455a.eUd.setVisibility(0);
            c0455a.eUd.setImageResource(a.f.pic_live_top1);
            c0455a.eUe.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (gVar.Yd == 2 && gVar.Ya.totalPrice > 0) {
            c0455a.eUd.setVisibility(0);
            c0455a.eUd.setImageResource(a.f.pic_live_top2);
            c0455a.eUe.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (gVar.Yd == 3 && gVar.Ya.totalPrice > 0) {
            c0455a.eUd.setVisibility(0);
            c0455a.eUd.setImageResource(a.f.pic_live_top3);
            c0455a.eUe.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0455a.eUd.setVisibility(8);
            c0455a.eUe.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0455a.eUe.setText(StringHelper.formatForHeaderDayCharmValue(gVar.Ya.totalPrice));
        if (gVar.Ya.totalPrice <= 0) {
            c0455a.eUe.setVisibility(4);
        } else {
            c0455a.eUe.setVisibility(0);
        }
        k.a(c0455a.eUc, gVar.Ya.portrait, true, !StringUtils.isNull(gVar.Ya.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0455a {
        public HeadImageView eUc;
        public ImageView eUd;
        public TextView eUe;
        public View rootView;

        public C0455a(View view) {
            this.rootView = view;
            this.eUc = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.eUd = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.eUe = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
