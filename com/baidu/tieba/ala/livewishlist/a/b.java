package com.baidu.tieba.ala.livewishlist.a;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveWishListData;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.data.c;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> eeO;
    private long eeP;
    private boolean fiS;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> bxd = new ArrayList<>();
    private SparseArray<CountDownTimer> fiR = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.bxd = arrayList;
        notifyDataSetChanged();
    }

    public void jF(boolean z) {
        this.fiS = z;
    }

    public void Y(ArrayList<AlaLiveWishListData> arrayList) {
        this.eeO = arrayList;
        notifyDataSetChanged();
    }

    public void cU(long j) {
        this.eeP = j;
    }

    public ArrayList<c> getData() {
        return this.bxd;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bxd.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bxd.get(i);
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
        c cVar = this.bxd.get(i);
        if (!ListUtils.isEmpty(this.eeO)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eeO.size()) {
                    break;
                } else if (!this.eeO.get(i3).wish_id.equals(cVar.etX)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.eeO.get(i3));
                    break;
                }
            }
        }
        aVar.jF(this.fiS);
        aVar.cU(this.eeP);
        aVar.a(i, this.fiR, cVar);
        return view;
    }

    public void boR() {
        if (this.fiR != null) {
            int size = this.fiR.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.fiR.get(this.fiR.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
