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
    private ArrayList<b> fEx = new ArrayList<>();
    private AlaPersonCenterExpActivity fEy;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.fEy = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void qv(int i) {
        this.mSkinType = i;
    }

    public void W(ArrayList<b> arrayList) {
        this.fEx.clear();
        this.fEx.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEx == null) {
            return 1;
        }
        return this.fEx.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.fEx.size())) {
            return null;
        }
        return this.fEx.get(i - 1);
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
        this.fEy.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0553a c0553a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_item, viewGroup, false);
            C0553a c0553a2 = new C0553a(view);
            view.setTag(c0553a2);
            c0553a = c0553a2;
        } else {
            c0553a = (C0553a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0553a.aG(bVar.level, bVar.fEB);
        }
        this.fEy.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0553a.fqf.b(a.d.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0553a {
        private TextView fEz;
        private ALALevelView fqf;

        public C0553a(View view) {
            this.fqf = (ALALevelView) view.findViewById(a.g.ala_person_center_exp_level);
            this.fEz = (TextView) view.findViewById(a.g.ala_person_center_exp_level_range);
        }

        public void aG(int i, String str) {
            this.fqf.setupLevelIcon(i);
            this.fEz.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
