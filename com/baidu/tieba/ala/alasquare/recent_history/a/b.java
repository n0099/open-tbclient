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
/* loaded from: classes6.dex */
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
            aVar.dzT = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.dzT.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.dzU = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.bFm = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.dzV = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.dzW = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.dzU, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.bFm, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.dzW, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b mi = getItem(i);
        if (mi != null && mi.caz != null && mi.caz.aiE() != null && mi.caz.aiX() != null) {
            MetaData aiE = mi.caz.aiE();
            aVar.dzT.startLoad(mi.caz.aiX().cover, 10, false);
            aVar.title.setText(mi.caz.getTitle());
            this.dzQ = 0;
            aVar.dzV.setVisibility(8);
            aVar.dzW.setVisibility(8);
            if (!v.isEmpty(mi.tagList)) {
                for (b.a aVar2 : mi.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.Oo) {
                            aVar.dzV.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.dAh)) {
                                aVar.dzV.setText(aVar2.dAh);
                            }
                            this.dzQ++;
                        } else if (2 == aVar2.Oo) {
                            aVar.dzW.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.dAh)) {
                                aVar.dzW.setText(aVar2.dAh);
                            }
                            this.dzQ++;
                        }
                    }
                }
            }
            String name_show = aiE.getName_show();
            if (this.dzQ <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.bFm.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.dzU.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(mi.caz.aiX().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.bS("tid", mi.caz.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, mi.caz, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.bS("tid", mi.caz.getTid());
            com.baidu.tieba.ala.alasquare.c.a.aJM().c(anVar);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView bFm;
        public TbImageView dzT;
        public TextView dzU;
        public TextView dzV;
        public TextView dzW;
        public TextView title;

        private a() {
        }
    }
}
