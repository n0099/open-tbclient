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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private Drawable ahf;
    private Drawable ahg;
    private ArrayList<Object> bii = new ArrayList<>();
    private SearchFriendActivity bij;
    private int size;

    public l(SearchFriendActivity searchFriendActivity) {
        this.bij = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.m.c(this.bij, com.baidu.tieba.t.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.RA() != null && aVar.RB() != null) {
            this.bii.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.RA().isEmpty()) {
                if (gD(aVar.RA().getTagName())) {
                    arrayList.add(aVar.RA().getTagName());
                } else {
                    arrayList.add(this.bij.getString(y.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.RA());
            }
            boolean z = false;
            for (com.baidu.tieba.im.searchfriend.a.b bVar : aVar.RB()) {
                if (bVar.RA() != null) {
                    if (!bVar.RA().isEmpty()) {
                        if (!z) {
                            if (gD(bVar.RA().getTagName())) {
                                arrayList.add(bVar.RA().getTagName());
                            } else {
                                arrayList.add(this.bij.getString(y.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.bii.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean gD(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.im.searchfriend.a.a Rz() {
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        Iterator<Object> it = this.bii.iterator();
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

    public void ae(String str, String str2) {
        if (this.bii != null && this.bii.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.bii.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.im.searchfriend.a.c) {
                    com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.kq();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.im.searchfriend.a.b) {
                    com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.RA().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.RA().getUserId()))) {
                        bVar.RA().kq();
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
        Object obj = this.bii.get(i);
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
        if (this.bii == null) {
            return 0;
        }
        return this.bii.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bii == null) {
            return null;
        }
        return this.bii.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bij, w.add_friend_recommend_title, null);
            t tVar2 = new t(this, null);
            tVar2.QK = (TextView) view.findViewById(v.add_friend_recommend_title);
            tVar2.bip = view.findViewById(v.add_friend_recommend_line);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        tVar.QK.setText(str);
        aw.b(tVar.QK, com.baidu.tieba.s.cp_cont_c, 1);
        aw.h(tVar.bip, com.baidu.tieba.s.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        s sVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof s)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bij, w.add_friend_recommend_new, null);
            s sVar2 = new s(this, null);
            sVar2.aEo = (HeadImageView) view.findViewById(v.recommend_new_head);
            sVar2.aEp = (UserIconBox) view.findViewById(v.recommend_new_crown);
            sVar2.aEq = (TextView) view.findViewById(v.recommend_new_user_name);
            sVar2.aEr = (TextView) view.findViewById(v.recommend_new_introduce);
            sVar2.bin = (TextView) view.findViewById(v.detail_info_distance);
            sVar2.bio = (TextView) view.findViewById(v.detail_info_time);
            sVar2.aEs = (TextView) view.findViewById(v.recommend_new_add_friend);
            sVar2.aEs.setOnClickListener(new m(this));
            sVar2.aEt = (ImageView) view.findViewById(v.recommend_new_user_sex);
            sVar2.bip = view.findViewById(v.recommend_new_line);
            view.setOnClickListener(new n(this));
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        sVar.aEs.setTag(cVar);
        view.setTag(cVar);
        this.bij.getLayoutMode().L(z);
        this.bij.getLayoutMode().h(view);
        a(sVar, cVar, z);
        aw.h(sVar.bip, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(view, u.recommend_friend_item_bg);
        return view;
    }

    private void a(s sVar, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && sVar != null) {
            if (com.baidu.tbadk.core.l.js().ju()) {
                sVar.aEo.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.ks())) {
                    sVar.aEo.setUserId(String.valueOf(cVar.getUserId()));
                    sVar.aEo.setImageDrawable(null);
                    sVar.aEo.c(cVar.ks(), 12, false);
                }
            } else {
                sVar.aEo.setVisibility(8);
            }
            if (cVar.kv() != null && !TextUtils.isEmpty(cVar.kv().getUrl())) {
                sVar.aEp.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.kv());
                sVar.aEp.a(arrayList, 1, this.bij.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.bij.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.bij.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                sVar.aEp.setVisibility(8);
            }
            sVar.aEq.setText(cVar.getName());
            if (StringUtils.isNull(cVar.ku())) {
                sVar.aEr.setVisibility(8);
            } else {
                sVar.aEr.setVisibility(0);
                sVar.aEr.setText(cVar.ku());
            }
            if (cVar.getLbsInfo() == null) {
                sVar.bin.setVisibility(8);
                sVar.bio.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().pD() == 1) {
                sVar.bin.setVisibility(0);
                sVar.bin.setText(this.bij.getString(y.contact_yinshen));
                sVar.bin.setCompoundDrawables(null, null, null, null);
                sVar.bio.setVisibility(8);
            } else if (cVar.getLbsInfo().pD() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    sVar.bin.setVisibility(0);
                    sVar.bio.setVisibility(0);
                    sVar.bin.setText(cVar.getLbsInfo().getDistance());
                    sVar.bio.setText(az.i(cVar.getLbsInfo().getTime()));
                    this.ahf = aw.getDrawable(u.icon_friend_pin);
                    this.ahf.setBounds(0, 0, this.size, this.size);
                    sVar.bin.setCompoundDrawables(this.ahf, null, null, null);
                    this.ahg = aw.getDrawable(u.icon_friend_time);
                    this.ahg.setBounds(0, 0, this.size, this.size);
                    sVar.bio.setCompoundDrawables(this.ahg, null, null, null);
                } else {
                    sVar.bin.setVisibility(8);
                    sVar.bio.setVisibility(8);
                }
            } else {
                sVar.bin.setVisibility(8);
                sVar.bio.setVisibility(8);
            }
            if (cVar.kt()) {
                aw.c(sVar.aEt, u.icon_pop_qz_girl);
            } else {
                aw.c(sVar.aEt, u.icon_pop_qz_boy);
            }
            if (cVar.kr()) {
                sVar.aEs.setClickable(false);
                sVar.aEs.setBackgroundResource(com.baidu.tieba.s.transparent);
                sVar.aEs.setText(y.waiting);
                aw.b(sVar.aEs, com.baidu.tieba.s.cp_cont_d, 1);
                return;
            }
            sVar.aEs.setClickable(true);
            sVar.aEs.setText(y.add);
        }
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        r rVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof s)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bij, w.add_friend_recommend_similar, null);
            r rVar2 = new r(this, null);
            rVar2.bim = new s(this, null);
            View findViewById = view.findViewById(v.recommend_similar_top);
            rVar2.bim.aEo = (HeadImageView) findViewById.findViewById(v.recommend_new_head);
            rVar2.bim.aEp = (UserIconBox) findViewById.findViewById(v.recommend_new_crown);
            rVar2.bim.aEq = (TextView) findViewById.findViewById(v.recommend_new_user_name);
            rVar2.bim.aEr = (TextView) findViewById.findViewById(v.recommend_new_introduce);
            rVar2.bim.bin = (TextView) view.findViewById(v.detail_info_distance);
            rVar2.bim.bio = (TextView) view.findViewById(v.detail_info_time);
            rVar2.bim.bip = findViewById.findViewById(v.recommend_new_line);
            rVar2.bim.aEs = (TextView) findViewById.findViewById(v.recommend_new_add_friend);
            rVar2.bim.aEs.setOnClickListener(new o(this, bVar));
            rVar2.bim.aEt = (ImageView) view.findViewById(v.recommend_new_user_sex);
            rVar2.bim.bip = view.findViewById(v.recommend_new_line);
            rVar2.aEe = (TextView) view.findViewById(v.recommend_similar_bar_names);
            rVar2.aEf = (TextView) view.findViewById(v.recommend_similar_bar_desc);
            rVar2.aEi = (TbImageView) view.findViewById(v.recommend_similar_pic_one);
            rVar2.aEj = (TbImageView) view.findViewById(v.recommend_similar_pic_two);
            rVar2.aEk = (TbImageView) view.findViewById(v.recommend_similar_pic_thr);
            p pVar = new p(this);
            rVar2.aEi.setTag(v.tag_first, bVar);
            rVar2.aEj.setTag(v.tag_first, bVar);
            rVar2.aEk.setTag(v.tag_first, bVar);
            rVar2.aEi.setTag(v.tag_second, 0);
            rVar2.aEj.setTag(v.tag_second, 1);
            rVar2.aEk.setTag(v.tag_second, 2);
            rVar2.aEi.setOnClickListener(pVar);
            rVar2.aEj.setOnClickListener(pVar);
            rVar2.aEk.setOnClickListener(pVar);
            rVar2.aEg = (TextView) view.findViewById(v.recommend_similar_forum);
            rVar2.aEh = (TextView) view.findViewById(v.recommend_similar_common_conern);
            rVar2.aEl = (LinearLayout) view.findViewById(v.recommend_similar_forum_container);
            rVar2.aEm = (LinearLayout) view.findViewById(v.recommend_similar_commom_conern_container);
            view.setOnClickListener(new q(this));
            view.setTag(v.tag_first, rVar2);
            rVar = rVar2;
        } else {
            rVar = (r) view.getTag(v.tag_first);
        }
        rVar.bim.aEs.setTag(bVar.RA());
        view.setTag(v.tag_second, bVar.RA());
        this.bij.getLayoutMode().L(z);
        this.bij.getLayoutMode().h(view);
        a(rVar, bVar, z);
        aw.i(rVar.bim.bip, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(view, u.recommend_friend_item_bg);
        return view;
    }

    private void a(r rVar, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        if (rVar != null && bVar != null && bVar.RA() != null) {
            a(rVar.bim, bVar.RA(), z);
            if (bVar.kj() > 0) {
                if (!TextUtils.isEmpty(bVar.kk())) {
                    rVar.aEe.setText(bVar.kk());
                }
                if (bVar.kj() < 3) {
                    rVar.aEf.setVisibility(8);
                } else {
                    rVar.aEf.setVisibility(0);
                    rVar.aEf.setText(y.add_friend_forum_count);
                }
            } else {
                rVar.aEm.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.js().jw() && bVar.kn() != null && bVar.kn().size() > 0) {
                rVar.aEl.setVisibility(0);
                if (bVar.RA().kt()) {
                    rVar.aEg.setText(y.add_friend_her_posts);
                } else {
                    rVar.aEg.setText(y.add_friend_his_posts);
                }
                switch (bVar.kn().size()) {
                    case 1:
                        rVar.aEi.setVisibility(0);
                        rVar.aEj.setVisibility(4);
                        rVar.aEk.setVisibility(4);
                        rVar.aEi.c(bVar.kn().get(0), 10, false);
                        return;
                    case 2:
                        rVar.aEi.setVisibility(0);
                        rVar.aEj.setVisibility(0);
                        rVar.aEk.setVisibility(4);
                        rVar.aEi.c(bVar.kn().get(0), 10, false);
                        rVar.aEj.c(bVar.kn().get(1), 10, false);
                        return;
                    default:
                        rVar.aEi.setVisibility(0);
                        rVar.aEj.setVisibility(0);
                        rVar.aEk.setVisibility(0);
                        rVar.aEi.c(bVar.kn().get(0), 10, false);
                        rVar.aEj.c(bVar.kn().get(1), 10, false);
                        rVar.aEk.c(bVar.kn().get(2), 10, false);
                        return;
                }
            }
            rVar.aEl.setVisibility(8);
        }
    }
}
