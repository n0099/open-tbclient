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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> cRE;
    private AlaGuardianListActivity eHA;
    private View.OnClickListener eHB = null;
    private View.OnClickListener erw = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.cRE = null;
        this.eHA = null;
        this.eHA = alaGuardianListActivity;
        this.cRE = new ArrayList<>();
    }

    public void n(View.OnClickListener onClickListener) {
        this.erw = onClickListener;
    }

    public void c(c cVar) {
        this.cRE.clear();
        this.cRE.addAll(cVar.bek());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRE == null) {
            return 0;
        }
        return this.cRE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE == null || i >= this.cRE.size()) {
            return null;
        }
        return this.cRE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eHA.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pl(i);
        this.eHA.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes2.dex */
    class a {
        ImageView eHC;
        TextView eHD;
        LinearLayout eHE;
        TextView eHF;
        ViewGroup erM;
        HeadImageView erP;
        TextView erQ;
        TextView mName;

        public a(View view) {
            this.eHC = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.eHD = (TextView) view.findViewById(a.g.tvGradeNum);
            this.erM = (ViewGroup) view.findViewById(a.g.item_view);
            this.erM.setOnClickListener(b.this.eHB);
            this.erP = (HeadImageView) view.findViewById(a.g.photo);
            this.erP.setRadius(BdUtilHelper.getDimens(b.this.eHA.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.erP.setAutoChangeStyle(true);
            this.erP.setClickable(false);
            this.eHE = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.erQ = (TextView) view.findViewById(a.g.ala_intro);
            this.eHF = (TextView) view.findViewById(a.g.attention_btn);
            this.eHF.setOnClickListener(b.this.erw);
        }

        public void pl(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.erM.setTag(Integer.valueOf(i));
                this.eHF.setTag(Integer.valueOf(i));
                oI(i);
                k.a(this.erP, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.erQ.setText(b.this.eHA.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.eHt));
                hU(aVar.followStatus != 0);
            }
        }

        private void hU(boolean z) {
            if (this.eHF != null) {
                this.eHF.setVisibility(8);
            } else if (z) {
                this.eHF.setText(b.this.eHA.getPageContext().getString(a.i.sdk_prc_guardian_list_attention));
                this.eHF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.eHF, a.d.sdk_cp_cont_d);
            } else {
                this.eHF.setText(b.this.eHA.getPageContext().getString(a.i.sdk_prc_guardian_list_not_attention));
                this.eHF.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_prc_live_attention_add_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.eHF, a.d.sdk_cp_other_b);
            }
        }

        public void oI(int i) {
            this.eHC.setVisibility(8);
            this.eHD.setVisibility(8);
            if (i == 0) {
                this.eHC.setVisibility(0);
                SkinManager.setImageResource(this.eHC, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.eHC.setVisibility(0);
                SkinManager.setImageResource(this.eHC, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.eHC.setVisibility(0);
                SkinManager.setImageResource(this.eHC, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.eHD.setVisibility(0);
                this.eHD.setText(String.valueOf(i + 1));
            }
        }
    }

    public void X(String str, boolean z) {
        if (this.cRE != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.cRE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.eHo)) {
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
