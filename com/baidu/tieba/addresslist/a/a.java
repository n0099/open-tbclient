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
/* loaded from: classes21.dex */
public class a extends BaseAdapter {
    private int gbC = R.color.CAM_X0105;
    private int gbD = R.color.CAM_X0108;
    private int gbE = R.color.CAM_X0109;
    private Drawable gbF;
    private Drawable gbG;
    private boolean gbH;
    private int gbn;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gbz;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.gbH = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.gbH = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gbz = list;
        notifyDataSetChanged();
    }

    public void uu(int i) {
        this.gbn = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.gbH ? 3 : 2;
        return this.gbz == null ? i : i + this.gbz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ut */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.gbH ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.gbz.get(i - i2);
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
        if (i == 2 && this.gbH) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bAg()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0621a c0621a;
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
                cVar4.ckh = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.eOv = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.ckh, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.gbC, 1);
            ap.setBackgroundResource(cVar3.eOv, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.gbn);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.ckh = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.eOv = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.ckh, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.gbC, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.eOv, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.ckh = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.ckh, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.gbC, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.gbL = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.eOv = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bAg() != null) {
                    bVar.gbL.setText(item.bAg());
                }
                ap.setViewTextColor(bVar.gbL, this.gbD, 1);
                ap.setBackgroundResource(bVar.eOv, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0621a)) {
                    C0621a c0621a2 = new C0621a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0621a2.gbA = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0621a2.gbB = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0621a2.gbI = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0621a2.gbJ = (TextView) view.findViewById(R.id.detail_info_time);
                    c0621a2.eOv = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0621a2);
                    c0621a = c0621a2;
                } else {
                    c0621a = (C0621a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0621a.gbB.setText(item.getUserName());
                    c0621a.gbA.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bAi() == 1) {
                        c0621a.gbI.setVisibility(0);
                        ap.setViewTextColor(c0621a.gbI, this.gbE, 1);
                        c0621a.gbI.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0621a.gbI.setCompoundDrawables(null, null, null, null);
                        c0621a.gbJ.setVisibility(8);
                    } else if (item.getLbsInfo().bAi() == 0) {
                        if (!FJ(item.getLbsInfo().getDistance()) || !eL(item.getLbsInfo().getTime())) {
                            c0621a.gbI.setVisibility(8);
                            c0621a.gbJ.setVisibility(8);
                        } else {
                            c0621a.gbI.setVisibility(0);
                            c0621a.gbJ.setVisibility(0);
                            c0621a.gbI.setText(item.getLbsInfo().getDistance());
                            c0621a.gbJ.setText(au.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0621a.gbI, this.gbE, 1);
                            this.gbF = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.gbF.setBounds(0, 0, this.size, this.size);
                            c0621a.gbI.setCompoundDrawables(this.gbF, null, null, null);
                            this.gbG = ap.getDrawable(R.drawable.icon_friend_time);
                            this.gbG.setBounds(0, 0, this.size, this.size);
                            c0621a.gbJ.setCompoundDrawables(this.gbG, null, null, null);
                            ap.setViewTextColor(c0621a.gbJ, this.gbE, 1);
                        }
                    } else {
                        c0621a.gbI.setVisibility(8);
                        c0621a.gbJ.setVisibility(8);
                    }
                } else {
                    c0621a.gbI.setVisibility(8);
                    c0621a.gbJ.setVisibility(8);
                }
                ap.setViewTextColor(c0621a.gbB, this.gbC, 1);
                String bAg = item.bAg();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bAg) || item2 == null || bAg.equals(item2.bAg())) ? false : true) {
                    c0621a.eOv.setVisibility(4);
                } else {
                    c0621a.eOv.setVisibility(0);
                    ap.setBackgroundResource(c0621a.eOv, R.color.CAM_X0204);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0621a.gbB, this.gbC, 1);
                ap.setBackgroundResource(c0621a.eOv, R.color.CAM_X0204);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean FJ(String str) {
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
        ImageView ckh;
        View eOv;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes21.dex */
    private class b {
        View eOv;
        TextView gbL;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private class C0621a {
        View eOv;
        HeadImageView gbA;
        TextView gbB;
        TextView gbI;
        TextView gbJ;

        private C0621a() {
        }
    }
}
