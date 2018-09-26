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
    private Drawable buA;
    private boolean buB;
    private int buh;
    private List<com.baidu.tbadk.coreExtra.relationship.a> but;
    private int buw = e.d.cp_cont_b;
    private int bux = e.d.cp_cont_c;
    private int buy = e.d.cp_cont_d;
    private Drawable buz;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.buB = true;
        this.mContext = context;
        this.size = l.h(this.mContext, e.C0141e.ds24);
        this.buB = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.but = list;
        notifyDataSetChanged();
    }

    public void hc(int i) {
        this.buh = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.buB ? 3 : 2;
        return this.but == null ? i : i + this.but.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hb */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.buB ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.but.get(i - i2);
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
        if (i == 2 && this.buB) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.GL()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.GK())) ? 2 : 3;
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
                view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.buG = (ImageView) view.findViewById(e.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(e.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(e.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            al.c(cVar3.buG, e.f.icon_new_friend);
            al.c(cVar3.title, this.buw, 1);
            al.i(cVar3.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.addresslist_item_bg);
            i((TextView) view.findViewById(e.g.addresslist_new_friend_message), this.buh);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.buG = (ImageView) view.findViewById(e.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(e.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(e.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            al.c(cVar2.buG, e.f.icon_add_friend);
            al.c(cVar2.title, this.buw, 1);
            cVar2.title.setText(this.mContext.getResources().getString(e.j.find_new_friend));
            al.i(cVar2.divider, e.d.cp_bg_line_b);
            al.i(view, e.f.addresslist_item_bg);
            ((TextView) view.findViewById(e.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.buG = (ImageView) view.findViewById(e.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(e.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            al.c(cVar.buG, e.f.icon_me_group);
            al.c(cVar.title, this.buw, 1);
            al.i(view, e.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.buF = (TextView) view.findViewById(e.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(e.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.GL() != null) {
                    bVar.buF.setText(item.GL());
                }
                al.c(bVar.buF, this.bux, 1);
                al.i(bVar.divider, e.d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0129a)) {
                    C0129a c0129a2 = new C0129a();
                    view = LayoutInflater.from(this.mContext).inflate(e.h.addresslist_child_item, (ViewGroup) null);
                    c0129a2.buu = (HeadImageView) view.findViewById(e.g.addresslist_child_item_icon);
                    c0129a2.buv = (TextView) view.findViewById(e.g.addresslist_child_item_name);
                    c0129a2.buC = (TextView) view.findViewById(e.g.detail_info_distance);
                    c0129a2.buD = (TextView) view.findViewById(e.g.detail_info_time);
                    c0129a2.divider = view.findViewById(e.g.addresslist_child_item_divider);
                    view.setTag(c0129a2);
                    c0129a = c0129a2;
                } else {
                    c0129a = (C0129a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0129a.buv.setText(item.getUserName());
                    c0129a.buu.startLoad(item.GK(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().GO() == 1) {
                        c0129a.buC.setVisibility(0);
                        al.c(c0129a.buC, this.buy, 1);
                        c0129a.buC.setText(this.mContext.getResources().getString(e.j.contact_yinshen));
                        c0129a.buC.setCompoundDrawables(null, null, null, null);
                        c0129a.buD.setVisibility(8);
                    } else if (item.getLbsInfo().GO() == 0) {
                        if (!jo(item.getLbsInfo().GN()) || !aK(item.getLbsInfo().getTime())) {
                            c0129a.buC.setVisibility(8);
                            c0129a.buD.setVisibility(8);
                        } else {
                            c0129a.buC.setVisibility(0);
                            c0129a.buD.setVisibility(0);
                            c0129a.buC.setText(item.getLbsInfo().GN());
                            c0129a.buD.setText(ao.y(item.getLbsInfo().getTime()));
                            al.c(c0129a.buC, this.buy, 1);
                            this.buz = al.getDrawable(e.f.icon_friend_pin);
                            this.buz.setBounds(0, 0, this.size, this.size);
                            c0129a.buC.setCompoundDrawables(this.buz, null, null, null);
                            this.buA = al.getDrawable(e.f.icon_friend_time);
                            this.buA.setBounds(0, 0, this.size, this.size);
                            c0129a.buD.setCompoundDrawables(this.buA, null, null, null);
                            al.c(c0129a.buD, this.buy, 1);
                        }
                    } else {
                        c0129a.buC.setVisibility(8);
                        c0129a.buD.setVisibility(8);
                    }
                } else {
                    c0129a.buC.setVisibility(8);
                    c0129a.buD.setVisibility(8);
                }
                al.c(c0129a.buv, this.buw, 1);
                String GL = item.GL();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(GL) || item2 == null || GL.equals(item2.GL())) ? false : true) {
                    c0129a.divider.setVisibility(4);
                } else {
                    c0129a.divider.setVisibility(0);
                    al.i(c0129a.divider, e.d.cp_bg_line_b);
                }
                al.i(view, e.f.addresslist_item_bg);
                al.c(c0129a.buv, this.buw, 1);
                al.i(c0129a.divider, e.d.cp_bg_line_b);
                al.i(view, e.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean jo(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aK(long j) {
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
        ImageView buG;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView buF;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0129a {
        TextView buC;
        TextView buD;
        HeadImageView buu;
        TextView buv;
        View divider;

        private C0129a() {
        }
    }
}
