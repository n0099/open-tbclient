package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aLi;
    private TbImageView aLj;
    private TbImageView aLk;
    private TextView aOS;
    private TextView aRm;
    private TextView aRn;
    private TextView aRr;
    private RelativeLayout aRv;
    private View.OnClickListener aRw;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRw = new f(this);
        this.aOS = (TextView) view.findViewById(n.g.chosen_picture_title);
        this.aRm = (TextView) view.findViewById(n.g.chosen_picture_praise);
        this.aRn = (TextView) view.findViewById(n.g.chosen_picture_comment);
        this.aRr = (TextView) view.findViewById(n.g.chosen_picture_head);
        this.aRv = (RelativeLayout) view.findViewById(n.g.chosen_picture_pic_container);
        this.aLi = (TbImageView) view.findViewById(n.g.chosen_picture_pic_one);
        this.aLj = (TbImageView) view.findViewById(n.g.chosen_picture_pic_two);
        this.aLk = (TbImageView) view.findViewById(n.g.chosen_picture_pic_thr);
        this.aLi.setOnClickListener(this.aRw);
        this.aLj.setOnClickListener(this.aRw);
        this.aLk.setOnClickListener(this.aRw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x007d: IGET  (r2v3 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0097: IGET  (r2v4 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(tinfo tinfoVar) {
        super.B(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aOS.setVisibility(8);
            } else {
                this.aOS.setVisibility(0);
                this.aOS.setText(UtilHelper.getFixedText(getContext().getString(n.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aOS.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aRr.setVisibility(8);
            } else {
                this.aRr.setVisibility(0);
                this.aRr.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aRm.setVisibility(8);
            } else {
                this.aRm.setVisibility(0);
                this.aRm.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aRn.setVisibility(8);
            } else {
                this.aRn.setVisibility(0);
                this.aRn.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.qQ().qW() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aRv.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aLk.setVisibility(0);
                        this.aLk.d(str, 10, false);
                        this.aLk.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aLj.setVisibility(0);
                        this.aLj.d(str2, 10, false);
                        this.aLj.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aLi.setVisibility(0);
                this.aLi.d(str3, 10, false);
                this.aLi.setTag(0);
                return;
            }
            this.aRv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ac(i == 1);
        layoutMode.k(getRootView());
        return true;
    }
}
