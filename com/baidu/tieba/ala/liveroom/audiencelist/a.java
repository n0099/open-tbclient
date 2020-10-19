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
    private List<m> aHJ;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void d(n nVar) {
        this.aHJ = new ArrayList();
        if (nVar != null && nVar.getList() != null && !nVar.getList().isEmpty()) {
            for (m mVar : nVar.getList()) {
                if (mVar != null && mVar.aHD != null) {
                    this.aHJ.add(mVar);
                }
            }
        }
    }

    public boolean b(m mVar) {
        if (mVar == null || mVar.aHD == null) {
            return false;
        }
        if (this.aHJ == null) {
            return false;
        }
        if (this.aHJ.size() == 0) {
            this.aHJ.add(mVar);
            return true;
        }
        for (m mVar2 : this.aHJ) {
            if (mVar2 != null && mVar2.aHD != null && mVar.aHD.userId == mVar2.aHD.userId) {
                return false;
            }
        }
        this.aHJ.add(mVar);
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHJ == null) {
            return 0;
        }
        return this.aHJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aHJ == null) {
            return null;
        }
        return this.aHJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0637a c0637a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_header_image, (ViewGroup) null);
            C0637a c0637a2 = new C0637a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                c0637a2.gGO.setDefaultResource(a.f.sdk_icon_default_avatar100_hk);
            } else {
                c0637a2.gGO.setDefaultResource(a.f.sdk_icon_default_avatar100);
            }
            c0637a2.gGO.setIsRound(true);
            c0637a2.gGO.setDrawBorder(true);
            c0637a2.gGO.setBorderColor(this.mContext.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
            c0637a2.gGO.setAutoChangeStyle(false);
            c0637a2.gGO.setScaleType(ImageView.ScaleType.CENTER_CROP);
            c0637a2.gGP.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setTag(c0637a2);
            c0637a = c0637a2;
        } else {
            c0637a = (C0637a) view.getTag();
        }
        m mVar = (m) getItem(i);
        c0637a.gGO.setDrawBorder(true);
        if (mVar.aHG == 1 && mVar.aHD.totalPrice > 0) {
            c0637a.gGP.setVisibility(0);
            c0637a.gGP.setImageResource(a.f.pic_live_top1);
            c0637a.gGQ.setBackgroundResource(a.f.round_header_day_list_bg_1);
        } else if (mVar.aHG == 2 && mVar.aHD.totalPrice > 0) {
            c0637a.gGP.setVisibility(0);
            c0637a.gGP.setImageResource(a.f.pic_live_top2);
            c0637a.gGQ.setBackgroundResource(a.f.round_header_day_list_bg_2);
        } else if (mVar.aHG == 3 && mVar.aHD.totalPrice > 0) {
            c0637a.gGP.setVisibility(0);
            c0637a.gGP.setImageResource(a.f.pic_live_top3);
            c0637a.gGQ.setBackgroundResource(a.f.round_header_day_list_bg_3);
        } else {
            c0637a.gGP.setVisibility(8);
            c0637a.gGQ.setBackgroundResource(a.f.round_header_day_list_bg_normal);
        }
        c0637a.gGQ.setText(StringHelper.formatForHeaderDayCharmValue(mVar.aHD.totalPrice));
        if (mVar.aHD.totalPrice <= 0) {
            c0637a.gGQ.setVisibility(4);
        } else {
            c0637a.gGQ.setVisibility(0);
        }
        l.a(c0637a.gGO, mVar.aHD.portrait, true, !StringUtils.isNull(mVar.aHD.appId));
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.audiencelist.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0637a {
        public HeadImageView gGO;
        public ImageView gGP;
        public TextView gGQ;
        public View rootView;

        public C0637a(View view) {
            this.rootView = view;
            this.gGO = (HeadImageView) view.findViewById(a.g.ala_live_room_audience_header_img);
            this.gGP = (ImageView) view.findViewById(a.g.ala_live_room_audience_pendant);
            this.gGQ = (TextView) view.findViewById(a.g.ala_live_room_audience_charm_count);
        }
    }
}
