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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private ArrayList<AlaLiveWishListData> gsH;
    private boolean hUT;
    private Context mContext;
    private long mCurrentTime;
    private LayoutInflater mInflater;
    private ArrayList<d> akG = new ArrayList<>();
    private SparseArray<CountDownTimer> hUS = new SparseArray<>();

    public b(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<d> arrayList) {
        this.akG = arrayList;
        notifyDataSetChanged();
    }

    public void oT(boolean z) {
        this.hUT = z;
    }

    public void ad(ArrayList<AlaLiveWishListData> arrayList) {
        this.gsH = arrayList;
        notifyDataSetChanged();
    }

    public void fM(long j) {
        this.mCurrentTime = j;
    }

    public ArrayList<d> getData() {
        return this.akG;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.akG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.akG.get(i);
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
        d dVar = this.akG.get(i);
        if (!ListUtils.isEmpty(this.gsH)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.gsH.size()) {
                    break;
                } else if (!this.gsH.get(i3).wish_id.equals(dVar.gUk)) {
                    i2 = i3 + 1;
                } else {
                    aVar.a(this.gsH.get(i3));
                    break;
                }
            }
        }
        aVar.oT(this.hUT);
        aVar.fM(this.mCurrentTime);
        aVar.a(i, this.hUS, dVar);
        return view;
    }

    public void clZ() {
        if (this.hUS != null) {
            int size = this.hUS.size();
            for (int i = 0; i < size; i++) {
                CountDownTimer countDownTimer = this.hUS.get(this.hUS.keyAt(i));
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
        }
    }
}
