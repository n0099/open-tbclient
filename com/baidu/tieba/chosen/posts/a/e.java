package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.g.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aMn;
    private TbImageView aMo;
    private TbImageView aMp;
    private TextView aQR;
    private RelativeLayout aTC;
    private View.OnClickListener aTD;
    private TextView aTt;
    private TextView aTu;
    private TextView aTy;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aTD = new f(this);
        this.aQR = (TextView) view.findViewById(t.g.chosen_picture_title);
        this.aTt = (TextView) view.findViewById(t.g.chosen_picture_praise);
        this.aTu = (TextView) view.findViewById(t.g.chosen_picture_comment);
        this.aTy = (TextView) view.findViewById(t.g.chosen_picture_head);
        this.aTC = (RelativeLayout) view.findViewById(t.g.chosen_picture_pic_container);
        this.aMn = (TbImageView) view.findViewById(t.g.chosen_picture_pic_one);
        this.aMo = (TbImageView) view.findViewById(t.g.chosen_picture_pic_two);
        this.aMp = (TbImageView) view.findViewById(t.g.chosen_picture_pic_thr);
        this.aMn.setOnClickListener(this.aTD);
        this.aMo.setOnClickListener(this.aTD);
        this.aMp.setOnClickListener(this.aTD);
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
                this.aQR.setVisibility(8);
            } else {
                this.aQR.setVisibility(0);
                this.aQR.setText(UtilHelper.getFixedText(getContext().getString(t.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aQR.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aTy.setVisibility(8);
            } else {
                this.aTy.setVisibility(0);
                this.aTy.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aTt.setVisibility(8);
            } else {
                this.aTt.setVisibility(0);
                this.aTt.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aTu.setVisibility(8);
            } else {
                this.aTu.setVisibility(0);
                this.aTu.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (l.rn().rt() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aTC.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aMp.setVisibility(0);
                        this.aMp.d(str, 10, false);
                        this.aMp.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aMo.setVisibility(0);
                        this.aMo.d(str2, 10, false);
                        this.aMo.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aMn.setVisibility(0);
                this.aMn.d(str3, 10, false);
                this.aMn.setTag(0);
                return;
            }
            this.aTC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.ac(i == 1);
        layoutMode.x(getRootView());
        return true;
    }
}
