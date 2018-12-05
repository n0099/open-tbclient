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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView amN;
    private TextView bdp;
    private TextView dcT;
    private TextView dcU;
    private TextView dcY;
    private LinearLayout dcZ;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.amN = (TextView) view.findViewById(e.g.chosen_no_picture_title);
        this.dcT = (TextView) view.findViewById(e.g.chosen_no_picture_praise);
        this.dcU = (TextView) view.findViewById(e.g.chosen_no_picture_comment);
        this.dcY = (TextView) view.findViewById(e.g.chosen_no_picture_head);
        this.bdp = (TextView) view.findViewById(e.g.chosen_no_picture_sub);
        this.dcZ = (LinearLayout) view.findViewById(e.g.chosen_no_picture_comment_line);
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
    public void L(final tinfo tinfoVar) {
        super.L(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.dcY.setVisibility(8);
        } else {
            this.dcY.setVisibility(0);
            this.dcY.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.dcZ.setVisibility(8);
        } else {
            this.dcZ.setVisibility(0);
            this.amN.setVisibility(0);
            this.amN.setText(UtilHelper.getFixedText(getContext().getString(e.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.amN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ao.bv(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.dcT.setVisibility(8);
            } else {
                this.dcT.setVisibility(0);
                this.dcT.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.dcU.setVisibility(8);
            } else {
                this.dcU.setVisibility(0);
                this.dcU.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.bdp.setVisibility(8);
            return;
        }
        this.bdp.setVisibility(0);
        this.bdp.setText(tinfoVar._abstract);
    }
}
