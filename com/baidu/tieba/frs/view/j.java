package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.m cjL;
    private ForumData cjM;
    private ViewGroup cjN;
    private View cjO;
    private TextView cjP;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public j(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cjN = null;
        this.cjO = null;
        this.cjP = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cjO = view.findViewById(w.h.frs_header_divider_ticket);
        this.cjN = (ViewGroup) view.findViewById(w.h.frs_header_ticket);
        this.cjP = (TextView) view.findViewById(w.h.frs_header_ticket_text);
        this.cjN.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aq.j(this.cjN, w.g.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cjL = mVar;
        this.cjM = forumData;
        String string = this.mContext.getString(w.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bgU();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.bgV()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(w.l.forum) + this.mContext.getString(w.l.frs_star_ticket_name);
        }
        if (z) {
            this.cjO.setVisibility(0);
            this.cjN.setVisibility(0);
            eC(z2);
            this.cjP.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cjO.setVisibility(8);
            this.cjN.setVisibility(8);
        }
        this.cjO.setVisibility(8);
        this.cjN.setVisibility(8);
    }

    public ViewGroup aen() {
        return this.cjN;
    }

    public View aeo() {
        return this.cjO;
    }

    private void eC(boolean z) {
        if (z) {
            this.cjP.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_news_down_bar_one, 0);
        } else {
            this.cjP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cjN) {
            if ((this.mTbPageContext == null || bh.aN(this.mTbPageContext.getPageActivity())) && this.cjL != null && this.cjM != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cjM.getId() + TbadkCoreApplication.getCurrentAccount(), this.cjL.bgV());
                eC(false);
                com.baidu.tbadk.browser.f.a(this.cjN.getContext(), com.baidu.adp.lib.util.j.a(this.cjP.getText(), this.mContext.getString(w.l.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.cjL.bgW())), true, false, true);
            }
        }
    }
}
