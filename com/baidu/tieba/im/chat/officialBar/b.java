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
    private LinearLayout fej;
    private View jRp;
    private BarImageView jRq;
    private TextView jRr;
    private RelativeLayout jRs;
    private OfficialFeedItemImage jRt;
    private OfficialFeedItemBottom jRu;
    private d.c jRv;
    private boolean jRw;
    private TextView jgl;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jRv = null;
        this.jRw = z;
        init();
    }

    private void init() {
        this.jRq = (BarImageView) findViewById(R.id.bar_icon);
        this.jgl = (TextView) findViewById(R.id.bar_name);
        this.jRr = (TextView) findViewById(R.id.message_time);
        this.fej = (LinearLayout) findViewById(R.id.item_container);
        this.jRs = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jRp = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jRw) {
            this.jRp.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jRr, R.color.cp_cont_d);
        ap.setViewTextColor(this.jgl, R.color.cp_cont_b);
        if (this.jRt != null) {
            this.jRt.cMQ();
        }
        if (this.jRu != null) {
            this.jRu.cMQ();
        }
        if (this.jRw) {
            com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_bg_line_e).pk(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pl(R.color.cp_shadow_a_alpha16).pj(4369).pm(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).po(0).pp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bg(this.fej);
        } else {
            com.baidu.tbadk.core.util.e.a.bpn().pq(R.color.cp_bg_line_e).pk(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pl(R.color.cp_shadow_a_alpha16).pj(4369).pm(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).po(0).pp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bg(this.jRp);
        }
    }

    public void a(Context context, final a.C0750a c0750a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cX;
        if (c0750a != null) {
            if (this.jRw) {
                this.jRq.setVisibility(8);
                this.jgl.setVisibility(8);
                this.jRr.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jRr.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jRr.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jRs.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fej.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0750a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fej.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fej.setLayoutParams(layoutParams2);
            } else {
                this.jRq.setShowOval(true);
                this.jRq.setAutoChangeStyle(true);
                this.jRq.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jRq.setStrokeColorResId(R.color.cp_border_a);
                this.jRq.setPlaceHolder(1);
            }
            if (!this.jRw && aVar != null) {
                this.jRq.startLoad(aVar.cOS(), 10, false);
                this.jgl.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0750a.createTime * 1000;
            if (this.jRw) {
                cX = k.getTimeStringNoYear(new Date(j));
            } else {
                cX = at.cX(j);
                if (at.BI(cX)) {
                    cX = at.getFormatTimeShort(j);
                }
            }
            this.jRr.setText(cX);
            this.jRu = new OfficialFeedItemBottom(context);
            if (this.jRw) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jRu.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jRu.setData(c0750a, z);
            this.fej.removeAllViews();
            this.jRs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jRv != null) {
                        b.this.jRv.a(b.this.jRs, c0750a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jRt = new OfficialFeedItemImage(context, this.jRw);
                if (this.jRw) {
                    this.jRt.cMR();
                    this.jRu.Cp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fej.addView(this.jRt);
                this.fej.addView(this.jRu);
                this.jRt.setData(c0750a, i, bVar);
            } else {
                if (this.jRw) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fej.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jRu.Cp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fej.addView(this.jRu);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jRv = cVar;
    }
}
