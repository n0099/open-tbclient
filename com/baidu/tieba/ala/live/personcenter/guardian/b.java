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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eXu;
    private AlaGuardianListActivity hnM;
    private View.OnClickListener hnN = null;
    private View.OnClickListener gQM = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eXu = null;
        this.hnM = null;
        this.hnM = alaGuardianListActivity;
        this.eXu = new ArrayList<>();
    }

    public void o(View.OnClickListener onClickListener) {
        this.gQM = onClickListener;
    }

    public void c(c cVar) {
        this.eXu.clear();
        this.eXu.addAll(cVar.bYM());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null || i >= this.eXu.size()) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.hnM.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uV(i);
        this.hnM.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes10.dex */
    class a {
        TextView dUn;
        ViewGroup gRf;
        HeadImageView gRi;
        TextView gRj;
        ImageView hnO;
        TextView hnP;
        LinearLayout hnQ;
        TextView mName;

        public a(View view) {
            this.hnO = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.hnP = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gRf = (ViewGroup) view.findViewById(a.f.item_view);
            this.gRf.setOnClickListener(b.this.hnN);
            this.gRi = (HeadImageView) view.findViewById(a.f.photo);
            this.gRi.setRadius(BdUtilHelper.getDimens(b.this.hnM.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gRi.setAutoChangeStyle(true);
            this.gRi.setClickable(false);
            this.hnQ = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gRj = (TextView) view.findViewById(a.f.ala_intro);
            this.dUn = (TextView) view.findViewById(a.f.attention_btn);
            this.dUn.setOnClickListener(b.this.gQM);
        }

        public void uV(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gRf.setTag(Integer.valueOf(i));
                this.dUn.setTag(Integer.valueOf(i));
                um(i);
                m.a(this.gRi, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gRj.setText(b.this.hnM.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.hnF));
                mU(aVar.followStatus != 0);
            }
        }

        private void mU(boolean z) {
            if (this.dUn != null) {
                this.dUn.setVisibility(8);
            }
        }

        public void um(int i) {
            this.hnO.setVisibility(8);
            this.hnP.setVisibility(8);
            if (i == 0) {
                this.hnO.setVisibility(0);
                SkinManager.setImageResource(this.hnO, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.hnO.setVisibility(0);
                SkinManager.setImageResource(this.hnO, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.hnO.setVisibility(0);
                SkinManager.setImageResource(this.hnO, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.hnP.setVisibility(0);
                this.hnP.setText(String.valueOf(i + 1));
            }
        }
    }

    public void aA(String str, boolean z) {
        if (this.eXu != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eXu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.hnB)) {
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
