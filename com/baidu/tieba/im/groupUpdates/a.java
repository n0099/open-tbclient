package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bQx = new ArrayList();
    private UpdatesActivity kkZ;

    public a(UpdatesActivity updatesActivity) {
        this.kkZ = updatesActivity;
    }

    public void destroy() {
        this.kkZ = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bQx;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bQx = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bQx == null) {
            return 0;
        }
        return this.bQx.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kkZ) : bVar;
        bVar2.b(this.bQx.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bQx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
