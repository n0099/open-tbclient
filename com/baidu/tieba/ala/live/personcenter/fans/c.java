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
    private View.OnClickListener fbL;
    private Drawable fqK;
    private boolean fqL;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fqL = z;
        this.mSex = i;
        this.fqK = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqJ) {
            return 1;
        }
        if (this.dvu == null) {
            return 0;
        }
        return this.dvu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvu == null) {
            return null;
        }
        return this.dvu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.dvu = eVar.aJB();
            bqe();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.fqM = (LinearLayout) view.findViewById(a.g.info);
            aVar.fch = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fch.setIsRound(true);
            aVar.fch.setAutoChangeStyle(false);
            aVar.fch.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fci = (TextView) view.findViewById(a.g.intro);
            aVar.aKP = (TextView) view.findViewById(a.g.attention_btn);
            aVar.fqN = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fqJ) {
            aVar.fqM.setVisibility(8);
            aVar.fqN.setVisibility(0);
            if (this.fqL) {
                aVar.fqN.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.fqN.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.fqN.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.fqN.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.fqN.setVisibility(8);
            aVar.fqM.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.dvu, i);
            if (aVar2 != null) {
                aVar.fch.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fci.setVisibility(8);
                } else {
                    aVar.fci.setVisibility(0);
                    aVar.fci.setText(aVar2.intro);
                }
                b(aVar.aKP, aVar2.bqd(), i);
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
        this.fbL = onClickListener;
    }

    public void ac(String str, boolean z) {
        if (this.dvu != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.dvu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.fqH = 1;
                    } else {
                        next.fqH = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView aKP;
        public HeadImageView fch;
        public TextView fci;
        public LinearLayout fqM;
        public TextView fqN;
        public TextView mName;

        private a() {
        }
    }
}
