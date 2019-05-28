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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private int cWD;
    private List<com.baidu.tbadk.coreExtra.relationship.a> cWO;
    private int cWR = R.color.cp_cont_b;
    private int cWS = R.color.cp_cont_c;
    private int cWT = R.color.cp_cont_d;
    private Drawable cWU;
    private Drawable cWV;
    private boolean cWW;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.cWW = true;
        this.mContext = context;
        this.size = l.g(this.mContext, R.dimen.ds24);
        this.cWW = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cWO = list;
        notifyDataSetChanged();
    }

    public void mq(int i) {
        this.cWD = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.cWW ? 3 : 2;
        return this.cWO == null ? i : i + this.cWO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mp */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.cWW ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.cWO.get(i - i2);
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
        if (i == 2 && this.cWW) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aoN()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aoM())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0270a c0270a;
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
                cVar4.cXb = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            al.c(cVar3.cXb, (int) R.drawable.icon_new_friend);
            al.f(cVar3.title, this.cWR, 1);
            al.k(cVar3.divider, R.color.cp_bg_line_b);
            al.k(view, R.drawable.addresslist_item_bg);
            g((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.cWD);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.cXb = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            al.c(cVar2.cXb, (int) R.drawable.icon_add_friend);
            al.f(cVar2.title, this.cWR, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            al.k(cVar2.divider, R.color.cp_bg_line_b);
            al.k(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.cXb = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            al.c(cVar.cXb, (int) R.drawable.icon_me_group);
            al.f(cVar.title, this.cWR, 1);
            al.k(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.cXa = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aoN() != null) {
                    bVar.cXa.setText(item.aoN());
                }
                al.f(bVar.cXa, this.cWS, 1);
                al.k(bVar.divider, R.color.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0270a)) {
                    C0270a c0270a2 = new C0270a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0270a2.cWP = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0270a2.cWQ = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0270a2.cWX = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0270a2.cWY = (TextView) view.findViewById(R.id.detail_info_time);
                    c0270a2.divider = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0270a2);
                    c0270a = c0270a2;
                } else {
                    c0270a = (C0270a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0270a.cWQ.setText(item.getUserName());
                    c0270a.cWP.startLoad(item.aoM(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aoP() == 1) {
                        c0270a.cWX.setVisibility(0);
                        al.f(c0270a.cWX, this.cWT, 1);
                        c0270a.cWX.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0270a.cWX.setCompoundDrawables(null, null, null, null);
                        c0270a.cWY.setVisibility(8);
                    } else if (item.getLbsInfo().aoP() == 0) {
                        if (!sf(item.getLbsInfo().getDistance()) || !bN(item.getLbsInfo().getTime())) {
                            c0270a.cWX.setVisibility(8);
                            c0270a.cWY.setVisibility(8);
                        } else {
                            c0270a.cWX.setVisibility(0);
                            c0270a.cWY.setVisibility(0);
                            c0270a.cWX.setText(item.getLbsInfo().getDistance());
                            c0270a.cWY.setText(ap.aA(item.getLbsInfo().getTime()));
                            al.f(c0270a.cWX, this.cWT, 1);
                            this.cWU = al.getDrawable(R.drawable.icon_friend_pin);
                            this.cWU.setBounds(0, 0, this.size, this.size);
                            c0270a.cWX.setCompoundDrawables(this.cWU, null, null, null);
                            this.cWV = al.getDrawable(R.drawable.icon_friend_time);
                            this.cWV.setBounds(0, 0, this.size, this.size);
                            c0270a.cWY.setCompoundDrawables(this.cWV, null, null, null);
                            al.f(c0270a.cWY, this.cWT, 1);
                        }
                    } else {
                        c0270a.cWX.setVisibility(8);
                        c0270a.cWY.setVisibility(8);
                    }
                } else {
                    c0270a.cWX.setVisibility(8);
                    c0270a.cWY.setVisibility(8);
                }
                al.f(c0270a.cWQ, this.cWR, 1);
                String aoN = item.aoN();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aoN) || item2 == null || aoN.equals(item2.aoN())) ? false : true) {
                    c0270a.divider.setVisibility(4);
                } else {
                    c0270a.divider.setVisibility(0);
                    al.k(c0270a.divider, R.color.cp_bg_line_b);
                }
                al.k(view, R.drawable.addresslist_item_bg);
                al.f(c0270a.cWQ, this.cWR, 1);
                al.k(c0270a.divider, R.color.cp_bg_line_b);
                al.k(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean sf(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean bN(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void g(TextView textView, int i) {
        int i2 = R.drawable.icon_news_head_prompt_two;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        al.f(textView, R.color.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
        } else {
            textView.setText("99+");
        }
        al.k(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView cXb;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView cXa;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0270a {
        HeadImageView cWP;
        TextView cWQ;
        TextView cWX;
        TextView cWY;
        View divider;

        private C0270a() {
        }
    }
}
