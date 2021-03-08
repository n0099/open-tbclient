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
/* loaded from: classes9.dex */
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
            aVar.gHu = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.gHu.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.gHv = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.eoT = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.gHw = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.gHx = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(aVar.title, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.gHv, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.eoT, R.color.CAM_X0107);
            ap.setViewTextColor(aVar.gHx, R.color.CAM_X0301);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tP = getItem(i);
        if (tP != null && tP.eLr != null && tP.eLr.bnS() != null && tP.eLr.bol() != null) {
            MetaData bnS = tP.eLr.bnS();
            aVar.gHu.startLoad(tP.eLr.bol().cover, 10, false);
            aVar.title.setText(tP.eLr.getTitle());
            this.gHr = 0;
            aVar.gHw.setVisibility(8);
            aVar.gHx.setVisibility(8);
            if (!y.isEmpty(tP.tagList)) {
                for (b.a aVar2 : tP.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aHy) {
                            aVar.gHw.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gHI)) {
                                aVar.gHw.setText(aVar2.gHI);
                            }
                            this.gHr++;
                        } else if (2 == aVar2.aHy) {
                            aVar.gHx.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gHI)) {
                                aVar.gHx.setText(aVar2.gHI);
                            }
                            this.gHr++;
                        }
                    }
                }
            }
            String name_show = bnS.getName_show();
            if (this.gHr <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.eoT.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.gHv.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, au.numberUniformFormatExtra(tP.eLr.bol().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ar arVar = new ar("c12659");
                    arVar.dR("tid", tP.eLr.getTid());
                    TiebaStatic.log(arVar);
                    b.this.a(b.this.mPageContext, tP.eLr, "recent_history_living_tab");
                }
            });
            ar arVar = new ar("c12658");
            arVar.dR("tid", tP.eLr.getTid());
            com.baidu.tieba.ala.alasquare.b.a.bSk().e(arVar);
        }
        return view;
    }

    /* loaded from: classes9.dex */
    private static class a {
        public TextView eoT;
        public TbImageView gHu;
        public TextView gHv;
        public TextView gHw;
        public TextView gHx;
        public TextView title;

        private a() {
        }
    }
}
