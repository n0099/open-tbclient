package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.o chu;
    private ForumData chv;
    private ViewGroup chw;
    private View chx;
    private TextView chy;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public o(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.chw = null;
        this.chx = null;
        this.chy = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.chx = view.findViewById(t.g.frs_header_divider_ticket);
        this.chw = (ViewGroup) view.findViewById(t.g.frs_header_ticket);
        this.chy = (TextView) view.findViewById(t.g.frs_header_ticket_text);
        this.chw.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        av.k(this.chw, t.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.chu = oVar;
        this.chv = forumData;
        String string = this.mContext.getString(t.j.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.bhL();
            if (com.baidu.tbadk.core.sharedPref.b.tS().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.bhM()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(t.j.forum_name_suffix) + this.mContext.getString(t.j.frs_star_ticket_name);
        }
        if (z) {
            this.chx.setVisibility(0);
            this.chw.setVisibility(0);
            em(z2);
            this.chy.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.chx.setVisibility(8);
        this.chw.setVisibility(8);
    }

    public ViewGroup afP() {
        return this.chw;
    }

    public View afQ() {
        return this.chx;
    }

    private void em(boolean z) {
        if (z) {
            this.chy.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_news_down_bar_one, 0);
        } else {
            this.chy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.chw) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.chu != null && this.chv != null) {
                com.baidu.tbadk.core.sharedPref.b.tS().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.chv.getId() + TbadkCoreApplication.getCurrentAccount(), this.chu.bhM());
                em(false);
                com.baidu.tbadk.browser.f.a(this.chw.getContext(), com.baidu.adp.lib.util.j.a(this.chy.getText(), this.mContext.getString(t.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.chu.bhN())), true, false, true);
            }
        }
    }
}
