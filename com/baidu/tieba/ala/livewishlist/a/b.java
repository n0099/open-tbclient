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
    private ArrayList<AlaLiveWishListData> eWc;
    private long eWd;
    private boolean giY;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> clk = new ArrayList<>();
    private SparseArray<CountDownTimer> giX = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.clk = arrayList;
        notifyDataSetChanged();
    }

    public void lv(boolean z) {
        this.giY = z;
    }

    public void aa(ArrayList<AlaLiveWishListData> arrayList) {
        this.eWc = arrayList;
        notifyDataSetChanged();
    }

    public void dK(long j) {
        this.eWd = j;
    }

    public ArrayList<c> getData() {
        return this.clk;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.clk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.clk.get(i);
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
        c cVar = this.clk.get(i);
        if (!ListUtils.isEmpty(this.eWc)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eWc.size()) {
                    break;
                } else if (!this.eWc.get(i3).wish_id.equals(cVar.fss)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.eWc.get(i3));
                    break;
                }
            }
        }
        aVar.lv(this.giY);
        aVar.dK(this.eWd);
        aVar.a(i, this.giX, cVar);
        return view;
    }

    public void bHB() {
        if (this.giX != null) {
            int size = this.giX.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.giX.get(this.giX.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
