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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> cOC;
    private int cOF = d.C0277d.cp_cont_b;
    private int cOG = d.C0277d.cp_cont_c;
    private int cOH = d.C0277d.cp_cont_d;
    private Drawable cOI;
    private Drawable cOJ;
    private boolean cOK;
    private int cOr;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.cOK = true;
        this.mContext = context;
        this.size = l.h(this.mContext, d.e.ds24);
        this.cOK = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cOC = list;
        notifyDataSetChanged();
    }

    public void lB(int i) {
        this.cOr = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.cOK ? 3 : 2;
        return this.cOC == null ? i : i + this.cOC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lA */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.cOK ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.cOC.get(i - i2);
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
        if (i == 2 && this.cOK) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.ajM()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.ajL())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0255a c0255a;
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
                cVar4.cOP = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            al.c(cVar3.cOP, d.f.icon_new_friend);
            al.d(cVar3.title, this.cOF, 1);
            al.k(cVar3.divider, d.C0277d.cp_bg_line_b);
            al.k(view, d.f.addresslist_item_bg);
            g((TextView) view.findViewById(d.g.addresslist_new_friend_message), this.cOr);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.cOP = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            al.c(cVar2.cOP, d.f.icon_add_friend);
            al.d(cVar2.title, this.cOF, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.j.find_new_friend));
            al.k(cVar2.divider, d.C0277d.cp_bg_line_b);
            al.k(view, d.f.addresslist_item_bg);
            ((TextView) view.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.cOP = (ImageView) view.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(d.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            al.c(cVar.cOP, d.f.icon_me_group);
            al.d(cVar.title, this.cOF, 1);
            al.k(view, d.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.cOO = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.ajM() != null) {
                    bVar.cOO.setText(item.ajM());
                }
                al.d(bVar.cOO, this.cOG, 1);
                al.k(bVar.divider, d.C0277d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0255a)) {
                    C0255a c0255a2 = new C0255a();
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_child_item, (ViewGroup) null);
                    c0255a2.cOD = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                    c0255a2.cOE = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                    c0255a2.cOL = (TextView) view.findViewById(d.g.detail_info_distance);
                    c0255a2.cOM = (TextView) view.findViewById(d.g.detail_info_time);
                    c0255a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                    view.setTag(c0255a2);
                    c0255a = c0255a2;
                } else {
                    c0255a = (C0255a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0255a.cOE.setText(item.getUserName());
                    c0255a.cOD.startLoad(item.ajL(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().ajO() == 1) {
                        c0255a.cOL.setVisibility(0);
                        al.d(c0255a.cOL, this.cOH, 1);
                        c0255a.cOL.setText(this.mContext.getResources().getString(d.j.contact_yinshen));
                        c0255a.cOL.setCompoundDrawables(null, null, null, null);
                        c0255a.cOM.setVisibility(8);
                    } else if (item.getLbsInfo().ajO() == 0) {
                        if (!qW(item.getLbsInfo().getDistance()) || !by(item.getLbsInfo().getTime())) {
                            c0255a.cOL.setVisibility(8);
                            c0255a.cOM.setVisibility(8);
                        } else {
                            c0255a.cOL.setVisibility(0);
                            c0255a.cOM.setVisibility(0);
                            c0255a.cOL.setText(item.getLbsInfo().getDistance());
                            c0255a.cOM.setText(ap.am(item.getLbsInfo().getTime()));
                            al.d(c0255a.cOL, this.cOH, 1);
                            this.cOI = al.getDrawable(d.f.icon_friend_pin);
                            this.cOI.setBounds(0, 0, this.size, this.size);
                            c0255a.cOL.setCompoundDrawables(this.cOI, null, null, null);
                            this.cOJ = al.getDrawable(d.f.icon_friend_time);
                            this.cOJ.setBounds(0, 0, this.size, this.size);
                            c0255a.cOM.setCompoundDrawables(this.cOJ, null, null, null);
                            al.d(c0255a.cOM, this.cOH, 1);
                        }
                    } else {
                        c0255a.cOL.setVisibility(8);
                        c0255a.cOM.setVisibility(8);
                    }
                } else {
                    c0255a.cOL.setVisibility(8);
                    c0255a.cOM.setVisibility(8);
                }
                al.d(c0255a.cOE, this.cOF, 1);
                String ajM = item.ajM();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(ajM) || item2 == null || ajM.equals(item2.ajM())) ? false : true) {
                    c0255a.divider.setVisibility(4);
                } else {
                    c0255a.divider.setVisibility(0);
                    al.k(c0255a.divider, d.C0277d.cp_bg_line_b);
                }
                al.k(view, d.f.addresslist_item_bg);
                al.d(c0255a.cOE, this.cOF, 1);
                al.k(c0255a.divider, d.C0277d.cp_bg_line_b);
                al.k(view, d.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean qW(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean by(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void g(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        al.d(textView, d.C0277d.common_color_10225, 1);
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
        al.k(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView cOP;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView cOO;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0255a {
        HeadImageView cOD;
        TextView cOE;
        TextView cOL;
        TextView cOM;
        View divider;

        private C0255a() {
        }
    }
}
