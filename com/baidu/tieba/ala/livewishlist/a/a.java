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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.data.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<e> bxd = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.bxd = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bxd == null) {
            return 0;
        }
        return this.bxd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qu */
    public e getItem(int i) {
        if (this.bxd == null) {
            return null;
        }
        return this.bxd.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0457a c0457a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0457a c0457a2 = new C0457a();
            c0457a2.fiN = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0457a2.fiN.setDefaultBgResource(a.f.icon_live_gift_default);
            c0457a2.fiN.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0457a2.fiN.setAutoChangeStyle(false);
            c0457a2.fiP = (TextView) view.findViewById(a.g.wish_name);
            c0457a2.fiO = (TextView) view.findViewById(a.g.wish_count);
            c0457a2.fiQ = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0457a2);
            c0457a = c0457a2;
        } else {
            c0457a = (C0457a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0457a.fiN.startLoad(item.eua, 10, false);
            c0457a.fiP.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.eul) && JavaTypesHelper.toInt(item.eul, 0) <= 0) {
                c0457a.fiQ.setVisibility(8);
                c0457a.fiO.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0457a.fiO.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0457a.fiO.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0457a.fiQ.setVisibility(0);
                c0457a.fiO.setText(String.format("%s", item.eul));
                c0457a.fiO.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0457a.fiO.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0457a {
        public TbImageView fiN;
        public TextView fiO;
        public TextView fiP;
        public ImageView fiQ;

        private C0457a() {
        }
    }
}
