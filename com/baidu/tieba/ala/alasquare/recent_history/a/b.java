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
            aVar.eqN = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.eqN.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.eqO = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.cuv = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.eqP = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.eqQ = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.eqO, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.cuv, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.eqQ, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b oL = getItem(i);
        if (oL != null && oL.cRt != null && oL.cRt.aCr() != null && oL.cRt.aCK() != null) {
            MetaData aCr = oL.cRt.aCr();
            aVar.eqN.startLoad(oL.cRt.aCK().cover, 10, false);
            aVar.title.setText(oL.cRt.getTitle());
            this.eqK = 0;
            aVar.eqP.setVisibility(8);
            aVar.eqQ.setVisibility(8);
            if (!v.isEmpty(oL.tagList)) {
                for (b.a aVar2 : oL.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.Xu) {
                            aVar.eqP.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.era)) {
                                aVar.eqP.setText(aVar2.era);
                            }
                            this.eqK++;
                        } else if (2 == aVar2.Xu) {
                            aVar.eqQ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.era)) {
                                aVar.eqQ.setText(aVar2.era);
                            }
                            this.eqK++;
                        }
                    }
                }
            }
            String name_show = aCr.getName_show();
            if (this.eqK <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.cuv.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.eqO.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(oL.cRt.aCK().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.cx("tid", oL.cRt.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, oL.cRt, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.cx("tid", oL.cRt.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bdd().e(anVar);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cuv;
        public TbImageView eqN;
        public TextView eqO;
        public TextView eqP;
        public TextView eqQ;
        public TextView title;

        private a() {
        }
    }
}
