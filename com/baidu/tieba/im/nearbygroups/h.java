package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.widget.q;
import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h extends q {
    private NearbyGroupsActivity bgd;
    private NearbyGroupsData bge = null;
    private boolean bgf = true;
    private boolean bgg = false;
    private a bgh;

    public h(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgd = null;
        this.bgd = nearbyGroupsActivity;
    }

    public NearbyGroupsData QY() {
        return this.bge;
    }

    public void dq(boolean z) {
        this.bgf = z;
        if (!this.bgf) {
            this.bge = null;
        }
        notifyDataSetChanged();
    }

    public void dr(boolean z) {
        this.bgg = z;
        if (this.bgg) {
            this.bge = null;
        }
        notifyDataSetChanged();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        boolean z = false;
        if (nearbyGroupsData != null && this.bge != null && nearbyGroupsData.getOffset() != 0) {
            z = true;
        }
        if (z) {
            com.baidu.tieba.im.data.b lastGroup = this.bge.getLastGroup();
            com.baidu.tieba.im.data.b firstGroup = nearbyGroupsData.getFirstGroup();
            if (lastGroup != null && firstGroup != null && lastGroup.getName() != null && lastGroup.getName().equals(firstGroup.getName())) {
                nearbyGroupsData.remove(firstGroup);
            }
            Iterator it = nearbyGroupsData.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) it.next();
                if ((cVar instanceof com.baidu.tieba.im.data.d) && this.bge.findItemByGroupId(((com.baidu.tieba.im.data.d) cVar).getGroupId()) != null) {
                    break;
                }
                this.bge.add(cVar);
            }
        } else {
            this.bge = nearbyGroupsData;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bge == null) {
            return (this.bgg || !this.bgf) ? 1 : 0;
        }
        int size = this.bge.size();
        if (size == 0) {
            return 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bge == null) {
            if (!this.bgf) {
                return 0;
            }
            if (this.bgg) {
                return 1;
            }
            return 5;
        } else if (this.bge.size() == 0) {
            return 2;
        } else {
            if (this.bge.get(i).getType() == 0) {
                return 4;
            }
            return 3;
        }
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bge == null || this.bge.size() <= 0) {
            return null;
        }
        return this.bge.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            aVar = i.a(this.bgd, itemViewType);
            view = aVar.getView();
            view.setTag(aVar);
        } else {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof a)) {
                aVar = null;
            } else {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.b(i, getItem(i));
        }
        return view;
    }

    @Override // com.baidu.adp.widget.q
    public int hZ() {
        return 4;
    }

    @Override // com.baidu.adp.widget.q
    public View ia() {
        if (this.bgh == null) {
            this.bgh = i.a(this.bgd, 4);
        }
        return this.bgh.getView();
    }

    @Override // com.baidu.adp.widget.q
    public void a(View view, AdapterView adapterView, int i) {
        if (this.bgh != null) {
            this.bgh.b(i, getItem(i));
        }
    }
}
