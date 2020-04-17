package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> avb = new ArrayList();
    private UpdatesActivity iqy;

    public a(UpdatesActivity updatesActivity) {
        this.iqy = updatesActivity;
    }

    public void destroy() {
        this.iqy = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.avb;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.avb = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avb == null) {
            return 0;
        }
        return this.avb.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.iqy) : bVar;
        bVar2.b(this.avb.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.avb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
