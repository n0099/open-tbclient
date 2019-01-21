package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bVQ = new ArrayList();
    private UpdatesActivity eYa;

    public a(UpdatesActivity updatesActivity) {
        this.eYa = updatesActivity;
    }

    public void destroy() {
        this.eYa = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bVQ;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bVQ = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bVQ == null) {
            return 0;
        }
        return this.bVQ.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eYa) : bVar;
        bVar2.b(this.bVQ.get(i));
        return bVar2.gb();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bVQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
