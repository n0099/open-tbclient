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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private Drawable fFB;
    private Drawable fFC;
    private boolean fFD;
    private int fFj;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fFv;
    private Context mContext;
    private int size;
    private int fFy = R.color.cp_cont_b;
    private int fFz = R.color.cp_cont_c;
    private int fFA = R.color.cp_cont_d;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.fFD = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.fFD = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fFv = list;
        notifyDataSetChanged();
    }

    public void sX(int i) {
        this.fFj = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.fFD ? 3 : 2;
        return this.fFv == null ? i : i + this.fFv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sW */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.fFD ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.fFv.get(i - i2);
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
        if (i == 2 && this.fFD) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bsY()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.bsX())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0583a c0583a;
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
                cVar4.bRe = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.euA = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.bRe, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.fFy, 1);
            ap.setBackgroundResource(cVar3.euA, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fFj);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bRe = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.euA = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.bRe, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.fFy, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.euA, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bRe = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.bRe, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.fFy, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fFH = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.euA = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bsY() != null) {
                    bVar.fFH.setText(item.bsY());
                }
                ap.setViewTextColor(bVar.fFH, this.fFz, 1);
                ap.setBackgroundResource(bVar.euA, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0583a)) {
                    C0583a c0583a2 = new C0583a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0583a2.fFw = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0583a2.fFx = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0583a2.fFE = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0583a2.fFF = (TextView) view.findViewById(R.id.detail_info_time);
                    c0583a2.euA = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0583a2);
                    c0583a = c0583a2;
                } else {
                    c0583a = (C0583a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0583a.fFx.setText(item.getUserName());
                    c0583a.fFw.startLoad(item.bsX(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bta() == 1) {
                        c0583a.fFE.setVisibility(0);
                        ap.setViewTextColor(c0583a.fFE, this.fFA, 1);
                        c0583a.fFE.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0583a.fFE.setCompoundDrawables(null, null, null, null);
                        c0583a.fFF.setVisibility(8);
                    } else if (item.getLbsInfo().bta() == 0) {
                        if (!EN(item.getLbsInfo().getDistance()) || !dK(item.getLbsInfo().getTime())) {
                            c0583a.fFE.setVisibility(8);
                            c0583a.fFF.setVisibility(8);
                        } else {
                            c0583a.fFE.setVisibility(0);
                            c0583a.fFF.setVisibility(0);
                            c0583a.fFE.setText(item.getLbsInfo().getDistance());
                            c0583a.fFF.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0583a.fFE, this.fFA, 1);
                            this.fFB = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.fFB.setBounds(0, 0, this.size, this.size);
                            c0583a.fFE.setCompoundDrawables(this.fFB, null, null, null);
                            this.fFC = ap.getDrawable(R.drawable.icon_friend_time);
                            this.fFC.setBounds(0, 0, this.size, this.size);
                            c0583a.fFF.setCompoundDrawables(this.fFC, null, null, null);
                            ap.setViewTextColor(c0583a.fFF, this.fFA, 1);
                        }
                    } else {
                        c0583a.fFE.setVisibility(8);
                        c0583a.fFF.setVisibility(8);
                    }
                } else {
                    c0583a.fFE.setVisibility(8);
                    c0583a.fFF.setVisibility(8);
                }
                ap.setViewTextColor(c0583a.fFx, this.fFy, 1);
                String bsY = item.bsY();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bsY) || item2 == null || bsY.equals(item2.bsY())) ? false : true) {
                    c0583a.euA.setVisibility(4);
                } else {
                    c0583a.euA.setVisibility(0);
                    ap.setBackgroundResource(c0583a.euA, R.color.cp_bg_line_c);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0583a.fFx, this.fFy, 1);
                ap.setBackgroundResource(c0583a.euA, R.color.cp_bg_line_c);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean EN(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean dK(long j) {
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

    /* loaded from: classes21.dex */
    private class c {
        ImageView bRe;
        View euA;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes21.dex */
    private class b {
        View euA;
        TextView fFH;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0583a {
        View euA;
        TextView fFE;
        TextView fFF;
        HeadImageView fFw;
        TextView fFx;

        private C0583a() {
        }
    }
}
