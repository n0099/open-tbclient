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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<f> ahW = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.ahW = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ahW == null) {
            return 0;
        }
        return this.ahW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uJ */
    public f getItem(int i) {
        if (this.ahW == null) {
            return null;
        }
        return this.ahW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0644a c0644a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0644a c0644a2 = new C0644a();
            c0644a2.gNE = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0644a2.gNE.setDefaultBgResource(a.f.icon_live_gift_default);
            c0644a2.gNE.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0644a2.gNE.setAutoChangeStyle(false);
            c0644a2.gNG = (TextView) view.findViewById(a.g.wish_name);
            c0644a2.gNF = (TextView) view.findViewById(a.g.wish_count);
            c0644a2.gNH = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0644a2);
            c0644a = c0644a2;
        } else {
            c0644a = (C0644a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0644a.gNE.startLoad(item.fUw, 10, false);
            c0644a.gNG.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.fUH) && JavaTypesHelper.toInt(item.fUH, 0) <= 0) {
                c0644a.gNH.setVisibility(8);
                c0644a.gNF.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0644a.gNF.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0644a.gNF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0644a.gNH.setVisibility(0);
                c0644a.gNF.setText(String.format("%s", item.fUH));
                c0644a.gNF.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0644a.gNF.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0644a {
        public TbImageView gNE;
        public TextView gNF;
        public TextView gNG;
        public ImageView gNH;

        private C0644a() {
        }
    }
}
