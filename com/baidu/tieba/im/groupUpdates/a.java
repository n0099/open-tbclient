package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dvz = new ArrayList();
    private UpdatesActivity gFh;

    public a(UpdatesActivity updatesActivity) {
        this.gFh = updatesActivity;
    }

    public void destroy() {
        this.gFh = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dvz;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dvz = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvz == null) {
            return 0;
        }
        return this.dvz.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gFh) : bVar;
        bVar2.b(this.dvz.get(i));
        return bVar2.eR();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dvz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
