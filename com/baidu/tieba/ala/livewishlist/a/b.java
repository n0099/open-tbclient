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
    private ArrayList<AlaLiveWishListData> flp;
    private long flq;
    private boolean gBi;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> agL = new ArrayList<>();
    private SparseArray<CountDownTimer> gBh = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.agL = arrayList;
        notifyDataSetChanged();
    }

    public void mh(boolean z) {
        this.gBi = z;
    }

    public void ab(ArrayList<AlaLiveWishListData> arrayList) {
        this.flp = arrayList;
        notifyDataSetChanged();
    }

    public void ea(long j) {
        this.flq = j;
    }

    public ArrayList<d> getData() {
        return this.agL;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.agL.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.agL.get(i);
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
        d dVar = this.agL.get(i);
        if (!ListUtils.isEmpty(this.flp)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.flp.size()) {
                    break;
                } else if (!this.flp.get(i3).wish_id.equals(dVar.fIY)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.flp.get(i3));
                    break;
                }
            }
        }
        aVar.mh(this.gBi);
        aVar.ea(this.flq);
        aVar.a(i, this.gBh, dVar);
        return view;
    }

    public void bNL() {
        if (this.gBh != null) {
            int size = this.gBh.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.gBh.get(this.gBh.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
