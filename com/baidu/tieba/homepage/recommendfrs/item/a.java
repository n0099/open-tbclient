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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbImageView apZ;
    private TextView cHW;
    private TextView cHX;
    private TextView cHY;
    private TextView cHZ;
    private TextView cIa;
    private int cIb;
    private com.baidu.tieba.homepage.recommendfrs.data.e cIc;
    private View.OnClickListener cId;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cIb = 0;
        this.cId = new b(this);
        view.setOnClickListener(this.cId);
        this.cHW = (TextView) view.findViewById(t.g.title_text);
        this.cHX = (TextView) view.findViewById(t.g.refresh_time);
        this.apZ = (TbImageView) view.findViewById(t.g.live_cover);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.cHY = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.cHZ = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.cHZ.setVisibility(8);
        this.cIa = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null && eVar.anb() != null) {
            this.cIc = eVar;
            ZhiBoInfoTW anb = eVar.anb();
            this.cHW.setText(e(anb.title));
            this.cHX.setText(c(anb));
            this.apZ.c(anb.livecover_src, 10, false);
            String forumName = StringUtils.isNull(anb.forum_name) ? eVar.getForumName() : anb.forum_name;
            if (StringUtils.isNull(forumName)) {
                this.cHY.setVisibility(8);
            } else {
                this.cHY.setVisibility(0);
                this.cHY.setText(getContext().getString(t.j.chosen_pb_original_bar, forumName));
            }
            this.cIa.setText(ba.y(anb.reply_num.intValue() == 0 ? eVar.amX() : anb.reply_num.intValue()));
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rf(String.valueOf(eVar.getThreadId()))) {
                this.cIb = t.d.cp_cont_c;
            } else {
                this.cIb = t.d.cp_cont_b;
            }
            av.c(this.cHW, this.cIb, 1);
        }
    }

    private String c(ZhiBoInfoTW zhiBoInfoTW) {
        return TbadkCoreApplication.m9getInst().getString(t.j.photo_live_thread_expression_time, new Object[]{ba.t(zhiBoInfoTW.last_modified_time.longValue() * 1000)});
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
        Bitmap cN = av.cN(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, 1, 33);
        return spannableStringBuilder;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.cIb != 0 && this.cHW != null) {
                av.c(this.cHW, this.cIb, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
