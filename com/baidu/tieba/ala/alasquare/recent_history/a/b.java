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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
            aVar.fsw = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.fsw.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.fsx = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.djl = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.fsy = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.fsz = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            an.setBackgroundColor(view, R.color.cp_bg_line_d);
            an.setViewTextColor(aVar.title, (int) R.color.cp_cont_b);
            an.setViewTextColor(aVar.fsx, (int) R.color.cp_cont_d);
            an.setViewTextColor(aVar.djl, (int) R.color.cp_cont_j);
            an.setViewTextColor(aVar.fsz, (int) R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b qg = getItem(i);
        if (qg != null && qg.dLi != null && qg.dLi.aSp() != null && qg.dLi.aSJ() != null) {
            MetaData aSp = qg.dLi.aSp();
            aVar.fsw.startLoad(qg.dLi.aSJ().cover, 10, false);
            aVar.title.setText(qg.dLi.getTitle());
            this.fst = 0;
            aVar.fsy.setVisibility(8);
            aVar.fsz.setVisibility(8);
            if (!w.isEmpty(qg.tagList)) {
                for (b.a aVar2 : qg.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.awC) {
                            aVar.fsy.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fsJ)) {
                                aVar.fsy.setText(aVar2.fsJ);
                            }
                            this.fst++;
                        } else if (2 == aVar2.awC) {
                            aVar.fsz.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fsJ)) {
                                aVar.fsz.setText(aVar2.fsJ);
                            }
                            this.fst++;
                        }
                    }
                }
            }
            String name_show = aSp.getName_show();
            if (this.fst <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.djl.setText(k.byteLength(name_show) > i2 ? ar.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.fsx.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, ar.numberUniformFormatExtra(qg.dLi.aSJ().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ao aoVar = new ao("c12659");
                    aoVar.dk("tid", qg.dLi.getTid());
                    TiebaStatic.log(aoVar);
                    b.this.a(b.this.mPageContext, qg.dLi, "recent_history_living_tab");
                }
            });
            ao aoVar = new ao("c12658");
            aoVar.dk("tid", qg.dLi.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bup().e(aoVar);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private static class a {
        public TextView djl;
        public TbImageView fsw;
        public TextView fsx;
        public TextView fsy;
        public TextView fsz;
        public TextView title;

        private a() {
        }
    }
}
