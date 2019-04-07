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
    private FrsViewData fvY;
    private PopupWindow fww;
    private com.baidu.tieba.frs.entelechy.b.d fwx;
    private Activity mActivity;
    private View mAnchorView;
    private Runnable fwy = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.fww != null && i.this.fww.getContentView() != null) {
                int h = l.h(i.this.mActivity, d.e.ds270);
                i.this.fww.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.fww, i.this.mAnchorView, (-l.h(i.this.mActivity, d.e.ds430)) + (i.this.mAnchorView.getMeasuredWidth() / 2) + 30, -h);
                com.baidu.adp.lib.g.e.jH().postDelayed(i.this.fwz, 5000L);
                TiebaStatic.log(new am("c13016").T("obj_locate", 2));
            }
        }
    };
    private Runnable fwz = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.bjA();
        }
    };
    private View.OnClickListener fwA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.bjz();
            if (i.this.fvY != null && i.this.fvY.postTopic != null && i.this.fvY.getForum() != null) {
                if (i.this.fwx == null || i.this.fwx.bfL()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.fvY.getForum().getId(), i.this.fvY.getForum().getName(), null, null, 0, i.this.fvY.getAnti(), 13003, false, false, null, false, false, null, null, i.this.fvY.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.fvY.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.fvY.postTopic.recom_topic, true);
                    }
                    ForumData forum = i.this.fvY.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").T("obj_locate", 2));
                }
            }
        }
    };

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.fwx = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.fvY = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(d.g.tips)).setText(ap.i(frsViewData.postTopic.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(d.g.tips_content)).setText(d.j.topic_join);
            inflate.setOnClickListener(this.fwA);
            this.fww = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fwy);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fwy, 100L);
        }
    }

    public void bjz() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fwy);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fwz);
        bjA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjA() {
        com.baidu.adp.lib.g.g.a(this.fww);
    }
}
