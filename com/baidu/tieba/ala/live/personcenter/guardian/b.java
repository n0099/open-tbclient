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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> dJp;
    private AlaGuardianListActivity fFF;
    private View.OnClickListener fFG = null;
    private View.OnClickListener fpn = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.dJp = null;
        this.fFF = null;
        this.fFF = alaGuardianListActivity;
        this.dJp = new ArrayList<>();
    }

    public void l(View.OnClickListener onClickListener) {
        this.fpn = onClickListener;
    }

    public void c(c cVar) {
        this.dJp.clear();
        this.dJp.addAll(cVar.bwe());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dJp == null) {
            return 0;
        }
        return this.dJp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp == null || i >= this.dJp.size()) {
            return null;
        }
        return this.dJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.fFF.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.qv(i);
        this.fFF.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ImageView fFH;
        TextView fFI;
        LinearLayout fFJ;
        TextView fFK;
        ViewGroup fpH;
        HeadImageView fpK;
        TextView fpL;
        TextView mName;

        public a(View view) {
            this.fFH = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.fFI = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fpH = (ViewGroup) view.findViewById(a.g.item_view);
            this.fpH.setOnClickListener(b.this.fFG);
            this.fpK = (HeadImageView) view.findViewById(a.g.photo);
            this.fpK.setRadius(BdUtilHelper.getDimens(b.this.fFF.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fpK.setAutoChangeStyle(true);
            this.fpK.setClickable(false);
            this.fFJ = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fpL = (TextView) view.findViewById(a.g.ala_intro);
            this.fFK = (TextView) view.findViewById(a.g.attention_btn);
            this.fFK.setOnClickListener(b.this.fpn);
        }

        public void qv(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fpH.setTag(Integer.valueOf(i));
                this.fFK.setTag(Integer.valueOf(i));
                pY(i);
                k.a(this.fpK, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fpL.setText(b.this.fFF.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.fFy));
                jH(aVar.followStatus != 0);
            }
        }

        private void jH(boolean z) {
            if (this.fFK != null) {
                this.fFK.setVisibility(8);
            }
        }

        public void pY(int i) {
            this.fFH.setVisibility(8);
            this.fFI.setVisibility(8);
            if (i == 0) {
                this.fFH.setVisibility(0);
                SkinManager.setImageResource(this.fFH, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.fFH.setVisibility(0);
                SkinManager.setImageResource(this.fFH, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.fFH.setVisibility(0);
                SkinManager.setImageResource(this.fFH, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.fFI.setVisibility(0);
                this.fFI.setText(String.valueOf(i + 1));
            }
        }
    }

    public void ap(String str, boolean z) {
        if (this.dJp != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.dJp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.fFt)) {
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
