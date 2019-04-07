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
/* loaded from: classes5.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView buc;
    private TextView cnA;
    private TextView eqf;
    private TextView eqg;
    private TextView eqk;
    private LinearLayout eql;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.buc = (TextView) view.findViewById(d.g.chosen_no_picture_title);
        this.eqf = (TextView) view.findViewById(d.g.chosen_no_picture_praise);
        this.eqg = (TextView) view.findViewById(d.g.chosen_no_picture_comment);
        this.eqk = (TextView) view.findViewById(d.g.chosen_no_picture_head);
        this.cnA = (TextView) view.findViewById(d.g.chosen_no_picture_sub);
        this.eql = (LinearLayout) view.findViewById(d.g.chosen_no_picture_comment_line);
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
    public void ad(final tinfo tinfoVar) {
        super.ad(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.eqk.setVisibility(8);
        } else {
            this.eqk.setVisibility(0);
            this.eqk.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.eql.setVisibility(8);
        } else {
            this.eql.setVisibility(0);
            this.buc.setVisibility(0);
            this.buc.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.buc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ap.bv(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.eqf.setVisibility(8);
            } else {
                this.eqf.setVisibility(0);
                this.eqf.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eqg.setVisibility(8);
            } else {
                this.eqg.setVisibility(0);
                this.eqg.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.cnA.setVisibility(8);
            return;
        }
        this.cnA.setVisibility(0);
        this.cnA.setText(tinfoVar._abstract);
    }
}
