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
    private TbImageView amS;
    private TextView cwr;
    private TextView cws;
    private TextView cwt;
    private TextView cwu;
    private TextView cwv;
    private int cww;
    private com.baidu.tieba.homepage.recommendfrs.data.e cwx;
    private View.OnClickListener cwy;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cww = 0;
        this.cwy = new b(this);
        view.setOnClickListener(this.cwy);
        this.cwr = (TextView) view.findViewById(u.g.title_text);
        this.cws = (TextView) view.findViewById(u.g.refresh_time);
        this.amS = (TbImageView) view.findViewById(u.g.live_cover);
        View findViewById = view.findViewById(u.g.hot_thread_comment);
        this.cwt = (TextView) findViewById.findViewById(u.g.hot_thread_line_tag);
        this.cwu = (TextView) findViewById.findViewById(u.g.hot_thread_line_praise);
        this.cwu.setVisibility(8);
        this.cwv = (TextView) findViewById.findViewById(u.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.ain() != null) {
            this.cwx = eVar;
            ZhiBoInfoTW ain = eVar.ain();
            this.cwr.setText(e(ain.title));
            this.cws.setText(c(ain));
            this.amS.c(ain.livecover_src, 10, false);
            String forumName = StringUtils.isNull(ain.forum_name) ? eVar.getForumName() : ain.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cwt.setVisibility(8);
            } else {
                this.cwt.setVisibility(0);
                this.cwt.setText(getContext().getString(u.j.chosen_pb_original_bar, forumName));
            }
            this.cwv.setText(ba.y(ain.reply_num.intValue() == 0 ? eVar.aij() : ain.reply_num.intValue()));
            s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(eVar.getThreadId()))) {
                this.cww = u.d.cp_cont_c;
            } else {
                this.cww = u.d.cp_cont_b;
            }
            av.c(this.cwr, this.cww, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m10getInst().getString(u.j.photo_live_thread_expression_time, new Object[]{ba.t(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
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
            if (this.cww != 0 && this.cwr != null) {
                av.c(this.cwr, this.cww, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
