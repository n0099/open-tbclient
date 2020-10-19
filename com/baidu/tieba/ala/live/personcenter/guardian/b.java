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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> euy;
    private AlaGuardianListActivity gzW;
    private View.OnClickListener gzX = null;
    private View.OnClickListener ggT = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.euy = null;
        this.gzW = null;
        this.gzW = alaGuardianListActivity;
        this.euy = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.ggT = onClickListener;
    }

    public void c(c cVar) {
        this.euy.clear();
        this.euy.addAll(cVar.bQm());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.euy == null) {
            return 0;
        }
        return this.euy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null || i >= this.euy.size()) {
            return null;
        }
        return this.euy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.gzW.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uw(i);
        this.gzW.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        TextView dsS;
        LinearLayout gAa;
        ViewGroup ghm;
        HeadImageView ghp;
        TextView ghq;
        ImageView gzY;
        TextView gzZ;
        TextView mName;

        public a(View view) {
            this.gzY = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.gzZ = (TextView) view.findViewById(a.g.tvGradeNum);
            this.ghm = (ViewGroup) view.findViewById(a.g.item_view);
            this.ghm.setOnClickListener(b.this.gzX);
            this.ghp = (HeadImageView) view.findViewById(a.g.photo);
            this.ghp.setRadius(BdUtilHelper.getDimens(b.this.gzW.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.ghp.setAutoChangeStyle(true);
            this.ghp.setClickable(false);
            this.gAa = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.ghq = (TextView) view.findViewById(a.g.ala_intro);
            this.dsS = (TextView) view.findViewById(a.g.attention_btn);
            this.dsS.setOnClickListener(b.this.ggT);
        }

        public void uw(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.ghm.setTag(Integer.valueOf(i));
                this.dsS.setTag(Integer.valueOf(i));
                tR(i);
                l.a(this.ghp, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.ghq.setText(b.this.gzW.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.gzP));
                ly(aVar.followStatus != 0);
            }
        }

        private void ly(boolean z) {
            if (this.dsS != null) {
                this.dsS.setVisibility(8);
            }
        }

        public void tR(int i) {
            this.gzY.setVisibility(8);
            this.gzZ.setVisibility(8);
            if (i == 0) {
                this.gzY.setVisibility(0);
                SkinManager.setImageResource(this.gzY, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.gzY.setVisibility(0);
                SkinManager.setImageResource(this.gzY, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.gzY.setVisibility(0);
                SkinManager.setImageResource(this.gzY, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.gzZ.setVisibility(0);
                this.gzZ.setText(String.valueOf(i + 1));
            }
        }
    }

    public void ax(String str, boolean z) {
        if (this.euy != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.euy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gzL)) {
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
