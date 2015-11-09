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
    private TbImageView aGL;
    private TbImageView aGM;
    private TbImageView aGN;
    private TextView aIS;
    private TextView aIT;
    private TextView aIX;
    private TextView aIY;
    private RelativeLayout aJc;
    private View.OnClickListener aJd;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJd = new f(this);
        this.aIX = (TextView) view.findViewById(i.f.chosen_picture_title);
        this.aIS = (TextView) view.findViewById(i.f.chosen_picture_praise);
        this.aIT = (TextView) view.findViewById(i.f.chosen_picture_comment);
        this.aIY = (TextView) view.findViewById(i.f.chosen_picture_head);
        this.aJc = (RelativeLayout) view.findViewById(i.f.chosen_picture_pic_container);
        this.aGL = (TbImageView) view.findViewById(i.f.chosen_picture_pic_one);
        this.aGM = (TbImageView) view.findViewById(i.f.chosen_picture_pic_two);
        this.aGN = (TbImageView) view.findViewById(i.f.chosen_picture_pic_thr);
        this.aGL.setOnClickListener(this.aJd);
        this.aGM.setOnClickListener(this.aJd);
        this.aGN.setOnClickListener(this.aJd);
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
                this.aIX.setVisibility(8);
            } else {
                this.aIX.setVisibility(0);
                this.aIX.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aIX.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aIY.setVisibility(8);
            } else {
                this.aIY.setVisibility(0);
                this.aIY.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aIS.setVisibility(8);
            } else {
                this.aIS.setVisibility(0);
                this.aIS.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aIT.setVisibility(8);
            } else {
                this.aIT.setVisibility(0);
                this.aIT.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.qV().qZ() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aJc.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aGN.setVisibility(0);
                        this.aGN.d(str, 10, false);
                        this.aGN.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aGM.setVisibility(0);
                        this.aGM.d(str2, 10, false);
                        this.aGM.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aGL.setVisibility(0);
                this.aGL.d(str3, 10, false);
                this.aGL.setTag(0);
                return;
            }
            this.aJc.setVisibility(8);
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
