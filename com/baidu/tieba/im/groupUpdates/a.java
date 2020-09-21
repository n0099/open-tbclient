package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aKx = new ArrayList();
    private UpdatesActivity jCV;

    public a(UpdatesActivity updatesActivity) {
        this.jCV = updatesActivity;
    }

    public void destroy() {
        this.jCV = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aKx;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aKx = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aKx == null) {
            return 0;
        }
        return this.aKx.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.jCV) : bVar;
        bVar2.b(this.aKx.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aKx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
