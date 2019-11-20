package com.baidu.tieba.ala.live.personcenter.guardian;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> bbH;
    private AlaGuardianListActivity dRT;
    private View.OnClickListener dRU = null;
    private View.OnClickListener dFs = null;

    public c(AlaGuardianListActivity alaGuardianListActivity) {
        this.bbH = null;
        this.dRT = null;
        this.dRT = alaGuardianListActivity;
        this.bbH = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.dFs = onClickListener;
    }

    public void c(d dVar) {
        this.bbH.clear();
        this.bbH.addAll(dVar.aMF());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null || i >= this.bbH.size()) {
            return null;
        }
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.dRT.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mV(i);
        this.dRT.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    class a {
        ViewGroup dFJ;
        HeadImageView dFM;
        TextView dFN;
        ImageView dRV;
        TextView dRW;
        LinearLayout dRX;
        TextView dRY;
        TextView mName;

        public a(View view) {
            this.dRV = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.dRW = (TextView) view.findViewById(a.g.tvGradeNum);
            this.dFJ = (ViewGroup) view.findViewById(a.g.item_view);
            this.dFJ.setOnClickListener(c.this.dRU);
            this.dFM = (HeadImageView) view.findViewById(a.g.photo);
            this.dFM.setRadius(BdUtilHelper.getDimens(c.this.dRT.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.dFM.setAutoChangeStyle(true);
            this.dFM.setClickable(false);
            this.dRX = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.dFN = (TextView) view.findViewById(a.g.ala_intro);
            this.dRY = (TextView) view.findViewById(a.g.attention_btn);
            this.dRY.setOnClickListener(c.this.dFs);
        }

        public void mV(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) c.this.getItem(i);
            if (aVar != null) {
                this.dFJ.setTag(Integer.valueOf(i));
                this.dRY.setTag(Integer.valueOf(i));
                mx(i);
                j.a(this.dFM, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.dFN.setText(c.this.dRT.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.dRM));
                gP(aVar.followStatus != 0);
            }
        }

        private void gP(boolean z) {
            if (this.dRY != null) {
                this.dRY.setVisibility(8);
            } else if (z) {
                this.dRY.setText(c.this.dRT.getPageContext().getString(a.i.sdk_prc_guardian_list_attention));
                this.dRY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.dRY, a.d.sdk_cp_cont_d);
            } else {
                this.dRY.setText(c.this.dRT.getPageContext().getString(a.i.sdk_prc_guardian_list_not_attention));
                this.dRY.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_prc_live_attention_add_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.dRY, a.d.sdk_cp_other_b);
            }
        }

        public void mx(int i) {
            this.dRV.setVisibility(8);
            this.dRW.setVisibility(8);
            if (i == 0) {
                this.dRV.setVisibility(0);
                SkinManager.setImageResource(this.dRV, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.dRV.setVisibility(0);
                SkinManager.setImageResource(this.dRV, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.dRV.setVisibility(0);
                SkinManager.setImageResource(this.dRV, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.dRW.setVisibility(0);
                this.dRW.setText(String.valueOf(i + 1));
            }
        }
    }

    public void T(String str, boolean z) {
        if (this.bbH != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.bbH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.dRH)) {
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
