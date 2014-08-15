package com.baidu.tieba.discover.memberprivilege;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private MemberPrivilegeActivity a;
    private List<i> b;
    private int c;
    private boolean d = false;
    private h e;

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        this.a = memberPrivilegeActivity;
    }

    public void a(h hVar) {
        this.e = hVar;
        if (this.e != null) {
            this.b = this.e.a();
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e == null) {
            return 0;
        }
        this.b = this.e.a();
        if (this.b != null) {
            return this.b.size() + 1;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i == 0) {
            if (this.e != null && this.e.a != null) {
                return this.e.a;
            }
        } else if (this.e != null && this.e.b != null && i > 0 && i < getCount() && i - 1 < this.b.size()) {
            return this.b.get(i - 1);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < 0 || i >= getCount()) {
            return 2;
        }
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 0) {
            return a(i, view, viewGroup);
        }
        if (getItemViewType(i) == 1) {
            return b(i, view, viewGroup);
        }
        return null;
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        e eVar;
        k kVar;
        j jVar;
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        int color = this.a.getResources().getColor(r.cp_cont_b);
        int color2 = this.a.getResources().getColor(r.cp_cont_b_1);
        if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
            view = LayoutInflater.from(this.a).inflate(v.memberprivilege_headview, (ViewGroup) null);
            eVar = new e(null);
            eVar.a = (HeadImageView) view.findViewById(u.head_portrait);
            eVar.b = (TextView) view.findViewById(u.nonmember_stamp);
            eVar.c = (RelativeLayout) view.findViewById(u.member_stamp);
            eVar.d = (TextView) view.findViewById(u.membername);
            eVar.e = (TbImageView) view.findViewById(u.membericon);
            eVar.f = (TextView) view.findViewById(u.endtime);
            eVar.g = (Button) view.findViewById(u.button);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        if (getItem(i) == null || (kVar = (k) getItem(i)) == null || (jVar = kVar.c) == null) {
            return null;
        }
        this.c = (int) jVar.a;
        long j = jVar.b;
        String a = a(j, jVar.c);
        eVar.a.a(kVar.b, 12, false);
        eVar.a.setBackgroundResource(z ? t.memberinfo_bg_shape_1 : t.memberinfo_bg_shape);
        if (jVar.a()) {
            eVar.b.setVisibility(8);
            eVar.c.setVisibility(0);
            eVar.e.a(kVar.c.d, 21, false);
            if (this.d) {
                eVar.f.setText(a(a));
            } else {
                eVar.f.setText(this.a.getString(x.endtiem_memeber_tip, new Object[]{ba.d(new Date(j * 1000))}));
                eVar.f.setTextColor(z ? color2 : color);
            }
            eVar.d.setText(kVar.a);
            eVar.g.setText(x.continue_member);
            eVar.g.setOnClickListener(this.a);
        } else {
            eVar.b.setVisibility(0);
            eVar.c.setVisibility(8);
            eVar.b.setText(kVar.a);
            eVar.g.setText(x.dredge_member);
            eVar.g.setOnClickListener(this.a);
        }
        this.a.getLayoutMode().a(z);
        this.a.getLayoutMode().a(view);
        return view;
    }

    private String a(long j, long j2) {
        long j3 = j - j2;
        if (0 >= j3 || j3 > 345600) {
            return "";
        }
        this.d = true;
        if (0 < j3 && j3 <= 86400) {
            return this.a.getString(x.today);
        }
        if (86400 < j3 && j3 <= 172800) {
            return TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
        }
        if (172800 < j3 && j3 <= 259200) {
            return TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT;
        }
        return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
    }

    private SpannableString a(String str) {
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        SpannableString spannableString = new SpannableString(this.a.getString(x.endtime_days_tip, new Object[]{str}));
        if (z) {
            spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(r.cp_cont_b_1)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(r.cp_other_b_1)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(r.cp_cont_b_1)), 5, 16, 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(r.cp_cont_b)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(r.cp_other_b)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.a.getResources().getColor(r.cp_cont_b)), 5, 16, 33);
        }
        return spannableString;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        d dVar;
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
            view = LayoutInflater.from(this.a).inflate(v.memberprivilege_item, (ViewGroup) null);
            dVar = new d(null);
            dVar.a = (HeadImageView) view.findViewById(u.item_portrait);
            dVar.b = (TextView) view.findViewById(u.title);
            dVar.c = (TextView) view.findViewById(u.description);
            dVar.d = (ImageView) view.findViewById(u.divide_line_top);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        if (1 == i) {
            dVar.d.setVisibility(8);
        }
        i iVar = (i) getItem(i);
        dVar.a.a(iVar.a, 10, false);
        dVar.b.setText(iVar.b);
        dVar.c.setText(iVar.c);
        this.a.getLayoutMode().a(z);
        this.a.getLayoutMode().a(view);
        return view;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
