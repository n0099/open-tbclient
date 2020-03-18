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
    private ArrayList<AlaLiveWishListData> ejD;
    private long ejE;
    private boolean fpu;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> bCk = new ArrayList<>();
    private SparseArray<CountDownTimer> fpt = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.bCk = arrayList;
        notifyDataSetChanged();
    }

    public void jU(boolean z) {
        this.fpu = z;
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        this.ejD = arrayList;
        notifyDataSetChanged();
    }

    public void db(long j) {
        this.ejE = j;
    }

    public ArrayList<c> getData() {
        return this.bCk;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bCk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bCk.get(i);
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
        c cVar = this.bCk.get(i);
        if (!ListUtils.isEmpty(this.ejD)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.ejD.size()) {
                    break;
                } else if (!this.ejD.get(i3).wish_id.equals(cVar.eAd)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.ejD.get(i3));
                    break;
                }
            }
        }
        aVar.jU(this.fpu);
        aVar.db(this.ejE);
        aVar.a(i, this.fpt, cVar);
        return view;
    }

    public void brE() {
        if (this.fpt != null) {
            int size = this.fpt.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.fpt.get(this.fpt.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
