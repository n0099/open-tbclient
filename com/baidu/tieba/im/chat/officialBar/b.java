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
    private TextView jAw;
    private View klB;
    private BarImageView klC;
    private TextView klD;
    private RelativeLayout klE;
    private OfficialFeedItemImage klF;
    private OfficialFeedItemBottom klG;
    private d.c klH;
    private boolean klI;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.klH = null;
        this.klI = z;
        init();
    }

    private void init() {
        this.klC = (BarImageView) findViewById(R.id.bar_icon);
        this.jAw = (TextView) findViewById(R.id.bar_name);
        this.klD = (TextView) findViewById(R.id.message_time);
        this.fqI = (LinearLayout) findViewById(R.id.item_container);
        this.klE = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.klB = findViewById(R.id.official_bar_feed_item_bg);
        if (this.klI) {
            this.klB.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.klD, R.color.CAM_X0109);
        ap.setViewTextColor(this.jAw, R.color.CAM_X0105);
        if (this.klF != null) {
            this.klF.cUl();
        }
        if (this.klG != null) {
            this.klG.cUl();
        }
        if (this.klI) {
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).qv(0).qw(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bq(this.fqI);
        } else {
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0205).qs(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).qt(R.color.CAM_X0804).qr(4369).qu(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).qv(0).qw(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bq(this.klB);
        }
    }

    public void a(Context context, final a.C0782a c0782a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dS;
        if (c0782a != null) {
            if (this.klI) {
                this.klC.setVisibility(8);
                this.jAw.setVisibility(8);
                this.klD.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.klD.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.klD.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.klE.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fqI.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0782a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fqI.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fqI.setLayoutParams(layoutParams2);
            } else {
                this.klC.setShowOval(true);
                this.klC.setAutoChangeStyle(true);
                this.klC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.klC.setStrokeColorResId(R.color.CAM_X0401);
                this.klC.setPlaceHolder(1);
            }
            if (!this.klI && aVar != null) {
                this.klC.startLoad(aVar.cWn(), 10, false);
                this.jAw.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0782a.createTime * 1000;
            if (this.klI) {
                dS = k.getTimeStringNoYear(new Date(j));
            } else {
                dS = au.dS(j);
                if (au.Cc(dS)) {
                    dS = au.getFormatTimeShort(j);
                }
            }
            this.klD.setText(dS);
            this.klG = new OfficialFeedItemBottom(context);
            if (this.klI) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.klG.setPadding(dimens4, 0, dimens4, 0);
            }
            this.klG.setData(c0782a, z);
            this.fqI.removeAllViews();
            this.klE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.klH != null) {
                        b.this.klH.a(b.this.klE, c0782a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.klF = new OfficialFeedItemImage(context, this.klI);
                if (this.klI) {
                    this.klF.cUm();
                    this.klG.DP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fqI.addView(this.klF);
                this.fqI.addView(this.klG);
                this.klF.setData(c0782a, i, bVar);
            } else {
                if (this.klI) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fqI.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.klG.DP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fqI.addView(this.klG);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.klH = cVar;
    }
}
