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
    private TbImageView auE;
    private TextView cBJ;
    private TextView cBK;
    private TextView cBL;
    private TextView cBM;
    private TextView cBN;
    private int cBO;
    private com.baidu.tieba.homepage.recommendfrs.data.e cBP;
    private View.OnClickListener cBQ;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cBO = 0;
        this.cBQ = new b(this);
        view.setOnClickListener(this.cBQ);
        this.cBJ = (TextView) view.findViewById(w.h.title_text);
        this.cBK = (TextView) view.findViewById(w.h.refresh_time);
        this.auE = (TbImageView) view.findViewById(w.h.live_cover);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.cBL = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.cBM = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.cBM.setVisibility(8);
        this.cBN = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.ake() != null) {
            this.cBP = eVar;
            ZhiBoInfoTW ake = eVar.ake();
            this.cBJ.setText(e(ake.title));
            this.cBK.setText(c(ake));
            this.auE.c(ake.livecover_src, 10, false);
            String forumName = StringUtils.isNull(ake.forum_name) ? eVar.getForumName() : ake.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cBL.setVisibility(8);
            } else {
                this.cBL.setVisibility(0);
                this.cBL.setText(getContext().getString(w.l.chosen_pb_original_bar, forumName));
            }
            this.cBN.setText(au.w(ake.reply_num.intValue() == 0 ? eVar.aka() : ake.reply_num.intValue()));
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pX(String.valueOf(eVar.getThreadId()))) {
                this.cBO = w.e.cp_cont_c;
            } else {
                this.cBO = w.e.cp_cont_b;
            }
            aq.c(this.cBJ, this.cBO, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(w.l.photo_live_thread_expression_time, new Object[]{au.q(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cL = aq.cL(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
        bitmapDrawable.setBounds(0, 0, cL.getWidth(), cL.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cBO != 0 && this.cBJ != null) {
                aq.c(this.cBJ, this.cBO, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
