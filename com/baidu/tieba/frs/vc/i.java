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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class i {
    private FrsViewData fMP;
    private PopupWindow fNn;
    private com.baidu.tieba.frs.entelechy.b.d fNo;
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.fNn != null && i.this.fNn.getContentView() != null) {
                int g = l.g(i.this.mActivity, R.dimen.ds270);
                i.this.fNn.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.fNn, i.this.mAnchorView, (-l.g(i.this.mActivity, R.dimen.ds430)) + (i.this.mAnchorView.getMeasuredWidth() / 2) + 30, -g);
                com.baidu.adp.lib.g.e.iB().postDelayed(i.this.fNq, 5000L);
                TiebaStatic.log(new am("c13016").P("obj_locate", 2));
            }
        }
    };
    private Runnable fNq = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.bqV();
        }
    };
    private View.OnClickListener fNr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.bqU();
            if (i.this.fMP != null && i.this.fMP.postTopic != null && i.this.fMP.getForum() != null) {
                if (i.this.fNo == null || i.this.fNo.bnh()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.fMP.getForum().getId(), i.this.fMP.getForum().getName(), null, null, 0, i.this.fMP.getAnti(), 13003, false, false, null, false, false, null, null, i.this.fMP.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.fMP.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.fMP.postTopic.recom_topic, true);
                    }
                    ForumData forum = i.this.fMP.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").P("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.fNo = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.fMP = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(ap.l(frsViewData.postTopic.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.fNr);
            this.fNn = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNp);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.fNp, 100L);
        }
    }

    public void bqU() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNp);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNq);
        bqV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqV() {
        com.baidu.adp.lib.g.g.a(this.fNn);
    }
}
