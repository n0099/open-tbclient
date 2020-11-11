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
    private LinearLayout fkc;
    private View jXm;
    private BarImageView jXn;
    private TextView jXo;
    private RelativeLayout jXp;
    private OfficialFeedItemImage jXq;
    private OfficialFeedItemBottom jXr;
    private d.c jXs;
    private boolean jXt;
    private TextView jmj;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jXs = null;
        this.jXt = z;
        init();
    }

    private void init() {
        this.jXn = (BarImageView) findViewById(R.id.bar_icon);
        this.jmj = (TextView) findViewById(R.id.bar_name);
        this.jXo = (TextView) findViewById(R.id.message_time);
        this.fkc = (LinearLayout) findViewById(R.id.item_container);
        this.jXp = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jXm = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jXt) {
            this.jXm.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jXo, R.color.cp_cont_d);
        ap.setViewTextColor(this.jmj, R.color.cp_cont_b);
        if (this.jXq != null) {
            this.jXq.cPr();
        }
        if (this.jXr != null) {
            this.jXr.cPr();
        }
        if (this.jXt) {
            com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_bg_line_e).pv(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pw(R.color.cp_shadow_a_alpha16).pu(4369).px(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).py(0).pz(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bk(this.fkc);
        } else {
            com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_bg_line_e).pv(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pw(R.color.cp_shadow_a_alpha16).pu(4369).px(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).py(0).pz(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bk(this.jXm);
        }
    }

    public void a(Context context, final a.C0764a c0764a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dt;
        if (c0764a != null) {
            if (this.jXt) {
                this.jXn.setVisibility(8);
                this.jmj.setVisibility(8);
                this.jXo.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jXo.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jXo.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jXp.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fkc.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0764a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fkc.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fkc.setLayoutParams(layoutParams2);
            } else {
                this.jXn.setShowOval(true);
                this.jXn.setAutoChangeStyle(true);
                this.jXn.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jXn.setStrokeColorResId(R.color.cp_border_a);
                this.jXn.setPlaceHolder(1);
            }
            if (!this.jXt && aVar != null) {
                this.jXn.startLoad(aVar.cRt(), 10, false);
                this.jmj.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0764a.createTime * 1000;
            if (this.jXt) {
                dt = k.getTimeStringNoYear(new Date(j));
            } else {
                dt = at.dt(j);
                if (at.BW(dt)) {
                    dt = at.getFormatTimeShort(j);
                }
            }
            this.jXo.setText(dt);
            this.jXr = new OfficialFeedItemBottom(context);
            if (this.jXt) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jXr.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jXr.setData(c0764a, z);
            this.fkc.removeAllViews();
            this.jXp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jXs != null) {
                        b.this.jXs.a(b.this.jXp, c0764a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jXq = new OfficialFeedItemImage(context, this.jXt);
                if (this.jXt) {
                    this.jXq.cPs();
                    this.jXr.CC(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fkc.addView(this.jXq);
                this.fkc.addView(this.jXr);
                this.jXq.setData(c0764a, i, bVar);
            } else {
                if (this.jXt) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fkc.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jXr.CC(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fkc.addView(this.jXr);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jXs = cVar;
    }
}
