package com.baidu.tieba.frs.vc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class i {
    private PopupWindow dXA;
    private com.baidu.tieba.frs.entelechy.b.d dXB;
    private Runnable dXC = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.dXA != null && i.this.dXA.getContentView() != null) {
                int h = l.h(i.this.mActivity, e.C0200e.ds252);
                i.this.dXA.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.dXA, i.this.mAnchorView, (-(l.h(i.this.mActivity, e.C0200e.ds430) - i.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jG().postDelayed(i.this.dXD, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 2));
            }
        }
    };
    private Runnable dXD = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.aFO();
        }
    };
    private View.OnClickListener dXE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.aFN();
            if (i.this.dXn != null && i.this.dXn.hcb != null && i.this.dXn.ber() != null) {
                if (i.this.dXB == null || i.this.dXB.aCr()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.dXn.ber().getId(), i.this.dXn.ber().getName(), null, null, 0, i.this.dXn.xA(), 13003, false, false, null, false, false, null, null, i.this.dXn.ber().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.dXn.hcb.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.dXn.hcb.recom_topic, true);
                    }
                    ForumData ber = i.this.dXn.ber();
                    writeActivityConfig.setForumDir(ber.getFirst_class(), ber.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").x("obj_locate", 2));
                }
            }
        }
    };
    private com.baidu.tieba.tbadkCore.l dXn;
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.dXB = dVar;
    }

    public void b(View view, com.baidu.tieba.tbadkCore.l lVar) {
        if (view != null && lVar != null && lVar.hcb != null && this.mActivity != null) {
            this.dXn = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.hcb.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.dXE);
            this.dXA = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXC);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dXC, 100L);
        }
    }

    public void aFN() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXC);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXD);
        aFO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFO() {
        com.baidu.adp.lib.g.g.a(this.dXA);
    }
}
