package com.baidu.tieba.ala.livewishlist.a;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> eeW;
    private long eeX;
    private boolean fmd;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> bxQ = new ArrayList<>();
    private SparseArray<CountDownTimer> fmc = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.bxQ = arrayList;
        notifyDataSetChanged();
    }

    public void jQ(boolean z) {
        this.fmd = z;
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        this.eeW = arrayList;
        notifyDataSetChanged();
    }

    public void cZ(long j) {
        this.eeX = j;
    }

    public ArrayList<c> getData() {
        return this.bxQ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bxQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bxQ.get(i);
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
        c cVar = this.bxQ.get(i);
        if (!ListUtils.isEmpty(this.eeW)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eeW.size()) {
                    break;
                } else if (!this.eeW.get(i3).wish_id.equals(cVar.evi)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.eeW.get(i3));
                    break;
                }
            }
        }
        aVar.jQ(this.fmd);
        aVar.cZ(this.eeX);
        aVar.a(i, this.fmc, cVar);
        return view;
    }

    public void bpS() {
        if (this.fmc != null) {
            int size = this.fmc.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.fmc.get(this.fmc.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
