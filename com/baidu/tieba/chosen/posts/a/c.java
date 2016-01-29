package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aQR;
    private TextView aTt;
    private TextView aTu;
    private TextView aTy;
    private LinearLayout aTz;
    private TextView axW;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aQR = (TextView) view.findViewById(t.g.chosen_no_picture_title);
        this.aTt = (TextView) view.findViewById(t.g.chosen_no_picture_praise);
        this.aTu = (TextView) view.findViewById(t.g.chosen_no_picture_comment);
        this.aTy = (TextView) view.findViewById(t.g.chosen_no_picture_head);
        this.axW = (TextView) view.findViewById(t.g.chosen_no_picture_sub);
        this.aTz = (LinearLayout) view.findViewById(t.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ac(i == 1);
        layoutMode.x(getRootView());
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
            this.aTy.setVisibility(8);
        } else {
            this.aTy.setVisibility(0);
            this.aTy.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aTz.setVisibility(8);
        } else {
            this.aTz.setVisibility(0);
            this.aQR.setVisibility(0);
            this.aQR.setText(UtilHelper.getFixedText(getContext().getString(t.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aQR.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aTt.setVisibility(8);
            } else {
                this.aTt.setVisibility(0);
                this.aTt.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aTu.setVisibility(8);
            } else {
                this.aTu.setVisibility(0);
                this.aTu.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.axW.setVisibility(8);
            return;
        }
        this.axW.setVisibility(0);
        this.axW.setText(tinfoVar._abstract);
    }
}
