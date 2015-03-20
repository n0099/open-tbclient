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
    private TextView aBm;
    private TextView aBn;
    private TextView aBo;
    private TextView aBp;
    private TextView alE;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBm = (TextView) view.findViewById(v.chosen_no_picture_title);
        this.aBn = (TextView) view.findViewById(v.chosen_no_picture_praise);
        this.aBo = (TextView) view.findViewById(v.chosen_no_picture_comment);
        this.aBp = (TextView) view.findViewById(v.chosen_no_picture_head);
        this.alE = (TextView) view.findViewById(v.chosen_no_picture_sub);
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
            this.aBm.setVisibility(8);
        } else {
            this.aBm.setVisibility(0);
            this.aBm.setText(tinfoVar.forum_name);
        }
        if (StringUtils.isNull(tinfoVar.title)) {
            this.aBp.setVisibility(8);
        } else {
            this.aBp.setVisibility(0);
            this.aBp.setText(tinfoVar.title);
        }
        if (tinfoVar.zan_num == null) {
            this.aBn.setVisibility(8);
        } else {
            this.aBn.setVisibility(0);
            this.aBn.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
        }
        if (tinfoVar.reply_num == null) {
            this.aBo.setVisibility(8);
        } else {
            this.aBo.setVisibility(0);
            this.aBo.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.alE.setVisibility(8);
            return;
        }
        this.alE.setVisibility(0);
        this.alE.setText(tinfoVar._abstract);
    }
}
