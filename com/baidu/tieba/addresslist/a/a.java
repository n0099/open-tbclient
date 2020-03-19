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
import com.google.android.exoplayer2.Format;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int eba;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ebm;
    private int ebp = R.color.cp_cont_b;
    private int ebq = R.color.cp_cont_c;
    private int ebr = R.color.cp_cont_d;
    private Drawable ebs;
    private Drawable ebt;
    private boolean ebu;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.ebu = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.ebu = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ebm = list;
        notifyDataSetChanged();
    }

    public void on(int i) {
        this.eba = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.ebu ? 3 : 2;
        return this.ebm == null ? i : i + this.ebm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: om */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.ebu ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.ebm.get(i - i2);
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
        if (i == 2 && this.ebu) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aMt()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aMs())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0407a c0407a;
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
                cVar4.aUc = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.cWh = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.aUc, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.ebp, 1);
            am.setBackgroundResource(cVar3.cWh, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.eba);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.aUc = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.cWh = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.aUc, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.ebp, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.cWh, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.aUc = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.aUc, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.ebp, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.eby = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.cWh = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aMt() != null) {
                    bVar.eby.setText(item.aMt());
                }
                am.setViewTextColor(bVar.eby, this.ebq, 1);
                am.setBackgroundResource(bVar.cWh, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0407a)) {
                    C0407a c0407a2 = new C0407a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0407a2.ebn = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0407a2.ebo = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0407a2.ebv = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0407a2.ebw = (TextView) view.findViewById(R.id.detail_info_time);
                    c0407a2.cWh = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0407a2);
                    c0407a = c0407a2;
                } else {
                    c0407a = (C0407a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0407a.ebo.setText(item.getUserName());
                    c0407a.ebn.startLoad(item.aMs(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aMv() == 1) {
                        c0407a.ebv.setVisibility(0);
                        am.setViewTextColor(c0407a.ebv, this.ebr, 1);
                        c0407a.ebv.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0407a.ebv.setCompoundDrawables(null, null, null, null);
                        c0407a.ebw.setVisibility(8);
                    } else if (item.getLbsInfo().aMv() == 0) {
                        if (!xl(item.getLbsInfo().getDistance()) || !cq(item.getLbsInfo().getTime())) {
                            c0407a.ebv.setVisibility(8);
                            c0407a.ebw.setVisibility(8);
                        } else {
                            c0407a.ebv.setVisibility(0);
                            c0407a.ebw.setVisibility(0);
                            c0407a.ebv.setText(item.getLbsInfo().getDistance());
                            c0407a.ebw.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0407a.ebv, this.ebr, 1);
                            this.ebs = am.getDrawable(R.drawable.icon_friend_pin);
                            this.ebs.setBounds(0, 0, this.size, this.size);
                            c0407a.ebv.setCompoundDrawables(this.ebs, null, null, null);
                            this.ebt = am.getDrawable(R.drawable.icon_friend_time);
                            this.ebt.setBounds(0, 0, this.size, this.size);
                            c0407a.ebw.setCompoundDrawables(this.ebt, null, null, null);
                            am.setViewTextColor(c0407a.ebw, this.ebr, 1);
                        }
                    } else {
                        c0407a.ebv.setVisibility(8);
                        c0407a.ebw.setVisibility(8);
                    }
                } else {
                    c0407a.ebv.setVisibility(8);
                    c0407a.ebw.setVisibility(8);
                }
                am.setViewTextColor(c0407a.ebo, this.ebp, 1);
                String aMt = item.aMt();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aMt) || item2 == null || aMt.equals(item2.aMt())) ? false : true) {
                    c0407a.cWh.setVisibility(4);
                } else {
                    c0407a.cWh.setVisibility(0);
                    am.setBackgroundResource(c0407a.cWh, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0407a.ebo, this.ebp, 1);
                am.setBackgroundResource(c0407a.cWh, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean xl(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean cq(long j) {
        return j > 0 && j < Format.OFFSET_SAMPLE_RELATIVE;
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
        ImageView aUc;
        View cWh;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View cWh;
        TextView eby;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0407a {
        View cWh;
        HeadImageView ebn;
        TextView ebo;
        TextView ebv;
        TextView ebw;

        private C0407a() {
        }
    }
}
