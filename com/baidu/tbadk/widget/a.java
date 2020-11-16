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
    private List<String> fzL = new ArrayList();
    private List<String> fzM = new ArrayList();
    private List<String> fzN = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fzM.clear();
        this.fzN.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.fzM.addAll(list);
            this.fzN.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fzL.clear();
        if (!y.isEmpty(list)) {
            this.fzL.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fzM)) {
            return 0;
        }
        return this.fzM.size();
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
            if (!y.isEmpty(this.fzM) && this.fzM.size() > i && !TextUtils.isEmpty(this.fzM.get(i))) {
                bVar.fzO.setText(this.fzM.get(i));
                bVar.fzO.setVisibility(0);
            } else {
                bVar.fzO.setVisibility(8);
            }
            if (!y.isEmpty(this.fzN) && this.fzN.size() > i && !TextUtils.isEmpty(this.fzN.get(i))) {
                bVar.cKm.setText(this.fzN.get(i));
                bVar.cKm.setVisibility(0);
            } else {
                bVar.cKm.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0598a c0598a = new C0598a(view);
            if (!y.isEmpty(this.fzL) && this.fzL.size() > i && !TextUtils.isEmpty(this.fzL.get(i))) {
                c0598a.eQn.setDefaultResource(R.drawable.transparent_bg);
                c0598a.eQn.startLoad(this.fzL.get(i), 10, false);
            }
            if (!y.isEmpty(this.fzM) && this.fzM.size() > i && !TextUtils.isEmpty(this.fzM.get(i))) {
                c0598a.fzO.setText(this.fzM.get(i));
                c0598a.fzO.setVisibility(0);
            } else {
                c0598a.fzO.setVisibility(8);
            }
            if (!y.isEmpty(this.fzN) && this.fzN.size() > i && !TextUtils.isEmpty(this.fzN.get(i))) {
                c0598a.cKm.setText(this.fzN.get(i));
                c0598a.cKm.setVisibility(0);
            } else {
                c0598a.cKm.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0598a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.fzO, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.cKm, R.color.CAM_X0109);
        }
    }

    public void a(C0598a c0598a) {
        if (c0598a != null) {
            ap.setViewTextColor(c0598a.fzO, R.color.CAM_X0105, 1);
            ap.setViewTextColor(c0598a.cKm, R.color.CAM_X0109, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cKm;
        public TextView fzO;

        public b(View view) {
            this.fzO = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cKm = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0598a {
        public TextView cKm;
        public TbImageView eQn;
        public TextView fzO;

        public C0598a(View view) {
            this.eQn = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eQn.setDefaultBgResource(R.color.CAM_X0206);
            this.fzO = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cKm = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
