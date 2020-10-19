package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.Date;
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<OfficialBarFeedActivity> {
    private LinearLayout eVN;
    private TextView iTP;
    private View jEQ;
    private BarImageView jER;
    private TextView jES;
    private RelativeLayout jET;
    private OfficialFeedItemImage jEU;
    private OfficialFeedItemBottom jEV;
    private d.c jEW;
    private boolean jEX;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jEW = null;
        this.jEX = z;
        init();
    }

    private void init() {
        this.jER = (BarImageView) findViewById(R.id.bar_icon);
        this.iTP = (TextView) findViewById(R.id.bar_name);
        this.jES = (TextView) findViewById(R.id.message_time);
        this.eVN = (LinearLayout) findViewById(R.id.item_container);
        this.jET = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jEQ = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jEX) {
            this.jEQ.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jES, R.color.cp_cont_d);
        ap.setViewTextColor(this.iTP, R.color.cp_cont_b);
        if (this.jEU != null) {
            this.jEU.cJJ();
        }
        if (this.jEV != null) {
            this.jEV.cJJ();
        }
        if (this.jEX) {
            com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_bg_line_e).oZ(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pa(R.color.cp_shadow_a_alpha16).oY(4369).pb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pc(0).pd(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bf(this.eVN);
        } else {
            com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_bg_line_e).oZ(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pa(R.color.cp_shadow_a_alpha16).oY(4369).pb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pc(0).pd(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bf(this.jEQ);
        }
    }

    public void a(Context context, final a.C0734a c0734a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cV;
        if (c0734a != null) {
            if (this.jEX) {
                this.jER.setVisibility(8);
                this.iTP.setVisibility(8);
                this.jES.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jES.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jES.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jET.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.eVN.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0734a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eVN.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.eVN.setLayoutParams(layoutParams2);
            } else {
                this.jER.setShowOval(true);
                this.jER.setAutoChangeStyle(true);
                this.jER.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jER.setStrokeColorResId(R.color.cp_border_a);
                this.jER.setPlaceHolder(1);
            }
            if (!this.jEX && aVar != null) {
                this.jER.startLoad(aVar.cLL(), 10, false);
                this.iTP.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0734a.createTime * 1000;
            if (this.jEX) {
                cV = k.getTimeStringNoYear(new Date(j));
            } else {
                cV = at.cV(j);
                if (at.Bp(cV)) {
                    cV = at.getFormatTimeShort(j);
                }
            }
            this.jES.setText(cV);
            this.jEV = new OfficialFeedItemBottom(context);
            if (this.jEX) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jEV.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jEV.setData(c0734a, z);
            this.eVN.removeAllViews();
            this.jET.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jEW != null) {
                        b.this.jEW.a(b.this.jET, c0734a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jEU = new OfficialFeedItemImage(context, this.jEX);
                if (this.jEX) {
                    this.jEU.cJK();
                    this.jEV.BW(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.eVN.addView(this.jEU);
                this.eVN.addView(this.jEV);
                this.jEU.setData(c0734a, i, bVar);
            } else {
                if (this.jEX) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.eVN.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jEV.BW(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.eVN.addView(this.jEV);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jEW = cVar;
    }
}
