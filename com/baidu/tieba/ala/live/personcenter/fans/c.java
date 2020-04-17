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
    private View.OnClickListener fbG;
    private Drawable fqF;
    private boolean fqG;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.fqG = z;
        this.mSex = i;
        this.fqF = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fqE) {
            return 1;
        }
        if (this.dvq == null) {
            return 0;
        }
        return this.dvq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dvq == null) {
            return null;
        }
        return this.dvq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.dvq = eVar.aJD();
            bqg();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.fqH = (LinearLayout) view.findViewById(a.g.info);
            aVar.fcc = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fcc.setIsRound(true);
            aVar.fcc.setAutoChangeStyle(false);
            aVar.fcc.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fcd = (TextView) view.findViewById(a.g.intro);
            aVar.aKJ = (TextView) view.findViewById(a.g.attention_btn);
            aVar.fqI = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.fqE) {
            aVar.fqH.setVisibility(8);
            aVar.fqI.setVisibility(0);
            if (this.fqG) {
                aVar.fqI.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.fqI.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.fqI.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.fqI.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.fqI.setVisibility(8);
            aVar.fqH.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.dvq, i);
            if (aVar2 != null) {
                aVar.fcc.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fcd.setVisibility(8);
                } else {
                    aVar.fcd.setVisibility(0);
                    aVar.fcd.setText(aVar2.intro);
                }
                b(aVar.aKJ, aVar2.bqf(), i);
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
        this.fbG = onClickListener;
    }

    public void ac(String str, boolean z) {
        if (this.dvq != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.dvq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.fqC = 1;
                    } else {
                        next.fqC = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView aKJ;
        public HeadImageView fcc;
        public TextView fcd;
        public LinearLayout fqH;
        public TextView fqI;
        public TextView mName;

        private a() {
        }
    }
}
