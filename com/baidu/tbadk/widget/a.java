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
    private List<String> fQj = new ArrayList();
    private List<String> fQk = new ArrayList();
    private List<String> fQl = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fQk.clear();
        this.fQl.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.fQk.addAll(list);
            this.fQl.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fQj.clear();
        if (!y.isEmpty(list)) {
            this.fQj.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fQk)) {
            return 0;
        }
        return this.fQk.size();
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
            if (!y.isEmpty(this.fQk) && this.fQk.size() > i && !TextUtils.isEmpty(this.fQk.get(i))) {
                bVar.fQm.setText(this.fQk.get(i));
                bVar.fQm.setVisibility(0);
            } else {
                bVar.fQm.setVisibility(8);
            }
            if (!y.isEmpty(this.fQl) && this.fQl.size() > i && !TextUtils.isEmpty(this.fQl.get(i))) {
                bVar.cVd.setText(this.fQl.get(i));
                bVar.cVd.setVisibility(0);
            } else {
                bVar.cVd.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0588a c0588a = new C0588a(view);
            if (!y.isEmpty(this.fQj) && this.fQj.size() > i && !TextUtils.isEmpty(this.fQj.get(i))) {
                c0588a.fgj.setDefaultResource(R.drawable.transparent_bg);
                c0588a.fgj.startLoad(this.fQj.get(i), 10, false);
            }
            if (!y.isEmpty(this.fQk) && this.fQk.size() > i && !TextUtils.isEmpty(this.fQk.get(i))) {
                c0588a.fQm.setText(this.fQk.get(i));
                c0588a.fQm.setVisibility(0);
            } else {
                c0588a.fQm.setVisibility(8);
            }
            if (!y.isEmpty(this.fQl) && this.fQl.size() > i && !TextUtils.isEmpty(this.fQl.get(i))) {
                c0588a.cVd.setText(this.fQl.get(i));
                c0588a.cVd.setVisibility(0);
            } else {
                c0588a.cVd.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0588a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.fQm, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.cVd, R.color.CAM_X0109);
        }
    }

    public void a(C0588a c0588a) {
        if (c0588a != null) {
            ap.setViewTextColor(c0588a.fQm, R.color.CAM_X0105, 1);
            ap.setViewTextColor(c0588a.cVd, R.color.CAM_X0109, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cVd;
        public TextView fQm;

        public b(View view) {
            this.fQm = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cVd = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0588a {
        public TextView cVd;
        public TextView fQm;
        public TbImageView fgj;

        public C0588a(View view) {
            this.fgj = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.fgj.setDefaultBgResource(R.color.CAM_X0206);
            this.fQm = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cVd = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
