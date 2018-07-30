package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView bwh;
    private TextView cGW;
    private TextView cGX;
    private TextView cGY;
    private View cGZ;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bwh = (TbImageView) view.findViewById(d.g.chosen_image_text_img);
        this.title = (TextView) view.findViewById(d.g.chosen_image_text_title);
        this.cGZ = view.findViewById(d.g.chosen_image_text_divider);
        this.cGW = (TextView) view.findViewById(d.g.chosen_image_text_forum);
        this.cGX = (TextView) view.findViewById(d.g.chosen_image_text_praise);
        this.cGY = (TextView) view.findViewById(d.g.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(final tinfo tinfoVar) {
        super.G(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.bwh.startLoad(str, 10, false);
            this.title.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.cGW.setVisibility(8);
            } else {
                this.cGW.setVisibility(0);
                this.cGW.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.cGW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2 = tinfoVar.forum_name;
                        if (ap.bf(str2)) {
                            TiebaStatic.eventStat(a.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.getActivity()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (tinfoVar.zan_num != null) {
                this.cGX.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.cGY.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.cGZ.setVisibility(0);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tY(String.valueOf(tinfoVar.forum_id))) {
                am.c(this.title, d.C0140d.cp_cont_d, 1);
            } else {
                am.c(this.title, d.C0140d.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
