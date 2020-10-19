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
    private List<String> flU = new ArrayList();
    private List<String> flV = new ArrayList();
    private List<String> flW = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.flV.clear();
        this.flW.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.flV.addAll(list);
            this.flW.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.flU.clear();
        if (!y.isEmpty(list)) {
            this.flU.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.flV)) {
            return 0;
        }
        return this.flV.size();
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
            if (!y.isEmpty(this.flV) && this.flV.size() > i && !TextUtils.isEmpty(this.flV.get(i))) {
                bVar.flX.setText(this.flV.get(i));
                bVar.flX.setVisibility(0);
            } else {
                bVar.flX.setVisibility(8);
            }
            if (!y.isEmpty(this.flW) && this.flW.size() > i && !TextUtils.isEmpty(this.flW.get(i))) {
                bVar.cxH.setText(this.flW.get(i));
                bVar.cxH.setVisibility(0);
            } else {
                bVar.cxH.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0573a c0573a = new C0573a(view);
            if (!y.isEmpty(this.flU) && this.flU.size() > i && !TextUtils.isEmpty(this.flU.get(i))) {
                c0573a.eDb.setDefaultResource(R.drawable.transparent_bg);
                c0573a.eDb.startLoad(this.flU.get(i), 10, false);
            }
            if (!y.isEmpty(this.flV) && this.flV.size() > i && !TextUtils.isEmpty(this.flV.get(i))) {
                c0573a.flX.setText(this.flV.get(i));
                c0573a.flX.setVisibility(0);
            } else {
                c0573a.flX.setVisibility(8);
            }
            if (!y.isEmpty(this.flW) && this.flW.size() > i && !TextUtils.isEmpty(this.flW.get(i))) {
                c0573a.cxH.setText(this.flW.get(i));
                c0573a.cxH.setVisibility(0);
            } else {
                c0573a.cxH.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0573a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.flX, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.cxH, R.color.cp_cont_d);
        }
    }

    public void a(C0573a c0573a) {
        if (c0573a != null) {
            ap.setViewTextColor(c0573a.flX, R.color.cp_cont_b, 1);
            ap.setViewTextColor(c0573a.cxH, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cxH;
        public TextView flX;

        public b(View view) {
            this.flX = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cxH = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0573a {
        public TextView cxH;
        public TbImageView eDb;
        public TextView flX;

        public C0573a(View view) {
            this.eDb = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eDb.setDefaultBgResource(R.color.cp_bg_line_g);
            this.flX = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cxH = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
