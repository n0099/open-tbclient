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
    private Drawable eLD;
    private boolean eLE;
    private View.OnClickListener ewR;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eLE = z;
        this.mSex = i;
        this.eLD = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLC) {
            return 1;
        }
        if (this.cVQ == null) {
            return 0;
        }
        return this.cVQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVQ == null) {
            return null;
        }
        return this.cVQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.cVQ = eVar.aBl();
            bgH();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.eLF = (LinearLayout) view.findViewById(a.g.info);
            aVar.exk = (HeadImageView) view.findViewById(a.g.photo);
            aVar.exk.setIsRound(true);
            aVar.exk.setAutoChangeStyle(false);
            aVar.exk.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.exl = (TextView) view.findViewById(a.g.intro);
            aVar.arB = (TextView) view.findViewById(a.g.attention_btn);
            aVar.eLG = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eLC) {
            aVar.eLF.setVisibility(8);
            aVar.eLG.setVisibility(0);
            if (this.eLE) {
                aVar.eLG.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.eLG.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.eLG.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.eLG.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.eLG.setVisibility(8);
            aVar.eLF.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.cVQ, i);
            if (aVar2 != null) {
                aVar.exk.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.exl.setVisibility(8);
                } else {
                    aVar.exl.setVisibility(0);
                    aVar.exl.setText(aVar2.intro);
                }
                b(aVar.arB, aVar2.bgG(), i);
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
        this.ewR = onClickListener;
    }

    public void X(String str, boolean z) {
        if (this.cVQ != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.cVQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.eLA = 1;
                    } else {
                        next.eLA = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView arB;
        public LinearLayout eLF;
        public TextView eLG;
        public HeadImageView exk;
        public TextView exl;
        public TextView mName;

        private a() {
        }
    }
}
