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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
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
    private Drawable aov;
    private Drawable aow;
    private ArrayList<Object> bmJ = new ArrayList<>();
    private SearchFriendActivity bmK;
    private int size;

    public n(SearchFriendActivity searchFriendActivity) {
        this.bmK = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.l.d(this.bmK.getPageContext().getPageActivity(), com.baidu.tieba.u.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.SM() != null && aVar.SN() != null) {
            this.bmJ.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.SM().isEmpty()) {
                if (hh(aVar.SM().getTagName())) {
                    arrayList.add(aVar.SM().getTagName());
                } else {
                    arrayList.add(this.bmK.getPageContext().getString(z.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.SM());
            }
            boolean z = false;
            for (com.baidu.tieba.im.searchfriend.a.b bVar : aVar.SN()) {
                if (bVar.SM() != null) {
                    if (!bVar.SM().isEmpty()) {
                        if (!z) {
                            if (hh(bVar.SM().getTagName())) {
                                arrayList.add(bVar.SM().getTagName());
                            } else {
                                arrayList.add(this.bmK.getPageContext().getString(z.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.bmJ.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean hh(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.im.searchfriend.a.a SL() {
        com.baidu.tieba.im.searchfriend.a.a aVar = new com.baidu.tieba.im.searchfriend.a.a();
        Iterator<Object> it = this.bmJ.iterator();
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

    public void am(String str, String str2) {
        if (this.bmJ != null && this.bmJ.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.bmJ.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.im.searchfriend.a.c) {
                    com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.nj();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.im.searchfriend.a.b) {
                    com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.SM().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.SM().getUserId()))) {
                        bVar.SM().nj();
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
        Object obj = this.bmJ.get(i);
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
        if (this.bmJ == null) {
            return 0;
        }
        return this.bmJ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bmJ == null) {
            return null;
        }
        return this.bmJ.get(i);
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bmK.getPageContext().getPageActivity(), x.add_friend_recommend_title, null);
            v vVar2 = new v(this, null);
            vVar2.title = (TextView) view.findViewById(w.add_friend_recommend_title);
            vVar2.line = view.findViewById(w.add_friend_recommend_line);
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        vVar.title.setText(str);
        ax.b(vVar.title, com.baidu.tieba.t.cp_cont_c, 1);
        ax.i(vVar.line, com.baidu.tieba.t.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bmK.getPageContext().getPageActivity(), x.add_friend_recommend_new, null);
            u uVar2 = new u(this, null);
            uVar2.aFT = (HeadImageView) view.findViewById(w.recommend_new_head);
            uVar2.aFU = (UserIconBox) view.findViewById(w.recommend_new_crown);
            uVar2.aFV = (TextView) view.findViewById(w.recommend_new_user_name);
            uVar2.aFW = (TextView) view.findViewById(w.recommend_new_introduce);
            uVar2.bmO = (TextView) view.findViewById(w.detail_info_distance);
            uVar2.bmP = (TextView) view.findViewById(w.detail_info_time);
            uVar2.aFX = (TextView) view.findViewById(w.recommend_new_add_friend);
            uVar2.aFX.setOnClickListener(new o(this));
            uVar2.aFY = (ImageView) view.findViewById(w.recommend_new_user_sex);
            uVar2.line = view.findViewById(w.recommend_new_line);
            view.setOnClickListener(new p(this));
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        uVar.aFX.setTag(cVar);
        view.setTag(cVar);
        this.bmK.getLayoutMode().ab(z);
        this.bmK.getLayoutMode().h(view);
        a(uVar, cVar, z);
        ax.i(uVar.line, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(view, com.baidu.tieba.v.recommend_friend_item_bg);
        return view;
    }

    private void a(u uVar, com.baidu.tieba.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && uVar != null) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                uVar.aFT.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.nl())) {
                    uVar.aFT.setUserId(String.valueOf(cVar.getUserId()));
                    uVar.aFT.setImageDrawable(null);
                    uVar.aFT.d(cVar.nl(), 12, false);
                }
            } else {
                uVar.aFT.setVisibility(8);
            }
            if (cVar.no() != null && !TextUtils.isEmpty(cVar.no().getUrl())) {
                uVar.aFU.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.no());
                uVar.aFU.a(arrayList, 1, this.bmK.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.bmK.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.bmK.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
            } else {
                uVar.aFU.setVisibility(8);
            }
            uVar.aFV.setText(cVar.getName());
            if (StringUtils.isNull(cVar.nn())) {
                uVar.aFW.setVisibility(8);
            } else {
                uVar.aFW.setVisibility(0);
                uVar.aFW.setText(cVar.nn());
            }
            if (cVar.getLbsInfo() == null) {
                uVar.bmO.setVisibility(8);
                uVar.bmP.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().sX() == 1) {
                uVar.bmO.setVisibility(0);
                uVar.bmO.setText(this.bmK.getPageContext().getString(z.contact_yinshen));
                uVar.bmO.setCompoundDrawables(null, null, null, null);
                uVar.bmP.setVisibility(8);
            } else if (cVar.getLbsInfo().sX() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    uVar.bmO.setVisibility(0);
                    uVar.bmP.setVisibility(0);
                    uVar.bmO.setText(cVar.getLbsInfo().getDistance());
                    uVar.bmP.setText(ba.m(cVar.getLbsInfo().getTime()));
                    this.aov = ax.getDrawable(com.baidu.tieba.v.icon_friend_pin);
                    this.aov.setBounds(0, 0, this.size, this.size);
                    uVar.bmO.setCompoundDrawables(this.aov, null, null, null);
                    this.aow = ax.getDrawable(com.baidu.tieba.v.icon_friend_time);
                    this.aow.setBounds(0, 0, this.size, this.size);
                    uVar.bmP.setCompoundDrawables(this.aow, null, null, null);
                } else {
                    uVar.bmO.setVisibility(8);
                    uVar.bmP.setVisibility(8);
                }
            } else {
                uVar.bmO.setVisibility(8);
                uVar.bmP.setVisibility(8);
            }
            if (cVar.nm()) {
                ax.c(uVar.aFY, com.baidu.tieba.v.icon_pop_qz_girl);
            } else {
                ax.c(uVar.aFY, com.baidu.tieba.v.icon_pop_qz_boy);
            }
            if (cVar.nk()) {
                uVar.aFX.setClickable(false);
                uVar.aFX.setBackgroundResource(com.baidu.tieba.t.transparent);
                uVar.aFX.setText(z.waiting);
                ax.b(uVar.aFX, com.baidu.tieba.t.cp_cont_d, 1);
                return;
            }
            uVar.aFX.setClickable(true);
            uVar.aFX.setText(z.add);
        }
    }

    private View a(View view, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        t tVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.bmK.getPageContext().getPageActivity(), x.add_friend_recommend_similar, null);
            t tVar2 = new t(this, null);
            tVar2.bmN = new u(this, null);
            View findViewById = view.findViewById(w.recommend_similar_top);
            tVar2.bmN.aFT = (HeadImageView) findViewById.findViewById(w.recommend_new_head);
            tVar2.bmN.aFU = (UserIconBox) findViewById.findViewById(w.recommend_new_crown);
            tVar2.bmN.aFV = (TextView) findViewById.findViewById(w.recommend_new_user_name);
            tVar2.bmN.aFW = (TextView) findViewById.findViewById(w.recommend_new_introduce);
            tVar2.bmN.bmO = (TextView) view.findViewById(w.detail_info_distance);
            tVar2.bmN.bmP = (TextView) view.findViewById(w.detail_info_time);
            tVar2.bmN.line = findViewById.findViewById(w.recommend_new_line);
            tVar2.bmN.aFX = (TextView) findViewById.findViewById(w.recommend_new_add_friend);
            tVar2.bmN.aFX.setOnClickListener(new q(this, bVar));
            tVar2.bmN.aFY = (ImageView) view.findViewById(w.recommend_new_user_sex);
            tVar2.bmN.line = view.findViewById(w.recommend_new_line);
            tVar2.aFJ = (TextView) view.findViewById(w.recommend_similar_bar_names);
            tVar2.aFK = (TextView) view.findViewById(w.recommend_similar_bar_desc);
            tVar2.aFN = (TbImageView) view.findViewById(w.recommend_similar_pic_one);
            tVar2.aFO = (TbImageView) view.findViewById(w.recommend_similar_pic_two);
            tVar2.aFP = (TbImageView) view.findViewById(w.recommend_similar_pic_thr);
            r rVar = new r(this);
            tVar2.aFN.setTag(w.tag_first, bVar);
            tVar2.aFO.setTag(w.tag_first, bVar);
            tVar2.aFP.setTag(w.tag_first, bVar);
            tVar2.aFN.setTag(w.tag_second, 0);
            tVar2.aFO.setTag(w.tag_second, 1);
            tVar2.aFP.setTag(w.tag_second, 2);
            tVar2.aFN.setOnClickListener(rVar);
            tVar2.aFO.setOnClickListener(rVar);
            tVar2.aFP.setOnClickListener(rVar);
            tVar2.aFL = (TextView) view.findViewById(w.recommend_similar_forum);
            tVar2.aFM = (TextView) view.findViewById(w.recommend_similar_common_conern);
            tVar2.aFQ = (LinearLayout) view.findViewById(w.recommend_similar_forum_container);
            tVar2.aFR = (LinearLayout) view.findViewById(w.recommend_similar_commom_conern_container);
            view.setOnClickListener(new s(this));
            view.setTag(w.tag_first, tVar2);
            tVar = tVar2;
        } else {
            tVar = (t) view.getTag(w.tag_first);
        }
        tVar.bmN.aFX.setTag(bVar.SM());
        view.setTag(w.tag_second, bVar.SM());
        this.bmK.getLayoutMode().ab(z);
        this.bmK.getLayoutMode().h(view);
        a(tVar, bVar, z);
        ax.j(tVar.bmN.line, com.baidu.tieba.t.cp_bg_line_b);
        ax.i(view, com.baidu.tieba.v.recommend_friend_item_bg);
        return view;
    }

    private void a(t tVar, com.baidu.tieba.im.searchfriend.a.b bVar, boolean z) {
        if (tVar != null && bVar != null && bVar.SM() != null) {
            a(tVar.bmN, bVar.SM(), z);
            if (bVar.nc() > 0) {
                if (!TextUtils.isEmpty(bVar.nd())) {
                    tVar.aFJ.setText(bVar.nd());
                }
                if (bVar.nc() < 3) {
                    tVar.aFK.setVisibility(8);
                } else {
                    tVar.aFK.setVisibility(0);
                    tVar.aFK.setText(z.add_friend_forum_count);
                }
            } else {
                tVar.aFR.setVisibility(8);
            }
            if (com.baidu.tbadk.core.l.mc().mg() && bVar.ng() != null && bVar.ng().size() > 0) {
                tVar.aFQ.setVisibility(0);
                if (bVar.SM().nm()) {
                    tVar.aFL.setText(z.add_friend_her_posts);
                } else {
                    tVar.aFL.setText(z.add_friend_his_posts);
                }
                switch (bVar.ng().size()) {
                    case 1:
                        tVar.aFN.setVisibility(0);
                        tVar.aFO.setVisibility(4);
                        tVar.aFP.setVisibility(4);
                        tVar.aFN.d(bVar.ng().get(0), 10, false);
                        return;
                    case 2:
                        tVar.aFN.setVisibility(0);
                        tVar.aFO.setVisibility(0);
                        tVar.aFP.setVisibility(4);
                        tVar.aFN.d(bVar.ng().get(0), 10, false);
                        tVar.aFO.d(bVar.ng().get(1), 10, false);
                        return;
                    default:
                        tVar.aFN.setVisibility(0);
                        tVar.aFO.setVisibility(0);
                        tVar.aFP.setVisibility(0);
                        tVar.aFN.d(bVar.ng().get(0), 10, false);
                        tVar.aFO.d(bVar.ng().get(1), 10, false);
                        tVar.aFP.d(bVar.ng().get(2), 10, false);
                        return;
                }
            }
            tVar.aFQ.setVisibility(8);
        }
    }
}
