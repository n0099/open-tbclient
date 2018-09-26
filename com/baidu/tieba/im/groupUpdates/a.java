package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bHX = new ArrayList();
    private UpdatesActivity eEE;

    public a(UpdatesActivity updatesActivity) {
        this.eEE = updatesActivity;
    }

    public void destroy() {
        this.eEE = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bHX;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bHX = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bHX == null) {
            return 0;
        }
        return this.bHX.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eEE) : bVar;
        bVar2.b(this.bHX.get(i));
        return bVar2.fJ();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bHX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
