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
    private List<p> aJb;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(q qVar) {
        this.aJb = new ArrayList();
        if (qVar != null && qVar.getList() != null && !qVar.getList().isEmpty()) {
            for (p pVar : qVar.getList()) {
                if (pVar != null && pVar.aIV != null) {
                    this.aJb.add(pVar);
                }
            }
        }
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.aIV == null) {
            return false;
        }
        if (this.aJb == null) {
            return false;
        }
        if (this.aJb.size() == 0) {
            this.aJb.add(pVar);
            return true;
        }
        for (p pVar2 : this.aJb) {
            if (pVar2 != null && pVar2.aIV != null && pVar.aIV.userId == pVar2.aIV.userId) {
                return false;
            }
        }
        this.aJb.add(pVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJb == null) {
            return 0;
        }
        return this.aJb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aJb == null) {
            return null;
        }
        return this.aJb.get(i);
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
                c0667a2.gYI.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                c0667a2.gYI.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            c0667a2.gYI.setIsRound(true);
            c0667a2.gYI.setDrawBorder(true);
            c0667a2.gYI.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            c0667a2.gYI.setAutoChangeStyle(false);
            c0667a2.gYI.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0667a2.gYJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0667a2);
            c0667a = c0667a2;
        } else {
            c0667a = (C0667a) view.getTag();
        }
        p pVar = (p) getItem(i);
        c0667a.gYI.setDrawBorder(true);
        if (pVar.aIY == 1 && pVar.aIV.totalPrice > 0) {
            c0667a.gYJ.setVisibility(0);
            c0667a.gYJ.setImageResource(a.e.pic_live_top1);
            c0667a.gYK.setBackgroundResource(a.e.round_header_day_list_bg_1);
        } else if (pVar.aIY == 2 && pVar.aIV.totalPrice > 0) {
            c0667a.gYJ.setVisibility(0);
            c0667a.gYJ.setImageResource(a.e.pic_live_top2);
            c0667a.gYK.setBackgroundResource(a.e.round_header_day_list_bg_2);
        } else if (pVar.aIY == 3 && pVar.aIV.totalPrice > 0) {
            c0667a.gYJ.setVisibility(0);
            c0667a.gYJ.setImageResource(a.e.pic_live_top3);
            c0667a.gYK.setBackgroundResource(a.e.round_header_day_list_bg_3);
        } else {
            c0667a.gYJ.setVisibility(8);
            c0667a.gYK.setBackgroundResource(a.e.round_header_day_list_bg_normal);
        }
        c0667a.gYK.setText(StringHelper.formatForHeaderDayCharmValue(pVar.aIV.totalPrice));
        if (pVar.aIV.totalPrice <= 0) {
            c0667a.gYK.setVisibility(4);
        } else {
            c0667a.gYK.setVisibility(0);
        }
        l.a(c0667a.gYI, pVar.aIV.portrait, true, !StringUtils.isNull(pVar.aIV.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0667a {
        public HeadImageView gYI;
        public ImageView gYJ;
        public TextView gYK;
        public View rootView;

        public C0667a(View view) {
            this.rootView = view;
            this.gYI = (HeadImageView) view.findViewById(a.f.ala_live_room_audience_header_img);
            this.gYJ = (ImageView) view.findViewById(a.f.ala_live_room_audience_pendant);
            this.gYK = (TextView) view.findViewById(a.f.ala_live_room_audience_charm_count);
        }
    }
}
