package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.view.ALALevelView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<b> eHq = new ArrayList<>();
    private AlaPersonCenterExpActivity eHr;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.eHr = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void pl(int i) {
        this.mSkinType = i;
    }

    public void T(ArrayList<b> arrayList) {
        this.eHq.clear();
        this.eHq.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHq == null) {
            return 1;
        }
        return this.eHq.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.eHq.size())) {
            return null;
        }
        return this.eHq.get(i - 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return a(i, view, viewGroup);
        }
        if (itemViewType == 1) {
            return b(i, view, viewGroup);
        }
        return view;
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_header, viewGroup, false);
        }
        this.eHr.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0439a c0439a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_item, viewGroup, false);
            C0439a c0439a2 = new C0439a(view);
            view.setTag(c0439a2);
            c0439a = c0439a2;
        } else {
            c0439a = (C0439a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0439a.ak(bVar.level, bVar.eHv);
        }
        this.eHr.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0439a.eHs.d(a.d.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0439a {
        private ALALevelView eHs;
        private TextView eHt;

        public C0439a(View view) {
            this.eHs = (ALALevelView) view.findViewById(a.g.ala_person_center_exp_level);
            this.eHt = (TextView) view.findViewById(a.g.ala_person_center_exp_level_range);
        }

        public void ak(int i, String str) {
            this.eHs.setupLevelIcon(i);
            this.eHt.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
