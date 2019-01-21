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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Drawable bDB;
    private Drawable bDC;
    private boolean bDD;
    private int bDk;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bDv;
    private Context mContext;
    private int size;
    private int bDy = e.d.cp_cont_b;
    private int bDz = e.d.cp_cont_c;
    private int bDA = e.d.cp_cont_d;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bDD = true;
        this.mContext = context;
        this.size = l.h(this.mContext, e.C0210e.ds24);
        this.bDD = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bDv = list;
        notifyDataSetChanged();
    }

    public void hM(int i) {
        this.bDk = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bDD ? 3 : 2;
        return this.bDv == null ? i : i + this.bDv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hL */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bDD ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.bDv.get(i - i2);
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
        if (i == 2 && this.bDD) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.Ks()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Kr())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0187a c0187a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.bDI = (ImageView) view.findViewById(e.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(e.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(e.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            al.c(cVar3.bDI, e.f.icon_new_friend);
            al.c(cVar3.title, this.bDy, 1);
            al.i(cVar3.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.addresslist_item_bg);
            i((TextView) view.findViewById(e.g.addresslist_new_friend_message), this.bDk);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bDI = (ImageView) view.findViewById(e.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(e.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(e.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            al.c(cVar2.bDI, e.f.icon_add_friend);
            al.c(cVar2.title, this.bDy, 1);
            cVar2.title.setText(this.mContext.getResources().getString(e.j.find_new_friend));
            al.i(cVar2.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.addresslist_item_bg);
            ((TextView) view.findViewById(e.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bDI = (ImageView) view.findViewById(e.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(e.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            al.c(cVar.bDI, e.f.icon_me_group);
            al.c(cVar.title, this.bDy, 1);
            al.i(view, e.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.bDH = (TextView) view.findViewById(e.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(e.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.Ks() != null) {
                    bVar.bDH.setText(item.Ks());
                }
                al.c(bVar.bDH, this.bDz, 1);
                al.i(bVar.divider, e.d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0187a)) {
                    C0187a c0187a2 = new C0187a();
                    view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_child_item, (ViewGroup) null);
                    c0187a2.bDw = (HeadImageView) view.findViewById(e.g.addresslist_child_item_icon);
                    c0187a2.bDx = (TextView) view.findViewById(e.g.addresslist_child_item_name);
                    c0187a2.bDE = (TextView) view.findViewById(e.g.detail_info_distance);
                    c0187a2.bDF = (TextView) view.findViewById(e.g.detail_info_time);
                    c0187a2.divider = view.findViewById(e.g.addresslist_child_item_divider);
                    view.setTag(c0187a2);
                    c0187a = c0187a2;
                } else {
                    c0187a = (C0187a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0187a.bDx.setText(item.getUserName());
                    c0187a.bDw.startLoad(item.Kr(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().Kv() == 1) {
                        c0187a.bDE.setVisibility(0);
                        al.c(c0187a.bDE, this.bDA, 1);
                        c0187a.bDE.setText(this.mContext.getResources().getString(e.j.contact_yinshen));
                        c0187a.bDE.setCompoundDrawables(null, null, null, null);
                        c0187a.bDF.setVisibility(8);
                    } else if (item.getLbsInfo().Kv() == 0) {
                        if (!km(item.getLbsInfo().Ku()) || !aW(item.getLbsInfo().getTime())) {
                            c0187a.bDE.setVisibility(8);
                            c0187a.bDF.setVisibility(8);
                        } else {
                            c0187a.bDE.setVisibility(0);
                            c0187a.bDF.setVisibility(0);
                            c0187a.bDE.setText(item.getLbsInfo().Ku());
                            c0187a.bDF.setText(ao.K(item.getLbsInfo().getTime()));
                            al.c(c0187a.bDE, this.bDA, 1);
                            this.bDB = al.getDrawable(e.f.icon_friend_pin);
                            this.bDB.setBounds(0, 0, this.size, this.size);
                            c0187a.bDE.setCompoundDrawables(this.bDB, null, null, null);
                            this.bDC = al.getDrawable(e.f.icon_friend_time);
                            this.bDC.setBounds(0, 0, this.size, this.size);
                            c0187a.bDF.setCompoundDrawables(this.bDC, null, null, null);
                            al.c(c0187a.bDF, this.bDA, 1);
                        }
                    } else {
                        c0187a.bDE.setVisibility(8);
                        c0187a.bDF.setVisibility(8);
                    }
                } else {
                    c0187a.bDE.setVisibility(8);
                    c0187a.bDF.setVisibility(8);
                }
                al.c(c0187a.bDx, this.bDy, 1);
                String Ks = item.Ks();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(Ks) || item2 == null || Ks.equals(item2.Ks())) ? false : true) {
                    c0187a.divider.setVisibility(4);
                } else {
                    c0187a.divider.setVisibility(0);
                    al.i(c0187a.divider, e.d.cp_bg_line_b);
                }
                al.i(view, e.f.addresslist_item_bg);
                al.c(c0187a.bDx, this.bDy, 1);
                al.i(c0187a.divider, e.d.cp_bg_line_b);
                al.i(view, e.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean km(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aW(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void i(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        al.c(textView, e.d.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = e.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = e.f.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = e.f.icon_news_head_prompt_two;
        }
        al.i(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView bDI;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView bDH;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0187a {
        TextView bDE;
        TextView bDF;
        HeadImageView bDw;
        TextView bDx;
        View divider;

        private C0187a() {
        }
    }
}
