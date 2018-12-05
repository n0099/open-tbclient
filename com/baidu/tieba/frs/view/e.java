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
    private j ehV;
    private ForumData ehW;
    private ViewGroup ehX;
    private View ehY;
    private TextView ehZ;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view) {
        this.ehX = null;
        this.ehY = null;
        this.ehZ = null;
        this.mContext = view.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.ehY = view.findViewById(e.g.frs_header_divider_ticket);
        this.ehX = (ViewGroup) view.findViewById(e.g.frs_header_ticket);
        this.ehZ = (TextView) view.findViewById(e.g.frs_header_ticket_text);
        this.ehX.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        al.i(this.ehX, e.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.ehV = jVar;
        this.ehW = forumData;
        String string = this.mContext.getString(e.j.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bCd();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bCe()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(e.j.forum) + this.mContext.getString(e.j.frs_star_ticket_name);
        }
        if (z) {
            this.ehY.setVisibility(0);
            this.ehX.setVisibility(0);
            hA(z2);
            this.ehZ.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.ehY.setVisibility(8);
            this.ehX.setVisibility(8);
        }
        this.ehY.setVisibility(8);
        this.ehX.setVisibility(8);
    }

    private void hA(boolean z) {
        if (z) {
            this.ehZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, e.f.icon_news_down_bar_one, 0);
        } else {
            this.ehZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ehX) {
            if ((this.mTbPageContext == null || ba.bJ(this.mTbPageContext.getPageActivity())) && this.ehV != null && this.ehW != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.ehW.getId() + TbadkCoreApplication.getCurrentAccount(), this.ehV.bCe());
                hA(false);
                com.baidu.tbadk.browser.a.a(this.ehX.getContext(), k.a(this.ehZ.getText(), this.mContext.getString(e.j.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.ehV.bCf())), true, false, true);
            }
        }
    }
}
