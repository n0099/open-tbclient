package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dkR = new ArrayList();
    private UpdatesActivity gnT;

    public a(UpdatesActivity updatesActivity) {
        this.gnT = updatesActivity;
    }

    public void destroy() {
        this.gnT = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dkR;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dkR = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dkR == null) {
            return 0;
        }
        return this.dkR.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gnT) : bVar;
        bVar2.b(this.dkR.get(i));
        return bVar2.fY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dkR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
