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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Drawable bmC;
    private Drawable bmD;
    private boolean bmE;
    private int bmk;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bmw;
    private Context mContext;
    private int size;
    private int bmz = d.C0141d.cp_cont_b;
    private int bmA = d.C0141d.cp_cont_c;
    private int bmB = d.C0141d.cp_cont_d;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bmE = true;
        this.mContext = context;
        this.size = l.e(this.mContext, d.e.ds24);
        this.bmE = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bmw = list;
        notifyDataSetChanged();
    }

    public void gw(int i) {
        this.bmk = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bmE ? 3 : 2;
        return this.bmw == null ? i : i + this.bmw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gv */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bmE ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.bmw.get(i - i2);
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
        if (i == 2 && this.bmE) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.Fh()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fg())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0130a c0130a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.bmJ = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            al.c(cVar3.bmJ, d.f.icon_new_friend);
            al.c(cVar3.title, this.bmz, 1);
            al.i(cVar3.divider, d.C0141d.cp_bg_line_b);
            al.i(view, d.f.addresslist_item_bg);
            i((TextView) view.findViewById(d.g.addresslist_new_friend_message), this.bmk);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bmJ = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            al.c(cVar2.bmJ, d.f.icon_add_friend);
            al.c(cVar2.title, this.bmz, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.k.find_new_friend));
            al.i(cVar2.divider, d.C0141d.cp_bg_line_b);
            al.i(view, d.f.addresslist_item_bg);
            ((TextView) view.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bmJ = (ImageView) view.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(d.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            al.c(cVar.bmJ, d.f.icon_me_group);
            al.c(cVar.title, this.bmz, 1);
            al.i(view, d.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.bmI = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.Fh() != null) {
                    bVar.bmI.setText(item.Fh());
                }
                al.c(bVar.bmI, this.bmA, 1);
                al.i(bVar.divider, d.C0141d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0130a)) {
                    C0130a c0130a2 = new C0130a();
                    view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_child_item, (ViewGroup) null);
                    c0130a2.bmx = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                    c0130a2.bmy = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                    c0130a2.bmF = (TextView) view.findViewById(d.g.detail_info_distance);
                    c0130a2.bmG = (TextView) view.findViewById(d.g.detail_info_time);
                    c0130a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                    view.setTag(c0130a2);
                    c0130a = c0130a2;
                } else {
                    c0130a = (C0130a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0130a.bmy.setText(item.getUserName());
                    c0130a.bmx.startLoad(item.Fg(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().Fk() == 1) {
                        c0130a.bmF.setVisibility(0);
                        al.c(c0130a.bmF, this.bmB, 1);
                        c0130a.bmF.setText(this.mContext.getResources().getString(d.k.contact_yinshen));
                        c0130a.bmF.setCompoundDrawables(null, null, null, null);
                        c0130a.bmG.setVisibility(8);
                    } else if (item.getLbsInfo().Fk() == 0) {
                        if (!iJ(item.getLbsInfo().Fj()) || !aC(item.getLbsInfo().getTime())) {
                            c0130a.bmF.setVisibility(8);
                            c0130a.bmG.setVisibility(8);
                        } else {
                            c0130a.bmF.setVisibility(0);
                            c0130a.bmG.setVisibility(0);
                            c0130a.bmF.setText(item.getLbsInfo().Fj());
                            c0130a.bmG.setText(ao.t(item.getLbsInfo().getTime()));
                            al.c(c0130a.bmF, this.bmB, 1);
                            this.bmC = al.getDrawable(d.f.icon_friend_pin);
                            this.bmC.setBounds(0, 0, this.size, this.size);
                            c0130a.bmF.setCompoundDrawables(this.bmC, null, null, null);
                            this.bmD = al.getDrawable(d.f.icon_friend_time);
                            this.bmD.setBounds(0, 0, this.size, this.size);
                            c0130a.bmG.setCompoundDrawables(this.bmD, null, null, null);
                            al.c(c0130a.bmG, this.bmB, 1);
                        }
                    } else {
                        c0130a.bmF.setVisibility(8);
                        c0130a.bmG.setVisibility(8);
                    }
                } else {
                    c0130a.bmF.setVisibility(8);
                    c0130a.bmG.setVisibility(8);
                }
                al.c(c0130a.bmy, this.bmz, 1);
                String Fh = item.Fh();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(Fh) || item2 == null || Fh.equals(item2.Fh())) ? false : true) {
                    c0130a.divider.setVisibility(4);
                } else {
                    c0130a.divider.setVisibility(0);
                    al.i(c0130a.divider, d.C0141d.cp_bg_line_b);
                }
                al.i(view, d.f.addresslist_item_bg);
                al.c(c0130a.bmy, this.bmz, 1);
                al.i(c0130a.divider, d.C0141d.cp_bg_line_b);
                al.i(view, d.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean iJ(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aC(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void i(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        al.c(textView, d.C0141d.common_color_10225, 1);
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
        al.i(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView bmJ;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView bmI;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0130a {
        TextView bmF;
        TextView bmG;
        HeadImageView bmx;
        TextView bmy;
        View divider;

        private C0130a() {
        }
    }
}
