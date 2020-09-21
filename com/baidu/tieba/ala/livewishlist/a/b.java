package com.baidu.tieba.ala.livewishlist.a;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.d;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> fAa;
    private long fAb;
    private boolean gQZ;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> air = new ArrayList<>();
    private SparseArray<CountDownTimer> gQY = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.air = arrayList;
        notifyDataSetChanged();
    }

    public void mP(boolean z) {
        this.gQZ = z;
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        this.fAa = arrayList;
        notifyDataSetChanged();
    }

    public void eo(long j) {
        this.fAb = j;
    }

    public ArrayList<d> getData() {
        return this.air;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.air.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.air.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.ala.livewishlist.b.a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_wish_list_item_view, (ViewGroup) null);
            com.baidu.tieba.ala.livewishlist.b.a aVar2 = new com.baidu.tieba.ala.livewishlist.b.a(this.mContext, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (com.baidu.tieba.ala.livewishlist.b.a) view.getTag();
        }
        d dVar = this.air.get(i);
        if (!ListUtils.isEmpty(this.fAa)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fAa.size()) {
                    break;
                } else if (!this.fAa.get(i3).wish_id.equals(dVar.fXI)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fAa.get(i3));
                    break;
                }
            }
        }
        aVar.mP(this.gQZ);
        aVar.eo(this.fAb);
        aVar.a(i, this.gQY, dVar);
        return view;
    }

    public void bZt() {
        if (this.gQY != null) {
            int size = this.gQY.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.gQY.get(this.gQY.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
