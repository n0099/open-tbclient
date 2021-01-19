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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.message.chat.a;
import java.util.Date;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<OfficialBarFeedActivity> {
    private LinearLayout fvH;
    private TextView jIr;
    private View ktE;
    private BarImageView ktF;
    private TextView ktG;
    private RelativeLayout ktH;
    private OfficialFeedItemImage ktI;
    private OfficialFeedItemBottom ktJ;
    private OfficialBarFeedMsglistAdapter.c ktK;
    private boolean ktL;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.ktK = null;
        this.ktL = z;
        init();
    }

    private void init() {
        this.ktF = (BarImageView) findViewById(R.id.bar_icon);
        this.jIr = (TextView) findViewById(R.id.bar_name);
        this.ktG = (TextView) findViewById(R.id.message_time);
        this.fvH = (LinearLayout) findViewById(R.id.item_container);
        this.ktH = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.ktE = findViewById(R.id.official_bar_feed_item_bg);
        if (this.ktL) {
            this.ktE.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.ktG, R.color.CAM_X0109);
        ao.setViewTextColor(this.jIr, R.color.CAM_X0105);
        if (this.ktI != null) {
            this.ktI.cTh();
        }
        if (this.ktJ != null) {
            this.ktJ.cTh();
        }
        if (this.ktL) {
            com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0205).oW(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oX(R.color.CAM_X0804).oV(4369).oY(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).oZ(0).pa(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bz(this.fvH);
        } else {
            com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0205).oW(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oX(R.color.CAM_X0804).oV(4369).oY(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).oZ(0).pa(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bz(this.ktE);
        }
    }

    public void a(Context context, final a.C0758a c0758a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dS;
        if (c0758a != null) {
            if (this.ktL) {
                this.ktF.setVisibility(8);
                this.jIr.setVisibility(8);
                this.ktG.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ktG.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.ktG.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.ktH.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fvH.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0758a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fvH.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fvH.setLayoutParams(layoutParams2);
            } else {
                this.ktF.setShowOval(true);
                this.ktF.setAutoChangeStyle(true);
                this.ktF.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ktF.setStrokeColorResId(R.color.CAM_X0401);
                this.ktF.setPlaceHolder(1);
            }
            if (!this.ktL && aVar != null) {
                this.ktF.startLoad(aVar.cTT(), 10, false);
                this.jIr.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0758a.createTime * 1000;
            if (this.ktL) {
                dS = k.getTimeStringNoYear(new Date(j));
            } else {
                dS = at.dS(j);
                if (at.AO(dS)) {
                    dS = at.getFormatTimeShort(j);
                }
            }
            this.ktG.setText(dS);
            this.ktJ = new OfficialFeedItemBottom(context);
            if (this.ktL) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.ktJ.setPadding(dimens4, 0, dimens4, 0);
            }
            this.ktJ.setData(c0758a, z);
            this.fvH.removeAllViews();
            this.ktH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ktK != null) {
                        b.this.ktK.a(b.this.ktH, c0758a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.ktI = new OfficialFeedItemImage(context, this.ktL);
                if (this.ktL) {
                    this.ktI.cTi();
                    this.ktJ.Cu(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fvH.addView(this.ktI);
                this.fvH.addView(this.ktJ);
                this.ktI.setData(c0758a, i, bVar);
            } else {
                if (this.ktL) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fvH.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.ktJ.Cu(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fvH.addView(this.ktJ);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OfficialBarFeedMsglistAdapter.c cVar) {
        this.ktK = cVar;
    }
}
