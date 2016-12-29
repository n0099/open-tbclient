package com.baidu.tieba.homepage.recommendfrs.item;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aqe;
    private TextView ctj;
    private TextView ctk;
    private TextView ctl;
    private TextView ctm;
    private TextView ctn;
    private int cto;
    private com.baidu.tieba.homepage.recommendfrs.data.e ctp;
    private View.OnClickListener ctq;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cto = 0;
        this.ctq = new b(this);
        view.setOnClickListener(this.ctq);
        this.ctj = (TextView) view.findViewById(r.g.title_text);
        this.ctk = (TextView) view.findViewById(r.g.refresh_time);
        this.aqe = (TbImageView) view.findViewById(r.g.live_cover);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.ctl = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.ctm = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.ctm.setVisibility(8);
        this.ctn = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.ajL() != null) {
            this.ctp = eVar;
            ZhiBoInfoTW ajL = eVar.ajL();
            this.ctj.setText(e(ajL.title));
            this.ctk.setText(c(ajL));
            this.aqe.c(ajL.livecover_src, 10, false);
            String forumName = StringUtils.isNull(ajL.forum_name) ? eVar.getForumName() : ajL.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.ctl.setVisibility(8);
            } else {
                this.ctl.setVisibility(0);
                this.ctl.setText(getContext().getString(r.j.chosen_pb_original_bar, forumName));
            }
            this.ctn.setText(av.y(ajL.reply_num.intValue() == 0 ? eVar.ajH() : ajL.reply_num.intValue()));
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                this.cto = r.d.cp_cont_c;
            } else {
                this.cto = r.d.cp_cont_b;
            }
            ar.c(this.ctj, this.cto, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(r.j.photo_live_thread_expression_time, new Object[]{av.s(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cQ = ar.cQ(r.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cto != 0 && this.ctj != null) {
                ar.c(this.ctj, this.cto, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
