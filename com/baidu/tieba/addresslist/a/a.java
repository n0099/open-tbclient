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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private Drawable dWB;
    private Drawable dWC;
    private boolean dWD;
    private int dWj;
    private List<com.baidu.tbadk.coreExtra.relationship.a> dWv;
    private Context mContext;
    private int size;
    private int dWy = R.color.cp_cont_b;
    private int dWz = R.color.cp_cont_c;
    private int dWA = R.color.cp_cont_d;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.dWD = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.dWD = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dWv = list;
        notifyDataSetChanged();
    }

    public void nU(int i) {
        this.dWj = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.dWD ? 3 : 2;
        return this.dWv == null ? i : i + this.dWv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nT */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.dWD ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.dWv.get(i - i2);
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
        if (i == 2 && this.dWD) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aJy()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aJx())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0394a c0394a;
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
                cVar4.aOw = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.cRG = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.aOw, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.dWy, 1);
            am.setBackgroundResource(cVar3.cRG, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.dWj);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.aOw = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.cRG = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.aOw, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.dWy, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.cRG, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.aOw = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.aOw, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.dWy, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.dWH = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.cRG = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aJy() != null) {
                    bVar.dWH.setText(item.aJy());
                }
                am.setViewTextColor(bVar.dWH, this.dWz, 1);
                am.setBackgroundResource(bVar.cRG, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0394a)) {
                    C0394a c0394a2 = new C0394a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0394a2.dWw = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0394a2.dWx = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0394a2.dWE = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0394a2.dWF = (TextView) view.findViewById(R.id.detail_info_time);
                    c0394a2.cRG = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0394a2);
                    c0394a = c0394a2;
                } else {
                    c0394a = (C0394a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0394a.dWx.setText(item.getUserName());
                    c0394a.dWw.startLoad(item.aJx(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aJA() == 1) {
                        c0394a.dWE.setVisibility(0);
                        am.setViewTextColor(c0394a.dWE, this.dWA, 1);
                        c0394a.dWE.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0394a.dWE.setCompoundDrawables(null, null, null, null);
                        c0394a.dWF.setVisibility(8);
                    } else if (item.getLbsInfo().aJA() == 0) {
                        if (!wL(item.getLbsInfo().getDistance()) || !ch(item.getLbsInfo().getTime())) {
                            c0394a.dWE.setVisibility(8);
                            c0394a.dWF.setVisibility(8);
                        } else {
                            c0394a.dWE.setVisibility(0);
                            c0394a.dWF.setVisibility(0);
                            c0394a.dWE.setText(item.getLbsInfo().getDistance());
                            c0394a.dWF.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0394a.dWE, this.dWA, 1);
                            this.dWB = am.getDrawable(R.drawable.icon_friend_pin);
                            this.dWB.setBounds(0, 0, this.size, this.size);
                            c0394a.dWE.setCompoundDrawables(this.dWB, null, null, null);
                            this.dWC = am.getDrawable(R.drawable.icon_friend_time);
                            this.dWC.setBounds(0, 0, this.size, this.size);
                            c0394a.dWF.setCompoundDrawables(this.dWC, null, null, null);
                            am.setViewTextColor(c0394a.dWF, this.dWA, 1);
                        }
                    } else {
                        c0394a.dWE.setVisibility(8);
                        c0394a.dWF.setVisibility(8);
                    }
                } else {
                    c0394a.dWE.setVisibility(8);
                    c0394a.dWF.setVisibility(8);
                }
                am.setViewTextColor(c0394a.dWx, this.dWy, 1);
                String aJy = item.aJy();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aJy) || item2 == null || aJy.equals(item2.aJy())) ? false : true) {
                    c0394a.cRG.setVisibility(4);
                } else {
                    c0394a.cRG.setVisibility(0);
                    am.setBackgroundResource(c0394a.cRG, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0394a.dWx, this.dWy, 1);
                am.setBackgroundResource(c0394a.cRG, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean wL(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean ch(long j) {
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

    /* loaded from: classes5.dex */
    private class c {
        ImageView aOw;
        View cRG;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes5.dex */
    private class b {
        View cRG;
        TextView dWH;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0394a {
        View cRG;
        TextView dWE;
        TextView dWF;
        HeadImageView dWw;
        TextView dWx;

        private C0394a() {
        }
    }
}
