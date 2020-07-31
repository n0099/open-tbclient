package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.Date;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<BaseActivity> {
    private LinearLayout ewV;
    private View iSi;
    private BarImageView iSj;
    private TextView iSk;
    private RelativeLayout iSl;
    private OfficialFeedItemImage iSm;
    private OfficialFeedItemBottom iSn;
    private d.c iSo;
    private boolean iSp;
    private TextView ijr;

    public b(TbPageContext<BaseActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.iSo = null;
        this.iSp = z;
        init();
    }

    private void init() {
        this.iSj = (BarImageView) findViewById(R.id.bar_icon);
        this.ijr = (TextView) findViewById(R.id.bar_name);
        this.iSk = (TextView) findViewById(R.id.message_time);
        this.ewV = (LinearLayout) findViewById(R.id.item_container);
        this.iSl = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.iSi = findViewById(R.id.official_bar_feed_item_bg);
        if (this.iSp) {
            this.iSi.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iSk, R.color.cp_cont_d);
        ao.setViewTextColor(this.ijr, R.color.cp_cont_b);
        if (this.iSm != null) {
            this.iSm.crB();
        }
        if (this.iSn != null) {
            this.iSn.crB();
        }
        if (this.iSp) {
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_e).ml(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).mo(0).mp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aX(this.ewV);
        } else {
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_e).ml(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).mo(0).mp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aX(this.iSi);
        }
    }

    public void a(Context context, final a.C0667a c0667a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cB;
        if (c0667a != null) {
            if (this.iSp) {
                this.iSj.setVisibility(8);
                this.ijr.setVisibility(8);
                this.iSk.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iSk.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.iSk.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.iSl.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.ewV.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0667a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ewV.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.ewV.setLayoutParams(layoutParams2);
            } else {
                this.iSj.setShowOval(true);
                this.iSj.setAccuracyWith(10.0f);
                this.iSj.setAutoChangeStyle(true);
                this.iSj.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.iSj.setStrokeColorResId(R.color.cp_border_a);
                this.iSj.setPlaceHolder(1);
            }
            if (!this.iSp && aVar != null) {
                this.iSj.startLoad(aVar.ctE(), 10, false);
                this.ijr.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0667a.createTime * 1000;
            if (this.iSp) {
                cB = k.getTimeStringNoYear(new Date(j));
            } else {
                cB = as.cB(j);
                if (as.xS(cB)) {
                    cB = as.getFormatTimeShort(j);
                }
            }
            this.iSk.setText(cB);
            this.iSn = new OfficialFeedItemBottom(context);
            if (this.iSp) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.iSn.setPadding(dimens4, 0, dimens4, 0);
            }
            this.iSn.setData(c0667a, z);
            this.ewV.removeAllViews();
            this.iSl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.iSo != null) {
                        b.this.iSo.a(b.this.iSl, c0667a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.iSm = new OfficialFeedItemImage(context, this.iSp);
                if (this.iSp) {
                    this.iSm.crC();
                    this.iSn.yv(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.ewV.addView(this.iSm);
                this.ewV.addView(this.iSn);
                this.iSm.setData(c0667a, i, bVar);
            } else {
                if (this.iSp) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.ewV.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.iSn.yv(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.ewV.addView(this.iSn);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.iSo = cVar;
    }
}
