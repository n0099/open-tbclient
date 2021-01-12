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
    private View.OnClickListener gMj;
    private Drawable hgA;
    private boolean hgB;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hgB = z;
        this.mSex = i;
        this.hgA = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hgz) {
            return 1;
        }
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eTF == null) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eTF = eVar.bmp();
            bXr();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.hgC = (LinearLayout) view.findViewById(a.f.info);
            aVar.gMF = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gMF.setIsRound(true);
            aVar.gMF.setAutoChangeStyle(false);
            aVar.gMF.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gMG = (TextView) view.findViewById(a.f.intro);
            aVar.bih = (TextView) view.findViewById(a.f.attention_btn);
            aVar.hgD = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.hgz) {
            aVar.hgC.setVisibility(8);
            aVar.hgD.setVisibility(0);
            if (this.hgB) {
                aVar.hgD.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.hgD.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.hgD.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.hgD.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.hgD.setVisibility(8);
            aVar.hgC.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eTF, i);
            if (aVar2 != null) {
                aVar.gMF.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gMG.setVisibility(8);
                } else {
                    aVar.gMG.setVisibility(0);
                    aVar.gMG.setText(aVar2.intro);
                }
                b(aVar.bih, aVar2.bXq(), i);
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
        this.gMj = onClickListener;
    }

    public void aB(String str, boolean z) {
        if (this.eTF != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eTF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aMc = 1;
                    } else {
                        next.aMc = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        public TextView bih;
        public HeadImageView gMF;
        public TextView gMG;
        public LinearLayout hgC;
        public TextView hgD;
        public TextView mName;

        private a() {
        }
    }
}
