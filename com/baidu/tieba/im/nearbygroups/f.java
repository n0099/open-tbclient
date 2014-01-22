package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.baidu.adp.widget.u;
import com.baidu.tieba.im.data.NearbyGroupsData;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f extends u {
    private NearbyGroupsActivity a;
    private com.baidu.tieba.util.i d;
    private a f;
    private NearbyGroupsData b = null;
    private boolean c = true;
    private boolean e = false;

    public f(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = null;
        this.d = null;
        this.a = nearbyGroupsActivity;
        this.d = new com.baidu.tieba.util.i(this.a);
        this.d.d(true);
    }

    public NearbyGroupsData d() {
        return this.b;
    }

    public com.baidu.tieba.util.i e() {
        return this.d;
    }

    public void a(boolean z) {
        this.c = z;
        if (!this.c) {
            this.b = null;
        }
        a();
    }

    public void b(boolean z) {
        this.e = z;
        if (this.e) {
            this.b = null;
        }
        a();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        boolean z = false;
        if (nearbyGroupsData != null && this.b != null && nearbyGroupsData.getOffset() != 0) {
            z = true;
        }
        if (z) {
            com.baidu.tieba.im.data.g lastGroup = this.b.getLastGroup();
            com.baidu.tieba.im.data.g firstGroup = nearbyGroupsData.getFirstGroup();
            if (lastGroup != null && firstGroup != null && lastGroup.a() != null && lastGroup.a().equals(firstGroup.a())) {
                nearbyGroupsData.remove(firstGroup);
            }
            Iterator it = nearbyGroupsData.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.im.data.h hVar = (com.baidu.tieba.im.data.h) it.next();
                if ((hVar instanceof com.baidu.tieba.im.data.i) && this.b.findItemByGroupId(((com.baidu.tieba.im.data.i) hVar).c()) != null) {
                    break;
                }
                this.b.add(hVar);
            }
        } else {
            this.b = nearbyGroupsData;
        }
        a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return (this.e || !this.c) ? 1 : 0;
        }
        int size = this.b.size();
        if (size == 0) {
            return 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.b == null) {
            if (!this.c) {
                return 0;
            }
            if (this.e) {
                return 1;
            }
            return 5;
        } else if (this.b.size() == 0) {
            return 2;
        } else {
            if (this.b.get(i).b() == 0) {
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
        if (this.b == null || this.b.size() <= 0) {
            return null;
        }
        return this.b.get(i);
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
            aVar = g.a(this.a, itemViewType);
            view = aVar.a();
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
            aVar.a(i, getItem(i));
        }
        return view;
    }

    @Override // com.baidu.adp.widget.u
    public int b() {
        return 4;
    }

    @Override // com.baidu.adp.widget.u
    public View c() {
        if (this.f == null) {
            this.f = g.a(this.a, 4);
        }
        return this.f.a();
    }

    @Override // com.baidu.adp.widget.u
    public void a(View view, AdapterView adapterView, int i) {
        if (this.f != null) {
            this.f.a(i, getItem(i));
        }
    }
}
