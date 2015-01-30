package com.baidu.tieba.im.searchfriend;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Drawable aps;
    private Drawable apt;
    private ArrayList<Object> bog = new ArrayList<>();
    private SearchFriendActivity boh;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.boh = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.l.d(this.boh.getPageContext().getPageActivity(), com.baidu.tieba.u.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Ti() != null && aVar.Tj() != null) {
            this.bog.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Ti().isEmpty()) {
                if (hm(aVar.Ti().getTagName())) {
                    arrayList.add(aVar.Ti().getTagName());
                } else {
                    arrayList.add(this.boh.getPageContext().getString(z.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Ti());
            }
            boolean z = false;
            for (com.baidu.tieba.im.searchfriend.a.b bVar : aVar.Tj()) {
                if (bVar.Ti() != null) {
                    if (!bVar.Ti().isEmpty()) {
                        if (!z) {
                            if (hm(bVar.Ti().getTagName())) {
                                arrayList.add(bVar.Ti().getTagName());
                            } else {
                                arrayList.add(this.boh.getPageContext().getString(z.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.bog.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean hm(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.im.searchfriend.a.a Th() {
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        Iterator<Object> it = this.bog.iterator();
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

    public void ap(String str, String str2) {
        if (this.bog != null && this.bog.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.bog.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.im.searchfriend.a.c) {
                    com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.nl();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.im.searchfriend.a.b) {
                    com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.Ti().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Ti().getUserId()))) {
                        bVar.Ti().nl();
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
        Object obj = this.bog.get(i);
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
        if (this.bog == null) {
            return 0;
        }
        return this.bog.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bog == null) {
            return null;
        }
        return this.bog.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
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
        v vVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof v)) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.boh.getPageContext().getPageActivity(), x.add_friend_recommend_title, null);
            v vVar2 = new v(this, null);
            vVar2.Xo = (TextView) view.findViewById(w.add_friend_recommend_title);
            vVar2.line = view.findViewById(w.add_friend_recommend_line);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.Xo.setText(str);
        bc.b(vVar.Xo, com.baidu.tieba.t.cp_cont_c, 1);
        bc.i(vVar.line, com.baidu.tieba.t.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.boh.getPageContext().getPageActivity(), x.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.aHd = (HeadImageView) view.findViewById(w.recommend_new_head);
            uVar2.aHe = (UserIconBox) view.findViewById(w.recommend_new_crown);
            uVar2.aHf = (TextView) view.findViewById(w.recommend_new_user_name);
            uVar2.aHg = (TextView) view.findViewById(w.recommend_new_introduce);
            uVar2.bol = (TextView) view.findViewById(w.detail_info_distance);
            uVar2.bom = (TextView) view.findViewById(w.detail_info_time);
            uVar2.aHh = (TextView) view.findViewById(w.recommend_new_add_friend);
            uVar2.aHh.setOnClickListener(new o(this));
            uVar2.aHi = (ImageView) view.findViewById(w.recommend_new_user_sex);
            uVar2.line = view.findViewById(w.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.aHh.setTag(cVar);
        view.setTag(cVar);
        this.boh.getLayoutMode().ab(z);
        this.boh.getLayoutMode().h(view);
        a(uVar, cVar, z);
        bc.i(uVar.line, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(view, com.baidu.tieba.v.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                uVar.aHd.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.nn())) {
                    uVar.aHd.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.aHd.setImageDrawable(null);
                    uVar.aHd.d(cVar.nn(), 12, false);
                }
            } else {
                uVar.aHd.setVisibility(8);
            }
            if (cVar.nq() != null && !TextUtils.isEmpty(cVar.nq().getUrl())) {
                uVar.aHe.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.nq());
                uVar.aHe.a(arrayList, 1, this.boh.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.boh.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.boh.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
            } else {
                uVar.aHe.setVisibility(8);
            }
            uVar.aHf.setText(cVar.getName());
            if (StringUtils.isNull(cVar.np())) {
                uVar.aHg.setVisibility(8);
            } else {
                uVar.aHg.setVisibility(0);
                uVar.aHg.setText(cVar.np());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.bol.setVisibility(8);
                uVar.bom.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().to() == 1) {
                uVar.bol.setVisibility(0);
                uVar.bol.setText(this.boh.getPageContext().getString(z.contact_yinshen));
                uVar.bol.setCompoundDrawables(null, null, null, null);
                uVar.bom.setVisibility(8);
            } else if (cVar.getLbsInfo().to() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.bol.setVisibility(0);
                    uVar.bom.setVisibility(0);
                    uVar.bol.setText(cVar.getLbsInfo().getDistance());
                    uVar.bom.setText(bf.m(cVar.getLbsInfo().getTime()));
                    this.aps = bc.getDrawable(com.baidu.tieba.v.icon_friend_pin);
                    this.aps.setBounds(0, 0, this.size, this.size);
                    uVar.bol.setCompoundDrawables(this.aps, null, null, null);
                    this.apt = bc.getDrawable(com.baidu.tieba.v.icon_friend_time);
                    this.apt.setBounds(0, 0, this.size, this.size);
                    uVar.bom.setCompoundDrawables(this.apt, null, null, null);
                } else {
                    uVar.bol.setVisibility(8);
                    uVar.bom.setVisibility(8);
                }
            } else {
                uVar.bol.setVisibility(8);
                uVar.bom.setVisibility(8);
            }
            if (cVar.no()) {
                bc.c(uVar.aHi, com.baidu.tieba.v.icon_pop_qz_girl);
            } else {
                bc.c(uVar.aHi, com.baidu.tieba.v.icon_pop_qz_boy);
            }
            if (cVar.nm()) {
                uVar.aHh.setClickable(false);
                uVar.aHh.setBackgroundResource(com.baidu.tieba.t.transparent);
                uVar.aHh.setText(z.waiting);
                bc.b(uVar.aHh, com.baidu.tieba.t.cp_cont_d, 1);
                return;
            }
            uVar.aHh.setClickable(true);
            uVar.aHh.setText(z.add);
        }
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.boh.getPageContext().getPageActivity(), x.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.bok = new u(this, null);
            View findViewById = view.findViewById(w.recommend_similar_top);
            tVar2.bok.aHd = (HeadImageView) findViewById.findViewById(w.recommend_new_head);
            tVar2.bok.aHe = (UserIconBox) findViewById.findViewById(w.recommend_new_crown);
            tVar2.bok.aHf = (TextView) findViewById.findViewById(w.recommend_new_user_name);
            tVar2.bok.aHg = (TextView) findViewById.findViewById(w.recommend_new_introduce);
            tVar2.bok.bol = (TextView) view.findViewById(w.detail_info_distance);
            tVar2.bok.bom = (TextView) view.findViewById(w.detail_info_time);
            tVar2.bok.line = findViewById.findViewById(w.recommend_new_line);
            tVar2.bok.aHh = (TextView) findViewById.findViewById(w.recommend_new_add_friend);
            tVar2.bok.aHh.setOnClickListener(new q(this, bVar));
            tVar2.bok.aHi = (ImageView) view.findViewById(w.recommend_new_user_sex);
            tVar2.bok.line = view.findViewById(w.recommend_new_line);
            tVar2.aGT = (TextView) view.findViewById(w.recommend_similar_bar_names);
            tVar2.aGU = (TextView) view.findViewById(w.recommend_similar_bar_desc);
            tVar2.aGX = (TbImageView) view.findViewById(w.recommend_similar_pic_one);
            tVar2.aGY = (TbImageView) view.findViewById(w.recommend_similar_pic_two);
            tVar2.aGZ = (TbImageView) view.findViewById(w.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.aGX.setTag(w.tag_first, bVar);
            tVar2.aGY.setTag(w.tag_first, bVar);
            tVar2.aGZ.setTag(w.tag_first, bVar);
            tVar2.aGX.setTag(w.tag_second, 0);
            tVar2.aGY.setTag(w.tag_second, 1);
            tVar2.aGZ.setTag(w.tag_second, 2);
            tVar2.aGX.setOnClickListener(rVar);
            tVar2.aGY.setOnClickListener(rVar);
            tVar2.aGZ.setOnClickListener(rVar);
            tVar2.aGV = (TextView) view.findViewById(w.recommend_similar_forum);
            tVar2.aGW = (TextView) view.findViewById(w.recommend_similar_common_conern);
            tVar2.aHa = (LinearLayout) view.findViewById(w.recommend_similar_forum_container);
            tVar2.aHb = (LinearLayout) view.findViewById(w.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(w.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(w.tag_first);
        }
        tVar.bok.aHh.setTag(bVar.Ti());
        view.setTag(w.tag_second, bVar.Ti());
        this.boh.getLayoutMode().ab(z);
        this.boh.getLayoutMode().h(view);
        a(tVar, bVar, z);
        bc.j(tVar.bok.line, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(view, com.baidu.tieba.v.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.Ti() != null) {
            a(tVar.bok, bVar.Ti(), z);
            if (bVar.ne() > 0) {
                if (!TextUtils.isEmpty(bVar.nf())) {
                    tVar.aGT.setText(bVar.nf());
                }
                if (bVar.ne() < 3) {
                    tVar.aGU.setVisibility(8);
                } else {
                    tVar.aGU.setVisibility(0);
                    tVar.aGU.setText(z.add_friend_forum_count);
                }
            } else {
                tVar.aHb.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.mc().mg() && bVar.ni() != null && bVar.ni().size() > 0) {
                tVar.aHa.setVisibility(0);
                if (bVar.Ti().no()) {
                    tVar.aGV.setText(z.add_friend_her_posts);
                } else {
                    tVar.aGV.setText(z.add_friend_his_posts);
                }
                switch (bVar.ni().size()) {
                    case 1:
                        tVar.aGX.setVisibility(0);
                        tVar.aGY.setVisibility(4);
                        tVar.aGZ.setVisibility(4);
                        tVar.aGX.d(bVar.ni().get(0), 10, false);
                        return;
                    case 2:
                        tVar.aGX.setVisibility(0);
                        tVar.aGY.setVisibility(0);
                        tVar.aGZ.setVisibility(4);
                        tVar.aGX.d(bVar.ni().get(0), 10, false);
                        tVar.aGY.d(bVar.ni().get(1), 10, false);
                        return;
                    default:
                        tVar.aGX.setVisibility(0);
                        tVar.aGY.setVisibility(0);
                        tVar.aGZ.setVisibility(0);
                        tVar.aGX.d(bVar.ni().get(0), 10, false);
                        tVar.aGY.d(bVar.ni().get(1), 10, false);
                        tVar.aGZ.d(bVar.ni().get(2), 10, false);
                        return;
                }
            }
            tVar.aHa.setVisibility(8);
        }
    }
}
