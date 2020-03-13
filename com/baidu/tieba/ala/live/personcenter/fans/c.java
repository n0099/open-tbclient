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
    private Drawable eLR;
    private boolean eLS;
    private View.OnClickListener exf;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eLS = z;
        this.mSex = i;
        this.eLR = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eLQ) {
            return 1;
        }
        if (this.cVS == null) {
            return 0;
        }
        return this.cVS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cVS == null) {
            return null;
        }
        return this.cVS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.cVS = eVar.aBn();
            bgK();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.eLT = (LinearLayout) view.findViewById(a.g.info);
            aVar.exz = (HeadImageView) view.findViewById(a.g.photo);
            aVar.exz.setIsRound(true);
            aVar.exz.setAutoChangeStyle(false);
            aVar.exz.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.exA = (TextView) view.findViewById(a.g.intro);
            aVar.arC = (TextView) view.findViewById(a.g.attention_btn);
            aVar.eLU = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eLQ) {
            aVar.eLT.setVisibility(8);
            aVar.eLU.setVisibility(0);
            if (this.eLS) {
                aVar.eLU.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.eLU.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.eLU.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.eLU.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.eLU.setVisibility(8);
            aVar.eLT.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.cVS, i);
            if (aVar2 != null) {
                aVar.exz.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.exA.setVisibility(8);
                } else {
                    aVar.exA.setVisibility(0);
                    aVar.exA.setText(aVar2.intro);
                }
                b(aVar.arC, aVar2.bgJ(), i);
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
        this.exf = onClickListener;
    }

    public void X(String str, boolean z) {
        if (this.cVS != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.cVS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.eLO = 1;
                    } else {
                        next.eLO = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView arC;
        public LinearLayout eLT;
        public TextView eLU;
        public TextView exA;
        public HeadImageView exz;
        public TextView mName;

        private a() {
        }
    }
}
