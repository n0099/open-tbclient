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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes15.dex */
public class a extends BaseAdapter {
    private int fpI;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fpU;
    private int fpX = R.color.cp_cont_b;
    private int fpY = R.color.cp_cont_c;
    private int fpZ = R.color.cp_cont_d;
    private Drawable fqa;
    private Drawable fqb;
    private boolean fqc;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.fqc = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.fqc = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fpU = list;
        notifyDataSetChanged();
    }

    public void sh(int i) {
        this.fpI = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.fqc ? 3 : 2;
        return this.fpU == null ? i : i + this.fpU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sg */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.fqc ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.fpU.get(i - i2);
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
        if (i == 2 && this.fqc) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bpt()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bps())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0570a c0570a;
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
                cVar4.bIq = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.efZ = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.bIq, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.fpX, 1);
            ap.setBackgroundResource(cVar3.efZ, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fpI);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bIq = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.efZ = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.bIq, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.fpX, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.efZ, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bIq = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.bIq, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.fpX, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fqg = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.efZ = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bpt() != null) {
                    bVar.fqg.setText(item.bpt());
                }
                ap.setViewTextColor(bVar.fqg, this.fpY, 1);
                ap.setBackgroundResource(bVar.efZ, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0570a)) {
                    C0570a c0570a2 = new C0570a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0570a2.fpV = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0570a2.fpW = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0570a2.fqd = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0570a2.fqe = (TextView) view.findViewById(R.id.detail_info_time);
                    c0570a2.efZ = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0570a2);
                    c0570a = c0570a2;
                } else {
                    c0570a = (C0570a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0570a.fpW.setText(item.getUserName());
                    c0570a.fpV.startLoad(item.bps(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bpv() == 1) {
                        c0570a.fqd.setVisibility(0);
                        ap.setViewTextColor(c0570a.fqd, this.fpZ, 1);
                        c0570a.fqd.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0570a.fqd.setCompoundDrawables(null, null, null, null);
                        c0570a.fqe.setVisibility(8);
                    } else if (item.getLbsInfo().bpv() == 0) {
                        if (!DE(item.getLbsInfo().getDistance()) || !dA(item.getLbsInfo().getTime())) {
                            c0570a.fqd.setVisibility(8);
                            c0570a.fqe.setVisibility(8);
                        } else {
                            c0570a.fqd.setVisibility(0);
                            c0570a.fqe.setVisibility(0);
                            c0570a.fqd.setText(item.getLbsInfo().getDistance());
                            c0570a.fqe.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0570a.fqd, this.fpZ, 1);
                            this.fqa = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.fqa.setBounds(0, 0, this.size, this.size);
                            c0570a.fqd.setCompoundDrawables(this.fqa, null, null, null);
                            this.fqb = ap.getDrawable(R.drawable.icon_friend_time);
                            this.fqb.setBounds(0, 0, this.size, this.size);
                            c0570a.fqe.setCompoundDrawables(this.fqb, null, null, null);
                            ap.setViewTextColor(c0570a.fqe, this.fpZ, 1);
                        }
                    } else {
                        c0570a.fqd.setVisibility(8);
                        c0570a.fqe.setVisibility(8);
                    }
                } else {
                    c0570a.fqd.setVisibility(8);
                    c0570a.fqe.setVisibility(8);
                }
                ap.setViewTextColor(c0570a.fpW, this.fpX, 1);
                String bpt = item.bpt();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bpt) || item2 == null || bpt.equals(item2.bpt())) ? false : true) {
                    c0570a.efZ.setVisibility(4);
                } else {
                    c0570a.efZ.setVisibility(0);
                    ap.setBackgroundResource(c0570a.efZ, R.color.cp_bg_line_c);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0570a.fpW, this.fpX, 1);
                ap.setBackgroundResource(c0570a.efZ, R.color.cp_bg_line_c);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean DE(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean dA(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void b(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ap.setViewTextColor(textView, R.color.common_color_10225, 1);
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
        ap.setBackgroundResource(textView, i2);
    }

    /* loaded from: classes15.dex */
    private class c {
        ImageView bIq;
        View efZ;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes15.dex */
    private class b {
        View efZ;
        TextView fqg;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0570a {
        View efZ;
        HeadImageView fpV;
        TextView fpW;
        TextView fqd;
        TextView fqe;

        private C0570a() {
        }
    }
}
