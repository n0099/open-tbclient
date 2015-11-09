package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aIQ;
    private TextView aIR;
    private TextView aIS;
    private TextView aIT;
    private View aIU;
    private TextView alz;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aIQ = (TbImageView) view.findViewById(i.f.chosen_image_text_img);
        this.alz = (TextView) view.findViewById(i.f.chosen_image_text_title);
        this.aIU = view.findViewById(i.f.chosen_image_text_divider);
        this.aIR = (TextView) view.findViewById(i.f.chosen_image_text_forum);
        this.aIS = (TextView) view.findViewById(i.f.chosen_image_text_praise);
        this.aIT = (TextView) view.findViewById(i.f.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(tinfo tinfoVar) {
        super.B(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.aIQ.d(str, 10, false);
            this.alz.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aIR.setVisibility(8);
            } else {
                this.aIR.setVisibility(0);
                this.aIR.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aIR.setOnClickListener(new b(this, tinfoVar));
            }
            if (tinfoVar.zan_num != null) {
                this.aIS.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.aIT.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.aIU.setVisibility(0);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(tinfoVar.forum_id))) {
                an.b(this.alz, i.c.cp_cont_d, 1);
            } else {
                an.b(this.alz, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        return true;
    }
}
