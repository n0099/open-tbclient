package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dvA = new ArrayList();
    private UpdatesActivity gFi;

    public a(UpdatesActivity updatesActivity) {
        this.gFi = updatesActivity;
    }

    public void destroy() {
        this.gFi = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dvA;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dvA = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvA == null) {
            return 0;
        }
        return this.dvA.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gFi) : bVar;
        bVar2.b(this.dvA.get(i));
        return bVar2.eR();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dvA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
