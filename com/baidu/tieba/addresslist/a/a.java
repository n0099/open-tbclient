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
    private int bdZ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bem;
    private int bep = d.C0126d.cp_cont_b;
    private int beq = d.C0126d.cp_cont_c;
    private int ber = d.C0126d.cp_cont_d;
    private Drawable bes;
    private Drawable beu;
    private boolean bev;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bev = true;
        this.mContext = context;
        this.size = l.e(this.mContext, d.e.ds24);
        this.bev = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bem = list;
        notifyDataSetChanged();
    }

    public void gv(int i) {
        this.bdZ = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bev ? 3 : 2;
        return this.bem == null ? i : i + this.bem.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gu */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bev ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.bem.get(i - i2);
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
        if (i == 2 && this.bev) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.BI()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.BH())) ? 2 : 3;
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
                cVar4.beA = (ImageView) view2.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view2.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view2.findViewById(d.g.addresslist_new_friend_divider);
                view2.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view2.getTag();
            }
            ak.c(cVar3.beA, d.f.icon_new_friend);
            ak.c(cVar3.title, this.bep, 1);
            ak.i(cVar3.divider, d.C0126d.cp_bg_line_b);
            ak.i(view2, d.f.addresslist_item_bg);
            i((TextView) view2.findViewById(d.g.addresslist_new_friend_message), this.bdZ);
            return view2;
        } else if (getItemViewType(i) == 5) {
            if (view2 == 0 || view2.getTag() == null || !(view2.getTag() instanceof c)) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.beA = (ImageView) view2.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view2.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view2.findViewById(d.g.addresslist_new_friend_divider);
                view2.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view2.getTag();
            }
            ak.c(cVar2.beA, d.f.icon_add_friend);
            ak.c(cVar2.title, this.bep, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.k.find_new_friend));
            ak.i(cVar2.divider, d.C0126d.cp_bg_line_b);
            ak.i(view2, d.f.addresslist_item_bg);
            ((TextView) view2.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view2;
        } else if (getItemViewType(i) == 1) {
            if (view2 == 0 || view2.getTag() == null || !(view2.getTag() instanceof c)) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.beA = (ImageView) view2.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view2.findViewById(d.g.addresslist_my_groups_text);
                view2.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view2.getTag();
            }
            ak.c(cVar.beA, d.f.icon_me_group);
            ak.c(cVar.title, this.bep, 1);
            ak.i(view2, d.f.addresslist_item_bg);
            return view2;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof b)) {
                    view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.bez = (TextView) view2.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view2.findViewById(d.g.addresslist_group_item_divider);
                    view2.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view2.getTag();
                }
                if (item.BI() != null) {
                    bVar.bez.setText(item.BI());
                }
                ak.c(bVar.bez, this.beq, 1);
                ak.i(bVar.divider, d.C0126d.cp_bg_line_b);
                return view2;
            } else if (getItemViewType(i) == 3) {
                if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof C0114a)) {
                    C0114a c0114a2 = new C0114a();
                    view2 = LayoutInflater.from(this.mContext).inflate(d.i.addresslist_child_item, (ViewGroup) null);
                    c0114a2.ben = (HeadImageView) view2.findViewById(d.g.addresslist_child_item_icon);
                    c0114a2.beo = (TextView) view2.findViewById(d.g.addresslist_child_item_name);
                    c0114a2.bew = (TextView) view2.findViewById(d.g.detail_info_distance);
                    c0114a2.bex = (TextView) view2.findViewById(d.g.detail_info_time);
                    c0114a2.divider = view2.findViewById(d.g.addresslist_child_item_divider);
                    view2.setTag(c0114a2);
                    c0114a = c0114a2;
                } else {
                    c0114a = (C0114a) view2.getTag();
                }
                if (item.getUserName() != null) {
                    c0114a.beo.setText(item.getUserName());
                    c0114a.ben.startLoad(item.BH(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().BK() == 1) {
                        c0114a.bew.setVisibility(0);
                        ak.c(c0114a.bew, this.ber, 1);
                        c0114a.bew.setText(this.mContext.getResources().getString(d.k.contact_yinshen));
                        c0114a.bew.setCompoundDrawables(null, null, null, null);
                        c0114a.bex.setVisibility(8);
                    } else if (item.getLbsInfo().BK() == 0) {
                        if (!ig(item.getLbsInfo().BJ()) || !ay(item.getLbsInfo().getTime())) {
                            c0114a.bew.setVisibility(8);
                            c0114a.bex.setVisibility(8);
                        } else {
                            c0114a.bew.setVisibility(0);
                            c0114a.bex.setVisibility(0);
                            c0114a.bew.setText(item.getLbsInfo().BJ());
                            c0114a.bex.setText(an.q(item.getLbsInfo().getTime()));
                            ak.c(c0114a.bew, this.ber, 1);
                            this.bes = ak.getDrawable(d.f.icon_friend_pin);
                            this.bes.setBounds(0, 0, this.size, this.size);
                            c0114a.bew.setCompoundDrawables(this.bes, null, null, null);
                            this.beu = ak.getDrawable(d.f.icon_friend_time);
                            this.beu.setBounds(0, 0, this.size, this.size);
                            c0114a.bex.setCompoundDrawables(this.beu, null, null, null);
                            ak.c(c0114a.bex, this.ber, 1);
                        }
                    } else {
                        c0114a.bew.setVisibility(8);
                        c0114a.bex.setVisibility(8);
                    }
                } else {
                    c0114a.bew.setVisibility(8);
                    c0114a.bex.setVisibility(8);
                }
                ak.c(c0114a.beo, this.bep, 1);
                String BI = item.BI();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(BI) || item2 == null || BI.equals(item2.BI())) ? false : true) {
                    c0114a.divider.setVisibility(4);
                } else {
                    c0114a.divider.setVisibility(0);
                    ak.i(c0114a.divider, d.C0126d.cp_bg_line_b);
                }
                ak.i(view2, d.f.addresslist_item_bg);
                ak.c(c0114a.beo, this.bep, 1);
                ak.i(c0114a.divider, d.C0126d.cp_bg_line_b);
                ak.i(view2, d.f.addresslist_item_bg);
                return view2;
            } else {
                return null;
            }
        }
    }

    public boolean ig(String str) {
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
        ImageView beA;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView bez;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0114a {
        HeadImageView ben;
        TextView beo;
        TextView bew;
        TextView bex;
        View divider;

        private C0114a() {
        }
    }
}
