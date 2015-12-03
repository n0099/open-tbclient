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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private int aHM;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aHZ;
    private int aIc = n.c.cp_cont_b;
    private int aId = n.c.cp_cont_c;
    private int aIe = n.c.cp_cont_d;
    private Drawable aIf;
    private Drawable aIg;
    private boolean aIh;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.aIh = true;
        this.mContext = context;
        this.size = k.d(this.mContext, n.d.ds24);
        this.aIh = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aHZ = list;
        notifyDataSetChanged();
    }

    public void fe(int i) {
        this.aHM = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.aIh ? 3 : 2;
        return this.aHZ == null ? i : i + this.aHZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fd */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.aIh ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.aHZ.get(i - i2);
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
        if (i == 2 && this.aIh) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.zv()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0058a c0058a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(n.g.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c(this, null);
                cVar4.aIm = (ImageView) view.findViewById(n.f.addresslist_new_friend_icon);
                cVar4.agd = (TextView) view.findViewById(n.f.addresslist_new_friend_text);
                cVar4.Yb = view.findViewById(n.f.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            as.c(cVar3.aIm, n.e.icon_new_friend);
            as.b(cVar3.agd, this.aIc, 1);
            as.i(cVar3.Yb, n.c.cp_bg_line_b);
            as.i(view, n.e.addresslist_item_bg);
            l((TextView) view.findViewById(n.f.addresslist_new_friend_message), this.aHM);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(n.g.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c(this, null);
                cVar5.aIm = (ImageView) view.findViewById(n.f.addresslist_new_friend_icon);
                cVar5.agd = (TextView) view.findViewById(n.f.addresslist_new_friend_text);
                cVar5.Yb = view.findViewById(n.f.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            as.c(cVar2.aIm, n.e.icon_add_friend);
            as.b(cVar2.agd, this.aIc, 1);
            cVar2.agd.setText(this.mContext.getResources().getString(n.i.find_new_friend));
            as.i(cVar2.Yb, n.c.cp_bg_line_b);
            as.i(view, n.e.addresslist_item_bg);
            ((TextView) view.findViewById(n.f.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(n.g.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c(this, null);
                cVar6.aIm = (ImageView) view.findViewById(n.f.addresslist_my_groups_icon);
                cVar6.agd = (TextView) view.findViewById(n.f.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            as.c(cVar.aIm, n.e.icon_me_group);
            as.b(cVar.agd, this.aIc, 1);
            as.i(view, n.e.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(n.g.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b(this, null);
                    bVar2.aIl = (TextView) view.findViewById(n.f.addresslist_group_item_key);
                    bVar2.Yb = view.findViewById(n.f.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.zv() != null) {
                    bVar.aIl.setText(item.zv());
                }
                as.b(bVar.aIl, this.aId, 1);
                as.i(bVar.Yb, n.c.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0058a)) {
                    C0058a c0058a2 = new C0058a(this, null);
                    view = LayoutInflater.from(this.mContext).inflate(n.g.addresslist_child_item, (ViewGroup) null);
                    c0058a2.aIa = (HeadImageView) view.findViewById(n.f.addresslist_child_item_icon);
                    c0058a2.aIb = (TextView) view.findViewById(n.f.addresslist_child_item_name);
                    c0058a2.aIi = (TextView) view.findViewById(n.f.detail_info_distance);
                    c0058a2.aIj = (TextView) view.findViewById(n.f.detail_info_time);
                    c0058a2.Yb = view.findViewById(n.f.addresslist_child_item_divider);
                    view.setTag(c0058a2);
                    c0058a = c0058a2;
                } else {
                    c0058a = (C0058a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0058a.aIb.setText(item.getUserName());
                    c0058a.aIa.d(item.getUserPortrait(), 12, false);
                }
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().zw() == 1) {
                        c0058a.aIi.setVisibility(0);
                        as.b(c0058a.aIi, this.aIe, 1);
                        c0058a.aIi.setText(this.mContext.getResources().getString(n.i.contact_yinshen));
                        c0058a.aIi.setCompoundDrawables(null, null, null, null);
                        c0058a.aIj.setVisibility(8);
                    } else if (item.getLbsInfo().zw() == 0) {
                        if (!gm(item.getLbsInfo().getDistance()) || !af(item.getLbsInfo().getTime())) {
                            c0058a.aIi.setVisibility(8);
                            c0058a.aIj.setVisibility(8);
                        } else {
                            c0058a.aIi.setVisibility(0);
                            c0058a.aIj.setVisibility(0);
                            c0058a.aIi.setText(item.getLbsInfo().getDistance());
                            c0058a.aIj.setText(ax.r(item.getLbsInfo().getTime()));
                            as.b(c0058a.aIi, this.aIe, 1);
                            this.aIf = as.getDrawable(n.e.icon_friend_pin);
                            this.aIf.setBounds(0, 0, this.size, this.size);
                            c0058a.aIi.setCompoundDrawables(this.aIf, null, null, null);
                            this.aIg = as.getDrawable(n.e.icon_friend_time);
                            this.aIg.setBounds(0, 0, this.size, this.size);
                            c0058a.aIj.setCompoundDrawables(this.aIg, null, null, null);
                            as.b(c0058a.aIj, this.aIe, 1);
                        }
                    } else {
                        c0058a.aIi.setVisibility(8);
                        c0058a.aIj.setVisibility(8);
                    }
                } else {
                    c0058a.aIi.setVisibility(8);
                    c0058a.aIj.setVisibility(8);
                }
                as.b(c0058a.aIb, this.aIc, 1);
                String zv = item.zv();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(zv) || item2 == null || zv.equals(item2.zv())) ? false : true) {
                    c0058a.Yb.setVisibility(4);
                } else {
                    c0058a.Yb.setVisibility(0);
                    as.i(c0058a.Yb, n.c.cp_bg_line_b);
                }
                as.i(view, n.e.addresslist_item_bg);
                as.b(c0058a.aIb, this.aIc, 1);
                as.i(c0058a.Yb, n.c.cp_bg_line_b);
                as.i(view, n.e.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean gm(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean af(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void l(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        as.b(textView, n.c.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = n.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = n.e.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = n.e.icon_news_head_prompt_two;
        }
        as.i((View) textView, i2);
    }

    /* loaded from: classes.dex */
    private class c {
        View Yb;
        ImageView aIm;
        TextView agd;

        private c() {
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class b {
        View Yb;
        TextView aIl;

        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0058a {
        View Yb;
        HeadImageView aIa;
        TextView aIb;
        TextView aIi;
        TextView aIj;

        private C0058a() {
        }

        /* synthetic */ C0058a(a aVar, C0058a c0058a) {
            this();
        }
    }
}
