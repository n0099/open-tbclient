package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dkS = new ArrayList();
    private UpdatesActivity gnU;

    public a(UpdatesActivity updatesActivity) {
        this.gnU = updatesActivity;
    }

    public void destroy() {
        this.gnU = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dkS;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dkS = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dkS == null) {
            return 0;
        }
        return this.dkS.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gnU) : bVar;
        bVar2.b(this.dkS.get(i));
        return bVar2.fY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dkS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
