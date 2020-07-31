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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes15.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> feB;
    private int feE = R.color.cp_cont_b;
    private int feF = R.color.cp_cont_c;
    private int feG = R.color.cp_cont_d;
    private Drawable feH;
    private Drawable feI;
    private boolean feJ;
    private int fep;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.feJ = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.feJ = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.feB = list;
        notifyDataSetChanged();
    }

    public void pV(int i) {
        this.fep = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.feJ ? 3 : 2;
        return this.feB == null ? i : i + this.feB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pU */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.feJ ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.feB.get(i - i2);
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
        if (i == 2 && this.feJ) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bgI()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bgH())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0524a c0524a;
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
                cVar4.bCQ = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.dWz = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ao.setImageResource(cVar3.bCQ, R.drawable.icon_new_friend);
            ao.setViewTextColor(cVar3.title, this.feE, 1);
            ao.setBackgroundResource(cVar3.dWz, R.color.cp_bg_line_c);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fep);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bCQ = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.dWz = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ao.setImageResource(cVar2.bCQ, R.drawable.icon_add_friend);
            ao.setViewTextColor(cVar2.title, this.feE, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ao.setBackgroundResource(cVar2.dWz, R.color.cp_bg_line_c);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bCQ = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ao.setImageResource(cVar.bCQ, R.drawable.icon_me_group);
            ao.setViewTextColor(cVar.title, this.feE, 1);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.feN = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.dWz = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bgI() != null) {
                    bVar.feN.setText(item.bgI());
                }
                ao.setViewTextColor(bVar.feN, this.feF, 1);
                ao.setBackgroundResource(bVar.dWz, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0524a)) {
                    C0524a c0524a2 = new C0524a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0524a2.feC = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0524a2.feD = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0524a2.feK = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0524a2.feL = (TextView) view.findViewById(R.id.detail_info_time);
                    c0524a2.dWz = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0524a2);
                    c0524a = c0524a2;
                } else {
                    c0524a = (C0524a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0524a.feD.setText(item.getUserName());
                    c0524a.feC.startLoad(item.bgH(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bgK() == 1) {
                        c0524a.feK.setVisibility(0);
                        ao.setViewTextColor(c0524a.feK, this.feG, 1);
                        c0524a.feK.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0524a.feK.setCompoundDrawables(null, null, null, null);
                        c0524a.feL.setVisibility(8);
                    } else if (item.getLbsInfo().bgK() == 0) {
                        if (!Bk(item.getLbsInfo().getDistance()) || !dp(item.getLbsInfo().getTime())) {
                            c0524a.feK.setVisibility(8);
                            c0524a.feL.setVisibility(8);
                        } else {
                            c0524a.feK.setVisibility(0);
                            c0524a.feL.setVisibility(0);
                            c0524a.feK.setText(item.getLbsInfo().getDistance());
                            c0524a.feL.setText(as.getTimeInterval(item.getLbsInfo().getTime()));
                            ao.setViewTextColor(c0524a.feK, this.feG, 1);
                            this.feH = ao.getDrawable(R.drawable.icon_friend_pin);
                            this.feH.setBounds(0, 0, this.size, this.size);
                            c0524a.feK.setCompoundDrawables(this.feH, null, null, null);
                            this.feI = ao.getDrawable(R.drawable.icon_friend_time);
                            this.feI.setBounds(0, 0, this.size, this.size);
                            c0524a.feL.setCompoundDrawables(this.feI, null, null, null);
                            ao.setViewTextColor(c0524a.feL, this.feG, 1);
                        }
                    } else {
                        c0524a.feK.setVisibility(8);
                        c0524a.feL.setVisibility(8);
                    }
                } else {
                    c0524a.feK.setVisibility(8);
                    c0524a.feL.setVisibility(8);
                }
                ao.setViewTextColor(c0524a.feD, this.feE, 1);
                String bgI = item.bgI();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bgI) || item2 == null || bgI.equals(item2.bgI())) ? false : true) {
                    c0524a.dWz.setVisibility(4);
                } else {
                    c0524a.dWz.setVisibility(0);
                    ao.setBackgroundResource(c0524a.dWz, R.color.cp_bg_line_c);
                }
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ao.setViewTextColor(c0524a.feD, this.feE, 1);
                ao.setBackgroundResource(c0524a.dWz, R.color.cp_bg_line_c);
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Bk(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean dp(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void b(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ao.setViewTextColor(textView, R.color.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = R.drawable.icon_news_head_prompt_two;
        }
        ao.setBackgroundResource(textView, i2);
    }

    /* loaded from: classes15.dex */
    private class c {
        ImageView bCQ;
        View dWz;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes15.dex */
    private class b {
        View dWz;
        TextView feN;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0524a {
        View dWz;
        HeadImageView feC;
        TextView feD;
        TextView feK;
        TextView feL;

        private C0524a() {
        }
    }
}
