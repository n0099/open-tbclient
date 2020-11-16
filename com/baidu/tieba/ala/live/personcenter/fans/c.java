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
    private Drawable gQd;
    private boolean gQe;
    private View.OnClickListener gwr;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mSex;

    public c(TbPageContext tbPageContext, boolean z, int i) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.gQe = z;
        this.mSex = i;
        this.gQd = this.mContext.getResources().getDrawable(a.e.sdk_prc_btn_focus_cross_bg);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gQc) {
            return 1;
        }
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eHj == null) {
            return null;
        }
        return this.eHj.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.eHj = eVar.bkv();
            bUT();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_prc_person_list_item, (ViewGroup) null);
            aVar.gQf = (LinearLayout) view.findViewById(a.f.info);
            aVar.gwN = (HeadImageView) view.findViewById(a.f.photo);
            aVar.gwN.setIsRound(true);
            aVar.gwN.setAutoChangeStyle(false);
            aVar.gwN.setClickable(false);
            aVar.mName = (TextView) view.findViewById(a.f.name);
            aVar.gwO = (TextView) view.findViewById(a.f.intro);
            aVar.bgZ = (TextView) view.findViewById(a.f.attention_btn);
            aVar.gQg = (TextView) view.findViewById(a.f.at_list_nodata);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.gQc) {
            aVar.gQf.setVisibility(8);
            aVar.gQg.setVisibility(0);
            if (this.gQe) {
                aVar.gQg.setText(a.h.sdk_prc_not_have_fans);
            } else if (this.mSex == 2) {
                aVar.gQg.setText(a.h.sdk_prc_her_no_fan_other);
            } else if (this.mSex == 1) {
                aVar.gQg.setText(a.h.sdk_prc_him_no_fan_other);
            } else {
                aVar.gQg.setText(a.h.sdk_prc_no_fan_other);
            }
        } else {
            aVar.gQg.setVisibility(8);
            aVar.gQf.setVisibility(0);
            com.baidu.tieba.ala.live.personcenter.fans.a aVar2 = (com.baidu.tieba.ala.live.personcenter.fans.a) ListUtils.getItem(this.eHj, i);
            if (aVar2 != null) {
                aVar.gwN.startLoad(aVar2.portrait, 12, false);
                aVar.mName.setText(aVar2.getNameShow());
                if (StringHelper.isEmpty(aVar2.intro)) {
                    aVar.gwO.setVisibility(8);
                } else {
                    aVar.gwO.setVisibility(0);
                    aVar.gwO.setText(aVar2.intro);
                }
                b(aVar.bgZ, aVar2.bUS(), i);
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
        this.gwr = onClickListener;
    }

    public void az(String str, boolean z) {
        if (this.eHj != null && str != null) {
            Iterator<com.baidu.tieba.ala.live.personcenter.fans.a> it = this.eHj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tieba.ala.live.personcenter.fans.a next = it.next();
                if (next != null && str.equals(next.userId)) {
                    if (z) {
                        next.aNb = 1;
                    } else {
                        next.aNb = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView bgZ;
        public LinearLayout gQf;
        public TextView gQg;
        public HeadImageView gwN;
        public TextView gwO;
        public TextView mName;

        private a() {
        }
    }
}
