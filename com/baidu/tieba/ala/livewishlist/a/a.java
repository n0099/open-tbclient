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
    /* renamed from: wc */
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
        C0675a c0675a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0675a c0675a2 = new C0675a();
            c0675a2.hrQ = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0675a2.hrQ.setDefaultBgResource(a.f.icon_live_gift_default);
            c0675a2.hrQ.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0675a2.hrQ.setAutoChangeStyle(false);
            c0675a2.hrS = (TextView) view.findViewById(a.g.wish_name);
            c0675a2.hrR = (TextView) view.findViewById(a.g.wish_count);
            c0675a2.hrT = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0675a2);
            c0675a = c0675a2;
        } else {
            c0675a = (C0675a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0675a.hrQ.startLoad(item.gui, 10, false);
            c0675a.hrS.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gus) && JavaTypesHelper.toInt(item.gus, 0) <= 0) {
                c0675a.hrT.setVisibility(8);
                c0675a.hrR.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0675a.hrR.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0675a.hrR.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0675a.hrT.setVisibility(0);
                c0675a.hrR.setText(String.format("%s", item.gus));
                c0675a.hrR.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0675a.hrR.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0675a {
        public TbImageView hrQ;
        public TextView hrR;
        public TextView hrS;
        public ImageView hrT;

        private C0675a() {
        }
    }
}
