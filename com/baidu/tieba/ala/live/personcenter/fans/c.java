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
    private Drawable gQw;
    private boolean gQx;
    private View.OnClickListener gwK;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gQx = z;
        this.mSex = i;
        this.gQw = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQv) {
            return 1;
        }
        if (this.eIM == null) {
            return 0;
        }
        return this.eIM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eIM == null) {
            return null;
        }
        return this.eIM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eIM = eVar.blt();
            bVA();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.gQy = (LinearLayout) view.findViewById(a.f.info);
            aVar.gxg = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gxg.setIsRound(true);
            aVar.gxg.setAutoChangeStyle(false);
            aVar.gxg.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gxh = (TextView) view.findViewById(a.f.intro);
            aVar.biN = (TextView) view.findViewById(a.f.attention_btn);
            aVar.gQz = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gQv) {
            aVar.gQy.setVisibility(8);
            aVar.gQz.setVisibility(0);
            if (this.gQx) {
                aVar.gQz.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.gQz.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.gQz.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.gQz.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.gQz.setVisibility(8);
            aVar.gQy.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eIM, i);
            if (aVar2 != null) {
                aVar.gxg.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gxh.setVisibility(8);
                } else {
                    aVar.gxh.setVisibility(0);
                    aVar.gxh.setText(aVar2.intro);
                }
                b(aVar.biN, aVar2.bVz(), i);
            }
        }
        return view;
    }

    private void b(TextView textView, boolean z, int i) {
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.gwK = onClickListener;
    }

    public void az(String str, boolean z) {
        if (this.eIM != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eIM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aOM = 1;
                    } else {
                        next.aOM = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView biN;
        public LinearLayout gQy;
        public TextView gQz;
        public HeadImageView gxg;
        public TextView gxh;
        public TextView mName;

        private a() {
        }
    }
}
