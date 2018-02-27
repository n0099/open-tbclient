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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int bTT;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bUf;
    private int bUi = d.C0141d.cp_cont_b;
    private int bUj = d.C0141d.cp_cont_c;
    private int bUk = d.C0141d.cp_cont_d;
    private Drawable bUl;
    private Drawable bUm;
    private boolean bUn;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bUn = true;
        this.mContext = context;
        this.size = l.t(this.mContext, d.e.ds24);
        this.bUn = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bUf = list;
        notifyDataSetChanged();
    }

    public void jq(int i) {
        this.bTT = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bUn ? 3 : 2;
        return this.bUf == null ? i : i + this.bUf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jp */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bUn ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.bUf.get(i - i2);
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
        if (i == 2 && this.bUn) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.IT()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.IS())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0127a c0127a;
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
                cVar4.bUs = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            aj.c(cVar3.bUs, d.f.icon_new_friend);
            aj.e(cVar3.title, this.bUi, 1);
            aj.s(cVar3.divider, d.C0141d.cp_bg_line_b);
            aj.s(view, d.f.addresslist_item_bg);
            j((TextView) view.findViewById(d.g.addresslist_new_friend_message), this.bTT);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bUs = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            aj.c(cVar2.bUs, d.f.icon_add_friend);
            aj.e(cVar2.title, this.bUi, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.j.find_new_friend));
            aj.s(cVar2.divider, d.C0141d.cp_bg_line_b);
            aj.s(view, d.f.addresslist_item_bg);
            ((TextView) view.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bUs = (ImageView) view.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(d.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            aj.c(cVar.bUs, d.f.icon_me_group);
            aj.e(cVar.title, this.bUi, 1);
            aj.s(view, d.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.bUr = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.IT() != null) {
                    bVar.bUr.setText(item.IT());
                }
                aj.e(bVar.bUr, this.bUj, 1);
                aj.s(bVar.divider, d.C0141d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0127a)) {
                    C0127a c0127a2 = new C0127a();
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_child_item, (ViewGroup) null);
                    c0127a2.bUg = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                    c0127a2.bUh = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                    c0127a2.bUo = (TextView) view.findViewById(d.g.detail_info_distance);
                    c0127a2.bUp = (TextView) view.findViewById(d.g.detail_info_time);
                    c0127a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                    view.setTag(c0127a2);
                    c0127a = c0127a2;
                } else {
                    c0127a = (C0127a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0127a.bUh.setText(item.getUserName());
                    c0127a.bUg.startLoad(item.IS(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().IV() == 1) {
                        c0127a.bUo.setVisibility(0);
                        aj.e(c0127a.bUo, this.bUk, 1);
                        c0127a.bUo.setText(this.mContext.getResources().getString(d.j.contact_yinshen));
                        c0127a.bUo.setCompoundDrawables(null, null, null, null);
                        c0127a.bUp.setVisibility(8);
                    } else if (item.getLbsInfo().IV() == 0) {
                        if (!ik(item.getLbsInfo().IU()) || !aH(item.getLbsInfo().getTime())) {
                            c0127a.bUo.setVisibility(8);
                            c0127a.bUp.setVisibility(8);
                        } else {
                            c0127a.bUo.setVisibility(0);
                            c0127a.bUp.setVisibility(0);
                            c0127a.bUo.setText(item.getLbsInfo().IU());
                            c0127a.bUp.setText(am.x(item.getLbsInfo().getTime()));
                            aj.e(c0127a.bUo, this.bUk, 1);
                            this.bUl = aj.getDrawable(d.f.icon_friend_pin);
                            this.bUl.setBounds(0, 0, this.size, this.size);
                            c0127a.bUo.setCompoundDrawables(this.bUl, null, null, null);
                            this.bUm = aj.getDrawable(d.f.icon_friend_time);
                            this.bUm.setBounds(0, 0, this.size, this.size);
                            c0127a.bUp.setCompoundDrawables(this.bUm, null, null, null);
                            aj.e(c0127a.bUp, this.bUk, 1);
                        }
                    } else {
                        c0127a.bUo.setVisibility(8);
                        c0127a.bUp.setVisibility(8);
                    }
                } else {
                    c0127a.bUo.setVisibility(8);
                    c0127a.bUp.setVisibility(8);
                }
                aj.e(c0127a.bUh, this.bUi, 1);
                String IT = item.IT();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(IT) || item2 == null || IT.equals(item2.IT())) ? false : true) {
                    c0127a.divider.setVisibility(4);
                } else {
                    c0127a.divider.setVisibility(0);
                    aj.s(c0127a.divider, d.C0141d.cp_bg_line_b);
                }
                aj.s(view, d.f.addresslist_item_bg);
                aj.e(c0127a.bUh, this.bUi, 1);
                aj.s(c0127a.divider, d.C0141d.cp_bg_line_b);
                aj.s(view, d.f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean ik(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aH(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void j(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        aj.e(textView, d.C0141d.common_color_10225, 1);
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
        aj.s(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView bUs;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView bUr;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0127a {
        HeadImageView bUg;
        TextView bUh;
        TextView bUo;
        TextView bUp;
        View divider;

        private C0127a() {
        }
    }
}
