package com.baidu.tieba.ala.livewishlist.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<e> bxQ = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.bxQ = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bxQ == null) {
            return 0;
        }
        return this.bxQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qz */
    public e getItem(int i) {
        if (this.bxQ == null) {
            return null;
        }
        return this.bxQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0461a c0461a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0461a c0461a2 = new C0461a();
            c0461a2.flY = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0461a2.flY.setDefaultBgResource(a.f.icon_live_gift_default);
            c0461a2.flY.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0461a2.flY.setAutoChangeStyle(false);
            c0461a2.fma = (TextView) view.findViewById(a.g.wish_name);
            c0461a2.flZ = (TextView) view.findViewById(a.g.wish_count);
            c0461a2.fmb = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0461a2);
            c0461a = c0461a2;
        } else {
            c0461a = (C0461a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0461a.flY.startLoad(item.evl, 10, false);
            c0461a.fma.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.evw) && JavaTypesHelper.toInt(item.evw, 0) <= 0) {
                c0461a.fmb.setVisibility(8);
                c0461a.flZ.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0461a.flZ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0461a.flZ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0461a.fmb.setVisibility(0);
                c0461a.flZ.setText(String.format("%s", item.evw));
                c0461a.flZ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0461a.flZ.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0461a {
        public TbImageView flY;
        public TextView flZ;
        public TextView fma;
        public ImageView fmb;

        private C0461a() {
        }
    }
}
