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
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> dWE;
    private int dWH = R.color.cp_cont_b;
    private int dWI = R.color.cp_cont_c;
    private int dWJ = R.color.cp_cont_d;
    private Drawable dWK;
    private Drawable dWL;
    private boolean dWM;
    private int dWs;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.dWM = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.dWM = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dWE = list;
        notifyDataSetChanged();
    }

    public void nU(int i) {
        this.dWs = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.dWM ? 3 : 2;
        return this.dWE == null ? i : i + this.dWE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nT */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.dWM ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.dWE.get(i - i2);
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
        if (i == 2 && this.dWM) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.aJS()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.aJR())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0396a c0396a;
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
                cVar4.aPo = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.cRQ = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.setImageResource(cVar3.aPo, R.drawable.icon_new_friend);
            am.setViewTextColor(cVar3.title, this.dWH, 1);
            am.setBackgroundResource(cVar3.cRQ, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            a((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.dWs);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.aPo = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.cRQ = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.setImageResource(cVar2.aPo, R.drawable.icon_add_friend);
            am.setViewTextColor(cVar2.title, this.dWH, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            am.setBackgroundResource(cVar2.cRQ, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.aPo = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.setImageResource(cVar.aPo, R.drawable.icon_me_group);
            am.setViewTextColor(cVar.title, this.dWH, 1);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.dWQ = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.cRQ = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.aJS() != null) {
                    bVar.dWQ.setText(item.aJS());
                }
                am.setViewTextColor(bVar.dWQ, this.dWI, 1);
                am.setBackgroundResource(bVar.cRQ, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0396a)) {
                    C0396a c0396a2 = new C0396a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0396a2.dWF = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0396a2.dWG = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0396a2.dWN = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0396a2.dWO = (TextView) view.findViewById(R.id.detail_info_time);
                    c0396a2.cRQ = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0396a2);
                    c0396a = c0396a2;
                } else {
                    c0396a = (C0396a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0396a.dWG.setText(item.getUserName());
                    c0396a.dWF.startLoad(item.aJR(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().aJU() == 1) {
                        c0396a.dWN.setVisibility(0);
                        am.setViewTextColor(c0396a.dWN, this.dWJ, 1);
                        c0396a.dWN.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0396a.dWN.setCompoundDrawables(null, null, null, null);
                        c0396a.dWO.setVisibility(8);
                    } else if (item.getLbsInfo().aJU() == 0) {
                        if (!wP(item.getLbsInfo().getDistance()) || !cm(item.getLbsInfo().getTime())) {
                            c0396a.dWN.setVisibility(8);
                            c0396a.dWO.setVisibility(8);
                        } else {
                            c0396a.dWN.setVisibility(0);
                            c0396a.dWO.setVisibility(0);
                            c0396a.dWN.setText(item.getLbsInfo().getDistance());
                            c0396a.dWO.setText(aq.getTimeInterval(item.getLbsInfo().getTime()));
                            am.setViewTextColor(c0396a.dWN, this.dWJ, 1);
                            this.dWK = am.getDrawable(R.drawable.icon_friend_pin);
                            this.dWK.setBounds(0, 0, this.size, this.size);
                            c0396a.dWN.setCompoundDrawables(this.dWK, null, null, null);
                            this.dWL = am.getDrawable(R.drawable.icon_friend_time);
                            this.dWL.setBounds(0, 0, this.size, this.size);
                            c0396a.dWO.setCompoundDrawables(this.dWL, null, null, null);
                            am.setViewTextColor(c0396a.dWO, this.dWJ, 1);
                        }
                    } else {
                        c0396a.dWN.setVisibility(8);
                        c0396a.dWO.setVisibility(8);
                    }
                } else {
                    c0396a.dWN.setVisibility(8);
                    c0396a.dWO.setVisibility(8);
                }
                am.setViewTextColor(c0396a.dWG, this.dWH, 1);
                String aJS = item.aJS();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(aJS) || item2 == null || aJS.equals(item2.aJS())) ? false : true) {
                    c0396a.cRQ.setVisibility(4);
                } else {
                    c0396a.cRQ.setVisibility(0);
                    am.setBackgroundResource(c0396a.cRQ, R.color.cp_bg_line_c);
                }
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                am.setViewTextColor(c0396a.dWG, this.dWH, 1);
                am.setBackgroundResource(c0396a.cRQ, R.color.cp_bg_line_c);
                am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean wP(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean cm(long j) {
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

    /* loaded from: classes6.dex */
    private class c {
        ImageView aPo;
        View cRQ;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes6.dex */
    private class b {
        View cRQ;
        TextView dWQ;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0396a {
        View cRQ;
        HeadImageView dWF;
        TextView dWG;
        TextView dWN;
        TextView dWO;

        private C0396a() {
        }
    }
}
