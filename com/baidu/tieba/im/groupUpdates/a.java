package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private UpdatesActivity edm;
    private List<UpdatesItemData> edn = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.edm = updatesActivity;
    }

    public void destroy() {
        this.edm = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.edn;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.edn = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.edn == null) {
            return 0;
        }
        return this.edn.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar = null;
        if (view2 != null) {
            bVar = (b) view2.getTag();
        }
        b bVar2 = bVar == null ? new b(this.edm) : bVar;
        bVar2.b(this.edn.get(i));
        return bVar2.bO();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.edn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
