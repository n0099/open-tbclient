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
            aVar.eqe = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.eqe.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.eqf = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.cuh = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.eqg = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.eqh = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            am.setViewTextColor(aVar.eqf, (int) R.color.cp_cont_d);
            am.setViewTextColor(aVar.cuh, (int) R.color.cp_cont_j);
            am.setViewTextColor(aVar.eqh, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b oJ = getItem(i);
        if (oJ != null && oJ.cRf != null && oJ.cRf.aCo() != null && oJ.cRf.aCH() != null) {
            MetaData aCo = oJ.cRf.aCo();
            aVar.eqe.startLoad(oJ.cRf.aCH().cover, 10, false);
            aVar.title.setText(oJ.cRf.getTitle());
            this.eqb = 0;
            aVar.eqg.setVisibility(8);
            aVar.eqh.setVisibility(8);
            if (!v.isEmpty(oJ.tagList)) {
                for (b.a aVar2 : oJ.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.Xk) {
                            aVar.eqg.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.eqr)) {
                                aVar.eqg.setText(aVar2.eqr);
                            }
                            this.eqb++;
                        } else if (2 == aVar2.Xk) {
                            aVar.eqh.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.eqr)) {
                                aVar.eqh.setText(aVar2.eqr);
                            }
                            this.eqb++;
                        }
                    }
                }
            }
            String name_show = aCo.getName_show();
            if (this.eqb <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.cuh.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.eqf.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, aq.numberUniformFormatExtra(oJ.cRf.aCH().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    an anVar = new an("c12659");
                    anVar.cy("tid", oJ.cRf.getTid());
                    TiebaStatic.log(anVar);
                    b.this.a(b.this.mPageContext, oJ.cRf, "recent_history_living_tab");
                }
            });
            an anVar = new an("c12658");
            anVar.cy("tid", oJ.cRf.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bcX().d(anVar);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView cuh;
        public TbImageView eqe;
        public TextView eqf;
        public TextView eqg;
        public TextView eqh;
        public TextView title;

        private a() {
        }
    }
}
