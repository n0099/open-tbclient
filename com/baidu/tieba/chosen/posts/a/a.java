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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes17.dex */
public class a extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView fxE;
    private TextView hbM;
    private TextView hbN;
    private TextView hbO;
    private View hbP;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fxE = (TbImageView) view.findViewById(R.id.chosen_image_text_img);
        this.title = (TextView) view.findViewById(R.id.chosen_image_text_title);
        this.hbP = view.findViewById(R.id.chosen_image_text_divider);
        this.hbM = (TextView) view.findViewById(R.id.chosen_image_text_forum);
        this.hbN = (TextView) view.findViewById(R.id.chosen_image_text_praise);
        this.hbO = (TextView) view.findViewById(R.id.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ao(final tinfo tinfoVar) {
        super.ao(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.fxE.startLoad(str, 10, false);
            this.title.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.hbM.setVisibility(8);
            } else {
                this.hbM.setVisibility(0);
                this.hbM.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.hbM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2 = tinfoVar.forum_name;
                        if (as.isForumName(str2)) {
                            TiebaStatic.eventStat(a.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.getActivity()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (tinfoVar.zan_num != null) {
                this.hbN.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.hbO.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.hbP.setVisibility(0);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.NZ(String.valueOf(tinfoVar.forum_id))) {
                ao.setViewTextColor(this.title, R.color.cp_cont_d, 1);
            } else {
                ao.setViewTextColor(this.title, R.color.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        return true;
    }
}
