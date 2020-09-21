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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
/* loaded from: classes4.dex */
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
            aVar.fMp = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.fMp.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.fMq = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dBn = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.fMr = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.fMs = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.fMq, R.color.cp_cont_d);
            ap.setViewTextColor(aVar.dBn, R.color.cp_cont_j);
            ap.setViewTextColor(aVar.fMs, R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b sZ = getItem(i);
        if (sZ != null && sZ.dXg != null && sZ.dXg.bfy() != null && sZ.dXg.bfS() != null) {
            MetaData bfy = sZ.dXg.bfy();
            aVar.fMp.startLoad(sZ.dXg.bfS().cover, 10, false);
            aVar.title.setText(sZ.dXg.getTitle());
            this.fMm = 0;
            aVar.fMr.setVisibility(8);
            aVar.fMs.setVisibility(8);
            if (!y.isEmpty(sZ.tagList)) {
                for (b.a aVar2 : sZ.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aDD) {
                            aVar.fMr.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fMC)) {
                                aVar.fMr.setText(aVar2.fMC);
                            }
                            this.fMm++;
                        } else if (2 == aVar2.aDD) {
                            aVar.fMs.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fMC)) {
                                aVar.fMs.setText(aVar2.fMC);
                            }
                            this.fMm++;
                        }
                    }
                }
            }
            String name_show = bfy.getName_show();
            if (this.fMm <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dBn.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.fMq.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, at.numberUniformFormatExtra(sZ.dXg.bfS().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    aq aqVar = new aq("c12659");
                    aqVar.dF("tid", sZ.dXg.getTid());
                    TiebaStatic.log(aqVar);
                    b.this.a(b.this.mPageContext, sZ.dXg, "recent_history_living_tab");
                }
            });
            aq aqVar = new aq("c12658");
            aqVar.dF("tid", sZ.dXg.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bHO().e(aqVar);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView dBn;
        public TbImageView fMp;
        public TextView fMq;
        public TextView fMr;
        public TextView fMs;
        public TextView title;

        private a() {
        }
    }
}
