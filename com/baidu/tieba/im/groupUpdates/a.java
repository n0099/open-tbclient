package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> TT = new ArrayList();
    private UpdatesActivity gMf;

    public a(UpdatesActivity updatesActivity) {
        this.gMf = updatesActivity;
    }

    public void destroy() {
        this.gMf = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.TT;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.TT = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.TT == null) {
            return 0;
        }
        return this.TT.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gMf) : bVar;
        bVar2.b(this.TT.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.TT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
