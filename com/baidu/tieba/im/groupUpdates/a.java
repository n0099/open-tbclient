package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> caS = new ArrayList();
    private UpdatesActivity kHs;

    public a(UpdatesActivity updatesActivity) {
        this.kHs = updatesActivity;
    }

    public void destroy() {
        this.kHs = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.caS;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.caS = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.caS == null) {
            return 0;
        }
        return this.caS.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kHs) : bVar;
        bVar2.b(this.caS.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
