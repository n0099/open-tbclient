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
    private TextView aBu;
    private TextView aBv;
    private TextView aBw;
    private TextView aBx;
    private RelativeLayout aBy;
    private View.OnClickListener aBz;
    private TbImageView azu;
    private TbImageView azv;
    private TbImageView azw;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBz = new c(this);
        this.aBu = (TextView) view.findViewById(v.chosen_picture_title);
        this.aBv = (TextView) view.findViewById(v.chosen_picture_praise);
        this.aBw = (TextView) view.findViewById(v.chosen_picture_comment);
        this.aBx = (TextView) view.findViewById(v.chosen_picture_head);
        this.aBy = (RelativeLayout) view.findViewById(v.chosen_picture_pic_container);
        this.azu = (TbImageView) view.findViewById(v.chosen_picture_pic_one);
        this.azv = (TbImageView) view.findViewById(v.chosen_picture_pic_two);
        this.azw = (TbImageView) view.findViewById(v.chosen_picture_pic_thr);
        this.azu.setOnClickListener(this.aBz);
        this.azv.setOnClickListener(this.aBz);
        this.azw.setOnClickListener(this.aBz);
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
                this.aBu.setVisibility(8);
            } else {
                this.aBu.setVisibility(0);
                this.aBu.setText(tinfoVar.forum_name);
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aBx.setVisibility(8);
            } else {
                this.aBx.setVisibility(0);
                this.aBx.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aBv.setVisibility(8);
            } else {
                this.aBv.setVisibility(0);
                this.aBv.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aBw.setVisibility(8);
            } else {
                this.aBw.setVisibility(0);
                this.aBw.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (n.px().pB() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aBy.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.azw.setVisibility(0);
                        this.azw.c(str, 10, false);
                        this.azw.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.azv.setVisibility(0);
                        this.azv.c(str2, 10, false);
                        this.azv.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.azu.setVisibility(0);
                this.azu.c(str3, 10, false);
                this.azu.setTag(0);
                return;
            }
            this.aBy.setVisibility(8);
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
