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
import com.baidu.tieba.ala.data.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> fgn;
    private long fgo;
    private boolean gvL;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> agU = new ArrayList<>();
    private SparseArray<CountDownTimer> gvK = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.agU = arrayList;
        notifyDataSetChanged();
    }

    public void lD(boolean z) {
        this.gvL = z;
    }

    public void aa(ArrayList<AlaLiveWishListData> arrayList) {
        this.fgn = arrayList;
        notifyDataSetChanged();
    }

    public void dN(long j) {
        this.fgo = j;
    }

    public ArrayList<c> getData() {
        return this.agU;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.agU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.agU.get(i);
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
        c cVar = this.agU.get(i);
        if (!ListUtils.isEmpty(this.fgn)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fgn.size()) {
                    break;
                } else if (!this.fgn.get(i3).wish_id.equals(cVar.fDD)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fgn.get(i3));
                    break;
                }
            }
        }
        aVar.lD(this.gvL);
        aVar.dN(this.fgo);
        aVar.a(i, this.gvK, cVar);
        return view;
    }

    public void bKG() {
        if (this.gvK != null) {
            int size = this.gvK.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.gvK.get(this.gvK.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
