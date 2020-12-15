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
    private ArrayList<AlaLiveWishListData> gil;
    private long gim;
    private boolean hHg;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> ajO = new ArrayList<>();
    private SparseArray<CountDownTimer> hHf = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.ajO = arrayList;
        notifyDataSetChanged();
    }

    public void oo(boolean z) {
        this.hHg = z;
    }

    public void aj(ArrayList<AlaLiveWishListData> arrayList) {
        this.gil = arrayList;
        notifyDataSetChanged();
    }

    public void fH(long j) {
        this.gim = j;
    }

    public ArrayList<d> getData() {
        return this.ajO;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ajO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ajO.get(i);
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
        d dVar = this.ajO.get(i);
        if (!ListUtils.isEmpty(this.gil)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gil.size()) {
                    break;
                } else if (!this.gil.get(i3).wish_id.equals(dVar.gIy)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.gil.get(i3));
                    break;
                }
            }
        }
        aVar.oo(this.hHg);
        aVar.fH(this.gim);
        aVar.a(i, this.hHf, dVar);
        return view;
    }

    public void clO() {
        if (this.hHf != null) {
            int size = this.hHf.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hHf.get(this.hHf.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
