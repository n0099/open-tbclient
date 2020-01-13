package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private List<UpdatesItemData> aaB = new ArrayList();
    private UpdatesActivity hCV;

    public a(UpdatesActivity updatesActivity) {
        this.hCV = updatesActivity;
    }

    public void destroy() {
        this.hCV = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.aaB;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.aaB = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aaB == null) {
            return 0;
        }
        return this.aaB.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar = null;
        if (view != null) {
            bVar = (b) view.getTag();
        }
        b bVar2 = bVar == null ? new b(this.hCV) : bVar;
        bVar2.b(this.aaB.get(i));
        return bVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.aaB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
