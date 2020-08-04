package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aDV = new ArrayList();
    private UpdatesActivity jfn;

    public a(UpdatesActivity updatesActivity) {
        this.jfn = updatesActivity;
    }

    public void destroy() {
        this.jfn = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aDV;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aDV = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDV == null) {
            return 0;
        }
        return this.aDV.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.jfn) : bVar;
        bVar2.b(this.aDV.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aDV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
