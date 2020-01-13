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
/* loaded from: classes2.dex */
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
            aVar.elP = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.elP.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.elQ = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.cqf = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.elR = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.elS = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.elQ, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.cqf, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.elS, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b os = getItem(i);
        if (os != null && os.cNb != null && os.cNb.azX() != null && os.cNb.aAq() != null) {
            MetaData azX = os.cNb.azX();
            aVar.elP.startLoad(os.cNb.aAq().cover, 10, false);
            aVar.title.setText(os.cNb.getTitle());
            this.elM = 0;
            aVar.elR.setVisibility(8);
            aVar.elS.setVisibility(8);
            if (!v.isEmpty(os.tagList)) {
                for (b.a aVar2 : os.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.VE) {
                            aVar.elR.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.emc)) {
                                aVar.elR.setText(aVar2.emc);
                            }
                            this.elM++;
                        } else if (2 == aVar2.VE) {
                            aVar.elS.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.emc)) {
                                aVar.elS.setText(aVar2.emc);
                            }
                            this.elM++;
                        }
                    }
                }
            }
            String name_show = azX.getName_show();
            if (this.elM <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.cqf.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.elQ.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(os.cNb.aAq().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.cp("tid", os.cNb.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, os.cNb, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.cp("tid", os.cNb.getTid());
            com.baidu.tieba.ala.alasquare.c.a.baG().c(anVar);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView cqf;
        public TbImageView elP;
        public TextView elQ;
        public TextView elR;
        public TextView elS;
        public TextView title;

        private a() {
        }
    }
}
