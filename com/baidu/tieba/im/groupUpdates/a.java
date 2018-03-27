package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private UpdatesActivity eIH;
    private List<UpdatesItemData> eII = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.eIH = updatesActivity;
    }

    public void destroy() {
        this.eIH = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.eII;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.eII = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eII == null) {
            return 0;
        }
        return this.eII.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eIH) : bVar;
        bVar2.b(this.eII.get(i));
        return bVar2.jK();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eII.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
