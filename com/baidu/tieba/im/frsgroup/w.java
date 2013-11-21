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
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class w extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private MembersActivity f1657a;
    private y b;
    private boolean c;
    private boolean d;
    private boolean e;
    private com.baidu.tieba.util.i f;
    private Set<Long> g = new HashSet();
    private List<UserData> h = new ArrayList();

    public void a(y yVar) {
        this.b = yVar;
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

    public w(MembersActivity membersActivity) {
        this.f1657a = membersActivity;
        this.f = new com.baidu.tieba.util.i(membersActivity);
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
        z zVar;
        View view2;
        if (this.h != null) {
            if (view == null) {
                z zVar2 = new z();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.f1657a).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    zVar2.f1659a = (LinearLayout) inflate.findViewById(R.id.list_more);
                    zVar2.c = (TextView) inflate.findViewById(R.id.more_title);
                    zVar2.d = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.f1657a).inflate(R.layout.im_members_list_item, viewGroup, false);
                    zVar2.b = (LinearLayout) inflate2.findViewById(R.id.list_content);
                    zVar2.f = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    zVar2.f.setAutoChangeStyle(false);
                    zVar2.g = (TextView) inflate2.findViewById(R.id.item_name);
                    zVar2.h = (ImageView) inflate2.findViewById(R.id.item_sex);
                    zVar2.i = (TextView) inflate2.findViewById(R.id.item_time);
                    zVar2.j = (TextView) inflate2.findViewById(R.id.item_address);
                    zVar2.e = (CheckBox) inflate2.findViewById(R.id.item_check);
                    view2 = inflate2;
                }
                view2.setTag(zVar2);
                zVar = zVar2;
                view = view2;
            } else {
                zVar = (z) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.c) {
                    zVar.c.setText(R.string.members_load_more_person);
                    zVar.d.setVisibility(0);
                } else {
                    zVar.c.setText(R.string.members_no_more_person);
                    zVar.d.setVisibility(8);
                }
            } else {
                UserData userData = (UserData) getItem(i);
                zVar.f.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    com.baidu.adp.widget.ImageView.e c = this.f.c(portrait);
                    if (c != null) {
                        zVar.f.setImageBitmap(c.f());
                    } else {
                        zVar.f.setTag(portrait);
                        zVar.f.setImageResource(R.drawable.photo);
                    }
                }
                zVar.g.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        zVar.h.setVisibility(0);
                        zVar.h.setImageResource(R.drawable.icon_man);
                        break;
                    case 2:
                        zVar.h.setVisibility(0);
                        zVar.h.setImageResource(R.drawable.icon_woman);
                        break;
                    default:
                        zVar.h.setVisibility(8);
                        break;
                }
                zVar.i.setText(a(userData));
                zVar.j.setText(userData.getPosition());
                if (this.e) {
                    zVar.e.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserId());
                    zVar.e.setTag(valueOf);
                    zVar.e.setChecked(this.g.contains(valueOf));
                    zVar.e.setOnCheckedChangeListener(new x(this));
                } else {
                    zVar.e.setVisibility(8);
                }
            }
        }
        return view;
    }

    private String a(UserData userData) {
        long lastReplyTime;
        com.baidu.tieba.im.model.h b = this.f1657a.b();
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
                return this.f1657a.getString(R.string.members_no_speak);
            }
            return "";
        }
        return be.e(new Date(lastReplyTime * 1000));
    }

    public com.baidu.tieba.util.i e() {
        return this.f;
    }
}
