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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> cVS;
    private AlaGuardianListActivity eMS;
    private View.OnClickListener eMT = null;
    private View.OnClickListener exf = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.cVS = null;
        this.eMS = null;
        this.eMS = alaGuardianListActivity;
        this.cVS = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.exf = onClickListener;
    }

    public void c(c cVar) {
        this.cVS.clear();
        this.cVS.addAll(cVar.bgS());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVS == null) {
            return 0;
        }
        return this.cVS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS == null || i >= this.cVS.size()) {
            return null;
        }
        return this.cVS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eMS.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.py(i);
        this.eMS.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ImageView eMU;
        TextView eMV;
        LinearLayout eMW;
        TextView eMX;
        TextView exA;
        ViewGroup exw;
        HeadImageView exz;
        TextView mName;

        public a(View view) {
            this.eMU = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.eMV = (TextView) view.findViewById(a.g.tvGradeNum);
            this.exw = (ViewGroup) view.findViewById(a.g.item_view);
            this.exw.setOnClickListener(b.this.eMT);
            this.exz = (HeadImageView) view.findViewById(a.g.photo);
            this.exz.setRadius(BdUtilHelper.getDimens(b.this.eMS.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.exz.setAutoChangeStyle(true);
            this.exz.setClickable(false);
            this.eMW = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.exA = (TextView) view.findViewById(a.g.ala_intro);
            this.eMX = (TextView) view.findViewById(a.g.attention_btn);
            this.eMX.setOnClickListener(b.this.exf);
        }

        public void py(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.exw.setTag(Integer.valueOf(i));
                this.eMX.setTag(Integer.valueOf(i));
                pa(i);
                k.a(this.exz, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.exA.setText(b.this.eMS.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.eML));
                il(aVar.followStatus != 0);
            }
        }

        private void il(boolean z) {
            if (this.eMX != null) {
                this.eMX.setVisibility(8);
            }
        }

        public void pa(int i) {
            this.eMU.setVisibility(8);
            this.eMV.setVisibility(8);
            if (i == 0) {
                this.eMU.setVisibility(0);
                SkinManager.setImageResource(this.eMU, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.eMU.setVisibility(0);
                SkinManager.setImageResource(this.eMU, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.eMU.setVisibility(0);
                SkinManager.setImageResource(this.eMU, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.eMV.setVisibility(0);
                this.eMV.setText(String.valueOf(i + 1));
            }
        }
    }

    public void X(String str, boolean z) {
        if (this.cVS != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.cVS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.eMG)) {
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
