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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    private View cdA;
    private TextView cdB;
    private com.baidu.tieba.tbadkCore.m cdx;
    private ForumData cdy;
    private ViewGroup cdz;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public j(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cdz = null;
        this.cdA = null;
        this.cdB = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cdA = view.findViewById(w.h.frs_header_divider_ticket);
        this.cdz = (ViewGroup) view.findViewById(w.h.frs_header_ticket);
        this.cdB = (TextView) view.findViewById(w.h.frs_header_ticket_text);
        this.cdz.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aq.j(this.cdz, w.g.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.m mVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cdx = mVar;
        this.cdy = forumData;
        String string = this.mContext.getString(w.l.frs_star_ticket_name);
        if (mVar != null) {
            z = mVar.bfy();
            if (com.baidu.tbadk.core.sharedPref.b.tX().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= mVar.bfz()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(w.l.forum) + this.mContext.getString(w.l.frs_star_ticket_name);
        }
        if (z) {
            this.cdA.setVisibility(0);
            this.cdz.setVisibility(0);
            em(z2);
            this.cdB.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cdA.setVisibility(8);
            this.cdz.setVisibility(8);
        }
        this.cdA.setVisibility(8);
        this.cdz.setVisibility(8);
    }

    public ViewGroup adk() {
        return this.cdz;
    }

    public View adl() {
        return this.cdA;
    }

    private void em(boolean z) {
        if (z) {
            this.cdB.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_news_down_bar_one, 0);
        } else {
            this.cdB.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cdz) {
            if ((this.mTbPageContext == null || bg.aN(this.mTbPageContext.getPageActivity())) && this.cdx != null && this.cdy != null) {
                com.baidu.tbadk.core.sharedPref.b.tX().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cdy.getId() + TbadkCoreApplication.getCurrentAccount(), this.cdx.bfz());
                em(false);
                com.baidu.tbadk.browser.f.a(this.cdz.getContext(), com.baidu.adp.lib.util.j.a(this.cdB.getText(), this.mContext.getString(w.l.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.cdx.bfA())), true, false, true);
            }
        }
    }
}
