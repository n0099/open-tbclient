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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    private TextView cJA;
    private h cJw;
    private ForumData cJx;
    private ViewGroup cJy;
    private View cJz;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.cJy = null;
        this.cJz = null;
        this.cJA = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.cJz = view.findViewById(d.h.frs_header_divider_ticket);
        this.cJy = (ViewGroup) view.findViewById(d.h.frs_header_ticket);
        this.cJA = (TextView) view.findViewById(d.h.frs_header_ticket_text);
        this.cJy.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        aj.j(this.cJy, d.g.frs_top_item_bg);
    }

    public void a(h hVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.cJw = hVar;
        this.cJx = forumData;
        String string = this.mContext.getString(d.l.frs_star_ticket_name);
        if (hVar != null) {
            z = hVar.brn();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= hVar.bro()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.l.forum) + this.mContext.getString(d.l.frs_star_ticket_name);
        }
        if (z) {
            this.cJz.setVisibility(0);
            this.cJy.setVisibility(0);
            fq(z2);
            this.cJA.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.cJz.setVisibility(8);
            this.cJy.setVisibility(8);
        }
        this.cJz.setVisibility(8);
        this.cJy.setVisibility(8);
    }

    private void fq(boolean z) {
        if (z) {
            this.cJA.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_news_down_bar_one, 0);
        } else {
            this.cJA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cJy) {
            if ((this.mTbPageContext == null || ax.aU(this.mTbPageContext.getPageActivity())) && this.cJw != null && this.cJx != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cJx.getId() + TbadkCoreApplication.getCurrentAccount(), this.cJw.bro());
                fq(false);
                com.baidu.tbadk.browser.a.a(this.cJy.getContext(), j.a(this.cJA.getText(), this.mContext.getString(d.l.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.cJw.brp())), true, false, true);
            }
        }
    }
}
