package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private final MembersActivity a;
    private ad b;
    private boolean c;
    private boolean e;
    private final Set<Long> f = new HashSet();
    private final List<UserData> g = new ArrayList();
    private LinkedList<IconData> h = null;
    private boolean d = false;

    public void a(ad adVar) {
        this.b = adVar;
    }

    public void a(List<UserData> list) {
        this.g.addAll(list);
    }

    public void b(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                long longValue = l.longValue();
                Iterator<UserData> it = this.g.iterator();
                while (it.hasNext()) {
                    if (it.next().getUserIdLong() == longValue) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void a() {
        this.f.clear();
    }

    public Set<Long> b() {
        return this.f;
    }

    public void a(Long l) {
        if (this.f.contains(l)) {
            this.f.remove(l);
        } else {
            this.f.add(l);
        }
        notifyDataSetChanged();
        if (this.b != null) {
            this.b.a(this.f.size());
        }
    }

    public void a(boolean z) {
        if (z) {
            this.g.clear();
        }
        this.d = false;
        this.c = true;
    }

    public ab(MembersActivity membersActivity) {
        this.a = membersActivity;
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
        if (this.g != null) {
            int size = this.g.size();
            if (this.d) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.g.size()) {
            return null;
        }
        return this.g.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.d && i == getCount() - 1) {
            return -2L;
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
        ae aeVar;
        View view2;
        if (this.g != null) {
            if (view == null) {
                ae aeVar2 = new ae();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.im_members_list_foot, viewGroup, false);
                    aeVar2.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.u.list_more);
                    aeVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.u.more_title);
                    aeVar2.c = (ProgressBar) inflate.findViewById(com.baidu.tieba.u.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.im_members_list_item, viewGroup, false);
                    aeVar2.e = (HeadImageView) inflate2.findViewById(com.baidu.tieba.u.item_head);
                    aeVar2.e.setIsRound(false);
                    aeVar2.e.setAutoChangeStyle(true);
                    aeVar2.f = (TextView) inflate2.findViewById(com.baidu.tieba.u.item_name);
                    aeVar2.g = (ImageView) inflate2.findViewById(com.baidu.tieba.u.item_sex);
                    aeVar2.h = (TextView) inflate2.findViewById(com.baidu.tieba.u.item_time);
                    aeVar2.i = (TextView) inflate2.findViewById(com.baidu.tieba.u.item_address);
                    aeVar2.d = (ImageView) inflate2.findViewById(com.baidu.tieba.u.item_check);
                    aeVar2.j = (UserIconBox) inflate2.findViewById(com.baidu.tieba.u.user_tshow_icon_box);
                    aeVar2.k = inflate2.findViewById(com.baidu.tieba.u.list_line);
                    view2 = inflate2;
                }
                view2.setTag(aeVar2);
                aeVar = aeVar2;
                view = view2;
            } else {
                aeVar = (ae) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.c) {
                    aeVar.b.setText(com.baidu.tieba.x.members_load_more_person);
                    aeVar.c.setVisibility(0);
                } else {
                    aeVar.b.setText(com.baidu.tieba.x.members_no_more_person);
                    aeVar.c.setVisibility(8);
                }
            } else {
                int skinType = TbadkApplication.m252getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                aeVar.e.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    aeVar.e.a(portrait, 12, false);
                }
                aeVar.f.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        aeVar.g.setVisibility(0);
                        if (skinType == 1) {
                            aeVar.g.setImageResource(com.baidu.tieba.t.icon_pop_qz_boy_1);
                            break;
                        } else {
                            aeVar.g.setImageResource(com.baidu.tieba.t.icon_pop_qz_boy);
                            break;
                        }
                    case 2:
                        aeVar.g.setVisibility(0);
                        if (skinType == 1) {
                            aeVar.g.setImageResource(com.baidu.tieba.t.icon_pop_qz_girl_1);
                            break;
                        } else {
                            aeVar.g.setImageResource(com.baidu.tieba.t.icon_pop_qz_girl);
                            break;
                        }
                    default:
                        aeVar.g.setVisibility(8);
                        break;
                }
                aeVar.h.setText(a(userData));
                aeVar.i.setText(userData.getPosition());
                this.h = userData.getTShowInfo();
                if (aeVar.j != null) {
                    aeVar.j.a(this.h, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.big_icon_margin), true);
                }
                if (this.e) {
                    aeVar.d.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    aeVar.d.setTag(valueOf);
                    aeVar.d.setSelected(this.f.contains(valueOf));
                    aeVar.d.setOnClickListener(new ac(this));
                } else {
                    aeVar.d.setVisibility(8);
                }
                a(view);
            }
        }
        return view;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
    }

    private String a(UserData userData) {
        long lastReplyTime;
        com.baidu.tieba.im.model.u b = this.a.b();
        switch (b.a()) {
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
            if (b.a() == 1) {
                return this.a.getString(com.baidu.tieba.x.members_no_speak);
            }
            return "";
        }
        return ba.e(new Date(lastReplyTime * 1000));
    }
}
