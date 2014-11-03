package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> Mu;
    private int agN;
    private boolean ahb;
    private int ahc = s.cp_cont_b;
    private int ahd = s.cp_cont_c;
    private int ahe = s.cp_cont_d;
    private Drawable ahf;
    private Drawable ahg;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.d dVar) {
        this.mContext = context;
        this.size = m.c(this.mContext, t.ds24);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.Mu = list;
        notifyDataSetChanged();
    }

    public void dJ(int i) {
        this.agN = i;
    }

    public void bj(boolean z) {
        this.ahb = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Mu == null) {
            return 3;
        }
        return this.Mu.size() + 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dI */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        if (i < 3 || i >= getCount()) {
            return null;
        }
        return this.Mu.get(i - 3);
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
        com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 5;
        }
        if (i != 2) {
            if (item == null) {
                return 4;
            }
            return (!TextUtils.isEmpty(item.pC()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        d dVar;
        d dVar2;
        d dVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.addresslist_header_new_friends, null);
                d dVar4 = new d(this, null);
                dVar4.ahl = (ImageView) view.findViewById(v.addresslist_new_friend_icon);
                dVar4.ahm = (ImageView) view.findViewById(v.addresslist_new_friend_new_icon);
                dVar4.QK = (TextView) view.findViewById(v.addresslist_new_friend_text);
                dVar4.UM = view.findViewById(v.addresslist_new_friend_divider);
                view.setTag(dVar4);
                dVar3 = dVar4;
            } else {
                dVar3 = (d) view.getTag();
            }
            aw.c(dVar3.ahl, u.icon_new_friend);
            if (this.ahb) {
                dVar3.ahm.setVisibility(0);
                aw.c(dVar3.ahm, u.icon_news_down_bar_one);
            } else {
                dVar3.ahm.setVisibility(8);
            }
            aw.b(dVar3.QK, this.ahc, 1);
            aw.h(dVar3.UM, s.cp_bg_line_b);
            aw.h(view, u.addresslist_item_bg);
            n((TextView) view.findViewById(v.addresslist_new_friend_message), this.agN);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.addresslist_header_new_friends, null);
                d dVar5 = new d(this, null);
                dVar5.ahl = (ImageView) view.findViewById(v.addresslist_new_friend_icon);
                dVar5.ahm = (ImageView) view.findViewById(v.addresslist_new_friend_new_icon);
                dVar5.QK = (TextView) view.findViewById(v.addresslist_new_friend_text);
                dVar5.UM = view.findViewById(v.addresslist_new_friend_divider);
                view.setTag(dVar5);
                dVar2 = dVar5;
            } else {
                dVar2 = (d) view.getTag();
            }
            aw.c(dVar2.ahl, u.icon_add_friend);
            dVar2.ahm.setVisibility(8);
            aw.b(dVar2.QK, this.ahc, 1);
            dVar2.QK.setText(this.mContext.getResources().getString(y.find_new_friend));
            aw.h(dVar2.UM, s.cp_bg_line_b);
            aw.h(view, u.addresslist_item_bg);
            ((TextView) view.findViewById(v.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.addresslist_header_my_groups, null);
                d dVar6 = new d(this, null);
                dVar6.ahl = (ImageView) view.findViewById(v.addresslist_my_groups_icon);
                dVar6.QK = (TextView) view.findViewById(v.addresslist_my_groups_text);
                view.setTag(dVar6);
                dVar = dVar6;
            } else {
                dVar = (d) view.getTag();
            }
            aw.c(dVar.ahl, u.icon_me_group);
            aw.b(dVar.QK, this.ahc, 1);
            aw.h(view, u.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.addresslist_group_item, null);
                    c cVar2 = new c(this, null);
                    cVar2.ahk = (TextView) view.findViewById(v.addresslist_group_item_key);
                    cVar2.UM = view.findViewById(v.addresslist_group_item_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (item.pC() != null) {
                    cVar.ahk.setText(item.pC());
                }
                aw.b(cVar.ahk, this.ahd, 1);
                aw.h(cVar.UM, s.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.addresslist_child_item, null);
                    bVar2.agZ = (HeadImageView) view.findViewById(v.addresslist_child_item_icon);
                    bVar2.aha = (TextView) view.findViewById(v.addresslist_child_item_name);
                    bVar2.ahh = (TextView) view.findViewById(v.detail_info_distance);
                    bVar2.ahi = (TextView) view.findViewById(v.detail_info_time);
                    bVar2.UM = view.findViewById(v.addresslist_child_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.getUserName() != null) {
                    bVar.aha.setText(item.getUserName());
                    bVar.agZ.c(item.getUserPortrait(), 12, false);
                }
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().pD() == 1) {
                        bVar.ahh.setVisibility(0);
                        aw.b(bVar.ahh, this.ahe, 1);
                        bVar.ahh.setText(this.mContext.getResources().getString(y.contact_yinshen));
                        bVar.ahh.setCompoundDrawables(null, null, null, null);
                        bVar.ahi.setVisibility(8);
                    } else if (item.getLbsInfo().pD() == 0) {
                        if (!ei(item.getLbsInfo().getDistance()) || !v(item.getLbsInfo().getTime())) {
                            bVar.ahh.setVisibility(8);
                            bVar.ahi.setVisibility(8);
                        } else {
                            bVar.ahh.setVisibility(0);
                            bVar.ahi.setVisibility(0);
                            bVar.ahh.setText(item.getLbsInfo().getDistance());
                            bVar.ahi.setText(az.i(item.getLbsInfo().getTime()));
                            aw.b(bVar.ahh, this.ahe, 1);
                            this.ahf = aw.getDrawable(u.icon_friend_pin);
                            this.ahf.setBounds(0, 0, this.size, this.size);
                            bVar.ahh.setCompoundDrawables(this.ahf, null, null, null);
                            this.ahg = aw.getDrawable(u.icon_friend_time);
                            this.ahg.setBounds(0, 0, this.size, this.size);
                            bVar.ahi.setCompoundDrawables(this.ahg, null, null, null);
                            aw.b(bVar.ahi, this.ahe, 1);
                        }
                    } else {
                        bVar.ahh.setVisibility(8);
                        bVar.ahi.setVisibility(8);
                    }
                } else {
                    bVar.ahh.setVisibility(8);
                    bVar.ahi.setVisibility(8);
                }
                aw.b(bVar.aha, this.ahc, 1);
                String pC = item.pC();
                com.baidu.tbadk.coreExtra.relationship.b item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(pC) || item2 == null || pC.equals(item2.pC())) ? false : true) {
                    bVar.UM.setVisibility(4);
                } else {
                    bVar.UM.setVisibility(0);
                    aw.h(bVar.UM, s.cp_bg_line_b);
                }
                aw.h(view, u.addresslist_item_bg);
                aw.b(bVar.aha, this.ahc, 1);
                aw.h(bVar.UM, s.cp_bg_line_b);
                aw.h(view, u.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean ei(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean v(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void n(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        aw.b(textView, s.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = u.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = u.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = u.icon_news_head_prompt_two;
        }
        aw.h((View) textView, i2);
    }
}
