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
import com.baidu.tbadk.core.util.be;
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
public class ad extends BaseAdapter {
    private final MembersActivity a;
    private af b;
    private boolean c;
    private boolean d;
    private boolean e;
    private final com.baidu.tbadk.editortool.ab f;
    private final Set<Long> g = new HashSet();
    private final List<UserData> h = new ArrayList();
    private LinkedList<IconData> i = null;

    public void a(af afVar) {
        this.b = afVar;
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
                    if (it.next().getUserIdLong() == longValue) {
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
        if (this.b != null) {
            this.b.a(this.g.size());
        }
    }

    public void a(boolean z) {
        if (z) {
            this.h.clear();
        }
        this.d = false;
        this.c = true;
    }

    public ad(MembersActivity membersActivity) {
        this.a = membersActivity;
        this.f = new com.baidu.tbadk.editortool.ab(membersActivity);
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
            int size = (this.h.size() * 2) + 1;
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
            return -2L;
        }
        if (i % 2 == 0) {
            return -1L;
        }
        return i / 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        if (getItemId(i) == -1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        View view2;
        if (this.h != null) {
            if (view == null) {
                ag agVar2 = new ag();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_members_list_foot, viewGroup, false);
                    agVar2.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.list_more);
                    agVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.v.more_title);
                    agVar2.c = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.more_progress);
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    view2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_list_divide, viewGroup, false);
                } else {
                    View inflate2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_members_list_item, viewGroup, false);
                    agVar2.e = (HeadImageView) inflate2.findViewById(com.baidu.tieba.v.item_head);
                    agVar2.e.setIsRound(true);
                    agVar2.e.setAutoChangeStyle(true);
                    agVar2.f = (TextView) inflate2.findViewById(com.baidu.tieba.v.item_name);
                    agVar2.g = (ImageView) inflate2.findViewById(com.baidu.tieba.v.item_sex);
                    agVar2.h = (TextView) inflate2.findViewById(com.baidu.tieba.v.item_time);
                    agVar2.i = (TextView) inflate2.findViewById(com.baidu.tieba.v.item_address);
                    agVar2.d = (ImageView) inflate2.findViewById(com.baidu.tieba.v.item_check);
                    agVar2.j = (UserIconBox) inflate2.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
                    view2 = inflate2;
                }
                view2.setTag(agVar2);
                agVar = agVar2;
                view = view2;
            } else {
                agVar = (ag) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.c) {
                    agVar.b.setText(com.baidu.tieba.y.members_load_more_person);
                    agVar.c.setVisibility(0);
                } else {
                    agVar.b.setText(com.baidu.tieba.y.members_no_more_person);
                    agVar.c.setVisibility(8);
                }
            } else if (getItemViewType(i) == 2) {
                a(view);
            } else {
                int skinType = TbadkApplication.m252getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                agVar.e.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    com.baidu.adp.widget.a.a c = this.f.c(portrait);
                    if (c != null) {
                        agVar.e.setImageBitmap(c.h());
                    } else {
                        agVar.e.setTag(portrait);
                        agVar.e.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.photo));
                    }
                }
                agVar.f.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        agVar.g.setVisibility(0);
                        if (skinType == 1) {
                            agVar.g.setImageResource(com.baidu.tieba.u.icon_pop_boy_1);
                            break;
                        } else {
                            agVar.g.setImageResource(com.baidu.tieba.u.icon_pop_boy);
                            break;
                        }
                    case 2:
                        agVar.g.setVisibility(0);
                        if (skinType == 1) {
                            agVar.g.setImageResource(com.baidu.tieba.u.icon_pop_girl_1);
                            break;
                        } else {
                            agVar.g.setImageResource(com.baidu.tieba.u.icon_pop_girl);
                            break;
                        }
                    default:
                        agVar.g.setVisibility(8);
                        break;
                }
                agVar.h.setText(a(userData));
                agVar.i.setText(userData.getPosition());
                this.i = userData.getTShowInfo();
                if (agVar.j != null) {
                    agVar.j.a(this.i, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                if (this.e) {
                    agVar.d.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    agVar.d.setTag(valueOf);
                    agVar.d.setSelected(this.g.contains(valueOf));
                    agVar.d.setOnClickListener(new ae(this));
                } else {
                    agVar.d.setVisibility(8);
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
        com.baidu.tieba.im.model.ad b = this.a.b();
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
                return this.a.getString(com.baidu.tieba.y.members_no_speak);
            }
            return "";
        }
        return be.e(new Date(lastReplyTime * 1000));
    }

    public com.baidu.tbadk.editortool.ab e() {
        return this.f;
    }
}
