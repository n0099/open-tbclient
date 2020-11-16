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
    private ArrayList<AlaLiveWishListData> fZX;
    private long fZY;
    private boolean hxz;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<d> aiP = new ArrayList<>();
    private SparseArray<CountDownTimer> hxy = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.aiP = arrayList;
        notifyDataSetChanged();
    }

    public void nT(boolean z) {
        this.hxz = z;
    }

    public void ai(ArrayList<AlaLiveWishListData> arrayList) {
        this.fZX = arrayList;
        notifyDataSetChanged();
    }

    public void fd(long j) {
        this.fZY = j;
    }

    public ArrayList<d> getData() {
        return this.aiP;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aiP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aiP.get(i);
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
        d dVar = this.aiP.get(i);
        if (!ListUtils.isEmpty(this.fZX)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.fZX.size()) {
                    break;
                } else if (!this.fZX.get(i3).wish_id.equals(dVar.gzA)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.fZX.get(i3));
                    break;
                }
            }
        }
        aVar.nT(this.hxz);
        aVar.fd(this.fZY);
        aVar.a(i, this.hxy, dVar);
        return view;
    }

    public void chS() {
        if (this.hxy != null) {
            int size = this.hxy.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hxy.get(this.hxy.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
