package com.baidu.tieba.im.creategroup;

import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class m extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<Address> f1583a = null;
    private int b = -1;
    private com.baidu.tieba.j c;

    public m(com.baidu.tieba.j jVar) {
        this.c = null;
        this.c = jVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1583a == null) {
            return 0;
        }
        return this.f1583a.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f1583a == null || this.f1583a.size() == 0) {
            return 0;
        }
        if (this.f1583a.size() != 1) {
            if (this.f1583a.size() > 1 && i == 0) {
                return 2;
            }
            if (this.f1583a.size() > 1 && i + 1 < this.f1583a.size()) {
                return 3;
            }
            return 4;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f1583a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public Address a() {
        if (this.b >= 0 && this.f1583a.size() >= this.b + 1) {
            return this.f1583a.get(this.b);
        }
        return null;
    }

    public void a(int i) {
        this.b = i;
        notifyDataSetInvalidated();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        n nVar = null;
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return null;
        }
        if (view == null) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.address_lbs_item, (ViewGroup) null);
            n nVar2 = new n(this);
            nVar2.f1584a = (LinearLayout) inflate;
            nVar2.b = (TextView) inflate.findViewById(R.id.text);
            nVar2.c = (ImageView) inflate.findViewById(R.id.arrow2);
            inflate.setTag(nVar2);
            nVar = nVar2;
            view2 = inflate;
        } else {
            view2 = view;
        }
        n nVar3 = nVar == null ? (n) view2.getTag() : nVar;
        int ap = TiebaApplication.g().ap();
        if (itemViewType == 1) {
            if (ap == 1) {
                bd.e(nVar3.f1584a, (int) R.drawable.more_all_1);
            } else {
                bd.e(nVar3.f1584a, (int) R.drawable.more_all);
            }
        } else if (itemViewType == 2) {
            if (ap == 1) {
                bd.e(nVar3.f1584a, (int) R.drawable.more_up_1);
            } else {
                bd.e(nVar3.f1584a, (int) R.drawable.more_up);
            }
        } else if (itemViewType == 3) {
            if (ap == 1) {
                bd.e(nVar3.f1584a, (int) R.drawable.more_middle_1);
            } else {
                bd.e(nVar3.f1584a, (int) R.drawable.more_middle);
            }
        } else if (itemViewType == 4) {
            if (ap == 1) {
                bd.e(nVar3.f1584a, (int) R.drawable.more_down_1);
            } else {
                bd.e(nVar3.f1584a, (int) R.drawable.more_down);
            }
        }
        if (ap == 1) {
            nVar3.b.setTextColor(this.c.getResources().getColor(R.color.skin_1_common_color));
            bd.e(nVar3.c, (int) R.drawable.icon_found_list_address_1);
        } else {
            nVar3.b.setTextColor(this.c.getResources().getColor(R.color.more_color));
            bd.e(nVar3.c, (int) R.drawable.icon_found_list_address);
        }
        if (this.b == i) {
            nVar3.c.setVisibility(0);
        } else {
            nVar3.c.setVisibility(8);
        }
        if (this.f1583a.size() >= i + 1) {
            nVar3.b.setText(this.f1583a.get(i).getAddressLine(0));
        }
        return view2;
    }
}
