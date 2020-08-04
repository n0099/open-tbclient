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
    private View iSk;
    private BarImageView iSl;
    private TextView iSm;
    private RelativeLayout iSn;
    private OfficialFeedItemImage iSo;
    private OfficialFeedItemBottom iSp;
    private d.c iSq;
    private boolean iSr;
    private TextView ijt;

    public b(TbPageContext<BaseActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.iSq = null;
        this.iSr = z;
        init();
    }

    private void init() {
        this.iSl = (BarImageView) findViewById(R.id.bar_icon);
        this.ijt = (TextView) findViewById(R.id.bar_name);
        this.iSm = (TextView) findViewById(R.id.message_time);
        this.ewV = (LinearLayout) findViewById(R.id.item_container);
        this.iSn = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.iSk = findViewById(R.id.official_bar_feed_item_bg);
        if (this.iSr) {
            this.iSk.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iSm, R.color.cp_cont_d);
        ao.setViewTextColor(this.ijt, R.color.cp_cont_b);
        if (this.iSo != null) {
            this.iSo.crB();
        }
        if (this.iSp != null) {
            this.iSp.crB();
        }
        if (this.iSr) {
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_e).ml(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).mo(0).mp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aX(this.ewV);
        } else {
            com.baidu.tbadk.core.util.e.a.bbq().mq(R.color.cp_bg_line_e).ml(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).mm(R.color.cp_shadow_a_alpha16).mk(4369).mn(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).mo(0).mp(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aX(this.iSk);
        }
    }

    public void a(Context context, final a.C0667a c0667a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cB;
        if (c0667a != null) {
            if (this.iSr) {
                this.iSl.setVisibility(8);
                this.ijt.setVisibility(8);
                this.iSm.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iSm.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.iSm.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.iSn.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.ewV.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0667a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ewV.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.ewV.setLayoutParams(layoutParams2);
            } else {
                this.iSl.setShowOval(true);
                this.iSl.setAccuracyWith(10.0f);
                this.iSl.setAutoChangeStyle(true);
                this.iSl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.iSl.setStrokeColorResId(R.color.cp_border_a);
                this.iSl.setPlaceHolder(1);
            }
            if (!this.iSr && aVar != null) {
                this.iSl.startLoad(aVar.ctE(), 10, false);
                this.ijt.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0667a.createTime * 1000;
            if (this.iSr) {
                cB = k.getTimeStringNoYear(new Date(j));
            } else {
                cB = as.cB(j);
                if (as.xS(cB)) {
                    cB = as.getFormatTimeShort(j);
                }
            }
            this.iSm.setText(cB);
            this.iSp = new OfficialFeedItemBottom(context);
            if (this.iSr) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.iSp.setPadding(dimens4, 0, dimens4, 0);
            }
            this.iSp.setData(c0667a, z);
            this.ewV.removeAllViews();
            this.iSn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.iSq != null) {
                        b.this.iSq.a(b.this.iSn, c0667a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.iSo = new OfficialFeedItemImage(context, this.iSr);
                if (this.iSr) {
                    this.iSo.crC();
                    this.iSp.yv(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.ewV.addView(this.iSo);
                this.ewV.addView(this.iSp);
                this.iSo.setData(c0667a, i, bVar);
            } else {
                if (this.iSr) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.ewV.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.iSp.yv(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.ewV.addView(this.iSp);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.iSq = cVar;
    }
}
