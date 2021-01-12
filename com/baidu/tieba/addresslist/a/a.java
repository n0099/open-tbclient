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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private int gfW;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ggi;
    private int ggl = R.color.CAM_X0105;
    private int ggm = R.color.CAM_X0108;
    private int ggn = R.color.CAM_X0109;
    private Drawable ggo;
    private Drawable ggp;
    private boolean ggq;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.ggq = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.ggq = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ggi = list;
        notifyDataSetChanged();
    }

    public void sZ(int i) {
        this.gfW = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.ggq ? 3 : 2;
        return this.ggi == null ? i : i + this.ggi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sY */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.ggq ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.ggi.get(i - i2);
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
        if (i == 2 && this.ggq) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.byH()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0595a c0595a;
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
                cVar4.icon = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.bPy = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ao.setImageResource(cVar3.icon, R.drawable.icon_new_friend);
            ao.setViewTextColor(cVar3.title, this.ggl, 1);
            ao.setBackgroundResource(cVar3.bPy, R.color.CAM_X0204);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.gfW);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.icon = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.bPy = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ao.setImageResource(cVar2.icon, R.drawable.icon_add_friend);
            ao.setViewTextColor(cVar2.title, this.ggl, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ao.setBackgroundResource(cVar2.bPy, R.color.CAM_X0204);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.icon = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ao.setImageResource(cVar.icon, R.drawable.icon_me_group);
            ao.setViewTextColor(cVar.title, this.ggl, 1);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.ggu = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.bPy = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.byH() != null) {
                    bVar.ggu.setText(item.byH());
                }
                ao.setViewTextColor(bVar.ggu, this.ggm, 1);
                ao.setBackgroundResource(bVar.bPy, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0595a)) {
                    C0595a c0595a2 = new C0595a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0595a2.ggj = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0595a2.ggk = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0595a2.ggr = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0595a2.ggs = (TextView) view.findViewById(R.id.detail_info_time);
                    c0595a2.bPy = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0595a2);
                    c0595a = c0595a2;
                } else {
                    c0595a = (C0595a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0595a.ggk.setText(item.getUserName());
                    c0595a.ggj.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().byJ() == 1) {
                        c0595a.ggr.setVisibility(0);
                        ao.setViewTextColor(c0595a.ggr, this.ggn, 1);
                        c0595a.ggr.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0595a.ggr.setCompoundDrawables(null, null, null, null);
                        c0595a.ggs.setVisibility(8);
                    } else if (item.getLbsInfo().byJ() == 0) {
                        if (!Ev(item.getLbsInfo().getDistance()) || !eL(item.getLbsInfo().getTime())) {
                            c0595a.ggr.setVisibility(8);
                            c0595a.ggs.setVisibility(8);
                        } else {
                            c0595a.ggr.setVisibility(0);
                            c0595a.ggs.setVisibility(0);
                            c0595a.ggr.setText(item.getLbsInfo().getDistance());
                            c0595a.ggs.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ao.setViewTextColor(c0595a.ggr, this.ggn, 1);
                            this.ggo = ao.getDrawable(R.drawable.icon_friend_pin);
                            this.ggo.setBounds(0, 0, this.size, this.size);
                            c0595a.ggr.setCompoundDrawables(this.ggo, null, null, null);
                            this.ggp = ao.getDrawable(R.drawable.icon_friend_time);
                            this.ggp.setBounds(0, 0, this.size, this.size);
                            c0595a.ggs.setCompoundDrawables(this.ggp, null, null, null);
                            ao.setViewTextColor(c0595a.ggs, this.ggn, 1);
                        }
                    } else {
                        c0595a.ggr.setVisibility(8);
                        c0595a.ggs.setVisibility(8);
                    }
                } else {
                    c0595a.ggr.setVisibility(8);
                    c0595a.ggs.setVisibility(8);
                }
                ao.setViewTextColor(c0595a.ggk, this.ggl, 1);
                String byH = item.byH();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(byH) || item2 == null || byH.equals(item2.byH())) ? false : true) {
                    c0595a.bPy.setVisibility(4);
                } else {
                    c0595a.bPy.setVisibility(0);
                    ao.setBackgroundResource(c0595a.bPy, R.color.CAM_X0204);
                }
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ao.setViewTextColor(c0595a.ggk, this.ggl, 1);
                ao.setBackgroundResource(c0595a.bPy, R.color.CAM_X0204);
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Ev(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean eL(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void b(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        ao.setViewTextColor(textView, R.color.common_color_10225, 1);
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
        ao.setBackgroundResource(textView, i2);
    }

    /* loaded from: classes7.dex */
    private class c {
        View bPy;
        ImageView icon;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        View bPy;
        TextView ggu;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0595a {
        View bPy;
        HeadImageView ggj;
        TextView ggk;
        TextView ggr;
        TextView ggs;

        private C0595a() {
        }
    }
}
