package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c extends b {
    private boolean eGA;
    private Drawable eGz;
    private View.OnClickListener erw;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eGA = z;
        this.mSex = i;
        this.eGz = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGy) {
            return 1;
        }
        if (this.cRE == null) {
            return 0;
        }
        return this.cRE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRE == null) {
            return null;
        }
        return this.cRE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.cRE = eVar.ayB();
            bec();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.eGB = (LinearLayout) view.findViewById(a.g.info);
            aVar.erP = (HeadImageView) view.findViewById(a.g.photo);
            aVar.erP.setIsRound(true);
            aVar.erP.setAutoChangeStyle(false);
            aVar.erP.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.erQ = (TextView) view.findViewById(a.g.intro);
            aVar.anw = (TextView) view.findViewById(a.g.attention_btn);
            aVar.eGC = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eGy) {
            aVar.eGB.setVisibility(8);
            aVar.eGC.setVisibility(0);
            if (this.eGA) {
                aVar.eGC.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.eGC.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.eGC.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.eGC.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.eGC.setVisibility(8);
            aVar.eGB.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.cRE, i);
            if (aVar2 != null) {
                aVar.erP.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.erQ.setVisibility(8);
                } else {
                    aVar.erQ.setVisibility(0);
                    aVar.erQ.setText(aVar2.intro);
                }
                b(aVar.anw, aVar2.beb(), i);
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
            textView.setCompoundDrawablesWithIntrinsicBounds(this.eGz, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextColor(this.mContext.getResources().getColorStateList(a.d.sdk_prc_btn_forum_focus_color));
            textView.setBackgroundResource(a.f.sdk_prc_btn_transparent_focus_border_bg);
        }
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(this.erw);
    }

    public void t(View.OnClickListener onClickListener) {
        this.erw = onClickListener;
    }

    public void X(String str, boolean z) {
        if (this.cRE != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.cRE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.eGw = 1;
                    } else {
                        next.eGw = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView anw;
        public LinearLayout eGB;
        public TextView eGC;
        public HeadImageView erP;
        public TextView erQ;
        public TextView mName;

        private a() {
        }
    }
}
