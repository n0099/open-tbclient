package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> Gd;
    private TextView bdk;
    private TextView bdl;
    private TextView bdm;
    private int cIb;
    private com.baidu.tieba.homepage.recommendfrs.data.e cIc;
    private View.OnClickListener cId;
    private TbImageView cIk;
    private TbImageView cIl;
    private TbImageView cIm;
    private List<TbImageView> cIn;
    private final int cIo;
    private int mSkinType;
    private TextView title;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cIo = 3;
        this.cIb = 0;
        this.cId = new h(this);
        this.Gd = tbPageContext;
        view.setOnClickListener(this.cId);
        this.cIk = (TbImageView) view.findViewById(t.g.img1);
        this.cIl = (TbImageView) view.findViewById(t.g.img2);
        this.cIm = (TbImageView) view.findViewById(t.g.img3);
        this.title = (TextView) view.findViewById(t.g.title);
        View findViewById = view.findViewById(t.g.hot_thread_comment);
        this.bdk = (TextView) findViewById.findViewById(t.g.hot_thread_line_tag);
        this.bdl = (TextView) findViewById.findViewById(t.g.hot_thread_line_praise);
        this.bdm = (TextView) findViewById.findViewById(t.g.hot_thread_line_comment);
        this.cIn = new ArrayList();
        this.cIn.add(this.cIk);
        this.cIn.add(this.cIl);
        this.cIn.add(this.cIm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cIc = eVar;
            if (eVar.amZ() != null) {
                List<String> amZ = eVar.amZ();
                if (amZ.size() > 3) {
                    amZ.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) y.c(amZ, i);
                    TbImageView tbImageView = this.cIn.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.Wg()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.title.setText(eVar.getTitle());
            this.bdl.setVisibility(0);
            String w = ba.w(eVar.amW());
            this.bdl.setText(w);
            this.bdl.setContentDescription(String.valueOf(this.Gd.getString(t.j.zan_num)) + w);
            com.baidu.tieba.graffiti.d.al(this.bdl);
            String w2 = ba.w(eVar.amX());
            this.bdm.setText(w2);
            this.bdm.setContentDescription(String.valueOf(this.Gd.getString(t.j.reply_num)) + w2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bdk.setVisibility(8);
            } else {
                this.bdk.setVisibility(0);
                this.bdk.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bdk.setOnClickListener(new i(this, eVar));
            }
            s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rf(String.valueOf(eVar.getThreadId()))) {
                this.cIb = t.d.cp_cont_c;
            } else {
                this.cIb = t.d.cp_cont_b;
            }
            av.c(this.title, this.cIb, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
            if (this.cIb != 0 && this.title != null) {
                av.c(this.title, this.cIb, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
