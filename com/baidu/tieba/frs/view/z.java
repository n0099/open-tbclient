package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.t aJc;
    private ForumData aJd;
    private ViewGroup aJe;
    private View aJf;
    private TextView aJg;
    private Context mContext;

    public z(View view) {
        this.aJe = null;
        this.aJf = null;
        this.aJg = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aJf = view.findViewById(com.baidu.tieba.w.frs_header_divider_ticket);
        this.aJe = (ViewGroup) view.findViewById(com.baidu.tieba.w.frs_header_ticket);
        this.aJg = (TextView) view.findViewById(com.baidu.tieba.w.frs_header_ticket_text);
        this.aJe.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        bc.i(this.aJe, com.baidu.tieba.v.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aJc = tVar;
        this.aJd = forumData;
        String string = this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name);
        if (tVar != null) {
            z = tVar.aeZ();
            if (com.baidu.tbadk.core.sharedPref.b.oj().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= tVar.afa()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.z.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name);
        }
        if (z) {
            this.aJf.setVisibility(0);
            this.aJe.setVisibility(0);
            ca(z2);
            this.aJg.setText(string);
            com.baidu.tbadk.core.i.B(this.mContext, "ticket_show");
            return;
        }
        this.aJf.setVisibility(8);
        this.aJe.setVisibility(8);
    }

    private void ca(boolean z) {
        if (z) {
            this.aJg.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_news_down_bar_one, 0);
        } else {
            this.aJg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aJe && this.aJc != null && this.aJd != null) {
            com.baidu.tbadk.core.sharedPref.b.oj().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aJd.getId() + TbadkCoreApplication.getCurrentAccount(), this.aJc.afa());
            ca(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aJe.getContext(), com.baidu.adp.lib.util.k.a(this.aJg.getText(), this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.aJc.afb())), true, true, false, false, false)));
        }
    }
}
