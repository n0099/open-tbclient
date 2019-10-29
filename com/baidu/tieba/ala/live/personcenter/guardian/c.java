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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> bbZ;
    private AlaGuardianListActivity dSK;
    private View.OnClickListener dSL = null;
    private View.OnClickListener dGj = null;

    public c(AlaGuardianListActivity alaGuardianListActivity) {
        this.bbZ = null;
        this.dSK = null;
        this.dSK = alaGuardianListActivity;
        this.bbZ = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.dGj = onClickListener;
    }

    public void c(d dVar) {
        this.bbZ.clear();
        this.bbZ.addAll(dVar.aMH());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null || i >= this.bbZ.size()) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.dSK.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mW(i);
        this.dSK.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    class a {
        ViewGroup dGA;
        HeadImageView dGD;
        TextView dGE;
        ImageView dSM;
        TextView dSN;
        LinearLayout dSO;
        TextView dSP;
        TextView mName;

        public a(View view) {
            this.dSM = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.dSN = (TextView) view.findViewById(a.g.tvGradeNum);
            this.dGA = (ViewGroup) view.findViewById(a.g.item_view);
            this.dGA.setOnClickListener(c.this.dSL);
            this.dGD = (HeadImageView) view.findViewById(a.g.photo);
            this.dGD.setRadius(BdUtilHelper.getDimens(c.this.dSK.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.dGD.setAutoChangeStyle(true);
            this.dGD.setClickable(false);
            this.dSO = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.dGE = (TextView) view.findViewById(a.g.ala_intro);
            this.dSP = (TextView) view.findViewById(a.g.attention_btn);
            this.dSP.setOnClickListener(c.this.dGj);
        }

        public void mW(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) c.this.getItem(i);
            if (aVar != null) {
                this.dGA.setTag(Integer.valueOf(i));
                this.dSP.setTag(Integer.valueOf(i));
                my(i);
                j.a(this.dGD, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.dGE.setText(c.this.dSK.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.dSD));
                gP(aVar.followStatus != 0);
            }
        }

        private void gP(boolean z) {
            if (this.dSP != null) {
                this.dSP.setVisibility(8);
            } else if (z) {
                this.dSP.setText(c.this.dSK.getPageContext().getString(a.i.sdk_prc_guardian_list_attention));
                this.dSP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.dSP, a.d.sdk_cp_cont_d);
            } else {
                this.dSP.setText(c.this.dSK.getPageContext().getString(a.i.sdk_prc_guardian_list_not_attention));
                this.dSP.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_prc_live_attention_add_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.dSP, a.d.sdk_cp_other_b);
            }
        }

        public void my(int i) {
            this.dSM.setVisibility(8);
            this.dSN.setVisibility(8);
            if (i == 0) {
                this.dSM.setVisibility(0);
                SkinManager.setImageResource(this.dSM, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.dSM.setVisibility(0);
                SkinManager.setImageResource(this.dSM, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.dSM.setVisibility(0);
                SkinManager.setImageResource(this.dSM, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.dSN.setVisibility(0);
                this.dSN.setText(String.valueOf(i + 1));
            }
        }
    }

    public void T(String str, boolean z) {
        if (this.bbZ != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.bbZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.dSy)) {
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
