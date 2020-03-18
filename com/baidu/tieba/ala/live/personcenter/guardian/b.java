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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> cWf;
    private AlaGuardianListActivity eNo;
    private View.OnClickListener eNp = null;
    private View.OnClickListener exC = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.cWf = null;
        this.eNo = null;
        this.eNo = alaGuardianListActivity;
        this.cWf = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.exC = onClickListener;
    }

    public void c(c cVar) {
        this.cWf.clear();
        this.cWf.addAll(cVar.bgX());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null || i >= this.cWf.size()) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eNo.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pA(i);
        this.eNo.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ImageView eNq;
        TextView eNr;
        LinearLayout eNs;
        TextView eNt;
        ViewGroup exS;
        HeadImageView exV;
        TextView exW;
        TextView mName;

        public a(View view) {
            this.eNq = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.eNr = (TextView) view.findViewById(a.g.tvGradeNum);
            this.exS = (ViewGroup) view.findViewById(a.g.item_view);
            this.exS.setOnClickListener(b.this.eNp);
            this.exV = (HeadImageView) view.findViewById(a.g.photo);
            this.exV.setRadius(BdUtilHelper.getDimens(b.this.eNo.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.exV.setAutoChangeStyle(true);
            this.exV.setClickable(false);
            this.eNs = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.exW = (TextView) view.findViewById(a.g.ala_intro);
            this.eNt = (TextView) view.findViewById(a.g.attention_btn);
            this.eNt.setOnClickListener(b.this.exC);
        }

        public void pA(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.exS.setTag(Integer.valueOf(i));
                this.eNt.setTag(Integer.valueOf(i));
                pc(i);
                k.a(this.exV, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.exW.setText(b.this.eNo.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.eNh));
                in(aVar.followStatus != 0);
            }
        }

        private void in(boolean z) {
            if (this.eNt != null) {
                this.eNt.setVisibility(8);
            }
        }

        public void pc(int i) {
            this.eNq.setVisibility(8);
            this.eNr.setVisibility(8);
            if (i == 0) {
                this.eNq.setVisibility(0);
                SkinManager.setImageResource(this.eNq, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.eNq.setVisibility(0);
                SkinManager.setImageResource(this.eNq, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.eNq.setVisibility(0);
                SkinManager.setImageResource(this.eNq, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.eNr.setVisibility(0);
                this.eNr.setText(String.valueOf(i + 1));
            }
        }
    }

    public void X(String str, boolean z) {
        if (this.cWf != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.cWf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.eNc)) {
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
