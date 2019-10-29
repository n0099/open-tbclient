package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.d;
import com.baidu.live.data.e;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<d> Px;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(e eVar) {
        this.Px = new ArrayList();
        if (eVar != null && eVar.getList() != null && !eVar.getList().isEmpty()) {
            for (d dVar : eVar.getList()) {
                if (dVar != null && dVar.Ps != null) {
                    this.Px.add(dVar);
                }
            }
        }
    }

    public boolean b(d dVar) {
        if (dVar == null || dVar.Ps == null) {
            return false;
        }
        if (this.Px == null) {
            return false;
        }
        if (this.Px.size() == 0) {
            this.Px.add(dVar);
            return true;
        }
        for (d dVar2 : this.Px) {
            if (dVar2 != null && dVar2.Ps != null && dVar.Ps.userId == dVar2.Ps.userId) {
                return false;
            }
        }
        this.Px.add(dVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Px == null) {
            return 0;
        }
        return this.Px.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Px == null) {
            return null;
        }
        return this.Px.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0358a c0358a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0358a c0358a2 = new C0358a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0358a2.dYJ.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0358a2.dYJ.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0358a2.dYJ.setIsRound(true);
            c0358a2.dYJ.setDrawBorder(false);
            c0358a2.dYJ.setAutoChangeStyle(false);
            c0358a2.dYJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0358a2.dYK.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0358a2);
            c0358a = c0358a2;
        } else {
            c0358a = (C0358a) view.getTag();
        }
        d dVar = (d) getItem(i);
        c0358a.dYJ.setDrawBorder(true);
        if (dVar.Pv == 1 && dVar.Ps.totalPrice > 0) {
            c0358a.dYK.setVisibility(0);
            c0358a.dYK.setImageResource(a.f.pic_live_top1);
            c0358a.dYL.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (dVar.Pv == 2 && dVar.Ps.totalPrice > 0) {
            c0358a.dYK.setVisibility(0);
            c0358a.dYK.setImageResource(a.f.pic_live_top2);
            c0358a.dYL.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (dVar.Pv == 3 && dVar.Ps.totalPrice > 0) {
            c0358a.dYK.setVisibility(0);
            c0358a.dYK.setImageResource(a.f.pic_live_top3);
            c0358a.dYL.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0358a.dYK.setVisibility(8);
            c0358a.dYL.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0358a.dYL.setText(StringHelper.formatForHeaderDayCharmValue(dVar.Ps.totalPrice));
        if (dVar.Ps.totalPrice <= 0) {
            c0358a.dYL.setVisibility(4);
        } else {
            c0358a.dYL.setVisibility(0);
        }
        j.a(c0358a.dYJ, dVar.Ps.portrait, true, !StringUtils.isNull(dVar.Ps.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0358a {
        public HeadImageView dYJ;
        public ImageView dYK;
        public TextView dYL;
        public View rootView;

        public C0358a(View view) {
            this.rootView = view;
            this.dYJ = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.dYK = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.dYL = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
