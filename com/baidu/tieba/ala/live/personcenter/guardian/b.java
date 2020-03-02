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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> cVR;
    private AlaGuardianListActivity eMF;
    private View.OnClickListener eMG = null;
    private View.OnClickListener ewS = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.cVR = null;
        this.eMF = null;
        this.eMF = alaGuardianListActivity;
        this.cVR = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.ewS = onClickListener;
    }

    public void c(c cVar) {
        this.cVR.clear();
        this.cVR.addAll(cVar.bgR());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVR == null) {
            return 0;
        }
        return this.cVR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null || i >= this.cVR.size()) {
            return null;
        }
        return this.cVR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eMF.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.py(i);
        this.eMF.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ImageView eMH;
        TextView eMI;
        LinearLayout eMJ;
        TextView eMK;
        ViewGroup exi;
        HeadImageView exl;
        TextView exm;
        TextView mName;

        public a(View view) {
            this.eMH = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.eMI = (TextView) view.findViewById(a.g.tvGradeNum);
            this.exi = (ViewGroup) view.findViewById(a.g.item_view);
            this.exi.setOnClickListener(b.this.eMG);
            this.exl = (HeadImageView) view.findViewById(a.g.photo);
            this.exl.setRadius(BdUtilHelper.getDimens(b.this.eMF.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.exl.setAutoChangeStyle(true);
            this.exl.setClickable(false);
            this.eMJ = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.exm = (TextView) view.findViewById(a.g.ala_intro);
            this.eMK = (TextView) view.findViewById(a.g.attention_btn);
            this.eMK.setOnClickListener(b.this.ewS);
        }

        public void py(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.exi.setTag(Integer.valueOf(i));
                this.eMK.setTag(Integer.valueOf(i));
                pa(i);
                k.a(this.exl, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.exm.setText(b.this.eMF.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.eMy));
                il(aVar.followStatus != 0);
            }
        }

        private void il(boolean z) {
            if (this.eMK != null) {
                this.eMK.setVisibility(8);
            }
        }

        public void pa(int i) {
            this.eMH.setVisibility(8);
            this.eMI.setVisibility(8);
            if (i == 0) {
                this.eMH.setVisibility(0);
                SkinManager.setImageResource(this.eMH, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.eMH.setVisibility(0);
                SkinManager.setImageResource(this.eMH, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.eMH.setVisibility(0);
                SkinManager.setImageResource(this.eMH, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.eMI.setVisibility(0);
                this.eMI.setText(String.valueOf(i + 1));
            }
        }
    }

    public void X(String str, boolean z) {
        if (this.cVR != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.cVR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.eMt)) {
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
