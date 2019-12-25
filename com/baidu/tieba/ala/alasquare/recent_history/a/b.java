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
            aVar.ekT = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.ekT.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.ekU = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.cpT = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.ekV = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.ekW = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.ekU, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.cpT, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.ekW, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b or = getItem(i);
        if (or != null && or.cMR != null && or.cMR.azE() != null && or.cMR.azX() != null) {
            MetaData azE = or.cMR.azE();
            aVar.ekT.startLoad(or.cMR.azX().cover, 10, false);
            aVar.title.setText(or.cMR.getTitle());
            this.ekQ = 0;
            aVar.ekV.setVisibility(8);
            aVar.ekW.setVisibility(8);
            if (!v.isEmpty(or.tagList)) {
                for (b.a aVar2 : or.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.Vo) {
                            aVar.ekV.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.elg)) {
                                aVar.ekV.setText(aVar2.elg);
                            }
                            this.ekQ++;
                        } else if (2 == aVar2.Vo) {
                            aVar.ekW.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.elg)) {
                                aVar.ekW.setText(aVar2.elg);
                            }
                            this.ekQ++;
                        }
                    }
                }
            }
            String name_show = azE.getName_show();
            if (this.ekQ <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.cpT.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.ekU.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(or.cMR.azX().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.cp("tid", or.cMR.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, or.cMR, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.cp("tid", or.cMR.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bal().c(anVar);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView cpT;
        public TbImageView ekT;
        public TextView ekU;
        public TextView ekV;
        public TextView ekW;
        public TextView title;

        private a() {
        }
    }
}
