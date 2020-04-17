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
    private ArrayList<e> caB = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.caB = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.caB == null) {
            return 0;
        }
        return this.caB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rb */
    public e getItem(int i) {
        if (this.caB == null) {
            return null;
        }
        return this.caB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0505a c0505a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0505a c0505a2 = new C0505a();
            c0505a2.fTK = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0505a2.fTK.setDefaultBgResource(a.f.icon_live_gift_default);
            c0505a2.fTK.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0505a2.fTK.setAutoChangeStyle(false);
            c0505a2.fTM = (TextView) view.findViewById(a.g.wish_name);
            c0505a2.fTL = (TextView) view.findViewById(a.g.wish_count);
            c0505a2.fTN = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0505a2);
            c0505a = c0505a2;
        } else {
            c0505a = (C0505a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0505a.fTK.startLoad(item.feA, 10, false);
            c0505a.fTM.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.feL) && JavaTypesHelper.toInt(item.feL, 0) <= 0) {
                c0505a.fTN.setVisibility(8);
                c0505a.fTL.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0505a.fTL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0505a.fTL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0505a.fTN.setVisibility(0);
                c0505a.fTL.setText(String.format("%s", item.feL));
                c0505a.fTL.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0505a.fTL.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0505a {
        public TbImageView fTK;
        public TextView fTL;
        public TextView fTM;
        public ImageView fTN;

        private C0505a() {
        }
    }
}
