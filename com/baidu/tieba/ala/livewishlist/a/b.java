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
    private ArrayList<AlaLiveWishListData> gar;
    private long gas;
    private boolean hxS;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> aiK = new ArrayList<>();
    private SparseArray<CountDownTimer> hxR = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.aiK = arrayList;
        notifyDataSetChanged();
    }

    public void nS(boolean z) {
        this.hxS = z;
    }

    public void ai(ArrayList<AlaLiveWishListData> arrayList) {
        this.gar = arrayList;
        notifyDataSetChanged();
    }

    public void fd(long j) {
        this.gas = j;
    }

    public ArrayList<d> getData() {
        return this.aiK;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aiK.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aiK.get(i);
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
        d dVar = this.aiK.get(i);
        if (!ListUtils.isEmpty(this.gar)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gar.size()) {
                    break;
                } else if (!this.gar.get(i3).wish_id.equals(dVar.gzT)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.gar.get(i3));
                    break;
                }
            }
        }
        aVar.nS(this.hxS);
        aVar.fd(this.gas);
        aVar.a(i, this.hxR, dVar);
        return view;
    }

    public void ciz() {
        if (this.hxR != null) {
            int size = this.hxR.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hxR.get(this.hxR.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
