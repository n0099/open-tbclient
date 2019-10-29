package com.baidu.tieba.ala.live.personcenter.exp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.view.ALALevelView;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private ArrayList<c> dRt = new ArrayList<>();
    private AlaPersonCenterExpActivity dRu;
    private Context mContext;
    private int mSkinType;

    public b(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.dRu = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void mV(int i) {
        this.mSkinType = i;
    }

    public void N(ArrayList<c> arrayList) {
        this.dRt.clear();
        this.dRt.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dRt == null) {
            return 1;
        }
        return this.dRt.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.dRt.size())) {
            return null;
        }
        return this.dRt.get(i - 1);
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
        this.dRu.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_item, viewGroup, false);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        c cVar = (c) getItem(i);
        if (cVar != null) {
            aVar.U(cVar.level, cVar.dRy);
        }
        this.dRu.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            aVar.dRv.d(a.d.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    public class a {
        private ALALevelView dRv;
        private TextView dRw;

        public a(View view) {
            this.dRv = (ALALevelView) view.findViewById(a.g.ala_person_center_exp_level);
            this.dRw = (TextView) view.findViewById(a.g.ala_person_center_exp_level_range);
        }

        public void U(int i, String str) {
            this.dRv.setupLevelIcon(i);
            this.dRw.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
