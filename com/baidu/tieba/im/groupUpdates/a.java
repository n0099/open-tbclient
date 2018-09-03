package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bCi = new ArrayList();
    private UpdatesActivity exl;

    public a(UpdatesActivity updatesActivity) {
        this.exl = updatesActivity;
    }

    public void destroy() {
        this.exl = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bCi;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bCi = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bCi == null) {
            return 0;
        }
        return this.bCi.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.exl) : bVar;
        bVar2.b(this.bCi.get(i));
        return bVar2.eB();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bCi.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
