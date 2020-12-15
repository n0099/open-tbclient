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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<f> ajO = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.ajO = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ajO == null) {
            return 0;
        }
        return this.ajO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xs */
    public f getItem(int i) {
        if (this.ajO == null) {
            return null;
        }
        return this.ajO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0702a c0702a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0702a c0702a2 = new C0702a();
            c0702a2.hHb = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0702a2.hHb.setDefaultBgResource(a.e.icon_live_gift_default);
            c0702a2.hHb.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0702a2.hHb.setAutoChangeStyle(false);
            c0702a2.hHd = (TextView) view.findViewById(a.f.wish_name);
            c0702a2.hHc = (TextView) view.findViewById(a.f.wish_count);
            c0702a2.hHe = (ImageView) view.findViewById(a.f.wish_icon_cheng);
            view.setTag(c0702a2);
            c0702a = c0702a2;
        } else {
            c0702a = (C0702a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0702a.hHb.startLoad(item.gIB, 10, false);
            c0702a.hHd.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gIL) && JavaTypesHelper.toInt(item.gIL, 0) <= 0) {
                c0702a.hHe.setVisibility(8);
                c0702a.hHc.setText(this.mContext.getString(a.h.ala_my_not_assist));
                c0702a.hHc.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize40));
                c0702a.hHc.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            } else {
                c0702a.hHe.setVisibility(0);
                c0702a.hHc.setText(String.format("%s", item.gIL));
                c0702a.hHc.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize48));
                c0702a.hHc.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0702a {
        public TbImageView hHb;
        public TextView hHc;
        public TextView hHd;
        public ImageView hHe;

        private C0702a() {
        }
    }
}
