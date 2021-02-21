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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int giA;
    private List<com.baidu.tbadk.coreExtra.relationship.a> giM;
    private int giP = R.color.CAM_X0105;
    private int giQ = R.color.CAM_X0108;
    private int giR = R.color.CAM_X0109;
    private Drawable giS;
    private Drawable giT;
    private boolean giU;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.giU = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.giU = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.giM = list;
        notifyDataSetChanged();
    }

    public void te(int i) {
        this.giA = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.giU ? 3 : 2;
        return this.giM == null ? i : i + this.giM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: td */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.giU ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.giM.get(i - i2);
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
        if (i == 2 && this.giU) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.byZ()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0593a c0593a;
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
                cVar4.bTo = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.icon, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.giP, 1);
            ap.setBackgroundResource(cVar3.bTo, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.giA);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.icon = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.bTo = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.icon, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.giP, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.bTo, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
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
            ap.setImageResource(cVar.icon, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.giP, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.giY = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.bTo = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.byZ() != null) {
                    bVar.giY.setText(item.byZ());
                }
                ap.setViewTextColor(bVar.giY, this.giQ, 1);
                ap.setBackgroundResource(bVar.bTo, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0593a)) {
                    C0593a c0593a2 = new C0593a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0593a2.giN = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0593a2.giO = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0593a2.giV = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0593a2.giW = (TextView) view.findViewById(R.id.detail_info_time);
                    c0593a2.bTo = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0593a2);
                    c0593a = c0593a2;
                } else {
                    c0593a = (C0593a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0593a.giO.setText(item.getUserName());
                    c0593a.giN.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bzb() == 1) {
                        c0593a.giV.setVisibility(0);
                        ap.setViewTextColor(c0593a.giV, this.giR, 1);
                        c0593a.giV.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0593a.giV.setCompoundDrawables(null, null, null, null);
                        c0593a.giW.setVisibility(8);
                    } else if (item.getLbsInfo().bzb() == 0) {
                        if (!EU(item.getLbsInfo().getDistance()) || !eR(item.getLbsInfo().getTime())) {
                            c0593a.giV.setVisibility(8);
                            c0593a.giW.setVisibility(8);
                        } else {
                            c0593a.giV.setVisibility(0);
                            c0593a.giW.setVisibility(0);
                            c0593a.giV.setText(item.getLbsInfo().getDistance());
                            c0593a.giW.setText(au.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0593a.giV, this.giR, 1);
                            this.giS = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.giS.setBounds(0, 0, this.size, this.size);
                            c0593a.giV.setCompoundDrawables(this.giS, null, null, null);
                            this.giT = ap.getDrawable(R.drawable.icon_friend_time);
                            this.giT.setBounds(0, 0, this.size, this.size);
                            c0593a.giW.setCompoundDrawables(this.giT, null, null, null);
                            ap.setViewTextColor(c0593a.giW, this.giR, 1);
                        }
                    } else {
                        c0593a.giV.setVisibility(8);
                        c0593a.giW.setVisibility(8);
                    }
                } else {
                    c0593a.giV.setVisibility(8);
                    c0593a.giW.setVisibility(8);
                }
                ap.setViewTextColor(c0593a.giO, this.giP, 1);
                String byZ = item.byZ();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(byZ) || item2 == null || byZ.equals(item2.byZ())) ? false : true) {
                    c0593a.bTo.setVisibility(4);
                } else {
                    c0593a.bTo.setVisibility(0);
                    ap.setBackgroundResource(c0593a.bTo, R.color.CAM_X0204);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0593a.giO, this.giP, 1);
                ap.setBackgroundResource(c0593a.bTo, R.color.CAM_X0204);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean EU(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean eR(long j) {
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

    /* loaded from: classes8.dex */
    private class c {
        View bTo;
        ImageView icon;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View bTo;
        TextView giY;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0593a {
        View bTo;
        HeadImageView giN;
        TextView giO;
        TextView giV;
        TextView giW;

        private C0593a() {
        }
    }
}
