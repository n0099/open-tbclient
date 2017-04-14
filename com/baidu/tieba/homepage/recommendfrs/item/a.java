package com.baidu.tieba.homepage.recommendfrs.item;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.w;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView auU;
    private TextView cAi;
    private TextView cAj;
    private TextView cAk;
    private TextView cAl;
    private TextView cAm;
    private int cAn;
    private com.baidu.tieba.homepage.recommendfrs.data.e cAo;
    private View.OnClickListener cAp;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cAn = 0;
        this.cAp = new b(this);
        view.setOnClickListener(this.cAp);
        this.cAi = (TextView) view.findViewById(w.h.title_text);
        this.cAj = (TextView) view.findViewById(w.h.refresh_time);
        this.auU = (TbImageView) view.findViewById(w.h.live_cover);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.cAk = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.cAl = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.cAl.setVisibility(8);
        this.cAm = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.ajY() != null) {
            this.cAo = eVar;
            ZhiBoInfoTW ajY = eVar.ajY();
            this.cAi.setText(e(ajY.title));
            this.cAj.setText(b(ajY));
            this.auU.c(ajY.livecover_src, 10, false);
            String forumName = StringUtils.isNull(ajY.forum_name) ? eVar.getForumName() : ajY.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cAk.setVisibility(8);
            } else {
                this.cAk.setVisibility(0);
                this.cAk.setText(getContext().getString(w.l.chosen_pb_original_bar, forumName));
            }
            this.cAm.setText(au.w(ajY.reply_num.intValue() == 0 ? eVar.ajU() : ajY.reply_num.intValue()));
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qo(String.valueOf(eVar.getThreadId()))) {
                this.cAn = w.e.cp_cont_c;
            } else {
                this.cAn = w.e.cp_cont_b;
            }
            aq.c(this.cAi, this.cAn, 1);
        }
    }

    private String b(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(w.l.photo_live_thread_expression_time, new Object[]{au.q(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cO = aq.cO(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
            if (this.cAn != 0 && this.cAi != null) {
                aq.c(this.cAi, this.cAn, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
