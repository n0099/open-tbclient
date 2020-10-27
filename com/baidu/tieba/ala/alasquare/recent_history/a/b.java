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
            aVar.giL = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.giL.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.giM = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dVL = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.giN = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.giO = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_b);
            ap.setViewTextColor(aVar.giM, R.color.cp_cont_d);
            ap.setViewTextColor(aVar.dVL, R.color.cp_cont_j);
            ap.setViewTextColor(aVar.giO, R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tQ = getItem(i);
        if (tQ != null && tQ.erH != null && tQ.erH.bka() != null && tQ.erH.bku() != null) {
            MetaData bka = tQ.erH.bka();
            aVar.giL.startLoad(tQ.erH.bku().cover, 10, false);
            aVar.title.setText(tQ.erH.getTitle());
            this.giI = 0;
            aVar.giN.setVisibility(8);
            aVar.giO.setVisibility(8);
            if (!y.isEmpty(tQ.tagList)) {
                for (b.a aVar2 : tQ.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aGP) {
                            aVar.giN.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.giY)) {
                                aVar.giN.setText(aVar2.giY);
                            }
                            this.giI++;
                        } else if (2 == aVar2.aGP) {
                            aVar.giO.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.giY)) {
                                aVar.giO.setText(aVar2.giY);
                            }
                            this.giI++;
                        }
                    }
                }
            }
            String name_show = bka.getName_show();
            if (this.giI <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dVL.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.giM.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, at.numberUniformFormatExtra(tQ.erH.bku().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    aq aqVar = new aq("c12659");
                    aqVar.dR("tid", tQ.erH.getTid());
                    TiebaStatic.log(aqVar);
                    b.this.a(b.this.mPageContext, tQ.erH, "recent_history_living_tab");
                }
            });
            aq aqVar = new aq("c12658");
            aqVar.dR("tid", tQ.erH.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bNc().e(aqVar);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView dVL;
        public TbImageView giL;
        public TextView giM;
        public TextView giN;
        public TextView giO;
        public TextView title;

        private a() {
        }
    }
}
