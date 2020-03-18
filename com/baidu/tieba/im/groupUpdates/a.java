package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> acJ = new ArrayList();
    private UpdatesActivity hGI;

    public a(UpdatesActivity updatesActivity) {
        this.hGI = updatesActivity;
    }

    public void destroy() {
        this.hGI = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.acJ;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.acJ = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acJ == null) {
            return 0;
        }
        return this.acJ.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.hGI) : bVar;
        bVar2.b(this.acJ.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.acJ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
