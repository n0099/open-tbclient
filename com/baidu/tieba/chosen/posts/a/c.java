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
    private TextView aKI;
    private TextView aKJ;
    private TextView aKN;
    private TextView aKO;
    private LinearLayout aKP;
    private TextView auz;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKN = (TextView) view.findViewById(i.f.chosen_no_picture_title);
        this.aKI = (TextView) view.findViewById(i.f.chosen_no_picture_praise);
        this.aKJ = (TextView) view.findViewById(i.f.chosen_no_picture_comment);
        this.aKO = (TextView) view.findViewById(i.f.chosen_no_picture_head);
        this.auz = (TextView) view.findViewById(i.f.chosen_no_picture_sub);
        this.aKP = (LinearLayout) view.findViewById(i.f.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.r
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
    public void A(tinfo tinfoVar) {
        super.A(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.aKO.setVisibility(8);
        } else {
            this.aKO.setVisibility(0);
            this.aKO.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aKP.setVisibility(8);
        } else {
            this.aKP.setVisibility(0);
            this.aKN.setVisibility(0);
            this.aKN.setText(UtilHelper.getFixedText(getContext().getString(i.C0057i.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aKN.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aKI.setVisibility(8);
            } else {
                this.aKI.setVisibility(0);
                this.aKI.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aKJ.setVisibility(8);
            } else {
                this.aKJ.setVisibility(0);
                this.aKJ.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.auz.setVisibility(8);
            return;
        }
        this.auz.setVisibility(0);
        this.auz.setText(tinfoVar._abstract);
    }
}
