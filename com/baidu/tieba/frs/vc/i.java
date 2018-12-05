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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes6.dex */
public class i {
    private l edR;
    private PopupWindow eee;
    private com.baidu.tieba.frs.entelechy.b.d eef;
    private Runnable eeg = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.eee != null && i.this.eee.getContentView() != null) {
                int h = com.baidu.adp.lib.util.l.h(i.this.mActivity, e.C0210e.ds252);
                i.this.eee.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.eee, i.this.mAnchorView, (-(com.baidu.adp.lib.util.l.h(i.this.mActivity, e.C0210e.ds430) - i.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jG().postDelayed(i.this.eeh, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 2));
            }
        }
    };
    private Runnable eeh = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.aHA();
        }
    };
    private View.OnClickListener eei = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.aHz();
            if (i.this.edR != null && i.this.edR.hiU != null && i.this.edR.bgi() != null) {
                if (i.this.eef == null || i.this.eef.aEd()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.edR.bgi().getId(), i.this.edR.bgi().getName(), null, null, 0, i.this.edR.yE(), 13003, false, false, null, false, false, null, null, i.this.edR.bgi().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.edR.hiU.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.edR.hiU.recom_topic, true);
                    }
                    ForumData bgi = i.this.edR.bgi();
                    writeActivityConfig.setForumDir(bgi.getFirst_class(), bgi.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").x("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.eef = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.hiU != null && this.mActivity != null) {
            this.edR = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.hiU.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.eei);
            this.eee = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeg);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eeg, 100L);
        }
    }

    public void aHz() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeg);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeh);
        aHA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHA() {
        com.baidu.adp.lib.g.g.a(this.eee);
    }
}
