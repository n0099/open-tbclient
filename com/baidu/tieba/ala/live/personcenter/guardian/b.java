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
import com.baidu.live.utils.m;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eVV;
    private AlaGuardianListActivity hlP;
    private View.OnClickListener hlQ = null;
    private View.OnClickListener gOP = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eVV = null;
        this.hlP = null;
        this.hlP = alaGuardianListActivity;
        this.eVV = new ArrayList<>();
    }

    public void o(View.OnClickListener onClickListener) {
        this.gOP = onClickListener;
    }

    public void c(c cVar) {
        this.eVV.clear();
        this.eVV.addAll(cVar.bYz());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null || i >= this.eVV.size()) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.hlP.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uT(i);
        this.hlP.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes11.dex */
    class a {
        TextView dSM;
        ViewGroup gPi;
        HeadImageView gPl;
        TextView gPm;
        ImageView hlR;
        TextView hlS;
        LinearLayout hlT;
        TextView mName;

        public a(View view) {
            this.hlR = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.hlS = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gPi = (ViewGroup) view.findViewById(a.f.item_view);
            this.gPi.setOnClickListener(b.this.hlQ);
            this.gPl = (HeadImageView) view.findViewById(a.f.photo);
            this.gPl.setRadius(BdUtilHelper.getDimens(b.this.hlP.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gPl.setAutoChangeStyle(true);
            this.gPl.setClickable(false);
            this.hlT = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gPm = (TextView) view.findViewById(a.f.ala_intro);
            this.dSM = (TextView) view.findViewById(a.f.attention_btn);
            this.dSM.setOnClickListener(b.this.gOP);
        }

        public void uT(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gPi.setTag(Integer.valueOf(i));
                this.dSM.setTag(Integer.valueOf(i));
                uk(i);
                m.a(this.gPl, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gPm.setText(b.this.hlP.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.hlI));
                mU(aVar.followStatus != 0);
            }
        }

        private void mU(boolean z) {
            if (this.dSM != null) {
                this.dSM.setVisibility(8);
            }
        }

        public void uk(int i) {
            this.hlR.setVisibility(8);
            this.hlS.setVisibility(8);
            if (i == 0) {
                this.hlR.setVisibility(0);
                SkinManager.setImageResource(this.hlR, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.hlR.setVisibility(0);
                SkinManager.setImageResource(this.hlR, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.hlR.setVisibility(0);
                SkinManager.setImageResource(this.hlR, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.hlS.setVisibility(0);
                this.hlS.setText(String.valueOf(i + 1));
            }
        }
    }

    public void aA(String str, boolean z) {
        if (this.eVV != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eVV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.hlE)) {
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
