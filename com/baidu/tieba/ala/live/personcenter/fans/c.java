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
/* loaded from: classes10.dex */
public class c extends b {
    private View.OnClickListener gQM;
    private Drawable hmN;
    private boolean hmO;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hmO = z;
        this.mSex = i;
        this.hmN = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmM) {
            return 1;
        }
        if (this.eXu == null) {
            return 0;
        }
        return this.eXu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eXu == null) {
            return null;
        }
        return this.eXu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eXu = eVar.bmK();
            bYE();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.hmP = (LinearLayout) view.findViewById(a.f.info);
            aVar.gRi = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gRi.setIsRound(true);
            aVar.gRi.setAutoChangeStyle(false);
            aVar.gRi.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gRj = (TextView) view.findViewById(a.f.intro);
            aVar.bna = (TextView) view.findViewById(a.f.attention_btn);
            aVar.hmQ = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.hmM) {
            aVar.hmP.setVisibility(8);
            aVar.hmQ.setVisibility(0);
            if (this.hmO) {
                aVar.hmQ.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.hmQ.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.hmQ.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.hmQ.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.hmQ.setVisibility(8);
            aVar.hmP.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eXu, i);
            if (aVar2 != null) {
                aVar.gRi.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gRj.setVisibility(8);
                } else {
                    aVar.gRj.setVisibility(0);
                    aVar.gRj.setText(aVar2.intro);
                }
                b(aVar.bna, aVar2.bYD(), i);
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
        this.gQM = onClickListener;
    }

    public void aA(String str, boolean z) {
        if (this.eXu != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eXu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aQz = 1;
                    } else {
                        next.aQz = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        public TextView bna;
        public HeadImageView gRi;
        public TextView gRj;
        public LinearLayout hmP;
        public TextView hmQ;
        public TextView mName;

        private a() {
        }
    }
}
