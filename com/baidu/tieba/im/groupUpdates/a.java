package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private UpdatesActivity eID;
    private List<UpdatesItemData> eIE = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.eID = updatesActivity;
    }

    public void destroy() {
        this.eID = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.eIE;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.eIE = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIE == null) {
            return 0;
        }
        return this.eIE.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.eID) : bVar;
        bVar2.b(this.eIE.get(i));
        return bVar2.jK();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.eIE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
