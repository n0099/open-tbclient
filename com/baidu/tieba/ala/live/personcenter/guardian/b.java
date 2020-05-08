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
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> dvu;
    private AlaGuardianListActivity frN;
    private View.OnClickListener frO = null;
    private View.OnClickListener fbL = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.dvu = null;
        this.frN = null;
        this.frN = alaGuardianListActivity;
        this.dvu = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fbL = onClickListener;
    }

    public void c(c cVar) {
        this.dvu.clear();
        this.dvu.addAll(cVar.bqm());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvu == null) {
            return 0;
        }
        return this.dvu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu == null || i >= this.dvu.size()) {
            return null;
        }
        return this.dvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.frN.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pU(i);
        this.frN.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ViewGroup fce;
        HeadImageView fch;
        TextView fci;
        ImageView frP;
        TextView frQ;
        LinearLayout frR;
        TextView frS;
        TextView mName;

        public a(View view) {
            this.frP = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.frQ = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fce = (ViewGroup) view.findViewById(a.g.item_view);
            this.fce.setOnClickListener(b.this.frO);
            this.fch = (HeadImageView) view.findViewById(a.g.photo);
            this.fch.setRadius(BdUtilHelper.getDimens(b.this.frN.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fch.setAutoChangeStyle(true);
            this.fch.setClickable(false);
            this.frR = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fci = (TextView) view.findViewById(a.g.ala_intro);
            this.frS = (TextView) view.findViewById(a.g.attention_btn);
            this.frS.setOnClickListener(b.this.fbL);
        }

        public void pU(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fce.setTag(Integer.valueOf(i));
                this.frS.setTag(Integer.valueOf(i));
                px(i);
                k.a(this.fch, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fci.setText(b.this.frN.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.frG));
                jo(aVar.followStatus != 0);
            }
        }

        private void jo(boolean z) {
            if (this.frS != null) {
                this.frS.setVisibility(8);
            }
        }

        public void px(int i) {
            this.frP.setVisibility(8);
            this.frQ.setVisibility(8);
            if (i == 0) {
                this.frP.setVisibility(0);
                SkinManager.setImageResource(this.frP, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.frP.setVisibility(0);
                SkinManager.setImageResource(this.frP, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.frP.setVisibility(0);
                SkinManager.setImageResource(this.frP, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.frQ.setVisibility(0);
                this.frQ.setText(String.valueOf(i + 1));
            }
        }
    }

    public void ac(String str, boolean z) {
        if (this.dvu != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.dvu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.frB)) {
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
