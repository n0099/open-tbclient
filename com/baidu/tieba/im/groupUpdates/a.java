package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private UpdatesActivity epF;
    private List<UpdatesItemData> epG = new ArrayList();

    public a(UpdatesActivity updatesActivity) {
        this.epF = updatesActivity;
    }

    public void destroy() {
        this.epF = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.epG;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.epG = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.epG == null) {
            return 0;
        }
        return this.epG.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.epF) : bVar;
        bVar2.b(this.epG.get(i));
        return bVar2.eC();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.epG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
