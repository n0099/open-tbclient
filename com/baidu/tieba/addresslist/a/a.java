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
    private List<com.baidu.tbadk.coreExtra.relationship.a> djC;
    private int djF = R.color.cp_cont_b;
    private int djG = R.color.cp_cont_c;
    private int djH = R.color.cp_cont_d;
    private Drawable djI;
    private Drawable djJ;
    private boolean djK;
    private int djr;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.djK = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.djK = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.djC = list;
        notifyDataSetChanged();
    }

    public void lH(int i) {
        this.djr = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.djK ? 3 : 2;
        return this.djC == null ? i : i + this.djC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lG */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.djK ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.djC.get(i - i2);
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
        if (i == 2 && this.djK) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.asb()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.asa())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0313a c0313a;
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
                cVar4.djP = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.cfY = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.djP, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.djF, 1);
            am.setBackgroundResource(cVar3.cfY, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.djr);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.djP = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.cfY = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.djP, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.djF, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.cfY, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.djP = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.djP, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.djF, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.djO = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.cfY = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.asb() != null) {
                    bVar.djO.setText(item.asb());
                }
                am.setViewTextColor(bVar.djO, this.djG, 1);
                am.setBackgroundResource(bVar.cfY, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0313a)) {
                    C0313a c0313a2 = new C0313a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0313a2.djD = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0313a2.djE = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0313a2.djL = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0313a2.djM = (TextView) view.findViewById(R.id.detail_info_time);
                    c0313a2.cfY = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0313a2);
                    c0313a = c0313a2;
                } else {
                    c0313a = (C0313a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0313a.djE.setText(item.getUserName());
                    c0313a.djD.startLoad(item.asa(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().asd() == 1) {
                        c0313a.djL.setVisibility(0);
                        am.setViewTextColor(c0313a.djL, this.djH, 1);
                        c0313a.djL.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0313a.djL.setCompoundDrawables(null, null, null, null);
                        c0313a.djM.setVisibility(8);
                    } else if (item.getLbsInfo().asd() == 0) {
                        if (!rF(item.getLbsInfo().getDistance()) || !bG(item.getLbsInfo().getTime())) {
                            c0313a.djL.setVisibility(8);
                            c0313a.djM.setVisibility(8);
                        } else {
                            c0313a.djL.setVisibility(0);
                            c0313a.djM.setVisibility(0);
                            c0313a.djL.setText(item.getLbsInfo().getDistance());
                            c0313a.djM.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0313a.djL, this.djH, 1);
                            this.djI = am.getDrawable(R.drawable.icon_friend_pin);
                            this.djI.setBounds(0, 0, this.size, this.size);
                            c0313a.djL.setCompoundDrawables(this.djI, null, null, null);
                            this.djJ = am.getDrawable(R.drawable.icon_friend_time);
                            this.djJ.setBounds(0, 0, this.size, this.size);
                            c0313a.djM.setCompoundDrawables(this.djJ, null, null, null);
                            am.setViewTextColor(c0313a.djM, this.djH, 1);
                        }
                    } else {
                        c0313a.djL.setVisibility(8);
                        c0313a.djM.setVisibility(8);
                    }
                } else {
                    c0313a.djL.setVisibility(8);
                    c0313a.djM.setVisibility(8);
                }
                am.setViewTextColor(c0313a.djE, this.djF, 1);
                String asb = item.asb();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(asb) || item2 == null || asb.equals(item2.asb())) ? false : true) {
                    c0313a.cfY.setVisibility(4);
                } else {
                    c0313a.cfY.setVisibility(0);
                    am.setBackgroundResource(c0313a.cfY, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0313a.djE, this.djF, 1);
                am.setBackgroundResource(c0313a.cfY, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean rF(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean bG(long j) {
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

    /* loaded from: classes3.dex */
    private class c {
        View cfY;
        ImageView djP;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        View cfY;
        TextView djO;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0313a {
        View cfY;
        HeadImageView djD;
        TextView djE;
        TextView djL;
        TextView djM;

        private C0313a() {
        }
    }
}
