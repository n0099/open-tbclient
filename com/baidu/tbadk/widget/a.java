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
    private List<String> ehV = new ArrayList();
    private List<String> ehW = new ArrayList();
    private List<String> ehX = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.ehW.clear();
        this.ehX.clear();
        if (!v.isEmpty(list) && !v.isEmpty(list2)) {
            this.ehW.addAll(list);
            this.ehX.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.ehV.clear();
        if (!v.isEmpty(list)) {
            this.ehV.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.ehW)) {
            return 0;
        }
        return this.ehW.size();
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
            if (!v.isEmpty(this.ehW) && this.ehW.size() > i && !TextUtils.isEmpty(this.ehW.get(i))) {
                bVar.ehY.setText(this.ehW.get(i));
                bVar.ehY.setVisibility(0);
            } else {
                bVar.ehY.setVisibility(8);
            }
            if (!v.isEmpty(this.ehX) && this.ehX.size() > i && !TextUtils.isEmpty(this.ehX.get(i))) {
                bVar.bNJ.setText(this.ehX.get(i));
                bVar.bNJ.setVisibility(0);
            } else {
                bVar.bNJ.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0428a c0428a = new C0428a(view);
            if (!v.isEmpty(this.ehV) && this.ehV.size() > i && !TextUtils.isEmpty(this.ehV.get(i))) {
                c0428a.dDz.setDefaultResource(R.drawable.transparent_bg);
                c0428a.dDz.startLoad(this.ehV.get(i), 10, false);
            }
            if (!v.isEmpty(this.ehW) && this.ehW.size() > i && !TextUtils.isEmpty(this.ehW.get(i))) {
                c0428a.ehY.setText(this.ehW.get(i));
                c0428a.ehY.setVisibility(0);
            } else {
                c0428a.ehY.setVisibility(8);
            }
            if (!v.isEmpty(this.ehX) && this.ehX.size() > i && !TextUtils.isEmpty(this.ehX.get(i))) {
                c0428a.bNJ.setText(this.ehX.get(i));
                c0428a.bNJ.setVisibility(0);
            } else {
                c0428a.bNJ.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0428a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            am.setViewTextColor(bVar.ehY, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.bNJ, (int) R.color.cp_cont_d);
        }
    }

    public void a(C0428a c0428a) {
        if (c0428a != null) {
            am.setViewTextColor(c0428a.ehY, R.color.cp_cont_b, 1);
            am.setViewTextColor(c0428a.bNJ, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView bNJ;
        public TextView ehY;

        public b(View view) {
            this.ehY = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.bNJ = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0428a {
        public TextView bNJ;
        public TbImageView dDz;
        public TextView ehY;

        public C0428a(View view) {
            this.dDz = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.dDz.setDefaultBgResource(R.color.cp_bg_line_g);
            this.ehY = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.bNJ = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
