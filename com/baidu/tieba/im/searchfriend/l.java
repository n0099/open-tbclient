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
import com.baidu.tbadk.core.util.ay;
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
    private Drawable agW;
    private Drawable agX;
    private ArrayList<Object> bhS = new ArrayList<>();
    private SearchFriendActivity bhT;
    private int size;

    public l(SearchFriendActivity searchFriendActivity) {
        this.bhT = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.m.c(this.bhT, com.baidu.tieba.t.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.Rx() != null && aVar.Ry() != null) {
            this.bhS.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.Rx().isEmpty()) {
                if (gD(aVar.Rx().getTagName())) {
                    arrayList.add(aVar.Rx().getTagName());
                } else {
                    arrayList.add(this.bhT.getString(y.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.Rx());
            }
            boolean z = false;
            for (com.baidu.tieba.im.searchfriend.a.b bVar : aVar.Ry()) {
                if (bVar.Rx() != null) {
                    if (!bVar.Rx().isEmpty()) {
                        if (!z) {
                            if (gD(bVar.Rx().getTagName())) {
                                arrayList.add(bVar.Rx().getTagName());
                            } else {
                                arrayList.add(this.bhT.getString(y.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.bhS.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean gD(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.im.searchfriend.a.a Rw() {
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        Iterator<Object> it = this.bhS.iterator();
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
        if (this.bhS != null && this.bhS.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.bhS.iterator();
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
                    if (TextUtils.equals(bVar.Rx().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.Rx().getUserId()))) {
                        bVar.Rx().kq();
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
        Object obj = this.bhS.get(i);
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
        if (this.bhS == null) {
            return 0;
        }
        return this.bhS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bhS == null) {
            return null;
        }
        return this.bhS.get(i);
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bhT, w.add_friend_recommend_title, null);
            t tVar2 = new t(this, null);
            tVar2.QG = (TextView) view.findViewById(v.add_friend_recommend_title);
            tVar2.bhZ = view.findViewById(v.add_friend_recommend_line);
            view.setTag(tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag();
        }
        tVar.QG.setText(str);
        aw.b(tVar.QG, com.baidu.tieba.s.cp_cont_c, 1);
        aw.h(tVar.bhZ, com.baidu.tieba.s.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        s sVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof s)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bhT, w.add_friend_recommend_new, null);
            s sVar2 = new s(this, null);
            sVar2.aEe = (HeadImageView) view.findViewById(v.recommend_new_head);
            sVar2.aEf = (UserIconBox) view.findViewById(v.recommend_new_crown);
            sVar2.aEg = (TextView) view.findViewById(v.recommend_new_user_name);
            sVar2.aEh = (TextView) view.findViewById(v.recommend_new_introduce);
            sVar2.bhX = (TextView) view.findViewById(v.detail_info_distance);
            sVar2.bhY = (TextView) view.findViewById(v.detail_info_time);
            sVar2.aEi = (TextView) view.findViewById(v.recommend_new_add_friend);
            sVar2.aEi.setOnClickListener(new m(this));
            sVar2.aEj = (ImageView) view.findViewById(v.recommend_new_user_sex);
            sVar2.bhZ = view.findViewById(v.recommend_new_line);
            view.setOnClickListener(new n(this));
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        sVar.aEi.setTag(cVar);
        view.setTag(cVar);
        this.bhT.getLayoutMode().L(z);
        this.bhT.getLayoutMode().h(view);
        a(sVar, cVar, z);
        aw.h(sVar.bhZ, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(view, u.recommend_friend_item_bg);
        return view;
    }

    private void a(s sVar, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && sVar != null) {
            if (com.baidu.tbadk.core.k.js().ju()) {
                sVar.aEe.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.ks())) {
                    sVar.aEe.setUserId(String.valueOf(cVar.getUserId()));
                    sVar.aEe.setImageDrawable(null);
                    sVar.aEe.c(cVar.ks(), 12, false);
                }
            } else {
                sVar.aEe.setVisibility(8);
            }
            if (cVar.kv() != null && !TextUtils.isEmpty(cVar.kv().getUrl())) {
                sVar.aEf.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.kv());
                sVar.aEf.a(arrayList, 1, this.bhT.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.bhT.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.bhT.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
            } else {
                sVar.aEf.setVisibility(8);
            }
            sVar.aEg.setText(cVar.getName());
            if (StringUtils.isNull(cVar.ku())) {
                sVar.aEh.setVisibility(8);
            } else {
                sVar.aEh.setVisibility(0);
                sVar.aEh.setText(cVar.ku());
            }
            if (cVar.getLbsInfo() == null) {
                sVar.bhX.setVisibility(8);
                sVar.bhY.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().pB() == 1) {
                sVar.bhX.setVisibility(0);
                sVar.bhX.setText(this.bhT.getString(y.contact_yinshen));
                sVar.bhX.setCompoundDrawables(null, null, null, null);
                sVar.bhY.setVisibility(8);
            } else if (cVar.getLbsInfo().pB() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    sVar.bhX.setVisibility(0);
                    sVar.bhY.setVisibility(0);
                    sVar.bhX.setText(cVar.getLbsInfo().getDistance());
                    sVar.bhY.setText(ay.i(cVar.getLbsInfo().getTime()));
                    this.agW = aw.getDrawable(u.icon_friend_pin);
                    this.agW.setBounds(0, 0, this.size, this.size);
                    sVar.bhX.setCompoundDrawables(this.agW, null, null, null);
                    this.agX = aw.getDrawable(u.icon_friend_time);
                    this.agX.setBounds(0, 0, this.size, this.size);
                    sVar.bhY.setCompoundDrawables(this.agX, null, null, null);
                } else {
                    sVar.bhX.setVisibility(8);
                    sVar.bhY.setVisibility(8);
                }
            } else {
                sVar.bhX.setVisibility(8);
                sVar.bhY.setVisibility(8);
            }
            if (cVar.kt()) {
                aw.c(sVar.aEj, u.icon_pop_qz_girl);
            } else {
                aw.c(sVar.aEj, u.icon_pop_qz_boy);
            }
            if (cVar.kr()) {
                sVar.aEi.setClickable(false);
                sVar.aEi.setBackgroundResource(com.baidu.tieba.s.transparent);
                sVar.aEi.setText(y.waiting);
                aw.b(sVar.aEi, com.baidu.tieba.s.cp_cont_d, 1);
                return;
            }
            sVar.aEi.setClickable(true);
            sVar.aEi.setText(y.add);
        }
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        r rVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof s)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bhT, w.add_friend_recommend_similar, null);
            r rVar2 = new r(this, null);
            rVar2.bhW = new s(this, null);
            View findViewById = view.findViewById(v.recommend_similar_top);
            rVar2.bhW.aEe = (HeadImageView) findViewById.findViewById(v.recommend_new_head);
            rVar2.bhW.aEf = (UserIconBox) findViewById.findViewById(v.recommend_new_crown);
            rVar2.bhW.aEg = (TextView) findViewById.findViewById(v.recommend_new_user_name);
            rVar2.bhW.aEh = (TextView) findViewById.findViewById(v.recommend_new_introduce);
            rVar2.bhW.bhX = (TextView) view.findViewById(v.detail_info_distance);
            rVar2.bhW.bhY = (TextView) view.findViewById(v.detail_info_time);
            rVar2.bhW.bhZ = findViewById.findViewById(v.recommend_new_line);
            rVar2.bhW.aEi = (TextView) findViewById.findViewById(v.recommend_new_add_friend);
            rVar2.bhW.aEi.setOnClickListener(new o(this, bVar));
            rVar2.bhW.aEj = (ImageView) view.findViewById(v.recommend_new_user_sex);
            rVar2.bhW.bhZ = view.findViewById(v.recommend_new_line);
            rVar2.aDU = (TextView) view.findViewById(v.recommend_similar_bar_names);
            rVar2.aDV = (TextView) view.findViewById(v.recommend_similar_bar_desc);
            rVar2.aDY = (TbImageView) view.findViewById(v.recommend_similar_pic_one);
            rVar2.aDZ = (TbImageView) view.findViewById(v.recommend_similar_pic_two);
            rVar2.aEa = (TbImageView) view.findViewById(v.recommend_similar_pic_thr);
            p pVar = new p(this);
            rVar2.aDY.setTag(v.tag_first, bVar);
            rVar2.aDZ.setTag(v.tag_first, bVar);
            rVar2.aEa.setTag(v.tag_first, bVar);
            rVar2.aDY.setTag(v.tag_second, 0);
            rVar2.aDZ.setTag(v.tag_second, 1);
            rVar2.aEa.setTag(v.tag_second, 2);
            rVar2.aDY.setOnClickListener(pVar);
            rVar2.aDZ.setOnClickListener(pVar);
            rVar2.aEa.setOnClickListener(pVar);
            rVar2.aDW = (TextView) view.findViewById(v.recommend_similar_forum);
            rVar2.aDX = (TextView) view.findViewById(v.recommend_similar_common_conern);
            rVar2.aEb = (LinearLayout) view.findViewById(v.recommend_similar_forum_container);
            rVar2.aEc = (LinearLayout) view.findViewById(v.recommend_similar_commom_conern_container);
            view.setOnClickListener(new q(this));
            view.setTag(v.tag_first, rVar2);
            rVar = rVar2;
        } else {
            rVar = (r) view.getTag(v.tag_first);
        }
        rVar.bhW.aEi.setTag(bVar.Rx());
        view.setTag(v.tag_second, bVar.Rx());
        this.bhT.getLayoutMode().L(z);
        this.bhT.getLayoutMode().h(view);
        a(rVar, bVar, z);
        aw.i(rVar.bhW.bhZ, com.baidu.tieba.s.cp_bg_line_b);
        aw.h(view, u.recommend_friend_item_bg);
        return view;
    }

    private void a(r rVar, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        if (rVar != null && bVar != null && bVar.Rx() != null) {
            a(rVar.bhW, bVar.Rx(), z);
            if (bVar.kj() > 0) {
                if (!TextUtils.isEmpty(bVar.kk())) {
                    rVar.aDU.setText(bVar.kk());
                }
                if (bVar.kj() < 3) {
                    rVar.aDV.setVisibility(8);
                } else {
                    rVar.aDV.setVisibility(0);
                    rVar.aDV.setText(y.add_friend_forum_count);
                }
            } else {
                rVar.aEc.setVisibility(8);
            }
            if (com.baidu.tbadk.core.k.js().jw() && bVar.kn() != null && bVar.kn().size() > 0) {
                rVar.aEb.setVisibility(0);
                if (bVar.Rx().kt()) {
                    rVar.aDW.setText(y.add_friend_her_posts);
                } else {
                    rVar.aDW.setText(y.add_friend_his_posts);
                }
                switch (bVar.kn().size()) {
                    case 1:
                        rVar.aDY.setVisibility(0);
                        rVar.aDZ.setVisibility(4);
                        rVar.aEa.setVisibility(4);
                        rVar.aDY.c(bVar.kn().get(0), 10, false);
                        return;
                    case 2:
                        rVar.aDY.setVisibility(0);
                        rVar.aDZ.setVisibility(0);
                        rVar.aEa.setVisibility(4);
                        rVar.aDY.c(bVar.kn().get(0), 10, false);
                        rVar.aDZ.c(bVar.kn().get(1), 10, false);
                        return;
                    default:
                        rVar.aDY.setVisibility(0);
                        rVar.aDZ.setVisibility(0);
                        rVar.aEa.setVisibility(0);
                        rVar.aDY.c(bVar.kn().get(0), 10, false);
                        rVar.aDZ.c(bVar.kn().get(1), 10, false);
                        rVar.aEa.c(bVar.kn().get(2), 10, false);
                        return;
                }
            }
            rVar.aEb.setVisibility(8);
        }
    }
}
