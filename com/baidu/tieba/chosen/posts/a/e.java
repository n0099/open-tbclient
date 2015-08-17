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
import com.baidu.tieba.i;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aIB;
    private TbImageView aIC;
    private TbImageView aID;
    private TextView aKI;
    private TextView aKJ;
    private TextView aKN;
    private TextView aKO;
    private RelativeLayout aKS;
    private View.OnClickListener aKT;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKT = new f(this);
        this.aKN = (TextView) view.findViewById(i.f.chosen_picture_title);
        this.aKI = (TextView) view.findViewById(i.f.chosen_picture_praise);
        this.aKJ = (TextView) view.findViewById(i.f.chosen_picture_comment);
        this.aKO = (TextView) view.findViewById(i.f.chosen_picture_head);
        this.aKS = (RelativeLayout) view.findViewById(i.f.chosen_picture_pic_container);
        this.aIB = (TbImageView) view.findViewById(i.f.chosen_picture_pic_one);
        this.aIC = (TbImageView) view.findViewById(i.f.chosen_picture_pic_two);
        this.aID = (TbImageView) view.findViewById(i.f.chosen_picture_pic_thr);
        this.aIB.setOnClickListener(this.aKT);
        this.aIC.setOnClickListener(this.aKT);
        this.aID.setOnClickListener(this.aKT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x007d: IGET  (r2v3 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.zan_num java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0097: IGET  (r2v4 java.lang.Integer A[REMOVE]) = (r7v0 tbclient.HotThread.tinfo) tbclient.HotThread.tinfo.reply_num java.lang.Integer)] */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(tinfo tinfoVar) {
        super.A(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aKN.setVisibility(8);
            } else {
                this.aKN.setVisibility(0);
                this.aKN.setText(UtilHelper.getFixedText(getContext().getString(i.C0057i.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aKN.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aKO.setVisibility(8);
            } else {
                this.aKO.setVisibility(0);
                this.aKO.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aKI.setVisibility(8);
            } else {
                this.aKI.setVisibility(0);
                this.aKI.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aKJ.setVisibility(8);
            } else {
                this.aKJ.setVisibility(0);
                this.aKJ.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.rd().rh() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aKS.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aID.setVisibility(0);
                        this.aID.d(str, 10, false);
                        this.aID.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aIC.setVisibility(0);
                        this.aIC.d(str2, 10, false);
                        this.aIC.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aIB.setVisibility(0);
                this.aIB.d(str3, 10, false);
                this.aIB.setTag(0);
                return;
            }
            this.aKS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(getRootView());
        return true;
    }
}
