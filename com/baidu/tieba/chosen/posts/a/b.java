package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aRq;
    private TextView abu;
    private TextView cEr;
    private TextView cEs;
    private TextView cEw;
    private LinearLayout cEx;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.abu = (TextView) view.findViewById(d.g.chosen_no_picture_title);
        this.cEr = (TextView) view.findViewById(d.g.chosen_no_picture_praise);
        this.cEs = (TextView) view.findViewById(d.g.chosen_no_picture_comment);
        this.cEw = (TextView) view.findViewById(d.g.chosen_no_picture_head);
        this.aRq = (TextView) view.findViewById(d.g.chosen_no_picture_sub);
        this.cEx = (LinearLayout) view.findViewById(d.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(final tinfo tinfoVar) {
        super.G(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.cEw.setVisibility(8);
        } else {
            this.cEw.setVisibility(0);
            this.cEw.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.cEx.setVisibility(8);
        } else {
            this.cEx.setVisibility(0);
            this.abu.setVisibility(0);
            this.abu.setText(UtilHelper.getFixedText(getContext().getString(d.k.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.abu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ap.be(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.cEr.setVisibility(8);
            } else {
                this.cEr.setVisibility(0);
                this.cEr.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cEs.setVisibility(8);
            } else {
                this.cEs.setVisibility(0);
                this.cEs.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.aRq.setVisibility(8);
            return;
        }
        this.aRq.setVisibility(0);
        this.aRq.setText(tinfoVar._abstract);
    }
}
