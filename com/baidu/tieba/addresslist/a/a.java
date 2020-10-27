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
    private int fNE;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fNQ;
    private int fNT = R.color.cp_cont_b;
    private int fNU = R.color.cp_cont_c;
    private int fNV = R.color.cp_cont_d;
    private Drawable fNW;
    private Drawable fNX;
    private boolean fNY;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.fNY = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.fNY = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fNQ = list;
        notifyDataSetChanged();
    }

    public void ti(int i) {
        this.fNE = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.fNY ? 3 : 2;
        return this.fNQ == null ? i : i + this.fNQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: th */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.fNY ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.fNQ.get(i - i2);
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
        if (i == 2 && this.fNY) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.buR()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.buQ())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0597a c0597a;
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
                cVar4.bZB = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.eCZ = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.bZB, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.fNT, 1);
            ap.setBackgroundResource(cVar3.eCZ, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fNE);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.bZB = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.eCZ = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.bZB, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.fNT, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.eCZ, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.bZB = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.bZB, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.fNT, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fOc = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.eCZ = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.buR() != null) {
                    bVar.fOc.setText(item.buR());
                }
                ap.setViewTextColor(bVar.fOc, this.fNU, 1);
                ap.setBackgroundResource(bVar.eCZ, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0597a)) {
                    C0597a c0597a2 = new C0597a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0597a2.fNR = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0597a2.fNS = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0597a2.fNZ = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0597a2.fOa = (TextView) view.findViewById(R.id.detail_info_time);
                    c0597a2.eCZ = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0597a2);
                    c0597a = c0597a2;
                } else {
                    c0597a = (C0597a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0597a.fNS.setText(item.getUserName());
                    c0597a.fNR.startLoad(item.buQ(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().buT() == 1) {
                        c0597a.fNZ.setVisibility(0);
                        ap.setViewTextColor(c0597a.fNZ, this.fNV, 1);
                        c0597a.fNZ.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0597a.fNZ.setCompoundDrawables(null, null, null, null);
                        c0597a.fOa.setVisibility(8);
                    } else if (item.getLbsInfo().buT() == 0) {
                        if (!Fg(item.getLbsInfo().getDistance()) || !dM(item.getLbsInfo().getTime())) {
                            c0597a.fNZ.setVisibility(8);
                            c0597a.fOa.setVisibility(8);
                        } else {
                            c0597a.fNZ.setVisibility(0);
                            c0597a.fOa.setVisibility(0);
                            c0597a.fNZ.setText(item.getLbsInfo().getDistance());
                            c0597a.fOa.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0597a.fNZ, this.fNV, 1);
                            this.fNW = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.fNW.setBounds(0, 0, this.size, this.size);
                            c0597a.fNZ.setCompoundDrawables(this.fNW, null, null, null);
                            this.fNX = ap.getDrawable(R.drawable.icon_friend_time);
                            this.fNX.setBounds(0, 0, this.size, this.size);
                            c0597a.fOa.setCompoundDrawables(this.fNX, null, null, null);
                            ap.setViewTextColor(c0597a.fOa, this.fNV, 1);
                        }
                    } else {
                        c0597a.fNZ.setVisibility(8);
                        c0597a.fOa.setVisibility(8);
                    }
                } else {
                    c0597a.fNZ.setVisibility(8);
                    c0597a.fOa.setVisibility(8);
                }
                ap.setViewTextColor(c0597a.fNS, this.fNT, 1);
                String buR = item.buR();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(buR) || item2 == null || buR.equals(item2.buR())) ? false : true) {
                    c0597a.eCZ.setVisibility(4);
                } else {
                    c0597a.eCZ.setVisibility(0);
                    ap.setBackgroundResource(c0597a.eCZ, R.color.cp_bg_line_c);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0597a.fNS, this.fNT, 1);
                ap.setBackgroundResource(c0597a.eCZ, R.color.cp_bg_line_c);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Fg(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean dM(long j) {
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
        ImageView bZB;
        View eCZ;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes21.dex */
    private class b {
        View eCZ;
        TextView fOc;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0597a {
        View eCZ;
        HeadImageView fNR;
        TextView fNS;
        TextView fNZ;
        TextView fOa;

        private C0597a() {
        }
    }
}
