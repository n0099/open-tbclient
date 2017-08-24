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
    private h cCm;
    private ForumData cCn;
    private ViewGroup cCo;
    private View cCp;
    private TextView cCq;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cCo = null;
        this.cCp = null;
        this.cCq = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cCp = view.findViewById(d.h.frs_header_divider_ticket);
        this.cCo = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cCq = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cCo.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ai.j(this.cCo, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cCm = hVar;
        this.cCn = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.brN();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.brO()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cCp.setVisibility(0);
            this.cCo.setVisibility(0);
            fh(z2);
            this.cCq.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cCp.setVisibility(8);
            this.cCo.setVisibility(8);
        }
        this.cCp.setVisibility(8);
        this.cCo.setVisibility(8);
    }

    private void fh(boolean z) {
        if (z) {
            this.cCq.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cCq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cCo) {
            if ((this.mTbPageContext == null || aw.aO(this.mTbPageContext.getPageActivity())) && this.cCm != null && this.cCn != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cCn.getId() + TbadkCoreApplication.getCurrentAccount(), this.cCm.brO());
                fh(false);
                com.baidu.tbadk.browser.a.a(this.cCo.getContext(), j.a(this.cCq.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cCm.brP())), true, false, true);
            }
        }
    }
}
