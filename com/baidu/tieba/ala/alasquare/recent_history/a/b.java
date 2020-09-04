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
            aVar.fJa = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.fJa.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.fJb = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dzm = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.fJc = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.fJd = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            ap.setViewTextColor(aVar.fJb, (int) R.color.cp_cont_d);
            ap.setViewTextColor(aVar.dzm, (int) R.color.cp_cont_j);
            ap.setViewTextColor(aVar.fJd, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b sH = getItem(i);
        if (sH != null && sH.dUW != null && sH.dUW.beE() != null && sH.dUW.beY() != null) {
            MetaData beE = sH.dUW.beE();
            aVar.fJa.startLoad(sH.dUW.beY().cover, 10, false);
            aVar.title.setText(sH.dUW.getTitle());
            this.fIX = 0;
            aVar.fJc.setVisibility(8);
            aVar.fJd.setVisibility(8);
            if (!y.isEmpty(sH.tagList)) {
                for (b.a aVar2 : sH.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aCT) {
                            aVar.fJc.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fJn)) {
                                aVar.fJc.setText(aVar2.fJn);
                            }
                            this.fIX++;
                        } else if (2 == aVar2.aCT) {
                            aVar.fJd.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fJn)) {
                                aVar.fJd.setText(aVar2.fJn);
                            }
                            this.fIX++;
                        }
                    }
                }
            }
            String name_show = beE.getName_show();
            if (this.fIX <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dzm.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.fJb.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, at.numberUniformFormatExtra(sH.dUW.beY().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    aq aqVar = new aq("c12659");
                    aqVar.dD("tid", sH.dUW.getTid());
                    TiebaStatic.log(aqVar);
                    b.this.a(b.this.mPageContext, sH.dUW, "recent_history_living_tab");
                }
            });
            aq aqVar = new aq("c12658");
            aqVar.dD("tid", sH.dUW.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bGy().e(aqVar);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView dzm;
        public TbImageView fJa;
        public TextView fJb;
        public TextView fJc;
        public TextView fJd;
        public TextView title;

        private a() {
        }
    }
}
