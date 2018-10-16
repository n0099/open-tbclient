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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes6.dex */
public class e implements View.OnClickListener {
    private j dZY;
    private ForumData dZZ;
    private ViewGroup eaa;
    private View eab;
    private TextView eac;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.eaa = null;
        this.eab = null;
        this.eac = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.eab = view.findViewById(e.g.frs_header_divider_ticket);
        this.eaa = (ViewGroup) view.findViewById(e.g.frs_header_ticket);
        this.eac = (TextView) view.findViewById(e.g.frs_header_ticket_text);
        this.eaa.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.eaa, e.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.dZY = jVar;
        this.dZZ = forumData;
        String string = this.mContext.getString(e.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bAN();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bAO()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(e.j.forum) + this.mContext.getString(e.j.frs_star_ticket_name);
        }
        if (z) {
            this.eab.setVisibility(0);
            this.eaa.setVisibility(0);
            ho(z2);
            this.eac.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.eab.setVisibility(8);
            this.eaa.setVisibility(8);
        }
        this.eab.setVisibility(8);
        this.eaa.setVisibility(8);
    }

    private void ho(boolean z) {
        if (z) {
            this.eac.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_news_down_bar_one, 0);
        } else {
            this.eac.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eaa) {
            if ((this.mTbPageContext == null || ba.bI(this.mTbPageContext.getPageActivity())) && this.dZY != null && this.dZZ != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dZZ.getId() + TbadkCoreApplication.getCurrentAccount(), this.dZY.bAO());
                ho(false);
                com.baidu.tbadk.browser.a.a(this.eaa.getContext(), k.a(this.eac.getText(), this.mContext.getString(e.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.dZY.bAP())), true, false, true);
            }
        }
    }
}
