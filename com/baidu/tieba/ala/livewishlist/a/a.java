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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<f> akG = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<f> arrayList) {
        this.akG = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.akG == null) {
            return 0;
        }
        return this.akG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wk */
    public f getItem(int i) {
        if (this.akG == null) {
            return null;
        }
        return this.akG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0684a c0684a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0684a c0684a2 = new C0684a();
            c0684a2.hUO = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0684a2.hUO.setDefaultBgResource(a.e.icon_live_gift_default);
            c0684a2.hUO.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0684a2.hUO.setAutoChangeStyle(false);
            c0684a2.hUQ = (TextView) view.findViewById(a.f.wish_name);
            c0684a2.hUP = (TextView) view.findViewById(a.f.wish_count);
            c0684a2.hUR = (ImageView) view.findViewById(a.f.wish_icon_cheng);
            view.setTag(c0684a2);
            c0684a = c0684a2;
        } else {
            c0684a = (C0684a) view.getTag();
        }
        f item = getItem(i);
        if (item != null) {
            c0684a.hUO.startLoad(item.gUn, 10, false);
            c0684a.hUQ.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.gUy) && JavaTypesHelper.toInt(item.gUy, 0) <= 0) {
                c0684a.hUR.setVisibility(8);
                c0684a.hUP.setText(this.mContext.getString(a.h.ala_my_not_assist));
                c0684a.hUP.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize40));
                c0684a.hUP.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            } else {
                c0684a.hUR.setVisibility(0);
                c0684a.hUP.setText(String.format("%s", item.gUy));
                c0684a.hUP.setTextSize(0, this.mContext.getResources().getDimension(a.d.sdk_fontsize48));
                c0684a.hUP.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0684a {
        public TbImageView hUO;
        public TextView hUP;
        public TextView hUQ;
        public ImageView hUR;

        private C0684a() {
        }
    }
}
