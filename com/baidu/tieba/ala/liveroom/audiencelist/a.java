package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<p> aKb;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(q qVar) {
        this.aKb = new ArrayList();
        if (qVar != null && qVar.getList() != null && !qVar.getList().isEmpty()) {
            for (p pVar : qVar.getList()) {
                if (pVar != null && pVar.aJV != null) {
                    this.aKb.add(pVar);
                }
            }
        }
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.aJV == null) {
            return false;
        }
        if (this.aKb == null) {
            return false;
        }
        if (this.aKb.size() == 0) {
            this.aKb.add(pVar);
            return true;
        }
        for (p pVar2 : this.aKb) {
            if (pVar2 != null && pVar2.aJV != null && pVar.aJV.userId == pVar2.aJV.userId) {
                return false;
            }
        }
        this.aKb.add(pVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKb == null) {
            return 0;
        }
        return this.aKb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aKb == null) {
            return null;
        }
        return this.aKb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0680a c0680a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_audience_header_image, (ViewGroup) null);
            C0680a c0680a2 = new C0680a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0680a2.hhU.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0680a2.hhU.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0680a2.hhU.setIsRound(true);
            c0680a2.hhU.setDrawBorder(true);
            c0680a2.hhU.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0680a2.hhU.setAutoChangeStyle(false);
            c0680a2.hhU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0680a2.hhV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0680a2);
            c0680a = c0680a2;
        } else {
            c0680a = (C0680a) view.getTag();
        }
        p pVar = (p) getItem(i);
        c0680a.hhU.setDrawBorder(true);
        if (pVar.aJY == 1 && pVar.aJV.totalPrice > 0) {
            c0680a.hhV.setVisibility(0);
            c0680a.hhV.setImageResource(a.e.pic_live_top1);
            c0680a.hhW.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (pVar.aJY == 2 && pVar.aJV.totalPrice > 0) {
            c0680a.hhV.setVisibility(0);
            c0680a.hhV.setImageResource(a.e.pic_live_top2);
            c0680a.hhW.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (pVar.aJY == 3 && pVar.aJV.totalPrice > 0) {
            c0680a.hhV.setVisibility(0);
            c0680a.hhV.setImageResource(a.e.pic_live_top3);
            c0680a.hhW.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0680a.hhV.setVisibility(8);
            c0680a.hhW.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0680a.hhW.setText(StringHelper.formatForHeaderDayCharmValue(pVar.aJV.totalPrice));
        if (pVar.aJV.totalPrice <= 0) {
            c0680a.hhW.setVisibility(4);
        } else {
            c0680a.hhW.setVisibility(0);
        }
        l.a(c0680a.hhU, pVar.aJV.portrait, true, !StringUtils.isNull(pVar.aJV.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0680a {
        public HeadImageView hhU;
        public ImageView hhV;
        public TextView hhW;
        public View rootView;

        public C0680a(View view) {
            this.rootView = view;
            this.hhU = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.hhV = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.hhW = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
