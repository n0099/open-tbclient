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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int eZN;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eZZ;
    private int fac = R.color.cp_cont_b;
    private int fad = R.color.cp_cont_c;
    private int fae = R.color.cp_cont_d;
    private Drawable faf;
    private Drawable fag;
    private boolean fah;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.fah = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.fah = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eZZ = list;
        notifyDataSetChanged();
    }

    public void pI(int i) {
        this.eZN = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.fah ? 3 : 2;
        return this.eZZ == null ? i : i + this.eZZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pH */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.fah ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.eZZ.get(i - i2);
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
        if (i == 2 && this.fah) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bdb()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bda())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0514a c0514a;
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
                cVar4.bCy = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.dQh = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            an.setImageResource(cVar3.bCy, R.drawable.icon_new_friend);
            an.setViewTextColor(cVar3.title, this.fac, 1);
            an.setBackgroundResource(cVar3.dQh, R.color.cp_bg_line_c);
            an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.eZN);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bCy = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.dQh = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            an.setImageResource(cVar2.bCy, R.drawable.icon_add_friend);
            an.setViewTextColor(cVar2.title, this.fac, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            an.setBackgroundResource(cVar2.dQh, R.color.cp_bg_line_c);
            an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bCy = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            an.setImageResource(cVar.bCy, R.drawable.icon_me_group);
            an.setViewTextColor(cVar.title, this.fac, 1);
            an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fal = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.dQh = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bdb() != null) {
                    bVar.fal.setText(item.bdb());
                }
                an.setViewTextColor(bVar.fal, this.fad, 1);
                an.setBackgroundResource(bVar.dQh, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0514a)) {
                    C0514a c0514a2 = new C0514a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0514a2.faa = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0514a2.fab = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0514a2.fai = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0514a2.faj = (TextView) view.findViewById(R.id.detail_info_time);
                    c0514a2.dQh = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0514a2);
                    c0514a = c0514a2;
                } else {
                    c0514a = (C0514a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0514a.fab.setText(item.getUserName());
                    c0514a.faa.startLoad(item.bda(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bdd() == 1) {
                        c0514a.fai.setVisibility(0);
                        an.setViewTextColor(c0514a.fai, this.fae, 1);
                        c0514a.fai.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0514a.fai.setCompoundDrawables(null, null, null, null);
                        c0514a.faj.setVisibility(8);
                    } else if (item.getLbsInfo().bdd() == 0) {
                        if (!Az(item.getLbsInfo().getDistance()) || !db(item.getLbsInfo().getTime())) {
                            c0514a.fai.setVisibility(8);
                            c0514a.faj.setVisibility(8);
                        } else {
                            c0514a.fai.setVisibility(0);
                            c0514a.faj.setVisibility(0);
                            c0514a.fai.setText(item.getLbsInfo().getDistance());
                            c0514a.faj.setText(ar.getTimeInterval(item.getLbsInfo().getTime()));
                            an.setViewTextColor(c0514a.fai, this.fae, 1);
                            this.faf = an.getDrawable(R.drawable.icon_friend_pin);
                            this.faf.setBounds(0, 0, this.size, this.size);
                            c0514a.fai.setCompoundDrawables(this.faf, null, null, null);
                            this.fag = an.getDrawable(R.drawable.icon_friend_time);
                            this.fag.setBounds(0, 0, this.size, this.size);
                            c0514a.faj.setCompoundDrawables(this.fag, null, null, null);
                            an.setViewTextColor(c0514a.faj, this.fae, 1);
                        }
                    } else {
                        c0514a.fai.setVisibility(8);
                        c0514a.faj.setVisibility(8);
                    }
                } else {
                    c0514a.fai.setVisibility(8);
                    c0514a.faj.setVisibility(8);
                }
                an.setViewTextColor(c0514a.fab, this.fac, 1);
                String bdb = item.bdb();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bdb) || item2 == null || bdb.equals(item2.bdb())) ? false : true) {
                    c0514a.dQh.setVisibility(4);
                } else {
                    c0514a.dQh.setVisibility(0);
                    an.setBackgroundResource(c0514a.dQh, R.color.cp_bg_line_c);
                }
                an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                an.setViewTextColor(c0514a.fab, this.fac, 1);
                an.setBackgroundResource(c0514a.dQh, R.color.cp_bg_line_c);
                an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Az(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean db(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void b(TextView textView, int i) {
        int i2 = R.drawable.icon_news_head_prompt_two;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        an.setViewTextColor(textView, R.color.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
        } else {
            textView.setText("99+");
        }
        an.setBackgroundResource(textView, i2);
    }

    /* loaded from: classes8.dex */
    private class c {
        ImageView bCy;
        View dQh;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View dQh;
        TextView fal;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0514a {
        View dQh;
        HeadImageView faa;
        TextView fab;
        TextView fai;
        TextView faj;

        private C0514a() {
        }
    }
}
