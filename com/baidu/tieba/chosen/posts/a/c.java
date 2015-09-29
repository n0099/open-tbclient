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
    private TextView aJN;
    private TextView aJO;
    private TextView aJS;
    private TextView aJT;
    private LinearLayout aJU;
    private TextView auI;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJS = (TextView) view.findViewById(i.f.chosen_no_picture_title);
        this.aJN = (TextView) view.findViewById(i.f.chosen_no_picture_praise);
        this.aJO = (TextView) view.findViewById(i.f.chosen_no_picture_comment);
        this.aJT = (TextView) view.findViewById(i.f.chosen_no_picture_head);
        this.auI = (TextView) view.findViewById(i.f.chosen_no_picture_sub);
        this.aJU = (LinearLayout) view.findViewById(i.f.chosen_no_picture_comment_line);
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
            this.aJT.setVisibility(8);
        } else {
            this.aJT.setVisibility(0);
            this.aJT.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aJU.setVisibility(8);
        } else {
            this.aJU.setVisibility(0);
            this.aJS.setVisibility(0);
            this.aJS.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aJS.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aJN.setVisibility(8);
            } else {
                this.aJN.setVisibility(0);
                this.aJN.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aJO.setVisibility(8);
            } else {
                this.aJO.setVisibility(0);
                this.aJO.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.auI.setVisibility(8);
            return;
        }
        this.auI.setVisibility(0);
        this.auI.setText(tinfoVar._abstract);
    }
}
