package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.l;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.j.a<tinfo, com.baidu.tbadk.mvc.e.c> {
    private TbImageView aDj;
    private TextView aDk;
    private TextView aDl;
    private TextView aDm;
    private View aDn;
    private TextView aiA;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aDj = (TbImageView) view.findViewById(q.chosen_image_text_img);
        this.aiA = (TextView) view.findViewById(q.chosen_image_text_title);
        this.aDn = view.findViewById(q.chosen_image_text_divider);
        this.aDk = (TextView) view.findViewById(q.chosen_image_text_forum);
        this.aDl = (TextView) view.findViewById(q.chosen_image_text_praise);
        this.aDm = (TextView) view.findViewById(q.chosen_image_text_comment);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(tinfo tinfoVar) {
        super.z(tinfoVar);
        if (tinfoVar != null) {
            String str = null;
            if (tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                str = tinfoVar.pics.get(0).small_pic;
            }
            this.aDj.c(str, 10, false);
            this.aiA.setText(tinfoVar.title);
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aDk.setVisibility(8);
            } else {
                this.aDk.setVisibility(0);
                this.aDk.setText(UtilHelper.getFixedText(getContext().getString(t.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aDk.setOnClickListener(new b(this, tinfoVar));
            }
            if (tinfoVar.zan_num != null) {
                this.aDl.setText(String.valueOf(tinfoVar.zan_num));
            }
            if (tinfoVar.reply_num != null) {
                this.aDm.setText(String.valueOf(tinfoVar.reply_num));
            }
            this.aDn.setVisibility(0);
            l readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.jL(String.valueOf(tinfoVar.forum_id))) {
                ay.b(this.aiA, n.cp_cont_d, 1);
            } else {
                ay.b(this.aiA, n.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }
}
