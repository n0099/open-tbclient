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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private int gkd;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gkp;
    private int gks = R.color.CAM_X0105;
    private int gkt = R.color.CAM_X0108;
    private int gku = R.color.CAM_X0109;
    private Drawable gkv;
    private Drawable gkw;
    private boolean gkx;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.gkx = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.gkx = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gkp = list;
        notifyDataSetChanged();
    }

    public void tg(int i) {
        this.gkd = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.gkx ? 3 : 2;
        return this.gkp == null ? i : i + this.gkp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tf */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.gkx ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.gkp.get(i - i2);
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
        if (i == 2 && this.gkx) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bzc()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0599a c0599a;
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
                cVar4.bUO = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.icon, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.gks, 1);
            ap.setBackgroundResource(cVar3.bUO, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.gkd);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.icon = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.bUO = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.icon, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.gks, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.bUO, R.color.CAM_X0204);
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
            ap.setViewTextColor(cVar.title, this.gks, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.gkB = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.bUO = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bzc() != null) {
                    bVar.gkB.setText(item.bzc());
                }
                ap.setViewTextColor(bVar.gkB, this.gkt, 1);
                ap.setBackgroundResource(bVar.bUO, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0599a)) {
                    C0599a c0599a2 = new C0599a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0599a2.gkq = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0599a2.gkr = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0599a2.gky = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0599a2.gkz = (TextView) view.findViewById(R.id.detail_info_time);
                    c0599a2.bUO = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0599a2);
                    c0599a = c0599a2;
                } else {
                    c0599a = (C0599a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0599a.gkr.setText(item.getUserName());
                    c0599a.gkq.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bze() == 1) {
                        c0599a.gky.setVisibility(0);
                        ap.setViewTextColor(c0599a.gky, this.gku, 1);
                        c0599a.gky.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0599a.gky.setCompoundDrawables(null, null, null, null);
                        c0599a.gkz.setVisibility(8);
                    } else if (item.getLbsInfo().bze() == 0) {
                        if (!Fb(item.getLbsInfo().getDistance()) || !eR(item.getLbsInfo().getTime())) {
                            c0599a.gky.setVisibility(8);
                            c0599a.gkz.setVisibility(8);
                        } else {
                            c0599a.gky.setVisibility(0);
                            c0599a.gkz.setVisibility(0);
                            c0599a.gky.setText(item.getLbsInfo().getDistance());
                            c0599a.gkz.setText(au.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0599a.gky, this.gku, 1);
                            this.gkv = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.gkv.setBounds(0, 0, this.size, this.size);
                            c0599a.gky.setCompoundDrawables(this.gkv, null, null, null);
                            this.gkw = ap.getDrawable(R.drawable.icon_friend_time);
                            this.gkw.setBounds(0, 0, this.size, this.size);
                            c0599a.gkz.setCompoundDrawables(this.gkw, null, null, null);
                            ap.setViewTextColor(c0599a.gkz, this.gku, 1);
                        }
                    } else {
                        c0599a.gky.setVisibility(8);
                        c0599a.gkz.setVisibility(8);
                    }
                } else {
                    c0599a.gky.setVisibility(8);
                    c0599a.gkz.setVisibility(8);
                }
                ap.setViewTextColor(c0599a.gkr, this.gks, 1);
                String bzc = item.bzc();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bzc) || item2 == null || bzc.equals(item2.bzc())) ? false : true) {
                    c0599a.bUO.setVisibility(4);
                } else {
                    c0599a.bUO.setVisibility(0);
                    ap.setBackgroundResource(c0599a.bUO, R.color.CAM_X0204);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0599a.gkr, this.gks, 1);
                ap.setBackgroundResource(c0599a.bUO, R.color.CAM_X0204);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean Fb(String str) {
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

    /* loaded from: classes7.dex */
    private class c {
        View bUO;
        ImageView icon;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes7.dex */
    private class b {
        View bUO;
        TextView gkB;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0599a {
        View bUO;
        HeadImageView gkq;
        TextView gkr;
        TextView gky;
        TextView gkz;

        private C0599a() {
        }
    }
}
