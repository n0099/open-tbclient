package com.baidu.tieba.ala.live.personcenter.guardian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> efX;
    private AlaGuardianListActivity gis;
    private View.OnClickListener git = null;
    private View.OnClickListener fRl = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.efX = null;
        this.gis = null;
        this.gis = alaGuardianListActivity;
        this.efX = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fRl = onClickListener;
    }

    public void c(c cVar) {
        this.efX.clear();
        this.efX.addAll(cVar.bLK());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efX == null) {
            return 0;
        }
        return this.efX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efX == null || i >= this.efX.size()) {
            return null;
        }
        return this.efX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.gis.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ty(i);
        this.gis.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes7.dex */
    class a {
        TextView deG;
        ViewGroup fRE;
        HeadImageView fRH;
        TextView fRI;
        ImageView giu;
        TextView giv;
        LinearLayout giw;
        TextView mName;

        public a(View view) {
            this.giu = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.giv = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fRE = (ViewGroup) view.findViewById(a.g.item_view);
            this.fRE.setOnClickListener(b.this.git);
            this.fRH = (HeadImageView) view.findViewById(a.g.photo);
            this.fRH.setRadius(BdUtilHelper.getDimens(b.this.gis.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fRH.setAutoChangeStyle(true);
            this.fRH.setClickable(false);
            this.giw = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fRI = (TextView) view.findViewById(a.g.ala_intro);
            this.deG = (TextView) view.findViewById(a.g.attention_btn);
            this.deG.setOnClickListener(b.this.fRl);
        }

        public void ty(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fRE.setTag(Integer.valueOf(i));
                this.deG.setTag(Integer.valueOf(i));
                ta(i);
                k.a(this.fRH, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fRI.setText(b.this.gis.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.gil));
                kW(aVar.followStatus != 0);
            }
        }

        private void kW(boolean z) {
            if (this.deG != null) {
                this.deG.setVisibility(8);
            }
        }

        public void ta(int i) {
            this.giu.setVisibility(8);
            this.giv.setVisibility(8);
            if (i == 0) {
                this.giu.setVisibility(0);
                SkinManager.setImageResource(this.giu, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.giu.setVisibility(0);
                SkinManager.setImageResource(this.giu, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.giu.setVisibility(0);
                SkinManager.setImageResource(this.giu, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.giv.setVisibility(0);
                this.giv.setText(String.valueOf(i + 1));
            }
        }
    }

    public void at(String str, boolean z) {
        if (this.efX != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.efX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gig)) {
                    if (z) {
                        next.followStatus = 1;
                    } else {
                        next.followStatus = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }
}
