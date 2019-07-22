package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dxI = new ArrayList();
    private UpdatesActivity gLu;

    public a(UpdatesActivity updatesActivity) {
        this.gLu = updatesActivity;
    }

    public void destroy() {
        this.gLu = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dxI;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dxI = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dxI == null) {
            return 0;
        }
        return this.dxI.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gLu) : bVar;
        bVar2.b(this.dxI.get(i));
        return bVar2.eY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dxI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
