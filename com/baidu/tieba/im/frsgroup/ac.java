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
import com.baidu.tbadk.core.util.bm;
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
public class ac extends BaseAdapter {
    private final MembersActivity a;
    private ae b;
    private boolean c;
    private boolean e;
    private final Set<Long> f = new HashSet();
    private final List<UserData> g = new ArrayList();
    private LinkedList<IconData> h = null;
    private boolean d = false;

    public void a(ae aeVar) {
        this.b = aeVar;
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

    public ac(MembersActivity membersActivity) {
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
        af afVar;
        View view2;
        if (this.g != null) {
            if (view == null) {
                af afVar2 = new af();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_members_list_foot, viewGroup, false);
                    afVar2.a = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.list_more);
                    afVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.v.more_title);
                    afVar2.c = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.more_progress);
                    view2 = inflate;
                } else {
                    View inflate2 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_members_list_item, viewGroup, false);
                    afVar2.e = (HeadImageView) inflate2.findViewById(com.baidu.tieba.v.item_head);
                    afVar2.e.setIsRound(true);
                    afVar2.e.setAutoChangeStyle(true);
                    afVar2.f = (TextView) inflate2.findViewById(com.baidu.tieba.v.item_name);
                    afVar2.g = (ImageView) inflate2.findViewById(com.baidu.tieba.v.item_sex);
                    afVar2.h = (TextView) inflate2.findViewById(com.baidu.tieba.v.item_time);
                    afVar2.i = (TextView) inflate2.findViewById(com.baidu.tieba.v.item_address);
                    afVar2.d = (ImageView) inflate2.findViewById(com.baidu.tieba.v.item_check);
                    afVar2.j = (UserIconBox) inflate2.findViewById(com.baidu.tieba.v.user_tshow_icon_box);
                    afVar2.k = inflate2.findViewById(com.baidu.tieba.v.list_line);
                    view2 = inflate2;
                }
                view2.setTag(afVar2);
                afVar = afVar2;
                view = view2;
            } else {
                afVar = (af) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.c) {
                    afVar.b.setText(com.baidu.tieba.y.members_load_more_person);
                    afVar.c.setVisibility(0);
                } else {
                    afVar.b.setText(com.baidu.tieba.y.members_no_more_person);
                    afVar.c.setVisibility(8);
                }
            } else {
                int skinType = TbadkApplication.m252getInst().getSkinType();
                UserData userData = (UserData) getItem(i);
                afVar.e.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    afVar.e.a(portrait, 12, false);
                }
                afVar.f.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        afVar.g.setVisibility(0);
                        if (skinType == 1) {
                            afVar.g.setImageResource(com.baidu.tieba.u.icon_pop_boy_1);
                            break;
                        } else {
                            afVar.g.setImageResource(com.baidu.tieba.u.icon_pop_boy);
                            break;
                        }
                    case 2:
                        afVar.g.setVisibility(0);
                        if (skinType == 1) {
                            afVar.g.setImageResource(com.baidu.tieba.u.icon_pop_girl_1);
                            break;
                        } else {
                            afVar.g.setImageResource(com.baidu.tieba.u.icon_pop_girl);
                            break;
                        }
                    default:
                        afVar.g.setVisibility(8);
                        break;
                }
                afVar.h.setText(a(userData));
                afVar.i.setText(userData.getPosition());
                this.h = userData.getTShowInfo();
                if (afVar.j != null) {
                    afVar.j.a(this.h, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.t.big_icon_margin), true);
                }
                if (this.e) {
                    afVar.d.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    afVar.d.setTag(valueOf);
                    afVar.d.setSelected(this.f.contains(valueOf));
                    afVar.d.setOnClickListener(new ad(this));
                } else {
                    afVar.d.setVisibility(8);
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
        com.baidu.tieba.im.model.ac b = this.a.b();
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
        return bm.e(new Date(lastReplyTime * 1000));
    }
}
