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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eCX;
    private AlaGuardianListActivity gLK;
    private View.OnClickListener gLL = null;
    private View.OnClickListener gqW = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eCX = null;
        this.gLK = null;
        this.gLK = alaGuardianListActivity;
        this.eCX = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.gqW = onClickListener;
    }

    public void c(c cVar) {
        this.eCX.clear();
        this.eCX.addAll(cVar.bTj());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCX == null) {
            return 0;
        }
        return this.eCX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX == null || i >= this.eCX.size()) {
            return null;
        }
        return this.eCX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.gLK.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uP(i);
        this.gLK.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        TextView dBq;
        ImageView gLM;
        TextView gLN;
        LinearLayout gLO;
        ViewGroup grp;
        HeadImageView grs;
        TextView grt;
        TextView mName;

        public a(View view) {
            this.gLM = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.gLN = (TextView) view.findViewById(a.g.tvGradeNum);
            this.grp = (ViewGroup) view.findViewById(a.g.item_view);
            this.grp.setOnClickListener(b.this.gLL);
            this.grs = (HeadImageView) view.findViewById(a.g.photo);
            this.grs.setRadius(BdUtilHelper.getDimens(b.this.gLK.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.grs.setAutoChangeStyle(true);
            this.grs.setClickable(false);
            this.gLO = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.grt = (TextView) view.findViewById(a.g.ala_intro);
            this.dBq = (TextView) view.findViewById(a.g.attention_btn);
            this.dBq.setOnClickListener(b.this.gqW);
        }

        public void uP(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.grp.setTag(Integer.valueOf(i));
                this.dBq.setTag(Integer.valueOf(i));
                uk(i);
                l.a(this.grs, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.grt.setText(b.this.gLK.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.gLD));
                lP(aVar.followStatus != 0);
            }
        }

        private void lP(boolean z) {
            if (this.dBq != null) {
                this.dBq.setVisibility(8);
            }
        }

        public void uk(int i) {
            this.gLM.setVisibility(8);
            this.gLN.setVisibility(8);
            if (i == 0) {
                this.gLM.setVisibility(0);
                SkinManager.setImageResource(this.gLM, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.gLM.setVisibility(0);
                SkinManager.setImageResource(this.gLM, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.gLM.setVisibility(0);
                SkinManager.setImageResource(this.gLM, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.gLN.setVisibility(0);
                this.gLN.setText(String.valueOf(i + 1));
            }
        }
    }

    public void az(String str, boolean z) {
        if (this.eCX != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eCX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gLz)) {
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
