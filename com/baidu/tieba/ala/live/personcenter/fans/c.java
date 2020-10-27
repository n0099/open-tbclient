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
    private Drawable gKK;
    private boolean gKL;
    private View.OnClickListener gqW;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gKL = z;
        this.mSex = i;
        this.gKK = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gKJ) {
            return 1;
        }
        if (this.eCX == null) {
            return 0;
        }
        return this.eCX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCX == null) {
            return null;
        }
        return this.eCX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eCX = eVar.biT();
            bTb();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.gKM = (LinearLayout) view.findViewById(a.g.info);
            aVar.grs = (HeadImageView) view.findViewById(a.g.photo);
            aVar.grs.setIsRound(true);
            aVar.grs.setAutoChangeStyle(false);
            aVar.grs.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.grt = (TextView) view.findViewById(a.g.intro);
            aVar.bhr = (TextView) view.findViewById(a.g.attention_btn);
            aVar.gKN = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gKJ) {
            aVar.gKM.setVisibility(8);
            aVar.gKN.setVisibility(0);
            if (this.gKL) {
                aVar.gKN.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.gKN.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.gKN.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.gKN.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.gKN.setVisibility(8);
            aVar.gKM.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eCX, i);
            if (aVar2 != null) {
                aVar.grs.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.grt.setVisibility(8);
                } else {
                    aVar.grt.setVisibility(0);
                    aVar.grt.setText(aVar2.intro);
                }
                b(aVar.bhr, aVar2.bTa(), i);
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
        this.gqW = onClickListener;
    }

    public void az(String str, boolean z) {
        if (this.eCX != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eCX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aNJ = 1;
                    } else {
                        next.aNJ = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView bhr;
        public LinearLayout gKM;
        public TextView gKN;
        public HeadImageView grs;
        public TextView grt;
        public TextView mName;

        private a() {
        }
    }
}
