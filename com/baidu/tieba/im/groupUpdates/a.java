package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> dxP = new ArrayList();
    private UpdatesActivity gMm;

    public a(UpdatesActivity updatesActivity) {
        this.gMm = updatesActivity;
    }

    public void destroy() {
        this.gMm = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.dxP;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.dxP = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dxP == null) {
            return 0;
        }
        return this.dxP.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gMm) : bVar;
        bVar2.b(this.dxP.get(i));
        return bVar2.eY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dxP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
