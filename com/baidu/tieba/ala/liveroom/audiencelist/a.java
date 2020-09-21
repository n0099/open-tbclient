package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private List<m> aEF;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(n nVar) {
        this.aEF = new ArrayList();
        if (nVar != null && nVar.getList() != null && !nVar.getList().isEmpty()) {
            for (m mVar : nVar.getList()) {
                if (mVar != null && mVar.aEz != null) {
                    this.aEF.add(mVar);
                }
            }
        }
    }

    public boolean b(m mVar) {
        if (mVar == null || mVar.aEz == null) {
            return false;
        }
        if (this.aEF == null) {
            return false;
        }
        if (this.aEF.size() == 0) {
            this.aEF.add(mVar);
            return true;
        }
        for (m mVar2 : this.aEF) {
            if (mVar2 != null && mVar2.aEz != null && mVar.aEz.userId == mVar2.aEz.userId) {
                return false;
            }
        }
        this.aEF.add(mVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aEF == null) {
            return 0;
        }
        return this.aEF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aEF == null) {
            return null;
        }
        return this.aEF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0619a c0619a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0619a c0619a2 = new C0619a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0619a2.gst.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0619a2.gst.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0619a2.gst.setIsRound(true);
            c0619a2.gst.setDrawBorder(true);
            c0619a2.gst.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0619a2.gst.setAutoChangeStyle(false);
            c0619a2.gst.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0619a2.gsu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0619a2);
            c0619a = c0619a2;
        } else {
            c0619a = (C0619a) view.getTag();
        }
        m mVar = (m) getItem(i);
        c0619a.gst.setDrawBorder(true);
        if (mVar.aEC == 1 && mVar.aEz.totalPrice > 0) {
            c0619a.gsu.setVisibility(0);
            c0619a.gsu.setImageResource(a.f.pic_live_top1);
            c0619a.gsv.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (mVar.aEC == 2 && mVar.aEz.totalPrice > 0) {
            c0619a.gsu.setVisibility(0);
            c0619a.gsu.setImageResource(a.f.pic_live_top2);
            c0619a.gsv.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (mVar.aEC == 3 && mVar.aEz.totalPrice > 0) {
            c0619a.gsu.setVisibility(0);
            c0619a.gsu.setImageResource(a.f.pic_live_top3);
            c0619a.gsv.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0619a.gsu.setVisibility(8);
            c0619a.gsv.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0619a.gsv.setText(StringHelper.formatForHeaderDayCharmValue(mVar.aEz.totalPrice));
        if (mVar.aEz.totalPrice <= 0) {
            c0619a.gsv.setVisibility(4);
        } else {
            c0619a.gsv.setVisibility(0);
        }
        l.a(c0619a.gst, mVar.aEz.portrait, true, !StringUtils.isNull(mVar.aEz.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0619a {
        public HeadImageView gst;
        public ImageView gsu;
        public TextView gsv;
        public View rootView;

        public C0619a(View view) {
            this.rootView = view;
            this.gst = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.gsu = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.gsv = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
