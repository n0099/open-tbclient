package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aNr;
    private TextView aNs;
    private TextView aNt;
    private TextView aNu;
    private View aNv;
    private TextView agd;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNr = (TbImageView) view.findViewById(n.f.chosen_image_text_img);
        this.agd = (TextView) view.findViewById(n.f.chosen_image_text_title);
        this.aNv = view.findViewById(n.f.chosen_image_text_divider);
        this.aNs = (TextView) view.findViewById(n.f.chosen_image_text_forum);
        this.aNt = (TextView) view.findViewById(n.f.chosen_image_text_praise);
        this.aNu = (TextView) view.findViewById(n.f.chosen_image_text_comment);
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
            this.aNr.d(str, 10, false);
            this.agd.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aNs.setVisibility(8);
            } else {
                this.aNs.setVisibility(0);
                this.aNs.setText(UtilHelper.getFixedText(getContext().getString(n.i.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aNs.setOnClickListener(new b(this, tinfoVar));
            }
            if (tinfoVar.zan_num != null) {
                this.aNt.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.aNu.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.aNv.setVisibility(0);
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mF(String.valueOf(tinfoVar.forum_id))) {
                as.b(this.agd, n.c.cp_cont_d, 1);
            } else {
                as.b(this.agd, n.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
