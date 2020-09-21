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
    private ArrayList<f> air = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.air = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.air == null) {
            return 0;
        }
        return this.air.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vc */
    public f getItem(int i) {
        if (this.air == null) {
            return null;
        }
        return this.air.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0641a c0641a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0641a c0641a2 = new C0641a();
            c0641a2.gQU = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0641a2.gQU.setDefaultBgResource(a.f.icon_live_gift_default);
            c0641a2.gQU.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0641a2.gQU.setAutoChangeStyle(false);
            c0641a2.gQW = (TextView) view.findViewById(a.g.wish_name);
            c0641a2.gQV = (TextView) view.findViewById(a.g.wish_count);
            c0641a2.gQX = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0641a2);
            c0641a = c0641a2;
        } else {
            c0641a = (C0641a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0641a.gQU.startLoad(item.fXL, 10, false);
            c0641a.gQW.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.fXW) && JavaTypesHelper.toInt(item.fXW, 0) <= 0) {
                c0641a.gQX.setVisibility(8);
                c0641a.gQV.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0641a.gQV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0641a.gQV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0641a.gQX.setVisibility(0);
                c0641a.gQV.setText(String.format("%s", item.fXW));
                c0641a.gQV.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0641a.gQV.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0641a {
        public TbImageView gQU;
        public TextView gQV;
        public TextView gQW;
        public ImageView gQX;

        private C0641a() {
        }
    }
}
