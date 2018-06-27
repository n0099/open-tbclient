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
    private int bnJ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bnV;
    private int bnY = d.C0142d.cp_cont_b;
    private int bnZ = d.C0142d.cp_cont_c;
    private int boa = d.C0142d.cp_cont_d;
    private Drawable bob;
    private Drawable boc;
    private boolean bod;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bod = true;
        this.mContext = context;
        this.size = l.e(this.mContext, d.e.ds24);
        this.bod = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bnV = list;
        notifyDataSetChanged();
    }

    public void gx(int i) {
        this.bnJ = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bod ? 3 : 2;
        return this.bnV == null ? i : i + this.bnV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gw */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bod ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.bnV.get(i - i2);
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
        if (i == 2 && this.bod) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.Fz()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fy())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0131a c0131a;
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
                cVar4.boi = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.c(cVar3.boi, d.f.icon_new_friend);
            am.c(cVar3.title, this.bnY, 1);
            am.i(cVar3.divider, d.C0142d.cp_bg_line_b);
            am.i(view, d.f.addresslist_item_bg);
            i((TextView) view.findViewById(d.g.addresslist_new_friend_message), this.bnJ);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.boi = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.c(cVar2.boi, d.f.icon_add_friend);
            am.c(cVar2.title, this.bnY, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.k.find_new_friend));
            am.i(cVar2.divider, d.C0142d.cp_bg_line_b);
            am.i(view, d.f.addresslist_item_bg);
            ((TextView) view.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.boi = (ImageView) view.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(d.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.c(cVar.boi, d.f.icon_me_group);
            am.c(cVar.title, this.bnY, 1);
            am.i(view, d.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.boh = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.Fz() != null) {
                    bVar.boh.setText(item.Fz());
                }
                am.c(bVar.boh, this.bnZ, 1);
                am.i(bVar.divider, d.C0142d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0131a)) {
                    C0131a c0131a2 = new C0131a();
                    view = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_child_item, (ViewGroup) null);
                    c0131a2.bnW = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                    c0131a2.bnX = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                    c0131a2.boe = (TextView) view.findViewById(d.g.detail_info_distance);
                    c0131a2.bof = (TextView) view.findViewById(d.g.detail_info_time);
                    c0131a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                    view.setTag(c0131a2);
                    c0131a = c0131a2;
                } else {
                    c0131a = (C0131a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0131a.bnX.setText(item.getUserName());
                    c0131a.bnW.startLoad(item.Fy(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().FC() == 1) {
                        c0131a.boe.setVisibility(0);
                        am.c(c0131a.boe, this.boa, 1);
                        c0131a.boe.setText(this.mContext.getResources().getString(d.k.contact_yinshen));
                        c0131a.boe.setCompoundDrawables(null, null, null, null);
                        c0131a.bof.setVisibility(8);
                    } else if (item.getLbsInfo().FC() == 0) {
                        if (!iO(item.getLbsInfo().FB()) || !aD(item.getLbsInfo().getTime())) {
                            c0131a.boe.setVisibility(8);
                            c0131a.bof.setVisibility(8);
                        } else {
                            c0131a.boe.setVisibility(0);
                            c0131a.bof.setVisibility(0);
                            c0131a.boe.setText(item.getLbsInfo().FB());
                            c0131a.bof.setText(ap.u(item.getLbsInfo().getTime()));
                            am.c(c0131a.boe, this.boa, 1);
                            this.bob = am.getDrawable(d.f.icon_friend_pin);
                            this.bob.setBounds(0, 0, this.size, this.size);
                            c0131a.boe.setCompoundDrawables(this.bob, null, null, null);
                            this.boc = am.getDrawable(d.f.icon_friend_time);
                            this.boc.setBounds(0, 0, this.size, this.size);
                            c0131a.bof.setCompoundDrawables(this.boc, null, null, null);
                            am.c(c0131a.bof, this.boa, 1);
                        }
                    } else {
                        c0131a.boe.setVisibility(8);
                        c0131a.bof.setVisibility(8);
                    }
                } else {
                    c0131a.boe.setVisibility(8);
                    c0131a.bof.setVisibility(8);
                }
                am.c(c0131a.bnX, this.bnY, 1);
                String Fz = item.Fz();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(Fz) || item2 == null || Fz.equals(item2.Fz())) ? false : true) {
                    c0131a.divider.setVisibility(4);
                } else {
                    c0131a.divider.setVisibility(0);
                    am.i(c0131a.divider, d.C0142d.cp_bg_line_b);
                }
                am.i(view, d.f.addresslist_item_bg);
                am.c(c0131a.bnX, this.bnY, 1);
                am.i(c0131a.divider, d.C0142d.cp_bg_line_b);
                am.i(view, d.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean iO(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aD(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void i(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        am.c(textView, d.C0142d.common_color_10225, 1);
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
        ImageView boi;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView boh;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0131a {
        HeadImageView bnW;
        TextView bnX;
        TextView boe;
        TextView bof;
        View divider;

        private C0131a() {
        }
    }
}
