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
    private List<g> aqp;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(h hVar) {
        this.aqp = new ArrayList();
        if (hVar != null && hVar.getList() != null && !hVar.getList().isEmpty()) {
            for (g gVar : hVar.getList()) {
                if (gVar != null && gVar.aqk != null) {
                    this.aqp.add(gVar);
                }
            }
        }
    }

    public boolean b(g gVar) {
        if (gVar == null || gVar.aqk == null) {
            return false;
        }
        if (this.aqp == null) {
            return false;
        }
        if (this.aqp.size() == 0) {
            this.aqp.add(gVar);
            return true;
        }
        for (g gVar2 : this.aqp) {
            if (gVar2 != null && gVar2.aqk != null && gVar.aqk.userId == gVar2.aqk.userId) {
                return false;
            }
        }
        this.aqp.add(gVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aqp == null) {
            return 0;
        }
        return this.aqp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aqp == null) {
            return null;
        }
        return this.aqp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0511a c0511a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0511a c0511a2 = new C0511a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0511a2.fyB.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0511a2.fyB.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0511a2.fyB.setIsRound(true);
            c0511a2.fyB.setDrawBorder(true);
            c0511a2.fyB.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0511a2.fyB.setAutoChangeStyle(false);
            c0511a2.fyB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0511a2.fyC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0511a2);
            c0511a = c0511a2;
        } else {
            c0511a = (C0511a) view.getTag();
        }
        g gVar = (g) getItem(i);
        c0511a.fyB.setDrawBorder(true);
        if (gVar.aqn == 1 && gVar.aqk.totalPrice > 0) {
            c0511a.fyC.setVisibility(0);
            c0511a.fyC.setImageResource(a.f.pic_live_top1);
            c0511a.fyD.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (gVar.aqn == 2 && gVar.aqk.totalPrice > 0) {
            c0511a.fyC.setVisibility(0);
            c0511a.fyC.setImageResource(a.f.pic_live_top2);
            c0511a.fyD.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (gVar.aqn == 3 && gVar.aqk.totalPrice > 0) {
            c0511a.fyC.setVisibility(0);
            c0511a.fyC.setImageResource(a.f.pic_live_top3);
            c0511a.fyD.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0511a.fyC.setVisibility(8);
            c0511a.fyD.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0511a.fyD.setText(StringHelper.formatForHeaderDayCharmValue(gVar.aqk.totalPrice));
        if (gVar.aqk.totalPrice <= 0) {
            c0511a.fyD.setVisibility(4);
        } else {
            c0511a.fyD.setVisibility(0);
        }
        k.a(c0511a.fyB, gVar.aqk.portrait, true, !StringUtils.isNull(gVar.aqk.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0511a {
        public HeadImageView fyB;
        public ImageView fyC;
        public TextView fyD;
        public View rootView;

        public C0511a(View view) {
            this.rootView = view;
            this.fyB = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.fyC = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.fyD = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
