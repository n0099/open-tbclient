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
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<OfficialBarFeedActivity> {
    private LinearLayout fAp;
    private TextView jMX;
    private View kyj;
    private BarImageView kyk;
    private TextView kyl;
    private RelativeLayout kym;
    private OfficialFeedItemImage kyn;
    private OfficialFeedItemBottom kyo;
    private OfficialBarFeedMsglistAdapter.c kyp;
    private boolean kyq;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.kyp = null;
        this.kyq = z;
        init();
    }

    private void init() {
        this.kyk = (BarImageView) findViewById(R.id.bar_icon);
        this.jMX = (TextView) findViewById(R.id.bar_name);
        this.kyl = (TextView) findViewById(R.id.message_time);
        this.fAp = (LinearLayout) findViewById(R.id.item_container);
        this.kym = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.kyj = findViewById(R.id.official_bar_feed_item_bg);
        if (this.kyq) {
            this.kyj.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.kyl, R.color.CAM_X0109);
        ao.setViewTextColor(this.jMX, R.color.CAM_X0105);
        if (this.kyn != null) {
            this.kyn.cWY();
        }
        if (this.kyo != null) {
            this.kyo.cWY();
        }
        if (this.kyq) {
            com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0205).qD(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).qE(R.color.CAM_X0804).qC(4369).qF(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).qG(0).qH(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bz(this.fAp);
        } else {
            com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0205).qD(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).qE(R.color.CAM_X0804).qC(4369).qF(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).qG(0).qH(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bz(this.kyj);
        }
    }

    public void a(Context context, final a.C0766a c0766a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dS;
        if (c0766a != null) {
            if (this.kyq) {
                this.kyk.setVisibility(8);
                this.jMX.setVisibility(8);
                this.kyl.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kyl.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.kyl.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.kym.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fAp.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0766a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fAp.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fAp.setLayoutParams(layoutParams2);
            } else {
                this.kyk.setShowOval(true);
                this.kyk.setAutoChangeStyle(true);
                this.kyk.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.kyk.setStrokeColorResId(R.color.CAM_X0401);
                this.kyk.setPlaceHolder(1);
            }
            if (!this.kyq && aVar != null) {
                this.kyk.startLoad(aVar.cXK(), 10, false);
                this.jMX.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0766a.createTime * 1000;
            if (this.kyq) {
                dS = k.getTimeStringNoYear(new Date(j));
            } else {
                dS = at.dS(j);
                if (at.Ca(dS)) {
                    dS = at.getFormatTimeShort(j);
                }
            }
            this.kyl.setText(dS);
            this.kyo = new OfficialFeedItemBottom(context);
            if (this.kyq) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.kyo.setPadding(dimens4, 0, dimens4, 0);
            }
            this.kyo.setData(c0766a, z);
            this.fAp.removeAllViews();
            this.kym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.kyp != null) {
                        b.this.kyp.a(b.this.kym, c0766a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.kyn = new OfficialFeedItemImage(context, this.kyq);
                if (this.kyq) {
                    this.kyn.cWZ();
                    this.kyo.Eb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fAp.addView(this.kyn);
                this.fAp.addView(this.kyo);
                this.kyn.setData(c0766a, i, bVar);
            } else {
                if (this.kyq) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fAp.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.kyo.Eb(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fAp.addView(this.kyo);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OfficialBarFeedMsglistAdapter.c cVar) {
        this.kyp = cVar;
    }
}
