package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aAp = new ArrayList();
    private UpdatesActivity iFX;

    public a(UpdatesActivity updatesActivity) {
        this.iFX = updatesActivity;
    }

    public void destroy() {
        this.iFX = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aAp;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aAp = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAp == null) {
            return 0;
        }
        return this.aAp.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.iFX) : bVar;
        bVar2.b(this.aAp.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aAp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
