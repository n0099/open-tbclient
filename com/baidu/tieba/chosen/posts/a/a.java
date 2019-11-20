package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class a extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView dzT;
    private TextView eUp;
    private TextView eUq;
    private TextView eUr;
    private View eUs;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dzT = (TbImageView) view.findViewById(R.id.chosen_image_text_img);
        this.title = (TextView) view.findViewById(R.id.chosen_image_text_title);
        this.eUs = view.findViewById(R.id.chosen_image_text_divider);
        this.eUp = (TextView) view.findViewById(R.id.chosen_image_text_forum);
        this.eUq = (TextView) view.findViewById(R.id.chosen_image_text_praise);
        this.eUr = (TextView) view.findViewById(R.id.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(final tinfo tinfoVar) {
        super.ab(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.dzT.startLoad(str, 10, false);
            this.title.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.eUp.setVisibility(8);
            } else {
                this.eUp.setVisibility(0);
                this.eUp.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.eUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2 = tinfoVar.forum_name;
                        if (aq.isForumName(str2)) {
                            TiebaStatic.eventStat(a.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.getActivity()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (tinfoVar.zan_num != null) {
                this.eUq.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.eUr.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.eUs.setVisibility(0);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(String.valueOf(tinfoVar.forum_id))) {
                am.setViewTextColor(this.title, R.color.cp_cont_d, 1);
            } else {
                am.setViewTextColor(this.title, R.color.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        return true;
    }
}
