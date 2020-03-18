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
    private Drawable eMn;
    private boolean eMo;
    private View.OnClickListener exC;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.eMo = z;
        this.mSex = i;
        this.eMn = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMm) {
            return 1;
        }
        if (this.cWf == null) {
            return 0;
        }
        return this.cWf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWf == null) {
            return null;
        }
        return this.cWf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.cWf = eVar.aBq();
            bgP();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.eMp = (LinearLayout) view.findViewById(a.g.info);
            aVar.exV = (HeadImageView) view.findViewById(a.g.photo);
            aVar.exV.setIsRound(true);
            aVar.exV.setAutoChangeStyle(false);
            aVar.exV.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.exW = (TextView) view.findViewById(a.g.intro);
            aVar.arM = (TextView) view.findViewById(a.g.attention_btn);
            aVar.eMq = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eMm) {
            aVar.eMp.setVisibility(8);
            aVar.eMq.setVisibility(0);
            if (this.eMo) {
                aVar.eMq.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.eMq.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.eMq.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.eMq.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.eMq.setVisibility(8);
            aVar.eMp.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.cWf, i);
            if (aVar2 != null) {
                aVar.exV.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.exW.setVisibility(8);
                } else {
                    aVar.exW.setVisibility(0);
                    aVar.exW.setText(aVar2.intro);
                }
                b(aVar.arM, aVar2.bgO(), i);
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
        this.exC = onClickListener;
    }

    public void X(String str, boolean z) {
        if (this.cWf != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.cWf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.eMk = 1;
                    } else {
                        next.eMk = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView arM;
        public LinearLayout eMp;
        public TextView eMq;
        public HeadImageView exV;
        public TextView exW;
        public TextView mName;

        private a() {
        }
    }
}
