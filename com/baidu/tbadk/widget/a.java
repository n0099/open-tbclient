package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private int mType = 0;
    private List<String> eWN = new ArrayList();
    private List<String> eWO = new ArrayList();
    private List<String> eWP = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.eWO.clear();
        this.eWP.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.eWO.addAll(list);
            this.eWP.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.eWN.clear();
        if (!y.isEmpty(list)) {
            this.eWN.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.eWO)) {
            return 0;
        }
        return this.eWO.size();
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
            if (!y.isEmpty(this.eWO) && this.eWO.size() > i && !TextUtils.isEmpty(this.eWO.get(i))) {
                bVar.eWQ.setText(this.eWO.get(i));
                bVar.eWQ.setVisibility(0);
            } else {
                bVar.eWQ.setVisibility(8);
            }
            if (!y.isEmpty(this.eWP) && this.eWP.size() > i && !TextUtils.isEmpty(this.eWP.get(i))) {
                bVar.cjk.setText(this.eWP.get(i));
                bVar.cjk.setVisibility(0);
            } else {
                bVar.cjk.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0560a c0560a = new C0560a(view);
            if (!y.isEmpty(this.eWN) && this.eWN.size() > i && !TextUtils.isEmpty(this.eWN.get(i))) {
                c0560a.eov.setDefaultResource(R.drawable.transparent_bg);
                c0560a.eov.startLoad(this.eWN.get(i), 10, false);
            }
            if (!y.isEmpty(this.eWO) && this.eWO.size() > i && !TextUtils.isEmpty(this.eWO.get(i))) {
                c0560a.eWQ.setText(this.eWO.get(i));
                c0560a.eWQ.setVisibility(0);
            } else {
                c0560a.eWQ.setVisibility(8);
            }
            if (!y.isEmpty(this.eWP) && this.eWP.size() > i && !TextUtils.isEmpty(this.eWP.get(i))) {
                c0560a.cjk.setText(this.eWP.get(i));
                c0560a.cjk.setVisibility(0);
            } else {
                c0560a.cjk.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0560a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.eWQ, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.cjk, R.color.cp_cont_d);
        }
    }

    public void a(C0560a c0560a) {
        if (c0560a != null) {
            ap.setViewTextColor(c0560a.eWQ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(c0560a.cjk, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView cjk;
        public TextView eWQ;

        public b(View view) {
            this.eWQ = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cjk = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0560a {
        public TextView cjk;
        public TextView eWQ;
        public TbImageView eov;

        public C0560a(View view) {
            this.eov = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eov.setDefaultBgResource(R.color.cp_bg_line_g);
            this.eWQ = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cjk = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
