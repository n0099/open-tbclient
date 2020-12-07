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
    private ArrayList<com.baidu.tieba.ala.live.personcenter.guardian.a> eOt;
    private AlaGuardianListActivity haq;
    private View.OnClickListener har = null;
    private View.OnClickListener gFc = null;

    public b(AlaGuardianListActivity alaGuardianListActivity) {
        this.eOt = null;
        this.haq = null;
        this.haq = alaGuardianListActivity;
        this.eOt = new ArrayList<>();
    }

    public void n(View.OnClickListener onClickListener) {
        this.gFc = onClickListener;
    }

    public void c(c cVar) {
        this.eOt.clear();
        this.eOt.addAll(cVar.bYK());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt == null || i >= this.eOt.size()) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.haq.getPageContext().getPageActivity()).inflate(a.g.sdk_prc_person_center_guardian_item, (ViewGroup) null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.we(i);
        this.haq.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes4.dex */
    class a {
        TextView dMz;
        ViewGroup gFv;
        HeadImageView gFy;
        TextView gFz;
        ImageView has;
        TextView hat;
        LinearLayout hau;
        TextView mName;

        public a(View view) {
            this.has = (ImageView) view.findViewById(a.f.imgGradeRound);
            this.hat = (TextView) view.findViewById(a.f.tvGradeNum);
            this.gFv = (ViewGroup) view.findViewById(a.f.item_view);
            this.gFv.setOnClickListener(b.this.har);
            this.gFy = (HeadImageView) view.findViewById(a.f.photo);
            this.gFy.setRadius(BdUtilHelper.getDimens(b.this.haq.getPageContext().getPageActivity(), a.d.sdk_ds90));
            this.gFy.setAutoChangeStyle(true);
            this.gFy.setClickable(false);
            this.hau = (LinearLayout) view.findViewById(a.f.info);
            this.mName = (TextView) view.findViewById(a.f.ala_name);
            this.gFz = (TextView) view.findViewById(a.f.ala_intro);
            this.dMz = (TextView) view.findViewById(a.f.attention_btn);
            this.dMz.setOnClickListener(b.this.gFc);
        }

        public void we(int i) {
            com.baidu.tieba.ala.live.personcenter.guardian.a aVar = (com.baidu.tieba.ala.live.personcenter.guardian.a) b.this.getItem(i);
            if (aVar != null) {
                this.gFv.setTag(Integer.valueOf(i));
                this.dMz.setTag(Integer.valueOf(i));
                vz(i);
                l.a(this.gFy, aVar.portrait, true, !StringUtils.isNull(aVar.appId));
                this.mName.setText(aVar.getNameShow());
                this.gFz.setText(b.this.haq.getResources().getString(a.h.sdk_prc_guardian_list_item_charm, aVar.haj));
                mu(aVar.followStatus != 0);
            }
        }

        private void mu(boolean z) {
            if (this.dMz != null) {
                this.dMz.setVisibility(8);
            }
        }

        public void vz(int i) {
            this.has.setVisibility(8);
            this.hat.setVisibility(8);
            if (i == 0) {
                this.has.setVisibility(0);
                SkinManager.setImageResource(this.has, a.e.sdk_prc_icon_grade_round_no1);
            } else if (i == 1) {
                this.has.setVisibility(0);
                SkinManager.setImageResource(this.has, a.e.sdk_prc_icon_grade_round_no2);
            } else if (i == 2) {
                this.has.setVisibility(0);
                SkinManager.setImageResource(this.has, a.e.sdk_prc_icon_grade_round_no3);
            } else {
                this.hat.setVisibility(0);
                this.hat.setText(String.valueOf(i + 1));
            }
        }
    }

    public void aA(String str, boolean z) {
        if (this.eOt != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.guardian.a> it = this.eOt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.guardian.a next = it.next();
                if (str.equals(next.haf)) {
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
