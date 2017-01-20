package com.baidu.tieba.homepage.recommendfrs.item;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView apj;
    private TextView cAn;
    private TextView cAo;
    private TextView cAp;
    private TextView cAq;
    private TextView cAr;
    private int cAs;
    private com.baidu.tieba.homepage.recommendfrs.data.e cAt;
    private View.OnClickListener cAu;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cAs = 0;
        this.cAu = new b(this);
        view.setOnClickListener(this.cAu);
        this.cAn = (TextView) view.findViewById(r.h.title_text);
        this.cAo = (TextView) view.findViewById(r.h.refresh_time);
        this.apj = (TbImageView) view.findViewById(r.h.live_cover);
        View findViewById = view.findViewById(r.h.hot_thread_comment);
        this.cAp = (TextView) findViewById.findViewById(r.h.hot_thread_line_tag);
        this.cAq = (TextView) findViewById.findViewById(r.h.hot_thread_line_praise);
        this.cAq.setVisibility(8);
        this.cAr = (TextView) findViewById.findViewById(r.h.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.akS() != null) {
            this.cAt = eVar;
            ZhiBoInfoTW akS = eVar.akS();
            this.cAn.setText(e(akS.title));
            this.cAo.setText(c(akS));
            this.apj.c(akS.livecover_src, 10, false);
            String forumName = StringUtils.isNull(akS.forum_name) ? eVar.getForumName() : akS.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cAp.setVisibility(8);
            } else {
                this.cAp.setVisibility(0);
                this.cAp.setText(getContext().getString(r.l.chosen_pb_original_bar, forumName));
            }
            this.cAr.setText(at.w(akS.reply_num.intValue() == 0 ? eVar.akO() : akS.reply_num.intValue()));
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qP(String.valueOf(eVar.getThreadId()))) {
                this.cAs = r.e.cp_cont_c;
            } else {
                this.cAs = r.e.cp_cont_b;
            }
            ap.c(this.cAn, this.cAs, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(r.l.photo_live_thread_expression_time, new Object[]{at.r(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cP = ap.cP(r.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cP);
        bitmapDrawable.setBounds(0, 0, cP.getWidth(), cP.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
            if (this.cAs != 0 && this.cAn != null) {
                ap.c(this.cAn, this.cAs, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
