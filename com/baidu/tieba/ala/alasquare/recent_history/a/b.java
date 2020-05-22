package com.baidu.tieba.ala.alasquare.recent_history.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            aVar.fgX = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.fgX.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.fgY = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dez = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.fgZ = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.fha = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fgY, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.dez, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.fha, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b pF = getItem(i);
        if (pF != null && pF.dEA != null && pF.dEA.aQx() != null && pF.dEA.aQS() != null) {
            MetaData aQx = pF.dEA.aQx();
            aVar.fgX.startLoad(pF.dEA.aQS().cover, 10, false);
            aVar.title.setText(pF.dEA.getTitle());
            this.fgU = 0;
            aVar.fgZ.setVisibility(8);
            aVar.fha.setVisibility(8);
            if (!v.isEmpty(pF.tagList)) {
                for (b.a aVar2 : pF.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.auw) {
                            aVar.fgZ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fhk)) {
                                aVar.fgZ.setText(aVar2.fhk);
                            }
                            this.fgU++;
                        } else if (2 == aVar2.auw) {
                            aVar.fha.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fhk)) {
                                aVar.fha.setText(aVar2.fhk);
                            }
                            this.fgU++;
                        }
                    }
                }
            }
            String name_show = aQx.getName_show();
            if (this.fgU <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dez.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.fgY.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(pF.dEA.aQS().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.dh("tid", pF.dEA.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, pF.dEA, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.dh("tid", pF.dEA.getTid());
            com.baidu.tieba.ala.alasquare.c.a.brq().e(anVar);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView dez;
        public TbImageView fgX;
        public TextView fgY;
        public TextView fgZ;
        public TextView fha;
        public TextView title;

        private a() {
        }
    }
}
