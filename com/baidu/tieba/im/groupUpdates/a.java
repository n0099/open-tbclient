package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> bVH = new ArrayList();
    private UpdatesActivity kyv;

    public a(UpdatesActivity updatesActivity) {
        this.kyv = updatesActivity;
    }

    public void destroy() {
        this.kyv = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.bVH;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.bVH = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bVH == null) {
            return 0;
        }
        return this.bVH.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.kyv) : bVar;
        bVar2.b(this.bVH.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bVH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
