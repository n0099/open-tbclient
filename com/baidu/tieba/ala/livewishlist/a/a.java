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
    private ArrayList<e> bBZ = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.bBZ = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBZ == null) {
            return 0;
        }
        return this.bBZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qG */
    public e getItem(int i) {
        if (this.bBZ == null) {
            return null;
        }
        return this.bBZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0469a c0469a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_my_assis_wish_list_item_view, (ViewGroup) null);
            C0469a c0469a2 = new C0469a();
            c0469a2.foP = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0469a2.foP.setDefaultBgResource(a.f.icon_live_gift_default);
            c0469a2.foP.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0469a2.foP.setAutoChangeStyle(false);
            c0469a2.foR = (TextView) view.findViewById(a.g.wish_name);
            c0469a2.foQ = (TextView) view.findViewById(a.g.wish_count);
            c0469a2.foS = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0469a2);
            c0469a = c0469a2;
        } else {
            c0469a = (C0469a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0469a.foP.startLoad(item.ezK, 10, false);
            c0469a.foR.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.ezV) && JavaTypesHelper.toInt(item.ezV, 0) <= 0) {
                c0469a.foS.setVisibility(8);
                c0469a.foQ.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0469a.foQ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0469a.foQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0469a.foS.setVisibility(0);
                c0469a.foQ.setText(String.format("%s", item.ezV));
                c0469a.foQ.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0469a.foQ.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0469a {
        public TbImageView foP;
        public TextView foQ;
        public TextView foR;
        public ImageView foS;

        private C0469a() {
        }
    }
}
