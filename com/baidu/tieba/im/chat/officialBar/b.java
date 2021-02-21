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
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.message.chat.a;
import java.util.Date;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<OfficialBarFeedActivity> {
    private LinearLayout fxX;
    private TextView jPC;
    private View kBZ;
    private BarImageView kCa;
    private TextView kCb;
    private RelativeLayout kCc;
    private OfficialFeedItemImage kCd;
    private OfficialFeedItemBottom kCe;
    private OfficialBarFeedMsglistAdapter.c kCf;
    private boolean kCg;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.kCf = null;
        this.kCg = z;
        init();
    }

    private void init() {
        this.kCa = (BarImageView) findViewById(R.id.bar_icon);
        this.jPC = (TextView) findViewById(R.id.bar_name);
        this.kCb = (TextView) findViewById(R.id.message_time);
        this.fxX = (LinearLayout) findViewById(R.id.item_container);
        this.kCc = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.kBZ = findViewById(R.id.official_bar_feed_item_bg);
        if (this.kCg) {
            this.kBZ.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.kCb, R.color.CAM_X0109);
        ap.setViewTextColor(this.jPC, R.color.CAM_X0105);
        if (this.kCd != null) {
            this.kCd.cVm();
        }
        if (this.kCe != null) {
            this.kCe.cVm();
        }
        if (this.kCg) {
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pe(0).pf(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bv(this.fxX);
        } else {
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pe(0).pf(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bv(this.kBZ);
        }
    }

    public void a(Context context, final a.C0761a c0761a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dY;
        if (c0761a != null) {
            if (this.kCg) {
                this.kCa.setVisibility(8);
                this.jPC.setVisibility(8);
                this.kCb.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCb.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.kCb.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.kCc.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fxX.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0761a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxX.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fxX.setLayoutParams(layoutParams2);
            } else {
                this.kCa.setShowOval(true);
                this.kCa.setAutoChangeStyle(true);
                this.kCa.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.kCa.setStrokeColorResId(R.color.CAM_X0401);
                this.kCa.setPlaceHolder(1);
            }
            if (!this.kCg && aVar != null) {
                this.kCa.startLoad(aVar.cVY(), 10, false);
                this.jPC.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0761a.createTime * 1000;
            if (this.kCg) {
                dY = k.getTimeStringNoYear(new Date(j));
            } else {
                dY = au.dY(j);
                if (au.Bf(dY)) {
                    dY = au.getFormatTimeShort(j);
                }
            }
            this.kCb.setText(dY);
            this.kCe = new OfficialFeedItemBottom(context);
            if (this.kCg) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.kCe.setPadding(dimens4, 0, dimens4, 0);
            }
            this.kCe.setData(c0761a, z);
            this.fxX.removeAllViews();
            this.kCc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.kCf != null) {
                        b.this.kCf.a(b.this.kCc, c0761a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.kCd = new OfficialFeedItemImage(context, this.kCg);
                if (this.kCg) {
                    this.kCd.cVn();
                    this.kCe.CM(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fxX.addView(this.kCd);
                this.fxX.addView(this.kCe);
                this.kCd.setData(c0761a, i, bVar);
            } else {
                if (this.kCg) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fxX.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.kCe.CM(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fxX.addView(this.kCe);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OfficialBarFeedMsglistAdapter.c cVar) {
        this.kCf = cVar;
    }
}
