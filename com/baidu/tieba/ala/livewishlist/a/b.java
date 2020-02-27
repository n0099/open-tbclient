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
    private ArrayList<AlaLiveWishListData> eiZ;
    private long eja;
    private boolean foG;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<c> bBX = new ArrayList<>();
    private SparseArray<CountDownTimer> foF = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<c> arrayList) {
        this.bBX = arrayList;
        notifyDataSetChanged();
    }

    public void jS(boolean z) {
        this.foG = z;
    }

    public void Z(ArrayList<AlaLiveWishListData> arrayList) {
        this.eiZ = arrayList;
        notifyDataSetChanged();
    }

    public void db(long j) {
        this.eja = j;
    }

    public ArrayList<c> getData() {
        return this.bBX;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bBX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bBX.get(i);
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
        c cVar = this.bBX.get(i);
        if (!ListUtils.isEmpty(this.eiZ)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.eiZ.size()) {
                    break;
                } else if (!this.eiZ.get(i3).wish_id.equals(cVar.ezt)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.eiZ.get(i3));
                    break;
                }
            }
        }
        aVar.jS(this.foG);
        aVar.db(this.eja);
        aVar.a(i, this.foF, cVar);
        return view;
    }

    public void brw() {
        if (this.foF != null) {
            int size = this.foF.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.foF.get(this.foF.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
