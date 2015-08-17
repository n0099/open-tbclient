package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.m;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aKG;
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private View aKK;
    private TextView anH;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKG = (TbImageView) view.findViewById(i.f.chosen_image_text_img);
        this.anH = (TextView) view.findViewById(i.f.chosen_image_text_title);
        this.aKK = view.findViewById(i.f.chosen_image_text_divider);
        this.aKH = (TextView) view.findViewById(i.f.chosen_image_text_forum);
        this.aKI = (TextView) view.findViewById(i.f.chosen_image_text_praise);
        this.aKJ = (TextView) view.findViewById(i.f.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(tinfo tinfoVar) {
        super.A(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.aKG.d(str, 10, false);
            this.anH.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aKH.setVisibility(8);
            } else {
                this.aKH.setVisibility(0);
                this.aKH.setText(UtilHelper.getFixedText(getContext().getString(i.C0057i.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aKH.setOnClickListener(new b(this, tinfoVar));
            }
            if (tinfoVar.zan_num != null) {
                this.aKI.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.aKJ.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.aKK.setVisibility(0);
            m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.kE(String.valueOf(tinfoVar.forum_id))) {
                al.b(this.anH, i.c.cp_cont_d, 1);
            } else {
                al.b(this.anH, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
