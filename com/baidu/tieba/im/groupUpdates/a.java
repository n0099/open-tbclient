package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> ccu = new ArrayList();
    private UpdatesActivity kJI;

    public a(UpdatesActivity updatesActivity) {
        this.kJI = updatesActivity;
    }

    public void destroy() {
        this.kJI = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.ccu;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.ccu = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ccu == null) {
            return 0;
        }
        return this.ccu.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kJI) : bVar;
        bVar2.b(this.ccu.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ccu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
