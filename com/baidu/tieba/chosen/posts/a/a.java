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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.util.e;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class a extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView cbV;
    private TextView dfh;
    private TextView dfi;
    private TextView dfj;
    private View dfk;
    private TextView title;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cbV = (TbImageView) view.findViewById(d.g.chosen_image_text_img);
        this.title = (TextView) view.findViewById(d.g.chosen_image_text_title);
        this.dfk = view.findViewById(d.g.chosen_image_text_divider);
        this.dfh = (TextView) view.findViewById(d.g.chosen_image_text_forum);
        this.dfi = (TextView) view.findViewById(d.g.chosen_image_text_praise);
        this.dfj = (TextView) view.findViewById(d.g.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(final tinfo tinfoVar) {
        super.aI(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.cbV.startLoad(str, 10, false);
            this.title.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dfh.setVisibility(8);
            } else {
                this.dfh.setVisibility(0);
                this.dfh.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str2 = tinfoVar.forum_name;
                        if (am.aT(str2)) {
                            TiebaStatic.eventStat(a.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.getActivity()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (tinfoVar.zan_num != null) {
                this.dfi.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.dfj.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.dfk.setVisibility(0);
            e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sW(String.valueOf(tinfoVar.forum_id))) {
                aj.e(this.title, d.C0140d.cp_cont_d, 1);
            } else {
                aj.e(this.title, d.C0140d.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
