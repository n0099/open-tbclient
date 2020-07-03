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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<j> axu;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(k kVar) {
        this.axu = new ArrayList();
        if (kVar != null && kVar.getList() != null && !kVar.getList().isEmpty()) {
            for (j jVar : kVar.getList()) {
                if (jVar != null && jVar.axp != null) {
                    this.axu.add(jVar);
                }
            }
        }
    }

    public boolean b(j jVar) {
        if (jVar == null || jVar.axp == null) {
            return false;
        }
        if (this.axu == null) {
            return false;
        }
        if (this.axu.size() == 0) {
            this.axu.add(jVar);
            return true;
        }
        for (j jVar2 : this.axu) {
            if (jVar2 != null && jVar2.axp != null && jVar.axp.userId == jVar2.axp.userId) {
                return false;
            }
        }
        this.axu.add(jVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.axu == null) {
            return 0;
        }
        return this.axu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.axu == null) {
            return null;
        }
        return this.axu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0566a c0566a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0566a c0566a2 = new C0566a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0566a2.fXM.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0566a2.fXM.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0566a2.fXM.setIsRound(true);
            c0566a2.fXM.setDrawBorder(true);
            c0566a2.fXM.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0566a2.fXM.setAutoChangeStyle(false);
            c0566a2.fXM.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0566a2.fXN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0566a2);
            c0566a = c0566a2;
        } else {
            c0566a = (C0566a) view.getTag();
        }
        j jVar = (j) getItem(i);
        c0566a.fXM.setDrawBorder(true);
        if (jVar.axs == 1 && jVar.axp.totalPrice > 0) {
            c0566a.fXN.setVisibility(0);
            c0566a.fXN.setImageResource(a.f.pic_live_top1);
            c0566a.fXO.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (jVar.axs == 2 && jVar.axp.totalPrice > 0) {
            c0566a.fXN.setVisibility(0);
            c0566a.fXN.setImageResource(a.f.pic_live_top2);
            c0566a.fXO.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (jVar.axs == 3 && jVar.axp.totalPrice > 0) {
            c0566a.fXN.setVisibility(0);
            c0566a.fXN.setImageResource(a.f.pic_live_top3);
            c0566a.fXO.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0566a.fXN.setVisibility(8);
            c0566a.fXO.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0566a.fXO.setText(StringHelper.formatForHeaderDayCharmValue(jVar.axp.totalPrice));
        if (jVar.axp.totalPrice <= 0) {
            c0566a.fXO.setVisibility(4);
        } else {
            c0566a.fXO.setVisibility(0);
        }
        com.baidu.live.utils.k.a(c0566a.fXM, jVar.axp.portrait, true, !StringUtils.isNull(jVar.axp.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0566a {
        public HeadImageView fXM;
        public ImageView fXN;
        public TextView fXO;
        public View rootView;

        public C0566a(View view) {
            this.rootView = view;
            this.fXM = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.fXN = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.fXO = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
