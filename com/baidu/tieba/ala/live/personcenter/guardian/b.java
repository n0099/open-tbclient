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
    private AlaGuardianListActivity hmd;
    private View.OnClickListener hme = null;
    private View.OnClickListener gPd = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eVV = null;
        this.hmd = null;
        this.hmd = alaGuardianListActivity;
        this.eVV = new ArrayList<>();
    }

    public void o(View.OnClickListener onClickListener) {
        this.gPd = onClickListener;
    }

    public void c(c cVar) {
        this.eVV.clear();
        this.eVV.addAll(cVar.bYG());
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
            view = LayoutInflater.from(this.hmd.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uT(i);
        this.hmd.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes11.dex */
    class a {
        TextView dSM;
        TextView gPA;
        ViewGroup gPw;
        HeadImageView gPz;
        ImageView hmf;
        TextView hmg;
        LinearLayout hmh;
        TextView mName;

        public a(View view) {
            this.hmf = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.hmg = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gPw = (ViewGroup) view.findViewById(a.f.item_view);
            this.gPw.setOnClickListener(b.this.hme);
            this.gPz = (HeadImageView) view.findViewById(a.f.photo);
            this.gPz.setRadius(BdUtilHelper.getDimens(b.this.hmd.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gPz.setAutoChangeStyle(true);
            this.gPz.setClickable(false);
            this.hmh = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gPA = (TextView) view.findViewById(a.f.ala_intro);
            this.dSM = (TextView) view.findViewById(a.f.attention_btn);
            this.dSM.setOnClickListener(b.this.gPd);
        }

        public void uT(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gPw.setTag(Integer.valueOf(i));
                this.dSM.setTag(Integer.valueOf(i));
                uk(i);
                m.a(this.gPz, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gPA.setText(b.this.hmd.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.hlW));
                mU(aVar.followStatus != 0);
            }
        }

        private void mU(boolean z) {
            if (this.dSM != null) {
                this.dSM.setVisibility(8);
            }
        }

        public void uk(int i) {
            this.hmf.setVisibility(8);
            this.hmg.setVisibility(8);
            if (i == 0) {
                this.hmf.setVisibility(0);
                SkinManager.setImageResource(this.hmf, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.hmf.setVisibility(0);
                SkinManager.setImageResource(this.hmf, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.hmf.setVisibility(0);
                SkinManager.setImageResource(this.hmf, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.hmg.setVisibility(0);
                this.hmg.setText(String.valueOf(i + 1));
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
                if (str.equals(next.hlS)) {
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
