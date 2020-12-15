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
    private View.OnClickListener gFe;
    private Drawable gZs;
    private boolean gZt;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gZt = z;
        this.mSex = i;
        this.gZs = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gZr) {
            return 1;
        }
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eOt = eVar.bnI();
            bYD();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.gZu = (LinearLayout) view.findViewById(a.f.info);
            aVar.gFA = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gFA.setIsRound(true);
            aVar.gFA.setAutoChangeStyle(false);
            aVar.gFA.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gFB = (TextView) view.findViewById(a.f.intro);
            aVar.blo = (TextView) view.findViewById(a.f.attention_btn);
            aVar.gZv = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gZr) {
            aVar.gZu.setVisibility(8);
            aVar.gZv.setVisibility(0);
            if (this.gZt) {
                aVar.gZv.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.gZv.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.gZv.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.gZv.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.gZv.setVisibility(8);
            aVar.gZu.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eOt, i);
            if (aVar2 != null) {
                aVar.gFA.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gFB.setVisibility(8);
                } else {
                    aVar.gFB.setVisibility(0);
                    aVar.gFB.setText(aVar2.intro);
                }
                b(aVar.blo, aVar2.bYC(), i);
            }
        }
        return view;
    }

    private void b(TextView textView, boolean z, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.gFe = onClickListener;
    }

    public void aA(String str, boolean z) {
        if (this.eOt != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eOt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aQa = 1;
                    } else {
                        next.aQa = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView blo;
        public HeadImageView gFA;
        public TextView gFB;
        public LinearLayout gZu;
        public TextView gZv;
        public TextView mName;

        private a() {
        }
    }
}
