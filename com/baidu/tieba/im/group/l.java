package com.baidu.tieba.im.group;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class l extends BaseAdapter implements AbsListView.OnScrollListener {
    private com.baidu.tbadk.core.d a;
    private ab b;
    private volatile boolean c;
    private List<GroupInfoData> d = new ArrayList();
    private int e = 0;
    private String f;
    private String g;

    public l(com.baidu.tbadk.core.d dVar) {
        this.b = null;
        this.a = dVar;
        this.b = new ab(dVar.getActivity());
    }

    public final void a(int i) {
        this.e = i;
        notifyDataSetChanged();
    }

    public final void a(String str, String str2) {
        this.f = str;
        this.g = str2;
        notifyDataSetChanged();
    }

    public final void a(List<GroupInfoData> list) {
        this.d = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.d == null || this.d.size() <= 0) {
            return 7;
        }
        return this.d.size() + 8;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.c = false;
            notifyDataSetChanged();
            return;
        }
        this.c = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i2 = (i - 7) - 1;
        return (i2 < 0 || i2 >= this.d.size()) ? Integer.valueOf(i) : this.d.get(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (i > 7) {
            return 3;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 7:
                return 2;
            case 2:
                return 1;
            case 3:
                return 1;
            case 4:
                return 1;
            case 5:
                return 1;
            case 6:
                return 1;
            default:
                return 1;
        }
    }

    public final void a() {
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        ImageView imageView;
        ImageView imageView2;
        String str;
        GroupInfoData groupInfoData = null;
        switch (getItemViewType(i)) {
            case 0:
                View inflate = LayoutInflater.from(TbadkApplication.j().b().getApplicationContext()).inflate(com.baidu.tieba.im.i.group_tab_banner, viewGroup, false);
                BannerView bannerView = (BannerView) inflate.findViewById(com.baidu.tieba.im.h.group_banner);
                bannerView.a("group_tab_banner_click", "group_tab_banner_close");
                if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
                    return inflate;
                }
                bannerView.a(this.f, this.g, "group_banner_date", 259200000L);
                return inflate;
            case 1:
                n nVar = view != null ? (n) view.getTag() : null;
                if (nVar == null) {
                    view = LayoutInflater.from(TbadkApplication.j().b().getApplicationContext()).inflate(com.baidu.tieba.im.i.group_tab_item, viewGroup, false);
                    nVar = n.a(view);
                    view.setTag(nVar);
                }
                n nVar2 = nVar;
                switch (i) {
                    case 2:
                        nVar2.b.setLineTopVisibility(true);
                        nVar2.b.setLineTopPxVisibility(false);
                        nVar2.b.setLineBottomPxVisibility(false);
                        if (this.e <= 0) {
                            nVar2.b.setText("附近群组");
                        } else {
                            nVar2.b.a("附近群组(" + this.e + ")", 5, str.length() - 1);
                        }
                        nVar2.b.setLeftIconRes(com.baidu.tieba.im.g.icon_nearby_group);
                        nVar2.b.getRightIcon().setVisibility(8);
                        nVar2.c.setVisibility(8);
                        break;
                    case 3:
                        nVar2.b.setLineTopVisibility(false);
                        nVar2.b.setLineTopPxVisibility(true);
                        nVar2.b.setLineBottomPxVisibility(false);
                        nVar2.b.setText(TbadkApplication.j().b().getResources().getString(com.baidu.tieba.im.j.group_tab_hotgroup));
                        nVar2.b.setLeftIconRes(com.baidu.tieba.im.g.icon_hot_group);
                        nVar2.b.getRightIcon().setVisibility(8);
                        nVar2.c.setVisibility(8);
                        break;
                    case 4:
                        nVar2.b.setLineTopVisibility(false);
                        nVar2.b.setLineTopPxVisibility(true);
                        nVar2.b.setLineBottomPxVisibility(false);
                        nVar2.b.setText(TbadkApplication.j().b().getResources().getString(com.baidu.tieba.im.j.group_tab_enterchatroom_btn));
                        nVar2.b.setLeftIconRes(com.baidu.tieba.im.g.icon_come_chat);
                        nVar2.b.getRightIcon().setVisibility(8);
                        nVar2.c.setVisibility(8);
                        break;
                    case 5:
                        nVar2.b.setLineTopVisibility(false);
                        nVar2.b.setLineTopPxVisibility(true);
                        nVar2.b.setLineBottomPxVisibility(false);
                        nVar2.b.setText(TbadkApplication.j().b().getResources().getString(com.baidu.tieba.im.j.group_tab_addgroup));
                        nVar2.b.setLeftIconRes(com.baidu.tieba.im.g.icon_qun_search);
                        nVar2.b.getRightIcon().setVisibility(8);
                        nVar2.c.setVisibility(0);
                        break;
                    case 6:
                        nVar2.b.setLineTopVisibility(false);
                        nVar2.b.setLineTopPxVisibility(true);
                        nVar2.b.setLineBottomPxVisibility(true);
                        nVar2.b.setText(TbadkApplication.j().b().getResources().getString(com.baidu.tieba.im.j.group_tab_creategroup));
                        nVar2.b.setLeftIconRes(com.baidu.tieba.im.g.icon_add_group);
                        nVar2.b.getRightIcon().setVisibility(8);
                        nVar2.c.setVisibility(8);
                        break;
                }
                nVar2.b.setTag(Integer.valueOf(i));
                ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(TbadkApplication.j().l() == 1);
                ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(view);
                ba.f(nVar2.b, com.baidu.tieba.im.g.list_item_selector);
                ba.f(nVar2.a, com.baidu.tieba.im.e.cp_bg_line_d);
                nVar2.b.a(TbadkApplication.j().l());
                nVar2.b.setOnClickListener(this.a);
                ba.a(nVar2.b.getTextView(), com.baidu.tieba.im.e.cp_cont_b, 1);
                ba.c(nVar2.b.getRightIcon(), com.baidu.tieba.im.g.icon_ba_top_arrow_big);
                return view;
            case 2:
                p a = p.a(view);
                if (a != null) {
                    if (i == 1) {
                        a.a(com.baidu.tieba.im.j.group_title_find_group);
                        a.a(false, false);
                    } else if (i == 7) {
                        a.a(com.baidu.tieba.im.j.group_tab_mygroup);
                        a.a(false, false);
                    }
                    ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(TbadkApplication.j().l() == 1);
                    ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(a.a());
                    if (TbadkApplication.j().l() == 1) {
                        imageView2 = a.d;
                        imageView2.setImageResource(com.baidu.tieba.im.e.cp_bg_line_b_1);
                    } else {
                        imageView = a.d;
                        imageView.setImageResource(com.baidu.tieba.im.e.cp_bg_line_b);
                    }
                    a.b();
                    return a.a();
                }
                return null;
            case 3:
                if (view == null) {
                    view = LayoutInflater.from(this.a.getActivity()).inflate(com.baidu.tieba.im.i.tab_my_group_item, viewGroup, false);
                    oVar = new o();
                    oVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.im.h.click_head);
                    oVar.g = (ImageView) view.findViewById(com.baidu.tieba.im.h.diver_top);
                    oVar.h = (ImageView) view.findViewById(com.baidu.tieba.im.h.diver_top_px);
                    oVar.b = (HeadImageView) view.findViewById(com.baidu.tieba.im.h.item_head);
                    oVar.c = (TextView) view.findViewById(com.baidu.tieba.im.h.item_group_name);
                    oVar.d = (TextView) view.findViewById(com.baidu.tieba.im.h.item_group_num);
                    oVar.e = (TextView) view.findViewById(com.baidu.tieba.im.h.item_introduce);
                    oVar.f = (TextView) view.findViewById(com.baidu.tieba.im.h.isCreator);
                    oVar.i = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_grade1);
                    oVar.j = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_grade2);
                    oVar.k = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_grade3);
                    oVar.l = new ImageView[4];
                    oVar.l[1] = oVar.i;
                    oVar.l[2] = oVar.j;
                    oVar.l[3] = oVar.k;
                    view.setTag(oVar);
                } else {
                    oVar = (o) view.getTag();
                }
                Object item = getItem(i);
                if (item != null && (item instanceof GroupInfoData)) {
                    groupInfoData = (GroupInfoData) item;
                }
                oVar.b.setDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140);
                oVar.b.setNightDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140_1);
                oVar.b.setDrawBorder(true);
                oVar.b.setRadius(com.baidu.adp.lib.util.i.a((Context) this.a.getActivity(), 3.0f));
                if (groupInfoData != null) {
                    String portrait = groupInfoData.getPortrait();
                    oVar.b.setTag(portrait);
                    ab abVar = this.b;
                    if (com.baidu.tbadk.imageManager.e.a().c(portrait) != null) {
                        oVar.b.invalidate();
                    } else if (!this.c) {
                        this.b.f(portrait, new m(this, view));
                    }
                    oVar.a.setOnClickListener(this.a);
                    oVar.a.setTag(groupInfoData);
                    if (this.d == null || i != getCount() - this.d.size()) {
                        oVar.g.setVisibility(8);
                        oVar.h.setVisibility(0);
                    } else {
                        oVar.g.setVisibility(0);
                        oVar.h.setVisibility(8);
                    }
                    oVar.c.setText(groupInfoData.getName());
                    oVar.d.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
                    oVar.e.setText(groupInfoData.getIntro());
                    if (groupInfoData.getIsGroupManager() == 1) {
                        oVar.f.setVisibility(0);
                    } else {
                        oVar.f.setVisibility(8);
                    }
                    a(oVar.l, groupInfoData.getGrade());
                }
                ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(TbadkApplication.j().l() == 1);
                ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(view);
                if (groupInfoData == null || !groupInfoData.isMemGroup()) {
                    return view;
                }
                ba.a(oVar.c, com.baidu.tieba.im.e.cp_cont_b, 1);
                ba.c(oVar.i, com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
                ba.c(oVar.j, com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
                ba.c(oVar.k, com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
                return view;
            default:
                return view;
        }
    }

    private static void a(ImageView[] imageViewArr, int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }
}
