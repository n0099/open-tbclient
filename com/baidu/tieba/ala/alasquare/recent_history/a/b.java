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
            aVar.gwo = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.gwo.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.gwp = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.egV = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.gwq = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.gwr = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(aVar.title, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.gwp, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.egV, R.color.CAM_X0107);
            ap.setViewTextColor(aVar.gwr, R.color.CAM_X0301);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b vc = getItem(i);
        if (vc != null && vc.eCR != null && vc.eCR.boP() != null && vc.eCR.bpj() != null) {
            MetaData boP = vc.eCR.boP();
            aVar.gwo.startLoad(vc.eCR.bpj().cover, 10, false);
            aVar.title.setText(vc.eCR.getTitle());
            this.gwl = 0;
            aVar.gwq.setVisibility(8);
            aVar.gwr.setVisibility(8);
            if (!y.isEmpty(vc.tagList)) {
                for (b.a aVar2 : vc.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aIC) {
                            aVar.gwq.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gwB)) {
                                aVar.gwq.setText(aVar2.gwB);
                            }
                            this.gwl++;
                        } else if (2 == aVar2.aIC) {
                            aVar.gwr.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gwB)) {
                                aVar.gwr.setText(aVar2.gwB);
                            }
                            this.gwl++;
                        }
                    }
                }
            }
            String name_show = boP.getName_show();
            if (this.gwl <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.egV.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.gwp.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, au.numberUniformFormatExtra(vc.eCR.bpj().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ar arVar = new ar("c12659");
                    arVar.dY("tid", vc.eCR.getTid());
                    TiebaStatic.log(arVar);
                    b.this.a(b.this.mPageContext, vc.eCR, "recent_history_living_tab");
                }
            });
            ar arVar = new ar("c12658");
            arVar.dY("tid", vc.eCR.getTid());
            com.baidu.tieba.ala.alasquare.c.a.bSG().e(arVar);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView egV;
        public TbImageView gwo;
        public TextView gwp;
        public TextView gwq;
        public TextView gwr;
        public TextView title;

        private a() {
        }
    }
}
