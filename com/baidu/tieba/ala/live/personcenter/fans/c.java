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
/* loaded from: classes11.dex */
public class c extends b {
    private View.OnClickListener gOP;
    private Drawable hkQ;
    private boolean hkR;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hkR = z;
        this.mSex = i;
        this.hkQ = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkP) {
            return 1;
        }
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVV == null) {
            return null;
        }
        return this.eVV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eVV = eVar.bmI();
            bYr();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.hkS = (LinearLayout) view.findViewById(a.f.info);
            aVar.gPl = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gPl.setIsRound(true);
            aVar.gPl.setAutoChangeStyle(false);
            aVar.gPl.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gPm = (TextView) view.findViewById(a.f.intro);
            aVar.blz = (TextView) view.findViewById(a.f.attention_btn);
            aVar.hkT = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.hkP) {
            aVar.hkS.setVisibility(8);
            aVar.hkT.setVisibility(0);
            if (this.hkR) {
                aVar.hkT.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.hkT.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.hkT.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.hkT.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.hkT.setVisibility(8);
            aVar.hkS.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eVV, i);
            if (aVar2 != null) {
                aVar.gPl.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gPm.setVisibility(8);
                } else {
                    aVar.gPm.setVisibility(0);
                    aVar.gPm.setText(aVar2.intro);
                }
                b(aVar.blz, aVar2.bYq(), i);
            }
        }
        return view;
    }

    private void b(TextView textView, boolean z, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void v(View.OnClickListener onClickListener) {
        this.gOP = onClickListener;
    }

    public void aA(String str, boolean z) {
        if (this.eVV != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eVV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aOZ = 1;
                    } else {
                        next.aOZ = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        public TextView blz;
        public HeadImageView gPl;
        public TextView gPm;
        public LinearLayout hkS;
        public TextView hkT;
        public TextView mName;

        private a() {
        }
    }
}
