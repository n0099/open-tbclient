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
    private ArrayList<AlaLiveWishListData> ejn;
    private long ejo;
    private boolean foU;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> bBZ = new ArrayList<>();
    private SparseArray<CountDownTimer> foT = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.bBZ = arrayList;
        notifyDataSetChanged();
    }

    public void jS(boolean z) {
        this.foU = z;
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        this.ejn = arrayList;
        notifyDataSetChanged();
    }

    public void db(long j) {
        this.ejo = j;
    }

    public ArrayList<c> getData() {
        return this.bBZ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bBZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bBZ.get(i);
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
        c cVar = this.bBZ.get(i);
        if (!ListUtils.isEmpty(this.ejn)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.ejn.size()) {
                    break;
                } else if (!this.ejn.get(i3).wish_id.equals(cVar.ezH)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.ejn.get(i3));
                    break;
                }
            }
        }
        aVar.jS(this.foU);
        aVar.db(this.ejo);
        aVar.a(i, this.foT, cVar);
        return view;
    }

    public void brz() {
        if (this.foT != null) {
            int size = this.foT.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.foT.get(this.foT.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
