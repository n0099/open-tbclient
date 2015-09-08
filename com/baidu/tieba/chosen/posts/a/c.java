package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aKV;
    private TextView aKW;
    private TextView aLa;
    private TextView aLb;
    private LinearLayout aLc;
    private TextView awj;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLa = (TextView) view.findViewById(i.f.chosen_no_picture_title);
        this.aKV = (TextView) view.findViewById(i.f.chosen_no_picture_praise);
        this.aKW = (TextView) view.findViewById(i.f.chosen_no_picture_comment);
        this.aLb = (TextView) view.findViewById(i.f.chosen_no_picture_head);
        this.awj = (TextView) view.findViewById(i.f.chosen_no_picture_sub);
        this.aLc = (LinearLayout) view.findViewById(i.f.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0089: IGET  (r2v3 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00a3: IGET  (r2v4 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(tinfo tinfoVar) {
        super.B(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.aLb.setVisibility(8);
        } else {
            this.aLb.setVisibility(0);
            this.aLb.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aLc.setVisibility(8);
        } else {
            this.aLc.setVisibility(0);
            this.aLa.setVisibility(0);
            this.aLa.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aLa.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aKV.setVisibility(8);
            } else {
                this.aKV.setVisibility(0);
                this.aKV.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aKW.setVisibility(8);
            } else {
                this.aKW.setVisibility(0);
                this.aKW.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.awj.setVisibility(8);
            return;
        }
        this.awj.setVisibility(0);
        this.awj.setText(tinfoVar._abstract);
    }
}
