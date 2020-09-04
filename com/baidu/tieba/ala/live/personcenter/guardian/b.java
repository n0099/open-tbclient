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
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> egb;
    private AlaGuardianListActivity giw;
    private View.OnClickListener gix = null;
    private View.OnClickListener fRp = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.egb = null;
        this.giw = null;
        this.giw = alaGuardianListActivity;
        this.egb = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fRp = onClickListener;
    }

    public void c(c cVar) {
        this.egb.clear();
        this.egb.addAll(cVar.bLL());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egb == null) {
            return 0;
        }
        return this.egb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb == null || i >= this.egb.size()) {
            return null;
        }
        return this.egb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.giw.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ty(i);
        this.giw.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes7.dex */
    class a {
        TextView deK;
        ViewGroup fRI;
        HeadImageView fRL;
        TextView fRM;
        LinearLayout giA;
        ImageView giy;
        TextView giz;
        TextView mName;

        public a(View view) {
            this.giy = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.giz = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fRI = (ViewGroup) view.findViewById(a.g.item_view);
            this.fRI.setOnClickListener(b.this.gix);
            this.fRL = (HeadImageView) view.findViewById(a.g.photo);
            this.fRL.setRadius(BdUtilHelper.getDimens(b.this.giw.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fRL.setAutoChangeStyle(true);
            this.fRL.setClickable(false);
            this.giA = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fRM = (TextView) view.findViewById(a.g.ala_intro);
            this.deK = (TextView) view.findViewById(a.g.attention_btn);
            this.deK.setOnClickListener(b.this.fRp);
        }

        public void ty(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fRI.setTag(Integer.valueOf(i));
                this.deK.setTag(Integer.valueOf(i));
                ta(i);
                k.a(this.fRL, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fRM.setText(b.this.giw.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.gip));
                kY(aVar.followStatus != 0);
            }
        }

        private void kY(boolean z) {
            if (this.deK != null) {
                this.deK.setVisibility(8);
            }
        }

        public void ta(int i) {
            this.giy.setVisibility(8);
            this.giz.setVisibility(8);
            if (i == 0) {
                this.giy.setVisibility(0);
                SkinManager.setImageResource(this.giy, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.giy.setVisibility(0);
                SkinManager.setImageResource(this.giy, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.giy.setVisibility(0);
                SkinManager.setImageResource(this.giy, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.giz.setVisibility(0);
                this.giz.setText(String.valueOf(i + 1));
            }
        }
    }

    public void at(String str, boolean z) {
        if (this.egb != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.egb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gik)) {
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
