package com.baidu.tieba.im.live.livenotify;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private LiveNotifyActivity a;
    private List<UpdatesItemData> b = new ArrayList();

    public j(LiveNotifyActivity liveNotifyActivity) {
        this.a = liveNotifyActivity;
    }

    public void a() {
        this.a = null;
    }

    public void a(List<UpdatesItemData> list) {
        if (list != null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar = null;
        if (view != null) {
            kVar = (k) view.getTag();
        }
        k kVar2 = kVar == null ? new k(this.a) : kVar;
        kVar2.a(this.b.get(i));
        return kVar2.a();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
