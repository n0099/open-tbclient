package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.n brM;
    private ForumData brN;
    private ViewGroup brO;
    private View brP;
    private TextView brQ;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public aa(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.brO = null;
        this.brP = null;
        this.brQ = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.brP = view.findViewById(t.g.frs_header_divider_ticket);
        this.brO = (ViewGroup) view.findViewById(t.g.frs_header_ticket);
        this.brQ = (TextView) view.findViewById(t.g.frs_header_ticket_text);
        this.brO.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ar.k(this.brO, t.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.n nVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.brM = nVar;
        this.brN = forumData;
        String string = this.mContext.getString(t.j.frs_star_ticket_name);
        if (nVar != null) {
            z = nVar.aLl();
            if (com.baidu.tbadk.core.sharedPref.b.uO().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= nVar.aLm()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(t.j.forum_name_suffix) + this.mContext.getString(t.j.frs_star_ticket_name);
        }
        if (z) {
            this.brP.setVisibility(0);
            this.brO.setVisibility(0);
            cE(z2);
            this.brQ.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.brP.setVisibility(8);
        this.brO.setVisibility(8);
    }

    public ViewGroup Sy() {
        return this.brO;
    }

    public View Sz() {
        return this.brP;
    }

    private void cE(boolean z) {
        if (z) {
            this.brQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_news_down_bar_one, 0);
        } else {
            this.brQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.brO) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.brM != null && this.brN != null) {
                com.baidu.tbadk.core.sharedPref.b.uO().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.brN.getId() + TbadkCoreApplication.getCurrentAccount(), this.brM.aLm());
                cE(false);
                com.baidu.tbadk.browser.f.a(this.brO.getContext(), com.baidu.adp.lib.util.j.a(this.brQ.getText(), this.mContext.getString(t.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.brM.aLn())), true, false, false);
            }
        }
    }
}
