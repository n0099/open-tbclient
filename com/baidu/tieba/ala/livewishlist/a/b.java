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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> gsI;
    private long gsJ;
    private boolean hTg;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> akq = new ArrayList<>();
    private SparseArray<CountDownTimer> hTf = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.akq = arrayList;
        notifyDataSetChanged();
    }

    public void oN(boolean z) {
        this.hTg = z;
    }

    public void aj(ArrayList<AlaLiveWishListData> arrayList) {
        this.gsI = arrayList;
        notifyDataSetChanged();
    }

    public void fH(long j) {
        this.gsJ = j;
    }

    public ArrayList<d> getData() {
        return this.akq;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.akq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.akq.get(i);
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
        d dVar = this.akq.get(i);
        if (!ListUtils.isEmpty(this.gsI)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gsI.size()) {
                    break;
                } else if (!this.gsI.get(i3).wish_id.equals(dVar.gUk)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.gsI.get(i3));
                    break;
                }
            }
        }
        aVar.oN(this.hTg);
        aVar.fH(this.gsJ);
        aVar.a(i, this.hTf, dVar);
        return view;
    }

    public void coF() {
        if (this.hTf != null) {
            int size = this.hTf.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hTf.get(this.hTf.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
