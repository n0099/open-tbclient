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
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context mContext;
    private int mType = 0;
    private List<String> fAl = new ArrayList();
    private List<String> fAm = new ArrayList();
    private List<String> fAn = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fAm.clear();
        this.fAn.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.fAm.addAll(list);
            this.fAn.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fAl.clear();
        if (!y.isEmpty(list)) {
            this.fAl.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fAm)) {
            return 0;
        }
        return this.fAm.size();
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
            if (!y.isEmpty(this.fAm) && this.fAm.size() > i && !TextUtils.isEmpty(this.fAm.get(i))) {
                bVar.fAo.setText(this.fAm.get(i));
                bVar.fAo.setVisibility(0);
            } else {
                bVar.fAo.setVisibility(8);
            }
            if (!y.isEmpty(this.fAn) && this.fAn.size() > i && !TextUtils.isEmpty(this.fAn.get(i))) {
                bVar.cLW.setText(this.fAn.get(i));
                bVar.cLW.setVisibility(0);
            } else {
                bVar.cLW.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0599a c0599a = new C0599a(view);
            if (!y.isEmpty(this.fAl) && this.fAl.size() > i && !TextUtils.isEmpty(this.fAl.get(i))) {
                c0599a.eRm.setDefaultResource(R.drawable.transparent_bg);
                c0599a.eRm.startLoad(this.fAl.get(i), 10, false);
            }
            if (!y.isEmpty(this.fAm) && this.fAm.size() > i && !TextUtils.isEmpty(this.fAm.get(i))) {
                c0599a.fAo.setText(this.fAm.get(i));
                c0599a.fAo.setVisibility(0);
            } else {
                c0599a.fAo.setVisibility(8);
            }
            if (!y.isEmpty(this.fAn) && this.fAn.size() > i && !TextUtils.isEmpty(this.fAn.get(i))) {
                c0599a.cLW.setText(this.fAn.get(i));
                c0599a.cLW.setVisibility(0);
            } else {
                c0599a.cLW.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0599a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.fAo, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.cLW, R.color.cp_cont_d);
        }
    }

    public void a(C0599a c0599a) {
        if (c0599a != null) {
            ap.setViewTextColor(c0599a.fAo, R.color.cp_cont_b, 1);
            ap.setViewTextColor(c0599a.cLW, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cLW;
        public TextView fAo;

        public b(View view) {
            this.fAo = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cLW = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0599a {
        public TextView cLW;
        public TbImageView eRm;
        public TextView fAo;

        public C0599a(View view) {
            this.eRm = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eRm.setDefaultBgResource(R.color.cp_bg_line_g);
            this.fAo = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cLW = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
