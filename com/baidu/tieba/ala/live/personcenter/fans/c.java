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
    private View.OnClickListener dFs;
    private Drawable dQS;
    private boolean dQT;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.dQT = z;
        this.mSex = i;
        this.dQS = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQR) {
            return 1;
        }
        if (this.bbH == null) {
            return 0;
        }
        return this.bbH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbH == null) {
            return null;
        }
        return this.bbH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.bbH = fVar.ahB();
            aMx();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.dQU = (LinearLayout) view.findViewById(a.g.info);
            aVar.dFM = (HeadImageView) view.findViewById(a.g.photo);
            aVar.dFM.setIsRound(true);
            aVar.dFM.setAutoChangeStyle(false);
            aVar.dFM.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.dFN = (TextView) view.findViewById(a.g.intro);
            aVar.afu = (TextView) view.findViewById(a.g.attention_btn);
            aVar.dQV = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.dQR) {
            aVar.dQU.setVisibility(8);
            aVar.dQV.setVisibility(0);
            if (this.dQT) {
                aVar.dQV.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.dQV.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.dQV.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.dQV.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.dQV.setVisibility(8);
            aVar.dQU.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.bbH, i);
            if (aVar2 != null) {
                aVar.dFM.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.dFN.setVisibility(8);
                } else {
                    aVar.dFN.setVisibility(0);
                    aVar.dFN.setText(aVar2.intro);
                }
                b(aVar.afu, aVar2.aMw(), i);
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
            textView.setCompoundDrawablesWithIntrinsicBounds(this.dQS, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextColor(this.mContext.getResources().getColorStateList(a.d.sdk_prc_btn_forum_focus_color));
            textView.setBackgroundResource(a.f.sdk_prc_btn_transparent_focus_border_bg);
        }
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(this.dFs);
    }

    public void r(View.OnClickListener onClickListener) {
        this.dFs = onClickListener;
    }

    public void T(String str, boolean z) {
        if (this.bbH != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.bbH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.dQP = 1;
                    } else {
                        next.dQP = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView afu;
        public HeadImageView dFM;
        public TextView dFN;
        public LinearLayout dQU;
        public TextView dQV;
        public TextView mName;

        private a() {
        }
    }
}
