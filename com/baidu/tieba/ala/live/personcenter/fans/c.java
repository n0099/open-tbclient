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
    private Drawable fEE;
    private boolean fEF;
    private View.OnClickListener fpn;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fEF = z;
        this.mSex = i;
        this.fEE = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fED) {
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
            bvW();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.fEG = (LinearLayout) view.findViewById(a.g.info);
            aVar.fpK = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fpK.setIsRound(true);
            aVar.fpK.setAutoChangeStyle(false);
            aVar.fpK.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fpL = (TextView) view.findViewById(a.g.intro);
            aVar.aQD = (TextView) view.findViewById(a.g.attention_btn);
            aVar.fEH = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fED) {
            aVar.fEG.setVisibility(8);
            aVar.fEH.setVisibility(0);
            if (this.fEF) {
                aVar.fEH.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.fEH.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.fEH.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.fEH.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.fEH.setVisibility(8);
            aVar.fEG.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.dJp, i);
            if (aVar2 != null) {
                aVar.fpK.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fpL.setVisibility(8);
                } else {
                    aVar.fpL.setVisibility(0);
                    aVar.fpL.setText(aVar2.intro);
                }
                b(aVar.aQD, aVar2.bvV(), i);
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
        this.fpn = onClickListener;
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
                        next.fEB = 1;
                    } else {
                        next.fEB = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView aQD;
        public LinearLayout fEG;
        public TextView fEH;
        public HeadImageView fpK;
        public TextView fpL;
        public TextView mName;

        private a() {
        }
    }
}
