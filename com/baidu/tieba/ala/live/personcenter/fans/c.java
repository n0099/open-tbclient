package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c extends b {
    private Drawable eHJ;
    private boolean eHK;
    private View.OnClickListener esH;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eHK = z;
        this.mSex = i;
        this.eHJ = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHI) {
            return 1;
        }
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRO == null) {
            return null;
        }
        return this.cRO.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.cRO = eVar.ayU();
            bex();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.eHL = (LinearLayout) view.findViewById(a.g.info);
            aVar.eta = (HeadImageView) view.findViewById(a.g.photo);
            aVar.eta.setIsRound(true);
            aVar.eta.setAutoChangeStyle(false);
            aVar.eta.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.etb = (TextView) view.findViewById(a.g.intro);
            aVar.aoj = (TextView) view.findViewById(a.g.attention_btn);
            aVar.eHM = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eHI) {
            aVar.eHL.setVisibility(8);
            aVar.eHM.setVisibility(0);
            if (this.eHK) {
                aVar.eHM.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.eHM.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.eHM.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.eHM.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.eHM.setVisibility(8);
            aVar.eHL.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.cRO, i);
            if (aVar2 != null) {
                aVar.eta.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.etb.setVisibility(8);
                } else {
                    aVar.etb.setVisibility(0);
                    aVar.etb.setText(aVar2.intro);
                }
                b(aVar.aoj, aVar2.bew(), i);
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
            textView.setCompoundDrawablesWithIntrinsicBounds(this.eHJ, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextColor(this.mContext.getResources().getColorStateList(a.d.sdk_prc_btn_forum_focus_color));
            textView.setBackgroundResource(a.f.sdk_prc_btn_transparent_focus_border_bg);
        }
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(this.esH);
    }

    public void s(View.OnClickListener onClickListener) {
        this.esH = onClickListener;
    }

    public void X(String str, boolean z) {
        if (this.cRO != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.cRO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.eHG = 1;
                    } else {
                        next.eHG = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView aoj;
        public LinearLayout eHL;
        public TextView eHM;
        public HeadImageView eta;
        public TextView etb;
        public TextView mName;

        private a() {
        }
    }
}
