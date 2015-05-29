package com.baidu.tieba.addresslist.im.searchfriend;

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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<Object> Su = new ArrayList<>();
    private SearchFriendActivity aAX;
    private Drawable azB;
    private Drawable azC;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.aAX = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.n.d(this.aAX.getPageContext().getPageActivity(), com.baidu.tieba.o.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Gf() != null && aVar.Gg() != null) {
            this.Su.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Gf().isEmpty()) {
                if (fF(aVar.Gf().getTagName())) {
                    arrayList.add(aVar.Gf().getTagName());
                } else {
                    arrayList.add(this.aAX.getPageContext().getString(com.baidu.tieba.t.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Gf());
            }
            boolean z = false;
            for (com.baidu.tieba.addresslist.im.searchfriend.a.b bVar : aVar.Gg()) {
                if (bVar.Gf() != null) {
                    if (!bVar.Gf().isEmpty()) {
                        if (!z) {
                            if (fF(bVar.Gf().getTagName())) {
                                arrayList.add(bVar.Gf().getTagName());
                            } else {
                                arrayList.add(this.aAX.getPageContext().getString(com.baidu.tieba.t.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.Su.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean fF(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.addresslist.im.searchfriend.a.a Ge() {
        com.baidu.tieba.addresslist.im.searchfriend.a.a aVar = new com.baidu.tieba.addresslist.im.searchfriend.a.a();
        Iterator<Object> it = this.Su.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
                aVar.a((com.baidu.tieba.addresslist.im.searchfriend.a.c) next);
            } else if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.b) {
                aVar.a((com.baidu.tieba.addresslist.im.searchfriend.a.b) next);
            }
        }
        return aVar;
    }

    public void aq(String str, String str2) {
        if (this.Su != null && this.Su.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.Su.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
                    com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.ra();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.b) {
                    com.baidu.tieba.addresslist.im.searchfriend.a.b bVar = (com.baidu.tieba.addresslist.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.Gf().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Gf().getUserId()))) {
                        bVar.Gf().ra();
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
        Object obj = this.Su.get(i);
        if (obj == null) {
            return super.getItemViewType(i);
        }
        if (obj instanceof String) {
            return 0;
        }
        if (obj instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
            return 1;
        }
        if (obj instanceof com.baidu.tieba.addresslist.im.searchfriend.a.b) {
            return 2;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Su == null) {
            return 0;
        }
        return this.Su.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Su == null) {
            return null;
        }
        return this.Su.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        switch (itemViewType) {
            case 0:
                return a(view, (String) getItem(i), 1 == skinType);
            case 1:
                return a(view, (com.baidu.tieba.addresslist.im.searchfriend.a.c) getItem(i), 1 == skinType);
            case 2:
                return a(view, (com.baidu.tieba.addresslist.im.searchfriend.a.b) getItem(i), 1 == skinType);
            default:
                return view;
        }
    }

    private View a(View view, String str, boolean z) {
        v vVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof v)) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.aAX.getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_title, null);
            v vVar2 = new v(this, null);
            vVar2.aiA = (TextView) view.findViewById(com.baidu.tieba.q.add_friend_recommend_title);
            vVar2.line = view.findViewById(com.baidu.tieba.q.add_friend_recommend_line);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.aiA.setText(str);
        ay.b(vVar.aiA, com.baidu.tieba.n.cp_cont_c, 1);
        ay.i(vVar.line, com.baidu.tieba.n.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.aAX.getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.aBk = (HeadImageView) view.findViewById(com.baidu.tieba.q.recommend_new_head);
            uVar2.aBl = (UserIconBox) view.findViewById(com.baidu.tieba.q.recommend_new_crown);
            uVar2.aBm = (TextView) view.findViewById(com.baidu.tieba.q.recommend_new_user_name);
            uVar2.aBn = (TextView) view.findViewById(com.baidu.tieba.q.recommend_new_introduce);
            uVar2.aBo = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_distance);
            uVar2.aBp = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_time);
            uVar2.aBq = (TextView) view.findViewById(com.baidu.tieba.q.recommend_new_add_friend);
            uVar2.aBq.setOnClickListener(new o(this));
            uVar2.aBr = (ImageView) view.findViewById(com.baidu.tieba.q.recommend_new_user_sex);
            uVar2.line = view.findViewById(com.baidu.tieba.q.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.aBq.setTag(cVar);
        view.setTag(cVar);
        this.aAX.getLayoutMode().ab(z);
        this.aAX.getLayoutMode().j(view);
        a(uVar, cVar, z);
        ay.i(uVar.line, com.baidu.tieba.n.cp_bg_line_b);
        ay.i(view, com.baidu.tieba.p.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.n.qc().qe()) {
                uVar.aBk.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.rc())) {
                    uVar.aBk.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.aBk.setImageDrawable(null);
                    uVar.aBk.c(cVar.rc(), 12, false);
                }
            } else {
                uVar.aBk.setVisibility(8);
            }
            if (cVar.rf() != null && !TextUtils.isEmpty(cVar.rf().getUrl())) {
                uVar.aBl.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.rf());
                uVar.aBl.a(arrayList, 1, this.aAX.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.aAX.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.aAX.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin));
            } else {
                uVar.aBl.setVisibility(8);
            }
            uVar.aBm.setText(cVar.getName());
            if (StringUtils.isNull(cVar.re())) {
                uVar.aBn.setVisibility(8);
            } else {
                uVar.aBn.setVisibility(0);
                uVar.aBn.setText(cVar.re());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.aBo.setVisibility(8);
                uVar.aBp.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().xx() == 1) {
                uVar.aBo.setVisibility(0);
                uVar.aBo.setText(this.aAX.getPageContext().getString(com.baidu.tieba.t.contact_yinshen));
                uVar.aBo.setCompoundDrawables(null, null, null, null);
                uVar.aBp.setVisibility(8);
            } else if (cVar.getLbsInfo().xx() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.aBo.setVisibility(0);
                    uVar.aBp.setVisibility(0);
                    uVar.aBo.setText(cVar.getLbsInfo().getDistance());
                    uVar.aBp.setText(bb.n(cVar.getLbsInfo().getTime()));
                    this.azB = ay.getDrawable(com.baidu.tieba.p.icon_friend_pin);
                    this.azB.setBounds(0, 0, this.size, this.size);
                    uVar.aBo.setCompoundDrawables(this.azB, null, null, null);
                    this.azC = ay.getDrawable(com.baidu.tieba.p.icon_friend_time);
                    this.azC.setBounds(0, 0, this.size, this.size);
                    uVar.aBp.setCompoundDrawables(this.azC, null, null, null);
                } else {
                    uVar.aBo.setVisibility(8);
                    uVar.aBp.setVisibility(8);
                }
            } else {
                uVar.aBo.setVisibility(8);
                uVar.aBp.setVisibility(8);
            }
            if (cVar.rd()) {
                ay.c(uVar.aBr, com.baidu.tieba.p.icon_pop_qz_girl);
            } else {
                ay.c(uVar.aBr, com.baidu.tieba.p.icon_pop_qz_boy);
            }
            if (cVar.rb()) {
                uVar.aBq.setClickable(false);
                uVar.aBq.setBackgroundResource(com.baidu.tieba.n.transparent);
                uVar.aBq.setText(com.baidu.tieba.t.waiting);
                ay.b(uVar.aBq, com.baidu.tieba.n.cp_cont_d, 1);
                return;
            }
            uVar.aBq.setClickable(true);
            uVar.aBq.setText(com.baidu.tieba.t.add);
        }
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.aAX.getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.aBa = new u(this, null);
            View findViewById = view.findViewById(com.baidu.tieba.q.recommend_similar_top);
            tVar2.aBa.aBk = (HeadImageView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_head);
            tVar2.aBa.aBl = (UserIconBox) findViewById.findViewById(com.baidu.tieba.q.recommend_new_crown);
            tVar2.aBa.aBm = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_user_name);
            tVar2.aBa.aBn = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_introduce);
            tVar2.aBa.aBo = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_distance);
            tVar2.aBa.aBp = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_time);
            tVar2.aBa.line = findViewById.findViewById(com.baidu.tieba.q.recommend_new_line);
            tVar2.aBa.aBq = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_add_friend);
            tVar2.aBa.aBq.setOnClickListener(new q(this, bVar));
            tVar2.aBa.aBr = (ImageView) view.findViewById(com.baidu.tieba.q.recommend_new_user_sex);
            tVar2.aBa.line = view.findViewById(com.baidu.tieba.q.recommend_new_line);
            tVar2.aBb = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_names);
            tVar2.aBc = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_desc);
            tVar2.aBf = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_one);
            tVar2.aBg = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_two);
            tVar2.aBh = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.aBf.setTag(com.baidu.tieba.q.tag_first, bVar);
            tVar2.aBg.setTag(com.baidu.tieba.q.tag_first, bVar);
            tVar2.aBh.setTag(com.baidu.tieba.q.tag_first, bVar);
            tVar2.aBf.setTag(com.baidu.tieba.q.tag_second, 0);
            tVar2.aBg.setTag(com.baidu.tieba.q.tag_second, 1);
            tVar2.aBh.setTag(com.baidu.tieba.q.tag_second, 2);
            tVar2.aBf.setOnClickListener(rVar);
            tVar2.aBg.setOnClickListener(rVar);
            tVar2.aBh.setOnClickListener(rVar);
            tVar2.aBd = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_forum);
            tVar2.aBe = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_common_conern);
            tVar2.aBi = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_forum_container);
            tVar2.aBj = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(com.baidu.tieba.q.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(com.baidu.tieba.q.tag_first);
        }
        tVar.aBa.aBq.setTag(bVar.Gf());
        view.setTag(com.baidu.tieba.q.tag_second, bVar.Gf());
        this.aAX.getLayoutMode().ab(z);
        this.aAX.getLayoutMode().j(view);
        a(tVar, bVar, z);
        ay.j(tVar.aBa.line, com.baidu.tieba.n.cp_bg_line_b);
        ay.i(view, com.baidu.tieba.p.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.Gf() != null) {
            a(tVar.aBa, bVar.Gf(), z);
            if (bVar.qT() > 0) {
                if (!TextUtils.isEmpty(bVar.qU())) {
                    tVar.aBb.setText(bVar.qU());
                }
                if (bVar.qT() < 3) {
                    tVar.aBc.setVisibility(8);
                } else {
                    tVar.aBc.setVisibility(0);
                    tVar.aBc.setText(com.baidu.tieba.t.add_friend_forum_count);
                }
            } else {
                tVar.aBj.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.qc().qg() && bVar.qX() != null && bVar.qX().size() > 0) {
                tVar.aBi.setVisibility(0);
                if (bVar.Gf().rd()) {
                    tVar.aBd.setText(com.baidu.tieba.t.add_friend_her_posts);
                } else {
                    tVar.aBd.setText(com.baidu.tieba.t.add_friend_his_posts);
                }
                switch (bVar.qX().size()) {
                    case 1:
                        tVar.aBf.setVisibility(0);
                        tVar.aBg.setVisibility(4);
                        tVar.aBh.setVisibility(4);
                        tVar.aBf.c(bVar.qX().get(0), 13, false);
                        return;
                    case 2:
                        tVar.aBf.setVisibility(0);
                        tVar.aBg.setVisibility(0);
                        tVar.aBh.setVisibility(4);
                        tVar.aBf.c(bVar.qX().get(0), 13, false);
                        tVar.aBg.c(bVar.qX().get(1), 13, false);
                        return;
                    default:
                        tVar.aBf.setVisibility(0);
                        tVar.aBg.setVisibility(0);
                        tVar.aBh.setVisibility(0);
                        tVar.aBf.c(bVar.qX().get(0), 13, false);
                        tVar.aBg.c(bVar.qX().get(1), 13, false);
                        tVar.aBh.c(bVar.qX().get(2), 13, false);
                        return;
                }
            }
            tVar.aBi.setVisibility(8);
        }
    }
}
