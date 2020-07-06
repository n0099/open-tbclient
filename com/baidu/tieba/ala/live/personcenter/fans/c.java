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
/* loaded from: classes3.dex */
public class c extends b {
    private View.OnClickListener fAK;
    private Drawable fPY;
    private boolean fPZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fPZ = z;
        this.mSex = i;
        this.fPY = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPX) {
            return 1;
        }
        if (this.dQf == null) {
            return 0;
        }
        return this.dQf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dQf == null) {
            return null;
        }
        return this.dQf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.dQf = eVar.aRi();
            byU();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.fQa = (LinearLayout) view.findViewById(a.g.info);
            aVar.fBg = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fBg.setIsRound(true);
            aVar.fBg.setAutoChangeStyle(false);
            aVar.fBg.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fBh = (TextView) view.findViewById(a.g.intro);
            aVar.aTj = (TextView) view.findViewById(a.g.attention_btn);
            aVar.fQb = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fPX) {
            aVar.fQa.setVisibility(8);
            aVar.fQb.setVisibility(0);
            if (this.fPZ) {
                aVar.fQb.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.fQb.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.fQb.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.fQb.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.fQb.setVisibility(8);
            aVar.fQa.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.dQf, i);
            if (aVar2 != null) {
                aVar.fBg.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fBh.setVisibility(8);
                } else {
                    aVar.fBh.setVisibility(0);
                    aVar.fBh.setText(aVar2.intro);
                }
                b(aVar.aTj, aVar2.byT(), i);
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
        this.fAK = onClickListener;
    }

    public void ar(String str, boolean z) {
        if (this.dQf != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.dQf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.fPV = 1;
                    } else {
                        next.fPV = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView aTj;
        public HeadImageView fBg;
        public TextView fBh;
        public LinearLayout fQa;
        public TextView fQb;
        public TextView mName;

        private a() {
        }
    }
}
