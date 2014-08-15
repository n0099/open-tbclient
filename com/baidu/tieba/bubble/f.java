package com.baidu.tieba.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.data.BubbleListData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private List<BubbleListData.BubbleData> a = new ArrayList();
    private BubbleChooseActivity b;
    private int c;
    private int d;
    private boolean e;

    public void a(boolean z) {
        this.e = z;
    }

    public f(BubbleChooseActivity bubbleChooseActivity) {
        this.b = bubbleChooseActivity;
        this.c = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds30);
        this.d = (int) this.b.getResources().getDimension(com.baidu.tieba.s.ds30);
    }

    public List<BubbleListData.BubbleData> a() {
        return this.a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BubbleListData.BubbleData getItem(int i) {
        if (this.a == null || (i < 0 && i >= this.a.size())) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.view.b bVar;
        if (view == null) {
            bVar = new com.baidu.tieba.view.b(this.b);
            view = bVar;
        } else {
            bVar = (com.baidu.tieba.view.b) view;
        }
        if (i == 0 || i == 1) {
            bVar.setPadding(0, this.d, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i == getCount() - 1 || i == getCount() - 2) {
                bVar.setPadding(0, bVar.getPaddingTop(), 0, this.c);
            }
        } else if (i == getCount() - 1) {
            bVar.setPadding(0, bVar.getPaddingTop(), 0, this.c);
        }
        BubbleListData.BubbleData item = getItem(i);
        if (item != null) {
            bVar.setShowName(true);
            bVar.a(item, this.e);
        }
        bVar.b();
        return view;
    }

    public void a(List<BubbleListData.BubbleData> list) {
        this.a.clear();
        BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
        bubbleData.setBcode(0);
        this.a.add(bubbleData);
        this.a.addAll(list);
        notifyDataSetChanged();
    }
}
