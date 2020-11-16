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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.Date;
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.b<OfficialBarFeedActivity> {
    private LinearLayout fjk;
    private View jXW;
    private BarImageView jXX;
    private TextView jXY;
    private RelativeLayout jXZ;
    private OfficialFeedItemImage jYa;
    private OfficialFeedItemBottom jYb;
    private d.c jYc;
    private boolean jYd;
    private TextView jmU;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jYc = null;
        this.jYd = z;
        init();
    }

    private void init() {
        this.jXX = (BarImageView) findViewById(R.id.bar_icon);
        this.jmU = (TextView) findViewById(R.id.bar_name);
        this.jXY = (TextView) findViewById(R.id.message_time);
        this.fjk = (LinearLayout) findViewById(R.id.item_container);
        this.jXZ = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jXW = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jYd) {
            this.jXW.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jXY, R.color.CAM_X0109);
        ap.setViewTextColor(this.jmU, R.color.CAM_X0105);
        if (this.jYa != null) {
            this.jYa.cOX();
        }
        if (this.jYb != null) {
            this.jYb.cOX();
        }
        if (this.jYd) {
            com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0205).pS(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pT(R.color.CAM_X0804).pR(4369).pU(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pV(0).pW(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bn(this.fjk);
        } else {
            com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0205).pS(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pT(R.color.CAM_X0804).pR(4369).pU(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pV(0).pW(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bn(this.jXW);
        }
    }

    public void a(Context context, final a.C0766a c0766a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dt;
        if (c0766a != null) {
            if (this.jYd) {
                this.jXX.setVisibility(8);
                this.jmU.setVisibility(8);
                this.jXY.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jXY.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jXY.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jXZ.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fjk.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0766a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fjk.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fjk.setLayoutParams(layoutParams2);
            } else {
                this.jXX.setShowOval(true);
                this.jXX.setAutoChangeStyle(true);
                this.jXX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jXX.setStrokeColorResId(R.color.CAM_X0401);
                this.jXX.setPlaceHolder(1);
            }
            if (!this.jYd && aVar != null) {
                this.jXX.startLoad(aVar.cQZ(), 10, false);
                this.jmU.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0766a.createTime * 1000;
            if (this.jYd) {
                dt = k.getTimeStringNoYear(new Date(j));
            } else {
                dt = au.dt(j);
                if (au.Bv(dt)) {
                    dt = au.getFormatTimeShort(j);
                }
            }
            this.jXY.setText(dt);
            this.jYb = new OfficialFeedItemBottom(context);
            if (this.jYd) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jYb.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jYb.setData(c0766a, z);
            this.fjk.removeAllViews();
            this.jXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jYc != null) {
                        b.this.jYc.a(b.this.jXZ, c0766a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jYa = new OfficialFeedItemImage(context, this.jYd);
                if (this.jYd) {
                    this.jYa.cOY();
                    this.jYb.Da(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fjk.addView(this.jYa);
                this.fjk.addView(this.jYb);
                this.jYa.setData(c0766a, i, bVar);
            } else {
                if (this.jYd) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fjk.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jYb.Da(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fjk.addView(this.jYb);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jYc = cVar;
    }
}
