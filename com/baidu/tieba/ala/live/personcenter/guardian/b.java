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
    private AlaGuardianListActivity fFQ;
    private View.OnClickListener fFR = null;
    private View.OnClickListener fpz = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.dJp = null;
        this.fFQ = null;
        this.fFQ = alaGuardianListActivity;
        this.dJp = new ArrayList<>();
    }

    public void l(View.OnClickListener onClickListener) {
        this.fpz = onClickListener;
    }

    public void c(c cVar) {
        this.dJp.clear();
        this.dJp.addAll(cVar.bwg());
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
            view = LayoutInflater.from(this.fFQ.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.qx(i);
        this.fFQ.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    class a {
        ImageView fFS;
        TextView fFT;
        LinearLayout fFU;
        TextView fFV;
        ViewGroup fpS;
        HeadImageView fpV;
        TextView fpW;
        TextView mName;

        public a(View view) {
            this.fFS = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.fFT = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fpS = (ViewGroup) view.findViewById(a.g.item_view);
            this.fpS.setOnClickListener(b.this.fFR);
            this.fpV = (HeadImageView) view.findViewById(a.g.photo);
            this.fpV.setRadius(BdUtilHelper.getDimens(b.this.fFQ.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fpV.setAutoChangeStyle(true);
            this.fpV.setClickable(false);
            this.fFU = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fpW = (TextView) view.findViewById(a.g.ala_intro);
            this.fFV = (TextView) view.findViewById(a.g.attention_btn);
            this.fFV.setOnClickListener(b.this.fpz);
        }

        public void qx(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fpS.setTag(Integer.valueOf(i));
                this.fFV.setTag(Integer.valueOf(i));
                qa(i);
                k.a(this.fpV, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fpW.setText(b.this.fFQ.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.fFJ));
                jH(aVar.followStatus != 0);
            }
        }

        private void jH(boolean z) {
            if (this.fFV != null) {
                this.fFV.setVisibility(8);
            }
        }

        public void qa(int i) {
            this.fFS.setVisibility(8);
            this.fFT.setVisibility(8);
            if (i == 0) {
                this.fFS.setVisibility(0);
                SkinManager.setImageResource(this.fFS, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.fFS.setVisibility(0);
                SkinManager.setImageResource(this.fFS, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.fFS.setVisibility(0);
                SkinManager.setImageResource(this.fFS, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.fFT.setVisibility(0);
                this.fFT.setText(String.valueOf(i + 1));
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
                if (str.equals(next.fFE)) {
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
