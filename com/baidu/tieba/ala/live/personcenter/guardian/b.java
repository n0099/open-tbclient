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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eIM;
    private AlaGuardianListActivity gRw;
    private View.OnClickListener gRx = null;
    private View.OnClickListener gwK = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eIM = null;
        this.gRw = null;
        this.gRw = alaGuardianListActivity;
        this.eIM = new ArrayList<>();
    }

    public void n(View.OnClickListener onClickListener) {
        this.gwK = onClickListener;
    }

    public void c(c cVar) {
        this.eIM.clear();
        this.eIM.addAll(cVar.bVI());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM == null || i >= this.eIM.size()) {
            return null;
        }
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.gRw.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.uZ(i);
        this.gRw.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        TextView dHi;
        LinearLayout gRA;
        ImageView gRy;
        TextView gRz;
        ViewGroup gxd;
        HeadImageView gxg;
        TextView gxh;
        TextView mName;

        public a(View view) {
            this.gRy = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.gRz = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gxd = (ViewGroup) view.findViewById(a.f.item_view);
            this.gxd.setOnClickListener(b.this.gRx);
            this.gxg = (HeadImageView) view.findViewById(a.f.photo);
            this.gxg.setRadius(BdUtilHelper.getDimens(b.this.gRw.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gxg.setAutoChangeStyle(true);
            this.gxg.setClickable(false);
            this.gRA = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gxh = (TextView) view.findViewById(a.f.ala_intro);
            this.dHi = (TextView) view.findViewById(a.f.attention_btn);
            this.dHi.setOnClickListener(b.this.gwK);
        }

        public void uZ(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gxd.setTag(Integer.valueOf(i));
                this.dHi.setTag(Integer.valueOf(i));
                uu(i);
                l.a(this.gxg, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gxh.setText(b.this.gRw.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.gRp));
                lY(aVar.followStatus != 0);
            }
        }

        private void lY(boolean z) {
            if (this.dHi != null) {
                this.dHi.setVisibility(8);
            }
        }

        public void uu(int i) {
            this.gRy.setVisibility(8);
            this.gRz.setVisibility(8);
            if (i == 0) {
                this.gRy.setVisibility(0);
                SkinManager.setImageResource(this.gRy, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.gRy.setVisibility(0);
                SkinManager.setImageResource(this.gRy, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.gRy.setVisibility(0);
                SkinManager.setImageResource(this.gRy, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.gRz.setVisibility(0);
                this.gRz.setText(String.valueOf(i + 1));
            }
        }
    }

    public void az(String str, boolean z) {
        if (this.eIM != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eIM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.gRl)) {
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
