package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private UpdatesActivity a;
    private List<UpdatesItemData> b = new ArrayList();

    public h(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    public void a() {
        this.a = null;
    }

    public List<UpdatesItemData> b() {
        return this.b;
    }

    public void a(List<UpdatesItemData> list) {
        if (list != null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.a) : iVar;
        iVar2.a(this.b.get(i));
        return iVar2.a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
