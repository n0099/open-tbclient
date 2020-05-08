package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.u.a;
import com.baidu.live.view.ALALevelView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<b> fqs = new ArrayList<>();
    private AlaPersonCenterExpActivity fqt;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.fqt = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void pT(int i) {
        this.mSkinType = i;
    }

    public void W(ArrayList<b> arrayList) {
        this.fqs.clear();
        this.fqs.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqs == null) {
            return 1;
        }
        return this.fqs.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.fqs.size())) {
            return null;
        }
        return this.fqs.get(i - 1);
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
        this.fqt.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0506a c0506a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_item, viewGroup, false);
            C0506a c0506a2 = new C0506a(view);
            view.setTag(c0506a2);
            c0506a = c0506a2;
        } else {
            c0506a = (C0506a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0506a.aB(bVar.level, bVar.fqw);
        }
        this.fqt.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0506a.fcr.b(a.d.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0506a {
        private ALALevelView fcr;
        private TextView fqu;

        public C0506a(View view) {
            this.fcr = (ALALevelView) view.findViewById(a.g.ala_person_center_exp_level);
            this.fqu = (TextView) view.findViewById(a.g.ala_person_center_exp_level_range);
        }

        public void aB(int i, String str) {
            this.fcr.setupLevelIcon(i);
            this.fqu.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
