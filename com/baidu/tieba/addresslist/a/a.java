package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
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
    private List<com.baidu.tbadk.coreExtra.relationship.a> axB;
    private int axE = s.cp_cont_b;
    private int axF = s.cp_cont_c;
    private int axG = s.cp_cont_d;
    private Drawable axH;
    private Drawable axI;
    private boolean axJ;
    private int axq;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.axJ = true;
        this.mContext = context;
        this.size = n.d(this.mContext, t.ds24);
        this.axJ = TbadkCoreApplication.m411getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.axB = list;
        notifyDataSetChanged();
    }

    public void en(int i) {
        this.axq = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.axJ ? 3 : 2;
        return this.axB == null ? i : i + this.axB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: em */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.axJ ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.axB.get(i - i2);
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
        if (i == 2 && this.axJ) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.wD()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
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
                view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.addresslist_header_new_friends, null);
                d dVar4 = new d(this, null);
                dVar4.axP = (ImageView) view.findViewById(v.addresslist_new_friend_icon);
                dVar4.ahr = (TextView) view.findViewById(v.addresslist_new_friend_text);
                dVar4.axK = view.findViewById(v.addresslist_new_friend_divider);
                view.setTag(dVar4);
                dVar3 = dVar4;
            } else {
                dVar3 = (d) view.getTag();
            }
            ba.c(dVar3.axP, u.icon_new_friend);
            ba.b(dVar3.ahr, this.axE, 1);
            ba.i(dVar3.axK, s.cp_bg_line_b);
            ba.i(view, u.addresslist_item_bg);
            m((TextView) view.findViewById(v.addresslist_new_friend_message), this.axq);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.addresslist_header_new_friends, null);
                d dVar5 = new d(this, null);
                dVar5.axP = (ImageView) view.findViewById(v.addresslist_new_friend_icon);
                dVar5.ahr = (TextView) view.findViewById(v.addresslist_new_friend_text);
                dVar5.axK = view.findViewById(v.addresslist_new_friend_divider);
                view.setTag(dVar5);
                dVar2 = dVar5;
            } else {
                dVar2 = (d) view.getTag();
            }
            ba.c(dVar2.axP, u.icon_add_friend);
            ba.b(dVar2.ahr, this.axE, 1);
            dVar2.ahr.setText(this.mContext.getResources().getString(y.find_new_friend));
            ba.i(dVar2.axK, s.cp_bg_line_b);
            ba.i(view, u.addresslist_item_bg);
            ((TextView) view.findViewById(v.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.addresslist_header_my_groups, null);
                d dVar6 = new d(this, null);
                dVar6.axP = (ImageView) view.findViewById(v.addresslist_my_groups_icon);
                dVar6.ahr = (TextView) view.findViewById(v.addresslist_my_groups_text);
                view.setTag(dVar6);
                dVar = dVar6;
            } else {
                dVar = (d) view.getTag();
            }
            ba.c(dVar.axP, u.icon_me_group);
            ba.b(dVar.ahr, this.axE, 1);
            ba.i(view, u.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.addresslist_group_item, null);
                    c cVar2 = new c(this, null);
                    cVar2.axO = (TextView) view.findViewById(v.addresslist_group_item_key);
                    cVar2.axK = view.findViewById(v.addresslist_group_item_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (item.wD() != null) {
                    cVar.axO.setText(item.wD());
                }
                ba.b(cVar.axO, this.axF, 1);
                ba.i(cVar.axK, s.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this, null);
                    view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.addresslist_child_item, null);
                    bVar2.axC = (HeadImageView) view.findViewById(v.addresslist_child_item_icon);
                    bVar2.axD = (TextView) view.findViewById(v.addresslist_child_item_name);
                    bVar2.axL = (TextView) view.findViewById(v.detail_info_distance);
                    bVar2.axM = (TextView) view.findViewById(v.detail_info_time);
                    bVar2.axK = view.findViewById(v.addresslist_child_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.getUserName() != null) {
                    bVar.axD.setText(item.getUserName());
                    bVar.axC.c(item.getUserPortrait(), 12, false);
                }
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().wE() == 1) {
                        bVar.axL.setVisibility(0);
                        ba.b(bVar.axL, this.axG, 1);
                        bVar.axL.setText(this.mContext.getResources().getString(y.contact_yinshen));
                        bVar.axL.setCompoundDrawables(null, null, null, null);
                        bVar.axM.setVisibility(8);
                    } else if (item.getLbsInfo().wE() == 0) {
                        if (!eV(item.getLbsInfo().getDistance()) || !F(item.getLbsInfo().getTime())) {
                            bVar.axL.setVisibility(8);
                            bVar.axM.setVisibility(8);
                        } else {
                            bVar.axL.setVisibility(0);
                            bVar.axM.setVisibility(0);
                            bVar.axL.setText(item.getLbsInfo().getDistance());
                            bVar.axM.setText(bd.m(item.getLbsInfo().getTime()));
                            ba.b(bVar.axL, this.axG, 1);
                            this.axH = ba.getDrawable(u.icon_friend_pin);
                            this.axH.setBounds(0, 0, this.size, this.size);
                            bVar.axL.setCompoundDrawables(this.axH, null, null, null);
                            this.axI = ba.getDrawable(u.icon_friend_time);
                            this.axI.setBounds(0, 0, this.size, this.size);
                            bVar.axM.setCompoundDrawables(this.axI, null, null, null);
                            ba.b(bVar.axM, this.axG, 1);
                        }
                    } else {
                        bVar.axL.setVisibility(8);
                        bVar.axM.setVisibility(8);
                    }
                } else {
                    bVar.axL.setVisibility(8);
                    bVar.axM.setVisibility(8);
                }
                ba.b(bVar.axD, this.axE, 1);
                String wD = item.wD();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(wD) || item2 == null || wD.equals(item2.wD())) ? false : true) {
                    bVar.axK.setVisibility(4);
                } else {
                    bVar.axK.setVisibility(0);
                    ba.i(bVar.axK, s.cp_bg_line_b);
                }
                ba.i(view, u.addresslist_item_bg);
                ba.b(bVar.axD, this.axE, 1);
                ba.i(bVar.axK, s.cp_bg_line_b);
                ba.i(view, u.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean eV(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean F(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void m(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ba.b(textView, s.top_msg_num_day, 1);
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
        ba.i((View) textView, i2);
    }
}
