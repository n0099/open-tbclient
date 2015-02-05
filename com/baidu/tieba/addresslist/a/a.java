package com.baidu.tieba.addresslist.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
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
    private List<com.baidu.tbadk.coreExtra.relationship.b> SQ;
    private int aoV;
    private boolean apk;
    private int apl = t.cp_cont_b;
    private int apm = t.cp_cont_c;
    private int apn = t.cp_cont_d;
    private Drawable apo;
    private Drawable apq;
    private boolean apr;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.apr = true;
        this.mContext = context;
        this.size = l.d(this.mContext, u.ds24);
        this.apr = TbadkCoreApplication.m255getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.SQ = list;
        notifyDataSetChanged();
    }

    public void ej(int i) {
        this.aoV = i;
    }

    public void bk(boolean z) {
        this.apk = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.apr ? 3 : 2;
        return this.SQ == null ? i : i + this.SQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ei */
    public com.baidu.tbadk.coreExtra.relationship.b getItem(int i) {
        int i2 = this.apr ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.SQ.get(i - i2);
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
        if (i == 2 && this.apr) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.th()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
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
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.addresslist_header_new_friends, null);
                d dVar4 = new d(this, null);
                dVar4.apw = (ImageView) view.findViewById(w.addresslist_new_friend_icon);
                dVar4.apx = (ImageView) view.findViewById(w.addresslist_new_friend_new_icon);
                dVar4.Xl = (TextView) view.findViewById(w.addresslist_new_friend_text);
                dVar4.abo = view.findViewById(w.addresslist_new_friend_divider);
                view.setTag(dVar4);
                dVar3 = dVar4;
            } else {
                dVar3 = (d) view.getTag();
            }
            bc.c(dVar3.apw, v.icon_new_friend);
            if (this.apk) {
                dVar3.apx.setVisibility(0);
                bc.c(dVar3.apx, v.icon_news_down_bar_one);
            } else {
                dVar3.apx.setVisibility(8);
            }
            bc.b(dVar3.Xl, this.apl, 1);
            bc.i(dVar3.abo, t.cp_bg_line_b);
            bc.i(view, v.addresslist_item_bg);
            m((TextView) view.findViewById(w.addresslist_new_friend_message), this.aoV);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.addresslist_header_new_friends, null);
                d dVar5 = new d(this, null);
                dVar5.apw = (ImageView) view.findViewById(w.addresslist_new_friend_icon);
                dVar5.apx = (ImageView) view.findViewById(w.addresslist_new_friend_new_icon);
                dVar5.Xl = (TextView) view.findViewById(w.addresslist_new_friend_text);
                dVar5.abo = view.findViewById(w.addresslist_new_friend_divider);
                view.setTag(dVar5);
                dVar2 = dVar5;
            } else {
                dVar2 = (d) view.getTag();
            }
            bc.c(dVar2.apw, v.icon_add_friend);
            dVar2.apx.setVisibility(8);
            bc.b(dVar2.Xl, this.apl, 1);
            dVar2.Xl.setText(this.mContext.getResources().getString(z.find_new_friend));
            bc.i(dVar2.abo, t.cp_bg_line_b);
            bc.i(view, v.addresslist_item_bg);
            ((TextView) view.findViewById(w.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof d)) {
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.addresslist_header_my_groups, null);
                d dVar6 = new d(this, null);
                dVar6.apw = (ImageView) view.findViewById(w.addresslist_my_groups_icon);
                dVar6.Xl = (TextView) view.findViewById(w.addresslist_my_groups_text);
                view.setTag(dVar6);
                dVar = dVar6;
            } else {
                dVar = (d) view.getTag();
            }
            bc.c(dVar.apw, v.icon_me_group);
            bc.b(dVar.Xl, this.apl, 1);
            bc.i(view, v.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.addresslist_group_item, null);
                    c cVar2 = new c(this, null);
                    cVar2.apv = (TextView) view.findViewById(w.addresslist_group_item_key);
                    cVar2.abo = view.findViewById(w.addresslist_group_item_divider);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (item.th() != null) {
                    cVar.apv.setText(item.th());
                }
                bc.b(cVar.apv, this.apm, 1);
                bc.i(cVar.abo, t.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b(this, null);
                    view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.addresslist_child_item, null);
                    bVar2.aph = (HeadImageView) view.findViewById(w.addresslist_child_item_icon);
                    bVar2.apj = (TextView) view.findViewById(w.addresslist_child_item_name);
                    bVar2.aps = (TextView) view.findViewById(w.detail_info_distance);
                    bVar2.apt = (TextView) view.findViewById(w.detail_info_time);
                    bVar2.abo = view.findViewById(w.addresslist_child_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.getUserName() != null) {
                    bVar.apj.setText(item.getUserName());
                    bVar.aph.d(item.getUserPortrait(), 12, false);
                }
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().ti() == 1) {
                        bVar.aps.setVisibility(0);
                        bc.b(bVar.aps, this.apn, 1);
                        bVar.aps.setText(this.mContext.getResources().getString(z.contact_yinshen));
                        bVar.aps.setCompoundDrawables(null, null, null, null);
                        bVar.apt.setVisibility(8);
                    } else if (item.getLbsInfo().ti() == 0) {
                        if (StringUtils.isNull(item.getLbsInfo().getDistance()) || !F(item.getLbsInfo().getTime())) {
                            bVar.aps.setVisibility(8);
                            bVar.apt.setVisibility(8);
                        } else {
                            bVar.aps.setVisibility(0);
                            bVar.apt.setVisibility(0);
                            bVar.aps.setText(item.getLbsInfo().getDistance());
                            bVar.apt.setText(bf.m(item.getLbsInfo().getTime()));
                            bc.b(bVar.aps, this.apn, 1);
                            this.apo = bc.getDrawable(v.icon_friend_pin);
                            this.apo.setBounds(0, 0, this.size, this.size);
                            bVar.aps.setCompoundDrawables(this.apo, null, null, null);
                            this.apq = bc.getDrawable(v.icon_friend_time);
                            this.apq.setBounds(0, 0, this.size, this.size);
                            bVar.apt.setCompoundDrawables(this.apq, null, null, null);
                            bc.b(bVar.apt, this.apn, 1);
                        }
                    } else {
                        bVar.aps.setVisibility(8);
                        bVar.apt.setVisibility(8);
                    }
                } else {
                    bVar.aps.setVisibility(8);
                    bVar.apt.setVisibility(8);
                }
                bc.b(bVar.apj, this.apl, 1);
                String th = item.th();
                com.baidu.tbadk.coreExtra.relationship.b item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(th) || item2 == null || th.equals(item2.th())) ? false : true) {
                    bVar.abo.setVisibility(4);
                } else {
                    bVar.abo.setVisibility(0);
                    bc.i(bVar.abo, t.cp_bg_line_b);
                }
                bc.i(view, v.addresslist_item_bg);
                bc.b(bVar.apj, this.apl, 1);
                bc.i(bVar.abo, t.cp_bg_line_b);
                bc.i(view, v.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
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
        bc.b(textView, t.top_msg_num_day, 1);
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
        bc.i((View) textView, i2);
    }
}
