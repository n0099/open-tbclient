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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> cVQ;
    private AlaGuardianListActivity eME;
    private View.OnClickListener eMF = null;
    private View.OnClickListener ewR = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.cVQ = null;
        this.eME = null;
        this.eME = alaGuardianListActivity;
        this.cVQ = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.ewR = onClickListener;
    }

    public void c(c cVar) {
        this.cVQ.clear();
        this.cVQ.addAll(cVar.bgP());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVQ == null) {
            return 0;
        }
        return this.cVQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVQ == null || i >= this.cVQ.size()) {
            return null;
        }
        return this.cVQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eME.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.py(i);
        this.eME.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ImageView eMG;
        TextView eMH;
        LinearLayout eMI;
        TextView eMJ;
        ViewGroup exh;
        HeadImageView exk;
        TextView exl;
        TextView mName;

        public a(View view) {
            this.eMG = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.eMH = (TextView) view.findViewById(a.g.tvGradeNum);
            this.exh = (ViewGroup) view.findViewById(a.g.item_view);
            this.exh.setOnClickListener(b.this.eMF);
            this.exk = (HeadImageView) view.findViewById(a.g.photo);
            this.exk.setRadius(BdUtilHelper.getDimens(b.this.eME.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.exk.setAutoChangeStyle(true);
            this.exk.setClickable(false);
            this.eMI = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.exl = (TextView) view.findViewById(a.g.ala_intro);
            this.eMJ = (TextView) view.findViewById(a.g.attention_btn);
            this.eMJ.setOnClickListener(b.this.ewR);
        }

        public void py(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.exh.setTag(Integer.valueOf(i));
                this.eMJ.setTag(Integer.valueOf(i));
                pa(i);
                k.a(this.exk, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.exl.setText(b.this.eME.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.eMx));
                il(aVar.followStatus != 0);
            }
        }

        private void il(boolean z) {
            if (this.eMJ != null) {
                this.eMJ.setVisibility(8);
            }
        }

        public void pa(int i) {
            this.eMG.setVisibility(8);
            this.eMH.setVisibility(8);
            if (i == 0) {
                this.eMG.setVisibility(0);
                SkinManager.setImageResource(this.eMG, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.eMG.setVisibility(0);
                SkinManager.setImageResource(this.eMG, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.eMG.setVisibility(0);
                SkinManager.setImageResource(this.eMG, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.eMH.setVisibility(0);
                this.eMH.setText(String.valueOf(i + 1));
            }
        }
    }

    public void X(String str, boolean z) {
        if (this.cVQ != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.cVQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.eMs)) {
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
