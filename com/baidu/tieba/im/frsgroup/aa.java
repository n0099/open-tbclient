package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class aa extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private MembersActivity f1553a;
    private ac b;
    private boolean c;
    private boolean d;
    private boolean e;
    private com.baidu.tieba.util.a f;
    private Set<Long> g = new HashSet();
    private List<UserData> h = new ArrayList();

    public void a(ac acVar) {
        this.b = acVar;
    }

    public void a(List<UserData> list) {
        this.h.addAll(list);
    }

    public void b(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.h.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserId() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void a() {
        this.g.clear();
    }

    public Set<Long> b() {
        return this.g;
    }

    public void a(Long l) {
        if (this.g.contains(l)) {
            this.g.remove(l);
        } else {
            this.g.add(l);
        }
        notifyDataSetChanged();
    }

    public void a(boolean z) {
        if (z) {
            this.h.clear();
        }
        this.d = false;
        this.c = true;
    }

    public aa(MembersActivity membersActivity) {
        this.f1553a = membersActivity;
        this.f = new com.baidu.tieba.util.a(membersActivity);
        this.f.d(false);
        this.d = false;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public boolean c() {
        return this.c;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean d() {
        return this.e;
    }

    public void d(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.h != null) {
            int size = this.h.size();
            if (this.d) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.h.size()) {
            return null;
        }
        return this.h.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.d && i == getCount() - 1) {
            i = -2;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ad adVar;
        View view2;
        if (this.h != null) {
            if (view == null) {
                ad adVar2 = new ad();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.f1553a).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    adVar2.f1555a = (LinearLayout) inflate.findViewById(R.id.list_more);
                    adVar2.c = (TextView) inflate.findViewById(R.id.more_title);
                    adVar2.d = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.f1553a).inflate(R.layout.im_members_list_item, viewGroup, false);
                    adVar2.b = (LinearLayout) inflate2.findViewById(R.id.list_content);
                    adVar2.f = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    adVar2.f.setAutoChangeStyle(false);
                    adVar2.g = (TextView) inflate2.findViewById(R.id.item_name);
                    adVar2.h = (ImageView) inflate2.findViewById(R.id.item_sex);
                    adVar2.i = (TextView) inflate2.findViewById(R.id.item_time);
                    adVar2.j = (TextView) inflate2.findViewById(R.id.item_address);
                    adVar2.e = (CheckBox) inflate2.findViewById(R.id.item_check);
                    view2 = inflate2;
                }
                view2.setTag(adVar2);
                adVar = adVar2;
                view = view2;
            } else {
                adVar = (ad) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.c) {
                    adVar.c.setText(R.string.members_load_more_person);
                    adVar.d.setVisibility(0);
                } else {
                    adVar.c.setText(R.string.members_no_more_person);
                    adVar.d.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                adVar.f.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    com.baidu.adp.widget.ImageView.e c = this.f.c(portrait);
                    if (c != null) {
                        adVar.f.setImageBitmap(c.f());
                    } else {
                        adVar.f.setTag(portrait);
                        adVar.f.setImageResource(R.drawable.photo);
                    }
                }
                adVar.g.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        adVar.h.setVisibility(0);
                        adVar.h.setImageResource(R.drawable.icon_man);
                        break;
                    case 2:
                        adVar.h.setVisibility(0);
                        adVar.h.setImageResource(R.drawable.icon_woman);
                        break;
                    default:
                        adVar.h.setVisibility(8);
                        break;
                }
                adVar.i.setText(a(userData));
                adVar.j.setText(userData.getPosition());
                if (this.e) {
                    adVar.e.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserId());
                    adVar.e.setTag(valueOf);
                    adVar.e.setChecked(this.g.contains(valueOf));
                    adVar.e.setOnCheckedChangeListener(new ab(this));
                } else {
                    adVar.e.setVisibility(8);
                }
            }
        }
        return view;
    }

    private String a(UserData userData) {
        long lastReplyTime;
        com.baidu.tieba.im.model.h b = this.f1553a.b();
        switch (b.b()) {
            case 0:
                lastReplyTime = userData.getLoginTime();
                break;
            case 1:
                lastReplyTime = userData.getLastReplyTime();
                break;
            case 2:
                lastReplyTime = userData.getInTime();
                break;
            default:
                lastReplyTime = 0;
                break;
        }
        if (lastReplyTime <= 0) {
            if (b.b() == 1) {
                return this.f1553a.getString(R.string.members_no_speak);
            }
            return "";
        }
        return bc.h(new Date(lastReplyTime * 1000));
    }

    public com.baidu.tieba.util.a e() {
        return this.f;
    }
}
