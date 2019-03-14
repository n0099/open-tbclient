package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dkO = new ArrayList();
    private UpdatesActivity gog;

    public a(UpdatesActivity updatesActivity) {
        this.gog = updatesActivity;
    }

    public void destroy() {
        this.gog = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dkO;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dkO = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dkO == null) {
            return 0;
        }
        return this.dkO.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gog) : bVar;
        bVar2.b(this.dkO.get(i));
        return bVar2.fY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dkO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
