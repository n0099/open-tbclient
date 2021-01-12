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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> gob;
    private long goc;
    private boolean hOA;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> ajz = new ArrayList<>();
    private SparseArray<CountDownTimer> hOz = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.ajz = arrayList;
        notifyDataSetChanged();
    }

    public void oJ(boolean z) {
        this.hOA = z;
    }

    public void ae(ArrayList<AlaLiveWishListData> arrayList) {
        this.gob = arrayList;
        notifyDataSetChanged();
    }

    public void fH(long j) {
        this.goc = j;
    }

    public ArrayList<d> getData() {
        return this.ajz;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ajz.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ajz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.ala.livewishlist.b.a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_wish_list_item_view, (ViewGroup) null);
            com.baidu.tieba.ala.livewishlist.b.a aVar2 = new com.baidu.tieba.ala.livewishlist.b.a(this.mContext, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (com.baidu.tieba.ala.livewishlist.b.a) view.getTag();
        }
        d dVar = this.ajz.get(i);
        if (!ListUtils.isEmpty(this.gob)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gob.size()) {
                    break;
                } else if (!this.gob.get(i3).wish_id.equals(dVar.gPE)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.gob.get(i3));
                    break;
                }
            }
        }
        aVar.oJ(this.hOA);
        aVar.fH(this.goc);
        aVar.a(i, this.hOz, dVar);
        return view;
    }

    public void ckO() {
        if (this.hOz != null) {
            int size = this.hOz.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hOz.get(this.hOz.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
