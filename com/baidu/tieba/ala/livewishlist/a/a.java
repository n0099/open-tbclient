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
    private ArrayList<f> aiJ = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.aiJ = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aiJ == null) {
            return 0;
        }
        return this.aiJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vI */
    public f getItem(int i) {
        if (this.aiJ == null) {
            return null;
        }
        return this.aiJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0659a c0659a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0659a c0659a2 = new C0659a();
            c0659a2.hfR = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0659a2.hfR.setDefaultBgResource(a.f.icon_live_gift_default);
            c0659a2.hfR.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0659a2.hfR.setAutoChangeStyle(false);
            c0659a2.hfT = (TextView) view.findViewById(a.g.wish_name);
            c0659a2.hfS = (TextView) view.findViewById(a.g.wish_count);
            c0659a2.hfU = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0659a2);
            c0659a = c0659a2;
        } else {
            c0659a = (C0659a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0659a.hfR.startLoad(item.gke, 10, false);
            c0659a.hfT.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gko) && JavaTypesHelper.toInt(item.gko, 0) <= 0) {
                c0659a.hfU.setVisibility(8);
                c0659a.hfS.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0659a.hfS.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0659a.hfS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0659a.hfU.setVisibility(0);
                c0659a.hfS.setText(String.format("%s", item.gko));
                c0659a.hfS.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0659a.hfS.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0659a {
        public TbImageView hfR;
        public TextView hfS;
        public TextView hfT;
        public ImageView hfU;

        private C0659a() {
        }
    }
}
