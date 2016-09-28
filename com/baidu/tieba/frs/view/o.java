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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.o chs;
    private ForumData cht;
    private ViewGroup chu;
    private View chv;
    private TextView chw;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public o(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.chu = null;
        this.chv = null;
        this.chw = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.chv = view.findViewById(r.g.frs_header_divider_ticket);
        this.chu = (ViewGroup) view.findViewById(r.g.frs_header_ticket);
        this.chw = (TextView) view.findViewById(r.g.frs_header_ticket_text);
        this.chu.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        av.k(this.chu, r.f.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.chs = oVar;
        this.cht = forumData;
        String string = this.mContext.getString(r.j.frs_star_ticket_name);
        if (oVar != null) {
            z = oVar.biv();
            if (com.baidu.tbadk.core.sharedPref.b.uh().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= oVar.biw()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(r.j.forum_name_suffix) + this.mContext.getString(r.j.frs_star_ticket_name);
        }
        if (z) {
            this.chv.setVisibility(0);
            this.chu.setVisibility(0);
            en(z2);
            this.chw.setText(string);
            TiebaStatic.log("ticket_show");
            return;
        }
        this.chv.setVisibility(8);
        this.chu.setVisibility(8);
    }

    public ViewGroup agd() {
        return this.chu;
    }

    public View age() {
        return this.chv;
    }

    private void en(boolean z) {
        if (z) {
            this.chw.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_news_down_bar_one, 0);
        } else {
            this.chw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.chu) {
            if ((this.mTbPageContext == null || this.mTbPageContext.getOrignalPage() == null || this.mTbPageContext.getOrignalPage().checkUpIsLogin()) && this.chs != null && this.cht != null) {
                com.baidu.tbadk.core.sharedPref.b.uh().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.cht.getId() + TbadkCoreApplication.getCurrentAccount(), this.chs.biw());
                en(false);
                com.baidu.tbadk.browser.f.a(this.chu.getContext(), com.baidu.adp.lib.util.j.a(this.chw.getText(), this.mContext.getString(r.j.frs_star_ticket_name)), com.baidu.tbadk.browser.f.appendVersionCode(com.baidu.tbadk.browser.f.appendCuidParam(this.chs.bix())), true, false, true);
            }
        }
    }
}
