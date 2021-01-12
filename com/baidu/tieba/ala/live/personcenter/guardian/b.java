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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eTF;
    private AlaGuardianListActivity hhz;
    private View.OnClickListener hhA = null;
    private View.OnClickListener gMj = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eTF = null;
        this.hhz = null;
        this.hhz = alaGuardianListActivity;
        this.eTF = new ArrayList<>();
    }

    public void o(View.OnClickListener onClickListener) {
        this.gMj = onClickListener;
    }

    public void c(c cVar) {
        this.eTF.clear();
        this.eTF.addAll(cVar.bXz());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF == null || i >= this.eTF.size()) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.hhz.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uJ(i);
        this.hhz.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes10.dex */
    class a {
        TextView dQG;
        ViewGroup gMC;
        HeadImageView gMF;
        TextView gMG;
        ImageView hhB;
        TextView hhC;
        LinearLayout hhD;
        TextView mName;

        public a(View view) {
            this.hhB = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.hhC = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gMC = (ViewGroup) view.findViewById(a.f.item_view);
            this.gMC.setOnClickListener(b.this.hhA);
            this.gMF = (HeadImageView) view.findViewById(a.f.photo);
            this.gMF.setRadius(BdUtilHelper.getDimens(b.this.hhz.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gMF.setAutoChangeStyle(true);
            this.gMF.setClickable(false);
            this.hhD = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gMG = (TextView) view.findViewById(a.f.ala_intro);
            this.dQG = (TextView) view.findViewById(a.f.attention_btn);
            this.dQG.setOnClickListener(b.this.gMj);
        }

        public void uJ(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gMC.setTag(Integer.valueOf(i));
                this.dQG.setTag(Integer.valueOf(i));
                ue(i);
                m.a(this.gMF, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gMG.setText(b.this.hhz.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.hhs));
                mQ(aVar.followStatus != 0);
            }
        }

        private void mQ(boolean z) {
            if (this.dQG != null) {
                this.dQG.setVisibility(8);
            }
        }

        public void ue(int i) {
            this.hhB.setVisibility(8);
            this.hhC.setVisibility(8);
            if (i == 0) {
                this.hhB.setVisibility(0);
                SkinManager.setImageResource(this.hhB, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.hhB.setVisibility(0);
                SkinManager.setImageResource(this.hhB, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.hhB.setVisibility(0);
                SkinManager.setImageResource(this.hhB, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.hhC.setVisibility(0);
                this.hhC.setText(String.valueOf(i + 1));
            }
        }
    }

    public void aB(String str, boolean z) {
        if (this.eTF != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eTF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.hho)) {
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
