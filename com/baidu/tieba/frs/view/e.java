package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private h cAo;
    private ForumData cAp;
    private ViewGroup cAq;
    private View cAr;
    private TextView cAs;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cAq = null;
        this.cAr = null;
        this.cAs = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cAr = view.findViewById(d.h.frs_header_divider_ticket);
        this.cAq = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cAs = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cAq.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ai.j(this.cAq, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cAo = hVar;
        this.cAp = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.brm();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.brn()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cAr.setVisibility(0);
            this.cAq.setVisibility(0);
            fe(z2);
            this.cAs.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cAr.setVisibility(8);
            this.cAq.setVisibility(8);
        }
        this.cAr.setVisibility(8);
        this.cAq.setVisibility(8);
    }

    private void fe(boolean z) {
        if (z) {
            this.cAs.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cAs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cAq) {
            if ((this.mTbPageContext == null || aw.aO(this.mTbPageContext.getPageActivity())) && this.cAo != null && this.cAp != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cAp.getId() + TbadkCoreApplication.getCurrentAccount(), this.cAo.brn());
                fe(false);
                com.baidu.tbadk.browser.a.a(this.cAq.getContext(), j.a(this.cAs.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cAo.bro())), true, false, true);
            }
        }
    }
}
