package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.r;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.homepage.recommendfrs.data.e, com.baidu.tbadk.mvc.d.b> {
    private TbPageContext<?> aaX;
    private TextView auO;
    private TextView bAa;
    private TextView bzY;
    private TextView bzZ;
    private int cAn;
    private com.baidu.tieba.homepage.recommendfrs.data.e cAo;
    private View.OnClickListener cAp;
    private TbImageView cAw;
    private TbImageView cAx;
    private TbImageView cAy;
    private List<TbImageView> cAz;
    private int mSkinType;

    public g(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mSkinType = 3;
        this.cAn = 0;
        this.cAp = new h(this);
        this.aaX = tbPageContext;
        view.setOnClickListener(this.cAp);
        this.cAw = (TbImageView) view.findViewById(w.h.img1);
        this.cAx = (TbImageView) view.findViewById(w.h.img2);
        this.cAy = (TbImageView) view.findViewById(w.h.img3);
        this.auO = (TextView) view.findViewById(w.h.title);
        View findViewById = view.findViewById(w.h.hot_thread_comment);
        this.bzY = (TextView) findViewById.findViewById(w.h.hot_thread_line_tag);
        this.bzZ = (TextView) findViewById.findViewById(w.h.hot_thread_line_praise);
        this.bAa = (TextView) findViewById.findViewById(w.h.hot_thread_line_comment);
        this.cAz = new ArrayList();
        this.cAz.add(this.cAw);
        this.cAz.add(this.cAx);
        this.cAz.add(this.cAy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        super.E(eVar);
        if (eVar != null) {
            this.cAo = eVar;
            if (eVar.ajW() != null) {
                List<String> ajW = eVar.ajW();
                if (ajW.size() > 3) {
                    ajW.subList(0, 3);
                }
                for (int i = 0; i < 3; i++) {
                    String str = (String) x.c(ajW, i);
                    TbImageView tbImageView = this.cAz.get(i);
                    if (StringUtils.isNULL(str)) {
                        tbImageView.setVisibility(4);
                    } else {
                        tbImageView.setVisibility(0);
                        if (!eVar.ajQ()) {
                            str = null;
                        }
                        tbImageView.c(str, 10, false);
                    }
                }
            }
            this.auO.setText(eVar.getTitle());
            this.bzZ.setVisibility(0);
            String t = au.t(eVar.ajT());
            this.bzZ.setText(t);
            this.bzZ.setContentDescription(String.valueOf(this.aaX.getString(w.l.zan_num)) + t);
            com.baidu.tieba.graffiti.c.al(this.bzZ);
            String t2 = au.t(eVar.ajU());
            this.bAa.setText(t2);
            this.bAa.setContentDescription(String.valueOf(this.aaX.getString(w.l.reply_num)) + t2);
            if (StringUtils.isNull(eVar.getForumName())) {
                this.bzY.setVisibility(8);
            } else {
                this.bzY.setVisibility(0);
                this.bzY.setText(getContext().getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedText(eVar.getForumName(), 7, false)));
                this.bzY.setOnClickListener(new i(this, eVar));
            }
            r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qo(String.valueOf(eVar.getThreadId()))) {
                this.cAn = w.e.cp_cont_c;
            } else {
                this.cAn = w.e.cp_cont_b;
            }
            aq.c(this.auO, this.cAn, 1);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
            if (this.cAn != 0 && this.auO != null) {
                aq.c(this.auO, this.cAn, 1);
            }
        }
        this.mSkinType = i;
        return true;
    }
}
