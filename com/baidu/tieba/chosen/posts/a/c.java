package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aOS;
    private TextView aRm;
    private TextView aRn;
    private TextView aRr;
    private LinearLayout aRs;
    private TextView axf;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOS = (TextView) view.findViewById(n.g.chosen_no_picture_title);
        this.aRm = (TextView) view.findViewById(n.g.chosen_no_picture_praise);
        this.aRn = (TextView) view.findViewById(n.g.chosen_no_picture_comment);
        this.aRr = (TextView) view.findViewById(n.g.chosen_no_picture_head);
        this.axf = (TextView) view.findViewById(n.g.chosen_no_picture_sub);
        this.aRs = (LinearLayout) view.findViewById(n.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ac(i == 1);
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
            this.aRr.setVisibility(8);
        } else {
            this.aRr.setVisibility(0);
            this.aRr.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aRs.setVisibility(8);
        } else {
            this.aRs.setVisibility(0);
            this.aOS.setVisibility(0);
            this.aOS.setText(UtilHelper.getFixedText(getContext().getString(n.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aOS.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aRm.setVisibility(8);
            } else {
                this.aRm.setVisibility(0);
                this.aRm.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aRn.setVisibility(8);
            } else {
                this.aRn.setVisibility(0);
                this.aRn.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.axf.setVisibility(8);
            return;
        }
        this.axf.setVisibility(0);
        this.axf.setText(tinfoVar._abstract);
    }
}
