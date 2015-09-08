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
    private TbImageView aIO;
    private TbImageView aIP;
    private TbImageView aIQ;
    private TextView aKV;
    private TextView aKW;
    private TextView aLa;
    private TextView aLb;
    private RelativeLayout aLf;
    private View.OnClickListener aLg;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLg = new f(this);
        this.aLa = (TextView) view.findViewById(i.f.chosen_picture_title);
        this.aKV = (TextView) view.findViewById(i.f.chosen_picture_praise);
        this.aKW = (TextView) view.findViewById(i.f.chosen_picture_comment);
        this.aLb = (TextView) view.findViewById(i.f.chosen_picture_head);
        this.aLf = (RelativeLayout) view.findViewById(i.f.chosen_picture_pic_container);
        this.aIO = (TbImageView) view.findViewById(i.f.chosen_picture_pic_one);
        this.aIP = (TbImageView) view.findViewById(i.f.chosen_picture_pic_two);
        this.aIQ = (TbImageView) view.findViewById(i.f.chosen_picture_pic_thr);
        this.aIO.setOnClickListener(this.aLg);
        this.aIP.setOnClickListener(this.aLg);
        this.aIQ.setOnClickListener(this.aLg);
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
                this.aLa.setVisibility(8);
            } else {
                this.aLa.setVisibility(0);
                this.aLa.setText(UtilHelper.getFixedText(getContext().getString(i.h.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aLa.setOnClickListener(new g(this, tinfoVar));
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.aLb.setVisibility(8);
            } else {
                this.aLb.setVisibility(0);
                this.aLb.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.aKV.setVisibility(8);
            } else {
                this.aKV.setVisibility(0);
                this.aKV.setText(new StringBuilder().append(tinfoVar.zan_num).toString());
            }
            if (tinfoVar.reply_num == null) {
                this.aKW.setVisibility(8);
            } else {
                this.aKW.setVisibility(0);
                this.aKW.setText(new StringBuilder().append(tinfoVar.reply_num).toString());
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (m.rb().rf() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.aLf.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.aIQ.setVisibility(0);
                        this.aIQ.d(str, 10, false);
                        this.aIQ.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.aIP.setVisibility(0);
                        this.aIP.d(str2, 10, false);
                        this.aIP.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.aIO.setVisibility(0);
                this.aIO.d(str3, 10, false);
                this.aIO.setTag(0);
                return;
            }
            this.aLf.setVisibility(8);
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
