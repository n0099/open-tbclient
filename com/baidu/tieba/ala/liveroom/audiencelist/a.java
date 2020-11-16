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
    private List<p> aHq;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(q qVar) {
        this.aHq = new ArrayList();
        if (qVar != null && qVar.getList() != null && !qVar.getList().isEmpty()) {
            for (p pVar : qVar.getList()) {
                if (pVar != null && pVar.aHk != null) {
                    this.aHq.add(pVar);
                }
            }
        }
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.aHk == null) {
            return false;
        }
        if (this.aHq == null) {
            return false;
        }
        if (this.aHq.size() == 0) {
            this.aHq.add(pVar);
            return true;
        }
        for (p pVar2 : this.aHq) {
            if (pVar2 != null && pVar2.aHk != null && pVar.aHk.userId == pVar2.aHk.userId) {
                return false;
            }
        }
        this.aHq.add(pVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHq == null) {
            return 0;
        }
        return this.aHq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHq == null) {
            return null;
        }
        return this.aHq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0667a c0667a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_audience_header_image, (ViewGroup) null);
            C0667a c0667a2 = new C0667a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0667a2.gYp.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0667a2.gYp.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0667a2.gYp.setIsRound(true);
            c0667a2.gYp.setDrawBorder(true);
            c0667a2.gYp.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0667a2.gYp.setAutoChangeStyle(false);
            c0667a2.gYp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0667a2.gYq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0667a2);
            c0667a = c0667a2;
        } else {
            c0667a = (C0667a) view.getTag();
        }
        p pVar = (p) getItem(i);
        c0667a.gYp.setDrawBorder(true);
        if (pVar.aHn == 1 && pVar.aHk.totalPrice > 0) {
            c0667a.gYq.setVisibility(0);
            c0667a.gYq.setImageResource(a.e.pic_live_top1);
            c0667a.gYr.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (pVar.aHn == 2 && pVar.aHk.totalPrice > 0) {
            c0667a.gYq.setVisibility(0);
            c0667a.gYq.setImageResource(a.e.pic_live_top2);
            c0667a.gYr.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (pVar.aHn == 3 && pVar.aHk.totalPrice > 0) {
            c0667a.gYq.setVisibility(0);
            c0667a.gYq.setImageResource(a.e.pic_live_top3);
            c0667a.gYr.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0667a.gYq.setVisibility(8);
            c0667a.gYr.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0667a.gYr.setText(StringHelper.formatForHeaderDayCharmValue(pVar.aHk.totalPrice));
        if (pVar.aHk.totalPrice <= 0) {
            c0667a.gYr.setVisibility(4);
        } else {
            c0667a.gYr.setVisibility(0);
        }
        l.a(c0667a.gYp, pVar.aHk.portrait, true, !StringUtils.isNull(pVar.aHk.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0667a {
        public HeadImageView gYp;
        public ImageView gYq;
        public TextView gYr;
        public View rootView;

        public C0667a(View view) {
            this.rootView = view;
            this.gYp = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.gYq = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.gYr = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
