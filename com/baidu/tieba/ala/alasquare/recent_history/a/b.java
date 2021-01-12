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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
            aVar.gCN = (TbImageView) view.findViewById(R.id.recent_history_living_img);
            aVar.gCN.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            aVar.title = (TextView) view.findViewById(R.id.recent_history_living_title);
            aVar.gCO = (TextView) view.findViewById(R.id.recent_history_living_audience_count);
            aVar.eli = (TextView) view.findViewById(R.id.recent_history_living_user_name);
            aVar.gCP = (TextView) view.findViewById(R.id.recent_history_living_living_tag);
            aVar.gCQ = (TextView) view.findViewById(R.id.recent_history_living_send_gift_tag);
            ao.setBackgroundColor(view, R.color.CAM_X0201);
            ao.setViewTextColor(aVar.title, R.color.CAM_X0105);
            ao.setViewTextColor(aVar.gCO, R.color.CAM_X0109);
            ao.setViewTextColor(aVar.eli, R.color.CAM_X0107);
            ao.setViewTextColor(aVar.gCQ, R.color.CAM_X0301);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tH = getItem(i);
        if (tH != null && tH.eHK != null && tH.eHK.bnx() != null && tH.eHK.bnQ() != null) {
            MetaData bnx = tH.eHK.bnx();
            aVar.gCN.startLoad(tH.eHK.bnQ().cover, 10, false);
            aVar.title.setText(tH.eHK.getTitle());
            this.gCK = 0;
            aVar.gCP.setVisibility(8);
            aVar.gCQ.setVisibility(8);
            if (!x.isEmpty(tH.tagList)) {
                for (b.a aVar2 : tH.tagList) {
                    if (aVar2 != null) {
                        if (1 == aVar2.aEl) {
                            aVar.gCP.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gDb)) {
                                aVar.gCP.setText(aVar2.gDb);
                            }
                            this.gCK++;
                        } else if (2 == aVar2.aEl) {
                            aVar.gCQ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar2.gDb)) {
                                aVar.gCQ.setText(aVar2.gDb);
                            }
                            this.gCK++;
                        }
                    }
                }
            }
            String name_show = bnx.getName_show();
            if (this.gCK <= 1) {
                i2 = 14;
            } else {
                i2 = 13;
            }
            aVar.eli.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            aVar.gCO.setText(this.mContext.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, at.numberUniformFormatExtra(tH.eHK.bnQ().audience_count)));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    aq aqVar = new aq("c12659");
                    aqVar.dW("tid", tH.eHK.getTid());
                    TiebaStatic.log(aqVar);
                    b.this.a(b.this.mPageContext, tH.eHK, "recent_history_living_tab");
                }
            });
            aq aqVar = new aq("c12658");
            aqVar.dW("tid", tH.eHK.getTid());
            com.baidu.tieba.ala.alasquare.b.a.bRu().e(aqVar);
        }
        return view;
    }

    /* loaded from: classes9.dex */
    private static class a {
        public TextView eli;
        public TbImageView gCN;
        public TextView gCO;
        public TextView gCP;
        public TextView gCQ;
        public TextView title;

        private a() {
        }
    }
}
