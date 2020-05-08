package com.baidu.tieba.ala.livewishlist.a;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> eJu;
    private long eJv;
    private boolean fTU;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> caH = new ArrayList<>();
    private SparseArray<CountDownTimer> fTT = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.caH = arrayList;
        notifyDataSetChanged();
    }

    public void kY(boolean z) {
        this.fTU = z;
    }

    public void aa(ArrayList<AlaLiveWishListData> arrayList) {
        this.eJu = arrayList;
        notifyDataSetChanged();
    }

    public void dJ(long j) {
        this.eJv = j;
    }

    public ArrayList<c> getData() {
        return this.caH;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.caH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caH.get(i);
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
        c cVar = this.caH.get(i);
        if (!ListUtils.isEmpty(this.eJu)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eJu.size()) {
                    break;
                } else if (!this.eJu.get(i3).wish_id.equals(cVar.feC)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.eJu.get(i3));
                    break;
                }
            }
        }
        aVar.kY(this.fTU);
        aVar.dJ(this.eJv);
        aVar.a(i, this.fTT, cVar);
        return view;
    }

    public void bBf() {
        if (this.fTT != null) {
            int size = this.fTT.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.fTT.get(this.fTT.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
