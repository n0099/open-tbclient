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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<b> hkR = new ArrayList<>();
    private AlaPersonCenterExpActivity hkS;
    private Context mContext;
    private int mSkinType;

    public a(AlaPersonCenterExpActivity alaPersonCenterExpActivity) {
        this.hkS = alaPersonCenterExpActivity;
        this.mContext = alaPersonCenterExpActivity.getPageContext().getPageActivity();
    }

    public void wn(int i) {
        this.mSkinType = i;
    }

    public void af(ArrayList<b> arrayList) {
        this.hkR.clear();
        this.hkR.addAll(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkR == null) {
            return 1;
        }
        return this.hkR.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (1 != getItemViewType(i) || (i - 1 < 0 && i - 1 >= this.hkR.size())) {
            return null;
        }
        return this.hkR.get(i - 1);
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
        this.hkS.getLayoutMode().onModeChanged(view);
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup) {
        C0666a c0666a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_center_exp_item, viewGroup, false);
            C0666a c0666a2 = new C0666a(view);
            view.setTag(c0666a2);
            c0666a = c0666a2;
        } else {
            c0666a = (C0666a) view.getTag();
        }
        b bVar = (b) getItem(i);
        if (bVar != null) {
            c0666a.aX(bVar.level, bVar.hkV);
        }
        this.hkS.getLayoutMode().onModeChanged(view);
        if (this.mSkinType == 1) {
            c0666a.gRv.b(a.c.sdk_cp_cont_g, 0.7f);
        }
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.live.personcenter.exp.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0666a {
        private ALALevelView gRv;
        private TextView hkT;

        public C0666a(View view) {
            this.gRv = (ALALevelView) view.findViewById(a.f.ala_person_center_exp_level);
            this.hkT = (TextView) view.findViewById(a.f.ala_person_center_exp_level_range);
        }

        public void aX(int i, String str) {
            this.gRv.setupLevelIcon(i);
            this.hkT.setText(str);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
