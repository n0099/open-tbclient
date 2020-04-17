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
    private int eAN;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eAZ;
    private int eBc = R.color.cp_cont_b;
    private int eBd = R.color.cp_cont_c;
    private int eBe = R.color.cp_cont_d;
    private Drawable eBf;
    private Drawable eBg;
    private boolean eBh;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.eBh = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.eBh = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eAZ = list;
        notifyDataSetChanged();
    }

    public void oA(int i) {
        this.eAN = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.eBh ? 3 : 2;
        return this.eAZ == null ? i : i + this.eAZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oz */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.eBh ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.eAZ.get(i - i2);
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
        if (i == 2 && this.eBh) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aUQ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aUP())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0438a c0438a;
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
                cVar4.bqb = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.dvs = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.bqb, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.eBc, 1);
            am.setBackgroundResource(cVar3.dvs, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.eAN);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bqb = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.dvs = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.bqb, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.eBc, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.dvs, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bqb = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.bqb, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.eBc, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.eBl = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.dvs = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aUQ() != null) {
                    bVar.eBl.setText(item.aUQ());
                }
                am.setViewTextColor(bVar.eBl, this.eBd, 1);
                am.setBackgroundResource(bVar.dvs, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0438a)) {
                    C0438a c0438a2 = new C0438a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0438a2.eBa = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0438a2.eBb = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0438a2.eBi = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0438a2.eBj = (TextView) view.findViewById(R.id.detail_info_time);
                    c0438a2.dvs = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0438a2);
                    c0438a = c0438a2;
                } else {
                    c0438a = (C0438a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0438a.eBb.setText(item.getUserName());
                    c0438a.eBa.startLoad(item.aUP(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aUS() == 1) {
                        c0438a.eBi.setVisibility(0);
                        am.setViewTextColor(c0438a.eBi, this.eBe, 1);
                        c0438a.eBi.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0438a.eBi.setCompoundDrawables(null, null, null, null);
                        c0438a.eBj.setVisibility(8);
                    } else if (item.getLbsInfo().aUS() == 0) {
                        if (!yx(item.getLbsInfo().getDistance()) || !cX(item.getLbsInfo().getTime())) {
                            c0438a.eBi.setVisibility(8);
                            c0438a.eBj.setVisibility(8);
                        } else {
                            c0438a.eBi.setVisibility(0);
                            c0438a.eBj.setVisibility(0);
                            c0438a.eBi.setText(item.getLbsInfo().getDistance());
                            c0438a.eBj.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0438a.eBi, this.eBe, 1);
                            this.eBf = am.getDrawable(R.drawable.icon_friend_pin);
                            this.eBf.setBounds(0, 0, this.size, this.size);
                            c0438a.eBi.setCompoundDrawables(this.eBf, null, null, null);
                            this.eBg = am.getDrawable(R.drawable.icon_friend_time);
                            this.eBg.setBounds(0, 0, this.size, this.size);
                            c0438a.eBj.setCompoundDrawables(this.eBg, null, null, null);
                            am.setViewTextColor(c0438a.eBj, this.eBe, 1);
                        }
                    } else {
                        c0438a.eBi.setVisibility(8);
                        c0438a.eBj.setVisibility(8);
                    }
                } else {
                    c0438a.eBi.setVisibility(8);
                    c0438a.eBj.setVisibility(8);
                }
                am.setViewTextColor(c0438a.eBb, this.eBc, 1);
                String aUQ = item.aUQ();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aUQ) || item2 == null || aUQ.equals(item2.aUQ())) ? false : true) {
                    c0438a.dvs.setVisibility(4);
                } else {
                    c0438a.dvs.setVisibility(0);
                    am.setBackgroundResource(c0438a.dvs, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0438a.eBb, this.eBc, 1);
                am.setBackgroundResource(c0438a.dvs, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean yx(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean cX(long j) {
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

    /* loaded from: classes8.dex */
    private class c {
        ImageView bqb;
        View dvs;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View dvs;
        TextView eBl;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0438a {
        View dvs;
        HeadImageView eBa;
        TextView eBb;
        TextView eBi;
        TextView eBj;

        private C0438a() {
        }
    }
}
