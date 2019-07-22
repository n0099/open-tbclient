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
    private int cYa;
    private List<com.baidu.tbadk.coreExtra.relationship.a> cYl;
    private int cYo = R.color.cp_cont_b;
    private int cYp = R.color.cp_cont_c;
    private int cYq = R.color.cp_cont_d;
    private Drawable cYr;
    private Drawable cYs;
    private boolean cYt;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.cYt = true;
        this.mContext = context;
        this.size = l.g(this.mContext, R.dimen.ds24);
        this.cYt = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYl = list;
        notifyDataSetChanged();
    }

    public void mx(int i) {
        this.cYa = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.cYt ? 3 : 2;
        return this.cYl == null ? i : i + this.cYl.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mw */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.cYt ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.cYl.get(i - i2);
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
        if (i == 2 && this.cYt) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.apT()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.apS())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0267a c0267a;
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
                cVar4.cYy = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.c(cVar3.cYy, (int) R.drawable.icon_new_friend);
            am.f(cVar3.title, this.cYo, 1);
            am.k(cVar3.divider, R.color.cp_bg_line_b);
            am.k(view, R.drawable.addresslist_item_bg);
            g((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.cYa);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.cYy = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.c(cVar2.cYy, (int) R.drawable.icon_add_friend);
            am.f(cVar2.title, this.cYo, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.k(cVar2.divider, R.color.cp_bg_line_b);
            am.k(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.cYy = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.c(cVar.cYy, (int) R.drawable.icon_me_group);
            am.f(cVar.title, this.cYo, 1);
            am.k(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.cYx = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.apT() != null) {
                    bVar.cYx.setText(item.apT());
                }
                am.f(bVar.cYx, this.cYp, 1);
                am.k(bVar.divider, R.color.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0267a)) {
                    C0267a c0267a2 = new C0267a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0267a2.cYm = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0267a2.cYn = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0267a2.cYu = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0267a2.cYv = (TextView) view.findViewById(R.id.detail_info_time);
                    c0267a2.divider = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0267a2);
                    c0267a = c0267a2;
                } else {
                    c0267a = (C0267a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0267a.cYn.setText(item.getUserName());
                    c0267a.cYm.startLoad(item.apS(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().apV() == 1) {
                        c0267a.cYu.setVisibility(0);
                        am.f(c0267a.cYu, this.cYq, 1);
                        c0267a.cYu.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0267a.cYu.setCompoundDrawables(null, null, null, null);
                        c0267a.cYv.setVisibility(8);
                    } else if (item.getLbsInfo().apV() == 0) {
                        if (!sx(item.getLbsInfo().getDistance()) || !bO(item.getLbsInfo().getTime())) {
                            c0267a.cYu.setVisibility(8);
                            c0267a.cYv.setVisibility(8);
                        } else {
                            c0267a.cYu.setVisibility(0);
                            c0267a.cYv.setVisibility(0);
                            c0267a.cYu.setText(item.getLbsInfo().getDistance());
                            c0267a.cYv.setText(aq.aB(item.getLbsInfo().getTime()));
                            am.f(c0267a.cYu, this.cYq, 1);
                            this.cYr = am.getDrawable(R.drawable.icon_friend_pin);
                            this.cYr.setBounds(0, 0, this.size, this.size);
                            c0267a.cYu.setCompoundDrawables(this.cYr, null, null, null);
                            this.cYs = am.getDrawable(R.drawable.icon_friend_time);
                            this.cYs.setBounds(0, 0, this.size, this.size);
                            c0267a.cYv.setCompoundDrawables(this.cYs, null, null, null);
                            am.f(c0267a.cYv, this.cYq, 1);
                        }
                    } else {
                        c0267a.cYu.setVisibility(8);
                        c0267a.cYv.setVisibility(8);
                    }
                } else {
                    c0267a.cYu.setVisibility(8);
                    c0267a.cYv.setVisibility(8);
                }
                am.f(c0267a.cYn, this.cYo, 1);
                String apT = item.apT();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(apT) || item2 == null || apT.equals(item2.apT())) ? false : true) {
                    c0267a.divider.setVisibility(4);
                } else {
                    c0267a.divider.setVisibility(0);
                    am.k(c0267a.divider, R.color.cp_bg_line_b);
                }
                am.k(view, R.drawable.addresslist_item_bg);
                am.f(c0267a.cYn, this.cYo, 1);
                am.k(c0267a.divider, R.color.cp_bg_line_b);
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
        ImageView cYy;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView cYx;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0267a {
        HeadImageView cYm;
        TextView cYn;
        TextView cYu;
        TextView cYv;
        View divider;

        private C0267a() {
        }
    }
}
