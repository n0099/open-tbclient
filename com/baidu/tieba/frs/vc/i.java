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
    private FrsViewData fMO;
    private PopupWindow fNm;
    private com.baidu.tieba.frs.entelechy.b.d fNn;
    private Runnable fNo = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.fNm != null && i.this.fNm.getContentView() != null) {
                int g = l.g(i.this.mActivity, R.dimen.ds270);
                i.this.fNm.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.fNm, i.this.mAnchorView, (-l.g(i.this.mActivity, R.dimen.ds430)) + (i.this.mAnchorView.getMeasuredWidth() / 2) + 30, -g);
                com.baidu.adp.lib.g.e.iB().postDelayed(i.this.fNp, 5000L);
                TiebaStatic.log(new am("c13016").P("obj_locate", 2));
            }
        }
    };
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.bqS();
        }
    };
    private View.OnClickListener fNq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.bqR();
            if (i.this.fMO != null && i.this.fMO.postTopic != null && i.this.fMO.getForum() != null) {
                if (i.this.fNn == null || i.this.fNn.bne()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.fMO.getForum().getId(), i.this.fMO.getForum().getName(), null, null, 0, i.this.fMO.getAnti(), 13003, false, false, null, false, false, null, null, i.this.fMO.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.fMO.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.fMO.postTopic.recom_topic, true);
                    }
                    ForumData forum = i.this.fMO.getForum();
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
        this.fNn = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.fMO = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(ap.l(frsViewData.postTopic.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.fNq);
            this.fNm = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNo);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.fNo, 100L);
        }
    }

    public void bqR() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNo);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fNp);
        bqS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqS() {
        com.baidu.adp.lib.g.g.a(this.fNm);
    }
}
