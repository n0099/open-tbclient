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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> ePD;
    private int ePG = R.color.cp_cont_b;
    private int ePH = R.color.cp_cont_c;
    private int ePI = R.color.cp_cont_d;
    private Drawable ePJ;
    private Drawable ePK;
    private boolean ePL;
    private int ePr;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.ePL = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.ePL = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ePD = list;
        notifyDataSetChanged();
    }

    public void ph(int i) {
        this.ePr = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.ePL ? 3 : 2;
        return this.ePD == null ? i : i + this.ePD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pg */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.ePL ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.ePD.get(i - i2);
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
        if (i == 2 && this.ePL) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.baY()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.baX())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0506a c0506a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.bxI = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.dJr = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.bxI, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.ePG, 1);
            am.setBackgroundResource(cVar3.dJr, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.ePr);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bxI = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.dJr = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.bxI, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.ePG, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.dJr, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bxI = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.bxI, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.ePG, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.ePP = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.dJr = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.baY() != null) {
                    bVar.ePP.setText(item.baY());
                }
                am.setViewTextColor(bVar.ePP, this.ePH, 1);
                am.setBackgroundResource(bVar.dJr, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0506a)) {
                    C0506a c0506a2 = new C0506a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0506a2.ePE = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0506a2.ePF = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0506a2.ePM = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0506a2.ePN = (TextView) view.findViewById(R.id.detail_info_time);
                    c0506a2.dJr = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0506a2);
                    c0506a = c0506a2;
                } else {
                    c0506a = (C0506a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0506a.ePF.setText(item.getUserName());
                    c0506a.ePE.startLoad(item.baX(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bba() == 1) {
                        c0506a.ePM.setVisibility(0);
                        am.setViewTextColor(c0506a.ePM, this.ePI, 1);
                        c0506a.ePM.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0506a.ePM.setCompoundDrawables(null, null, null, null);
                        c0506a.ePN.setVisibility(8);
                    } else if (item.getLbsInfo().bba() == 0) {
                        if (!Ag(item.getLbsInfo().getDistance()) || !cZ(item.getLbsInfo().getTime())) {
                            c0506a.ePM.setVisibility(8);
                            c0506a.ePN.setVisibility(8);
                        } else {
                            c0506a.ePM.setVisibility(0);
                            c0506a.ePN.setVisibility(0);
                            c0506a.ePM.setText(item.getLbsInfo().getDistance());
                            c0506a.ePN.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0506a.ePM, this.ePI, 1);
                            this.ePJ = am.getDrawable(R.drawable.icon_friend_pin);
                            this.ePJ.setBounds(0, 0, this.size, this.size);
                            c0506a.ePM.setCompoundDrawables(this.ePJ, null, null, null);
                            this.ePK = am.getDrawable(R.drawable.icon_friend_time);
                            this.ePK.setBounds(0, 0, this.size, this.size);
                            c0506a.ePN.setCompoundDrawables(this.ePK, null, null, null);
                            am.setViewTextColor(c0506a.ePN, this.ePI, 1);
                        }
                    } else {
                        c0506a.ePM.setVisibility(8);
                        c0506a.ePN.setVisibility(8);
                    }
                } else {
                    c0506a.ePM.setVisibility(8);
                    c0506a.ePN.setVisibility(8);
                }
                am.setViewTextColor(c0506a.ePF, this.ePG, 1);
                String baY = item.baY();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(baY) || item2 == null || baY.equals(item2.baY())) ? false : true) {
                    c0506a.dJr.setVisibility(4);
                } else {
                    c0506a.dJr.setVisibility(0);
                    am.setBackgroundResource(c0506a.dJr, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0506a.ePF, this.ePG, 1);
                am.setBackgroundResource(c0506a.dJr, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Ag(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean cZ(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void b(TextView textView, int i) {
        int i2 = R.drawable.icon_news_head_prompt_two;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        am.setViewTextColor(textView, R.color.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
        } else {
            textView.setText("99+");
        }
        am.setBackgroundResource(textView, i2);
    }

    /* loaded from: classes8.dex */
    private class c {
        ImageView bxI;
        View dJr;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View dJr;
        TextView ePP;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0506a {
        View dJr;
        HeadImageView ePE;
        TextView ePF;
        TextView ePM;
        TextView ePN;

        private C0506a() {
        }
    }
}
