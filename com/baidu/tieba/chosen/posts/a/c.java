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
    private LinearLayout aNA;
    private TextView aNt;
    private TextView aNu;
    private TextView aNy;
    private TextView aNz;
    private TextView avB;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNy = (TextView) view.findViewById(n.f.chosen_no_picture_title);
        this.aNt = (TextView) view.findViewById(n.f.chosen_no_picture_praise);
        this.aNu = (TextView) view.findViewById(n.f.chosen_no_picture_comment);
        this.aNz = (TextView) view.findViewById(n.f.chosen_no_picture_head);
        this.avB = (TextView) view.findViewById(n.f.chosen_no_picture_sub);
        this.aNA = (LinearLayout) view.findViewById(n.f.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.af(i == 1);
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
            this.aNz.setVisibility(8);
        } else {
            this.aNz.setVisibility(0);
            this.aNz.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aNA.setVisibility(8);
        } else {
            this.aNA.setVisibility(0);
            this.aNy.setVisibility(0);
            this.aNy.setText(UtilHelper.getFixedText(getContext().getString(n.i.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aNy.setOnClickListener(new d(this, tinfoVar));
            if (tinfoVar.zan_num == null) {
                this.aNt.setVisibility(8);
            } else {
                this.aNt.setVisibility(0);
                this.aNt.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aNu.setVisibility(8);
            } else {
                this.aNu.setVisibility(0);
                this.aNu.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.avB.setVisibility(8);
            return;
        }
        this.avB.setVisibility(0);
        this.avB.setText(tinfoVar._abstract);
    }
}
