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
    private List<String> ewD = new ArrayList();
    private List<String> ewE = new ArrayList();
    private List<String> ewF = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.ewE.clear();
        this.ewF.clear();
        if (!v.isEmpty(list) && !v.isEmpty(list2)) {
            this.ewE.addAll(list);
            this.ewF.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.ewD.clear();
        if (!v.isEmpty(list)) {
            this.ewD.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.ewE)) {
            return 0;
        }
        return this.ewE.size();
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
            if (!v.isEmpty(this.ewE) && this.ewE.size() > i && !TextUtils.isEmpty(this.ewE.get(i))) {
                bVar.ewG.setText(this.ewE.get(i));
                bVar.ewG.setVisibility(0);
            } else {
                bVar.ewG.setVisibility(8);
            }
            if (!v.isEmpty(this.ewF) && this.ewF.size() > i && !TextUtils.isEmpty(this.ewF.get(i))) {
                bVar.bWU.setText(this.ewF.get(i));
                bVar.bWU.setVisibility(0);
            } else {
                bVar.bWU.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0496a c0496a = new C0496a(view);
            if (!v.isEmpty(this.ewD) && this.ewD.size() > i && !TextUtils.isEmpty(this.ewD.get(i))) {
                c0496a.dRP.setDefaultResource(R.drawable.transparent_bg);
                c0496a.dRP.startLoad(this.ewD.get(i), 10, false);
            }
            if (!v.isEmpty(this.ewE) && this.ewE.size() > i && !TextUtils.isEmpty(this.ewE.get(i))) {
                c0496a.ewG.setText(this.ewE.get(i));
                c0496a.ewG.setVisibility(0);
            } else {
                c0496a.ewG.setVisibility(8);
            }
            if (!v.isEmpty(this.ewF) && this.ewF.size() > i && !TextUtils.isEmpty(this.ewF.get(i))) {
                c0496a.bWU.setText(this.ewF.get(i));
                c0496a.bWU.setVisibility(0);
            } else {
                c0496a.bWU.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0496a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            am.setViewTextColor(bVar.ewG, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.bWU, (int) R.color.cp_cont_d);
        }
    }

    public void a(C0496a c0496a) {
        if (c0496a != null) {
            am.setViewTextColor(c0496a.ewG, R.color.cp_cont_b, 1);
            am.setViewTextColor(c0496a.bWU, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView bWU;
        public TextView ewG;

        public b(View view) {
            this.ewG = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.bWU = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0496a {
        public TextView bWU;
        public TbImageView dRP;
        public TextView ewG;

        public C0496a(View view) {
            this.dRP = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.dRP.setDefaultBgResource(R.color.cp_bg_line_g);
            this.ewG = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.bWU = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
