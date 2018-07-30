package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> boB;
    private int boE = d.C0140d.cp_cont_b;
    private int boF = d.C0140d.cp_cont_c;
    private int boG = d.C0140d.cp_cont_d;
    private Drawable boH;
    private Drawable boI;
    private boolean boJ;
    private int bop;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.boJ = true;
        this.mContext = context;
        this.size = l.f(this.mContext, d.e.ds24);
        this.boJ = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.boB = list;
        notifyDataSetChanged();
    }

    public void gD(int i) {
        this.bop = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.boJ ? 3 : 2;
        return this.boB == null ? i : i + this.boB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gC */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.boJ ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.boB.get(i - i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 5;
        }
        if (i == 2 && this.boJ) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.Fv()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fu())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0129a c0129a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.boO = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.c(cVar3.boO, d.f.icon_new_friend);
            am.c(cVar3.title, this.boE, 1);
            am.i(cVar3.divider, d.C0140d.cp_bg_line_b);
            am.i(view, d.f.addresslist_item_bg);
            i((TextView) view.findViewById(d.g.addresslist_new_friend_message), this.bop);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.boO = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.c(cVar2.boO, d.f.icon_add_friend);
            am.c(cVar2.title, this.boE, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.j.find_new_friend));
            am.i(cVar2.divider, d.C0140d.cp_bg_line_b);
            am.i(view, d.f.addresslist_item_bg);
            ((TextView) view.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.boO = (ImageView) view.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(d.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.c(cVar.boO, d.f.icon_me_group);
            am.c(cVar.title, this.boE, 1);
            am.i(view, d.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.boN = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.Fv() != null) {
                    bVar.boN.setText(item.Fv());
                }
                am.c(bVar.boN, this.boF, 1);
                am.i(bVar.divider, d.C0140d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0129a)) {
                    C0129a c0129a2 = new C0129a();
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_child_item, (ViewGroup) null);
                    c0129a2.boC = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                    c0129a2.boD = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                    c0129a2.boK = (TextView) view.findViewById(d.g.detail_info_distance);
                    c0129a2.boL = (TextView) view.findViewById(d.g.detail_info_time);
                    c0129a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                    view.setTag(c0129a2);
                    c0129a = c0129a2;
                } else {
                    c0129a = (C0129a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0129a.boD.setText(item.getUserName());
                    c0129a.boC.startLoad(item.Fu(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().Fy() == 1) {
                        c0129a.boK.setVisibility(0);
                        am.c(c0129a.boK, this.boG, 1);
                        c0129a.boK.setText(this.mContext.getResources().getString(d.j.contact_yinshen));
                        c0129a.boK.setCompoundDrawables(null, null, null, null);
                        c0129a.boL.setVisibility(8);
                    } else if (item.getLbsInfo().Fy() == 0) {
                        if (!iL(item.getLbsInfo().Fx()) || !aG(item.getLbsInfo().getTime())) {
                            c0129a.boK.setVisibility(8);
                            c0129a.boL.setVisibility(8);
                        } else {
                            c0129a.boK.setVisibility(0);
                            c0129a.boL.setVisibility(0);
                            c0129a.boK.setText(item.getLbsInfo().Fx());
                            c0129a.boL.setText(ap.u(item.getLbsInfo().getTime()));
                            am.c(c0129a.boK, this.boG, 1);
                            this.boH = am.getDrawable(d.f.icon_friend_pin);
                            this.boH.setBounds(0, 0, this.size, this.size);
                            c0129a.boK.setCompoundDrawables(this.boH, null, null, null);
                            this.boI = am.getDrawable(d.f.icon_friend_time);
                            this.boI.setBounds(0, 0, this.size, this.size);
                            c0129a.boL.setCompoundDrawables(this.boI, null, null, null);
                            am.c(c0129a.boL, this.boG, 1);
                        }
                    } else {
                        c0129a.boK.setVisibility(8);
                        c0129a.boL.setVisibility(8);
                    }
                } else {
                    c0129a.boK.setVisibility(8);
                    c0129a.boL.setVisibility(8);
                }
                am.c(c0129a.boD, this.boE, 1);
                String Fv = item.Fv();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(Fv) || item2 == null || Fv.equals(item2.Fv())) ? false : true) {
                    c0129a.divider.setVisibility(4);
                } else {
                    c0129a.divider.setVisibility(0);
                    am.i(c0129a.divider, d.C0140d.cp_bg_line_b);
                }
                am.i(view, d.f.addresslist_item_bg);
                am.c(c0129a.boD, this.boE, 1);
                am.i(c0129a.divider, d.C0140d.cp_bg_line_b);
                am.i(view, d.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean iL(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aG(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void i(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        am.c(textView, d.C0140d.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = d.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = d.f.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = d.f.icon_news_head_prompt_two;
        }
        am.i(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView boO;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView boN;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0129a {
        HeadImageView boC;
        TextView boD;
        TextView boK;
        TextView boL;
        View divider;

        private C0129a() {
        }
    }
}
