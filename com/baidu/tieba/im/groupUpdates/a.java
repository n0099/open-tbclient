package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aNC = new ArrayList();
    private UpdatesActivity jRS;

    public a(UpdatesActivity updatesActivity) {
        this.jRS = updatesActivity;
    }

    public void destroy() {
        this.jRS = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aNC;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aNC = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aNC == null) {
            return 0;
        }
        return this.aNC.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.jRS) : bVar;
        bVar2.b(this.aNC.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aNC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
