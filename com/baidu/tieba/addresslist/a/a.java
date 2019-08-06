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
    private boolean cYA;
    private int cYh;
    private List<com.baidu.tbadk.coreExtra.relationship.a> cYs;
    private int cYv = R.color.cp_cont_b;
    private int cYw = R.color.cp_cont_c;
    private int cYx = R.color.cp_cont_d;
    private Drawable cYy;
    private Drawable cYz;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.cYA = true;
        this.mContext = context;
        this.size = l.g(this.mContext, R.dimen.ds24);
        this.cYA = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYs = list;
        notifyDataSetChanged();
    }

    public void my(int i) {
        this.cYh = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.cYA ? 3 : 2;
        return this.cYs == null ? i : i + this.cYs.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mx */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.cYA ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.cYs.get(i - i2);
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
        if (i == 2 && this.cYA) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.apV()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.apU())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0272a c0272a;
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
                cVar4.cYF = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.c(cVar3.cYF, (int) R.drawable.icon_new_friend);
            am.f(cVar3.title, this.cYv, 1);
            am.k(cVar3.divider, R.color.cp_bg_line_b);
            am.k(view, R.drawable.addresslist_item_bg);
            g((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.cYh);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.cYF = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.c(cVar2.cYF, (int) R.drawable.icon_add_friend);
            am.f(cVar2.title, this.cYv, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.k(cVar2.divider, R.color.cp_bg_line_b);
            am.k(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.cYF = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.c(cVar.cYF, (int) R.drawable.icon_me_group);
            am.f(cVar.title, this.cYv, 1);
            am.k(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.cYE = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.apV() != null) {
                    bVar.cYE.setText(item.apV());
                }
                am.f(bVar.cYE, this.cYw, 1);
                am.k(bVar.divider, R.color.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0272a)) {
                    C0272a c0272a2 = new C0272a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0272a2.cYt = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0272a2.cYu = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0272a2.cYB = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0272a2.cYC = (TextView) view.findViewById(R.id.detail_info_time);
                    c0272a2.divider = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0272a2);
                    c0272a = c0272a2;
                } else {
                    c0272a = (C0272a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0272a.cYu.setText(item.getUserName());
                    c0272a.cYt.startLoad(item.apU(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().apX() == 1) {
                        c0272a.cYB.setVisibility(0);
                        am.f(c0272a.cYB, this.cYx, 1);
                        c0272a.cYB.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0272a.cYB.setCompoundDrawables(null, null, null, null);
                        c0272a.cYC.setVisibility(8);
                    } else if (item.getLbsInfo().apX() == 0) {
                        if (!sx(item.getLbsInfo().getDistance()) || !bO(item.getLbsInfo().getTime())) {
                            c0272a.cYB.setVisibility(8);
                            c0272a.cYC.setVisibility(8);
                        } else {
                            c0272a.cYB.setVisibility(0);
                            c0272a.cYC.setVisibility(0);
                            c0272a.cYB.setText(item.getLbsInfo().getDistance());
                            c0272a.cYC.setText(aq.aB(item.getLbsInfo().getTime()));
                            am.f(c0272a.cYB, this.cYx, 1);
                            this.cYy = am.getDrawable(R.drawable.icon_friend_pin);
                            this.cYy.setBounds(0, 0, this.size, this.size);
                            c0272a.cYB.setCompoundDrawables(this.cYy, null, null, null);
                            this.cYz = am.getDrawable(R.drawable.icon_friend_time);
                            this.cYz.setBounds(0, 0, this.size, this.size);
                            c0272a.cYC.setCompoundDrawables(this.cYz, null, null, null);
                            am.f(c0272a.cYC, this.cYx, 1);
                        }
                    } else {
                        c0272a.cYB.setVisibility(8);
                        c0272a.cYC.setVisibility(8);
                    }
                } else {
                    c0272a.cYB.setVisibility(8);
                    c0272a.cYC.setVisibility(8);
                }
                am.f(c0272a.cYu, this.cYv, 1);
                String apV = item.apV();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(apV) || item2 == null || apV.equals(item2.apV())) ? false : true) {
                    c0272a.divider.setVisibility(4);
                } else {
                    c0272a.divider.setVisibility(0);
                    am.k(c0272a.divider, R.color.cp_bg_line_b);
                }
                am.k(view, R.drawable.addresslist_item_bg);
                am.f(c0272a.cYu, this.cYv, 1);
                am.k(c0272a.divider, R.color.cp_bg_line_b);
                am.k(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean sx(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean bO(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void g(TextView textView, int i) {
        int i2 = R.drawable.icon_news_head_prompt_two;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        am.f(textView, R.color.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = R.drawable.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
        } else {
            textView.setText("99+");
        }
        am.k(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView cYF;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView cYE;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0272a {
        TextView cYB;
        TextView cYC;
        HeadImageView cYt;
        TextView cYu;
        View divider;

        private C0272a() {
        }
    }
}
