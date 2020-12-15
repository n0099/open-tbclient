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
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<OfficialBarFeedActivity> {
    private LinearLayout fqI;
    private TextView jAy;
    private View klD;
    private BarImageView klE;
    private TextView klF;
    private RelativeLayout klG;
    private OfficialFeedItemImage klH;
    private OfficialFeedItemBottom klI;
    private d.c klJ;
    private boolean klK;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.klJ = null;
        this.klK = z;
        init();
    }

    private void init() {
        this.klE = (BarImageView) findViewById(R.id.bar_icon);
        this.jAy = (TextView) findViewById(R.id.bar_name);
        this.klF = (TextView) findViewById(R.id.message_time);
        this.fqI = (LinearLayout) findViewById(R.id.item_container);
        this.klG = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.klD = findViewById(R.id.official_bar_feed_item_bg);
        if (this.klK) {
            this.klD.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.klF, R.color.CAM_X0109);
        ap.setViewTextColor(this.jAy, R.color.CAM_X0105);
        if (this.klH != null) {
            this.klH.cUm();
        }
        if (this.klI != null) {
            this.klI.cUm();
        }
        if (this.klK) {
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).qv(0).qw(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bq(this.fqI);
        } else {
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).qv(0).qw(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bq(this.klD);
        }
    }

    public void a(Context context, final a.C0782a c0782a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dS;
        if (c0782a != null) {
            if (this.klK) {
                this.klE.setVisibility(8);
                this.jAy.setVisibility(8);
                this.klF.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.klF.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.klF.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.klG.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fqI.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0782a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fqI.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fqI.setLayoutParams(layoutParams2);
            } else {
                this.klE.setShowOval(true);
                this.klE.setAutoChangeStyle(true);
                this.klE.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.klE.setStrokeColorResId(R.color.CAM_X0401);
                this.klE.setPlaceHolder(1);
            }
            if (!this.klK && aVar != null) {
                this.klE.startLoad(aVar.cWo(), 10, false);
                this.jAy.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0782a.createTime * 1000;
            if (this.klK) {
                dS = k.getTimeStringNoYear(new Date(j));
            } else {
                dS = au.dS(j);
                if (au.Cc(dS)) {
                    dS = au.getFormatTimeShort(j);
                }
            }
            this.klF.setText(dS);
            this.klI = new OfficialFeedItemBottom(context);
            if (this.klK) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.klI.setPadding(dimens4, 0, dimens4, 0);
            }
            this.klI.setData(c0782a, z);
            this.fqI.removeAllViews();
            this.klG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.klJ != null) {
                        b.this.klJ.a(b.this.klG, c0782a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.klH = new OfficialFeedItemImage(context, this.klK);
                if (this.klK) {
                    this.klH.cUn();
                    this.klI.DP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fqI.addView(this.klH);
                this.fqI.addView(this.klI);
                this.klH.setData(c0782a, i, bVar);
            } else {
                if (this.klK) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fqI.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.klI.DP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fqI.addView(this.klI);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.klJ = cVar;
    }
}
