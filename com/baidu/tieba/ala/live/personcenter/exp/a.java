package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.view.ALALevelView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<b> gkn = new ArrayList<>();
    private AlaPersonCenterExpActivity gko;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.gko = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void tP(int i) {
        this.mSkinType = i;
    }

    public void ad(ArrayList<b> arrayList) {
        this.gkn.clear();
        this.gkn.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkn == null) {
            return 1;
        }
        return this.gkn.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.gkn.size())) {
            return null;
        }
        return this.gkn.get(i - 1);
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
        this.gko.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0615a c0615a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_item, viewGroup, false);
            C0615a c0615a2 = new C0615a(view);
            view.setTag(c0615a2);
            c0615a = c0615a2;
        } else {
            c0615a = (C0615a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0615a.aI(bVar.level, bVar.gkr);
        }
        this.gko.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0615a.fVg.b(a.d.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0615a {
        private ALALevelView fVg;
        private TextView gkp;

        public C0615a(View view) {
            this.fVg = (ALALevelView) view.findViewById(a.g.ala_person_center_exp_level);
            this.gkp = (TextView) view.findViewById(a.g.ala_person_center_exp_level_range);
        }

        public void aI(int i, String str) {
            this.fVg.setupLevelIcon(i);
            this.gkp.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
