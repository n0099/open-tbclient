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
    private List<String> fMw = new ArrayList();
    private List<String> fMx = new ArrayList();
    private List<String> fMy = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fMx.clear();
        this.fMy.clear();
        if (!x.isEmpty(list) && !x.isEmpty(list2)) {
            this.fMx.addAll(list);
            this.fMy.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fMw.clear();
        if (!x.isEmpty(list)) {
            this.fMw.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.fMx)) {
            return 0;
        }
        return this.fMx.size();
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
            if (!x.isEmpty(this.fMx) && this.fMx.size() > i && !TextUtils.isEmpty(this.fMx.get(i))) {
                bVar.fMz.setText(this.fMx.get(i));
                bVar.fMz.setVisibility(0);
            } else {
                bVar.fMz.setVisibility(8);
            }
            if (!x.isEmpty(this.fMy) && this.fMy.size() > i && !TextUtils.isEmpty(this.fMy.get(i))) {
                bVar.cRq.setText(this.fMy.get(i));
                bVar.cRq.setVisibility(0);
            } else {
                bVar.cRq.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0585a c0585a = new C0585a(view);
            if (!x.isEmpty(this.fMw) && this.fMw.size() > i && !TextUtils.isEmpty(this.fMw.get(i))) {
                c0585a.fcv.setDefaultResource(R.drawable.transparent_bg);
                c0585a.fcv.startLoad(this.fMw.get(i), 10, false);
            }
            if (!x.isEmpty(this.fMx) && this.fMx.size() > i && !TextUtils.isEmpty(this.fMx.get(i))) {
                c0585a.fMz.setText(this.fMx.get(i));
                c0585a.fMz.setVisibility(0);
            } else {
                c0585a.fMz.setVisibility(8);
            }
            if (!x.isEmpty(this.fMy) && this.fMy.size() > i && !TextUtils.isEmpty(this.fMy.get(i))) {
                c0585a.cRq.setText(this.fMy.get(i));
                c0585a.cRq.setVisibility(0);
            } else {
                c0585a.cRq.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0585a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ao.setViewTextColor(bVar.fMz, R.color.CAM_X0105);
            ao.setViewTextColor(bVar.cRq, R.color.CAM_X0109);
        }
    }

    public void a(C0585a c0585a) {
        if (c0585a != null) {
            ao.setViewTextColor(c0585a.fMz, R.color.CAM_X0105, 1);
            ao.setViewTextColor(c0585a.cRq, R.color.CAM_X0109, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cRq;
        public TextView fMz;

        public b(View view) {
            this.fMz = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cRq = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0585a {
        public TextView cRq;
        public TextView fMz;
        public TbImageView fcv;

        public C0585a(View view) {
            this.fcv = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.fcv.setDefaultBgResource(R.color.CAM_X0206);
            this.fMz = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cRq = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
