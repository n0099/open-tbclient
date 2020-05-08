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
            aVar.eUp = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.eUp.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.eUq = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.cTw = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.eUr = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.eUs = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.eUq, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.cTw, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.eUs, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b pe = getItem(i);
        if (pe != null && pe.dqE != null && pe.dqE.aKC() != null && pe.dqE.aKV() != null) {
            MetaData aKC = pe.dqE.aKC();
            aVar.eUp.startLoad(pe.dqE.aKV().cover, 10, false);
            aVar.title.setText(pe.dqE.getTitle());
            this.eUm = 0;
            aVar.eUr.setVisibility(8);
            aVar.eUs.setVisibility(8);
            if (!v.isEmpty(pe.tagList)) {
                for (b.a aVar2 : pe.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.apD) {
                            aVar.eUr.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.eUC)) {
                                aVar.eUr.setText(aVar2.eUC);
                            }
                            this.eUm++;
                        } else if (2 == aVar2.apD) {
                            aVar.eUs.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.eUC)) {
                                aVar.eUs.setText(aVar2.eUC);
                            }
                            this.eUm++;
                        }
                    }
                }
            }
            String name_show = aKC.getName_show();
            if (this.eUm <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.cTw.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.eUq.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(pe.dqE.aKV().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.cI("tid", pe.dqE.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, pe.dqE, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.cI("tid", pe.dqE.getTid());
            com.baidu.tieba.ala.alasquare.c.a.blS().e(anVar);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cTw;
        public TbImageView eUp;
        public TextView eUq;
        public TextView eUr;
        public TextView eUs;
        public TextView title;

        private a() {
        }
    }
}
