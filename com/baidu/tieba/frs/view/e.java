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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes2.dex */
public class e implements View.OnClickListener {
    private TextView duA;
    private j duw;
    private ForumData dux;
    private ViewGroup duy;
    private View duz;
    private Context mContext;
    TbPageContext<FrsActivity> mTbPageContext;

    public e(TbPageContext<FrsActivity> tbPageContext, View view2) {
        this.duy = null;
        this.duz = null;
        this.duA = null;
        this.mContext = view2.getContext().getApplicationContext();
        this.mTbPageContext = tbPageContext;
        this.duz = view2.findViewById(d.g.frs_header_divider_ticket);
        this.duy = (ViewGroup) view2.findViewById(d.g.frs_header_ticket);
        this.duA = (TextView) view2.findViewById(d.g.frs_header_ticket_text);
        this.duy.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ak.i(this.duy, d.f.frs_top_item_bg);
    }

    public void a(j jVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.duw = jVar;
        this.dux = forumData;
        String string = this.mContext.getString(d.k.frs_star_ticket_name);
        if (jVar != null) {
            z = jVar.bqN();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= jVar.bqO()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = forumData.getName() + this.mContext.getString(d.k.forum) + this.mContext.getString(d.k.frs_star_ticket_name);
        }
        if (z) {
            this.duz.setVisibility(0);
            this.duy.setVisibility(0);
            gg(z2);
            this.duA.setText(string);
            TiebaStatic.log("ticket_show");
        } else {
            this.duz.setVisibility(8);
            this.duy.setVisibility(8);
        }
        this.duz.setVisibility(8);
        this.duy.setVisibility(8);
    }

    private void gg(boolean z) {
        if (z) {
            this.duA.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.f.icon_news_down_bar_one, 0);
        } else {
            this.duA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.duy) {
            if ((this.mTbPageContext == null || az.aK(this.mTbPageContext.getPageActivity())) && this.duw != null && this.dux != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.dux.getId() + TbadkCoreApplication.getCurrentAccount(), this.duw.bqO());
                gg(false);
                com.baidu.tbadk.browser.a.a(this.duy.getContext(), k.a(this.duA.getText(), this.mContext.getString(d.k.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.duw.bqP())), true, false, true);
            }
        }
    }
}
