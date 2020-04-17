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
    private ArrayList<AlaLiveWishListData> eJp;
    private long eJq;
    private boolean fTP;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> caB = new ArrayList<>();
    private SparseArray<CountDownTimer> fTO = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.caB = arrayList;
        notifyDataSetChanged();
    }

    public void kY(boolean z) {
        this.fTP = z;
    }

    public void aa(ArrayList<AlaLiveWishListData> arrayList) {
        this.eJp = arrayList;
        notifyDataSetChanged();
    }

    public void dJ(long j) {
        this.eJq = j;
    }

    public ArrayList<c> getData() {
        return this.caB;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.caB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caB.get(i);
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
        c cVar = this.caB.get(i);
        if (!ListUtils.isEmpty(this.eJp)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eJp.size()) {
                    break;
                } else if (!this.eJp.get(i3).wish_id.equals(cVar.fex)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.eJp.get(i3));
                    break;
                }
            }
        }
        aVar.kY(this.fTP);
        aVar.dJ(this.eJq);
        aVar.a(i, this.fTO, cVar);
        return view;
    }

    public void bBh() {
        if (this.fTO != null) {
            int size = this.fTO.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.fTO.get(this.fTO.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
