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
    private View.OnClickListener gQP;
    private Drawable hlh;
    private boolean hli;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hli = z;
        this.mSex = i;
        this.hlh = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlg) {
            return 1;
        }
        if (this.eYq == null) {
            return 0;
        }
        return this.eYq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYq == null) {
            return null;
        }
        return this.eYq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eYq = eVar.bqi();
            cbi();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.hlj = (LinearLayout) view.findViewById(a.f.info);
            aVar.gRl = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gRl.setIsRound(true);
            aVar.gRl.setAutoChangeStyle(false);
            aVar.gRl.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gRm = (TextView) view.findViewById(a.f.intro);
            aVar.bmU = (TextView) view.findViewById(a.f.attention_btn);
            aVar.hlk = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.hlg) {
            aVar.hlj.setVisibility(8);
            aVar.hlk.setVisibility(0);
            if (this.hli) {
                aVar.hlk.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.hlk.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.hlk.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.hlk.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.hlk.setVisibility(8);
            aVar.hlj.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eYq, i);
            if (aVar2 != null) {
                aVar.gRl.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gRm.setVisibility(8);
                } else {
                    aVar.gRm.setVisibility(0);
                    aVar.gRm.setText(aVar2.intro);
                }
                b(aVar.bmU, aVar2.cbh(), i);
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
        this.gQP = onClickListener;
    }

    public void aB(String str, boolean z) {
        if (this.eYq != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eYq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aQP = 1;
                    } else {
                        next.aQP = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        public TextView bmU;
        public HeadImageView gRl;
        public TextView gRm;
        public LinearLayout hlj;
        public TextView hlk;
        public TextView mName;

        private a() {
        }
    }
}
