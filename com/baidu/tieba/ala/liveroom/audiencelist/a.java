package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private List<u> aJJ;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(v vVar) {
        this.aJJ = new ArrayList();
        if (vVar != null && vVar.getList() != null && !vVar.getList().isEmpty()) {
            for (u uVar : vVar.getList()) {
                if (uVar != null && uVar.aJD != null) {
                    this.aJJ.add(uVar);
                }
            }
        }
    }

    public boolean b(u uVar) {
        if (uVar == null || uVar.aJD == null) {
            return false;
        }
        if (this.aJJ == null) {
            return false;
        }
        if (this.aJJ.size() == 0) {
            this.aJJ.add(uVar);
            return true;
        }
        for (u uVar2 : this.aJJ) {
            if (uVar2 != null && uVar2.aJD != null && uVar.aJD.userId == uVar2.aJD.userId) {
                return false;
            }
        }
        this.aJJ.add(uVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJJ == null) {
            return 0;
        }
        return this.aJJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aJJ == null) {
            return null;
        }
        return this.aJJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0662a c0662a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_audience_header_image, (ViewGroup) null);
            C0662a c0662a2 = new C0662a(view);
            c0662a2.hvv.setDefaultResource(a.e.sdk_icon_default_avatar100);
            c0662a2.hvv.setIsRound(true);
            c0662a2.hvv.setDrawBorder(true);
            c0662a2.hvv.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0662a2.hvv.setAutoChangeStyle(false);
            c0662a2.hvv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0662a2.hvw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0662a2);
            c0662a = c0662a2;
        } else {
            c0662a = (C0662a) view.getTag();
        }
        u uVar = (u) getItem(i);
        c0662a.hvv.setDrawBorder(true);
        if (uVar.aJG == 1 && uVar.aJD.totalPrice > 0) {
            c0662a.hvw.setVisibility(0);
            c0662a.hvw.setImageResource(a.e.pic_live_top1);
            c0662a.hvx.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (uVar.aJG == 2 && uVar.aJD.totalPrice > 0) {
            c0662a.hvw.setVisibility(0);
            c0662a.hvw.setImageResource(a.e.pic_live_top2);
            c0662a.hvx.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (uVar.aJG == 3 && uVar.aJD.totalPrice > 0) {
            c0662a.hvw.setVisibility(0);
            c0662a.hvw.setImageResource(a.e.pic_live_top3);
            c0662a.hvx.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0662a.hvw.setVisibility(8);
            c0662a.hvx.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0662a.hvx.setText(StringHelper.formatForHeaderDayCharmValue(uVar.aJD.totalPrice));
        if (uVar.aJD.totalPrice <= 0) {
            c0662a.hvx.setVisibility(4);
        } else {
            c0662a.hvx.setVisibility(0);
        }
        m.a(c0662a.hvv, uVar.aJD.portrait, true, !StringUtils.isNull(uVar.aJD.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0662a {
        public HeadImageView hvv;
        public ImageView hvw;
        public TextView hvx;
        public View rootView;

        public C0662a(View view) {
            this.rootView = view;
            this.hvv = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.hvw = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.hvx = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
