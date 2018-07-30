package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bCg = new ArrayList();
    private UpdatesActivity exp;

    public a(UpdatesActivity updatesActivity) {
        this.exp = updatesActivity;
    }

    public void destroy() {
        this.exp = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bCg;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bCg = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bCg == null) {
            return 0;
        }
        return this.bCg.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.exp) : bVar;
        bVar2.b(this.bCg.get(i));
        return bVar2.eB();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bCg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
