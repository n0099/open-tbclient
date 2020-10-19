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
    private View.OnClickListener ggT;
    private Drawable gyW;
    private boolean gyX;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gyX = z;
        this.mSex = i;
        this.gyW = this.mContext.getResources().getDrawable(a.f.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyV) {
            return 1;
        }
        if (this.euy == null) {
            return 0;
        }
        return this.euy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.euy == null) {
            return null;
        }
        return this.euy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.euy = eVar.bha();
            bQe();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.gyY = (LinearLayout) view.findViewById(a.g.info);
            aVar.ghp = (HeadImageView) view.findViewById(a.g.photo);
            aVar.ghp.setIsRound(true);
            aVar.ghp.setAutoChangeStyle(false);
            aVar.ghp.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.g.name);
            aVar.ghq = (TextView) view.findViewById(a.g.intro);
            aVar.bgc = (TextView) view.findViewById(a.g.attention_btn);
            aVar.gyZ = (TextView) view.findViewById(a.g.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gyV) {
            aVar.gyY.setVisibility(8);
            aVar.gyZ.setVisibility(0);
            if (this.gyX) {
                aVar.gyZ.setText(a.i.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.gyZ.setText(a.i.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.gyZ.setText(a.i.sdk_prc_him_no_fan_other);
            } else {
                aVar.gyZ.setText(a.i.sdk_prc_no_fan_other);
            }
        } else {
            aVar.gyZ.setVisibility(8);
            aVar.gyY.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.euy, i);
            if (aVar2 != null) {
                aVar.ghp.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.ghq.setVisibility(8);
                } else {
                    aVar.ghq.setVisibility(0);
                    aVar.ghq.setText(aVar2.intro);
                }
                b(aVar.bgc, aVar2.bQd(), i);
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
        this.ggT = onClickListener;
    }

    public void ax(String str, boolean z) {
        if (this.euy != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.euy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aNe = 1;
                    } else {
                        next.aNe = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView bgc;
        public HeadImageView ghp;
        public TextView ghq;
        public LinearLayout gyY;
        public TextView gyZ;
        public TextView mName;

        private a() {
        }
    }
}
