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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.IconData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.util.bu;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
    private MembersActivity a;
    private aa b;
    private boolean c;
    private boolean d;
    private boolean e;
    private com.baidu.tieba.util.i f;
    private Set<Long> g = new HashSet();
    private List<UserData> h = new ArrayList();
    private LinkedList<IconData> i = null;

    public void a(aa aaVar) {
        this.b = aaVar;
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

    public y(MembersActivity membersActivity) {
        this.a = membersActivity;
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
        ab abVar;
        View view2;
        if (this.h != null) {
            if (view == null) {
                ab abVar2 = new ab();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.a).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    abVar2.a = (LinearLayout) inflate.findViewById(R.id.list_more);
                    abVar2.c = (TextView) inflate.findViewById(R.id.more_title);
                    abVar2.d = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.im_list_divide, viewGroup, false);
                } else {
                    View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.im_members_list_item, viewGroup, false);
                    abVar2.b = (LinearLayout) inflate2.findViewById(R.id.list_content);
                    abVar2.f = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    abVar2.f.setIsRound(true);
                    abVar2.f.setAutoChangeStyle(true);
                    abVar2.g = (TextView) inflate2.findViewById(R.id.item_name);
                    abVar2.h = (ImageView) inflate2.findViewById(R.id.item_sex);
                    abVar2.i = (TextView) inflate2.findViewById(R.id.item_time);
                    abVar2.j = (TextView) inflate2.findViewById(R.id.item_address);
                    abVar2.e = (ImageView) inflate2.findViewById(R.id.item_check);
                    abVar2.k = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
                    view2 = inflate2;
                }
                view2.setTag(abVar2);
                abVar = abVar2;
                view = view2;
            } else {
                abVar = (ab) view.getTag();
            }
            if (getItemViewType(i) == 1) {
                if (this.c) {
                    abVar.c.setText(R.string.members_load_more_person);
                    abVar.d.setVisibility(0);
                } else {
                    abVar.c.setText(R.string.members_no_more_person);
                    abVar.d.setVisibility(8);
                }
            } else if (getItemViewType(i) == 2) {
                a(view);
            } else {
                int al = TiebaApplication.h().al();
                UserData userData = (UserData) getItem(i);
                abVar.f.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    com.baidu.adp.widget.ImageView.d c = this.f.c(portrait);
                    if (c != null) {
                        abVar.f.setImageBitmap(c.h());
                    } else {
                        abVar.f.setTag(portrait);
                        abVar.f.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                    }
                }
                abVar.g.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        abVar.h.setVisibility(0);
                        if (al == 1) {
                            abVar.h.setImageResource(R.drawable.icon_pop_boy_1);
                            break;
                        } else {
                            abVar.h.setImageResource(R.drawable.icon_pop_boy);
                            break;
                        }
                    case 2:
                        abVar.h.setVisibility(0);
                        if (al == 1) {
                            abVar.h.setImageResource(R.drawable.icon_pop_girl_1);
                            break;
                        } else {
                            abVar.h.setImageResource(R.drawable.icon_pop_girl);
                            break;
                        }
                    default:
                        abVar.h.setVisibility(8);
                        break;
                }
                abVar.i.setText(a(userData));
                abVar.j.setText(userData.getPosition());
                this.i = userData.getTShowInfo();
                if (abVar.k != null) {
                    abVar.k.a(this.i, 2, this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
                if (this.e) {
                    abVar.e.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserId());
                    abVar.e.setTag(valueOf);
                    abVar.e.setSelected(this.g.contains(valueOf));
                    abVar.e.setOnClickListener(new z(this));
                } else {
                    abVar.e.setVisibility(8);
                }
                a(view);
            }
        }
        return view;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TiebaApplication.h().al() == 1);
        this.a.getLayoutMode().a(view);
    }

    private String a(UserData userData) {
        long lastReplyTime;
        com.baidu.tieba.im.model.n b = this.a.b();
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
                return this.a.getString(R.string.members_no_speak);
            }
            return "";
        }
        return bu.d(new Date(lastReplyTime * 1000));
    }

    public com.baidu.tieba.util.i e() {
        return this.f;
    }
}
