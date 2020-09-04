package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aJh = new ArrayList();
    private UpdatesActivity jut;

    public a(UpdatesActivity updatesActivity) {
        this.jut = updatesActivity;
    }

    public void destroy() {
        this.jut = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aJh;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aJh = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJh == null) {
            return 0;
        }
        return this.aJh.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.jut) : bVar;
        bVar2.b(this.aJh.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aJh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
