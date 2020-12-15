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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes23.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView eAz;
    private TextView ioQ;
    private TextView ioR;
    private TextView ioV;
    private LinearLayout ioW;
    private TextView subTextView;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eAz = (TextView) view.findViewById(R.id.chosen_no_picture_title);
        this.ioQ = (TextView) view.findViewById(R.id.chosen_no_picture_praise);
        this.ioR = (TextView) view.findViewById(R.id.chosen_no_picture_comment);
        this.ioV = (TextView) view.findViewById(R.id.chosen_no_picture_head);
        this.subTextView = (TextView) view.findViewById(R.id.chosen_no_picture_sub);
        this.ioW = (LinearLayout) view.findViewById(R.id.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(final tinfo tinfoVar) {
        super.au(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.ioV.setVisibility(8);
        } else {
            this.ioV.setVisibility(0);
            this.ioV.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.ioW.setVisibility(8);
        } else {
            this.ioW.setVisibility(0);
            this.eAz.setVisibility(0);
            this.eAz.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.eAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (au.isForumName(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.ioQ.setVisibility(8);
            } else {
                this.ioQ.setVisibility(0);
                this.ioQ.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.ioR.setVisibility(8);
            } else {
                this.ioR.setVisibility(0);
                this.ioR.setText(tinfoVar.reply_num + "");
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
