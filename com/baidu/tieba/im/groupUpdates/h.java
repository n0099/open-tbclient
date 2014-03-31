package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class h extends BaseAdapter {
    private UpdatesActivity a;
    private List<UpdatesItemData> b = new ArrayList();

    public h(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    public final void a() {
        this.a = null;
    }

    public final void a(List<UpdatesItemData> list) {
        if (list != null) {
            this.b = list;
            com.baidu.adp.lib.util.f.e("size:" + this.b.size());
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.a) : iVar;
        iVar2.a(this.b.get(i));
        iVar2.d();
        return iVar2.a();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }
}
