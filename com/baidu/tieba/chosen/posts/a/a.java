package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.v;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.j.a<tinfo, com.baidu.tbadk.mvc.e.c> {
    private TextView aBu;
    private TextView aBv;
    private TextView aBw;
    private TextView aBx;
    private TextView alM;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBu = (TextView) view.findViewById(v.chosen_no_picture_title);
        this.aBv = (TextView) view.findViewById(v.chosen_no_picture_praise);
        this.aBw = (TextView) view.findViewById(v.chosen_no_picture_comment);
        this.aBx = (TextView) view.findViewById(v.chosen_no_picture_head);
        this.alM = (TextView) view.findViewById(v.chosen_no_picture_sub);
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.X(i == 1);
        layoutMode.h(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0066: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0080: IGET  (r2v1 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(tinfo tinfoVar) {
        super.A(tinfoVar);
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.aBu.setVisibility(8);
        } else {
            this.aBu.setVisibility(0);
            this.aBu.setText(tinfoVar.forum_name);
        }
        if (StringUtils.isNull(tinfoVar.title)) {
            this.aBx.setVisibility(8);
        } else {
            this.aBx.setVisibility(0);
            this.aBx.setText(tinfoVar.title);
        }
        if (tinfoVar.zan_num == null) {
            this.aBv.setVisibility(8);
        } else {
            this.aBv.setVisibility(0);
            this.aBv.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
        }
        if (tinfoVar.reply_num == null) {
            this.aBw.setVisibility(8);
        } else {
            this.aBw.setVisibility(0);
            this.aBw.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.alM.setVisibility(8);
            return;
        }
        this.alM.setVisibility(0);
        this.alM.setText(tinfoVar._abstract);
    }
}
