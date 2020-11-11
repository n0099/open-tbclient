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
    private ArrayList<f> aiK = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.aiK = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aiK == null) {
            return 0;
        }
        return this.aiK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wp */
    public f getItem(int i) {
        if (this.aiK == null) {
            return null;
        }
        return this.aiK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0689a c0689a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0689a c0689a2 = new C0689a();
            c0689a2.hxN = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0689a2.hxN.setDefaultBgResource(a.e.icon_live_gift_default);
            c0689a2.hxN.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0689a2.hxN.setAutoChangeStyle(false);
            c0689a2.hxP = (TextView) view.findViewById(a.f.wish_name);
            c0689a2.hxO = (TextView) view.findViewById(a.f.wish_count);
            c0689a2.hxQ = (ImageView) view.findViewById(a.f.wish_icon_cheng);
            view.setTag(c0689a2);
            c0689a = c0689a2;
        } else {
            c0689a = (C0689a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0689a.hxN.startLoad(item.gzW, 10, false);
            c0689a.hxP.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gAg) && JavaTypesHelper.toInt(item.gAg, 0) <= 0) {
                c0689a.hxQ.setVisibility(8);
                c0689a.hxO.setText(this.mContext.getString(a.h.ala_my_not_assist));
                c0689a.hxO.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize40));
                c0689a.hxO.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            } else {
                c0689a.hxQ.setVisibility(0);
                c0689a.hxO.setText(String.format("%s", item.gAg));
                c0689a.hxO.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize48));
                c0689a.hxO.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0689a {
        public TbImageView hxN;
        public TextView hxO;
        public TextView hxP;
        public ImageView hxQ;

        private C0689a() {
        }
    }
}
