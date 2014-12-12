package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.b> So;
    private int aod;
    private boolean aor;
    private int aos = t.cp_cont_b;
    private int aot = t.cp_cont_c;
    private int aou = t.cp_cont_d;
    private Drawable aov;
    private Drawable aow;
    private boolean aox;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.aox = true;
        this.mContext = context;
        this.size = l.d(this.mContext, u.ds24);
        this.aox = TbadkCoreApplication.m255getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.So = list;
        notifyDataSetChanged();
    }

    public void ed(int i) {
        this.aod = i;
    }

    public void bi(boolean z) {
        this.aor = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.aox ? 3 : 2;
        return this.So == null ? i : i + this.So.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ec */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        int i2 = this.aox ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.So.get(i - i2);
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
        if (i == 2 && this.aox) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.sW()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
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
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.addresslist_header_new_friends, null);
                d dVar4 = new d(this, null);
                dVar4.icon = (ImageView) view.findViewById(w.addresslist_new_friend_icon);
                dVar4.aoC = (ImageView) view.findViewById(w.addresslist_new_friend_new_icon);
                dVar4.title = (TextView) view.findViewById(w.addresslist_new_friend_text);
                dVar4.aaQ = view.findViewById(w.addresslist_new_friend_divider);
                view.setTag(dVar4);
                dVar3 = dVar4;
            } else {
                dVar3 = (d) view.getTag();
            }
            ax.c(dVar3.icon, v.icon_new_friend);
            if (this.aor) {
                dVar3.aoC.setVisibility(0);
                ax.c(dVar3.aoC, v.icon_news_down_bar_one);
            } else {
                dVar3.aoC.setVisibility(8);
            }
            ax.b(dVar3.title, this.aos, 1);
            ax.i(dVar3.aaQ, t.cp_bg_line_b);
            ax.i(view, v.addresslist_item_bg);
            m((TextView) view.findViewById(w.addresslist_new_friend_message), this.aod);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.addresslist_header_new_friends, null);
                d dVar5 = new d(this, null);
                dVar5.icon = (ImageView) view.findViewById(w.addresslist_new_friend_icon);
                dVar5.aoC = (ImageView) view.findViewById(w.addresslist_new_friend_new_icon);
                dVar5.title = (TextView) view.findViewById(w.addresslist_new_friend_text);
                dVar5.aaQ = view.findViewById(w.addresslist_new_friend_divider);
                view.setTag(dVar5);
                dVar2 = dVar5;
            } else {
                dVar2 = (d) view.getTag();
            }
            ax.c(dVar2.icon, v.icon_add_friend);
            dVar2.aoC.setVisibility(8);
            ax.b(dVar2.title, this.aos, 1);
            dVar2.title.setText(this.mContext.getResources().getString(z.find_new_friend));
            ax.i(dVar2.aaQ, t.cp_bg_line_b);
            ax.i(view, v.addresslist_item_bg);
            ((TextView) view.findViewById(w.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.addresslist_header_my_groups, null);
                d dVar6 = new d(this, null);
                dVar6.icon = (ImageView) view.findViewById(w.addresslist_my_groups_icon);
                dVar6.title = (TextView) view.findViewById(w.addresslist_my_groups_text);
                view.setTag(dVar6);
                dVar = dVar6;
            } else {
                dVar = (d) view.getTag();
            }
            ax.c(dVar.icon, v.icon_me_group);
            ax.b(dVar.title, this.aos, 1);
            ax.i(view, v.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.addresslist_group_item, null);
                    c cVar2 = new c(this, null);
                    cVar2.aoB = (TextView) view.findViewById(w.addresslist_group_item_key);
                    cVar2.aaQ = view.findViewById(w.addresslist_group_item_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (item.sW() != null) {
                    cVar.aoB.setText(item.sW());
                }
                ax.b(cVar.aoB, this.aot, 1);
                ax.i(cVar.aaQ, t.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.addresslist_child_item, null);
                    bVar2.aop = (HeadImageView) view.findViewById(w.addresslist_child_item_icon);
                    bVar2.aoq = (TextView) view.findViewById(w.addresslist_child_item_name);
                    bVar2.aoy = (TextView) view.findViewById(w.detail_info_distance);
                    bVar2.aoz = (TextView) view.findViewById(w.detail_info_time);
                    bVar2.aaQ = view.findViewById(w.addresslist_child_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.getUserName() != null) {
                    bVar.aoq.setText(item.getUserName());
                    bVar.aop.d(item.getUserPortrait(), 12, false);
                }
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().sX() == 1) {
                        bVar.aoy.setVisibility(0);
                        ax.b(bVar.aoy, this.aou, 1);
                        bVar.aoy.setText(this.mContext.getResources().getString(z.contact_yinshen));
                        bVar.aoy.setCompoundDrawables(null, null, null, null);
                        bVar.aoz.setVisibility(8);
                    } else if (item.getLbsInfo().sX() == 0) {
                        if (!eO(item.getLbsInfo().getDistance()) || !F(item.getLbsInfo().getTime())) {
                            bVar.aoy.setVisibility(8);
                            bVar.aoz.setVisibility(8);
                        } else {
                            bVar.aoy.setVisibility(0);
                            bVar.aoz.setVisibility(0);
                            bVar.aoy.setText(item.getLbsInfo().getDistance());
                            bVar.aoz.setText(ba.m(item.getLbsInfo().getTime()));
                            ax.b(bVar.aoy, this.aou, 1);
                            this.aov = ax.getDrawable(v.icon_friend_pin);
                            this.aov.setBounds(0, 0, this.size, this.size);
                            bVar.aoy.setCompoundDrawables(this.aov, null, null, null);
                            this.aow = ax.getDrawable(v.icon_friend_time);
                            this.aow.setBounds(0, 0, this.size, this.size);
                            bVar.aoz.setCompoundDrawables(this.aow, null, null, null);
                            ax.b(bVar.aoz, this.aou, 1);
                        }
                    } else {
                        bVar.aoy.setVisibility(8);
                        bVar.aoz.setVisibility(8);
                    }
                } else {
                    bVar.aoy.setVisibility(8);
                    bVar.aoz.setVisibility(8);
                }
                ax.b(bVar.aoq, this.aos, 1);
                String sW = item.sW();
                com.baidu.tbadk.coreExtra.relationship.b item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(sW) || item2 == null || sW.equals(item2.sW())) ? false : true) {
                    bVar.aaQ.setVisibility(4);
                } else {
                    bVar.aaQ.setVisibility(0);
                    ax.i(bVar.aaQ, t.cp_bg_line_b);
                }
                ax.i(view, v.addresslist_item_bg);
                ax.b(bVar.aoq, this.aos, 1);
                ax.i(bVar.aaQ, t.cp_bg_line_b);
                ax.i(view, v.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean eO(String str) {
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
        ax.b(textView, t.top_msg_num_day, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = v.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = v.icon_news_head_prompt_two;
        }
        ax.i((View) textView, i2);
    }
}
