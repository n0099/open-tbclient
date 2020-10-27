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
    private ArrayList<AlaLiveWishListData> fUA;
    private long fUB;
    private boolean hrV;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> aiK = new ArrayList<>();
    private SparseArray<CountDownTimer> hrU = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.aiK = arrayList;
        notifyDataSetChanged();
    }

    public void nJ(boolean z) {
        this.hrV = z;
    }

    public void ai(ArrayList<AlaLiveWishListData> arrayList) {
        this.fUA = arrayList;
        notifyDataSetChanged();
    }

    public void eH(long j) {
        this.fUB = j;
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
            view = LayoutInflater.from(this.mContext).inflate(a.h.ala_wish_list_item_view, (ViewGroup) null);
            com.baidu.tieba.ala.livewishlist.b.a aVar2 = new com.baidu.tieba.ala.livewishlist.b.a(this.mContext, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (com.baidu.tieba.ala.livewishlist.b.a) view.getTag();
        }
        d dVar = this.aiK.get(i);
        if (!ListUtils.isEmpty(this.fUA)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fUA.size()) {
                    break;
                } else if (!this.fUA.get(i3).wish_id.equals(dVar.guf)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fUA.get(i3));
                    break;
                }
            }
        }
        aVar.nJ(this.hrV);
        aVar.eH(this.fUB);
        aVar.a(i, this.hrU, dVar);
        return view;
    }

    public void cfX() {
        if (this.hrU != null) {
            int size = this.hrU.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hrU.get(this.hrU.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
