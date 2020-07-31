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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> dWx;
    private AlaGuardianListActivity fWs;
    private View.OnClickListener fWt = null;
    private View.OnClickListener fFU = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.dWx = null;
        this.fWs = null;
        this.fWs = alaGuardianListActivity;
        this.dWx = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.fFU = onClickListener;
    }

    public void c(c cVar) {
        this.dWx.clear();
        this.dWx.addAll(cVar.bCq());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx == null) {
            return 0;
        }
        return this.dWx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx == null || i >= this.dWx.size()) {
            return null;
        }
        return this.dWx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.fWs.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.rm(i);
        this.fWs.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        ViewGroup fGn;
        HeadImageView fGq;
        TextView fGr;
        ImageView fWu;
        TextView fWv;
        LinearLayout fWw;
        TextView fWx;
        TextView mName;

        public a(View view) {
            this.fWu = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.fWv = (TextView) view.findViewById(a.g.tvGradeNum);
            this.fGn = (ViewGroup) view.findViewById(a.g.item_view);
            this.fGn.setOnClickListener(b.this.fWt);
            this.fGq = (HeadImageView) view.findViewById(a.g.photo);
            this.fGq.setRadius(BdUtilHelper.getDimens(b.this.fWs.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.fGq.setAutoChangeStyle(true);
            this.fGq.setClickable(false);
            this.fWw = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.fGr = (TextView) view.findViewById(a.g.ala_intro);
            this.fWx = (TextView) view.findViewById(a.g.attention_btn);
            this.fWx.setOnClickListener(b.this.fFU);
        }

        public void rm(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.fGn.setTag(Integer.valueOf(i));
                this.fWx.setTag(Integer.valueOf(i));
                qO(i);
                k.a(this.fGq, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.fGr.setText(b.this.fWs.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.fWl));
                ky(aVar.followStatus != 0);
            }
        }

        private void ky(boolean z) {
            if (this.fWx != null) {
                this.fWx.setVisibility(8);
            }
        }

        public void qO(int i) {
            this.fWu.setVisibility(8);
            this.fWv.setVisibility(8);
            if (i == 0) {
                this.fWu.setVisibility(0);
                SkinManager.setImageResource(this.fWu, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.fWu.setVisibility(0);
                SkinManager.setImageResource(this.fWu, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.fWu.setVisibility(0);
                SkinManager.setImageResource(this.fWu, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.fWv.setVisibility(0);
                this.fWv.setText(String.valueOf(i + 1));
            }
        }
    }

    public void ap(String str, boolean z) {
        if (this.dWx != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.dWx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.fWg)) {
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
