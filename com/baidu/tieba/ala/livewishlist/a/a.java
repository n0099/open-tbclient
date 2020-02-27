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
    private ArrayList<e> bBX = new ArrayList<>();
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<e> arrayList) {
        this.bBX = new ArrayList<>(arrayList);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBX == null) {
            return 0;
        }
        return this.bBX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qG */
    public e getItem(int i) {
        if (this.bBX == null) {
            return null;
        }
        return this.bBX.get(i);
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
            c0469a2.foB = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0469a2.foB.setDefaultBgResource(a.f.icon_live_gift_default);
            c0469a2.foB.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0469a2.foB.setAutoChangeStyle(false);
            c0469a2.foD = (TextView) view.findViewById(a.g.wish_name);
            c0469a2.foC = (TextView) view.findViewById(a.g.wish_count);
            c0469a2.foE = (ImageView) view.findViewById(a.g.wish_icon_cheng);
            view.setTag(c0469a2);
            c0469a = c0469a2;
        } else {
            c0469a = (C0469a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            c0469a.foB.startLoad(item.ezw, 10, false);
            c0469a.foD.setText(item.mGiftName);
            if (!TextUtils.isEmpty(item.ezH) && JavaTypesHelper.toInt(item.ezH, 0) <= 0) {
                c0469a.foE.setVisibility(8);
                c0469a.foC.setText(this.mContext.getString(a.i.ala_my_not_assist));
                c0469a.foC.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize40));
                c0469a.foC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                c0469a.foE.setVisibility(0);
                c0469a.foC.setText(String.format("%s", item.ezH));
                c0469a.foC.setTextSize(0, this.mContext.getResources().getDimension(a.e.sdk_fontsize48));
                c0469a.foC.setTextColor(Color.parseColor("#C4586A"));
            }
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.livewishlist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0469a {
        public TbImageView foB;
        public TextView foC;
        public TextView foD;
        public ImageView foE;

        private C0469a() {
        }
    }
}
