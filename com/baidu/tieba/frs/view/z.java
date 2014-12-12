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
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    private com.baidu.tieba.tbadkCore.t aHS;
    private ForumData aHT;
    private ViewGroup aHU;
    private View aHV;
    private TextView aHW;
    private Context mContext;

    public z(View view) {
        this.aHU = null;
        this.aHV = null;
        this.aHW = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aHV = view.findViewById(com.baidu.tieba.w.frs_header_divider_ticket);
        this.aHU = (ViewGroup) view.findViewById(com.baidu.tieba.w.frs_header_ticket);
        this.aHW = (TextView) view.findViewById(com.baidu.tieba.w.frs_header_ticket_text);
        this.aHU.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        ax.i(this.aHU, com.baidu.tieba.v.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aHS = tVar;
        this.aHT = forumData;
        String string = this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name);
        if (tVar != null) {
            z = tVar.aev();
            if (com.baidu.tbadk.core.sharedPref.b.og().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= tVar.aew()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.z.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name);
        }
        if (z) {
            this.aHV.setVisibility(0);
            this.aHU.setVisibility(0);
            bX(z2);
            this.aHW.setText(string);
            com.baidu.tbadk.core.i.C(this.mContext, "ticket_show");
            return;
        }
        this.aHV.setVisibility(8);
        this.aHU.setVisibility(8);
    }

    private void bX(boolean z) {
        if (z) {
            this.aHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_news_down_bar_one, 0);
        } else {
            this.aHW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aHU && this.aHS != null && this.aHT != null) {
            com.baidu.tbadk.core.sharedPref.b.og().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aHT.getId() + TbadkCoreApplication.getCurrentAccount(), this.aHS.aew());
            bX(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aHU.getContext(), com.baidu.adp.lib.util.k.a(this.aHW.getText(), this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.aHS.aex())), true, true, false, false, false)));
        }
    }
}
