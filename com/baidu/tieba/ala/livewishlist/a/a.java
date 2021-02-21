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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.f;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<f> ajo = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.ajo = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ajo == null) {
            return 0;
        }
        return this.ajo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wj */
    public f getItem(int i) {
        if (this.ajo == null) {
            return null;
        }
        return this.ajo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0678a c0678a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0678a c0678a2 = new C0678a();
            c0678a2.hTf = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0678a2.hTf.setDefaultBgResource(a.e.icon_live_gift_default);
            c0678a2.hTf.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0678a2.hTf.setAutoChangeStyle(false);
            c0678a2.hTh = (TextView) view.findViewById(a.f.wish_name);
            c0678a2.hTg = (TextView) view.findViewById(a.f.wish_count);
            c0678a2.hTi = (ImageView) view.findViewById(a.f.wish_icon_cheng);
            view.setTag(c0678a2);
            c0678a = c0678a2;
        } else {
            c0678a = (C0678a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0678a.hTf.startLoad(item.gSE, 10, false);
            c0678a.hTh.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gSP) && JavaTypesHelper.toInt(item.gSP, 0) <= 0) {
                c0678a.hTi.setVisibility(8);
                c0678a.hTg.setText(this.mContext.getString(a.h.ala_my_not_assist));
                c0678a.hTg.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize40));
                c0678a.hTg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            } else {
                c0678a.hTi.setVisibility(0);
                c0678a.hTg.setText(String.format("%s", item.gSP));
                c0678a.hTg.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize48));
                c0678a.hTg.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0678a {
        public TbImageView hTf;
        public TextView hTg;
        public TextView hTh;
        public ImageView hTi;

        private C0678a() {
        }
    }
}
