package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> cbD = new ArrayList();
    private UpdatesActivity kDS;

    public a(UpdatesActivity updatesActivity) {
        this.kDS = updatesActivity;
    }

    public void destroy() {
        this.kDS = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.cbD;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.cbD = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cbD == null) {
            return 0;
        }
        return this.cbD.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kDS) : bVar;
        bVar2.b(this.cbD.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cbD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
