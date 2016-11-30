package com.baidu.tieba.homepage.recommendfrs.item;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aqB;
    private TextView cOd;
    private TextView cOe;
    private TextView cOf;
    private TextView cOg;
    private TextView cOh;
    private int cOi;
    private com.baidu.tieba.homepage.recommendfrs.data.e cOj;
    private View.OnClickListener cOk;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cOi = 0;
        this.cOk = new b(this);
        view.setOnClickListener(this.cOk);
        this.cOd = (TextView) view.findViewById(r.g.title_text);
        this.cOe = (TextView) view.findViewById(r.g.refresh_time);
        this.aqB = (TbImageView) view.findViewById(r.g.live_cover);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.cOf = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.cOg = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.cOg.setVisibility(8);
        this.cOh = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.apj() != null) {
            this.cOj = eVar;
            ZhiBoInfoTW apj = eVar.apj();
            this.cOd.setText(e(apj.title));
            this.cOe.setText(c(apj));
            this.aqB.c(apj.livecover_src, 10, false);
            String forumName = StringUtils.isNull(apj.forum_name) ? eVar.getForumName() : apj.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cOf.setVisibility(8);
            } else {
                this.cOf.setVisibility(0);
                this.cOf.setText(getContext().getString(r.j.chosen_pb_original_bar, forumName));
            }
            this.cOh.setText(ax.y(apj.reply_num.intValue() == 0 ? eVar.apf() : apj.reply_num.intValue()));
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rP(String.valueOf(eVar.getThreadId()))) {
                this.cOi = r.d.cp_cont_c;
            } else {
                this.cOi = r.d.cp_cont_b;
            }
            at.c(this.cOd, this.cOi, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(r.j.photo_live_thread_expression_time, new Object[]{ax.s(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cO = at.cO(r.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cOi != 0 && this.cOd != null) {
                at.c(this.cOd, this.cOi, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
