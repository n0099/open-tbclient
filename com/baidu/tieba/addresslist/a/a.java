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
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private int fTb;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fTn;
    private int fTq = R.color.CAM_X0105;
    private int fTr = R.color.CAM_X0108;
    private int fTs = R.color.CAM_X0109;
    private Drawable fTt;
    private Drawable fTu;
    private boolean fTv;
    private Context mContext;
    private int size;

    public a(Context context, com.baidu.tbadk.core.c cVar) {
        this.fTv = true;
        this.mContext = context;
        this.size = l.getDimens(this.mContext, R.dimen.ds24);
        this.fTv = TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class);
    }

    public void setContacts(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fTn = list;
        notifyDataSetChanged();
    }

    public void tQ(int i) {
        this.fTb = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = this.fTv ? 3 : 2;
        return this.fTn == null ? i : i + this.fTn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tP */
    public com.baidu.tbadk.coreExtra.relationship.a getItem(int i) {
        int i2 = this.fTv ? 3 : 2;
        if (i < i2 || i >= getCount()) {
            return null;
        }
        return this.fTn.get(i - i2);
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
        if (i == 2 && this.fTv) {
            return 1;
        }
        if (item == null) {
            return 4;
        }
        return (!TextUtils.isEmpty(item.bwG()) && TextUtils.isEmpty(item.getUserName()) && TextUtils.isEmpty(item.getUserPortrait())) ? 2 : 3;
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
                cVar4.cdC = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar4.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar4.eHl = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar4);
                cVar3 = cVar4;
            } else {
                cVar3 = (c) view.getTag();
            }
            ap.setImageResource(cVar3.cdC, R.drawable.icon_new_friend);
            ap.setViewTextColor(cVar3.title, this.fTq, 1);
            ap.setBackgroundResource(cVar3.eHl, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            b((TextView) view.findViewById(R.id.addresslist_new_friend_message), this.fTb);
            return view;
        } else if (getItemViewType(i) == 5) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_new_friends, (ViewGroup) null);
                c cVar5 = new c();
                cVar5.cdC = (ImageView) view.findViewById(R.id.addresslist_new_friend_icon);
                cVar5.title = (TextView) view.findViewById(R.id.addresslist_new_friend_text);
                cVar5.eHl = view.findViewById(R.id.addresslist_new_friend_divider);
                view.setTag(cVar5);
                cVar2 = cVar5;
            } else {
                cVar2 = (c) view.getTag();
            }
            ap.setImageResource(cVar2.cdC, R.drawable.icon_add_friend);
            ap.setViewTextColor(cVar2.title, this.fTq, 1);
            cVar2.title.setText(this.mContext.getResources().getString(R.string.find_new_friend));
            ap.setBackgroundResource(cVar2.eHl, R.color.CAM_X0204);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ((TextView) view.findViewById(R.id.addresslist_new_friend_message)).setVisibility(8);
            return view;
        } else if (getItemViewType(i) == 1) {
            if (view == 0 || view.getTag() == null || !(view.getTag() instanceof c)) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_header_my_groups, (ViewGroup) null);
                c cVar6 = new c();
                cVar6.cdC = (ImageView) view.findViewById(R.id.addresslist_my_groups_icon);
                cVar6.title = (TextView) view.findViewById(R.id.addresslist_my_groups_text);
                view.setTag(cVar6);
                cVar = cVar6;
            } else {
                cVar = (c) view.getTag();
            }
            ap.setImageResource(cVar.cdC, R.drawable.icon_me_group);
            ap.setViewTextColor(cVar.title, this.fTq, 1);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            return view;
        } else {
            com.baidu.tbadk.coreExtra.relationship.a item = getItem(i);
            if (getItemViewType(i) == 2) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_group_item, (ViewGroup) null);
                    b bVar2 = new b();
                    bVar2.fTz = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    bVar2.eHl = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                if (item.bwG() != null) {
                    bVar.fTz.setText(item.bwG());
                }
                ap.setViewTextColor(bVar.fTz, this.fTr, 1);
                ap.setBackgroundResource(bVar.eHl, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i) == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof C0609a)) {
                    C0609a c0609a2 = new C0609a();
                    view = LayoutInflater.from(this.mContext).inflate(R.layout.addresslist_child_item, (ViewGroup) null);
                    c0609a2.fTo = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    c0609a2.fTp = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    c0609a2.fTw = (TextView) view.findViewById(R.id.detail_info_distance);
                    c0609a2.fTx = (TextView) view.findViewById(R.id.detail_info_time);
                    c0609a2.eHl = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(c0609a2);
                    c0609a = c0609a2;
                } else {
                    c0609a = (C0609a) view.getTag();
                }
                if (item.getUserName() != null) {
                    c0609a.fTp.setText(item.getUserName());
                    c0609a.fTo.startLoad(item.getUserPortrait(), 12, false);
                }
                item.setLbsInfo(null);
                if (item.getLbsInfo() != null) {
                    if (item.getLbsInfo().bwI() == 1) {
                        c0609a.fTw.setVisibility(0);
                        ap.setViewTextColor(c0609a.fTw, this.fTs, 1);
                        c0609a.fTw.setText(this.mContext.getResources().getString(R.string.contact_yinshen));
                        c0609a.fTw.setCompoundDrawables(null, null, null, null);
                        c0609a.fTx.setVisibility(8);
                    } else if (item.getLbsInfo().bwI() == 0) {
                        if (!EV(item.getLbsInfo().getDistance()) || !ei(item.getLbsInfo().getTime())) {
                            c0609a.fTw.setVisibility(8);
                            c0609a.fTx.setVisibility(8);
                        } else {
                            c0609a.fTw.setVisibility(0);
                            c0609a.fTx.setVisibility(0);
                            c0609a.fTw.setText(item.getLbsInfo().getDistance());
                            c0609a.fTx.setText(au.getTimeInterval(item.getLbsInfo().getTime()));
                            ap.setViewTextColor(c0609a.fTw, this.fTs, 1);
                            this.fTt = ap.getDrawable(R.drawable.icon_friend_pin);
                            this.fTt.setBounds(0, 0, this.size, this.size);
                            c0609a.fTw.setCompoundDrawables(this.fTt, null, null, null);
                            this.fTu = ap.getDrawable(R.drawable.icon_friend_time);
                            this.fTu.setBounds(0, 0, this.size, this.size);
                            c0609a.fTx.setCompoundDrawables(this.fTu, null, null, null);
                            ap.setViewTextColor(c0609a.fTx, this.fTs, 1);
                        }
                    } else {
                        c0609a.fTw.setVisibility(8);
                        c0609a.fTx.setVisibility(8);
                    }
                } else {
                    c0609a.fTw.setVisibility(8);
                    c0609a.fTx.setVisibility(8);
                }
                ap.setViewTextColor(c0609a.fTp, this.fTq, 1);
                String bwG = item.bwG();
                com.baidu.tbadk.coreExtra.relationship.a item2 = getItem(i + 1);
                if ((TextUtils.isEmpty(bwG) || item2 == null || bwG.equals(item2.bwG())) ? false : true) {
                    c0609a.eHl.setVisibility(4);
                } else {
                    c0609a.eHl.setVisibility(0);
                    ap.setBackgroundResource(c0609a.eHl, R.color.CAM_X0204);
                }
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                ap.setViewTextColor(c0609a.fTp, this.fTq, 1);
                ap.setBackgroundResource(c0609a.eHl, R.color.CAM_X0204);
                ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
                return view;
            } else {
                return null;
            }
        }
    }

    public boolean EV(String str) {
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

    /* loaded from: classes20.dex */
    private class c {
        ImageView cdC;
        View eHl;
        TextView title;

        private c() {
        }
    }

    /* loaded from: classes20.dex */
    private class b {
        View eHl;
        TextView fTz;

        private b() {
        }
    }

    /* renamed from: com.baidu.tieba.addresslist.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private class C0609a {
        View eHl;
        HeadImageView fTo;
        TextView fTp;
        TextView fTw;
        TextView fTx;

        private C0609a() {
        }
    }
}
