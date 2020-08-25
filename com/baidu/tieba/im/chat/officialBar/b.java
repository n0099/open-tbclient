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
    private LinearLayout eHv;
    private TextView ixx;
    private View jhh;
    private BarImageView jhi;
    private TextView jhj;
    private RelativeLayout jhk;
    private OfficialFeedItemImage jhl;
    private OfficialFeedItemBottom jhm;
    private d.c jhn;
    private boolean jho;

    public b(TbPageContext<BaseActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.jhn = null;
        this.jho = z;
        init();
    }

    private void init() {
        this.jhi = (BarImageView) findViewById(R.id.bar_icon);
        this.ixx = (TextView) findViewById(R.id.bar_name);
        this.jhj = (TextView) findViewById(R.id.message_time);
        this.eHv = (LinearLayout) findViewById(R.id.item_container);
        this.jhk = (RelativeLayout) findViewById(R.id.official_bar_feed_item);
        this.jhh = findViewById(R.id.official_bar_feed_item_bg);
        if (this.jho) {
            this.jhh.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jhj, R.color.cp_cont_d);
        ap.setViewTextColor(this.ixx, R.color.cp_cont_b);
        if (this.jhl != null) {
            this.jhl.cCt();
        }
        if (this.jhm != null) {
            this.jhm.cCt();
        }
        if (this.jho) {
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_e).op(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).os(0).ot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aZ(this.eHv);
        } else {
            com.baidu.tbadk.core.util.e.a.bjP().ou(R.color.cp_bg_line_e).op(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).oq(R.color.cp_shadow_a_alpha16).oo(4369).or(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).os(0).ot(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).aZ(this.jhh);
        }
    }

    public void a(Context context, final a.C0719a c0719a, com.baidu.tieba.im.db.pojo.a aVar, com.baidu.tieba.im.forum.broadcast.data.b bVar, int i, boolean z, final int i2) {
        String cM;
        if (c0719a != null) {
            if (this.jho) {
                this.jhi.setVisibility(8);
                this.ixx.setVisibility(8);
                this.jhj.setTextSize(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jhj.getLayoutParams();
                layoutParams.removeRule(11);
                layoutParams.addRule(14);
                this.jhj.setLayoutParams(layoutParams);
                int dimens = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens2 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens3 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
                this.jhk.setPadding(0, l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
                this.eHv.setPadding(dimens, dimens2, dimens, StringUtils.isNull(c0719a.text) ? 0 : dimens3 + dimens);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eHv.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
                this.eHv.setLayoutParams(layoutParams2);
            } else {
                this.jhi.setShowOval(true);
                this.jhi.setAutoChangeStyle(true);
                this.jhi.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.jhi.setStrokeColorResId(R.color.cp_border_a);
                this.jhi.setPlaceHolder(1);
            }
            if (!this.jho && aVar != null) {
                this.jhi.startLoad(aVar.cEv(), 10, false);
                this.ixx.setText(String.format("%s%s", aVar.getForumName(), context.getString(R.string.forum)));
            }
            long j = c0719a.createTime * 1000;
            if (this.jho) {
                cM = k.getTimeStringNoYear(new Date(j));
            } else {
                cM = at.cM(j);
                if (at.Ag(cM)) {
                    cM = at.getFormatTimeShort(j);
                }
            }
            this.jhj.setText(cM);
            this.jhm = new OfficialFeedItemBottom(context);
            if (this.jho) {
                int dimens4 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
                this.jhm.setPadding(dimens4, 0, dimens4, 0);
            }
            this.jhm.setData(c0719a, z);
            this.eHv.removeAllViews();
            this.jhk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.jhn != null) {
                        b.this.jhn.a(b.this.jhk, c0719a, i2, 0L);
                    }
                }
            });
            if (z) {
                this.jhl = new OfficialFeedItemImage(context, this.jho);
                if (this.jho) {
                    this.jhl.cCu();
                    this.jhm.AP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
                }
                this.eHv.addView(this.jhl);
                this.eHv.addView(this.jhm);
                this.jhl.setData(c0719a, i, bVar);
            } else {
                if (this.jho) {
                    int dimens5 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                    int dimens6 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                    int dimens7 = l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                    this.eHv.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                    this.jhm.AP(l.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
                }
                this.eHv.addView(this.jhm);
            }
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        this.jhn = cVar;
    }
}
