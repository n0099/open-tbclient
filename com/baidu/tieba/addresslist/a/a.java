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
    private int eaK;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eaW;
    private int eaZ = R.color.cp_cont_b;
    private int eba = R.color.cp_cont_c;
    private int ebb = R.color.cp_cont_d;
    private Drawable ebc;
    private Drawable ebd;
    private boolean ebe;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.ebe = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.ebe = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eaW = list;
        notifyDataSetChanged();
    }

    public void ol(int i) {
        this.eaK = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.ebe ? 3 : 2;
        return this.eaW == null ? i : i + this.eaW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ok */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.ebe ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.eaW.get(i - i2);
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
        if (i == 2 && this.ebe) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aMp()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aMo())) ? 2 : 3;
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
                cVar4.aTP = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.cVU = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.aTP, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.eaZ, 1);
            am.setBackgroundResource(cVar3.cVU, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.eaK);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.aTP = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.cVU = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.aTP, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.eaZ, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.cVU, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.aTP = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.aTP, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.eaZ, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.ebi = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.cVU = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aMp() != null) {
                    bVar.ebi.setText(item.aMp());
                }
                am.setViewTextColor(bVar.ebi, this.eba, 1);
                am.setBackgroundResource(bVar.cVU, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0407a)) {
                    C0407a c0407a2 = new C0407a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0407a2.eaX = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0407a2.eaY = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0407a2.ebf = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0407a2.ebg = (TextView) view.findViewById(R.id.detail_info_time);
                    c0407a2.cVU = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0407a2);
                    c0407a = c0407a2;
                } else {
                    c0407a = (C0407a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0407a.eaY.setText(item.getUserName());
                    c0407a.eaX.startLoad(item.aMo(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aMr() == 1) {
                        c0407a.ebf.setVisibility(0);
                        am.setViewTextColor(c0407a.ebf, this.ebb, 1);
                        c0407a.ebf.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0407a.ebf.setCompoundDrawables(null, null, null, null);
                        c0407a.ebg.setVisibility(8);
                    } else if (item.getLbsInfo().aMr() == 0) {
                        if (!xk(item.getLbsInfo().getDistance()) || !cq(item.getLbsInfo().getTime())) {
                            c0407a.ebf.setVisibility(8);
                            c0407a.ebg.setVisibility(8);
                        } else {
                            c0407a.ebf.setVisibility(0);
                            c0407a.ebg.setVisibility(0);
                            c0407a.ebf.setText(item.getLbsInfo().getDistance());
                            c0407a.ebg.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0407a.ebf, this.ebb, 1);
                            this.ebc = am.getDrawable(R.drawable.icon_friend_pin);
                            this.ebc.setBounds(0, 0, this.size, this.size);
                            c0407a.ebf.setCompoundDrawables(this.ebc, null, null, null);
                            this.ebd = am.getDrawable(R.drawable.icon_friend_time);
                            this.ebd.setBounds(0, 0, this.size, this.size);
                            c0407a.ebg.setCompoundDrawables(this.ebd, null, null, null);
                            am.setViewTextColor(c0407a.ebg, this.ebb, 1);
                        }
                    } else {
                        c0407a.ebf.setVisibility(8);
                        c0407a.ebg.setVisibility(8);
                    }
                } else {
                    c0407a.ebf.setVisibility(8);
                    c0407a.ebg.setVisibility(8);
                }
                am.setViewTextColor(c0407a.eaY, this.eaZ, 1);
                String aMp = item.aMp();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aMp) || item2 == null || aMp.equals(item2.aMp())) ? false : true) {
                    c0407a.cVU.setVisibility(4);
                } else {
                    c0407a.cVU.setVisibility(0);
                    am.setBackgroundResource(c0407a.cVU, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0407a.eaY, this.eaZ, 1);
                am.setBackgroundResource(c0407a.cVU, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean xk(String str) {
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
        ImageView aTP;
        View cVU;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View cVU;
        TextView ebi;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0407a {
        View cVU;
        HeadImageView eaX;
        TextView eaY;
        TextView ebf;
        TextView ebg;

        private C0407a() {
        }
    }
}
