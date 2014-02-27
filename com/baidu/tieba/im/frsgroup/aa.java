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
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.util.bs;
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
public final class aa extends BaseAdapter {
    private MembersActivity a;
    private ac b;
    private boolean c;
    private boolean d;
    private boolean e;
    private com.baidu.tieba.util.i f;
    private Set<Long> g = new HashSet();
    private List<UserData> h = new ArrayList();
    private LinkedList<IconData> i = null;

    public final void a(ac acVar) {
        this.b = acVar;
    }

    public final void a(List<UserData> list) {
        this.h.addAll(list);
    }

    public final void b(List<Long> list) {
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

    public final void a() {
        this.g.clear();
    }

    public final Set<Long> b() {
        return this.g;
    }

    public final void a(Long l) {
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

    public final void a(boolean z) {
        if (z) {
            this.h.clear();
        }
        this.d = false;
        this.c = true;
    }

    public aa(MembersActivity membersActivity) {
        this.a = membersActivity;
        this.f = new com.baidu.tieba.util.i(membersActivity);
        this.f.a(false);
        this.d = false;
    }

    public final void b(boolean z) {
        this.c = false;
    }

    public final boolean c() {
        return this.c;
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final boolean d() {
        return this.e;
    }

    public final void d(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
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
    public final Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.h.size()) {
            return null;
        }
        return this.h.get(itemId);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (this.d && i == getCount() - 1) {
            return -2L;
        }
        if (i % 2 == 0) {
            return -1L;
        }
        return i / 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        if (getItemId(i) == -1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        ad adVar;
        View view2;
        if (this.h != null) {
            if (view == null) {
                ad adVar2 = new ad();
                if (getItemViewType(i) == 1) {
                    View inflate = LayoutInflater.from(this.a).inflate(R.layout.im_members_list_foot, viewGroup, false);
                    adVar2.a = (LinearLayout) inflate.findViewById(R.id.list_more);
                    adVar2.b = (TextView) inflate.findViewById(R.id.more_title);
                    adVar2.c = (ProgressBar) inflate.findViewById(R.id.more_progress);
                    view2 = inflate;
                } else if (getItemViewType(i) == 2) {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.im_list_divide, viewGroup, false);
                } else {
                    View inflate2 = LayoutInflater.from(this.a).inflate(R.layout.im_members_list_item, viewGroup, false);
                    adVar2.e = (HeadImageView) inflate2.findViewById(R.id.item_head);
                    adVar2.e.setIsRound(true);
                    adVar2.e.setAutoChangeStyle(true);
                    adVar2.f = (TextView) inflate2.findViewById(R.id.item_name);
                    adVar2.g = (ImageView) inflate2.findViewById(R.id.item_sex);
                    adVar2.h = (TextView) inflate2.findViewById(R.id.item_time);
                    adVar2.i = (TextView) inflate2.findViewById(R.id.item_address);
                    adVar2.d = (ImageView) inflate2.findViewById(R.id.item_check);
                    adVar2.j = (UserIconBox) inflate2.findViewById(R.id.user_tshow_icon_box);
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
                    adVar.b.setText(R.string.members_load_more_person);
                    adVar.c.setVisibility(0);
                } else {
                    adVar.b.setText(R.string.members_no_more_person);
                    adVar.c.setVisibility(8);
                }
            } else if (getItemViewType(i) == 2) {
                a(view);
            } else {
                int ae = TiebaApplication.g().ae();
                UserData userData = (UserData) getItem(i);
                adVar.e.setTag(null);
                String portrait = userData.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    com.baidu.tieba.util.i iVar = this.f;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        adVar.e.setImageBitmap(b.h());
                    } else {
                        adVar.e.setTag(portrait);
                        adVar.e.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                    }
                }
                adVar.f.setText(userData.getUserName());
                switch (userData.getSex()) {
                    case 1:
                        adVar.g.setVisibility(0);
                        if (ae == 1) {
                            adVar.g.setImageResource(R.drawable.icon_pop_boy_1);
                            break;
                        } else {
                            adVar.g.setImageResource(R.drawable.icon_pop_boy);
                            break;
                        }
                    case 2:
                        adVar.g.setVisibility(0);
                        if (ae == 1) {
                            adVar.g.setImageResource(R.drawable.icon_pop_girl_1);
                            break;
                        } else {
                            adVar.g.setImageResource(R.drawable.icon_pop_girl);
                            break;
                        }
                    default:
                        adVar.g.setVisibility(8);
                        break;
                }
                TextView textView = adVar.h;
                long j = 0;
                com.baidu.tieba.im.model.l a = this.a.a();
                switch (a.a()) {
                    case 0:
                        j = userData.getLoginTime();
                        break;
                    case 1:
                        j = userData.getLastReplyTime();
                        break;
                    case 2:
                        j = userData.getInTime();
                        break;
                }
                textView.setText(j <= 0 ? a.a() == 1 ? this.a.getString(R.string.members_no_speak) : "" : bs.d(new Date(j * 1000)));
                adVar.i.setText(userData.getPosition());
                this.i = userData.getTShowInfo();
                if (adVar.j != null) {
                    adVar.j.a(this.i, 2, this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_width), this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_height), this.a.getResources().getDimensionPixelSize(R.dimen.big_icon_margin), true);
                }
                if (this.e) {
                    adVar.d.setVisibility(userData.getPermission().isController() ? 4 : 0);
                    Long valueOf = Long.valueOf(userData.getUserIdLong());
                    adVar.d.setTag(valueOf);
                    adVar.d.setSelected(this.g.contains(valueOf));
                    adVar.d.setOnClickListener(new ab(this));
                } else {
                    adVar.d.setVisibility(8);
                }
                a(view);
            }
        }
        return view;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TiebaApplication.g().ae() == 1);
        this.a.getLayoutMode().a(view);
    }

    public final com.baidu.tieba.util.i e() {
        return this.f;
    }
}
