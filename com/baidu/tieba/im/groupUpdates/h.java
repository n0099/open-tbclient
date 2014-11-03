package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<UpdatesItemData> aKa = new ArrayList();
    private UpdatesActivity bck;

    public h(UpdatesActivity updatesActivity) {
        this.bck = updatesActivity;
    }

    public void destroy() {
        this.bck = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aKa;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aKa = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKa == null) {
            return 0;
        }
        return this.aKa.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.bck) : iVar;
        iVar2.b(this.aKa.get(i));
        return iVar2.O();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aKa.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
