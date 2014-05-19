package com.baidu.tieba.im.group;

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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter implements AbsListView.OnScrollListener {
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

    public void a(int i) {
        this.e = i;
        notifyDataSetChanged();
    }

    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
        notifyDataSetChanged();
    }

    public void a(List<GroupInfoData> list) {
        this.d = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.d == null || this.d.size() <= 0) {
            return 8;
        }
        return this.d.size() + 9;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.c = false;
            notifyDataSetChanged();
            return;
        }
        this.c = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = (i - 8) - 1;
        return (i2 <= -1 || i2 >= this.d.size()) ? Integer.valueOf(i) : this.d.get(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i > 8) {
            return 3;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
            case 8:
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
            case 7:
                return 1;
            default:
                return 1;
        }
    }

    public void b(int i) {
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                return a(i, view, viewGroup);
            case 1:
                return d(i, view, viewGroup);
            case 2:
                return b(i, view, viewGroup);
            case 3:
                return c(i, view, viewGroup);
            default:
                return view;
        }
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(TbadkApplication.m252getInst().getApp().getApplicationContext()).inflate(s.group_tab_banner, viewGroup, false);
        BannerView bannerView = (BannerView) inflate.findViewById(r.group_banner);
        bannerView.a("group_tab_banner_click", "group_tab_banner_close");
        if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.g)) {
            bannerView.a(this.f, this.g, "group_banner_date", 259200000L);
        }
        return inflate;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        ImageView imageView2;
        p a = p.a(view);
        if (a != null) {
            if (i == 1) {
                a.a(u.group_title_find_group);
                a.a(false, false);
            } else if (i == 8) {
                a.a(u.group_tab_mygroup);
                a.a(false, false);
            }
            ((com.baidu.tbadk.core.e) this.a.getActivity()).a().a(TbadkApplication.m252getInst().getSkinType() == 1);
            ((com.baidu.tbadk.core.e) this.a.getActivity()).a().a(a.a());
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                imageView2 = a.d;
                imageView2.setImageResource(com.baidu.tieba.o.cp_bg_line_b_1);
            } else {
                imageView = a.d;
                imageView.setImageResource(com.baidu.tieba.o.cp_bg_line_b);
            }
            a.b();
            return a.a();
        }
        return null;
    }

    private View c(int i, View view, ViewGroup viewGroup) {
        o oVar;
        if (view == null) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(s.tab_my_group_item, viewGroup, false);
            oVar = new o();
            oVar.a = (LinearLayout) view.findViewById(r.click_head);
            oVar.g = (ImageView) view.findViewById(r.diver_top);
            oVar.h = (ImageView) view.findViewById(r.diver_top_px);
            oVar.b = (HeadImageView) view.findViewById(r.item_head);
            oVar.c = (TextView) view.findViewById(r.item_group_name);
            oVar.d = (TextView) view.findViewById(r.item_group_num);
            oVar.e = (TextView) view.findViewById(r.item_introduce);
            oVar.f = (TextView) view.findViewById(r.isCreator);
            oVar.i = (ImageView) view.findViewById(r.item_grade1);
            oVar.j = (ImageView) view.findViewById(r.item_grade2);
            oVar.k = (ImageView) view.findViewById(r.item_grade3);
            oVar.l = new ImageView[4];
            oVar.l[1] = oVar.i;
            oVar.l[2] = oVar.j;
            oVar.l[3] = oVar.k;
            view.setTag(oVar);
        } else {
            oVar = (o) view.getTag();
        }
        GroupInfoData groupInfoData = null;
        Object item = getItem(i);
        if (item != null && (item instanceof GroupInfoData)) {
            groupInfoData = (GroupInfoData) item;
        }
        oVar.b.setDefaultResource(com.baidu.tieba.q.avatar_poto_defaul140);
        oVar.b.setNightDefaultResource(com.baidu.tieba.q.avatar_poto_defaul140_1);
        oVar.b.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            oVar.b.setTag(portrait);
            if (this.b.d(portrait) != null) {
                oVar.b.invalidate();
            } else if (!this.c) {
                this.b.e(portrait, new m(this, view));
            }
            oVar.a.setOnClickListener(this.a);
            oVar.a.setTag(groupInfoData);
            if (this.d != null && i == getCount() - this.d.size()) {
                oVar.g.setVisibility(0);
                oVar.h.setVisibility(8);
            } else {
                oVar.g.setVisibility(8);
                oVar.h.setVisibility(0);
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
        ((com.baidu.tbadk.core.e) this.a.getActivity()).a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((com.baidu.tbadk.core.e) this.a.getActivity()).a().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            bc.a(oVar.c, com.baidu.tieba.o.cp_cont_b, 1);
            bc.c(oVar.i, com.baidu.tieba.q.icon_vip_grade_big_small_s);
            bc.c(oVar.j, com.baidu.tieba.q.icon_vip_grade_big_small_s);
            bc.c(oVar.k, com.baidu.tieba.q.icon_vip_grade_big_small_s);
        }
        return view;
    }

    private View d(int i, View view, ViewGroup viewGroup) {
        String str;
        n nVar = null;
        if (view != null) {
            nVar = (n) view.getTag();
        }
        if (nVar == null) {
            view = LayoutInflater.from(TbadkApplication.m252getInst().getApp().getApplicationContext()).inflate(s.group_tab_item, viewGroup, false);
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
                nVar2.b.setLeftIconRes(com.baidu.tieba.q.icon_nearby_group);
                nVar2.b.getRightIcon().setVisibility(8);
                nVar2.c.setVisibility(8);
                break;
            case 3:
                nVar2.b.setLineTopVisibility(false);
                nVar2.b.setLineTopPxVisibility(true);
                nVar2.b.setLineBottomPxVisibility(false);
                nVar2.b.setText(TbadkApplication.m252getInst().getApp().getResources().getString(u.group_tab_hotgroup));
                nVar2.b.setLeftIconRes(com.baidu.tieba.q.icon_hot_group);
                nVar2.b.getRightIcon().setVisibility(8);
                nVar2.c.setVisibility(8);
                break;
            case 4:
                nVar2.b.setLineTopVisibility(false);
                nVar2.b.setLineTopPxVisibility(true);
                nVar2.b.setLineBottomPxVisibility(false);
                nVar2.b.setText(TbadkApplication.m252getInst().getApp().getResources().getString(u.group_tab_living_btn));
                nVar2.b.setLeftIconRes(com.baidu.tieba.q.icon_live_telecast);
                nVar2.b.getRightIcon().setVisibility(8);
                nVar2.c.setVisibility(8);
                break;
            case 5:
                nVar2.b.setLineTopVisibility(false);
                nVar2.b.setLineTopPxVisibility(true);
                nVar2.b.setLineBottomPxVisibility(false);
                nVar2.b.setText(TbadkApplication.m252getInst().getApp().getResources().getString(u.group_tab_enterchatroom_btn));
                nVar2.b.setLeftIconRes(com.baidu.tieba.q.icon_come_chat);
                nVar2.b.getRightIcon().setVisibility(8);
                nVar2.c.setVisibility(8);
                break;
            case 6:
                nVar2.b.setLineTopVisibility(false);
                nVar2.b.setLineTopPxVisibility(true);
                nVar2.b.setLineBottomPxVisibility(false);
                nVar2.b.setText(TbadkApplication.m252getInst().getApp().getResources().getString(u.group_tab_addgroup));
                nVar2.b.setLeftIconRes(com.baidu.tieba.q.icon_qun_search);
                nVar2.b.getRightIcon().setVisibility(8);
                nVar2.c.setVisibility(0);
                break;
            case 7:
                nVar2.b.setLineTopVisibility(false);
                nVar2.b.setLineTopPxVisibility(true);
                nVar2.b.setLineBottomPxVisibility(true);
                nVar2.b.setText(TbadkApplication.m252getInst().getApp().getResources().getString(u.group_tab_creategroup));
                nVar2.b.setLeftIconRes(com.baidu.tieba.q.icon_add_group);
                nVar2.b.getRightIcon().setVisibility(8);
                nVar2.c.setVisibility(8);
                break;
        }
        nVar2.b.setTag(Integer.valueOf(i));
        ((com.baidu.tbadk.core.e) this.a.getActivity()).a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((com.baidu.tbadk.core.e) this.a.getActivity()).a().a(view);
        bc.f(nVar2.b, com.baidu.tieba.q.list_item_selector);
        bc.f(nVar2.a, com.baidu.tieba.o.cp_bg_line_d);
        nVar2.b.a(TbadkApplication.m252getInst().getSkinType());
        nVar2.b.setOnClickListener(this.a);
        bc.a(nVar2.b.getTextView(), com.baidu.tieba.o.cp_cont_b, 1);
        bc.c(nVar2.b.getRightIcon(), com.baidu.tieba.q.icon_ba_top_arrow_big);
        return view;
    }

    private void a(ImageView[] imageViewArr, int i) {
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
