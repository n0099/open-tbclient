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
    private List<d> OX;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(e eVar) {
        this.OX = new ArrayList();
        if (eVar != null && eVar.getList() != null && !eVar.getList().isEmpty()) {
            for (d dVar : eVar.getList()) {
                if (dVar != null && dVar.OR != null) {
                    this.OX.add(dVar);
                }
            }
        }
    }

    public boolean b(d dVar) {
        if (dVar == null || dVar.OR == null) {
            return false;
        }
        if (this.OX == null) {
            return false;
        }
        if (this.OX.size() == 0) {
            this.OX.add(dVar);
            return true;
        }
        for (d dVar2 : this.OX) {
            if (dVar2 != null && dVar2.OR != null && dVar.OR.userId == dVar2.OR.userId) {
                return false;
            }
        }
        this.OX.add(dVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.OX == null) {
            return 0;
        }
        return this.OX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.OX == null) {
            return null;
        }
        return this.OX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0353a c0353a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0353a c0353a2 = new C0353a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0353a2.dXS.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0353a2.dXS.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0353a2.dXS.setIsRound(true);
            c0353a2.dXS.setDrawBorder(false);
            c0353a2.dXS.setAutoChangeStyle(false);
            c0353a2.dXS.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0353a2.dXT.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0353a2);
            c0353a = c0353a2;
        } else {
            c0353a = (C0353a) view.getTag();
        }
        d dVar = (d) getItem(i);
        c0353a.dXS.setDrawBorder(true);
        if (dVar.OV == 1 && dVar.OR.totalPrice > 0) {
            c0353a.dXT.setVisibility(0);
            c0353a.dXT.setImageResource(a.f.pic_live_top1);
            c0353a.dXU.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (dVar.OV == 2 && dVar.OR.totalPrice > 0) {
            c0353a.dXT.setVisibility(0);
            c0353a.dXT.setImageResource(a.f.pic_live_top2);
            c0353a.dXU.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (dVar.OV == 3 && dVar.OR.totalPrice > 0) {
            c0353a.dXT.setVisibility(0);
            c0353a.dXT.setImageResource(a.f.pic_live_top3);
            c0353a.dXU.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0353a.dXT.setVisibility(8);
            c0353a.dXU.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0353a.dXU.setText(StringHelper.formatForHeaderDayCharmValue(dVar.OR.totalPrice));
        if (dVar.OR.totalPrice <= 0) {
            c0353a.dXU.setVisibility(4);
        } else {
            c0353a.dXU.setVisibility(0);
        }
        j.a(c0353a.dXS, dVar.OR.portrait, true, !StringUtils.isNull(dVar.OR.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0353a {
        public HeadImageView dXS;
        public ImageView dXT;
        public TextView dXU;
        public View rootView;

        public C0353a(View view) {
            this.rootView = view;
            this.dXS = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.dXT = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.dXU = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
