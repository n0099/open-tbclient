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
/* loaded from: classes7.dex */
public class c extends b {
    private View.OnClickListener fRl;
    private Drawable ghq;
    private boolean ghr;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.ghr = z;
        this.mSex = i;
        this.ghq = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ghp) {
            return 1;
        }
        if (this.efX == null) {
            return 0;
        }
        return this.efX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efX == null) {
            return null;
        }
        return this.efX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.efX = eVar.bdx();
            bLC();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.ghs = (LinearLayout) view.findViewById(a.g.info);
            aVar.fRH = (HeadImageView) view.findViewById(a.g.photo);
            aVar.fRH.setIsRound(true);
            aVar.fRH.setAutoChangeStyle(false);
            aVar.fRH.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.fRI = (TextView) view.findViewById(a.g.intro);
            aVar.aZQ = (TextView) view.findViewById(a.g.attention_btn);
            aVar.ght = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.ghp) {
            aVar.ghs.setVisibility(8);
            aVar.ght.setVisibility(0);
            if (this.ghr) {
                aVar.ght.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.ght.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.ght.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.ght.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.ght.setVisibility(8);
            aVar.ghs.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.efX, i);
            if (aVar2 != null) {
                aVar.fRH.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.fRI.setVisibility(8);
                } else {
                    aVar.fRI.setVisibility(0);
                    aVar.fRI.setText(aVar2.intro);
                }
                b(aVar.aZQ, aVar2.bLB(), i);
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
        this.fRl = onClickListener;
    }

    public void at(String str, boolean z) {
        if (this.efX != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.efX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.ghn = 1;
                    } else {
                        next.ghn = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    private static class a {
        public TextView aZQ;
        public HeadImageView fRH;
        public TextView fRI;
        public LinearLayout ghs;
        public TextView ght;
        public TextView mName;

        private a() {
        }
    }
}
