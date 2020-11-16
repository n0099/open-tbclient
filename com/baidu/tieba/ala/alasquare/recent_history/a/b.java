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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
            aVar.gof = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.gof.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.gog = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.dZV = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.goh = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.goi = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(aVar.title, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.gog, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.dZV, R.color.CAM_X0107);
            ap.setViewTextColor(aVar.goi, R.color.CAM_X0301);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b uy = getItem(i);
        if (uy != null && uy.evQ != null && uy.evQ.blC() != null && uy.evQ.blW() != null) {
            MetaData blC = uy.evQ.blC();
            aVar.gof.startLoad(uy.evQ.blW().cover, 10, false);
            aVar.title.setText(uy.evQ.getTitle());
            this.goc = 0;
            aVar.goh.setVisibility(8);
            aVar.goi.setVisibility(8);
            if (!y.isEmpty(uy.tagList)) {
                for (b.a aVar2 : uy.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aFU) {
                            aVar.goh.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gos)) {
                                aVar.goh.setText(aVar2.gos);
                            }
                            this.goc++;
                        } else if (2 == aVar2.aFU) {
                            aVar.goi.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gos)) {
                                aVar.goi.setText(aVar2.gos);
                            }
                            this.goc++;
                        }
                    }
                }
            }
            String name_show = blC.getName_show();
            if (this.goc <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.dZV.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.gog.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, au.numberUniformFormatExtra(uy.evQ.blW().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ar arVar = new ar("c12659");
                    arVar.dR("tid", uy.evQ.getTid());
                    TiebaStatic.log(arVar);
                    b.this.a(b.this.mPageContext, uy.evQ, "recent_history_living_tab");
                }
            });
            ar arVar = new ar("c12658");
            arVar.dR("tid", uy.evQ.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bOV().e(arVar);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView dZV;
        public TbImageView gof;
        public TextView gog;
        public TextView goh;
        public TextView goi;
        public TextView title;

        private a() {
        }
    }
}
