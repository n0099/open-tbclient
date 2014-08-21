package com.baidu.tieba.im.searchfriend;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<Object> a = new ArrayList<>();
    private SearchFriendActivity b;

    public l(SearchFriendActivity searchFriendActivity) {
        this.b = searchFriendActivity;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.a() != null && aVar.b() != null) {
            this.a.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.a().j()) {
                arrayList.add(this.b.getString(x.add_friend_recommend_title_new));
                arrayList.add(aVar.a());
            }
            boolean z = false;
            for (com.baidu.tieba.im.searchfriend.a.b bVar : aVar.b()) {
                if (bVar.c() != null) {
                    if (!bVar.c().j()) {
                        if (!z) {
                            arrayList.add(this.b.getString(x.add_friend_recommend_title_similar));
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.a.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.im.searchfriend.a.a a() {
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        Iterator<Object> it = this.a.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof com.baidu.tieba.im.searchfriend.a.c) {
                aVar.a((com.baidu.tieba.im.searchfriend.a.c) next);
            } else if (next instanceof com.baidu.tieba.im.searchfriend.a.b) {
                aVar.a((com.baidu.tieba.im.searchfriend.a.b) next);
            }
        }
        return aVar;
    }

    public void a(String str, String str2) {
        if (this.a != null && this.a.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.a.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.im.searchfriend.a.c) {
                    com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.e(), str2) && TextUtils.equals(str, String.valueOf(cVar.c()))) {
                        cVar.a();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.im.searchfriend.a.b) {
                    com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.c().e(), str2) && TextUtils.equals(str, String.valueOf(bVar.c().c()))) {
                        bVar.c().a();
                        notifyDataSetChanged();
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object obj = this.a.get(i);
        if (obj == null) {
            return super.getItemViewType(i);
        }
        if (obj instanceof String) {
            return 0;
        }
        if (obj instanceof com.baidu.tieba.im.searchfriend.a.c) {
            return 1;
        }
        if (obj instanceof com.baidu.tieba.im.searchfriend.a.b) {
            return 2;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        switch (itemViewType) {
            case 0:
                return a(view, (String) getItem(i), 1 == skinType);
            case 1:
                return a(view, (com.baidu.tieba.im.searchfriend.a.c) getItem(i), 1 == skinType);
            case 2:
                return a(view, (com.baidu.tieba.im.searchfriend.a.b) getItem(i), 1 == skinType);
            default:
                return view;
        }
    }

    private View a(View view, String str, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof t)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, v.add_friend_recommend_title, null);
            t tVar2 = new t(this, null);
            tVar2.a = (TextView) view.findViewById(u.add_friend_recommend_title);
            tVar2.b = view.findViewById(u.add_friend_recommend_line);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        tVar.a.setText(str);
        tVar.a.setTextColor(z ? this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1) : this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
        tVar.b.setBackgroundResource(z ? com.baidu.tieba.r.cp_bg_line_b_1 : com.baidu.tieba.r.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        r rVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof r)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, v.add_friend_recommend_new, null);
            r rVar2 = new r(this, null);
            rVar2.a = (HeadImageView) view.findViewById(u.recommend_new_head);
            rVar2.b = (UserIconBox) view.findViewById(u.recommend_new_crown);
            rVar2.c = (TextView) view.findViewById(u.recommend_new_user_name);
            rVar2.e = (TextView) view.findViewById(u.recommend_new_introduce);
            rVar2.f = (TextView) view.findViewById(u.recommend_new_add_friend);
            rVar2.f.setOnClickListener(new m(this));
            rVar2.d = (TextView) view.findViewById(u.recommend_new_distance);
            rVar2.g = (ImageView) view.findViewById(u.recommend_new_user_sex);
            rVar2.h = view.findViewById(u.recommend_new_line);
            view.setOnClickListener(new n(this));
            view.setTag(rVar2);
            rVar = rVar2;
        } else {
            rVar = (r) view.getTag();
        }
        rVar.f.setTag(cVar);
        view.setTag(cVar);
        this.b.getLayoutMode().a(z);
        this.b.getLayoutMode().a(view);
        a(rVar, cVar, z);
        rVar.h.setBackgroundResource(z ? com.baidu.tieba.r.cp_bg_line_b_1 : com.baidu.tieba.r.cp_bg_line_b);
        view.setBackgroundResource(z ? com.baidu.tieba.t.recommend_friend_item_bg_1 : com.baidu.tieba.t.recommend_friend_item_bg);
        return view;
    }

    private void a(r rVar, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && rVar != null) {
            if (com.baidu.tbadk.core.h.a().d()) {
                rVar.a.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.d())) {
                    rVar.a.setUserId(String.valueOf(cVar.c()));
                    rVar.a.setImageDrawable(null);
                    rVar.a.a(cVar.d(), 12, false);
                }
            } else {
                rVar.a.setVisibility(8);
            }
            if (cVar.i() != null && !TextUtils.isEmpty(cVar.i().getUrl())) {
                rVar.b.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.i());
                rVar.b.a(arrayList, 1, this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height), this.b.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_margin));
            } else {
                rVar.b.setVisibility(8);
            }
            rVar.c.setText(cVar.e());
            rVar.e.setText(cVar.h());
            if (cVar.g() > 0) {
                rVar.d.setVisibility(0);
                rVar.d.setText(this.b.getString(x.add_friend_distance, new Object[]{Integer.valueOf(cVar.g())}));
            } else {
                rVar.d.setVisibility(8);
            }
            if (cVar.f()) {
                rVar.g.setImageResource(z ? com.baidu.tieba.t.icon_pop_qz_girl_1 : com.baidu.tieba.t.icon_pop_qz_girl);
            } else {
                rVar.g.setImageResource(z ? com.baidu.tieba.t.icon_pop_qz_boy_1 : com.baidu.tieba.t.icon_pop_qz_boy);
            }
            if (cVar.b()) {
                rVar.f.setClickable(false);
                rVar.f.setBackgroundResource(com.baidu.tieba.r.transparent);
                rVar.f.setText(x.waiting);
                rVar.f.setTextColor(z ? this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_d) : this.b.getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
                return;
            }
            rVar.f.setClickable(true);
            rVar.f.setText(x.add);
        }
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        q qVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof r)) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, v.add_friend_recommend_similar, null);
            q qVar2 = new q(this, null);
            qVar2.a = new r(this, null);
            View findViewById = view.findViewById(u.recommend_similar_top);
            qVar2.a.a = (HeadImageView) findViewById.findViewById(u.recommend_new_head);
            qVar2.a.b = (UserIconBox) findViewById.findViewById(u.recommend_new_crown);
            qVar2.a.c = (TextView) findViewById.findViewById(u.recommend_new_user_name);
            qVar2.a.d = (TextView) findViewById.findViewById(u.recommend_new_distance);
            qVar2.a.e = (TextView) findViewById.findViewById(u.recommend_new_introduce);
            qVar2.a.h = findViewById.findViewById(u.recommend_new_line);
            qVar2.a.f = (TextView) findViewById.findViewById(u.recommend_new_add_friend);
            qVar2.a.f.setOnClickListener(new o(this));
            qVar2.a.g = (ImageView) view.findViewById(u.recommend_new_user_sex);
            qVar2.a.h = view.findViewById(u.recommend_new_line);
            qVar2.b = (TextView) view.findViewById(u.recommend_similar_bar_names);
            qVar2.c = (TextView) view.findViewById(u.recommend_similar_bar_desc);
            qVar2.f = (TbImageView) view.findViewById(u.recommend_similar_pic_one);
            qVar2.g = (TbImageView) view.findViewById(u.recommend_similar_pic_two);
            qVar2.h = (TbImageView) view.findViewById(u.recommend_similar_pic_thr);
            qVar2.d = (TextView) view.findViewById(u.recommend_similar_forum);
            qVar2.e = (TextView) view.findViewById(u.recommend_similar_common_conern);
            qVar2.i = (LinearLayout) view.findViewById(u.recommend_similar_forum_container);
            qVar2.j = (LinearLayout) view.findViewById(u.recommend_similar_commom_conern_container);
            view.setOnClickListener(new p(this));
            view.setTag(qVar2);
            qVar = qVar2;
        } else {
            qVar = (q) view.getTag();
        }
        qVar.a.f.setTag(bVar.c());
        view.setTag(bVar.c());
        this.b.getLayoutMode().a(z);
        this.b.getLayoutMode().a(view);
        a(qVar, bVar, z);
        qVar.a.h.setBackgroundResource(z ? com.baidu.tieba.r.cp_bg_line_b_1 : com.baidu.tieba.r.cp_bg_line_b);
        view.setBackgroundResource(z ? com.baidu.tieba.t.recommend_friend_item_bg_1 : com.baidu.tieba.t.recommend_friend_item_bg);
        return view;
    }

    private void a(q qVar, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        if (qVar != null && bVar != null && bVar.c() != null) {
            a(qVar.a, bVar.c(), z);
            if (bVar.a() > 0) {
                if (!TextUtils.isEmpty(bVar.b())) {
                    qVar.b.setText(bVar.b());
                }
                if (bVar.a() < 3) {
                    qVar.c.setVisibility(8);
                } else {
                    qVar.c.setVisibility(0);
                    qVar.c.setText(x.add_friend_forum_count);
                }
            } else {
                qVar.j.setVisibility(8);
            }
            if (com.baidu.tbadk.core.h.a().f() && bVar.d() != null && bVar.d().size() > 0) {
                qVar.i.setVisibility(0);
                if (bVar.c().f()) {
                    qVar.d.setText(x.add_friend_her_posts);
                } else {
                    qVar.d.setText(x.add_friend_his_posts);
                }
                switch (bVar.d().size()) {
                    case 1:
                        qVar.f.setVisibility(0);
                        qVar.g.setVisibility(4);
                        qVar.h.setVisibility(4);
                        qVar.f.a(bVar.d().get(0), 10, false);
                        return;
                    case 2:
                        qVar.f.setVisibility(0);
                        qVar.g.setVisibility(0);
                        qVar.h.setVisibility(4);
                        qVar.f.a(bVar.d().get(0), 10, false);
                        qVar.g.a(bVar.d().get(1), 10, false);
                        return;
                    default:
                        qVar.f.setVisibility(0);
                        qVar.g.setVisibility(0);
                        qVar.h.setVisibility(0);
                        qVar.f.a(bVar.d().get(0), 10, false);
                        qVar.g.a(bVar.d().get(1), 10, false);
                        qVar.h.a(bVar.d().get(2), 10, false);
                        return;
                }
            }
            qVar.i.setVisibility(8);
        }
    }
}
