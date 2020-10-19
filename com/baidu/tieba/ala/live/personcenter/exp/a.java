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
    private ArrayList<b> gyG = new ArrayList<>();
    private AlaPersonCenterExpActivity gyH;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.gyH = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void uu(int i) {
        this.mSkinType = i;
    }

    public void ad(ArrayList<b> arrayList) {
        this.gyG.clear();
        this.gyG.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyG == null) {
            return 1;
        }
        return this.gyG.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.gyG.size())) {
            return null;
        }
        return this.gyG.get(i - 1);
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
        this.gyH.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0633a c0633a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_center_exp_item, viewGroup, false);
            C0633a c0633a2 = new C0633a(view);
            view.setTag(c0633a2);
            c0633a = c0633a2;
        } else {
            c0633a = (C0633a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0633a.aS(bVar.level, bVar.gyK);
        }
        this.gyH.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0633a.ghz.b(a.d.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0633a {
        private ALALevelView ghz;
        private TextView gyI;

        public C0633a(View view) {
            this.ghz = (ALALevelView) view.findViewById(a.g.ala_person_center_exp_level);
            this.gyI = (TextView) view.findViewById(a.g.ala_person_center_exp_level_range);
        }

        public void aS(int i, String str) {
            this.ghz.setupLevelIcon(i);
            this.gyI.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
