package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c extends b {
    private Drawable eLE;
    private boolean eLF;
    private View.OnClickListener ewS;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eLF = z;
        this.mSex = i;
        this.eLE = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLD) {
            return 1;
        }
        if (this.cVR == null) {
            return 0;
        }
        return this.cVR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVR == null) {
            return null;
        }
        return this.cVR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.cVR = eVar.aBn();
            bgJ();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.eLG = (LinearLayout) view.findViewById(a.g.info);
            aVar.exl = (HeadImageView) view.findViewById(a.g.photo);
            aVar.exl.setIsRound(true);
            aVar.exl.setAutoChangeStyle(false);
            aVar.exl.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.exm = (TextView) view.findViewById(a.g.intro);
            aVar.arB = (TextView) view.findViewById(a.g.attention_btn);
            aVar.eLH = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eLD) {
            aVar.eLG.setVisibility(8);
            aVar.eLH.setVisibility(0);
            if (this.eLF) {
                aVar.eLH.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.eLH.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.eLH.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.eLH.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.eLH.setVisibility(8);
            aVar.eLG.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.cVR, i);
            if (aVar2 != null) {
                aVar.exl.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.exm.setVisibility(8);
                } else {
                    aVar.exm.setVisibility(0);
                    aVar.exm.setText(aVar2.intro);
                }
                b(aVar.arB, aVar2.bgI(), i);
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
        this.ewS = onClickListener;
    }

    public void X(String str, boolean z) {
        if (this.cVR != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.cVR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.eLB = 1;
                    } else {
                        next.eLB = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView arB;
        public LinearLayout eLG;
        public TextView eLH;
        public HeadImageView exl;
        public TextView exm;
        public TextView mName;

        private a() {
        }
    }
}
