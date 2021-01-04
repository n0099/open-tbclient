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
    private ArrayList<f> akq = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.akq = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.akq == null) {
            return 0;
        }
        return this.akq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xE */
    public f getItem(int i) {
        if (this.akq == null) {
            return null;
        }
        return this.akq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0694a c0694a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0694a c0694a2 = new C0694a();
            c0694a2.hTb = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0694a2.hTb.setDefaultBgResource(a.e.icon_live_gift_default);
            c0694a2.hTb.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0694a2.hTb.setAutoChangeStyle(false);
            c0694a2.hTd = (TextView) view.findViewById(a.f.wish_name);
            c0694a2.hTc = (TextView) view.findViewById(a.f.wish_count);
            c0694a2.hTe = (ImageView) view.findViewById(a.f.wish_icon_cheng);
            view.setTag(c0694a2);
            c0694a = c0694a2;
        } else {
            c0694a = (C0694a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0694a.hTb.startLoad(item.gUn, 10, false);
            c0694a.hTd.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gUx) && JavaTypesHelper.toInt(item.gUx, 0) <= 0) {
                c0694a.hTe.setVisibility(8);
                c0694a.hTc.setText(this.mContext.getString(a.h.ala_my_not_assist));
                c0694a.hTc.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize40));
                c0694a.hTc.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            } else {
                c0694a.hTe.setVisibility(0);
                c0694a.hTc.setText(String.format("%s", item.gUx));
                c0694a.hTc.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize48));
                c0694a.hTc.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0694a {
        public TbImageView hTb;
        public TextView hTc;
        public TextView hTd;
        public ImageView hTe;

        private C0694a() {
        }
    }
}
