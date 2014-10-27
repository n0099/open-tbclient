package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<UpdatesItemData> aJN = new ArrayList();
    private UpdatesActivity bbW;

    public h(UpdatesActivity updatesActivity) {
        this.bbW = updatesActivity;
    }

    public void destroy() {
        this.bbW = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aJN;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aJN = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJN == null) {
            return 0;
        }
        return this.aJN.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.bbW) : iVar;
        iVar2.b(this.aJN.get(i));
        return iVar2.O();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aJN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
