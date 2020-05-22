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
    private ArrayList<e> clk = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.clk = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.clk == null) {
            return 0;
        }
        return this.clk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rD */
    public e getItem(int i) {
        if (this.clk == null) {
            return null;
        }
        return this.clk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0576a c0576a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0576a c0576a2 = new C0576a();
            c0576a2.giI = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0576a2.giI.setDefaultBgResource(a.f.icon_live_gift_default);
            c0576a2.giI.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0576a2.giI.setAutoChangeStyle(false);
            c0576a2.giK = (TextView) view.findViewById(a.g.wish_name);
            c0576a2.giJ = (TextView) view.findViewById(a.g.wish_count);
            c0576a2.giL = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0576a2);
            c0576a = c0576a2;
        } else {
            c0576a = (C0576a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0576a.giI.startLoad(item.fsk, 10, false);
            c0576a.giK.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.fsv) && JavaTypesHelper.toInt(item.fsv, 0) <= 0) {
                c0576a.giL.setVisibility(8);
                c0576a.giJ.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0576a.giJ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0576a.giJ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0576a.giL.setVisibility(0);
                c0576a.giJ.setText(String.format("%s", item.fsv));
                c0576a.giJ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0576a.giJ.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0576a {
        public TbImageView giI;
        public TextView giJ;
        public TextView giK;
        public ImageView giL;

        private C0576a() {
        }
    }
}
