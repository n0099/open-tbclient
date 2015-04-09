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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private ArrayList<Object> RM = new ArrayList<>();
    private Drawable axP;
    private Drawable axQ;
    private SearchFriendActivity azm;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.azm = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.n.d(this.azm.getPageContext().getPageActivity(), com.baidu.tieba.t.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Fm() != null && aVar.Fn() != null) {
            this.RM.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Fm().isEmpty()) {
                if (fk(aVar.Fm().getTagName())) {
                    arrayList.add(aVar.Fm().getTagName());
                } else {
                    arrayList.add(this.azm.getPageContext().getString(y.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Fm());
            }
            boolean z = false;
            for (com.baidu.tieba.addresslist.im.searchfriend.a.b bVar : aVar.Fn()) {
                if (bVar.Fm() != null) {
                    if (!bVar.Fm().isEmpty()) {
                        if (!z) {
                            if (fk(bVar.Fm().getTagName())) {
                                arrayList.add(bVar.Fm().getTagName());
                            } else {
                                arrayList.add(this.azm.getPageContext().getString(y.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.RM.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean fk(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.addresslist.im.searchfriend.a.a Fl() {
        com.baidu.tieba.addresslist.im.searchfriend.a.a aVar = new com.baidu.tieba.addresslist.im.searchfriend.a.a();
        Iterator<Object> it = this.RM.iterator();
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

    public void al(String str, String str2) {
        if (this.RM != null && this.RM.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.RM.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
                    com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.qu();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.b) {
                    com.baidu.tieba.addresslist.im.searchfriend.a.b bVar = (com.baidu.tieba.addresslist.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.Fm().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Fm().getUserId()))) {
                        bVar.Fm().qu();
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
        Object obj = this.RM.get(i);
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
        if (this.RM == null) {
            return 0;
        }
        return this.RM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.RM == null) {
            return null;
        }
        return this.RM.get(i);
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
            view = com.baidu.adp.lib.g.b.hH().inflate(this.azm.getPageContext().getPageActivity(), w.add_friend_recommend_title, null);
            v vVar2 = new v(this, null);
            vVar2.ahz = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_recommend_title);
            vVar2.line = view.findViewById(com.baidu.tieba.v.add_friend_recommend_line);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.ahz.setText(str);
        ba.b(vVar.ahz, com.baidu.tieba.s.cp_cont_c, 1);
        ba.i(vVar.line, com.baidu.tieba.s.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.azm.getPageContext().getPageActivity(), w.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.azz = (HeadImageView) view.findViewById(com.baidu.tieba.v.recommend_new_head);
            uVar2.azA = (UserIconBox) view.findViewById(com.baidu.tieba.v.recommend_new_crown);
            uVar2.azB = (TextView) view.findViewById(com.baidu.tieba.v.recommend_new_user_name);
            uVar2.azC = (TextView) view.findViewById(com.baidu.tieba.v.recommend_new_introduce);
            uVar2.azD = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_distance);
            uVar2.azE = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_time);
            uVar2.azF = (TextView) view.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
            uVar2.azF.setOnClickListener(new o(this));
            uVar2.azG = (ImageView) view.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
            uVar2.line = view.findViewById(com.baidu.tieba.v.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.azF.setTag(cVar);
        view.setTag(cVar);
        this.azm.getLayoutMode().X(z);
        this.azm.getLayoutMode().h(view);
        a(uVar, cVar, z);
        ba.i(uVar.line, com.baidu.tieba.s.cp_bg_line_b);
        ba.i(view, com.baidu.tieba.u.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.n.px().pz()) {
                uVar.azz.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.qw())) {
                    uVar.azz.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.azz.setImageDrawable(null);
                    uVar.azz.c(cVar.qw(), 12, false);
                }
            } else {
                uVar.azz.setVisibility(8);
            }
            if (cVar.qz() != null && !TextUtils.isEmpty(cVar.qz().getUrl())) {
                uVar.azA.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.qz());
                uVar.azA.a(arrayList, 1, this.azm.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.azm.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.azm.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                uVar.azA.setVisibility(8);
            }
            uVar.azB.setText(cVar.getName());
            if (StringUtils.isNull(cVar.qy())) {
                uVar.azC.setVisibility(8);
            } else {
                uVar.azC.setVisibility(0);
                uVar.azC.setText(cVar.qy());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.azD.setVisibility(8);
                uVar.azE.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().wK() == 1) {
                uVar.azD.setVisibility(0);
                uVar.azD.setText(this.azm.getPageContext().getString(y.contact_yinshen));
                uVar.azD.setCompoundDrawables(null, null, null, null);
                uVar.azE.setVisibility(8);
            } else if (cVar.getLbsInfo().wK() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.azD.setVisibility(0);
                    uVar.azE.setVisibility(0);
                    uVar.azD.setText(cVar.getLbsInfo().getDistance());
                    uVar.azE.setText(bd.m(cVar.getLbsInfo().getTime()));
                    this.axP = ba.getDrawable(com.baidu.tieba.u.icon_friend_pin);
                    this.axP.setBounds(0, 0, this.size, this.size);
                    uVar.azD.setCompoundDrawables(this.axP, null, null, null);
                    this.axQ = ba.getDrawable(com.baidu.tieba.u.icon_friend_time);
                    this.axQ.setBounds(0, 0, this.size, this.size);
                    uVar.azE.setCompoundDrawables(this.axQ, null, null, null);
                } else {
                    uVar.azD.setVisibility(8);
                    uVar.azE.setVisibility(8);
                }
            } else {
                uVar.azD.setVisibility(8);
                uVar.azE.setVisibility(8);
            }
            if (cVar.qx()) {
                ba.c(uVar.azG, com.baidu.tieba.u.icon_pop_qz_girl);
            } else {
                ba.c(uVar.azG, com.baidu.tieba.u.icon_pop_qz_boy);
            }
            if (cVar.qv()) {
                uVar.azF.setClickable(false);
                uVar.azF.setBackgroundResource(com.baidu.tieba.s.transparent);
                uVar.azF.setText(y.waiting);
                ba.b(uVar.azF, com.baidu.tieba.s.cp_cont_d, 1);
                return;
            }
            uVar.azF.setClickable(true);
            uVar.azF.setText(y.add);
        }
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.azm.getPageContext().getPageActivity(), w.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.azp = new u(this, null);
            View findViewById = view.findViewById(com.baidu.tieba.v.recommend_similar_top);
            tVar2.azp.azz = (HeadImageView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_head);
            tVar2.azp.azA = (UserIconBox) findViewById.findViewById(com.baidu.tieba.v.recommend_new_crown);
            tVar2.azp.azB = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_user_name);
            tVar2.azp.azC = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_introduce);
            tVar2.azp.azD = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_distance);
            tVar2.azp.azE = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_time);
            tVar2.azp.line = findViewById.findViewById(com.baidu.tieba.v.recommend_new_line);
            tVar2.azp.azF = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
            tVar2.azp.azF.setOnClickListener(new q(this, bVar));
            tVar2.azp.azG = (ImageView) view.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
            tVar2.azp.line = view.findViewById(com.baidu.tieba.v.recommend_new_line);
            tVar2.azq = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_names);
            tVar2.azr = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_desc);
            tVar2.azu = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_one);
            tVar2.azv = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_two);
            tVar2.azw = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.azu.setTag(com.baidu.tieba.v.tag_first, bVar);
            tVar2.azv.setTag(com.baidu.tieba.v.tag_first, bVar);
            tVar2.azw.setTag(com.baidu.tieba.v.tag_first, bVar);
            tVar2.azu.setTag(com.baidu.tieba.v.tag_second, 0);
            tVar2.azv.setTag(com.baidu.tieba.v.tag_second, 1);
            tVar2.azw.setTag(com.baidu.tieba.v.tag_second, 2);
            tVar2.azu.setOnClickListener(rVar);
            tVar2.azv.setOnClickListener(rVar);
            tVar2.azw.setOnClickListener(rVar);
            tVar2.azs = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_forum);
            tVar2.azt = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_common_conern);
            tVar2.azx = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_forum_container);
            tVar2.azy = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(com.baidu.tieba.v.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(com.baidu.tieba.v.tag_first);
        }
        tVar.azp.azF.setTag(bVar.Fm());
        view.setTag(com.baidu.tieba.v.tag_second, bVar.Fm());
        this.azm.getLayoutMode().X(z);
        this.azm.getLayoutMode().h(view);
        a(tVar, bVar, z);
        ba.j(tVar.azp.line, com.baidu.tieba.s.cp_bg_line_b);
        ba.i(view, com.baidu.tieba.u.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.Fm() != null) {
            a(tVar.azp, bVar.Fm(), z);
            if (bVar.qn() > 0) {
                if (!TextUtils.isEmpty(bVar.qo())) {
                    tVar.azq.setText(bVar.qo());
                }
                if (bVar.qn() < 3) {
                    tVar.azr.setVisibility(8);
                } else {
                    tVar.azr.setVisibility(0);
                    tVar.azr.setText(y.add_friend_forum_count);
                }
            } else {
                tVar.azy.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.px().pB() && bVar.qr() != null && bVar.qr().size() > 0) {
                tVar.azx.setVisibility(0);
                if (bVar.Fm().qx()) {
                    tVar.azs.setText(y.add_friend_her_posts);
                } else {
                    tVar.azs.setText(y.add_friend_his_posts);
                }
                switch (bVar.qr().size()) {
                    case 1:
                        tVar.azu.setVisibility(0);
                        tVar.azv.setVisibility(4);
                        tVar.azw.setVisibility(4);
                        tVar.azu.c(bVar.qr().get(0), 13, false);
                        return;
                    case 2:
                        tVar.azu.setVisibility(0);
                        tVar.azv.setVisibility(0);
                        tVar.azw.setVisibility(4);
                        tVar.azu.c(bVar.qr().get(0), 13, false);
                        tVar.azv.c(bVar.qr().get(1), 13, false);
                        return;
                    default:
                        tVar.azu.setVisibility(0);
                        tVar.azv.setVisibility(0);
                        tVar.azw.setVisibility(0);
                        tVar.azu.c(bVar.qr().get(0), 13, false);
                        tVar.azv.c(bVar.qr().get(1), 13, false);
                        tVar.azw.c(bVar.qr().get(2), 13, false);
                        return;
                }
            }
            tVar.azx.setVisibility(8);
        }
    }
}
