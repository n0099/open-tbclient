package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private UpdatesActivity a;
    private List<UpdatesItemData> b = new ArrayList();

    public e(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    public void a() {
        this.a = null;
    }

    public void a(List<UpdatesItemData> list) {
        if (list != null) {
            this.b = list;
            com.baidu.adp.lib.g.e.d("size:" + this.b.size());
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
        f fVar = null;
        if (view != null) {
            fVar = (f) view.getTag();
        }
        f fVar2 = fVar == null ? new f(this.a) : fVar;
        fVar2.a(this.b.get(i));
        return fVar2.a();
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
