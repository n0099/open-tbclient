package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.widget.q;
import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h extends q {
    private NearbyGroupsActivity bgr;
    private NearbyGroupsData bgs = null;
    private boolean bgt = true;
    private boolean bgu = false;
    private a bgv;

    public h(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgr = null;
        this.bgr = nearbyGroupsActivity;
    }

    public NearbyGroupsData Rb() {
        return this.bgs;
    }

    public void dq(boolean z) {
        this.bgt = z;
        if (!this.bgt) {
            this.bgs = null;
        }
        notifyDataSetChanged();
    }

    public void dr(boolean z) {
        this.bgu = z;
        if (this.bgu) {
            this.bgs = null;
        }
        notifyDataSetChanged();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        boolean z = false;
        if (nearbyGroupsData != null && this.bgs != null && nearbyGroupsData.getOffset() != 0) {
            z = true;
        }
        if (z) {
            com.baidu.tieba.im.data.b lastGroup = this.bgs.getLastGroup();
            com.baidu.tieba.im.data.b firstGroup = nearbyGroupsData.getFirstGroup();
            if (lastGroup != null && firstGroup != null && lastGroup.getName() != null && lastGroup.getName().equals(firstGroup.getName())) {
                nearbyGroupsData.remove(firstGroup);
            }
            Iterator it = nearbyGroupsData.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) it.next();
                if ((cVar instanceof com.baidu.tieba.im.data.d) && this.bgs.findItemByGroupId(((com.baidu.tieba.im.data.d) cVar).getGroupId()) != null) {
                    break;
                }
                this.bgs.add(cVar);
            }
        } else {
            this.bgs = nearbyGroupsData;
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bgs == null) {
            return (this.bgu || !this.bgt) ? 1 : 0;
        }
        int size = this.bgs.size();
        if (size == 0) {
            return 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.bgs == null) {
            if (!this.bgt) {
                return 0;
            }
            if (this.bgu) {
                return 1;
            }
            return 5;
        } else if (this.bgs.size() == 0) {
            return 2;
        } else {
            if (this.bgs.get(i).getType() == 0) {
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
        if (this.bgs == null || this.bgs.size() <= 0) {
            return null;
        }
        return this.bgs.get(i);
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
            aVar = i.a(this.bgr, itemViewType);
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
        if (this.bgv == null) {
            this.bgv = i.a(this.bgr, 4);
        }
        return this.bgv.getView();
    }

    @Override // com.baidu.adp.widget.q
    public void a(View view, AdapterView adapterView, int i) {
        if (this.bgv != null) {
            this.bgv.b(i, getItem(i));
        }
    }
}
