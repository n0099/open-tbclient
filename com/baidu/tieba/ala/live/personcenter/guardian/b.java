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
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eYq;
    private AlaGuardianListActivity hmg;
    private View.OnClickListener hmh = null;
    private View.OnClickListener gQP = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eYq = null;
        this.hmg = null;
        this.hmg = alaGuardianListActivity;
        this.eYq = new ArrayList<>();
    }

    public void o(View.OnClickListener onClickListener) {
        this.gQP = onClickListener;
    }

    public void c(c cVar) {
        this.eYq.clear();
        this.eYq.addAll(cVar.cbr());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eYq == null) {
            return 0;
        }
        return this.eYq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq == null || i >= this.eYq.size()) {
            return null;
        }
        return this.eYq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.hmg.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.wp(i);
        this.hmg.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes11.dex */
    class a {
        TextView dVs;
        ViewGroup gRi;
        HeadImageView gRl;
        TextView gRm;
        ImageView hmi;
        TextView hmj;
        LinearLayout hmk;
        TextView mName;

        public a(View view) {
            this.hmi = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.hmj = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gRi = (ViewGroup) view.findViewById(a.f.item_view);
            this.gRi.setOnClickListener(b.this.hmh);
            this.gRl = (HeadImageView) view.findViewById(a.f.photo);
            this.gRl.setRadius(BdUtilHelper.getDimens(b.this.hmg.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gRl.setAutoChangeStyle(true);
            this.gRl.setClickable(false);
            this.hmk = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gRm = (TextView) view.findViewById(a.f.ala_intro);
            this.dVs = (TextView) view.findViewById(a.f.attention_btn);
            this.dVs.setOnClickListener(b.this.gQP);
        }

        public void wp(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gRi.setTag(Integer.valueOf(i));
                this.dVs.setTag(Integer.valueOf(i));
                vK(i);
                m.a(this.gRl, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gRm.setText(b.this.hmg.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.hlZ));
                mU(aVar.followStatus != 0);
            }
        }

        private void mU(boolean z) {
            if (this.dVs != null) {
                this.dVs.setVisibility(8);
            }
        }

        public void vK(int i) {
            this.hmi.setVisibility(8);
            this.hmj.setVisibility(8);
            if (i == 0) {
                this.hmi.setVisibility(0);
                SkinManager.setImageResource(this.hmi, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.hmi.setVisibility(0);
                SkinManager.setImageResource(this.hmi, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.hmi.setVisibility(0);
                SkinManager.setImageResource(this.hmi, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.hmj.setVisibility(0);
                this.hmj.setText(String.valueOf(i + 1));
            }
        }
    }

    public void aB(String str, boolean z) {
        if (this.eYq != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eYq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.hlV)) {
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
