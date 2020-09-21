package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c extends b {
    private View.OnClickListener fUA;
    private Drawable gkD;
    private boolean gkE;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gkE = z;
        this.mSex = i;
        this.gkD = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gkC) {
            return 1;
        }
        if (this.eiq == null) {
            return 0;
        }
        return this.eiq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eiq == null) {
            return null;
        }
        return this.eiq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eiq = eVar.ber();
            bMN();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.gkF = (LinearLayout) view.findViewById(a.g.info);
            aVar.fUW = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fUW.setIsRound(true);
            aVar.fUW.setAutoChangeStyle(false);
            aVar.fUW.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fUX = (TextView) view.findViewById(a.g.intro);
            aVar.bcq = (TextView) view.findViewById(a.g.attention_btn);
            aVar.gkG = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gkC) {
            aVar.gkF.setVisibility(8);
            aVar.gkG.setVisibility(0);
            if (this.gkE) {
                aVar.gkG.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.gkG.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.gkG.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.gkG.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.gkG.setVisibility(8);
            aVar.gkF.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eiq, i);
            if (aVar2 != null) {
                aVar.fUW.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fUX.setVisibility(8);
                } else {
                    aVar.fUX.setVisibility(0);
                    aVar.fUX.setText(aVar2.intro);
                }
                b(aVar.bcq, aVar2.bMM(), i);
            }
        }
        return view;
    }

    private void b(TextView textView, boolean z, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.fUA = onClickListener;
    }

    public void at(String str, boolean z) {
        if (this.eiq != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eiq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aJZ = 1;
                    } else {
                        next.aJZ = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView bcq;
        public HeadImageView fUW;
        public TextView fUX;
        public LinearLayout gkF;
        public TextView gkG;
        public TextView mName;

        private a() {
        }
    }
}
