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
import com.baidu.tieba.f;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aRn;
    private TextView aaX;
    private TextView cGU;
    private TextView cGV;
    private TextView cGZ;
    private LinearLayout cHa;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aaX = (TextView) view.findViewById(f.g.chosen_no_picture_title);
        this.cGU = (TextView) view.findViewById(f.g.chosen_no_picture_praise);
        this.cGV = (TextView) view.findViewById(f.g.chosen_no_picture_comment);
        this.cGZ = (TextView) view.findViewById(f.g.chosen_no_picture_head);
        this.aRn = (TextView) view.findViewById(f.g.chosen_no_picture_sub);
        this.cHa = (LinearLayout) view.findViewById(f.g.chosen_no_picture_comment_line);
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
            this.cGZ.setVisibility(8);
        } else {
            this.cGZ.setVisibility(0);
            this.cGZ.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.cHa.setVisibility(8);
        } else {
            this.cHa.setVisibility(0);
            this.aaX.setVisibility(0);
            this.aaX.setText(UtilHelper.getFixedText(getContext().getString(f.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aaX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ap.bf(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.cGU.setVisibility(8);
            } else {
                this.cGU.setVisibility(0);
                this.cGU.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cGV.setVisibility(8);
            } else {
                this.cGV.setVisibility(0);
                this.cGV.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.aRn.setVisibility(8);
            return;
        }
        this.aRn.setVisibility(0);
        this.aRn.setText(tinfoVar._abstract);
    }
}
