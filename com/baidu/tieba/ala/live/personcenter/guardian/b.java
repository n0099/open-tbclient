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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eHj;
    private AlaGuardianListActivity gRd;
    private View.OnClickListener gRe = null;
    private View.OnClickListener gwr = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eHj = null;
        this.gRd = null;
        this.gRd = alaGuardianListActivity;
        this.eHj = new ArrayList<>();
    }

    public void n(View.OnClickListener onClickListener) {
        this.gwr = onClickListener;
    }

    public void c(c cVar) {
        this.eHj.clear();
        this.eHj.addAll(cVar.bVb());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj == null || i >= this.eHj.size()) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.gRd.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.vx(i);
        this.gRd.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        TextView dFB;
        ImageView gRf;
        TextView gRg;
        LinearLayout gRh;
        ViewGroup gwK;
        HeadImageView gwN;
        TextView gwO;
        TextView mName;

        public a(View view) {
            this.gRf = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.gRg = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gwK = (ViewGroup) view.findViewById(a.f.item_view);
            this.gwK.setOnClickListener(b.this.gRe);
            this.gwN = (HeadImageView) view.findViewById(a.f.photo);
            this.gwN.setRadius(BdUtilHelper.getDimens(b.this.gRd.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gwN.setAutoChangeStyle(true);
            this.gwN.setClickable(false);
            this.gRh = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gwO = (TextView) view.findViewById(a.f.ala_intro);
            this.dFB = (TextView) view.findViewById(a.f.attention_btn);
            this.dFB.setOnClickListener(b.this.gwr);
        }

        public void vx(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gwK.setTag(Integer.valueOf(i));
                this.dFB.setTag(Integer.valueOf(i));
                uS(i);
                l.a(this.gwN, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gwO.setText(b.this.gRd.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.gQW));
                lZ(aVar.followStatus != 0);
            }
        }

        private void lZ(boolean z) {
            if (this.dFB != null) {
                this.dFB.setVisibility(8);
            }
        }

        public void uS(int i) {
            this.gRf.setVisibility(8);
            this.gRg.setVisibility(8);
            if (i == 0) {
                this.gRf.setVisibility(0);
                SkinManager.setImageResource(this.gRf, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.gRf.setVisibility(0);
                SkinManager.setImageResource(this.gRf, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.gRf.setVisibility(0);
                SkinManager.setImageResource(this.gRf, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.gRg.setVisibility(0);
                this.gRg.setText(String.valueOf(i + 1));
            }
        }
    }

    public void az(String str, boolean z) {
        if (this.eHj != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eHj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gQS)) {
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
