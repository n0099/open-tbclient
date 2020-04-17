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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class l {
    private PopupWindow hyB;
    private com.baidu.tieba.frs.entelechy.b.d hyC;
    private Runnable hyD = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.hyB != null && l.this.hyB.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.hyB.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.hyB, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.lb().postDelayed(l.this.hyE, 5000L);
                TiebaStatic.log(new an("c13016").af("obj_locate", 2));
            }
        }
    };
    private Runnable hyE = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.bWb();
        }
    };
    private View.OnClickListener hyF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.bWa();
            if (l.this.hyb != null && l.this.hyb.postTopic != null && l.this.hyb.getForum() != null) {
                if (l.this.hyC == null || l.this.hyC.bSc()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.hyb.getForum().getId(), l.this.hyb.getForum().getName(), null, null, 0, l.this.hyb.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.hyb.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.hyb.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.hyb.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.hyb.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").af("obj_locate", 2));
                }
            }
        }
    };
    private FrsViewData hyb;
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.hyC = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.hyb = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.hyF);
            this.hyB = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyD);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hyD, 100L);
        }
    }

    public void bWa() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyD);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyE);
        bWb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWb() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.hyB);
    }
}
