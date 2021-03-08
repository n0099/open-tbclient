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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<b> hmx = new ArrayList<>();
    private AlaPersonCenterExpActivity hmy;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.hmy = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void uT(int i) {
        this.mSkinType = i;
    }

    public void Z(ArrayList<b> arrayList) {
        this.hmx.clear();
        this.hmx.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmx == null) {
            return 1;
        }
        return this.hmx.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.hmx.size())) {
            return null;
        }
        return this.hmx.get(i - 1);
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
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_header, viewGroup, false);
        }
        this.hmy.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0656a c0656a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_item, viewGroup, false);
            C0656a c0656a2 = new C0656a(view);
            view.setTag(c0656a2);
            c0656a = c0656a2;
        } else {
            c0656a = (C0656a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0656a.bd(bVar.level, bVar.hmB);
        }
        this.hmy.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0656a.gRs.b(a.c.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0656a {
        private ALALevelView gRs;
        private TextView hmz;

        public C0656a(View view) {
            this.gRs = (ALALevelView) view.findViewById(a.f.ala_person_center_exp_level);
            this.hmz = (TextView) view.findViewById(a.f.ala_person_center_exp_level_range);
        }

        public void bd(int i, String str) {
            this.gRs.setupLevelIcon(i);
            this.hmz.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
