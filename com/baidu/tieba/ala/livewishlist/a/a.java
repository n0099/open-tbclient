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
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<e> caH = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.caH = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.caH == null) {
            return 0;
        }
        return this.caH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rb */
    public e getItem(int i) {
        if (this.caH == null) {
            return null;
        }
        return this.caH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0526a c0526a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0526a c0526a2 = new C0526a();
            c0526a2.fTP = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0526a2.fTP.setDefaultBgResource(a.f.icon_live_gift_default);
            c0526a2.fTP.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0526a2.fTP.setAutoChangeStyle(false);
            c0526a2.fTR = (TextView) view.findViewById(a.g.wish_name);
            c0526a2.fTQ = (TextView) view.findViewById(a.g.wish_count);
            c0526a2.fTS = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0526a2);
            c0526a = c0526a2;
        } else {
            c0526a = (C0526a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0526a.fTP.startLoad(item.feF, 10, false);
            c0526a.fTR.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.feQ) && JavaTypesHelper.toInt(item.feQ, 0) <= 0) {
                c0526a.fTS.setVisibility(8);
                c0526a.fTQ.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0526a.fTQ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0526a.fTQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0526a.fTS.setVisibility(0);
                c0526a.fTQ.setText(String.format("%s", item.feQ));
                c0526a.fTQ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0526a.fTQ.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0526a {
        public TbImageView fTP;
        public TextView fTQ;
        public TextView fTR;
        public ImageView fTS;

        private C0526a() {
        }
    }
}
