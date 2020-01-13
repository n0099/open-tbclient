package com.baidu.tieba.ala.liveroom.audiencelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private List<f> Wk;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void e(g gVar) {
        this.Wk = new ArrayList();
        if (gVar != null && gVar.getList() != null && !gVar.getList().isEmpty()) {
            for (f fVar : gVar.getList()) {
                if (fVar != null && fVar.Wf != null) {
                    this.Wk.add(fVar);
                }
            }
        }
    }

    public boolean b(f fVar) {
        if (fVar == null || fVar.Wf == null) {
            return false;
        }
        if (this.Wk == null) {
            return false;
        }
        if (this.Wk.size() == 0) {
            this.Wk.add(fVar);
            return true;
        }
        for (f fVar2 : this.Wk) {
            if (fVar2 != null && fVar2.Wf != null && fVar.Wf.userId == fVar2.Wf.userId) {
                return false;
            }
        }
        this.Wk.add(fVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wk == null) {
            return 0;
        }
        return this.Wk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wk == null) {
            return null;
        }
        return this.Wk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0444a c0444a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0444a c0444a2 = new C0444a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0444a2.ePo.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0444a2.ePo.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0444a2.ePo.setIsRound(true);
            c0444a2.ePo.setDrawBorder(true);
            c0444a2.ePo.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0444a2.ePo.setAutoChangeStyle(false);
            c0444a2.ePo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0444a2.ePp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0444a2);
            c0444a = c0444a2;
        } else {
            c0444a = (C0444a) view.getTag();
        }
        f fVar = (f) getItem(i);
        c0444a.ePo.setDrawBorder(true);
        if (fVar.Wi == 1 && fVar.Wf.totalPrice > 0) {
            c0444a.ePp.setVisibility(0);
            c0444a.ePp.setImageResource(a.f.pic_live_top1);
            c0444a.ePq.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (fVar.Wi == 2 && fVar.Wf.totalPrice > 0) {
            c0444a.ePp.setVisibility(0);
            c0444a.ePp.setImageResource(a.f.pic_live_top2);
            c0444a.ePq.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (fVar.Wi == 3 && fVar.Wf.totalPrice > 0) {
            c0444a.ePp.setVisibility(0);
            c0444a.ePp.setImageResource(a.f.pic_live_top3);
            c0444a.ePq.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0444a.ePp.setVisibility(8);
            c0444a.ePq.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0444a.ePq.setText(StringHelper.formatForHeaderDayCharmValue(fVar.Wf.totalPrice));
        if (fVar.Wf.totalPrice <= 0) {
            c0444a.ePq.setVisibility(4);
        } else {
            c0444a.ePq.setVisibility(0);
        }
        k.a(c0444a.ePo, fVar.Wf.portrait, true, !StringUtils.isNull(fVar.Wf.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0444a {
        public HeadImageView ePo;
        public ImageView ePp;
        public TextView ePq;
        public View rootView;

        public C0444a(View view) {
            this.rootView = view;
            this.ePo = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.ePp = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.ePq = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
