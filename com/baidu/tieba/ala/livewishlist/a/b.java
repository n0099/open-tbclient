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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> fwL;
    private long fwM;
    private boolean gNF;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> ahU = new ArrayList<>();
    private SparseArray<CountDownTimer> gNE = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.ahU = arrayList;
        notifyDataSetChanged();
    }

    public void mJ(boolean z) {
        this.gNF = z;
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        this.fwL = arrayList;
        notifyDataSetChanged();
    }

    public void el(long j) {
        this.fwM = j;
    }

    public ArrayList<d> getData() {
        return this.ahU;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ahU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ahU.get(i);
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
        d dVar = this.ahU.get(i);
        if (!ListUtils.isEmpty(this.fwL)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fwL.size()) {
                    break;
                } else if (!this.fwL.get(i3).wish_id.equals(dVar.fUp)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fwL.get(i3));
                    break;
                }
            }
        }
        aVar.mJ(this.gNF);
        aVar.el(this.fwM);
        aVar.a(i, this.gNE, dVar);
        return view;
    }

    public void bXL() {
        if (this.gNE != null) {
            int size = this.gNE.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.gNE.get(this.gNE.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
