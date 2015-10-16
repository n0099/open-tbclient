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
    private TextView aJY;
    private TextView aJZ;
    private TextView aKd;
    private TextView aKe;
    private LinearLayout aKf;
    private TextView auJ;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKd = (TextView) view.findViewById(i.f.chosen_no_picture_title);
        this.aJY = (TextView) view.findViewById(i.f.chosen_no_picture_praise);
        this.aJZ = (TextView) view.findViewById(i.f.chosen_no_picture_comment);
        this.aKe = (TextView) view.findViewById(i.f.chosen_no_picture_head);
        this.auJ = (TextView) view.findViewById(i.f.chosen_no_picture_sub);
        this.aKf = (LinearLayout) view.findViewById(i.f.chosen_no_picture_comment_line);
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
            this.aKe.setVisibility(8);
        } else {
            this.aKe.setVisibility(0);
            this.aKe.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aKf.setVisibility(8);
        } else {
            this.aKf.setVisibility(0);
            this.aKd.setVisibility(0);
            this.aKd.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aKd.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aJY.setVisibility(8);
            } else {
                this.aJY.setVisibility(0);
                this.aJY.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aJZ.setVisibility(8);
            } else {
                this.aJZ.setVisibility(0);
                this.aJZ.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.auJ.setVisibility(8);
            return;
        }
        this.auJ.setVisibility(0);
        this.auJ.setText(tinfoVar._abstract);
    }
}
