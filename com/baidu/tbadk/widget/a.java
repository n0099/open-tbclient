package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private int mType = 0;
    private List<String> eMh = new ArrayList();
    private List<String> eMi = new ArrayList();
    private List<String> eMj = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.eMi.clear();
        this.eMj.clear();
        if (!x.isEmpty(list) && !x.isEmpty(list2)) {
            this.eMi.addAll(list);
            this.eMj.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.eMh.clear();
        if (!x.isEmpty(list)) {
            this.eMh.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.eMi)) {
            return 0;
        }
        return this.eMi.size();
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
            if (!x.isEmpty(this.eMi) && this.eMi.size() > i && !TextUtils.isEmpty(this.eMi.get(i))) {
                bVar.eMk.setText(this.eMi.get(i));
                bVar.eMk.setVisibility(0);
            } else {
                bVar.eMk.setVisibility(8);
            }
            if (!x.isEmpty(this.eMj) && this.eMj.size() > i && !TextUtils.isEmpty(this.eMj.get(i))) {
                bVar.cdm.setText(this.eMj.get(i));
                bVar.cdm.setVisibility(0);
            } else {
                bVar.cdm.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0514a c0514a = new C0514a(view);
            if (!x.isEmpty(this.eMh) && this.eMh.size() > i && !TextUtils.isEmpty(this.eMh.get(i))) {
                c0514a.eeU.setDefaultResource(R.drawable.transparent_bg);
                c0514a.eeU.startLoad(this.eMh.get(i), 10, false);
            }
            if (!x.isEmpty(this.eMi) && this.eMi.size() > i && !TextUtils.isEmpty(this.eMi.get(i))) {
                c0514a.eMk.setText(this.eMi.get(i));
                c0514a.eMk.setVisibility(0);
            } else {
                c0514a.eMk.setVisibility(8);
            }
            if (!x.isEmpty(this.eMj) && this.eMj.size() > i && !TextUtils.isEmpty(this.eMj.get(i))) {
                c0514a.cdm.setText(this.eMj.get(i));
                c0514a.cdm.setVisibility(0);
            } else {
                c0514a.cdm.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0514a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ao.setViewTextColor(bVar.eMk, R.color.cp_cont_b);
            ao.setViewTextColor(bVar.cdm, R.color.cp_cont_d);
        }
    }

    public void a(C0514a c0514a) {
        if (c0514a != null) {
            ao.setViewTextColor(c0514a.eMk, R.color.cp_cont_b, 1);
            ao.setViewTextColor(c0514a.cdm, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cdm;
        public TextView eMk;

        public b(View view) {
            this.eMk = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cdm = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0514a {
        public TextView cdm;
        public TextView eMk;
        public TbImageView eeU;

        public C0514a(View view) {
            this.eeU = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eeU.setDefaultBgResource(R.color.cp_bg_line_g);
            this.eMk = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cdm = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
