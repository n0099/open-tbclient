package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.j.a<tinfo, com.baidu.tbadk.mvc.e.c> {
    private TbImageView aBg;
    private TbImageView aBh;
    private TbImageView aBi;
    private TextView aDl;
    private TextView aDm;
    private TextView aDq;
    private TextView aDr;
    private RelativeLayout aDv;
    private View.OnClickListener aDw;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aDw = new f(this);
        this.aDq = (TextView) view.findViewById(q.chosen_picture_title);
        this.aDl = (TextView) view.findViewById(q.chosen_picture_praise);
        this.aDm = (TextView) view.findViewById(q.chosen_picture_comment);
        this.aDr = (TextView) view.findViewById(q.chosen_picture_head);
        this.aDv = (RelativeLayout) view.findViewById(q.chosen_picture_pic_container);
        this.aBg = (TbImageView) view.findViewById(q.chosen_picture_pic_one);
        this.aBh = (TbImageView) view.findViewById(q.chosen_picture_pic_two);
        this.aBi = (TbImageView) view.findViewById(q.chosen_picture_pic_thr);
        this.aBg.setOnClickListener(this.aDw);
        this.aBh.setOnClickListener(this.aDw);
        this.aBi.setOnClickListener(this.aDw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x007d: IGET  (r2v3 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0097: IGET  (r2v4 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(tinfo tinfoVar) {
        super.z(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aDq.setVisibility(8);
            } else {
                this.aDq.setVisibility(0);
                this.aDq.setText(UtilHelper.getFixedText(getContext().getString(t.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aDq.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aDr.setVisibility(8);
            } else {
                this.aDr.setVisibility(0);
                this.aDr.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aDl.setVisibility(8);
            } else {
                this.aDl.setVisibility(0);
                this.aDl.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aDm.setVisibility(8);
            } else {
                this.aDm.setVisibility(0);
                this.aDm.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (n.qc().qg() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aDv.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aBi.setVisibility(0);
                        this.aBi.c(str, 10, false);
                        this.aBi.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aBh.setVisibility(0);
                        this.aBh.c(str2, 10, false);
                        this.aBh.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aBg.setVisibility(0);
                this.aBg.c(str3, 10, false);
                this.aBg.setTag(0);
                return;
            }
            this.aDv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.j(getRootView());
        return true;
    }
}
