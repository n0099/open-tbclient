package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> avh = new ArrayList();
    private UpdatesActivity iqE;

    public a(UpdatesActivity updatesActivity) {
        this.iqE = updatesActivity;
    }

    public void destroy() {
        this.iqE = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.avh;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.avh = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avh == null) {
            return 0;
        }
        return this.avh.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.iqE) : bVar;
        bVar2.b(this.avh.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.avh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
