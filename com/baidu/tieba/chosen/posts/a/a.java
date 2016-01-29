package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.r;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aTr;
    private TextView aTs;
    private TextView aTt;
    private TextView aTu;
    private View aTv;
    private TextView apm;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aTr = (TbImageView) view.findViewById(t.g.chosen_image_text_img);
        this.apm = (TextView) view.findViewById(t.g.chosen_image_text_title);
        this.aTv = view.findViewById(t.g.chosen_image_text_divider);
        this.aTs = (TextView) view.findViewById(t.g.chosen_image_text_forum);
        this.aTt = (TextView) view.findViewById(t.g.chosen_image_text_praise);
        this.aTu = (TextView) view.findViewById(t.g.chosen_image_text_comment);
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
            this.aTr.d(str, 10, false);
            this.apm.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aTs.setVisibility(8);
            } else {
                this.aTs.setVisibility(0);
                this.aTs.setText(UtilHelper.getFixedText(getContext().getString(t.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aTs.setOnClickListener(new b(this, tinfoVar));
            }
            if (tinfoVar.zan_num != null) {
                this.aTt.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.aTu.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.aTv.setVisibility(0);
            r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mU(String.valueOf(tinfoVar.forum_id))) {
                ar.b(this.apm, t.d.cp_cont_d, 1);
            } else {
                ar.b(this.apm, t.d.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
