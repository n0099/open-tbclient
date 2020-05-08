package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private int mType = 0;
    private List<String> eia = new ArrayList();
    private List<String> eib = new ArrayList();
    private List<String> eic = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.eib.clear();
        this.eic.clear();
        if (!v.isEmpty(list) && !v.isEmpty(list2)) {
            this.eib.addAll(list);
            this.eic.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.eia.clear();
        if (!v.isEmpty(list)) {
            this.eia.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.eib)) {
            return 0;
        }
        return this.eib.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.mType == 0) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
            b bVar = new b(view);
            if (!v.isEmpty(this.eib) && this.eib.size() > i && !TextUtils.isEmpty(this.eib.get(i))) {
                bVar.eid.setText(this.eib.get(i));
                bVar.eid.setVisibility(0);
            } else {
                bVar.eid.setVisibility(8);
            }
            if (!v.isEmpty(this.eic) && this.eic.size() > i && !TextUtils.isEmpty(this.eic.get(i))) {
                bVar.bNO.setText(this.eic.get(i));
                bVar.bNO.setVisibility(0);
            } else {
                bVar.bNO.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0449a c0449a = new C0449a(view);
            if (!v.isEmpty(this.eia) && this.eia.size() > i && !TextUtils.isEmpty(this.eia.get(i))) {
                c0449a.dDD.setDefaultResource(R.drawable.transparent_bg);
                c0449a.dDD.startLoad(this.eia.get(i), 10, false);
            }
            if (!v.isEmpty(this.eib) && this.eib.size() > i && !TextUtils.isEmpty(this.eib.get(i))) {
                c0449a.eid.setText(this.eib.get(i));
                c0449a.eid.setVisibility(0);
            } else {
                c0449a.eid.setVisibility(8);
            }
            if (!v.isEmpty(this.eic) && this.eic.size() > i && !TextUtils.isEmpty(this.eic.get(i))) {
                c0449a.bNO.setText(this.eic.get(i));
                c0449a.bNO.setVisibility(0);
            } else {
                c0449a.bNO.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0449a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            am.setViewTextColor(bVar.eid, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.bNO, (int) R.color.cp_cont_d);
        }
    }

    public void a(C0449a c0449a) {
        if (c0449a != null) {
            am.setViewTextColor(c0449a.eid, R.color.cp_cont_b, 1);
            am.setViewTextColor(c0449a.bNO, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView bNO;
        public TextView eid;

        public b(View view) {
            this.eid = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.bNO = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0449a {
        public TextView bNO;
        public TbImageView dDD;
        public TextView eid;

        public C0449a(View view) {
            this.dDD = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.dDD.setDefaultBgResource(R.color.cp_bg_line_g);
            this.eid = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.bNO = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
