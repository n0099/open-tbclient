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
    private View.OnClickListener fFU;
    private Drawable fVr;
    private boolean fVs;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fVs = z;
        this.mSex = i;
        this.fVr = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVq) {
            return 1;
        }
        if (this.dWx == null) {
            return 0;
        }
        return this.dWx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dWx == null) {
            return null;
        }
        return this.dWx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.dWx = eVar.aVe();
            bCi();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.fVt = (LinearLayout) view.findViewById(a.g.info);
            aVar.fGq = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fGq.setIsRound(true);
            aVar.fGq.setAutoChangeStyle(false);
            aVar.fGq.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fGr = (TextView) view.findViewById(a.g.intro);
            aVar.aUC = (TextView) view.findViewById(a.g.attention_btn);
            aVar.fVu = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fVq) {
            aVar.fVt.setVisibility(8);
            aVar.fVu.setVisibility(0);
            if (this.fVs) {
                aVar.fVu.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.fVu.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.fVu.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.fVu.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.fVu.setVisibility(8);
            aVar.fVt.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.dWx, i);
            if (aVar2 != null) {
                aVar.fGq.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fGr.setVisibility(8);
                } else {
                    aVar.fGr.setVisibility(0);
                    aVar.fGr.setText(aVar2.intro);
                }
                b(aVar.aUC, aVar2.bCh(), i);
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
        this.fFU = onClickListener;
    }

    public void ap(String str, boolean z) {
        if (this.dWx != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.dWx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.fVo = 1;
                    } else {
                        next.fVo = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView aUC;
        public HeadImageView fGq;
        public TextView fGr;
        public LinearLayout fVt;
        public TextView fVu;
        public TextView mName;

        private a() {
        }
    }
}
