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
import com.baidu.tieba.tbadkCore.util.q;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aRk;
    private TextView aRl;
    private TextView aRm;
    private TextView aRn;
    private View aRo;
    private TextView ahk;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRk = (TbImageView) view.findViewById(n.g.chosen_image_text_img);
        this.ahk = (TextView) view.findViewById(n.g.chosen_image_text_title);
        this.aRo = view.findViewById(n.g.chosen_image_text_divider);
        this.aRl = (TextView) view.findViewById(n.g.chosen_image_text_forum);
        this.aRm = (TextView) view.findViewById(n.g.chosen_image_text_praise);
        this.aRn = (TextView) view.findViewById(n.g.chosen_image_text_comment);
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
            this.aRk.d(str, 10, false);
            this.ahk.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aRl.setVisibility(8);
            } else {
                this.aRl.setVisibility(0);
                this.aRl.setText(UtilHelper.getFixedText(getContext().getString(n.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aRl.setOnClickListener(new b(this, tinfoVar));
            }
            if (tinfoVar.zan_num != null) {
                this.aRm.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.aRn.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.aRo.setVisibility(0);
            q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mD(String.valueOf(tinfoVar.forum_id))) {
                as.b(this.ahk, n.d.cp_cont_d, 1);
            } else {
                as.b(this.ahk, n.d.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        return true;
    }
}
