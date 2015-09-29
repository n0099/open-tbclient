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
    private TbImageView aHG;
    private TbImageView aHH;
    private TbImageView aHI;
    private TextView aJN;
    private TextView aJO;
    private TextView aJS;
    private TextView aJT;
    private RelativeLayout aJX;
    private View.OnClickListener aJY;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJY = new f(this);
        this.aJS = (TextView) view.findViewById(i.f.chosen_picture_title);
        this.aJN = (TextView) view.findViewById(i.f.chosen_picture_praise);
        this.aJO = (TextView) view.findViewById(i.f.chosen_picture_comment);
        this.aJT = (TextView) view.findViewById(i.f.chosen_picture_head);
        this.aJX = (RelativeLayout) view.findViewById(i.f.chosen_picture_pic_container);
        this.aHG = (TbImageView) view.findViewById(i.f.chosen_picture_pic_one);
        this.aHH = (TbImageView) view.findViewById(i.f.chosen_picture_pic_two);
        this.aHI = (TbImageView) view.findViewById(i.f.chosen_picture_pic_thr);
        this.aHG.setOnClickListener(this.aJY);
        this.aHH.setOnClickListener(this.aJY);
        this.aHI.setOnClickListener(this.aJY);
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
                this.aJS.setVisibility(8);
            } else {
                this.aJS.setVisibility(0);
                this.aJS.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aJS.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aJT.setVisibility(8);
            } else {
                this.aJT.setVisibility(0);
                this.aJT.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aJN.setVisibility(8);
            } else {
                this.aJN.setVisibility(0);
                this.aJN.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aJO.setVisibility(8);
            } else {
                this.aJO.setVisibility(0);
                this.aJO.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.qX().rb() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aJX.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aHI.setVisibility(0);
                        this.aHI.d(str, 10, false);
                        this.aHI.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aHH.setVisibility(0);
                        this.aHH.d(str2, 10, false);
                        this.aHH.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aHG.setVisibility(0);
                this.aHG.d(str3, 10, false);
                this.aHG.setTag(0);
                return;
            }
            this.aJX.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ad(i == 1);
        layoutMode.k(getRootView());
        return true;
    }
}
