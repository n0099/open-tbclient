package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class au extends w {
    private TextView bkS;
    private BaseActivity<?> boS;
    private String bqq;
    private String mForumId;

    public au(BaseActivity<?> baseActivity) {
        super(baseActivity.getPageContext());
        this.bkS = (TextView) getView().findViewById(t.g.action_button);
        this.boS = baseActivity;
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w, com.baidu.tieba.card.a
    public int JP() {
        return t.h.frs_share_picture_thread_item;
    }

    @Override // com.baidu.tieba.frs.entelechy.c.w
    public void h(ax axVar) {
        super.h(axVar);
        if (axVar != null) {
            this.bkS.setVisibility(8);
            if (axVar.qV() != null && axVar.qV().size() > 0 && axVar.qV().get(0) != null) {
                com.baidu.tbadk.core.data.a aVar = axVar.qV().get(0);
                if (!StringUtils.isNull(aVar.getUrl())) {
                    this.bkS.setTag(axVar.qV().get(0).getUrl());
                    this.bqq = axVar.getTid();
                    this.mForumId = String.valueOf(axVar.getFid());
                }
                if (aVar.getStatus() == 1) {
                    this.bkS.setVisibility(0);
                }
            }
            com.baidu.tbadk.core.util.at.k(this.bkS, t.f.btn_focus_border_bg);
            com.baidu.tbadk.core.util.at.j((View) this.bkS, t.d.btn_forum_focus_color);
            this.bkS.setOnClickListener(new av(this));
        }
    }
}
