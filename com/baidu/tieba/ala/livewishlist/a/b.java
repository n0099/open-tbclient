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
    private ArrayList<AlaLiveWishListData> gqK;
    private boolean hSW;
    private Context mContext;
    private long mCurrentTime;
    private LayoutInflater mInflater;
    private ArrayList<d> ajo = new ArrayList<>();
    private SparseArray<CountDownTimer> hSV = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.ajo = arrayList;
        notifyDataSetChanged();
    }

    public void oT(boolean z) {
        this.hSW = z;
    }

    public void ad(ArrayList<AlaLiveWishListData> arrayList) {
        this.gqK = arrayList;
        notifyDataSetChanged();
    }

    public void fM(long j) {
        this.mCurrentTime = j;
    }

    public ArrayList<d> getData() {
        return this.ajo;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ajo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ajo.get(i);
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
        d dVar = this.ajo.get(i);
        if (!ListUtils.isEmpty(this.gqK)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gqK.size()) {
                    break;
                } else if (!this.gqK.get(i3).wish_id.equals(dVar.gSn)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.gqK.get(i3));
                    break;
                }
            }
        }
        aVar.oT(this.hSW);
        aVar.fM(this.mCurrentTime);
        aVar.a(i, this.hSV, dVar);
        return view;
    }

    public void clM() {
        if (this.hSV != null) {
            int size = this.hSV.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hSV.get(this.hSV.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
