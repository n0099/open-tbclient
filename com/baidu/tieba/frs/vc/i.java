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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class i {
    private PopupWindow fwJ;
    private com.baidu.tieba.frs.entelechy.b.d fwK;
    private Runnable fwL = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.fwJ != null && i.this.fwJ.getContentView() != null) {
                int h = l.h(i.this.mActivity, d.e.ds270);
                i.this.fwJ.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.fwJ, i.this.mAnchorView, (-l.h(i.this.mActivity, d.e.ds430)) + (i.this.mAnchorView.getMeasuredWidth() / 2) + 30, -h);
                com.baidu.adp.lib.g.e.jH().postDelayed(i.this.fwM, 5000L);
                TiebaStatic.log(new am("c13016").T("obj_locate", 2));
            }
        }
    };
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.bjC();
        }
    };
    private View.OnClickListener fwN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.bjB();
            if (i.this.fwm != null && i.this.fwm.postTopic != null && i.this.fwm.getForum() != null) {
                if (i.this.fwK == null || i.this.fwK.bfN()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.fwm.getForum().getId(), i.this.fwm.getForum().getName(), null, null, 0, i.this.fwm.getAnti(), 13003, false, false, null, false, false, null, null, i.this.fwm.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.fwm.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.fwm.postTopic.recom_topic, true);
                    }
                    ForumData forum = i.this.fwm.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").T("obj_locate", 2));
                }
            }
        }
    };
    private FrsViewData fwm;
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.fwK = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.fwm = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tips)).setText(ap.i(frsViewData.postTopic.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(d.g.tips_content)).setText(d.j.topic_join);
            inflate.setOnClickListener(this.fwN);
            this.fwJ = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fwL);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fwL, 100L);
        }
    }

    public void bjB() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fwL);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fwM);
        bjC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        com.baidu.adp.lib.g.g.a(this.fwJ);
    }
}
