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
    private TbImageView aHR;
    private TbImageView aHS;
    private TbImageView aHT;
    private TextView aJY;
    private TextView aJZ;
    private TextView aKd;
    private TextView aKe;
    private RelativeLayout aKi;
    private View.OnClickListener aKj;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKj = new f(this);
        this.aKd = (TextView) view.findViewById(i.f.chosen_picture_title);
        this.aJY = (TextView) view.findViewById(i.f.chosen_picture_praise);
        this.aJZ = (TextView) view.findViewById(i.f.chosen_picture_comment);
        this.aKe = (TextView) view.findViewById(i.f.chosen_picture_head);
        this.aKi = (RelativeLayout) view.findViewById(i.f.chosen_picture_pic_container);
        this.aHR = (TbImageView) view.findViewById(i.f.chosen_picture_pic_one);
        this.aHS = (TbImageView) view.findViewById(i.f.chosen_picture_pic_two);
        this.aHT = (TbImageView) view.findViewById(i.f.chosen_picture_pic_thr);
        this.aHR.setOnClickListener(this.aKj);
        this.aHS.setOnClickListener(this.aKj);
        this.aHT.setOnClickListener(this.aKj);
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
                this.aKd.setVisibility(8);
            } else {
                this.aKd.setVisibility(0);
                this.aKd.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aKd.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aKe.setVisibility(8);
            } else {
                this.aKe.setVisibility(0);
                this.aKe.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aJY.setVisibility(8);
            } else {
                this.aJY.setVisibility(0);
                this.aJY.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aJZ.setVisibility(8);
            } else {
                this.aJZ.setVisibility(0);
                this.aJZ.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.qX().rb() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aKi.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aHT.setVisibility(0);
                        this.aHT.d(str, 10, false);
                        this.aHT.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aHS.setVisibility(0);
                        this.aHS.d(str2, 10, false);
                        this.aHS.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aHR.setVisibility(0);
                this.aHR.d(str3, 10, false);
                this.aHR.setTag(0);
                return;
            }
            this.aKi.setVisibility(8);
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
