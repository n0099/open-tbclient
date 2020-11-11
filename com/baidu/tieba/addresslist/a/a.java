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
    private List<com.baidu.tbadk.coreExtra.relationship.a> fTG;
    private int fTJ = R.color.cp_cont_b;
    private int fTK = R.color.cp_cont_c;
    private int fTL = R.color.cp_cont_d;
    private Drawable fTM;
    private Drawable fTN;
    private boolean fTO;
    private int fTu;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.fTO = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.fTO = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fTG = list;
        notifyDataSetChanged();
    }

    public void ts(int i) {
        this.fTu = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.fTO ? 3 : 2;
        return this.fTG == null ? i : i + this.fTG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tr */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.fTO ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.fTG.get(i - i2);
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
        if (i == 2 && this.fTO) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bxq()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0609a c0609a;
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
                cVar4.cfn = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.eIO = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.cfn, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.fTJ, 1);
            ap.setBackgroundResource(cVar3.eIO, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fTu);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.cfn = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.eIO = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.cfn, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.fTJ, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.eIO, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.cfn = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.cfn, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.fTJ, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fTS = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.eIO = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bxq() != null) {
                    bVar.fTS.setText(item.bxq());
                }
                ap.setViewTextColor(bVar.fTS, this.fTK, 1);
                ap.setBackgroundResource(bVar.eIO, R.color.cp_bg_line_c);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0609a)) {
                    C0609a c0609a2 = new C0609a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0609a2.fTH = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0609a2.fTI = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0609a2.fTP = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0609a2.fTQ = (TextView) view.findViewById(R.id.detail_info_time);
                    c0609a2.eIO = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0609a2);
                    c0609a = c0609a2;
                } else {
                    c0609a = (C0609a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0609a.fTI.setText(item.getUserName());
                    c0609a.fTH.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bxs() == 1) {
                        c0609a.fTP.setVisibility(0);
                        ap.setViewTextColor(c0609a.fTP, this.fTL, 1);
                        c0609a.fTP.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0609a.fTP.setCompoundDrawables(null, null, null, null);
                        c0609a.fTQ.setVisibility(8);
                    } else if (item.getLbsInfo().bxs() == 0) {
                        if (!Fu(item.getLbsInfo().getDistance()) || !ei(item.getLbsInfo().getTime())) {
                            c0609a.fTP.setVisibility(8);
                            c0609a.fTQ.setVisibility(8);
                        } else {
                            c0609a.fTP.setVisibility(0);
                            c0609a.fTQ.setVisibility(0);
                            c0609a.fTP.setText(item.getLbsInfo().getDistance());
                            c0609a.fTQ.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0609a.fTP, this.fTL, 1);
                            this.fTM = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.fTM.setBounds(0, 0, this.size, this.size);
                            c0609a.fTP.setCompoundDrawables(this.fTM, null, null, null);
                            this.fTN = ap.getDrawable(R.drawable.icon_friend_time);
                            this.fTN.setBounds(0, 0, this.size, this.size);
                            c0609a.fTQ.setCompoundDrawables(this.fTN, null, null, null);
                            ap.setViewTextColor(c0609a.fTQ, this.fTL, 1);
                        }
                    } else {
                        c0609a.fTP.setVisibility(8);
                        c0609a.fTQ.setVisibility(8);
                    }
                } else {
                    c0609a.fTP.setVisibility(8);
                    c0609a.fTQ.setVisibility(8);
                }
                ap.setViewTextColor(c0609a.fTI, this.fTJ, 1);
                String bxq = item.bxq();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bxq) || item2 == null || bxq.equals(item2.bxq())) ? false : true) {
                    c0609a.eIO.setVisibility(4);
                } else {
                    c0609a.eIO.setVisibility(0);
                    ap.setBackgroundResource(c0609a.eIO, R.color.cp_bg_line_c);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0609a.fTI, this.fTJ, 1);
                ap.setBackgroundResource(c0609a.eIO, R.color.cp_bg_line_c);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Fu(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean ei(long j) {
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
        ImageView cfn;
        View eIO;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes21.dex */
    private class b {
        View eIO;
        TextView fTS;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0609a {
        View eIO;
        HeadImageView fTH;
        TextView fTI;
        TextView fTP;
        TextView fTQ;

        private C0609a() {
        }
    }
}
