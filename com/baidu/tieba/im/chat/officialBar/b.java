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
    private TextView jPo;
    private View kBL;
    private BarImageView kBM;
    private TextView kBN;
    private RelativeLayout kBO;
    private OfficialFeedItemImage kBP;
    private OfficialFeedItemBottom kBQ;
    private OfficialBarFeedMsglistAdapter.c kBR;
    private boolean kBS;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.kBR = null;
        this.kBS = z;
        init();
    }

    private void init() {
        this.kBM = (BarImageView) findViewById(R.id.bar_icon);
        this.jPo = (TextView) findViewById(R.id.bar_name);
        this.kBN = (TextView) findViewById(R.id.message_time);
        this.fxX = (LinearLayout) findViewById(R.id.item_container);
        this.kBO = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.kBL = findViewById(R.id.official_bar_feed_item_bg);
        if (this.kBS) {
            this.kBL.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.kBN, R.color.CAM_X0109);
        ap.setViewTextColor(this.jPo, R.color.CAM_X0105);
        if (this.kBP != null) {
            this.kBP.cVf();
        }
        if (this.kBQ != null) {
            this.kBQ.cVf();
        }
        if (this.kBS) {
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pe(0).pf(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bv(this.fxX);
        } else {
            com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0205).pb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pc(R.color.CAM_X0804).pa(4369).pd(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pe(0).pf(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bv(this.kBL);
        }
    }

    public void a(Context context, final a.C0760a c0760a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dY;
        if (c0760a != null) {
            if (this.kBS) {
                this.kBM.setVisibility(8);
                this.jPo.setVisibility(8);
                this.kBN.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kBN.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.kBN.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.kBO.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fxX.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0760a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxX.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fxX.setLayoutParams(layoutParams2);
            } else {
                this.kBM.setShowOval(true);
                this.kBM.setAutoChangeStyle(true);
                this.kBM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.kBM.setStrokeColorResId(R.color.CAM_X0401);
                this.kBM.setPlaceHolder(1);
            }
            if (!this.kBS && aVar != null) {
                this.kBM.startLoad(aVar.cVR(), 10, false);
                this.jPo.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0760a.createTime * 1000;
            if (this.kBS) {
                dY = k.getTimeStringNoYear(new Date(j));
            } else {
                dY = au.dY(j);
                if (au.Bf(dY)) {
                    dY = au.getFormatTimeShort(j);
                }
            }
            this.kBN.setText(dY);
            this.kBQ = new OfficialFeedItemBottom(context);
            if (this.kBS) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.kBQ.setPadding(dimens4, 0, dimens4, 0);
            }
            this.kBQ.setData(c0760a, z);
            this.fxX.removeAllViews();
            this.kBO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.kBR != null) {
                        b.this.kBR.a(b.this.kBO, c0760a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.kBP = new OfficialFeedItemImage(context, this.kBS);
                if (this.kBS) {
                    this.kBP.cVg();
                    this.kBQ.CM(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fxX.addView(this.kBP);
                this.fxX.addView(this.kBQ);
                this.kBP.setData(c0760a, i, bVar);
            } else {
                if (this.kBS) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fxX.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.kBQ.CM(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fxX.addView(this.kBQ);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OfficialBarFeedMsglistAdapter.c cVar) {
        this.kBR = cVar;
    }
}
