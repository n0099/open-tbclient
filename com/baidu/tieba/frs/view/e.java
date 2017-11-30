package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private i dcO;
    private ForumData dcP;
    private ViewGroup dcQ;
    private View dcR;
    private TextView dcS;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.dcQ = null;
        this.dcR = null;
        this.dcS = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.dcR = view.findViewById(d.g.frs_header_divider_ticket);
        this.dcQ = (ViewGroup) view.findViewById(d.g.frs_header_ticket);
        this.dcS = (TextView) view.findViewById(d.g.frs_header_ticket_text);
        this.dcQ.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.dcQ, d.f.frs_top_item_bg);
    }

    public void a(i iVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dcO = iVar;
        this.dcP = forumData;
        String string = this.mContext.getString(d.j.frs_star_ticket_name);
        if (iVar != null) {
            z = iVar.bva();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= iVar.bvb()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.j.forum) + this.mContext.getString(d.j.frs_star_ticket_name);
        }
        if (z) {
            this.dcR.setVisibility(0);
            this.dcQ.setVisibility(0);
            fG(z2);
            this.dcS.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.dcR.setVisibility(8);
            this.dcQ.setVisibility(8);
        }
        this.dcR.setVisibility(8);
        this.dcQ.setVisibility(8);
    }

    private void fG(boolean z) {
        if (z) {
            this.dcS.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.dcS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dcQ) {
            if ((this.mTbPageContext == null || ax.aV(this.mTbPageContext.getPageActivity())) && this.dcO != null && this.dcP != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dcP.getId() + TbadkCoreApplication.getCurrentAccount(), this.dcO.bvb());
                fG(false);
                com.baidu.tbadk.browser.a.a(this.dcQ.getContext(), k.a(this.dcS.getText(), this.mContext.getString(d.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dcO.bvc())), true, false, true);
            }
        }
    }
}
