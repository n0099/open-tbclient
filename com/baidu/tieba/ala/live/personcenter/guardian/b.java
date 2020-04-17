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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> dvq;
    private AlaGuardianListActivity frI;
    private View.OnClickListener frJ = null;
    private View.OnClickListener fbG = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.dvq = null;
        this.frI = null;
        this.frI = alaGuardianListActivity;
        this.dvq = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fbG = onClickListener;
    }

    public void c(c cVar) {
        this.dvq.clear();
        this.dvq.addAll(cVar.bqo());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvq == null) {
            return 0;
        }
        return this.dvq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq == null || i >= this.dvq.size()) {
            return null;
        }
        return this.dvq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.frI.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pU(i);
        this.frI.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ViewGroup fbZ;
        HeadImageView fcc;
        TextView fcd;
        ImageView frK;
        TextView frL;
        LinearLayout frM;
        TextView frN;
        TextView mName;

        public a(View view) {
            this.frK = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.frL = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fbZ = (ViewGroup) view.findViewById(a.g.item_view);
            this.fbZ.setOnClickListener(b.this.frJ);
            this.fcc = (HeadImageView) view.findViewById(a.g.photo);
            this.fcc.setRadius(BdUtilHelper.getDimens(b.this.frI.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fcc.setAutoChangeStyle(true);
            this.fcc.setClickable(false);
            this.frM = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fcd = (TextView) view.findViewById(a.g.ala_intro);
            this.frN = (TextView) view.findViewById(a.g.attention_btn);
            this.frN.setOnClickListener(b.this.fbG);
        }

        public void pU(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fbZ.setTag(Integer.valueOf(i));
                this.frN.setTag(Integer.valueOf(i));
                px(i);
                k.a(this.fcc, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fcd.setText(b.this.frI.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.frB));
                jo(aVar.followStatus != 0);
            }
        }

        private void jo(boolean z) {
            if (this.frN != null) {
                this.frN.setVisibility(8);
            }
        }

        public void px(int i) {
            this.frK.setVisibility(8);
            this.frL.setVisibility(8);
            if (i == 0) {
                this.frK.setVisibility(0);
                SkinManager.setImageResource(this.frK, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.frK.setVisibility(0);
                SkinManager.setImageResource(this.frK, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.frK.setVisibility(0);
                SkinManager.setImageResource(this.frK, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.frL.setVisibility(0);
                this.frL.setText(String.valueOf(i + 1));
            }
        }
    }

    public void ac(String str, boolean z) {
        if (this.dvq != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.dvq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.frw)) {
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
