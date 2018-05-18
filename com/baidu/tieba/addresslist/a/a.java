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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int bea;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ben;
    private int beq = d.C0126d.cp_cont_b;
    private int ber = d.C0126d.cp_cont_c;
    private int bes = d.C0126d.cp_cont_d;
    private Drawable beu;
    private Drawable bev;
    private boolean bew;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bew = true;
        this.mContext = context;
        this.size = l.e(this.mContext, d.e.ds24);
        this.bew = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ben = list;
        notifyDataSetChanged();
    }

    public void gv(int i) {
        this.bea = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bew ? 3 : 2;
        return this.ben == null ? i : i + this.ben.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gu */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bew ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.ben.get(i - i2);
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
        if (i == 2 && this.bew) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.BG()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.BF())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0114a c0114a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view2 == 0 || view2.getTag() == null || !(view2.getTag() instanceof c)) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.beB = (ImageView) view2.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view2.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view2.findViewById(d.g.addresslist_new_friend_divider);
                view2.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view2.getTag();
            }
            ak.c(cVar3.beB, d.f.icon_new_friend);
            ak.c(cVar3.title, this.beq, 1);
            ak.i(cVar3.divider, d.C0126d.cp_bg_line_b);
            ak.i(view2, d.f.addresslist_item_bg);
            i((TextView) view2.findViewById(d.g.addresslist_new_friend_message), this.bea);
            return view2;
        } else if (getItemViewType(i) == 5) {
            if (view2 == 0 || view2.getTag() == null || !(view2.getTag() instanceof c)) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.beB = (ImageView) view2.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view2.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view2.findViewById(d.g.addresslist_new_friend_divider);
                view2.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view2.getTag();
            }
            ak.c(cVar2.beB, d.f.icon_add_friend);
            ak.c(cVar2.title, this.beq, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.k.find_new_friend));
            ak.i(cVar2.divider, d.C0126d.cp_bg_line_b);
            ak.i(view2, d.f.addresslist_item_bg);
            ((TextView) view2.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view2;
        } else if (getItemViewType(i) == 1) {
            if (view2 == 0 || view2.getTag() == null || !(view2.getTag() instanceof c)) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.beB = (ImageView) view2.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view2.findViewById(d.g.addresslist_my_groups_text);
                view2.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view2.getTag();
            }
            ak.c(cVar.beB, d.f.icon_me_group);
            ak.c(cVar.title, this.beq, 1);
            ak.i(view2, d.f.addresslist_item_bg);
            return view2;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof b)) {
                    view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.beA = (TextView) view2.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view2.findViewById(d.g.addresslist_group_item_divider);
                    view2.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view2.getTag();
                }
                if (item.BG() != null) {
                    bVar.beA.setText(item.BG());
                }
                ak.c(bVar.beA, this.ber, 1);
                ak.i(bVar.divider, d.C0126d.cp_bg_line_b);
                return view2;
            } else if (getItemViewType(i) == 3) {
                if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof C0114a)) {
                    C0114a c0114a2 = new C0114a();
                    view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_child_item, (ViewGroup) null);
                    c0114a2.beo = (HeadImageView) view2.findViewById(d.g.addresslist_child_item_icon);
                    c0114a2.bep = (TextView) view2.findViewById(d.g.addresslist_child_item_name);
                    c0114a2.bex = (TextView) view2.findViewById(d.g.detail_info_distance);
                    c0114a2.bey = (TextView) view2.findViewById(d.g.detail_info_time);
                    c0114a2.divider = view2.findViewById(d.g.addresslist_child_item_divider);
                    view2.setTag(c0114a2);
                    c0114a = c0114a2;
                } else {
                    c0114a = (C0114a) view2.getTag();
                }
                if (item.getUserName() != null) {
                    c0114a.bep.setText(item.getUserName());
                    c0114a.beo.startLoad(item.BF(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().BI() == 1) {
                        c0114a.bex.setVisibility(0);
                        ak.c(c0114a.bex, this.bes, 1);
                        c0114a.bex.setText(this.mContext.getResources().getString(d.k.contact_yinshen));
                        c0114a.bex.setCompoundDrawables(null, null, null, null);
                        c0114a.bey.setVisibility(8);
                    } else if (item.getLbsInfo().BI() == 0) {
                        if (!ih(item.getLbsInfo().BH()) || !ay(item.getLbsInfo().getTime())) {
                            c0114a.bex.setVisibility(8);
                            c0114a.bey.setVisibility(8);
                        } else {
                            c0114a.bex.setVisibility(0);
                            c0114a.bey.setVisibility(0);
                            c0114a.bex.setText(item.getLbsInfo().BH());
                            c0114a.bey.setText(an.q(item.getLbsInfo().getTime()));
                            ak.c(c0114a.bex, this.bes, 1);
                            this.beu = ak.getDrawable(d.f.icon_friend_pin);
                            this.beu.setBounds(0, 0, this.size, this.size);
                            c0114a.bex.setCompoundDrawables(this.beu, null, null, null);
                            this.bev = ak.getDrawable(d.f.icon_friend_time);
                            this.bev.setBounds(0, 0, this.size, this.size);
                            c0114a.bey.setCompoundDrawables(this.bev, null, null, null);
                            ak.c(c0114a.bey, this.bes, 1);
                        }
                    } else {
                        c0114a.bex.setVisibility(8);
                        c0114a.bey.setVisibility(8);
                    }
                } else {
                    c0114a.bex.setVisibility(8);
                    c0114a.bey.setVisibility(8);
                }
                ak.c(c0114a.bep, this.beq, 1);
                String BG = item.BG();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(BG) || item2 == null || BG.equals(item2.BG())) ? false : true) {
                    c0114a.divider.setVisibility(4);
                } else {
                    c0114a.divider.setVisibility(0);
                    ak.i(c0114a.divider, d.C0126d.cp_bg_line_b);
                }
                ak.i(view2, d.f.addresslist_item_bg);
                ak.c(c0114a.bep, this.beq, 1);
                ak.i(c0114a.divider, d.C0126d.cp_bg_line_b);
                ak.i(view2, d.f.addresslist_item_bg);
                return view2;
            } else {
                return null;
            }
        }
    }

    public boolean ih(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean ay(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void i(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ak.c(textView, d.C0126d.common_color_10225, 1);
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
        ak.i(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView beB;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView beA;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0114a {
        HeadImageView beo;
        TextView bep;
        TextView bex;
        TextView bey;
        View divider;

        private C0114a() {
        }
    }
}
