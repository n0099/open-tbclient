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
    private List<g> aqj;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(h hVar) {
        this.aqj = new ArrayList();
        if (hVar != null && hVar.getList() != null && !hVar.getList().isEmpty()) {
            for (g gVar : hVar.getList()) {
                if (gVar != null && gVar.aqe != null) {
                    this.aqj.add(gVar);
                }
            }
        }
    }

    public boolean b(g gVar) {
        if (gVar == null || gVar.aqe == null) {
            return false;
        }
        if (this.aqj == null) {
            return false;
        }
        if (this.aqj.size() == 0) {
            this.aqj.add(gVar);
            return true;
        }
        for (g gVar2 : this.aqj) {
            if (gVar2 != null && gVar2.aqe != null && gVar.aqe.userId == gVar2.aqe.userId) {
                return false;
            }
        }
        this.aqj.add(gVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aqj == null) {
            return 0;
        }
        return this.aqj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aqj == null) {
            return null;
        }
        return this.aqj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0490a c0490a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0490a c0490a2 = new C0490a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0490a2.fyw.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0490a2.fyw.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0490a2.fyw.setIsRound(true);
            c0490a2.fyw.setDrawBorder(true);
            c0490a2.fyw.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0490a2.fyw.setAutoChangeStyle(false);
            c0490a2.fyw.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0490a2.fyx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0490a2);
            c0490a = c0490a2;
        } else {
            c0490a = (C0490a) view.getTag();
        }
        g gVar = (g) getItem(i);
        c0490a.fyw.setDrawBorder(true);
        if (gVar.aqh == 1 && gVar.aqe.totalPrice > 0) {
            c0490a.fyx.setVisibility(0);
            c0490a.fyx.setImageResource(a.f.pic_live_top1);
            c0490a.fyy.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (gVar.aqh == 2 && gVar.aqe.totalPrice > 0) {
            c0490a.fyx.setVisibility(0);
            c0490a.fyx.setImageResource(a.f.pic_live_top2);
            c0490a.fyy.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (gVar.aqh == 3 && gVar.aqe.totalPrice > 0) {
            c0490a.fyx.setVisibility(0);
            c0490a.fyx.setImageResource(a.f.pic_live_top3);
            c0490a.fyy.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0490a.fyx.setVisibility(8);
            c0490a.fyy.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0490a.fyy.setText(StringHelper.formatForHeaderDayCharmValue(gVar.aqe.totalPrice));
        if (gVar.aqe.totalPrice <= 0) {
            c0490a.fyy.setVisibility(4);
        } else {
            c0490a.fyy.setVisibility(0);
        }
        k.a(c0490a.fyw, gVar.aqe.portrait, true, !StringUtils.isNull(gVar.aqe.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0490a {
        public HeadImageView fyw;
        public ImageView fyx;
        public TextView fyy;
        public View rootView;

        public C0490a(View view) {
            this.rootView = view;
            this.fyw = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.fyx = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.fyy = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
