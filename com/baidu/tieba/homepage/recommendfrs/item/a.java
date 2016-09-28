package com.baidu.tieba.homepage.recommendfrs.item;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.s;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView apH;
    private TextView cIO;
    private TextView cIP;
    private TextView cIQ;
    private TextView cIR;
    private TextView cIS;
    private int cIT;
    private com.baidu.tieba.homepage.recommendfrs.data.e cIU;
    private View.OnClickListener cIV;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cIT = 0;
        this.cIV = new b(this);
        view.setOnClickListener(this.cIV);
        this.cIO = (TextView) view.findViewById(r.g.title_text);
        this.cIP = (TextView) view.findViewById(r.g.refresh_time);
        this.apH = (TbImageView) view.findViewById(r.g.live_cover);
        View findViewById = view.findViewById(r.g.hot_thread_comment);
        this.cIQ = (TextView) findViewById.findViewById(r.g.hot_thread_line_tag);
        this.cIR = (TextView) findViewById.findViewById(r.g.hot_thread_line_praise);
        this.cIR.setVisibility(8);
        this.cIS = (TextView) findViewById.findViewById(r.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.anp() != null) {
            this.cIU = eVar;
            ZhiBoInfoTW anp = eVar.anp();
            this.cIO.setText(e(anp.title));
            this.cIP.setText(c(anp));
            this.apH.c(anp.livecover_src, 10, false);
            String forumName = StringUtils.isNull(anp.forum_name) ? eVar.getForumName() : anp.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cIQ.setVisibility(8);
            } else {
                this.cIQ.setVisibility(0);
                this.cIQ.setText(getContext().getString(r.j.chosen_pb_original_bar, forumName));
            }
            this.cIS.setText(az.z(anp.reply_num.intValue() == 0 ? eVar.anl() : anp.reply_num.intValue()));
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(String.valueOf(eVar.getThreadId()))) {
                this.cIT = r.d.cp_cont_c;
            } else {
                this.cIT = r.d.cp_cont_b;
            }
            av.c(this.cIO, this.cIT, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(r.j.photo_live_thread_expression_time, new Object[]{az.t(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cN = av.cN(r.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cIT != 0 && this.cIO != null) {
                av.c(this.cIO, this.cIT, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
