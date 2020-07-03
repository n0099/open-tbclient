package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private int mType = 0;
    private List<String> eFL = new ArrayList();
    private List<String> eFM = new ArrayList();
    private List<String> eFN = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.eFM.clear();
        this.eFN.clear();
        if (!w.isEmpty(list) && !w.isEmpty(list2)) {
            this.eFM.addAll(list);
            this.eFN.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.eFL.clear();
        if (!w.isEmpty(list)) {
            this.eFL.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.eFM)) {
            return 0;
        }
        return this.eFM.size();
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
            if (!w.isEmpty(this.eFM) && this.eFM.size() > i && !TextUtils.isEmpty(this.eFM.get(i))) {
                bVar.eFO.setText(this.eFM.get(i));
                bVar.eFO.setVisibility(0);
            } else {
                bVar.eFO.setVisibility(8);
            }
            if (!w.isEmpty(this.eFN) && this.eFN.size() > i && !TextUtils.isEmpty(this.eFN.get(i))) {
                bVar.cbI.setText(this.eFN.get(i));
                bVar.cbI.setVisibility(0);
            } else {
                bVar.cbI.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0502a c0502a = new C0502a(view);
            if (!w.isEmpty(this.eFL) && this.eFL.size() > i && !TextUtils.isEmpty(this.eFL.get(i))) {
                c0502a.dYH.setDefaultResource(R.drawable.transparent_bg);
                c0502a.dYH.startLoad(this.eFL.get(i), 10, false);
            }
            if (!w.isEmpty(this.eFM) && this.eFM.size() > i && !TextUtils.isEmpty(this.eFM.get(i))) {
                c0502a.eFO.setText(this.eFM.get(i));
                c0502a.eFO.setVisibility(0);
            } else {
                c0502a.eFO.setVisibility(8);
            }
            if (!w.isEmpty(this.eFN) && this.eFN.size() > i && !TextUtils.isEmpty(this.eFN.get(i))) {
                c0502a.cbI.setText(this.eFN.get(i));
                c0502a.cbI.setVisibility(0);
            } else {
                c0502a.cbI.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0502a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            an.setViewTextColor(bVar.eFO, (int) R.color.cp_cont_b);
            an.setViewTextColor(bVar.cbI, (int) R.color.cp_cont_d);
        }
    }

    public void a(C0502a c0502a) {
        if (c0502a != null) {
            an.setViewTextColor(c0502a.eFO, R.color.cp_cont_b, 1);
            an.setViewTextColor(c0502a.cbI, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cbI;
        public TextView eFO;

        public b(View view) {
            this.eFO = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cbI = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0502a {
        public TextView cbI;
        public TbImageView dYH;
        public TextView eFO;

        public C0502a(View view) {
            this.dYH = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.dYH.setDefaultBgResource(R.color.cp_bg_line_g);
            this.eFO = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cbI = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
