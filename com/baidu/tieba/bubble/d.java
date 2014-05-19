package com.baidu.tieba.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private List<BubbleListData.BubbleData> a = new ArrayList();
    private BubbleChooseActivity b;
    private ab c;
    private int d;
    private int e;
    private boolean f;

    public void a(boolean z) {
        this.f = z;
    }

    public d(BubbleChooseActivity bubbleChooseActivity) {
        this.b = bubbleChooseActivity;
        this.c = new ab(this.b);
        this.c.d(true);
        this.d = (int) this.b.getResources().getDimension(p.ds30);
        this.e = (int) this.b.getResources().getDimension(p.ds30);
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
        com.baidu.tieba.view.a aVar;
        if (view == null) {
            aVar = new com.baidu.tieba.view.a(this.b);
            view = aVar;
        } else {
            aVar = (com.baidu.tieba.view.a) view;
        }
        if (i == 0 || i == 1) {
            aVar.setPadding(0, this.e, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i == getCount() - 1 || i == getCount() - 2) {
                aVar.setPadding(0, aVar.getPaddingTop(), 0, this.d);
            }
        } else if (i == getCount() - 1) {
            aVar.setPadding(0, aVar.getPaddingTop(), 0, this.d);
        }
        BubbleListData.BubbleData item = getItem(i);
        if (item != null) {
            aVar.setShowName(true);
            aVar.a(item, this.c, this.f);
        }
        aVar.b();
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
