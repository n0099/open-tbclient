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
    private List<String> eZI = new ArrayList();
    private List<String> eZJ = new ArrayList();
    private List<String> eZK = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.eZJ.clear();
        this.eZK.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.eZJ.addAll(list);
            this.eZK.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.eZI.clear();
        if (!y.isEmpty(list)) {
            this.eZI.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.eZJ)) {
            return 0;
        }
        return this.eZJ.size();
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
            if (!y.isEmpty(this.eZJ) && this.eZJ.size() > i && !TextUtils.isEmpty(this.eZJ.get(i))) {
                bVar.eZL.setText(this.eZJ.get(i));
                bVar.eZL.setVisibility(0);
            } else {
                bVar.eZL.setVisibility(8);
            }
            if (!y.isEmpty(this.eZK) && this.eZK.size() > i && !TextUtils.isEmpty(this.eZK.get(i))) {
                bVar.clp.setText(this.eZK.get(i));
                bVar.clp.setVisibility(0);
            } else {
                bVar.clp.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0556a c0556a = new C0556a(view);
            if (!y.isEmpty(this.eZI) && this.eZI.size() > i && !TextUtils.isEmpty(this.eZI.get(i))) {
                c0556a.eqP.setDefaultResource(R.drawable.transparent_bg);
                c0556a.eqP.startLoad(this.eZI.get(i), 10, false);
            }
            if (!y.isEmpty(this.eZJ) && this.eZJ.size() > i && !TextUtils.isEmpty(this.eZJ.get(i))) {
                c0556a.eZL.setText(this.eZJ.get(i));
                c0556a.eZL.setVisibility(0);
            } else {
                c0556a.eZL.setVisibility(8);
            }
            if (!y.isEmpty(this.eZK) && this.eZK.size() > i && !TextUtils.isEmpty(this.eZK.get(i))) {
                c0556a.clp.setText(this.eZK.get(i));
                c0556a.clp.setVisibility(0);
            } else {
                c0556a.clp.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0556a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.eZL, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.clp, R.color.cp_cont_d);
        }
    }

    public void a(C0556a c0556a) {
        if (c0556a != null) {
            ap.setViewTextColor(c0556a.eZL, R.color.cp_cont_b, 1);
            ap.setViewTextColor(c0556a.clp, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView clp;
        public TextView eZL;

        public b(View view) {
            this.eZL = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.clp = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0556a {
        public TextView clp;
        public TextView eZL;
        public TbImageView eqP;

        public C0556a(View view) {
            this.eqP = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eqP.setDefaultBgResource(R.color.cp_bg_line_g);
            this.eZL = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.clp = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
