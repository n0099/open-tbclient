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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<u> aIj;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(v vVar) {
        this.aIj = new ArrayList();
        if (vVar != null && vVar.getList() != null && !vVar.getList().isEmpty()) {
            for (u uVar : vVar.getList()) {
                if (uVar != null && uVar.aId != null) {
                    this.aIj.add(uVar);
                }
            }
        }
    }

    public boolean b(u uVar) {
        if (uVar == null || uVar.aId == null) {
            return false;
        }
        if (this.aIj == null) {
            return false;
        }
        if (this.aIj.size() == 0) {
            this.aIj.add(uVar);
            return true;
        }
        for (u uVar2 : this.aIj) {
            if (uVar2 != null && uVar2.aId != null && uVar.aId.userId == uVar2.aId.userId) {
                return false;
            }
        }
        this.aIj.add(uVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIj == null) {
            return 0;
        }
        return this.aIj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIj == null) {
            return null;
        }
        return this.aIj.get(i);
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
            c0655a2.hty.setDefaultResource(a.e.sdk_icon_default_avatar100);
            c0655a2.hty.setIsRound(true);
            c0655a2.hty.setDrawBorder(true);
            c0655a2.hty.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0655a2.hty.setAutoChangeStyle(false);
            c0655a2.hty.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0655a2.htz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0655a2);
            c0655a = c0655a2;
        } else {
            c0655a = (C0655a) view.getTag();
        }
        u uVar = (u) getItem(i);
        c0655a.hty.setDrawBorder(true);
        if (uVar.aIg == 1 && uVar.aId.totalPrice > 0) {
            c0655a.htz.setVisibility(0);
            c0655a.htz.setImageResource(a.e.pic_live_top1);
            c0655a.htA.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (uVar.aIg == 2 && uVar.aId.totalPrice > 0) {
            c0655a.htz.setVisibility(0);
            c0655a.htz.setImageResource(a.e.pic_live_top2);
            c0655a.htA.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (uVar.aIg == 3 && uVar.aId.totalPrice > 0) {
            c0655a.htz.setVisibility(0);
            c0655a.htz.setImageResource(a.e.pic_live_top3);
            c0655a.htA.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0655a.htz.setVisibility(8);
            c0655a.htA.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0655a.htA.setText(StringHelper.formatForHeaderDayCharmValue(uVar.aId.totalPrice));
        if (uVar.aId.totalPrice <= 0) {
            c0655a.htA.setVisibility(4);
        } else {
            c0655a.htA.setVisibility(0);
        }
        m.a(c0655a.hty, uVar.aId.portrait, true, !StringUtils.isNull(uVar.aId.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0655a {
        public TextView htA;
        public HeadImageView hty;
        public ImageView htz;
        public View rootView;

        public C0655a(View view) {
            this.rootView = view;
            this.hty = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.htz = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.htA = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
