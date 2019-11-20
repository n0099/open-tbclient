package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> Ty = new ArrayList();
    private UpdatesActivity gLo;

    public a(UpdatesActivity updatesActivity) {
        this.gLo = updatesActivity;
    }

    public void destroy() {
        this.gLo = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.Ty;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.Ty = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Ty == null) {
            return 0;
        }
        return this.Ty.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.gLo) : bVar;
        bVar2.b(this.Ty.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.Ty.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
