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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int diA;
    private List<com.baidu.tbadk.coreExtra.relationship.a> diL;
    private int diO = R.color.cp_cont_b;
    private int diP = R.color.cp_cont_c;
    private int diQ = R.color.cp_cont_d;
    private Drawable diR;
    private Drawable diS;
    private boolean diT;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.diT = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.diT = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.diL = list;
        notifyDataSetChanged();
    }

    public void lG(int i) {
        this.diA = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.diT ? 3 : 2;
        return this.diL == null ? i : i + this.diL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lF */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.diT ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.diL.get(i - i2);
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
        if (i == 2 && this.diT) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.arZ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.arY())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0313a c0313a;
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
                cVar4.diY = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.cfh = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.diY, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.diO, 1);
            am.setBackgroundResource(cVar3.cfh, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.diA);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.diY = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.cfh = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.diY, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.diO, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.cfh, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.diY = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.diY, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.diO, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.diX = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.cfh = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.arZ() != null) {
                    bVar.diX.setText(item.arZ());
                }
                am.setViewTextColor(bVar.diX, this.diP, 1);
                am.setBackgroundResource(bVar.cfh, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0313a)) {
                    C0313a c0313a2 = new C0313a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0313a2.diM = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0313a2.diN = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0313a2.diU = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0313a2.diV = (TextView) view.findViewById(R.id.detail_info_time);
                    c0313a2.cfh = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0313a2);
                    c0313a = c0313a2;
                } else {
                    c0313a = (C0313a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0313a.diN.setText(item.getUserName());
                    c0313a.diM.startLoad(item.arY(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().asb() == 1) {
                        c0313a.diU.setVisibility(0);
                        am.setViewTextColor(c0313a.diU, this.diQ, 1);
                        c0313a.diU.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0313a.diU.setCompoundDrawables(null, null, null, null);
                        c0313a.diV.setVisibility(8);
                    } else if (item.getLbsInfo().asb() == 0) {
                        if (!rF(item.getLbsInfo().getDistance()) || !bF(item.getLbsInfo().getTime())) {
                            c0313a.diU.setVisibility(8);
                            c0313a.diV.setVisibility(8);
                        } else {
                            c0313a.diU.setVisibility(0);
                            c0313a.diV.setVisibility(0);
                            c0313a.diU.setText(item.getLbsInfo().getDistance());
                            c0313a.diV.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0313a.diU, this.diQ, 1);
                            this.diR = am.getDrawable(R.drawable.icon_friend_pin);
                            this.diR.setBounds(0, 0, this.size, this.size);
                            c0313a.diU.setCompoundDrawables(this.diR, null, null, null);
                            this.diS = am.getDrawable(R.drawable.icon_friend_time);
                            this.diS.setBounds(0, 0, this.size, this.size);
                            c0313a.diV.setCompoundDrawables(this.diS, null, null, null);
                            am.setViewTextColor(c0313a.diV, this.diQ, 1);
                        }
                    } else {
                        c0313a.diU.setVisibility(8);
                        c0313a.diV.setVisibility(8);
                    }
                } else {
                    c0313a.diU.setVisibility(8);
                    c0313a.diV.setVisibility(8);
                }
                am.setViewTextColor(c0313a.diN, this.diO, 1);
                String arZ = item.arZ();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(arZ) || item2 == null || arZ.equals(item2.arZ())) ? false : true) {
                    c0313a.cfh.setVisibility(4);
                } else {
                    c0313a.cfh.setVisibility(0);
                    am.setBackgroundResource(c0313a.cfh, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0313a.diN, this.diO, 1);
                am.setBackgroundResource(c0313a.cfh, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean rF(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean bF(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void a(TextView textView, int i) {
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

    /* loaded from: classes3.dex */
    private class c {
        View cfh;
        ImageView diY;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        View cfh;
        TextView diX;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0313a {
        View cfh;
        HeadImageView diM;
        TextView diN;
        TextView diU;
        TextView diV;

        private C0313a() {
        }
    }
}
