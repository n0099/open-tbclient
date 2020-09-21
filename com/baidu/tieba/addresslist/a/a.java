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
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private int fsY;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ftk;
    private int ftn = R.color.cp_cont_b;
    private int fto = R.color.cp_cont_c;
    private int ftq = R.color.cp_cont_d;
    private Drawable ftr;
    private Drawable fts;
    private boolean ftt;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.ftt = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.ftt = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ftk = list;
        notifyDataSetChanged();
    }

    public void sz(int i) {
        this.fsY = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.ftt ? 3 : 2;
        return this.ftk == null ? i : i + this.ftk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sy */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.ftt ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.ftk.get(i - i2);
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
        if (i == 2 && this.ftt) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bqo()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bqn())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0566a c0566a;
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
                cVar4.bKv = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.eis = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.bKv, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.ftn, 1);
            ap.setBackgroundResource(cVar3.eis, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fsY);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bKv = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.eis = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.bKv, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.ftn, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.eis, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bKv = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.bKv, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.ftn, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fty = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.eis = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bqo() != null) {
                    bVar.fty.setText(item.bqo());
                }
                ap.setViewTextColor(bVar.fty, this.fto, 1);
                ap.setBackgroundResource(bVar.eis, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0566a)) {
                    C0566a c0566a2 = new C0566a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0566a2.ftl = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0566a2.ftm = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0566a2.ftu = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0566a2.ftw = (TextView) view.findViewById(R.id.detail_info_time);
                    c0566a2.eis = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0566a2);
                    c0566a = c0566a2;
                } else {
                    c0566a = (C0566a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0566a.ftm.setText(item.getUserName());
                    c0566a.ftl.startLoad(item.bqn(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bqq() == 1) {
                        c0566a.ftu.setVisibility(0);
                        ap.setViewTextColor(c0566a.ftu, this.ftq, 1);
                        c0566a.ftu.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0566a.ftu.setCompoundDrawables(null, null, null, null);
                        c0566a.ftw.setVisibility(8);
                    } else if (item.getLbsInfo().bqq() == 0) {
                        if (!Ec(item.getLbsInfo().getDistance()) || !dB(item.getLbsInfo().getTime())) {
                            c0566a.ftu.setVisibility(8);
                            c0566a.ftw.setVisibility(8);
                        } else {
                            c0566a.ftu.setVisibility(0);
                            c0566a.ftw.setVisibility(0);
                            c0566a.ftu.setText(item.getLbsInfo().getDistance());
                            c0566a.ftw.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0566a.ftu, this.ftq, 1);
                            this.ftr = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.ftr.setBounds(0, 0, this.size, this.size);
                            c0566a.ftu.setCompoundDrawables(this.ftr, null, null, null);
                            this.fts = ap.getDrawable(R.drawable.icon_friend_time);
                            this.fts.setBounds(0, 0, this.size, this.size);
                            c0566a.ftw.setCompoundDrawables(this.fts, null, null, null);
                            ap.setViewTextColor(c0566a.ftw, this.ftq, 1);
                        }
                    } else {
                        c0566a.ftu.setVisibility(8);
                        c0566a.ftw.setVisibility(8);
                    }
                } else {
                    c0566a.ftu.setVisibility(8);
                    c0566a.ftw.setVisibility(8);
                }
                ap.setViewTextColor(c0566a.ftm, this.ftn, 1);
                String bqo = item.bqo();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bqo) || item2 == null || bqo.equals(item2.bqo())) ? false : true) {
                    c0566a.eis.setVisibility(4);
                } else {
                    c0566a.eis.setVisibility(0);
                    ap.setBackgroundResource(c0566a.eis, R.color.cp_bg_line_c);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0566a.ftm, this.ftn, 1);
                ap.setBackgroundResource(c0566a.eis, R.color.cp_bg_line_c);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Ec(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean dB(long j) {
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

    /* loaded from: classes20.dex */
    private class c {
        ImageView bKv;
        View eis;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes20.dex */
    private class b {
        View eis;
        TextView fty;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class C0566a {
        View eis;
        HeadImageView ftl;
        TextView ftm;
        TextView ftu;
        TextView ftw;

        private C0566a() {
        }
    }
}
