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
    private com.baidu.tieba.tbadkCore.t aIZ;
    private ForumData aJa;
    private ViewGroup aJb;
    private View aJc;
    private TextView aJd;
    private Context mContext;

    public z(View view) {
        this.aJb = null;
        this.aJc = null;
        this.aJd = null;
        this.mContext = view.getContext().getApplicationContext();
        this.aJc = view.findViewById(com.baidu.tieba.w.frs_header_divider_ticket);
        this.aJb = (ViewGroup) view.findViewById(com.baidu.tieba.w.frs_header_ticket);
        this.aJd = (TextView) view.findViewById(com.baidu.tieba.w.frs_header_ticket_text);
        this.aJb.setOnClickListener(this);
    }

    public void changeSkinType(int i) {
        bc.i(this.aJb, com.baidu.tieba.v.frs_top_item_bg);
    }

    public void a(com.baidu.tieba.tbadkCore.t tVar, ForumData forumData) {
        boolean z;
        boolean z2 = true;
        this.aIZ = tVar;
        this.aJa = forumData;
        String string = this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name);
        if (tVar != null) {
            z = tVar.aeU();
            if (com.baidu.tbadk.core.sharedPref.b.oc().getLong("FRS_STARTICKET_LAST_CLICK_TIME" + forumData.getId() + TbadkCoreApplication.getCurrentAccount(), 0L) >= tVar.aeV()) {
                z2 = false;
            }
        } else {
            z = true;
        }
        if (forumData != null && forumData.getName() != null) {
            string = String.valueOf(forumData.getName()) + this.mContext.getString(com.baidu.tieba.z.forum_name_suffix) + this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name);
        }
        if (z) {
            this.aJc.setVisibility(0);
            this.aJb.setVisibility(0);
            ca(z2);
            this.aJd.setText(string);
            com.baidu.tbadk.core.i.B(this.mContext, "ticket_show");
            return;
        }
        this.aJc.setVisibility(8);
        this.aJb.setVisibility(8);
    }

    private void ca(boolean z) {
        if (z) {
            this.aJd.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_news_down_bar_one, 0);
        } else {
            this.aJd.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aJb && this.aIZ != null && this.aJa != null) {
            com.baidu.tbadk.core.sharedPref.b.oc().putLong("FRS_STARTICKET_LAST_CLICK_TIME" + this.aJa.getId() + TbadkCoreApplication.getCurrentAccount(), this.aIZ.aeV());
            ca(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aJb.getContext(), com.baidu.adp.lib.util.k.a(this.aJd.getText(), this.mContext.getString(com.baidu.tieba.z.frs_star_ticket_name)), com.baidu.tbadk.browser.a.appendVersionCode(com.baidu.tbadk.browser.a.appendCuidParam(this.aIZ.aeW())), true, true, false, false, false)));
        }
    }
}
