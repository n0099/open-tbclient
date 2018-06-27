package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bBz = new ArrayList();
    private UpdatesActivity ety;

    public a(UpdatesActivity updatesActivity) {
        this.ety = updatesActivity;
    }

    public void destroy() {
        this.ety = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bBz;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bBz = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBz == null) {
            return 0;
        }
        return this.bBz.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.ety) : bVar;
        bVar2.b(this.bBz.get(i));
        return bVar2.eC();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bBz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
