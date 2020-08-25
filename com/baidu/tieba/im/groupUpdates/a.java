package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aJf = new ArrayList();
    private UpdatesActivity jun;

    public a(UpdatesActivity updatesActivity) {
        this.jun = updatesActivity;
    }

    public void destroy() {
        this.jun = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aJf;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aJf = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aJf == null) {
            return 0;
        }
        return this.aJf.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.jun) : bVar;
        bVar2.b(this.aJf.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aJf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
