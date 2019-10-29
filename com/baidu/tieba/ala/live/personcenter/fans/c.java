package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c extends b {
    private View.OnClickListener dGj;
    private Drawable dRJ;
    private boolean dRK;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.dRK = z;
        this.mSex = i;
        this.dRJ = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dRI) {
            return 1;
        }
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbZ == null) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.bbZ = fVar.ahD();
            aMz();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.dRL = (LinearLayout) view.findViewById(a.g.info);
            aVar.dGD = (HeadImageView) view.findViewById(a.g.photo);
            aVar.dGD.setIsRound(true);
            aVar.dGD.setAutoChangeStyle(false);
            aVar.dGD.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.dGE = (TextView) view.findViewById(a.g.intro);
            aVar.afM = (TextView) view.findViewById(a.g.attention_btn);
            aVar.dRM = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.dRI) {
            aVar.dRL.setVisibility(8);
            aVar.dRM.setVisibility(0);
            if (this.dRK) {
                aVar.dRM.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.dRM.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.dRM.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.dRM.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.dRM.setVisibility(8);
            aVar.dRL.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.bbZ, i);
            if (aVar2 != null) {
                aVar.dGD.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.dGE.setVisibility(8);
                } else {
                    aVar.dGE.setVisibility(0);
                    aVar.dGE.setText(aVar2.intro);
                }
                b(aVar.afM, aVar2.aMy(), i);
            }
        }
        return view;
    }

    private void b(TextView textView, boolean z, int i) {
        if (textView != null) {
            textView.setVisibility(8);
            return;
        }
        if (z) {
            textView.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds24));
            textView.setText(a.i.sdk_prc_each_concerned);
            textView.setPadding(0, 0, 0, 0);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextColor(this.mContext.getResources().getColorStateList(a.d.sdk_prc_btn_forum_focus_gray_color));
            textView.setBackgroundResource(a.f.sdk_prc_btn_transparent_gray_border);
        } else {
            textView.setTextSize(0, BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds26));
            textView.setText(a.i.sdk_prc_attention);
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10), 0);
            textView.setCompoundDrawablesWithIntrinsicBounds(this.dRJ, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextColor(this.mContext.getResources().getColorStateList(a.d.sdk_prc_btn_forum_focus_color));
            textView.setBackgroundResource(a.f.sdk_prc_btn_transparent_focus_border_bg);
        }
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(this.dGj);
    }

    public void r(View.OnClickListener onClickListener) {
        this.dGj = onClickListener;
    }

    public void T(String str, boolean z) {
        if (this.bbZ != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.bbZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.dRG = 1;
                    } else {
                        next.dRG = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView afM;
        public HeadImageView dGD;
        public TextView dGE;
        public LinearLayout dRL;
        public TextView dRM;
        public TextView mName;

        private a() {
        }
    }
}
