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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eiq;
    private AlaGuardianListActivity glD;
    private View.OnClickListener glE = null;
    private View.OnClickListener fUA = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eiq = null;
        this.glD = null;
        this.glD = alaGuardianListActivity;
        this.eiq = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fUA = onClickListener;
    }

    public void c(c cVar) {
        this.eiq.clear();
        this.eiq.addAll(cVar.bMV());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq == null) {
            return 0;
        }
        return this.eiq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq == null || i >= this.eiq.size()) {
            return null;
        }
        return this.eiq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.glD.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.tR(i);
        this.glD.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        TextView dgK;
        ViewGroup fUT;
        HeadImageView fUW;
        TextView fUX;
        ImageView glF;
        TextView glG;
        LinearLayout glH;
        TextView mName;

        public a(View view) {
            this.glF = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.glG = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fUT = (ViewGroup) view.findViewById(a.g.item_view);
            this.fUT.setOnClickListener(b.this.glE);
            this.fUW = (HeadImageView) view.findViewById(a.g.photo);
            this.fUW.setRadius(BdUtilHelper.getDimens(b.this.glD.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fUW.setAutoChangeStyle(true);
            this.fUW.setClickable(false);
            this.glH = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fUX = (TextView) view.findViewById(a.g.ala_intro);
            this.dgK = (TextView) view.findViewById(a.g.attention_btn);
            this.dgK.setOnClickListener(b.this.fUA);
        }

        public void tR(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fUT.setTag(Integer.valueOf(i));
                this.dgK.setTag(Integer.valueOf(i));
                tt(i);
                l.a(this.fUW, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fUX.setText(b.this.glD.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.glw));
                la(aVar.followStatus != 0);
            }
        }

        private void la(boolean z) {
            if (this.dgK != null) {
                this.dgK.setVisibility(8);
            }
        }

        public void tt(int i) {
            this.glF.setVisibility(8);
            this.glG.setVisibility(8);
            if (i == 0) {
                this.glF.setVisibility(0);
                SkinManager.setImageResource(this.glF, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.glF.setVisibility(0);
                SkinManager.setImageResource(this.glF, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.glF.setVisibility(0);
                SkinManager.setImageResource(this.glF, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.glG.setVisibility(0);
                this.glG.setText(String.valueOf(i + 1));
            }
        }
    }

    public void at(String str, boolean z) {
        if (this.eiq != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eiq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gls)) {
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
