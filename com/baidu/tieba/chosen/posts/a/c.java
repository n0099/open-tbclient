package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.j.a<tinfo, com.baidu.tbadk.mvc.e.c> {
    private TextView aDl;
    private TextView aDm;
    private TextView aDq;
    private TextView aDr;
    private LinearLayout aDs;
    private TextView amN;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aDq = (TextView) view.findViewById(q.chosen_no_picture_title);
        this.aDl = (TextView) view.findViewById(q.chosen_no_picture_praise);
        this.aDm = (TextView) view.findViewById(q.chosen_no_picture_comment);
        this.aDr = (TextView) view.findViewById(q.chosen_no_picture_head);
        this.amN = (TextView) view.findViewById(q.chosen_no_picture_sub);
        this.aDs = (LinearLayout) view.findViewById(q.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.j(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0089: IGET  (r2v3 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x00a3: IGET  (r2v4 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(tinfo tinfoVar) {
        super.z(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.aDr.setVisibility(8);
        } else {
            this.aDr.setVisibility(0);
            this.aDr.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aDs.setVisibility(8);
        } else {
            this.aDs.setVisibility(0);
            this.aDq.setVisibility(0);
            this.aDq.setText(UtilHelper.getFixedText(getContext().getString(t.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aDq.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aDl.setVisibility(8);
            } else {
                this.aDl.setVisibility(0);
                this.aDl.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aDm.setVisibility(8);
            } else {
                this.aDm.setVisibility(0);
                this.aDm.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.amN.setVisibility(8);
            return;
        }
        this.amN.setVisibility(0);
        this.amN.setText(tinfoVar._abstract);
    }
}
