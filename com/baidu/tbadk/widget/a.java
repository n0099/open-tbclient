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
    private List<String> eWR = new ArrayList();
    private List<String> eWS = new ArrayList();
    private List<String> eWT = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.eWS.clear();
        this.eWT.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.eWS.addAll(list);
            this.eWT.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.eWR.clear();
        if (!y.isEmpty(list)) {
            this.eWR.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.eWS)) {
            return 0;
        }
        return this.eWS.size();
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
            if (!y.isEmpty(this.eWS) && this.eWS.size() > i && !TextUtils.isEmpty(this.eWS.get(i))) {
                bVar.eWU.setText(this.eWS.get(i));
                bVar.eWU.setVisibility(0);
            } else {
                bVar.eWU.setVisibility(8);
            }
            if (!y.isEmpty(this.eWT) && this.eWT.size() > i && !TextUtils.isEmpty(this.eWT.get(i))) {
                bVar.cjo.setText(this.eWT.get(i));
                bVar.cjo.setVisibility(0);
            } else {
                bVar.cjo.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0560a c0560a = new C0560a(view);
            if (!y.isEmpty(this.eWR) && this.eWR.size() > i && !TextUtils.isEmpty(this.eWR.get(i))) {
                c0560a.eoz.setDefaultResource(R.drawable.transparent_bg);
                c0560a.eoz.startLoad(this.eWR.get(i), 10, false);
            }
            if (!y.isEmpty(this.eWS) && this.eWS.size() > i && !TextUtils.isEmpty(this.eWS.get(i))) {
                c0560a.eWU.setText(this.eWS.get(i));
                c0560a.eWU.setVisibility(0);
            } else {
                c0560a.eWU.setVisibility(8);
            }
            if (!y.isEmpty(this.eWT) && this.eWT.size() > i && !TextUtils.isEmpty(this.eWT.get(i))) {
                c0560a.cjo.setText(this.eWT.get(i));
                c0560a.cjo.setVisibility(0);
            } else {
                c0560a.cjo.setVisibility(8);
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
            ap.setViewTextColor(bVar.eWU, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.cjo, R.color.cp_cont_d);
        }
    }

    public void a(C0560a c0560a) {
        if (c0560a != null) {
            ap.setViewTextColor(c0560a.eWU, R.color.cp_cont_b, 1);
            ap.setViewTextColor(c0560a.cjo, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cjo;
        public TextView eWU;

        public b(View view) {
            this.eWU = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cjo = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0560a {
        public TextView cjo;
        public TextView eWU;
        public TbImageView eoz;

        public C0560a(View view) {
            this.eoz = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eoz.setDefaultBgResource(R.color.cp_bg_line_g);
            this.eWU = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cjo = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
