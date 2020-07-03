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
import com.baidu.tieba.ala.data.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<e> agU = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.agU = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.agU == null) {
            return 0;
        }
        return this.agU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sd */
    public e getItem(int i) {
        if (this.agU == null) {
            return null;
        }
        return this.agU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0585a c0585a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0585a c0585a2 = new C0585a();
            c0585a2.gvG = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0585a2.gvG.setDefaultBgResource(a.f.icon_live_gift_default);
            c0585a2.gvG.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0585a2.gvG.setAutoChangeStyle(false);
            c0585a2.gvI = (TextView) view.findViewById(a.g.wish_name);
            c0585a2.gvH = (TextView) view.findViewById(a.g.wish_count);
            c0585a2.gvJ = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0585a2);
            c0585a = c0585a2;
        } else {
            c0585a = (C0585a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0585a.gvG.startLoad(item.fDG, 10, false);
            c0585a.gvI.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.fDR) && JavaTypesHelper.toInt(item.fDR, 0) <= 0) {
                c0585a.gvJ.setVisibility(8);
                c0585a.gvH.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0585a.gvH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0585a.gvH.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0585a.gvJ.setVisibility(0);
                c0585a.gvH.setText(String.format("%s", item.fDR));
                c0585a.gvH.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0585a.gvH.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0585a {
        public TbImageView gvG;
        public TextView gvH;
        public TextView gvI;
        public ImageView gvJ;

        private C0585a() {
        }
    }
}
