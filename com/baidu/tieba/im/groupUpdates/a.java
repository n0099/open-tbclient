package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bWQ = new ArrayList();
    private UpdatesActivity kzn;

    public a(UpdatesActivity updatesActivity) {
        this.kzn = updatesActivity;
    }

    public void destroy() {
        this.kzn = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bWQ;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bWQ = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bWQ == null) {
            return 0;
        }
        return this.bWQ.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kzn) : bVar;
        bVar2.b(this.bWQ.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bWQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
