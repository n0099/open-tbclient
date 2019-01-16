package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bVP = new ArrayList();
    private UpdatesActivity eXZ;

    public a(UpdatesActivity updatesActivity) {
        this.eXZ = updatesActivity;
    }

    public void destroy() {
        this.eXZ = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bVP;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bVP = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bVP == null) {
            return 0;
        }
        return this.bVP.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eXZ) : bVar;
        bVar2.b(this.bVP.get(i));
        return bVar2.gb();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bVP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
