package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.j;
import com.baidu.live.data.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private List<j> aDL;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(k kVar) {
        this.aDL = new ArrayList();
        if (kVar != null && kVar.getList() != null && !kVar.getList().isEmpty()) {
            for (j jVar : kVar.getList()) {
                if (jVar != null && jVar.aDG != null) {
                    this.aDL.add(jVar);
                }
            }
        }
    }

    public boolean b(j jVar) {
        if (jVar == null || jVar.aDG == null) {
            return false;
        }
        if (this.aDL == null) {
            return false;
        }
        if (this.aDL.size() == 0) {
            this.aDL.add(jVar);
            return true;
        }
        for (j jVar2 : this.aDL) {
            if (jVar2 != null && jVar2.aDG != null && jVar.aDG.userId == jVar2.aDG.userId) {
                return false;
            }
        }
        this.aDL.add(jVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDL == null) {
            return 0;
        }
        return this.aDL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aDL == null) {
            return null;
        }
        return this.aDL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0623a c0623a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0623a c0623a2 = new C0623a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0623a2.gpf.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0623a2.gpf.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0623a2.gpf.setIsRound(true);
            c0623a2.gpf.setDrawBorder(true);
            c0623a2.gpf.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0623a2.gpf.setAutoChangeStyle(false);
            c0623a2.gpf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0623a2.gpg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0623a2);
            c0623a = c0623a2;
        } else {
            c0623a = (C0623a) view.getTag();
        }
        j jVar = (j) getItem(i);
        c0623a.gpf.setDrawBorder(true);
        if (jVar.aDJ == 1 && jVar.aDG.totalPrice > 0) {
            c0623a.gpg.setVisibility(0);
            c0623a.gpg.setImageResource(a.f.pic_live_top1);
            c0623a.gph.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (jVar.aDJ == 2 && jVar.aDG.totalPrice > 0) {
            c0623a.gpg.setVisibility(0);
            c0623a.gpg.setImageResource(a.f.pic_live_top2);
            c0623a.gph.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (jVar.aDJ == 3 && jVar.aDG.totalPrice > 0) {
            c0623a.gpg.setVisibility(0);
            c0623a.gpg.setImageResource(a.f.pic_live_top3);
            c0623a.gph.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0623a.gpg.setVisibility(8);
            c0623a.gph.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0623a.gph.setText(StringHelper.formatForHeaderDayCharmValue(jVar.aDG.totalPrice));
        if (jVar.aDG.totalPrice <= 0) {
            c0623a.gph.setVisibility(4);
        } else {
            c0623a.gph.setVisibility(0);
        }
        com.baidu.live.utils.k.a(c0623a.gpf, jVar.aDG.portrait, true, !StringUtils.isNull(jVar.aDG.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0623a {
        public HeadImageView gpf;
        public ImageView gpg;
        public TextView gph;
        public View rootView;

        public C0623a(View view) {
            this.rootView = view;
            this.gpf = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.gpg = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.gph = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
