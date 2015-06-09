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
    private SearchFriendActivity aAY;
    private Drawable azC;
    private Drawable azD;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.aAY = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.n.d(this.aAY.getPageContext().getPageActivity(), com.baidu.tieba.o.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Gg() != null && aVar.Gh() != null) {
            this.Su.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Gg().isEmpty()) {
                if (fF(aVar.Gg().getTagName())) {
                    arrayList.add(aVar.Gg().getTagName());
                } else {
                    arrayList.add(this.aAY.getPageContext().getString(com.baidu.tieba.t.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Gg());
            }
            boolean z = false;
            for (com.baidu.tieba.addresslist.im.searchfriend.a.b bVar : aVar.Gh()) {
                if (bVar.Gg() != null) {
                    if (!bVar.Gg().isEmpty()) {
                        if (!z) {
                            if (fF(bVar.Gg().getTagName())) {
                                arrayList.add(bVar.Gg().getTagName());
                            } else {
                                arrayList.add(this.aAY.getPageContext().getString(com.baidu.tieba.t.add_friend_recommend_title_similar));
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

    public com.baidu.tieba.addresslist.im.searchfriend.a.a Gf() {
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
                    if (TextUtils.equals(bVar.Gg().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Gg().getUserId()))) {
                        bVar.Gg().ra();
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
            view = com.baidu.adp.lib.g.b.hr().inflate(this.aAY.getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_title, null);
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
            view = com.baidu.adp.lib.g.b.hr().inflate(this.aAY.getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.aBl = (HeadImageView) view.findViewById(com.baidu.tieba.q.recommend_new_head);
            uVar2.aBm = (UserIconBox) view.findViewById(com.baidu.tieba.q.recommend_new_crown);
            uVar2.aBn = (TextView) view.findViewById(com.baidu.tieba.q.recommend_new_user_name);
            uVar2.aBo = (TextView) view.findViewById(com.baidu.tieba.q.recommend_new_introduce);
            uVar2.aBp = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_distance);
            uVar2.aBq = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_time);
            uVar2.aBr = (TextView) view.findViewById(com.baidu.tieba.q.recommend_new_add_friend);
            uVar2.aBr.setOnClickListener(new o(this));
            uVar2.aBs = (ImageView) view.findViewById(com.baidu.tieba.q.recommend_new_user_sex);
            uVar2.line = view.findViewById(com.baidu.tieba.q.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.aBr.setTag(cVar);
        view.setTag(cVar);
        this.aAY.getLayoutMode().ab(z);
        this.aAY.getLayoutMode().j(view);
        a(uVar, cVar, z);
        ay.i(uVar.line, com.baidu.tieba.n.cp_bg_line_b);
        ay.i(view, com.baidu.tieba.p.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.n.qc().qe()) {
                uVar.aBl.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.rc())) {
                    uVar.aBl.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.aBl.setImageDrawable(null);
                    uVar.aBl.c(cVar.rc(), 12, false);
                }
            } else {
                uVar.aBl.setVisibility(8);
            }
            if (cVar.rf() != null && !TextUtils.isEmpty(cVar.rf().getUrl())) {
                uVar.aBm.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.rf());
                uVar.aBm.a(arrayList, 1, this.aAY.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_width), this.aAY.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_height), this.aAY.getResources().getDimensionPixelSize(com.baidu.tieba.o.small_icon_margin));
            } else {
                uVar.aBm.setVisibility(8);
            }
            uVar.aBn.setText(cVar.getName());
            if (StringUtils.isNull(cVar.re())) {
                uVar.aBo.setVisibility(8);
            } else {
                uVar.aBo.setVisibility(0);
                uVar.aBo.setText(cVar.re());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.aBp.setVisibility(8);
                uVar.aBq.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().xy() == 1) {
                uVar.aBp.setVisibility(0);
                uVar.aBp.setText(this.aAY.getPageContext().getString(com.baidu.tieba.t.contact_yinshen));
                uVar.aBp.setCompoundDrawables(null, null, null, null);
                uVar.aBq.setVisibility(8);
            } else if (cVar.getLbsInfo().xy() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.aBp.setVisibility(0);
                    uVar.aBq.setVisibility(0);
                    uVar.aBp.setText(cVar.getLbsInfo().getDistance());
                    uVar.aBq.setText(bb.n(cVar.getLbsInfo().getTime()));
                    this.azC = ay.getDrawable(com.baidu.tieba.p.icon_friend_pin);
                    this.azC.setBounds(0, 0, this.size, this.size);
                    uVar.aBp.setCompoundDrawables(this.azC, null, null, null);
                    this.azD = ay.getDrawable(com.baidu.tieba.p.icon_friend_time);
                    this.azD.setBounds(0, 0, this.size, this.size);
                    uVar.aBq.setCompoundDrawables(this.azD, null, null, null);
                } else {
                    uVar.aBp.setVisibility(8);
                    uVar.aBq.setVisibility(8);
                }
            } else {
                uVar.aBp.setVisibility(8);
                uVar.aBq.setVisibility(8);
            }
            if (cVar.rd()) {
                ay.c(uVar.aBs, com.baidu.tieba.p.icon_pop_qz_girl);
            } else {
                ay.c(uVar.aBs, com.baidu.tieba.p.icon_pop_qz_boy);
            }
            if (cVar.rb()) {
                uVar.aBr.setClickable(false);
                uVar.aBr.setBackgroundResource(com.baidu.tieba.n.transparent);
                uVar.aBr.setText(com.baidu.tieba.t.waiting);
                ay.b(uVar.aBr, com.baidu.tieba.n.cp_cont_d, 1);
                return;
            }
            uVar.aBr.setClickable(true);
            uVar.aBr.setText(com.baidu.tieba.t.add);
        }
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.aAY.getPageContext().getPageActivity(), com.baidu.tieba.r.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.aBb = new u(this, null);
            View findViewById = view.findViewById(com.baidu.tieba.q.recommend_similar_top);
            tVar2.aBb.aBl = (HeadImageView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_head);
            tVar2.aBb.aBm = (UserIconBox) findViewById.findViewById(com.baidu.tieba.q.recommend_new_crown);
            tVar2.aBb.aBn = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_user_name);
            tVar2.aBb.aBo = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_introduce);
            tVar2.aBb.aBp = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_distance);
            tVar2.aBb.aBq = (TextView) view.findViewById(com.baidu.tieba.q.detail_info_time);
            tVar2.aBb.line = findViewById.findViewById(com.baidu.tieba.q.recommend_new_line);
            tVar2.aBb.aBr = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_add_friend);
            tVar2.aBb.aBr.setOnClickListener(new q(this, bVar));
            tVar2.aBb.aBs = (ImageView) view.findViewById(com.baidu.tieba.q.recommend_new_user_sex);
            tVar2.aBb.line = view.findViewById(com.baidu.tieba.q.recommend_new_line);
            tVar2.aBc = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_names);
            tVar2.aBd = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_desc);
            tVar2.aBg = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_one);
            tVar2.aBh = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_two);
            tVar2.aBi = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.aBg.setTag(com.baidu.tieba.q.tag_first, bVar);
            tVar2.aBh.setTag(com.baidu.tieba.q.tag_first, bVar);
            tVar2.aBi.setTag(com.baidu.tieba.q.tag_first, bVar);
            tVar2.aBg.setTag(com.baidu.tieba.q.tag_second, 0);
            tVar2.aBh.setTag(com.baidu.tieba.q.tag_second, 1);
            tVar2.aBi.setTag(com.baidu.tieba.q.tag_second, 2);
            tVar2.aBg.setOnClickListener(rVar);
            tVar2.aBh.setOnClickListener(rVar);
            tVar2.aBi.setOnClickListener(rVar);
            tVar2.aBe = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_forum);
            tVar2.aBf = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_common_conern);
            tVar2.aBj = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_forum_container);
            tVar2.aBk = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(com.baidu.tieba.q.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(com.baidu.tieba.q.tag_first);
        }
        tVar.aBb.aBr.setTag(bVar.Gg());
        view.setTag(com.baidu.tieba.q.tag_second, bVar.Gg());
        this.aAY.getLayoutMode().ab(z);
        this.aAY.getLayoutMode().j(view);
        a(tVar, bVar, z);
        ay.j(tVar.aBb.line, com.baidu.tieba.n.cp_bg_line_b);
        ay.i(view, com.baidu.tieba.p.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.Gg() != null) {
            a(tVar.aBb, bVar.Gg(), z);
            if (bVar.qT() > 0) {
                if (!TextUtils.isEmpty(bVar.qU())) {
                    tVar.aBc.setText(bVar.qU());
                }
                if (bVar.qT() < 3) {
                    tVar.aBd.setVisibility(8);
                } else {
                    tVar.aBd.setVisibility(0);
                    tVar.aBd.setText(com.baidu.tieba.t.add_friend_forum_count);
                }
            } else {
                tVar.aBk.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.qc().qg() && bVar.qX() != null && bVar.qX().size() > 0) {
                tVar.aBj.setVisibility(0);
                if (bVar.Gg().rd()) {
                    tVar.aBe.setText(com.baidu.tieba.t.add_friend_her_posts);
                } else {
                    tVar.aBe.setText(com.baidu.tieba.t.add_friend_his_posts);
                }
                switch (bVar.qX().size()) {
                    case 1:
                        tVar.aBg.setVisibility(0);
                        tVar.aBh.setVisibility(4);
                        tVar.aBi.setVisibility(4);
                        tVar.aBg.c(bVar.qX().get(0), 13, false);
                        return;
                    case 2:
                        tVar.aBg.setVisibility(0);
                        tVar.aBh.setVisibility(0);
                        tVar.aBi.setVisibility(4);
                        tVar.aBg.c(bVar.qX().get(0), 13, false);
                        tVar.aBh.c(bVar.qX().get(1), 13, false);
                        return;
                    default:
                        tVar.aBg.setVisibility(0);
                        tVar.aBh.setVisibility(0);
                        tVar.aBi.setVisibility(0);
                        tVar.aBg.c(bVar.qX().get(0), 13, false);
                        tVar.aBh.c(bVar.qX().get(1), 13, false);
                        tVar.aBi.c(bVar.qX().get(2), 13, false);
                        return;
                }
            }
            tVar.aBj.setVisibility(8);
        }
    }
}
