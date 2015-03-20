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
    private ArrayList<Object> RK = new ArrayList<>();
    private Drawable axH;
    private Drawable axI;
    private SearchFriendActivity aze;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.aze = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.n.d(this.aze.getPageContext().getPageActivity(), com.baidu.tieba.t.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Fg() != null && aVar.Fh() != null) {
            this.RK.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Fg().isEmpty()) {
                if (fh(aVar.Fg().getTagName())) {
                    arrayList.add(aVar.Fg().getTagName());
                } else {
                    arrayList.add(this.aze.getPageContext().getString(y.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Fg());
            }
            boolean z = false;
            for (com.baidu.tieba.addresslist.im.searchfriend.a.b bVar : aVar.Fh()) {
                if (bVar.Fg() != null) {
                    if (!bVar.Fg().isEmpty()) {
                        if (!z) {
                            if (fh(bVar.Fg().getTagName())) {
                                arrayList.add(bVar.Fg().getTagName());
                            } else {
                                arrayList.add(this.aze.getPageContext().getString(y.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.RK.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean fh(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.addresslist.im.searchfriend.a.a Ff() {
        com.baidu.tieba.addresslist.im.searchfriend.a.a aVar = new com.baidu.tieba.addresslist.im.searchfriend.a.a();
        Iterator<Object> it = this.RK.iterator();
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
        if (this.RK != null && this.RK.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.RK.iterator();
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
                    if (TextUtils.equals(bVar.Fg().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Fg().getUserId()))) {
                        bVar.Fg().qu();
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
        Object obj = this.RK.get(i);
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
        if (this.RK == null) {
            return 0;
        }
        return this.RK.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.RK == null) {
            return null;
        }
        return this.RK.get(i);
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
            view = com.baidu.adp.lib.g.b.hH().inflate(this.aze.getPageContext().getPageActivity(), w.add_friend_recommend_title, null);
            v vVar2 = new v(this, null);
            vVar2.ahr = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_recommend_title);
            vVar2.line = view.findViewById(com.baidu.tieba.v.add_friend_recommend_line);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.ahr.setText(str);
        ba.b(vVar.ahr, com.baidu.tieba.s.cp_cont_c, 1);
        ba.i(vVar.line, com.baidu.tieba.s.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.aze.getPageContext().getPageActivity(), w.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.azr = (HeadImageView) view.findViewById(com.baidu.tieba.v.recommend_new_head);
            uVar2.azs = (UserIconBox) view.findViewById(com.baidu.tieba.v.recommend_new_crown);
            uVar2.azt = (TextView) view.findViewById(com.baidu.tieba.v.recommend_new_user_name);
            uVar2.azu = (TextView) view.findViewById(com.baidu.tieba.v.recommend_new_introduce);
            uVar2.azv = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_distance);
            uVar2.azw = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_time);
            uVar2.azx = (TextView) view.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
            uVar2.azx.setOnClickListener(new o(this));
            uVar2.azy = (ImageView) view.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
            uVar2.line = view.findViewById(com.baidu.tieba.v.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.azx.setTag(cVar);
        view.setTag(cVar);
        this.aze.getLayoutMode().X(z);
        this.aze.getLayoutMode().h(view);
        a(uVar, cVar, z);
        ba.i(uVar.line, com.baidu.tieba.s.cp_bg_line_b);
        ba.i(view, com.baidu.tieba.u.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.n.px().pz()) {
                uVar.azr.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.qw())) {
                    uVar.azr.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.azr.setImageDrawable(null);
                    uVar.azr.c(cVar.qw(), 12, false);
                }
            } else {
                uVar.azr.setVisibility(8);
            }
            if (cVar.qz() != null && !TextUtils.isEmpty(cVar.qz().getUrl())) {
                uVar.azs.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.qz());
                uVar.azs.a(arrayList, 1, this.aze.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.aze.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.aze.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                uVar.azs.setVisibility(8);
            }
            uVar.azt.setText(cVar.getName());
            if (StringUtils.isNull(cVar.qy())) {
                uVar.azu.setVisibility(8);
            } else {
                uVar.azu.setVisibility(0);
                uVar.azu.setText(cVar.qy());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.azv.setVisibility(8);
                uVar.azw.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().wE() == 1) {
                uVar.azv.setVisibility(0);
                uVar.azv.setText(this.aze.getPageContext().getString(y.contact_yinshen));
                uVar.azv.setCompoundDrawables(null, null, null, null);
                uVar.azw.setVisibility(8);
            } else if (cVar.getLbsInfo().wE() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.azv.setVisibility(0);
                    uVar.azw.setVisibility(0);
                    uVar.azv.setText(cVar.getLbsInfo().getDistance());
                    uVar.azw.setText(bd.m(cVar.getLbsInfo().getTime()));
                    this.axH = ba.getDrawable(com.baidu.tieba.u.icon_friend_pin);
                    this.axH.setBounds(0, 0, this.size, this.size);
                    uVar.azv.setCompoundDrawables(this.axH, null, null, null);
                    this.axI = ba.getDrawable(com.baidu.tieba.u.icon_friend_time);
                    this.axI.setBounds(0, 0, this.size, this.size);
                    uVar.azw.setCompoundDrawables(this.axI, null, null, null);
                } else {
                    uVar.azv.setVisibility(8);
                    uVar.azw.setVisibility(8);
                }
            } else {
                uVar.azv.setVisibility(8);
                uVar.azw.setVisibility(8);
            }
            if (cVar.qx()) {
                ba.c(uVar.azy, com.baidu.tieba.u.icon_pop_qz_girl);
            } else {
                ba.c(uVar.azy, com.baidu.tieba.u.icon_pop_qz_boy);
            }
            if (cVar.qv()) {
                uVar.azx.setClickable(false);
                uVar.azx.setBackgroundResource(com.baidu.tieba.s.transparent);
                uVar.azx.setText(y.waiting);
                ba.b(uVar.azx, com.baidu.tieba.s.cp_cont_d, 1);
                return;
            }
            uVar.azx.setClickable(true);
            uVar.azx.setText(y.add);
        }
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.aze.getPageContext().getPageActivity(), w.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.azh = new u(this, null);
            View findViewById = view.findViewById(com.baidu.tieba.v.recommend_similar_top);
            tVar2.azh.azr = (HeadImageView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_head);
            tVar2.azh.azs = (UserIconBox) findViewById.findViewById(com.baidu.tieba.v.recommend_new_crown);
            tVar2.azh.azt = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_user_name);
            tVar2.azh.azu = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_introduce);
            tVar2.azh.azv = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_distance);
            tVar2.azh.azw = (TextView) view.findViewById(com.baidu.tieba.v.detail_info_time);
            tVar2.azh.line = findViewById.findViewById(com.baidu.tieba.v.recommend_new_line);
            tVar2.azh.azx = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
            tVar2.azh.azx.setOnClickListener(new q(this, bVar));
            tVar2.azh.azy = (ImageView) view.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
            tVar2.azh.line = view.findViewById(com.baidu.tieba.v.recommend_new_line);
            tVar2.azi = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_names);
            tVar2.azj = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_desc);
            tVar2.azm = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_one);
            tVar2.azn = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_two);
            tVar2.azo = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.azm.setTag(com.baidu.tieba.v.tag_first, bVar);
            tVar2.azn.setTag(com.baidu.tieba.v.tag_first, bVar);
            tVar2.azo.setTag(com.baidu.tieba.v.tag_first, bVar);
            tVar2.azm.setTag(com.baidu.tieba.v.tag_second, 0);
            tVar2.azn.setTag(com.baidu.tieba.v.tag_second, 1);
            tVar2.azo.setTag(com.baidu.tieba.v.tag_second, 2);
            tVar2.azm.setOnClickListener(rVar);
            tVar2.azn.setOnClickListener(rVar);
            tVar2.azo.setOnClickListener(rVar);
            tVar2.azk = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_forum);
            tVar2.azl = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_common_conern);
            tVar2.azp = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_forum_container);
            tVar2.azq = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(com.baidu.tieba.v.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(com.baidu.tieba.v.tag_first);
        }
        tVar.azh.azx.setTag(bVar.Fg());
        view.setTag(com.baidu.tieba.v.tag_second, bVar.Fg());
        this.aze.getLayoutMode().X(z);
        this.aze.getLayoutMode().h(view);
        a(tVar, bVar, z);
        ba.j(tVar.azh.line, com.baidu.tieba.s.cp_bg_line_b);
        ba.i(view, com.baidu.tieba.u.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.Fg() != null) {
            a(tVar.azh, bVar.Fg(), z);
            if (bVar.qn() > 0) {
                if (!TextUtils.isEmpty(bVar.qo())) {
                    tVar.azi.setText(bVar.qo());
                }
                if (bVar.qn() < 3) {
                    tVar.azj.setVisibility(8);
                } else {
                    tVar.azj.setVisibility(0);
                    tVar.azj.setText(y.add_friend_forum_count);
                }
            } else {
                tVar.azq.setVisibility(8);
            }
            if (com.baidu.tbadk.core.n.px().pB() && bVar.qr() != null && bVar.qr().size() > 0) {
                tVar.azp.setVisibility(0);
                if (bVar.Fg().qx()) {
                    tVar.azk.setText(y.add_friend_her_posts);
                } else {
                    tVar.azk.setText(y.add_friend_his_posts);
                }
                switch (bVar.qr().size()) {
                    case 1:
                        tVar.azm.setVisibility(0);
                        tVar.azn.setVisibility(4);
                        tVar.azo.setVisibility(4);
                        tVar.azm.c(bVar.qr().get(0), 13, false);
                        return;
                    case 2:
                        tVar.azm.setVisibility(0);
                        tVar.azn.setVisibility(0);
                        tVar.azo.setVisibility(4);
                        tVar.azm.c(bVar.qr().get(0), 13, false);
                        tVar.azn.c(bVar.qr().get(1), 13, false);
                        return;
                    default:
                        tVar.azm.setVisibility(0);
                        tVar.azn.setVisibility(0);
                        tVar.azo.setVisibility(0);
                        tVar.azm.c(bVar.qr().get(0), 13, false);
                        tVar.azn.c(bVar.qr().get(1), 13, false);
                        tVar.azo.c(bVar.qr().get(2), 13, false);
                        return;
                }
            }
            tVar.azp.setVisibility(8);
        }
    }
}
