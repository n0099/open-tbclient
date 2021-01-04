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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<q> aKA;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(r rVar) {
        this.aKA = new ArrayList();
        if (rVar != null && rVar.getList() != null && !rVar.getList().isEmpty()) {
            for (q qVar : rVar.getList()) {
                if (qVar != null && qVar.aKu != null) {
                    this.aKA.add(qVar);
                }
            }
        }
    }

    public boolean b(q qVar) {
        if (qVar == null || qVar.aKu == null) {
            return false;
        }
        if (this.aKA == null) {
            return false;
        }
        if (this.aKA.size() == 0) {
            this.aKA.add(qVar);
            return true;
        }
        for (q qVar2 : this.aKA) {
            if (qVar2 != null && qVar2.aKu != null && qVar.aKu.userId == qVar2.aKu.userId) {
                return false;
            }
        }
        this.aKA.add(qVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKA == null) {
            return 0;
        }
        return this.aKA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aKA == null) {
            return null;
        }
        return this.aKA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0672a c0672a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_audience_header_image, (ViewGroup) null);
            C0672a c0672a2 = new C0672a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0672a2.htT.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0672a2.htT.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0672a2.htT.setIsRound(true);
            c0672a2.htT.setDrawBorder(true);
            c0672a2.htT.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0672a2.htT.setAutoChangeStyle(false);
            c0672a2.htT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0672a2.htU.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0672a2);
            c0672a = c0672a2;
        } else {
            c0672a = (C0672a) view.getTag();
        }
        q qVar = (q) getItem(i);
        c0672a.htT.setDrawBorder(true);
        if (qVar.aKx == 1 && qVar.aKu.totalPrice > 0) {
            c0672a.htU.setVisibility(0);
            c0672a.htU.setImageResource(a.e.pic_live_top1);
            c0672a.htV.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (qVar.aKx == 2 && qVar.aKu.totalPrice > 0) {
            c0672a.htU.setVisibility(0);
            c0672a.htU.setImageResource(a.e.pic_live_top2);
            c0672a.htV.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (qVar.aKx == 3 && qVar.aKu.totalPrice > 0) {
            c0672a.htU.setVisibility(0);
            c0672a.htU.setImageResource(a.e.pic_live_top3);
            c0672a.htV.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0672a.htU.setVisibility(8);
            c0672a.htV.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0672a.htV.setText(StringHelper.formatForHeaderDayCharmValue(qVar.aKu.totalPrice));
        if (qVar.aKu.totalPrice <= 0) {
            c0672a.htV.setVisibility(4);
        } else {
            c0672a.htV.setVisibility(0);
        }
        m.a(c0672a.htT, qVar.aKu.portrait, true, !StringUtils.isNull(qVar.aKu.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0672a {
        public HeadImageView htT;
        public ImageView htU;
        public TextView htV;
        public View rootView;

        public C0672a(View view) {
            this.rootView = view;
            this.htT = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.htU = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.htV = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
