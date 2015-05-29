package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Drawable azB;
    private Drawable azC;
    private boolean azD;
    private int azj;
    private List<com.baidu.tbadk.coreExtra.relationship.a> azv;
    private Context mContext;
    private int size;
    private int azy = n.cp_cont_b;
    private int azz = n.cp_cont_c;
    private int azA = n.cp_cont_d;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.azD = true;
        this.mContext = context;
        this.size = com.baidu.adp.lib.util.n.d(this.mContext, o.ds24);
        this.azD = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azv = list;
        notifyDataSetChanged();
    }

    public void ez(int i) {
        this.azj = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.azD ? 3 : 2;
        return this.azv == null ? i : i + this.azv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ey */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.azD ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.azv.get(i - i2);
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
        if (i == 2 && this.azD) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.xw()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
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
                view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.addresslist_header_new_friends, null);
                d dVar4 = new d(this, null);
                dVar4.azI = (ImageView) view.findViewById(q.addresslist_new_friend_icon);
                dVar4.aiA = (TextView) view.findViewById(q.addresslist_new_friend_text);
                dVar4.So = view.findViewById(q.addresslist_new_friend_divider);
                view.setTag(dVar4);
                dVar3 = dVar4;
            } else {
                dVar3 = (d) view.getTag();
            }
            ay.c(dVar3.azI, p.icon_new_friend);
            ay.b(dVar3.aiA, this.azy, 1);
            ay.i(dVar3.So, n.cp_bg_line_b);
            ay.i(view, p.addresslist_item_bg);
            m((TextView) view.findViewById(q.addresslist_new_friend_message), this.azj);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.addresslist_header_new_friends, null);
                d dVar5 = new d(this, null);
                dVar5.azI = (ImageView) view.findViewById(q.addresslist_new_friend_icon);
                dVar5.aiA = (TextView) view.findViewById(q.addresslist_new_friend_text);
                dVar5.So = view.findViewById(q.addresslist_new_friend_divider);
                view.setTag(dVar5);
                dVar2 = dVar5;
            } else {
                dVar2 = (d) view.getTag();
            }
            ay.c(dVar2.azI, p.icon_add_friend);
            ay.b(dVar2.aiA, this.azy, 1);
            dVar2.aiA.setText(this.mContext.getResources().getString(t.find_new_friend));
            ay.i(dVar2.So, n.cp_bg_line_b);
            ay.i(view, p.addresslist_item_bg);
            ((TextView) view.findViewById(q.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.addresslist_header_my_groups, null);
                d dVar6 = new d(this, null);
                dVar6.azI = (ImageView) view.findViewById(q.addresslist_my_groups_icon);
                dVar6.aiA = (TextView) view.findViewById(q.addresslist_my_groups_text);
                view.setTag(dVar6);
                dVar = dVar6;
            } else {
                dVar = (d) view.getTag();
            }
            ay.c(dVar.azI, p.icon_me_group);
            ay.b(dVar.aiA, this.azy, 1);
            ay.i(view, p.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.addresslist_group_item, null);
                    c cVar2 = new c(this, null);
                    cVar2.azH = (TextView) view.findViewById(q.addresslist_group_item_key);
                    cVar2.So = view.findViewById(q.addresslist_group_item_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (item.xw() != null) {
                    cVar.azH.setText(item.xw());
                }
                ay.b(cVar.azH, this.azz, 1);
                ay.i(cVar.So, n.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this, null);
                    view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.addresslist_child_item, null);
                    bVar2.azw = (HeadImageView) view.findViewById(q.addresslist_child_item_icon);
                    bVar2.azx = (TextView) view.findViewById(q.addresslist_child_item_name);
                    bVar2.azE = (TextView) view.findViewById(q.detail_info_distance);
                    bVar2.azF = (TextView) view.findViewById(q.detail_info_time);
                    bVar2.So = view.findViewById(q.addresslist_child_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.getUserName() != null) {
                    bVar.azx.setText(item.getUserName());
                    bVar.azw.c(item.getUserPortrait(), 12, false);
                }
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().xx() == 1) {
                        bVar.azE.setVisibility(0);
                        ay.b(bVar.azE, this.azA, 1);
                        bVar.azE.setText(this.mContext.getResources().getString(t.contact_yinshen));
                        bVar.azE.setCompoundDrawables(null, null, null, null);
                        bVar.azF.setVisibility(8);
                    } else if (item.getLbsInfo().xx() == 0) {
                        if (!ft(item.getLbsInfo().getDistance()) || !E(item.getLbsInfo().getTime())) {
                            bVar.azE.setVisibility(8);
                            bVar.azF.setVisibility(8);
                        } else {
                            bVar.azE.setVisibility(0);
                            bVar.azF.setVisibility(0);
                            bVar.azE.setText(item.getLbsInfo().getDistance());
                            bVar.azF.setText(bb.n(item.getLbsInfo().getTime()));
                            ay.b(bVar.azE, this.azA, 1);
                            this.azB = ay.getDrawable(p.icon_friend_pin);
                            this.azB.setBounds(0, 0, this.size, this.size);
                            bVar.azE.setCompoundDrawables(this.azB, null, null, null);
                            this.azC = ay.getDrawable(p.icon_friend_time);
                            this.azC.setBounds(0, 0, this.size, this.size);
                            bVar.azF.setCompoundDrawables(this.azC, null, null, null);
                            ay.b(bVar.azF, this.azA, 1);
                        }
                    } else {
                        bVar.azE.setVisibility(8);
                        bVar.azF.setVisibility(8);
                    }
                } else {
                    bVar.azE.setVisibility(8);
                    bVar.azF.setVisibility(8);
                }
                ay.b(bVar.azx, this.azy, 1);
                String xw = item.xw();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(xw) || item2 == null || xw.equals(item2.xw())) ? false : true) {
                    bVar.So.setVisibility(4);
                } else {
                    bVar.So.setVisibility(0);
                    ay.i(bVar.So, n.cp_bg_line_b);
                }
                ay.i(view, p.addresslist_item_bg);
                ay.b(bVar.azx, this.azy, 1);
                ay.i(bVar.So, n.cp_bg_line_b);
                ay.i(view, p.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean ft(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean E(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void m(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ay.b(textView, n.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = p.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = p.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = p.icon_news_head_prompt_two;
        }
        ay.i((View) textView, i2);
    }
}
