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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> boD;
    private int boG = f.d.cp_cont_b;
    private int boH = f.d.cp_cont_c;
    private int boI = f.d.cp_cont_d;
    private Drawable boJ;
    private Drawable boK;
    private boolean boL;
    private int bor;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.boL = true;
        this.mContext = context;
        this.size = l.f(this.mContext, f.e.ds24);
        this.boL = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.boD = list;
        notifyDataSetChanged();
    }

    public void gC(int i) {
        this.bor = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.boL ? 3 : 2;
        return this.boD == null ? i : i + this.boD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gB */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.boL ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.boD.get(i - i2);
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
        if (i == 2 && this.boL) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.Fv()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.Fu())) ? 2 : 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0129a c0129a;
        b bVar;
        c cVar;
        c cVar2;
        c cVar3;
        if (getItemViewType(i) == 4) {
            return null;
        }
        if (getItemViewType(i) == 0) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(f.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar4 = new c();
                cVar4.boQ = (ImageView) view.findViewById(f.g.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(f.g.addresslist_new_friend_text);
                cVar4.divider = view.findViewById(f.g.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            am.c(cVar3.boQ, f.C0146f.icon_new_friend);
            am.c(cVar3.title, this.boG, 1);
            am.i(cVar3.divider, f.d.cp_bg_line_b);
            am.i(view, f.C0146f.addresslist_item_bg);
            i((TextView) view.findViewById(f.g.addresslist_new_friend_message), this.bor);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(f.h.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.boQ = (ImageView) view.findViewById(f.g.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(f.g.addresslist_new_friend_text);
                cVar5.divider = view.findViewById(f.g.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            am.c(cVar2.boQ, f.C0146f.icon_add_friend);
            am.c(cVar2.title, this.boG, 1);
            cVar2.title.setText(this.mContext.getResources().getString(f.j.find_new_friend));
            am.i(cVar2.divider, f.d.cp_bg_line_b);
            am.i(view, f.C0146f.addresslist_item_bg);
            ((TextView) view.findViewById(f.g.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(f.h.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.boQ = (ImageView) view.findViewById(f.g.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(f.g.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            am.c(cVar.boQ, f.C0146f.icon_me_group);
            am.c(cVar.title, this.boG, 1);
            am.i(view, f.C0146f.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(f.h.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.boP = (TextView) view.findViewById(f.g.addresslist_group_item_key);
                    bVar2.divider = view.findViewById(f.g.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.Fv() != null) {
                    bVar.boP.setText(item.Fv());
                }
                am.c(bVar.boP, this.boH, 1);
                am.i(bVar.divider, f.d.cp_bg_line_b);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0129a)) {
                    C0129a c0129a2 = new C0129a();
                    view = LayoutInflater.from(this.mContext).inflate(f.h.addresslist_child_item, (ViewGroup) null);
                    c0129a2.boE = (HeadImageView) view.findViewById(f.g.addresslist_child_item_icon);
                    c0129a2.boF = (TextView) view.findViewById(f.g.addresslist_child_item_name);
                    c0129a2.boM = (TextView) view.findViewById(f.g.detail_info_distance);
                    c0129a2.boN = (TextView) view.findViewById(f.g.detail_info_time);
                    c0129a2.divider = view.findViewById(f.g.addresslist_child_item_divider);
                    view.setTag(c0129a2);
                    c0129a = c0129a2;
                } else {
                    c0129a = (C0129a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0129a.boF.setText(item.getUserName());
                    c0129a.boE.startLoad(item.Fu(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().Fy() == 1) {
                        c0129a.boM.setVisibility(0);
                        am.c(c0129a.boM, this.boI, 1);
                        c0129a.boM.setText(this.mContext.getResources().getString(f.j.contact_yinshen));
                        c0129a.boM.setCompoundDrawables(null, null, null, null);
                        c0129a.boN.setVisibility(8);
                    } else if (item.getLbsInfo().Fy() == 0) {
                        if (!iM(item.getLbsInfo().Fx()) || !aG(item.getLbsInfo().getTime())) {
                            c0129a.boM.setVisibility(8);
                            c0129a.boN.setVisibility(8);
                        } else {
                            c0129a.boM.setVisibility(0);
                            c0129a.boN.setVisibility(0);
                            c0129a.boM.setText(item.getLbsInfo().Fx());
                            c0129a.boN.setText(ap.u(item.getLbsInfo().getTime()));
                            am.c(c0129a.boM, this.boI, 1);
                            this.boJ = am.getDrawable(f.C0146f.icon_friend_pin);
                            this.boJ.setBounds(0, 0, this.size, this.size);
                            c0129a.boM.setCompoundDrawables(this.boJ, null, null, null);
                            this.boK = am.getDrawable(f.C0146f.icon_friend_time);
                            this.boK.setBounds(0, 0, this.size, this.size);
                            c0129a.boN.setCompoundDrawables(this.boK, null, null, null);
                            am.c(c0129a.boN, this.boI, 1);
                        }
                    } else {
                        c0129a.boM.setVisibility(8);
                        c0129a.boN.setVisibility(8);
                    }
                } else {
                    c0129a.boM.setVisibility(8);
                    c0129a.boN.setVisibility(8);
                }
                am.c(c0129a.boF, this.boG, 1);
                String Fv = item.Fv();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(Fv) || item2 == null || Fv.equals(item2.Fv())) ? false : true) {
                    c0129a.divider.setVisibility(4);
                } else {
                    c0129a.divider.setVisibility(0);
                    am.i(c0129a.divider, f.d.cp_bg_line_b);
                }
                am.i(view, f.C0146f.addresslist_item_bg);
                am.c(c0129a.boF, this.boG, 1);
                am.i(c0129a.divider, f.d.cp_bg_line_b);
                am.i(view, f.C0146f.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean iM(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) ? false : true;
    }

    public boolean aG(long j) {
        return j > 0 && j < Long.MAX_VALUE;
    }

    private void i(TextView textView, int i) {
        int i2;
        if (i <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        am.c(textView, f.d.common_color_10225, 1);
        if (i < 10) {
            textView.setText(String.valueOf(i));
            i2 = f.C0146f.icon_news_head_prompt_one;
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            i2 = f.C0146f.icon_news_head_prompt_two;
        } else {
            textView.setText("99+");
            i2 = f.C0146f.icon_news_head_prompt_two;
        }
        am.i(textView, i2);
    }

    /* loaded from: classes3.dex */
    private class c {
        ImageView boQ;
        View divider;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        TextView boP;
        View divider;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0129a {
        HeadImageView boE;
        TextView boF;
        TextView boM;
        TextView boN;
        View divider;

        private C0129a() {
        }
    }
}
