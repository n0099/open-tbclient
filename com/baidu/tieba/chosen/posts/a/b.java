package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.v;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<tinfo, com.baidu.tbadk.mvc.e.c> {
    private TextView aBm;
    private TextView aBn;
    private TextView aBo;
    private TextView aBp;
    private RelativeLayout aBq;
    private View.OnClickListener aBr;
    private TbImageView azm;
    private TbImageView azn;
    private TbImageView azo;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBr = new c(this);
        this.aBm = (TextView) view.findViewById(v.chosen_picture_title);
        this.aBn = (TextView) view.findViewById(v.chosen_picture_praise);
        this.aBo = (TextView) view.findViewById(v.chosen_picture_comment);
        this.aBp = (TextView) view.findViewById(v.chosen_picture_head);
        this.aBq = (RelativeLayout) view.findViewById(v.chosen_picture_pic_container);
        this.azm = (TbImageView) view.findViewById(v.chosen_picture_pic_one);
        this.azn = (TbImageView) view.findViewById(v.chosen_picture_pic_two);
        this.azo = (TbImageView) view.findViewById(v.chosen_picture_pic_thr);
        this.azm.setOnClickListener(this.aBr);
        this.azn.setOnClickListener(this.aBr);
        this.azo.setOnClickListener(this.aBr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x005f: IGET  (r2v0 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0079: IGET  (r2v1 java.lang.Integer A[REMOVE]) = (r6v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(tinfo tinfoVar) {
        super.A(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aBm.setVisibility(8);
            } else {
                this.aBm.setVisibility(0);
                this.aBm.setText(tinfoVar.forum_name);
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aBp.setVisibility(8);
            } else {
                this.aBp.setVisibility(0);
                this.aBp.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aBn.setVisibility(8);
            } else {
                this.aBn.setVisibility(0);
                this.aBn.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aBo.setVisibility(8);
            } else {
                this.aBo.setVisibility(0);
                this.aBo.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (n.px().pB() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aBq.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.azo.setVisibility(0);
                        this.azo.c(str, 10, false);
                        this.azo.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.azn.setVisibility(0);
                        this.azn.c(str2, 10, false);
                        this.azn.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.azm.setVisibility(0);
                this.azm.c(str3, 10, false);
                this.azm.setTag(0);
                return;
            }
            this.aBq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.X(i == 1);
        layoutMode.h(getRootView());
        return true;
    }
}
