package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bQA = new ArrayList();
    private UpdatesActivity eMn;

    public a(UpdatesActivity updatesActivity) {
        this.eMn = updatesActivity;
    }

    public void destroy() {
        this.eMn = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bQA;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bQA = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bQA == null) {
            return 0;
        }
        return this.bQA.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eMn) : bVar;
        bVar2.b(this.bQA.get(i));
        return bVar2.gb();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bQA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
