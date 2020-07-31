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
    private ArrayList<f> agL = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.agL = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.agL == null) {
            return 0;
        }
        return this.agL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sv */
    public f getItem(int i) {
        if (this.agL == null) {
            return null;
        }
        return this.agL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0594a c0594a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0594a c0594a2 = new C0594a();
            c0594a2.gBd = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0594a2.gBd.setDefaultBgResource(a.f.icon_live_gift_default);
            c0594a2.gBd.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0594a2.gBd.setAutoChangeStyle(false);
            c0594a2.gBf = (TextView) view.findViewById(a.g.wish_name);
            c0594a2.gBe = (TextView) view.findViewById(a.g.wish_count);
            c0594a2.gBg = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0594a2);
            c0594a = c0594a2;
        } else {
            c0594a = (C0594a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0594a.gBd.startLoad(item.fJb, 10, false);
            c0594a.gBf.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.fJm) && JavaTypesHelper.toInt(item.fJm, 0) <= 0) {
                c0594a.gBg.setVisibility(8);
                c0594a.gBe.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0594a.gBe.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0594a.gBe.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0594a.gBg.setVisibility(0);
                c0594a.gBe.setText(String.format("%s", item.fJm));
                c0594a.gBe.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0594a.gBe.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0594a {
        public TbImageView gBd;
        public TextView gBe;
        public TextView gBf;
        public ImageView gBg;

        private C0594a() {
        }
    }
}
