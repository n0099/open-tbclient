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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> dQf;
    private AlaGuardianListActivity fQZ;
    private View.OnClickListener fRa = null;
    private View.OnClickListener fAK = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.dQf = null;
        this.fQZ = null;
        this.fQZ = alaGuardianListActivity;
        this.dQf = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fAK = onClickListener;
    }

    public void c(c cVar) {
        this.dQf.clear();
        this.dQf.addAll(cVar.bzc());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf == null) {
            return 0;
        }
        return this.dQf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf == null || i >= this.dQf.size()) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.fQZ.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.qW(i);
        this.fQZ.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ViewGroup fBd;
        HeadImageView fBg;
        TextView fBh;
        ImageView fRb;
        TextView fRc;
        LinearLayout fRd;
        TextView fRe;
        TextView mName;

        public a(View view) {
            this.fRb = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.fRc = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fBd = (ViewGroup) view.findViewById(a.g.item_view);
            this.fBd.setOnClickListener(b.this.fRa);
            this.fBg = (HeadImageView) view.findViewById(a.g.photo);
            this.fBg.setRadius(BdUtilHelper.getDimens(b.this.fQZ.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fBg.setAutoChangeStyle(true);
            this.fBg.setClickable(false);
            this.fRd = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fBh = (TextView) view.findViewById(a.g.ala_intro);
            this.fRe = (TextView) view.findViewById(a.g.attention_btn);
            this.fRe.setOnClickListener(b.this.fAK);
        }

        public void qW(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fBd.setTag(Integer.valueOf(i));
                this.fRe.setTag(Integer.valueOf(i));
                qz(i);
                k.a(this.fBg, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fBh.setText(b.this.fQZ.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.fQS));
                jU(aVar.followStatus != 0);
            }
        }

        private void jU(boolean z) {
            if (this.fRe != null) {
                this.fRe.setVisibility(8);
            }
        }

        public void qz(int i) {
            this.fRb.setVisibility(8);
            this.fRc.setVisibility(8);
            if (i == 0) {
                this.fRb.setVisibility(0);
                SkinManager.setImageResource(this.fRb, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.fRb.setVisibility(0);
                SkinManager.setImageResource(this.fRb, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.fRb.setVisibility(0);
                SkinManager.setImageResource(this.fRb, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.fRc.setVisibility(0);
                this.fRc.setText(String.valueOf(i + 1));
            }
        }
    }

    public void ar(String str, boolean z) {
        if (this.dQf != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.dQf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.fQN)) {
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
