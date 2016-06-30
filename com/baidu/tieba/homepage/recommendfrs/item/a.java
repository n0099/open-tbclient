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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.s;
import com.baidu.tieba.u;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView amd;
    private TextView ctC;
    private TextView ctD;
    private TextView ctE;
    private TextView ctF;
    private TextView ctG;
    private int ctH;
    private com.baidu.tieba.homepage.recommendfrs.data.e ctI;
    private View.OnClickListener ctJ;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.ctH = 0;
        this.ctJ = new b(this);
        view.setOnClickListener(this.ctJ);
        this.ctC = (TextView) view.findViewById(u.g.title_text);
        this.ctD = (TextView) view.findViewById(u.g.refresh_time);
        this.amd = (TbImageView) view.findViewById(u.g.live_cover);
        View findViewById = view.findViewById(u.g.hot_thread_comment);
        this.ctE = (TextView) findViewById.findViewById(u.g.hot_thread_line_tag);
        this.ctF = (TextView) findViewById.findViewById(u.g.hot_thread_line_praise);
        this.ctF.setVisibility(8);
        this.ctG = (TextView) findViewById.findViewById(u.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.B(eVar);
        if (eVar != null && eVar.ahD() != null) {
            this.ctI = eVar;
            ZhiBoInfoTW ahD = eVar.ahD();
            this.ctC.setText(e(ahD.title));
            this.ctD.setText(c(ahD));
            this.amd.c(ahD.livecover_src, 10, false);
            String forumName = StringUtils.isNull(ahD.forum_name) ? eVar.getForumName() : ahD.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.ctE.setVisibility(8);
            } else {
                this.ctE.setVisibility(0);
                this.ctE.setText(getContext().getString(u.j.chosen_pb_original_bar, forumName));
            }
            this.ctG.setText(ba.D(ahD.reply_num.intValue() == 0 ? eVar.ahz() : ahD.reply_num.intValue()));
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pL(String.valueOf(eVar.getThreadId()))) {
                this.ctH = u.d.cp_cont_c;
            } else {
                this.ctH = u.d.cp_cont_b;
            }
            av.c(this.ctC, this.ctH, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(u.j.photo_live_thread_expression_time, new Object[]{ba.y(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cA = av.cA(u.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
        bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.ctH != 0 && this.ctC != null) {
                av.c(this.ctC, this.ctH, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
