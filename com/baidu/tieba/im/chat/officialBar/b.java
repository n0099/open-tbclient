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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.Date;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<BaseActivity> {
    private LinearLayout eHz;
    private TextView ixD;
    private View jhn;
    private BarImageView jho;
    private TextView jhp;
    private RelativeLayout jhq;
    private OfficialFeedItemImage jhr;
    private OfficialFeedItemBottom jhs;
    private d.c jht;
    private boolean jhu;

    public b(TbPageContext<BaseActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jht = null;
        this.jhu = z;
        init();
    }

    private void init() {
        this.jho = (BarImageView) findViewById(R.id.bar_icon);
        this.ixD = (TextView) findViewById(R.id.bar_name);
        this.jhp = (TextView) findViewById(R.id.message_time);
        this.eHz = (LinearLayout) findViewById(R.id.item_container);
        this.jhq = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jhn = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jhu) {
            this.jhn.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jhp, R.color.cp_cont_d);
        ap.setViewTextColor(this.ixD, R.color.cp_cont_b);
        if (this.jhr != null) {
            this.jhr.cCu();
        }
        if (this.jhs != null) {
            this.jhs.cCu();
        }
        if (this.jhu) {
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_e).op(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).os(0).ot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aZ(this.eHz);
        } else {
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_e).op(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).os(0).ot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aZ(this.jhn);
        }
    }

    public void a(Context context, final a.C0719a c0719a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cM;
        if (c0719a != null) {
            if (this.jhu) {
                this.jho.setVisibility(8);
                this.ixD.setVisibility(8);
                this.jhp.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jhp.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jhp.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jhq.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.eHz.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0719a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eHz.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.eHz.setLayoutParams(layoutParams2);
            } else {
                this.jho.setShowOval(true);
                this.jho.setAutoChangeStyle(true);
                this.jho.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jho.setStrokeColorResId(R.color.cp_border_a);
                this.jho.setPlaceHolder(1);
            }
            if (!this.jhu && aVar != null) {
                this.jho.startLoad(aVar.cEw(), 10, false);
                this.ixD.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0719a.createTime * 1000;
            if (this.jhu) {
                cM = k.getTimeStringNoYear(new Date(j));
            } else {
                cM = at.cM(j);
                if (at.Ah(cM)) {
                    cM = at.getFormatTimeShort(j);
                }
            }
            this.jhp.setText(cM);
            this.jhs = new OfficialFeedItemBottom(context);
            if (this.jhu) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jhs.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jhs.setData(c0719a, z);
            this.eHz.removeAllViews();
            this.jhq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jht != null) {
                        b.this.jht.a(b.this.jhq, c0719a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jhr = new OfficialFeedItemImage(context, this.jhu);
                if (this.jhu) {
                    this.jhr.cCv();
                    this.jhs.AP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.eHz.addView(this.jhr);
                this.eHz.addView(this.jhs);
                this.jhr.setData(c0719a, i, bVar);
            } else {
                if (this.jhu) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.eHz.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jhs.AP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.eHz.addView(this.jhs);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jht = cVar;
    }
}
