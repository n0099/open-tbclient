package com.baidu.tieba.addresslist.im.searchfriend;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private ArrayList<Object> Yg = new ArrayList<>();
    private Drawable aIf;
    private Drawable aIg;
    private SearchFriendActivity aJC;
    private int size;

    public m(SearchFriendActivity searchFriendActivity) {
        this.aJC = searchFriendActivity;
        this.size = com.baidu.adp.lib.util.k.d(this.aJC.getPageContext().getPageActivity(), n.d.ds24);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void a(com.baidu.tieba.addresslist.im.searchfriend.a.a aVar) {
        if (aVar != null && aVar.HC() != null && aVar.HD() != null) {
            this.Yg.clear();
            ArrayList arrayList = new ArrayList();
            if (!aVar.HC().isEmpty()) {
                if (gx(aVar.HC().getTagName())) {
                    arrayList.add(aVar.HC().getTagName());
                } else {
                    arrayList.add(this.aJC.getPageContext().getString(n.i.add_friend_recommend_title_new));
                }
                arrayList.add(aVar.HC());
            }
            boolean z = false;
            for (com.baidu.tieba.addresslist.im.searchfriend.a.b bVar : aVar.HD()) {
                if (bVar.HC() != null) {
                    if (!bVar.HC().isEmpty()) {
                        if (!z) {
                            if (gx(bVar.HC().getTagName())) {
                                arrayList.add(bVar.HC().getTagName());
                            } else {
                                arrayList.add(this.aJC.getPageContext().getString(n.i.add_friend_recommend_title_similar));
                            }
                            z = true;
                        }
                        arrayList.add(bVar);
                    }
                } else {
                    return;
                }
            }
            this.Yg.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    private boolean gx(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.getTrimmedLength(str) > 0;
    }

    public com.baidu.tieba.addresslist.im.searchfriend.a.a HB() {
        com.baidu.tieba.addresslist.im.searchfriend.a.a aVar = new com.baidu.tieba.addresslist.im.searchfriend.a.a();
        Iterator<Object> it = this.Yg.iterator();
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
        if (this.Yg != null && this.Yg.size() > 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Iterator<Object> it = this.Yg.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
                    com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) next;
                    if (TextUtils.equals(cVar.getName(), str2) && TextUtils.equals(str, String.valueOf(cVar.getUserId()))) {
                        cVar.ss();
                        notifyDataSetChanged();
                        return;
                    }
                } else if (next instanceof com.baidu.tieba.addresslist.im.searchfriend.a.b) {
                    com.baidu.tieba.addresslist.im.searchfriend.a.b bVar = (com.baidu.tieba.addresslist.im.searchfriend.a.b) next;
                    if (TextUtils.equals(bVar.HC().getName(), str2) && TextUtils.equals(str, String.valueOf(bVar.HC().getUserId()))) {
                        bVar.HC().ss();
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
        Object obj = this.Yg.get(i);
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
        if (this.Yg == null) {
            return 0;
        }
        return this.Yg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Yg == null) {
            return null;
        }
        return this.Yg.get(i);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {
        TextView agd;
        View line;

        private c() {
        }

        /* synthetic */ c(m mVar, c cVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView aJP;
        UserIconBox aJQ;
        TextView aJR;
        TextView aJS;
        TextView aJT;
        TextView aJU;
        TextView aJV;
        ImageView aJW;
        View line;

        private b() {
        }

        /* synthetic */ b(m mVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        b aJF;
        TextView aJG;
        TextView aJH;
        TextView aJI;
        TextView aJJ;
        TbImageView aJK;
        TbImageView aJL;
        TbImageView aJM;
        LinearLayout aJN;
        LinearLayout aJO;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }

    private View a(View view, String str, boolean z) {
        c cVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
            view = LayoutInflater.from(this.aJC.getPageContext().getPageActivity()).inflate(n.g.add_friend_recommend_title, (ViewGroup) null);
            c cVar2 = new c(this, null);
            cVar2.agd = (TextView) view.findViewById(n.f.add_friend_recommend_title);
            cVar2.line = view.findViewById(n.f.add_friend_recommend_line);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        cVar.agd.setText(str);
        as.b(cVar.agd, n.c.cp_cont_c, 1);
        as.i(cVar.line, n.c.cp_bg_line_b);
        return view;
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.aJC.getPageContext().getPageActivity()).inflate(n.g.add_friend_recommend_new, (ViewGroup) null);
            b bVar2 = new b(this, null);
            bVar2.aJP = (HeadImageView) view.findViewById(n.f.recommend_new_head);
            bVar2.aJQ = (UserIconBox) view.findViewById(n.f.recommend_new_crown);
            bVar2.aJR = (TextView) view.findViewById(n.f.recommend_new_user_name);
            bVar2.aJS = (TextView) view.findViewById(n.f.recommend_new_introduce);
            bVar2.aJT = (TextView) view.findViewById(n.f.detail_info_distance);
            bVar2.aJU = (TextView) view.findViewById(n.f.detail_info_time);
            bVar2.aJV = (TextView) view.findViewById(n.f.recommend_new_add_friend);
            bVar2.aJV.setOnClickListener(new n(this));
            bVar2.aJW = (ImageView) view.findViewById(n.f.recommend_new_user_sex);
            bVar2.line = view.findViewById(n.f.recommend_new_line);
            view.setOnClickListener(new o(this));
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.aJV.setTag(cVar);
        view.setTag(cVar);
        this.aJC.getLayoutMode().af(z);
        this.aJC.getLayoutMode().k(view);
        a(bVar, cVar, z);
        as.i(bVar.line, n.c.cp_bg_line_b);
        as.i(view, n.e.recommend_friend_item_bg);
        return view;
    }

    private void a(b bVar, com.baidu.tieba.addresslist.im.searchfriend.a.c cVar, boolean z) {
        if (cVar != null && bVar != null) {
            if (com.baidu.tbadk.core.m.rh().rj()) {
                bVar.aJP.setVisibility(0);
                if (!TextUtils.isEmpty(cVar.su())) {
                    bVar.aJP.setUserId(String.valueOf(cVar.getUserId()));
                    bVar.aJP.setImageDrawable(null);
                    bVar.aJP.d(cVar.su(), 12, false);
                }
            } else {
                bVar.aJP.setVisibility(8);
            }
            if (cVar.sx() != null && !TextUtils.isEmpty(cVar.sx().getUrl())) {
                bVar.aJQ.setVisibility(0);
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar.sx());
                bVar.aJQ.a(arrayList, 1, this.aJC.getResources().getDimensionPixelSize(n.d.small_icon_width), this.aJC.getResources().getDimensionPixelSize(n.d.small_icon_height), this.aJC.getResources().getDimensionPixelSize(n.d.small_icon_margin));
            } else {
                bVar.aJQ.setVisibility(8);
            }
            bVar.aJR.setText(cVar.getName());
            if (StringUtils.isNull(cVar.sw())) {
                bVar.aJS.setVisibility(8);
            } else {
                bVar.aJS.setVisibility(0);
                bVar.aJS.setText(cVar.sw());
            }
            if (cVar.getLbsInfo() == null) {
                bVar.aJT.setVisibility(8);
                bVar.aJU.setVisibility(8);
                return;
            }
            if (cVar.getLbsInfo().zw() == 1) {
                bVar.aJT.setVisibility(0);
                bVar.aJT.setText(this.aJC.getPageContext().getString(n.i.contact_yinshen));
                bVar.aJT.setCompoundDrawables(null, null, null, null);
                bVar.aJU.setVisibility(8);
            } else if (cVar.getLbsInfo().zw() == 0) {
                if (!StringUtils.isNull(cVar.getLbsInfo().getDistance()) && cVar.getLbsInfo().getTime() > 0) {
                    bVar.aJT.setVisibility(0);
                    bVar.aJU.setVisibility(0);
                    bVar.aJT.setText(cVar.getLbsInfo().getDistance());
                    bVar.aJU.setText(ax.r(cVar.getLbsInfo().getTime()));
                    this.aIf = as.getDrawable(n.e.icon_friend_pin);
                    this.aIf.setBounds(0, 0, this.size, this.size);
                    bVar.aJT.setCompoundDrawables(this.aIf, null, null, null);
                    this.aIg = as.getDrawable(n.e.icon_friend_time);
                    this.aIg.setBounds(0, 0, this.size, this.size);
                    bVar.aJU.setCompoundDrawables(this.aIg, null, null, null);
                } else {
                    bVar.aJT.setVisibility(8);
                    bVar.aJU.setVisibility(8);
                }
            } else {
                bVar.aJT.setVisibility(8);
                bVar.aJU.setVisibility(8);
            }
            if (cVar.sv()) {
                as.c(bVar.aJW, n.e.icon_pop_qz_girl);
            } else {
                as.c(bVar.aJW, n.e.icon_pop_qz_boy);
            }
            if (cVar.st()) {
                bVar.aJV.setClickable(false);
                bVar.aJV.setBackgroundResource(n.c.transparent);
                bVar.aJV.setText(n.i.waiting);
                as.b(bVar.aJV, n.c.cp_cont_d, 1);
                return;
            }
            bVar.aJV.setClickable(true);
            bVar.aJV.setText(n.i.add);
        }
    }

    private View a(View view, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.aJC.getPageContext().getPageActivity()).inflate(n.g.add_friend_recommend_similar, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.aJF = new b(this, null);
            View findViewById = view.findViewById(n.f.recommend_similar_top);
            aVar2.aJF.aJP = (HeadImageView) findViewById.findViewById(n.f.recommend_new_head);
            aVar2.aJF.aJQ = (UserIconBox) findViewById.findViewById(n.f.recommend_new_crown);
            aVar2.aJF.aJR = (TextView) findViewById.findViewById(n.f.recommend_new_user_name);
            aVar2.aJF.aJS = (TextView) findViewById.findViewById(n.f.recommend_new_introduce);
            aVar2.aJF.aJT = (TextView) view.findViewById(n.f.detail_info_distance);
            aVar2.aJF.aJU = (TextView) view.findViewById(n.f.detail_info_time);
            aVar2.aJF.line = findViewById.findViewById(n.f.recommend_new_line);
            aVar2.aJF.aJV = (TextView) findViewById.findViewById(n.f.recommend_new_add_friend);
            aVar2.aJF.aJV.setOnClickListener(new p(this, bVar));
            aVar2.aJF.aJW = (ImageView) view.findViewById(n.f.recommend_new_user_sex);
            aVar2.aJF.line = view.findViewById(n.f.recommend_new_line);
            aVar2.aJG = (TextView) view.findViewById(n.f.recommend_similar_bar_names);
            aVar2.aJH = (TextView) view.findViewById(n.f.recommend_similar_bar_desc);
            aVar2.aJK = (TbImageView) view.findViewById(n.f.recommend_similar_pic_one);
            aVar2.aJL = (TbImageView) view.findViewById(n.f.recommend_similar_pic_two);
            aVar2.aJM = (TbImageView) view.findViewById(n.f.recommend_similar_pic_thr);
            q qVar = new q(this);
            aVar2.aJK.setTag(n.f.tag_first, bVar);
            aVar2.aJL.setTag(n.f.tag_first, bVar);
            aVar2.aJM.setTag(n.f.tag_first, bVar);
            aVar2.aJK.setTag(n.f.tag_second, 0);
            aVar2.aJL.setTag(n.f.tag_second, 1);
            aVar2.aJM.setTag(n.f.tag_second, 2);
            aVar2.aJK.setOnClickListener(qVar);
            aVar2.aJL.setOnClickListener(qVar);
            aVar2.aJM.setOnClickListener(qVar);
            aVar2.aJI = (TextView) view.findViewById(n.f.recommend_similar_forum);
            aVar2.aJJ = (TextView) view.findViewById(n.f.recommend_similar_common_conern);
            aVar2.aJN = (LinearLayout) view.findViewById(n.f.recommend_similar_forum_container);
            aVar2.aJO = (LinearLayout) view.findViewById(n.f.recommend_similar_commom_conern_container);
            view.setOnClickListener(new r(this));
            view.setTag(n.f.tag_first, aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag(n.f.tag_first);
        }
        aVar.aJF.aJV.setTag(bVar.HC());
        view.setTag(n.f.tag_second, bVar.HC());
        this.aJC.getLayoutMode().af(z);
        this.aJC.getLayoutMode().k(view);
        a(aVar, bVar, z);
        as.j(aVar.aJF.line, n.c.cp_bg_line_b);
        as.i(view, n.e.recommend_friend_item_bg);
        return view;
    }

    private void a(a aVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar, boolean z) {
        if (aVar != null && bVar != null && bVar.HC() != null) {
            a(aVar.aJF, bVar.HC(), z);
            if (bVar.sl() > 0) {
                if (!TextUtils.isEmpty(bVar.sm())) {
                    aVar.aJG.setText(bVar.sm());
                }
                if (bVar.sl() < 3) {
                    aVar.aJH.setVisibility(8);
                } else {
                    aVar.aJH.setVisibility(0);
                    aVar.aJH.setText(n.i.add_friend_forum_count);
                }
            } else {
                aVar.aJO.setVisibility(8);
            }
            if (com.baidu.tbadk.core.m.rh().rn() && bVar.sp() != null && bVar.sp().size() > 0) {
                aVar.aJN.setVisibility(0);
                if (bVar.HC().sv()) {
                    aVar.aJI.setText(n.i.add_friend_her_posts);
                } else {
                    aVar.aJI.setText(n.i.add_friend_his_posts);
                }
                switch (bVar.sp().size()) {
                    case 1:
                        aVar.aJK.setVisibility(0);
                        aVar.aJL.setVisibility(4);
                        aVar.aJM.setVisibility(4);
                        aVar.aJK.d(bVar.sp().get(0), 13, false);
                        return;
                    case 2:
                        aVar.aJK.setVisibility(0);
                        aVar.aJL.setVisibility(0);
                        aVar.aJM.setVisibility(4);
                        aVar.aJK.d(bVar.sp().get(0), 13, false);
                        aVar.aJL.d(bVar.sp().get(1), 13, false);
                        return;
                    default:
                        aVar.aJK.setVisibility(0);
                        aVar.aJL.setVisibility(0);
                        aVar.aJM.setVisibility(0);
                        aVar.aJK.d(bVar.sp().get(0), 13, false);
                        aVar.aJL.d(bVar.sp().get(1), 13, false);
                        aVar.aJM.d(bVar.sp().get(2), 13, false);
                        return;
                }
            }
            aVar.aJN.setVisibility(8);
        }
    }
}
