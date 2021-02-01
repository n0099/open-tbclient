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
    private List<String> fOJ = new ArrayList();
    private List<String> fOK = new ArrayList();
    private List<String> fOL = new ArrayList();

    public a(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> list, List<String> list2) {
        this.fOK.clear();
        this.fOL.clear();
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            this.fOK.addAll(list);
            this.fOL.addAll(list2);
        }
        notifyDataSetChanged();
    }

    public void setData(List<String> list, List<String> list2, List<String> list3) {
        this.fOJ.clear();
        if (!y.isEmpty(list)) {
            this.fOJ.addAll(list);
        }
        setData(list2, list3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.fOK)) {
            return 0;
        }
        return this.fOK.size();
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
            if (!y.isEmpty(this.fOK) && this.fOK.size() > i && !TextUtils.isEmpty(this.fOK.get(i))) {
                bVar.fOM.setText(this.fOK.get(i));
                bVar.fOM.setVisibility(0);
            } else {
                bVar.fOM.setVisibility(8);
            }
            if (!y.isEmpty(this.fOL) && this.fOL.size() > i && !TextUtils.isEmpty(this.fOL.get(i))) {
                bVar.cTD.setText(this.fOL.get(i));
                bVar.cTD.setVisibility(0);
            } else {
                bVar.cTD.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            view.setLayoutParams(layoutParams);
            a(bVar);
        } else if (this.mType == 1) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
            C0582a c0582a = new C0582a(view);
            if (!y.isEmpty(this.fOJ) && this.fOJ.size() > i && !TextUtils.isEmpty(this.fOJ.get(i))) {
                c0582a.feK.setDefaultResource(R.drawable.transparent_bg);
                c0582a.feK.startLoad(this.fOJ.get(i), 10, false);
            }
            if (!y.isEmpty(this.fOK) && this.fOK.size() > i && !TextUtils.isEmpty(this.fOK.get(i))) {
                c0582a.fOM.setText(this.fOK.get(i));
                c0582a.fOM.setVisibility(0);
            } else {
                c0582a.fOM.setVisibility(8);
            }
            if (!y.isEmpty(this.fOL) && this.fOL.size() > i && !TextUtils.isEmpty(this.fOL.get(i))) {
                c0582a.cTD.setText(this.fOL.get(i));
                c0582a.cTD.setVisibility(0);
            } else {
                c0582a.cTD.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            view.setLayoutParams(layoutParams2);
            a(c0582a);
        }
        return view;
    }

    public void a(b bVar) {
        if (bVar != null) {
            ap.setViewTextColor(bVar.fOM, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.cTD, R.color.CAM_X0109);
        }
    }

    public void a(C0582a c0582a) {
        if (c0582a != null) {
            ap.setViewTextColor(c0582a.fOM, R.color.CAM_X0105, 1);
            ap.setViewTextColor(c0582a.cTD, R.color.CAM_X0109, 1);
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cTD;
        public TextView fOM;

        public b(View view) {
            this.fOM = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.cTD = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    /* renamed from: com.baidu.tbadk.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0582a {
        public TextView cTD;
        public TextView fOM;
        public TbImageView feK;

        public C0582a(View view) {
            this.feK = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.feK.setDefaultBgResource(R.color.CAM_X0206);
            this.fOM = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.cTD = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }
}
