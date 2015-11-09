package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.n beu;
    private ForumData bev;
    private ViewGroup bew;
    private View bex;
    private TextView bey;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public w(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.bew = null;
        this.bex = null;
        this.bey = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.bex = view.findViewById(i.f.frs_header_divider_ticket);
        this.bew = (ViewGroup) view.findViewById(i.f.frs_header_ticket);
        this.bey = (TextView) view.findViewById(i.f.frs_header_ticket_text);
        this.bew.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        an.i(this.bew, i.e.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.beu = nVar;
        this.bev = forumData;
        String string = this.mContext.getString(i.h.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.awr();
            if (com.baidu.tbadk.core.sharedPref.b.tu().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.aws()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(i.h.forum_name_suffix) + this.mContext.getString(i.h.frs_star_ticket_name);
        }
        if (z) {
            this.bex.setVisibility(0);
            this.bew.setVisibility(0);
            cp(z2);
            this.bey.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.bex.setVisibility(8);
        this.bew.setVisibility(8);
    }

    public ViewGroup Ow() {
        return this.bew;
    }

    public View Ox() {
        return this.bex;
    }

    private void cp(boolean z) {
        if (z) {
            this.bey.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_news_down_bar_one, 0);
        } else {
            this.bey.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bew) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.beu != null && this.bev != null) {
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.bev.getId() + TbadkCoreApplication.getCurrentAccount(), this.beu.aws());
                cp(false);
                com.baidu.tbadk.browser.g.a(this.bew.getContext(), com.baidu.adp.lib.util.j.a(this.bey.getText(), this.mContext.getString(i.h.frs_star_ticket_name)), com.baidu.tbadk.browser.g.appendVersionCode(com.baidu.tbadk.browser.g.appendCuidParam(this.beu.awt())), true, false, false);
            }
        }
    }
}
