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
    private List<String> fuv = new ArrayList();
    private List<String> fuw = new ArrayList();
    private List<String> fux = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fuw.clear();
        this.fux.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.fuw.addAll(list);
            this.fux.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fuv.clear();
        if (!y.isEmpty(list)) {
            this.fuv.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fuw)) {
            return 0;
        }
        return this.fuw.size();
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
            if (!y.isEmpty(this.fuw) && this.fuw.size() > i && !TextUtils.isEmpty(this.fuw.get(i))) {
                bVar.fuy.setText(this.fuw.get(i));
                bVar.fuy.setVisibility(0);
            } else {
                bVar.fuy.setVisibility(8);
            }
            if (!y.isEmpty(this.fux) && this.fux.size() > i && !TextUtils.isEmpty(this.fux.get(i))) {
                bVar.cGd.setText(this.fux.get(i));
                bVar.cGd.setVisibility(0);
            } else {
                bVar.cGd.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0587a c0587a = new C0587a(view);
            if (!y.isEmpty(this.fuv) && this.fuv.size() > i && !TextUtils.isEmpty(this.fuv.get(i))) {
                c0587a.eLx.setDefaultResource(R.drawable.transparent_bg);
                c0587a.eLx.startLoad(this.fuv.get(i), 10, false);
            }
            if (!y.isEmpty(this.fuw) && this.fuw.size() > i && !TextUtils.isEmpty(this.fuw.get(i))) {
                c0587a.fuy.setText(this.fuw.get(i));
                c0587a.fuy.setVisibility(0);
            } else {
                c0587a.fuy.setVisibility(8);
            }
            if (!y.isEmpty(this.fux) && this.fux.size() > i && !TextUtils.isEmpty(this.fux.get(i))) {
                c0587a.cGd.setText(this.fux.get(i));
                c0587a.cGd.setVisibility(0);
            } else {
                c0587a.cGd.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0587a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.fuy, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.cGd, R.color.cp_cont_d);
        }
    }

    public void a(C0587a c0587a) {
        if (c0587a != null) {
            ap.setViewTextColor(c0587a.fuy, R.color.cp_cont_b, 1);
            ap.setViewTextColor(c0587a.cGd, R.color.cp_cont_d, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cGd;
        public TextView fuy;

        public b(View view) {
            this.fuy = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cGd = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0587a {
        public TextView cGd;
        public TbImageView eLx;
        public TextView fuy;

        public C0587a(View view) {
            this.eLx = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eLx.setDefaultBgResource(R.color.cp_bg_line_g);
            this.fuy = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cGd = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
