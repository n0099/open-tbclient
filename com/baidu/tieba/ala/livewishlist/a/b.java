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
    private ArrayList<AlaLiveWishListData> fMj;
    private long fMk;
    private boolean hfW;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> aiJ = new ArrayList<>();
    private SparseArray<CountDownTimer> hfV = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.aiJ = arrayList;
        notifyDataSetChanged();
    }

    public void ns(boolean z) {
        this.hfW = z;
    }

    public void ah(ArrayList<AlaLiveWishListData> arrayList) {
        this.fMj = arrayList;
        notifyDataSetChanged();
    }

    public void eF(long j) {
        this.fMk = j;
    }

    public ArrayList<d> getData() {
        return this.aiJ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aiJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aiJ.get(i);
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
        d dVar = this.aiJ.get(i);
        if (!ListUtils.isEmpty(this.fMj)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fMj.size()) {
                    break;
                } else if (!this.fMj.get(i3).wish_id.equals(dVar.gkb)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fMj.get(i3));
                    break;
                }
            }
        }
        aVar.ns(this.hfW);
        aVar.eF(this.fMk);
        aVar.a(i, this.hfV, dVar);
        return view;
    }

    public void ccR() {
        if (this.hfV != null) {
            int size = this.hfV.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hfV.get(this.hfV.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
