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
    private Drawable fEP;
    private boolean fEQ;
    private View.OnClickListener fpz;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fEQ = z;
        this.mSex = i;
        this.fEP = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEO) {
            return 1;
        }
        if (this.dJp == null) {
            return 0;
        }
        return this.dJp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dJp == null) {
            return null;
        }
        return this.dJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.dJp = eVar.aPw();
            bvY();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.fER = (LinearLayout) view.findViewById(a.g.info);
            aVar.fpV = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fpV.setIsRound(true);
            aVar.fpV.setAutoChangeStyle(false);
            aVar.fpV.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fpW = (TextView) view.findViewById(a.g.intro);
            aVar.aQD = (TextView) view.findViewById(a.g.attention_btn);
            aVar.fES = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fEO) {
            aVar.fER.setVisibility(8);
            aVar.fES.setVisibility(0);
            if (this.fEQ) {
                aVar.fES.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.fES.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.fES.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.fES.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.fES.setVisibility(8);
            aVar.fER.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.dJp, i);
            if (aVar2 != null) {
                aVar.fpV.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fpW.setVisibility(8);
                } else {
                    aVar.fpW.setVisibility(0);
                    aVar.fpW.setText(aVar2.intro);
                }
                b(aVar.aQD, aVar2.bvX(), i);
            }
        }
        return view;
    }

    private void b(TextView textView, boolean z, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.fpz = onClickListener;
    }

    public void ap(String str, boolean z) {
        if (this.dJp != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.dJp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.fEM = 1;
                    } else {
                        next.fEM = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView aQD;
        public LinearLayout fER;
        public TextView fES;
        public HeadImageView fpV;
        public TextView fpW;
        public TextView mName;

        private a() {
        }
    }
}
