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
/* loaded from: classes7.dex */
public class c extends b {
    private View.OnClickListener fRp;
    private Drawable ghu;
    private boolean ghv;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ghv = z;
        this.mSex = i;
        this.ghu = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ght) {
            return 1;
        }
        if (this.egb == null) {
            return 0;
        }
        return this.egb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.egb == null) {
            return null;
        }
        return this.egb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.egb = eVar.bdx();
            bLD();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.ghw = (LinearLayout) view.findViewById(a.g.info);
            aVar.fRL = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fRL.setIsRound(true);
            aVar.fRL.setAutoChangeStyle(false);
            aVar.fRL.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fRM = (TextView) view.findViewById(a.g.intro);
            aVar.aZS = (TextView) view.findViewById(a.g.attention_btn);
            aVar.ghx = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.ght) {
            aVar.ghw.setVisibility(8);
            aVar.ghx.setVisibility(0);
            if (this.ghv) {
                aVar.ghx.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.ghx.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.ghx.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.ghx.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.ghx.setVisibility(8);
            aVar.ghw.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.egb, i);
            if (aVar2 != null) {
                aVar.fRL.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fRM.setVisibility(8);
                } else {
                    aVar.fRM.setVisibility(0);
                    aVar.fRM.setText(aVar2.intro);
                }
                b(aVar.aZS, aVar2.bLC(), i);
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
        this.fRp = onClickListener;
    }

    public void at(String str, boolean z) {
        if (this.egb != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.egb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.ghr = 1;
                    } else {
                        next.ghr = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    private static class a {
        public TextView aZS;
        public HeadImageView fRL;
        public TextView fRM;
        public LinearLayout ghw;
        public TextView ghx;
        public TextView mName;

        private a() {
        }
    }
}
