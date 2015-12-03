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
    private TbImageView aJK;
    private TbImageView aJL;
    private TbImageView aJM;
    private RelativeLayout aND;
    private View.OnClickListener aNE;
    private TextView aNt;
    private TextView aNu;
    private TextView aNy;
    private TextView aNz;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNE = new f(this);
        this.aNy = (TextView) view.findViewById(n.f.chosen_picture_title);
        this.aNt = (TextView) view.findViewById(n.f.chosen_picture_praise);
        this.aNu = (TextView) view.findViewById(n.f.chosen_picture_comment);
        this.aNz = (TextView) view.findViewById(n.f.chosen_picture_head);
        this.aND = (RelativeLayout) view.findViewById(n.f.chosen_picture_pic_container);
        this.aJK = (TbImageView) view.findViewById(n.f.chosen_picture_pic_one);
        this.aJL = (TbImageView) view.findViewById(n.f.chosen_picture_pic_two);
        this.aJM = (TbImageView) view.findViewById(n.f.chosen_picture_pic_thr);
        this.aJK.setOnClickListener(this.aNE);
        this.aJL.setOnClickListener(this.aNE);
        this.aJM.setOnClickListener(this.aNE);
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
                this.aNy.setVisibility(8);
            } else {
                this.aNy.setVisibility(0);
                this.aNy.setText(UtilHelper.getFixedText(getContext().getString(n.i.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aNy.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aNz.setVisibility(8);
            } else {
                this.aNz.setVisibility(0);
                this.aNz.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aNt.setVisibility(8);
            } else {
                this.aNt.setVisibility(0);
                this.aNt.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aNu.setVisibility(8);
            } else {
                this.aNu.setVisibility(0);
                this.aNu.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.rh().rn() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aND.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aJM.setVisibility(0);
                        this.aJM.d(str, 10, false);
                        this.aJM.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aJL.setVisibility(0);
                        this.aJL.d(str2, 10, false);
                        this.aJL.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aJK.setVisibility(0);
                this.aJK.d(str3, 10, false);
                this.aJK.setTag(0);
                return;
            }
            this.aND.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.af(i == 1);
        layoutMode.k(getRootView());
        return true;
    }
}
