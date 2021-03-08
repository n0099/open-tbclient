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
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<OfficialBarFeedActivity> {
    private LinearLayout fzw;
    private TextView jRl;
    private View kEb;
    private BarImageView kEc;
    private TextView kEd;
    private RelativeLayout kEe;
    private OfficialFeedItemImage kEf;
    private OfficialFeedItemBottom kEg;
    private OfficialBarFeedMsglistAdapter.c kEh;
    private boolean kEi;

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.kEh = null;
        this.kEi = z;
        init();
    }

    private void init() {
        this.kEc = (BarImageView) findViewById(R.id.bar_icon);
        this.jRl = (TextView) findViewById(R.id.bar_name);
        this.kEd = (TextView) findViewById(R.id.message_time);
        this.fzw = (LinearLayout) findViewById(R.id.item_container);
        this.kEe = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.kEb = findViewById(R.id.official_bar_feed_item_bg);
        if (this.kEi) {
            this.kEb.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.kEd, R.color.CAM_X0109);
        ap.setViewTextColor(this.jRl, R.color.CAM_X0105);
        if (this.kEf != null) {
            this.kEf.cVt();
        }
        if (this.kEg != null) {
            this.kEg.cVt();
        }
        if (this.kEi) {
            com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0205).pc(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pd(R.color.CAM_X0804).pb(4369).pe(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pf(0).pg(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bv(this.fzw);
        } else {
            com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0205).pc(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).pd(R.color.CAM_X0804).pb(4369).pe(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).pf(0).pg(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).bv(this.kEb);
        }
    }

    public void a(Context context, final a.C0767a c0767a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String dY;
        if (c0767a != null) {
            if (this.kEi) {
                this.kEc.setVisibility(8);
                this.jRl.setVisibility(8);
                this.kEd.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kEd.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.kEd.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.kEe.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.fzw.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0767a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fzw.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.fzw.setLayoutParams(layoutParams2);
            } else {
                this.kEc.setShowOval(true);
                this.kEc.setAutoChangeStyle(true);
                this.kEc.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.kEc.setStrokeColorResId(R.color.CAM_X0401);
                this.kEc.setPlaceHolder(1);
            }
            if (!this.kEi && aVar != null) {
                this.kEc.startLoad(aVar.cWf(), 10, false);
                this.jRl.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0767a.createTime * 1000;
            if (this.kEi) {
                dY = k.getTimeStringNoYear(new Date(j));
            } else {
                dY = au.dY(j);
                if (au.Bm(dY)) {
                    dY = au.getFormatTimeShort(j);
                }
            }
            this.kEd.setText(dY);
            this.kEg = new OfficialFeedItemBottom(context);
            if (this.kEi) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.kEg.setPadding(dimens4, 0, dimens4, 0);
            }
            this.kEg.setData(c0767a, z);
            this.fzw.removeAllViews();
            this.kEe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.kEh != null) {
                        b.this.kEh.a(b.this.kEe, c0767a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.kEf = new OfficialFeedItemImage(context, this.kEi);
                if (this.kEi) {
                    this.kEf.cVu();
                    this.kEg.CP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.fzw.addView(this.kEf);
                this.fzw.addView(this.kEg);
                this.kEf.setData(c0767a, i, bVar);
            } else {
                if (this.kEi) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.fzw.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.kEg.CP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.fzw.addView(this.kEg);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OfficialBarFeedMsglistAdapter.c cVar) {
        this.kEh = cVar;
    }
}
