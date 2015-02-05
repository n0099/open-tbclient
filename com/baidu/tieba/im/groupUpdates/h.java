package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.data.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private UpdatesActivity bhj;
    private List<UpdatesItemData> datas = new ArrayList();

    public h(UpdatesActivity updatesActivity) {
        this.bhj = updatesActivity;
    }

    public void destroy() {
        this.bhj = null;
    }

    public List<UpdatesItemData> getDatas() {
        return this.datas;
    }

    public void setData(List<UpdatesItemData> list) {
        if (list != null) {
            this.datas = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.datas == null) {
            return 0;
        }
        return this.datas.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        i iVar = null;
        if (view != null) {
            iVar = (i) view.getTag();
        }
        i iVar2 = iVar == null ? new i(this.bhj) : iVar;
        iVar2.refresh(this.datas.get(i));
        return iVar2.getConvertView();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.datas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
