package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aap = new ArrayList();
    private UpdatesActivity hzs;

    public a(UpdatesActivity updatesActivity) {
        this.hzs = updatesActivity;
    }

    public void destroy() {
        this.hzs = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aap;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aap = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aap == null) {
            return 0;
        }
        return this.aap.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.hzs) : bVar;
        bVar2.b(this.aap.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aap.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
