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
    private int eAS;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eBe;
    private int eBh = R.color.cp_cont_b;
    private int eBi = R.color.cp_cont_c;
    private int eBj = R.color.cp_cont_d;
    private Drawable eBk;
    private Drawable eBl;
    private boolean eBm;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.eBm = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.eBm = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eBe = list;
        notifyDataSetChanged();
    }

    public void oA(int i) {
        this.eAS = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.eBm ? 3 : 2;
        return this.eBe == null ? i : i + this.eBe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oz */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.eBm ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.eBe.get(i - i2);
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
        if (i == 2 && this.eBm) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aUO()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aUN())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0459a c0459a;
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
                cVar4.bqg = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.dvw = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.bqg, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.eBh, 1);
            am.setBackgroundResource(cVar3.dvw, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.eAS);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bqg = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.dvw = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.bqg, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.eBh, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.dvw, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bqg = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.bqg, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.eBh, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.eBq = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.dvw = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aUO() != null) {
                    bVar.eBq.setText(item.aUO());
                }
                am.setViewTextColor(bVar.eBq, this.eBi, 1);
                am.setBackgroundResource(bVar.dvw, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0459a)) {
                    C0459a c0459a2 = new C0459a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0459a2.eBf = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0459a2.eBg = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0459a2.eBn = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0459a2.eBo = (TextView) view.findViewById(R.id.detail_info_time);
                    c0459a2.dvw = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0459a2);
                    c0459a = c0459a2;
                } else {
                    c0459a = (C0459a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0459a.eBg.setText(item.getUserName());
                    c0459a.eBf.startLoad(item.aUN(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aUQ() == 1) {
                        c0459a.eBn.setVisibility(0);
                        am.setViewTextColor(c0459a.eBn, this.eBj, 1);
                        c0459a.eBn.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0459a.eBn.setCompoundDrawables(null, null, null, null);
                        c0459a.eBo.setVisibility(8);
                    } else if (item.getLbsInfo().aUQ() == 0) {
                        if (!yA(item.getLbsInfo().getDistance()) || !cX(item.getLbsInfo().getTime())) {
                            c0459a.eBn.setVisibility(8);
                            c0459a.eBo.setVisibility(8);
                        } else {
                            c0459a.eBn.setVisibility(0);
                            c0459a.eBo.setVisibility(0);
                            c0459a.eBn.setText(item.getLbsInfo().getDistance());
                            c0459a.eBo.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0459a.eBn, this.eBj, 1);
                            this.eBk = am.getDrawable(R.drawable.icon_friend_pin);
                            this.eBk.setBounds(0, 0, this.size, this.size);
                            c0459a.eBn.setCompoundDrawables(this.eBk, null, null, null);
                            this.eBl = am.getDrawable(R.drawable.icon_friend_time);
                            this.eBl.setBounds(0, 0, this.size, this.size);
                            c0459a.eBo.setCompoundDrawables(this.eBl, null, null, null);
                            am.setViewTextColor(c0459a.eBo, this.eBj, 1);
                        }
                    } else {
                        c0459a.eBn.setVisibility(8);
                        c0459a.eBo.setVisibility(8);
                    }
                } else {
                    c0459a.eBn.setVisibility(8);
                    c0459a.eBo.setVisibility(8);
                }
                am.setViewTextColor(c0459a.eBg, this.eBh, 1);
                String aUO = item.aUO();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aUO) || item2 == null || aUO.equals(item2.aUO())) ? false : true) {
                    c0459a.dvw.setVisibility(4);
                } else {
                    c0459a.dvw.setVisibility(0);
                    am.setBackgroundResource(c0459a.dvw, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0459a.eBg, this.eBh, 1);
                am.setBackgroundResource(c0459a.dvw, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean yA(String str) {
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
        ImageView bqg;
        View dvw;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View dvw;
        TextView eBq;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0459a {
        View dvw;
        HeadImageView eBf;
        TextView eBg;
        TextView eBn;
        TextView eBo;

        private C0459a() {
        }
    }
}
