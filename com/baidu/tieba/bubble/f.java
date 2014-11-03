package com.baidu.tieba.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.data.BubbleListData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private int aan;
    private int aao;
    private BubbleChooseActivity ajk;
    private boolean ajl;
    private List<BubbleListData.BubbleData> mData = new ArrayList();

    public void bn(boolean z) {
        this.ajl = z;
    }

    public f(BubbleChooseActivity bubbleChooseActivity) {
        this.ajk = bubbleChooseActivity;
        this.aao = (int) this.ajk.getResources().getDimension(com.baidu.tieba.t.ds30);
        this.aan = (int) this.ajk.getResources().getDimension(com.baidu.tieba.t.ds30);
    }

    public List<BubbleListData.BubbleData> yl() {
        return this.mData;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dW */
    public BubbleListData.BubbleData getItem(int i) {
        if (this.mData == null || (i < 0 && i >= this.mData.size())) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.view.b bVar;
        if (view == null) {
            bVar = new com.baidu.tieba.view.b(this.ajk);
            view = bVar;
        } else {
            bVar = (com.baidu.tieba.view.b) view;
        }
        if (i == 0 || i == 1) {
            bVar.setPadding(0, this.aan, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i == getCount() - 1 || i == getCount() - 2) {
                bVar.setPadding(0, bVar.getPaddingTop(), 0, this.aao);
            }
        } else if (i == getCount() - 1) {
            bVar.setPadding(0, bVar.getPaddingTop(), 0, this.aao);
        }
        BubbleListData.BubbleData item = getItem(i);
        if (item != null) {
            bVar.setShowName(true);
            bVar.a(item, this.ajl);
        }
        bVar.nz();
        return view;
    }

    public void setData(List<BubbleListData.BubbleData> list) {
        this.mData.clear();
        BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
        bubbleData.setBcode(0);
        this.mData.add(bubbleData);
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
