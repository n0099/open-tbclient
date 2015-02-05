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
    private Drawable apo;
    private Drawable apq;
    private ArrayList<Object> bof = new ArrayList<>();
    private SearchFriendActivity bog;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.bog = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.l.d(this.bog.getPageContext().getPageActivity(), com.baidu.tieba.u.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Td() != null && aVar.Te() != null) {
            this.bof.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Td().isEmpty()) {
                if (hj(aVar.Td().getTagName())) {
                    arrayList.add(aVar.Td().getTagName());
                } else {
                    arrayList.add(this.bog.getPageContext().getString(z.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Td());
            }
            boolean z = false;
            for (com.baidu.tieba.im.searchfriend.a.b bVar : aVar.Te()) {
                if (bVar.Td() != null) {
                    if (!bVar.Td().isEmpty()) {
                        if (!z) {
                            if (hj(bVar.Td().getTagName())) {
                                arrayList.add(bVar.Td().getTagName());
                            } else {
                                arrayList.add(this.bog.getPageContext().getString(z.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.bof.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean hj(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.im.searchfriend.a.a Tc() {
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        Iterator<Object> it = this.bof.iterator();
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
        if (this.bof != null && this.bof.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.bof.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.im.searchfriend.a.c) {
                    com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.ne();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.im.searchfriend.a.b) {
                    com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.Td().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Td().getUserId()))) {
                        bVar.Td().ne();
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
        Object obj = this.bof.get(i);
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
        if (this.bof == null) {
            return 0;
        }
        return this.bof.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bof == null) {
            return null;
        }
        return this.bof.get(i);
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
            view = com.baidu.adp.lib.g.b.ei().inflate(this.bog.getPageContext().getPageActivity(), x.add_friend_recommend_title, null);
            v vVar2 = new v(this, null);
            vVar2.Xl = (TextView) view.findViewById(w.add_friend_recommend_title);
            vVar2.line = view.findViewById(w.add_friend_recommend_line);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.Xl.setText(str);
        bc.b(vVar.Xl, com.baidu.tieba.t.cp_cont_c, 1);
        bc.i(vVar.line, com.baidu.tieba.t.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.bog.getPageContext().getPageActivity(), x.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.aHa = (HeadImageView) view.findViewById(w.recommend_new_head);
            uVar2.aHb = (UserIconBox) view.findViewById(w.recommend_new_crown);
            uVar2.aHc = (TextView) view.findViewById(w.recommend_new_user_name);
            uVar2.aHd = (TextView) view.findViewById(w.recommend_new_introduce);
            uVar2.bok = (TextView) view.findViewById(w.detail_info_distance);
            uVar2.bol = (TextView) view.findViewById(w.detail_info_time);
            uVar2.aHe = (TextView) view.findViewById(w.recommend_new_add_friend);
            uVar2.aHe.setOnClickListener(new o(this));
            uVar2.aHf = (ImageView) view.findViewById(w.recommend_new_user_sex);
            uVar2.line = view.findViewById(w.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.aHe.setTag(cVar);
        view.setTag(cVar);
        this.bog.getLayoutMode().ab(z);
        this.bog.getLayoutMode().h(view);
        a(uVar, cVar, z);
        bc.i(uVar.line, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(view, com.baidu.tieba.v.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.l.lV().lX()) {
                uVar.aHa.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.ng())) {
                    uVar.aHa.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.aHa.setImageDrawable(null);
                    uVar.aHa.d(cVar.ng(), 12, false);
                }
            } else {
                uVar.aHa.setVisibility(8);
            }
            if (cVar.nj() != null && !TextUtils.isEmpty(cVar.nj().getUrl())) {
                uVar.aHb.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.nj());
                uVar.aHb.a(arrayList, 1, this.bog.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.bog.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.bog.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
            } else {
                uVar.aHb.setVisibility(8);
            }
            uVar.aHc.setText(cVar.getName());
            if (StringUtils.isNull(cVar.ni())) {
                uVar.aHd.setVisibility(8);
            } else {
                uVar.aHd.setVisibility(0);
                uVar.aHd.setText(cVar.ni());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.bok.setVisibility(8);
                uVar.bol.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().ti() == 1) {
                uVar.bok.setVisibility(0);
                uVar.bok.setText(this.bog.getPageContext().getString(z.contact_yinshen));
                uVar.bok.setCompoundDrawables(null, null, null, null);
                uVar.bol.setVisibility(8);
            } else if (cVar.getLbsInfo().ti() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.bok.setVisibility(0);
                    uVar.bol.setVisibility(0);
                    uVar.bok.setText(cVar.getLbsInfo().getDistance());
                    uVar.bol.setText(bf.m(cVar.getLbsInfo().getTime()));
                    this.apo = bc.getDrawable(com.baidu.tieba.v.icon_friend_pin);
                    this.apo.setBounds(0, 0, this.size, this.size);
                    uVar.bok.setCompoundDrawables(this.apo, null, null, null);
                    this.apq = bc.getDrawable(com.baidu.tieba.v.icon_friend_time);
                    this.apq.setBounds(0, 0, this.size, this.size);
                    uVar.bol.setCompoundDrawables(this.apq, null, null, null);
                } else {
                    uVar.bok.setVisibility(8);
                    uVar.bol.setVisibility(8);
                }
            } else {
                uVar.bok.setVisibility(8);
                uVar.bol.setVisibility(8);
            }
            if (cVar.nh()) {
                bc.c(uVar.aHf, com.baidu.tieba.v.icon_pop_qz_girl);
            } else {
                bc.c(uVar.aHf, com.baidu.tieba.v.icon_pop_qz_boy);
            }
            if (cVar.nf()) {
                uVar.aHe.setClickable(false);
                uVar.aHe.setBackgroundResource(com.baidu.tieba.t.transparent);
                uVar.aHe.setText(z.waiting);
                bc.b(uVar.aHe, com.baidu.tieba.t.cp_cont_d, 1);
                return;
            }
            uVar.aHe.setClickable(true);
            uVar.aHe.setText(z.add);
        }
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.bog.getPageContext().getPageActivity(), x.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.boj = new u(this, null);
            View findViewById = view.findViewById(w.recommend_similar_top);
            tVar2.boj.aHa = (HeadImageView) findViewById.findViewById(w.recommend_new_head);
            tVar2.boj.aHb = (UserIconBox) findViewById.findViewById(w.recommend_new_crown);
            tVar2.boj.aHc = (TextView) findViewById.findViewById(w.recommend_new_user_name);
            tVar2.boj.aHd = (TextView) findViewById.findViewById(w.recommend_new_introduce);
            tVar2.boj.bok = (TextView) view.findViewById(w.detail_info_distance);
            tVar2.boj.bol = (TextView) view.findViewById(w.detail_info_time);
            tVar2.boj.line = findViewById.findViewById(w.recommend_new_line);
            tVar2.boj.aHe = (TextView) findViewById.findViewById(w.recommend_new_add_friend);
            tVar2.boj.aHe.setOnClickListener(new q(this, bVar));
            tVar2.boj.aHf = (ImageView) view.findViewById(w.recommend_new_user_sex);
            tVar2.boj.line = view.findViewById(w.recommend_new_line);
            tVar2.aGQ = (TextView) view.findViewById(w.recommend_similar_bar_names);
            tVar2.aGR = (TextView) view.findViewById(w.recommend_similar_bar_desc);
            tVar2.aGU = (TbImageView) view.findViewById(w.recommend_similar_pic_one);
            tVar2.aGV = (TbImageView) view.findViewById(w.recommend_similar_pic_two);
            tVar2.aGW = (TbImageView) view.findViewById(w.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.aGU.setTag(w.tag_first, bVar);
            tVar2.aGV.setTag(w.tag_first, bVar);
            tVar2.aGW.setTag(w.tag_first, bVar);
            tVar2.aGU.setTag(w.tag_second, 0);
            tVar2.aGV.setTag(w.tag_second, 1);
            tVar2.aGW.setTag(w.tag_second, 2);
            tVar2.aGU.setOnClickListener(rVar);
            tVar2.aGV.setOnClickListener(rVar);
            tVar2.aGW.setOnClickListener(rVar);
            tVar2.aGS = (TextView) view.findViewById(w.recommend_similar_forum);
            tVar2.aGT = (TextView) view.findViewById(w.recommend_similar_common_conern);
            tVar2.aGX = (LinearLayout) view.findViewById(w.recommend_similar_forum_container);
            tVar2.aGY = (LinearLayout) view.findViewById(w.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(w.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(w.tag_first);
        }
        tVar.boj.aHe.setTag(bVar.Td());
        view.setTag(w.tag_second, bVar.Td());
        this.bog.getLayoutMode().ab(z);
        this.bog.getLayoutMode().h(view);
        a(tVar, bVar, z);
        bc.j(tVar.boj.line, com.baidu.tieba.t.cp_bg_line_b);
        bc.i(view, com.baidu.tieba.v.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.Td() != null) {
            a(tVar.boj, bVar.Td(), z);
            if (bVar.mX() > 0) {
                if (!TextUtils.isEmpty(bVar.mY())) {
                    tVar.aGQ.setText(bVar.mY());
                }
                if (bVar.mX() < 3) {
                    tVar.aGR.setVisibility(8);
                } else {
                    tVar.aGR.setVisibility(0);
                    tVar.aGR.setText(z.add_friend_forum_count);
                }
            } else {
                tVar.aGY.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.lV().lZ() && bVar.nb() != null && bVar.nb().size() > 0) {
                tVar.aGX.setVisibility(0);
                if (bVar.Td().nh()) {
                    tVar.aGS.setText(z.add_friend_her_posts);
                } else {
                    tVar.aGS.setText(z.add_friend_his_posts);
                }
                switch (bVar.nb().size()) {
                    case 1:
                        tVar.aGU.setVisibility(0);
                        tVar.aGV.setVisibility(4);
                        tVar.aGW.setVisibility(4);
                        tVar.aGU.d(bVar.nb().get(0), 10, false);
                        return;
                    case 2:
                        tVar.aGU.setVisibility(0);
                        tVar.aGV.setVisibility(0);
                        tVar.aGW.setVisibility(4);
                        tVar.aGU.d(bVar.nb().get(0), 10, false);
                        tVar.aGV.d(bVar.nb().get(1), 10, false);
                        return;
                    default:
                        tVar.aGU.setVisibility(0);
                        tVar.aGV.setVisibility(0);
                        tVar.aGW.setVisibility(0);
                        tVar.aGU.d(bVar.nb().get(0), 10, false);
                        tVar.aGV.d(bVar.nb().get(1), 10, false);
                        tVar.aGW.d(bVar.nb().get(2), 10, false);
                        return;
                }
            }
            tVar.aGX.setVisibility(8);
        }
    }
}
