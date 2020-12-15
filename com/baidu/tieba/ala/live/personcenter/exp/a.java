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
    private ArrayList<b> gZc = new ArrayList<>();
    private AlaPersonCenterExpActivity gZd;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.gZd = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void wc(int i) {
        this.mSkinType = i;
    }

    public void af(ArrayList<b> arrayList) {
        this.gZc.clear();
        this.gZc.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZc == null) {
            return 1;
        }
        return this.gZc.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.gZc.size())) {
            return null;
        }
        return this.gZc.get(i - 1);
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
        this.gZd.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0674a c0674a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_item, viewGroup, false);
            C0674a c0674a2 = new C0674a(view);
            view.setTag(c0674a2);
            c0674a = c0674a2;
        } else {
            c0674a = (C0674a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0674a.aV(bVar.level, bVar.gZg);
        }
        this.gZd.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0674a.gFK.b(a.c.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0674a {
        private ALALevelView gFK;
        private TextView gZe;

        public C0674a(View view) {
            this.gFK = (ALALevelView) view.findViewById(a.f.ala_person_center_exp_level);
            this.gZe = (TextView) view.findViewById(a.f.ala_person_center_exp_level_range);
        }

        public void aV(int i, String str) {
            this.gFK.setupLevelIcon(i);
            this.gZe.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
