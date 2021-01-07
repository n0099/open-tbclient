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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private int gkE;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gkQ;
    private int gkT = R.color.CAM_X0105;
    private int gkU = R.color.CAM_X0108;
    private int gkV = R.color.CAM_X0109;
    private Drawable gkW;
    private Drawable gkX;
    private boolean gkY;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.gkY = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.gkY = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gkQ = list;
        notifyDataSetChanged();
    }

    public void uF(int i) {
        this.gkE = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.gkY ? 3 : 2;
        return this.gkQ == null ? i : i + this.gkQ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uE */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.gkY ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.gkQ.get(i - i2);
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
        if (i == 2 && this.gkY) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bCB()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0612a c0612a;
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
                cVar4.bUk = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ao.setImageResource(cVar3.icon, R.drawable.icon_new_friend);
            ao.setViewTextColor(cVar3.title, this.gkT, 1);
            ao.setBackgroundResource(cVar3.bUk, R.color.CAM_X0204);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.gkE);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.icon = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.bUk = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ao.setImageResource(cVar2.icon, R.drawable.icon_add_friend);
            ao.setViewTextColor(cVar2.title, this.gkT, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ao.setBackgroundResource(cVar2.bUk, R.color.CAM_X0204);
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
            ao.setViewTextColor(cVar.title, this.gkT, 1);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.glc = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.bUk = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bCB() != null) {
                    bVar.glc.setText(item.bCB());
                }
                ao.setViewTextColor(bVar.glc, this.gkU, 1);
                ao.setBackgroundResource(bVar.bUk, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0612a)) {
                    C0612a c0612a2 = new C0612a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0612a2.gkR = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0612a2.gkS = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0612a2.gkZ = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0612a2.gla = (TextView) view.findViewById(R.id.detail_info_time);
                    c0612a2.bUk = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0612a2);
                    c0612a = c0612a2;
                } else {
                    c0612a = (C0612a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0612a.gkS.setText(item.getUserName());
                    c0612a.gkR.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bCD() == 1) {
                        c0612a.gkZ.setVisibility(0);
                        ao.setViewTextColor(c0612a.gkZ, this.gkV, 1);
                        c0612a.gkZ.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0612a.gkZ.setCompoundDrawables(null, null, null, null);
                        c0612a.gla.setVisibility(8);
                    } else if (item.getLbsInfo().bCD() == 0) {
                        if (!FG(item.getLbsInfo().getDistance()) || !eL(item.getLbsInfo().getTime())) {
                            c0612a.gkZ.setVisibility(8);
                            c0612a.gla.setVisibility(8);
                        } else {
                            c0612a.gkZ.setVisibility(0);
                            c0612a.gla.setVisibility(0);
                            c0612a.gkZ.setText(item.getLbsInfo().getDistance());
                            c0612a.gla.setText(at.getTimeInterval(item.getLbsInfo().getTime()));
                            ao.setViewTextColor(c0612a.gkZ, this.gkV, 1);
                            this.gkW = ao.getDrawable(R.drawable.icon_friend_pin);
                            this.gkW.setBounds(0, 0, this.size, this.size);
                            c0612a.gkZ.setCompoundDrawables(this.gkW, null, null, null);
                            this.gkX = ao.getDrawable(R.drawable.icon_friend_time);
                            this.gkX.setBounds(0, 0, this.size, this.size);
                            c0612a.gla.setCompoundDrawables(this.gkX, null, null, null);
                            ao.setViewTextColor(c0612a.gla, this.gkV, 1);
                        }
                    } else {
                        c0612a.gkZ.setVisibility(8);
                        c0612a.gla.setVisibility(8);
                    }
                } else {
                    c0612a.gkZ.setVisibility(8);
                    c0612a.gla.setVisibility(8);
                }
                ao.setViewTextColor(c0612a.gkS, this.gkT, 1);
                String bCB = item.bCB();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bCB) || item2 == null || bCB.equals(item2.bCB())) ? false : true) {
                    c0612a.bUk.setVisibility(4);
                } else {
                    c0612a.bUk.setVisibility(0);
                    ao.setBackgroundResource(c0612a.bUk, R.color.CAM_X0204);
                }
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ao.setViewTextColor(c0612a.gkS, this.gkT, 1);
                ao.setBackgroundResource(c0612a.bUk, R.color.CAM_X0204);
                ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean FG(String str) {
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

    /* loaded from: classes8.dex */
    private class c {
        View bUk;
        ImageView icon;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes8.dex */
    private class b {
        View bUk;
        TextView glc;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private class C0612a {
        View bUk;
        HeadImageView gkR;
        TextView gkS;
        TextView gkZ;
        TextView gla;

        private C0612a() {
        }
    }
}
