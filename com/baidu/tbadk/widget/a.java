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
    private List<String> fRd = new ArrayList();
    private List<String> fRe = new ArrayList();
    private List<String> fRf = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fRe.clear();
        this.fRf.clear();
        if (!x.isEmpty(list) && !x.isEmpty(list2)) {
            this.fRe.addAll(list);
            this.fRf.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fRd.clear();
        if (!x.isEmpty(list)) {
            this.fRd.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.fRe)) {
            return 0;
        }
        return this.fRe.size();
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
            if (!x.isEmpty(this.fRe) && this.fRe.size() > i && !TextUtils.isEmpty(this.fRe.get(i))) {
                bVar.fRg.setText(this.fRe.get(i));
                bVar.fRg.setVisibility(0);
            } else {
                bVar.fRg.setVisibility(8);
            }
            if (!x.isEmpty(this.fRf) && this.fRf.size() > i && !TextUtils.isEmpty(this.fRf.get(i))) {
                bVar.cWc.setText(this.fRf.get(i));
                bVar.cWc.setVisibility(0);
            } else {
                bVar.cWc.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0602a c0602a = new C0602a(view);
            if (!x.isEmpty(this.fRd) && this.fRd.size() > i && !TextUtils.isEmpty(this.fRd.get(i))) {
                c0602a.fhd.setDefaultResource(R.drawable.transparent_bg);
                c0602a.fhd.startLoad(this.fRd.get(i), 10, false);
            }
            if (!x.isEmpty(this.fRe) && this.fRe.size() > i && !TextUtils.isEmpty(this.fRe.get(i))) {
                c0602a.fRg.setText(this.fRe.get(i));
                c0602a.fRg.setVisibility(0);
            } else {
                c0602a.fRg.setVisibility(8);
            }
            if (!x.isEmpty(this.fRf) && this.fRf.size() > i && !TextUtils.isEmpty(this.fRf.get(i))) {
                c0602a.cWc.setText(this.fRf.get(i));
                c0602a.cWc.setVisibility(0);
            } else {
                c0602a.cWc.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0602a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ao.setViewTextColor(bVar.fRg, R.color.CAM_X0105);
            ao.setViewTextColor(bVar.cWc, R.color.CAM_X0109);
        }
    }

    public void a(C0602a c0602a) {
        if (c0602a != null) {
            ao.setViewTextColor(c0602a.fRg, R.color.CAM_X0105, 1);
            ao.setViewTextColor(c0602a.cWc, R.color.CAM_X0109, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cWc;
        public TextView fRg;

        public b(View view) {
            this.fRg = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cWc = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0602a {
        public TextView cWc;
        public TextView fRg;
        public TbImageView fhd;

        public C0602a(View view) {
            this.fhd = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.fhd.setDefaultBgResource(R.color.CAM_X0206);
            this.fRg = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cWc = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
