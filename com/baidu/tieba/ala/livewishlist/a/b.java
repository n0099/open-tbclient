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
    private ArrayList<AlaLiveWishListData> fwP;
    private long fwQ;
    private boolean gNJ;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> ahW = new ArrayList<>();
    private SparseArray<CountDownTimer> gNI = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.ahW = arrayList;
        notifyDataSetChanged();
    }

    public void mL(boolean z) {
        this.gNJ = z;
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        this.fwP = arrayList;
        notifyDataSetChanged();
    }

    public void el(long j) {
        this.fwQ = j;
    }

    public ArrayList<d> getData() {
        return this.ahW;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ahW.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ahW.get(i);
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
        d dVar = this.ahW.get(i);
        if (!ListUtils.isEmpty(this.fwP)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fwP.size()) {
                    break;
                } else if (!this.fwP.get(i3).wish_id.equals(dVar.fUt)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fwP.get(i3));
                    break;
                }
            }
        }
        aVar.mL(this.gNJ);
        aVar.el(this.fwQ);
        aVar.a(i, this.gNI, dVar);
        return view;
    }

    public void bXM() {
        if (this.gNI != null) {
            int size = this.gNI.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.gNI.get(this.gNI.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
