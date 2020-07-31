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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
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
            aVar.fxE = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.fxE.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.fxF = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dpg = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.fxG = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.fxH = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ao.setBackgroundColor(view, R.color.cp_bg_line_d);
            ao.setViewTextColor(aVar.title, R.color.cp_cont_b);
            ao.setViewTextColor(aVar.fxF, R.color.cp_cont_d);
            ao.setViewTextColor(aVar.dpg, R.color.cp_cont_j);
            ao.setViewTextColor(aVar.fxH, R.color.cp_cont_h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b qv = getItem(i);
        if (qv != null && qv.dLK != null && qv.dLK.aWl() != null && qv.dLK.aWF() != null) {
            MetaData aWl = qv.dLK.aWl();
            aVar.fxE.startLoad(qv.dLK.aWF().cover, 10, false);
            aVar.title.setText(qv.dLK.getTitle());
            this.fxB = 0;
            aVar.fxG.setVisibility(8);
            aVar.fxH.setVisibility(8);
            if (!x.isEmpty(qv.tagList)) {
                for (b.a aVar2 : qv.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.axP) {
                            aVar.fxG.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fxR)) {
                                aVar.fxG.setText(aVar2.fxR);
                            }
                            this.fxB++;
                        } else if (2 == aVar2.axP) {
                            aVar.fxH.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.fxR)) {
                                aVar.fxH.setText(aVar2.fxR);
                            }
                            this.fxB++;
                        }
                    }
                }
            }
            String name_show = aWl.getName_show();
            if (this.fxB <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dpg.setText(k.byteLength(name_show) > i2 ? as.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.fxF.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, as.numberUniformFormatExtra(qv.dLK.aWF().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ap apVar = new ap("c12659");
                    apVar.dn("tid", qv.dLK.getTid());
                    TiebaStatic.log(apVar);
                    b.this.a(b.this.mPageContext, qv.dLK, "recent_history_living_tab");
                }
            });
            ap apVar = new ap("c12658");
            apVar.dn("tid", qv.dLK.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bxy().e(apVar);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView dpg;
        public TbImageView fxE;
        public TextView fxF;
        public TextView fxG;
        public TextView fxH;
        public TextView title;

        private a() {
        }
    }
}
