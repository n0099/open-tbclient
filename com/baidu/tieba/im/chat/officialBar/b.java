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
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.b<OfficialBarFeedActivity> {
    private LinearLayout eJG;
    private TextView iEZ;
    private View jpT;
    private BarImageView jpU;
    private TextView jpV;
    private RelativeLayout jpW;
    private OfficialFeedItemImage jpX;
    private OfficialFeedItemBottom jpY;
    private d.c jpZ;
    private boolean jqa;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jpZ = null;
        this.jqa = z;
        init();
    }

    private void init() {
        this.jpU = (BarImageView) findViewById(R.id.bar_icon);
        this.iEZ = (TextView) findViewById(R.id.bar_name);
        this.jpV = (TextView) findViewById(R.id.message_time);
        this.eJG = (LinearLayout) findViewById(R.id.item_container);
        this.jpW = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jpT = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jqa) {
            this.jpT.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jpV, R.color.cp_cont_d);
        ap.setViewTextColor(this.iEZ, R.color.cp_cont_b);
        if (this.jpX != null) {
            this.jpX.cGa();
        }
        if (this.jpY != null) {
            this.jpY.cGa();
        }
        if (this.jqa) {
            com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_bg_line_e).oB(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oC(R.color.cp_shadow_a_alpha16).oA(4369).oD(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).oE(0).oF(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bb(this.eJG);
        } else {
            com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_bg_line_e).oB(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oC(R.color.cp_shadow_a_alpha16).oA(4369).oD(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).oE(0).oF(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bb(this.jpT);
        }
    }

    public void a(Context context, final a.C0716a c0716a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cN;
        if (c0716a != null) {
            if (this.jqa) {
                this.jpU.setVisibility(8);
                this.iEZ.setVisibility(8);
                this.jpV.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jpV.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jpV.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jpW.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.eJG.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0716a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eJG.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.eJG.setLayoutParams(layoutParams2);
            } else {
                this.jpU.setShowOval(true);
                this.jpU.setAutoChangeStyle(true);
                this.jpU.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jpU.setStrokeColorResId(R.color.cp_border_a);
                this.jpU.setPlaceHolder(1);
            }
            if (!this.jqa && aVar != null) {
                this.jpU.startLoad(aVar.cIc(), 10, false);
                this.iEZ.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0716a.createTime * 1000;
            if (this.jqa) {
                cN = k.getTimeStringNoYear(new Date(j));
            } else {
                cN = at.cN(j);
                if (at.AD(cN)) {
                    cN = at.getFormatTimeShort(j);
                }
            }
            this.jpV.setText(cN);
            this.jpY = new OfficialFeedItemBottom(context);
            if (this.jqa) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jpY.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jpY.setData(c0716a, z);
            this.eJG.removeAllViews();
            this.jpW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jpZ != null) {
                        b.this.jpZ.a(b.this.jpW, c0716a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jpX = new OfficialFeedItemImage(context, this.jqa);
                if (this.jqa) {
                    this.jpX.cGb();
                    this.jpY.Bq(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.eJG.addView(this.jpX);
                this.eJG.addView(this.jpY);
                this.jpX.setData(c0716a, i, bVar);
            } else {
                if (this.jqa) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.eJG.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jpY.Bq(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.eJG.addView(this.jpY);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jpZ = cVar;
    }
}
