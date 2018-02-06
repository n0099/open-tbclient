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
    private int bUf;
    private List<com.baidu.tbadk.coreExtra.relationship.a> bUr;
    private int bUu = d.C0140d.cp_cont_b;
    private int bUv = d.C0140d.cp_cont_c;
    private int bUw = d.C0140d.cp_cont_d;
    private Drawable bUx;
    private Drawable bUy;
    private boolean bUz;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.bUz = true;
        this.mContext = context;
        this.size = l.t(this.mContext, d.e.ds24);
        this.bUz = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bUr = list;
        notifyDataSetChanged();
    }

    public void jq(int i) {
        this.bUf = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.bUz ? 3 : 2;
        return this.bUr == null ? i : i + this.bUr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jp */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.bUz ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.bUr.get(i - i2);
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
        if (i == 2 && this.bUz) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.IU()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.IT())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0126a c0126a;
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
                cVar4.bUE = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            aj.c(cVar3.bUE, d.f.icon_new_friend);
            aj.e(cVar3.title, this.bUu, 1);
            aj.s(cVar3.divider, d.C0140d.cp_bg_line_b);
            aj.s(view, d.f.addresslist_item_bg);
            j((TextView) view.findViewById(d.g.addresslist_new_friend_message), this.bUf);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bUE = (ImageView) view.findViewById(d.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(d.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(d.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            aj.c(cVar2.bUE, d.f.icon_add_friend);
            aj.e(cVar2.title, this.bUu, 1);
            cVar2.title.setText(this.mContext.getResources().getString(d.j.find_new_friend));
            aj.s(cVar2.divider, d.C0140d.cp_bg_line_b);
            aj.s(view, d.f.addresslist_item_bg);
            ((TextView) view.findViewById(d.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bUE = (ImageView) view.findViewById(d.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(d.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            aj.c(cVar.bUE, d.f.icon_me_group);
            aj.e(cVar.title, this.bUu, 1);
            aj.s(view, d.f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.bUD = (TextView) view.findViewById(d.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(d.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.IU() != null) {
                    bVar.bUD.setText(item.IU());
                }
                aj.e(bVar.bUD, this.bUv, 1);
                aj.s(bVar.divider, d.C0140d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0126a)) {
                    C0126a c0126a2 = new C0126a();
                    view = LayoutInflater.from(this.mContext).inflate(d.h.addresslist_child_item, (ViewGroup) null);
                    c0126a2.bUs = (HeadImageView) view.findViewById(d.g.addresslist_child_item_icon);
                    c0126a2.bUt = (TextView) view.findViewById(d.g.addresslist_child_item_name);
                    c0126a2.bUA = (TextView) view.findViewById(d.g.detail_info_distance);
                    c0126a2.bUB = (TextView) view.findViewById(d.g.detail_info_time);
                    c0126a2.divider = view.findViewById(d.g.addresslist_child_item_divider);
                    view.setTag(c0126a2);
                    c0126a = c0126a2;
                } else {
                    c0126a = (C0126a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0126a.bUt.setText(item.getUserName());
                    c0126a.bUs.startLoad(item.IT(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().IW() == 1) {
                        c0126a.bUA.setVisibility(0);
                        aj.e(c0126a.bUA, this.bUw, 1);
                        c0126a.bUA.setText(this.mContext.getResources().getString(d.j.contact_yinshen));
                        c0126a.bUA.setCompoundDrawables(null, null, null, null);
                        c0126a.bUB.setVisibility(8);
                    } else if (item.getLbsInfo().IW() == 0) {
                        if (!ik(item.getLbsInfo().IV()) || !aH(item.getLbsInfo().getTime())) {
                            c0126a.bUA.setVisibility(8);
                            c0126a.bUB.setVisibility(8);
                        } else {
                            c0126a.bUA.setVisibility(0);
                            c0126a.bUB.setVisibility(0);
                            c0126a.bUA.setText(item.getLbsInfo().IV());
                            c0126a.bUB.setText(am.x(item.getLbsInfo().getTime()));
                            aj.e(c0126a.bUA, this.bUw, 1);
                            this.bUx = aj.getDrawable(d.f.icon_friend_pin);
                            this.bUx.setBounds(0, 0, this.size, this.size);
                            c0126a.bUA.setCompoundDrawables(this.bUx, null, null, null);
                            this.bUy = aj.getDrawable(d.f.icon_friend_time);
                            this.bUy.setBounds(0, 0, this.size, this.size);
                            c0126a.bUB.setCompoundDrawables(this.bUy, null, null, null);
                            aj.e(c0126a.bUB, this.bUw, 1);
                        }
                    } else {
                        c0126a.bUA.setVisibility(8);
                        c0126a.bUB.setVisibility(8);
                    }
                } else {
                    c0126a.bUA.setVisibility(8);
                    c0126a.bUB.setVisibility(8);
                }
                aj.e(c0126a.bUt, this.bUu, 1);
                String IU = item.IU();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(IU) || item2 == null || IU.equals(item2.IU())) ? false : true) {
                    c0126a.divider.setVisibility(4);
                } else {
                    c0126a.divider.setVisibility(0);
                    aj.s(c0126a.divider, d.C0140d.cp_bg_line_b);
                }
                aj.s(view, d.f.addresslist_item_bg);
                aj.e(c0126a.bUt, this.bUu, 1);
                aj.s(c0126a.divider, d.C0140d.cp_bg_line_b);
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
        aj.e(textView, d.C0140d.common_color_10225, 1);
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
        ImageView bUE;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView bUD;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0126a {
        TextView bUA;
        TextView bUB;
        HeadImageView bUs;
        TextView bUt;
        View divider;

        private C0126a() {
        }
    }
}
