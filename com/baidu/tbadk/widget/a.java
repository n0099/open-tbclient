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
    private List<String> fHB = new ArrayList();
    private List<String> fHC = new ArrayList();
    private List<String> fHD = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fHC.clear();
        this.fHD.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.fHC.addAll(list);
            this.fHD.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fHB.clear();
        if (!y.isEmpty(list)) {
            this.fHB.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fHC)) {
            return 0;
        }
        return this.fHC.size();
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
            if (!y.isEmpty(this.fHC) && this.fHC.size() > i && !TextUtils.isEmpty(this.fHC.get(i))) {
                bVar.fHE.setText(this.fHC.get(i));
                bVar.fHE.setVisibility(0);
            } else {
                bVar.fHE.setVisibility(8);
            }
            if (!y.isEmpty(this.fHD) && this.fHD.size() > i && !TextUtils.isEmpty(this.fHD.get(i))) {
                bVar.cRf.setText(this.fHD.get(i));
                bVar.cRf.setVisibility(0);
            } else {
                bVar.cRf.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0611a c0611a = new C0611a(view);
            if (!y.isEmpty(this.fHB) && this.fHB.size() > i && !TextUtils.isEmpty(this.fHB.get(i))) {
                c0611a.eXC.setDefaultResource(R.drawable.transparent_bg);
                c0611a.eXC.startLoad(this.fHB.get(i), 10, false);
            }
            if (!y.isEmpty(this.fHC) && this.fHC.size() > i && !TextUtils.isEmpty(this.fHC.get(i))) {
                c0611a.fHE.setText(this.fHC.get(i));
                c0611a.fHE.setVisibility(0);
            } else {
                c0611a.fHE.setVisibility(8);
            }
            if (!y.isEmpty(this.fHD) && this.fHD.size() > i && !TextUtils.isEmpty(this.fHD.get(i))) {
                c0611a.cRf.setText(this.fHD.get(i));
                c0611a.cRf.setVisibility(0);
            } else {
                c0611a.cRf.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0611a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.fHE, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.cRf, R.color.CAM_X0109);
        }
    }

    public void a(C0611a c0611a) {
        if (c0611a != null) {
            ap.setViewTextColor(c0611a.fHE, R.color.CAM_X0105, 1);
            ap.setViewTextColor(c0611a.cRf, R.color.CAM_X0109, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cRf;
        public TextView fHE;

        public b(View view) {
            this.fHE = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cRf = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0611a {
        public TextView cRf;
        public TbImageView eXC;
        public TextView fHE;

        public C0611a(View view) {
            this.eXC = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.eXC.setDefaultBgResource(R.color.CAM_X0206);
            this.fHE = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cRf = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
