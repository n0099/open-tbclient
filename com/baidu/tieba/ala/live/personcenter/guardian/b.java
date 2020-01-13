package com.baidu.tieba.ala.live.personcenter.guardian;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> cRO;
    private AlaGuardianListActivity eIK;
    private View.OnClickListener eIL = null;
    private View.OnClickListener esH = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.cRO = null;
        this.eIK = null;
        this.eIK = alaGuardianListActivity;
        this.cRO = new ArrayList<>();
    }

    public void m(View.OnClickListener onClickListener) {
        this.esH = onClickListener;
    }

    public void c(c cVar) {
        this.cRO.clear();
        this.cRO.addAll(cVar.beF());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null || i >= this.cRO.size()) {
            return null;
        }
        return this.cRO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eIK.getPageContext().getPageActivity()).inflate(a.h.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pm(i);
        this.eIK.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes2.dex */
    class a {
        ImageView eIM;
        TextView eIN;
        LinearLayout eIO;
        TextView eIP;
        ViewGroup esX;
        HeadImageView eta;
        TextView etb;
        TextView mName;

        public a(View view) {
            this.eIM = (ImageView) view.findViewById(a.g.imgGradeRound);
            this.eIN = (TextView) view.findViewById(a.g.tvGradeNum);
            this.esX = (ViewGroup) view.findViewById(a.g.item_view);
            this.esX.setOnClickListener(b.this.eIL);
            this.eta = (HeadImageView) view.findViewById(a.g.photo);
            this.eta.setRadius(BdUtilHelper.getDimens(b.this.eIK.getPageContext().getPageActivity(), a.e.sdk_ds90));
            this.eta.setAutoChangeStyle(true);
            this.eta.setClickable(false);
            this.eIO = (LinearLayout) view.findViewById(a.g.info);
            this.mName = (TextView) view.findViewById(a.g.ala_name);
            this.etb = (TextView) view.findViewById(a.g.ala_intro);
            this.eIP = (TextView) view.findViewById(a.g.attention_btn);
            this.eIP.setOnClickListener(b.this.esH);
        }

        public void pm(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.esX.setTag(Integer.valueOf(i));
                this.eIP.setTag(Integer.valueOf(i));
                oJ(i);
                k.a(this.eta, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.etb.setText(b.this.eIK.getResources().getString(a.i.sdk_prc_guardian_list_item_charm, aVar.eID));
                ie(aVar.followStatus != 0);
            }
        }

        private void ie(boolean z) {
            if (this.eIP != null) {
                this.eIP.setVisibility(8);
            } else if (z) {
                this.eIP.setText(b.this.eIK.getPageContext().getString(a.i.sdk_prc_guardian_list_attention));
                this.eIP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.eIP, a.d.sdk_cp_cont_d);
            } else {
                this.eIP.setText(b.this.eIK.getPageContext().getString(a.i.sdk_prc_guardian_list_not_attention));
                this.eIP.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(a.f.sdk_prc_live_attention_add_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                SkinManager.setViewTextColor(this.eIP, a.d.sdk_cp_other_b);
            }
        }

        public void oJ(int i) {
            this.eIM.setVisibility(8);
            this.eIN.setVisibility(8);
            if (i == 0) {
                this.eIM.setVisibility(0);
                SkinManager.setImageResource(this.eIM, a.f.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.eIM.setVisibility(0);
                SkinManager.setImageResource(this.eIM, a.f.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.eIM.setVisibility(0);
                SkinManager.setImageResource(this.eIM, a.f.sdk_prc_icon_grade_round_no3);
            } else {
                this.eIN.setVisibility(0);
                this.eIN.setText(String.valueOf(i + 1));
            }
        }
    }

    public void X(String str, boolean z) {
        if (this.cRO != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.cRO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.eIy)) {
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
