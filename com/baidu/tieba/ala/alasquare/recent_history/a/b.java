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
/* loaded from: classes10.dex */
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
            aVar.gFL = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.gFL.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.gFM = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.enq = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.gFN = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.gFO = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(aVar.title, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.gFM, R.color.CAM_X0109);
            ap.setViewTextColor(aVar.enq, R.color.CAM_X0107);
            ap.setViewTextColor(aVar.gFO, R.color.CAM_X0301);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tN = getItem(i);
        if (tN != null && tN.eJQ != null && tN.eJQ.bnQ() != null && tN.eJQ.boj() != null) {
            MetaData bnQ = tN.eJQ.bnQ();
            aVar.gFL.startLoad(tN.eJQ.boj().cover, 10, false);
            aVar.title.setText(tN.eJQ.getTitle());
            this.gFI = 0;
            aVar.gFN.setVisibility(8);
            aVar.gFO.setVisibility(8);
            if (!y.isEmpty(tN.tagList)) {
                for (b.a aVar2 : tN.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aFY) {
                            aVar.gFN.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gFZ)) {
                                aVar.gFN.setText(aVar2.gFZ);
                            }
                            this.gFI++;
                        } else if (2 == aVar2.aFY) {
                            aVar.gFO.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gFZ)) {
                                aVar.gFO.setText(aVar2.gFZ);
                            }
                            this.gFI++;
                        }
                    }
                }
            }
            String name_show = bnQ.getName_show();
            if (this.gFI <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.enq.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.gFM.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, au.numberUniformFormatExtra(tN.eJQ.boj().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ar arVar = new ar("c12659");
                    arVar.dR("tid", tN.eJQ.getTid());
                    TiebaStatic.log(arVar);
                    b.this.a(b.this.mPageContext, tN.eJQ, "recent_history_living_tab");
                }
            });
            ar arVar = new ar("c12658");
            arVar.dR("tid", tN.eJQ.getTid());
            com.baidu.tieba.ala.alasquare.b.a.bSe().e(arVar);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private static class a {
        public TextView enq;
        public TbImageView gFL;
        public TextView gFM;
        public TextView gFN;
        public TextView gFO;
        public TextView title;

        private a() {
        }
    }
}
