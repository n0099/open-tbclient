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
            aVar.fhi = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.fhi.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.fhj = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dez = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.fhk = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.fhl = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.fhj, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.dez, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.fhl, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b pH = getItem(i);
        if (pH != null && pH.dEA != null && pH.dEA.aQx() != null && pH.dEA.aQS() != null) {
            MetaData aQx = pH.dEA.aQx();
            aVar.fhi.startLoad(pH.dEA.aQS().cover, 10, false);
            aVar.title.setText(pH.dEA.getTitle());
            this.fhf = 0;
            aVar.fhk.setVisibility(8);
            aVar.fhl.setVisibility(8);
            if (!v.isEmpty(pH.tagList)) {
                for (b.a aVar2 : pH.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.auw) {
                            aVar.fhk.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fhv)) {
                                aVar.fhk.setText(aVar2.fhv);
                            }
                            this.fhf++;
                        } else if (2 == aVar2.auw) {
                            aVar.fhl.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fhv)) {
                                aVar.fhl.setText(aVar2.fhv);
                            }
                            this.fhf++;
                        }
                    }
                }
            }
            String name_show = aQx.getName_show();
            if (this.fhf <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dez.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.fhj.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(pH.dEA.aQS().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.dh("tid", pH.dEA.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, pH.dEA, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.dh("tid", pH.dEA.getTid());
            com.baidu.tieba.ala.alasquare.c.a.brs().e(anVar);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView dez;
        public TbImageView fhi;
        public TextView fhj;
        public TextView fhk;
        public TextView fhl;
        public TextView title;

        private a() {
        }
    }
}
