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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView bCd;
    private TextView cwX;
    private TextView eKK;
    private TextView eKL;
    private TextView eKP;
    private LinearLayout eKQ;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bCd = (TextView) view.findViewById(R.id.chosen_no_picture_title);
        this.eKK = (TextView) view.findViewById(R.id.chosen_no_picture_praise);
        this.eKL = (TextView) view.findViewById(R.id.chosen_no_picture_comment);
        this.eKP = (TextView) view.findViewById(R.id.chosen_no_picture_head);
        this.cwX = (TextView) view.findViewById(R.id.chosen_no_picture_sub);
        this.eKQ = (LinearLayout) view.findViewById(R.id.chosen_no_picture_comment_line);
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
    public void af(final tinfo tinfoVar) {
        super.af(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.eKP.setVisibility(8);
        } else {
            this.eKP.setVisibility(0);
            this.eKP.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.eKQ.setVisibility(8);
        } else {
            this.eKQ.setVisibility(0);
            this.bCd.setVisibility(0);
            this.bCd.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.bCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (aq.bg(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.eKK.setVisibility(8);
            } else {
                this.eKK.setVisibility(0);
                this.eKK.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eKL.setVisibility(8);
            } else {
                this.eKL.setVisibility(0);
                this.eKL.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.cwX.setVisibility(8);
            return;
        }
        this.cwX.setVisibility(0);
        this.cwX.setText(tinfoVar._abstract);
    }
}
