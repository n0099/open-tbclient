package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView cGN;
    private TextView fMh;
    private TextView fMi;
    private TextView fMm;
    private LinearLayout fMn;
    private TextView subTextView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cGN = (TextView) view.findViewById(R.id.chosen_no_picture_title);
        this.fMh = (TextView) view.findViewById(R.id.chosen_no_picture_praise);
        this.fMi = (TextView) view.findViewById(R.id.chosen_no_picture_comment);
        this.fMm = (TextView) view.findViewById(R.id.chosen_no_picture_head);
        this.subTextView = (TextView) view.findViewById(R.id.chosen_no_picture_sub);
        this.fMn = (LinearLayout) view.findViewById(R.id.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(final tinfo tinfoVar) {
        super.ag(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.fMm.setVisibility(8);
        } else {
            this.fMm.setVisibility(0);
            this.fMm.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.fMn.setVisibility(8);
        } else {
            this.fMn.setVisibility(0);
            this.cGN.setVisibility(0);
            this.cGN.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.cGN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (aq.isForumName(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.fMh.setVisibility(8);
            } else {
                this.fMh.setVisibility(0);
                this.fMh.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.fMi.setVisibility(8);
            } else {
                this.fMi.setVisibility(0);
                this.fMi.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(tinfoVar._abstract);
    }
}
