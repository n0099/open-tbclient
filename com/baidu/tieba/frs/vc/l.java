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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes22.dex */
public class l {
    private FrsViewData jta;
    private PopupWindow jyB;
    private com.baidu.tieba.frs.entelechy.b.d jyC;
    private Runnable jyD = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jyB != null && l.this.jyB.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jyB.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jyB, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mY().postDelayed(l.this.jyE, 5000L);
                TiebaStatic.log(new ar("c13016").al("obj_locate", 2));
            }
        }
    };
    private Runnable jyE = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cLw();
        }
    };
    private View.OnClickListener jyF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cLv();
            if (l.this.jta != null && l.this.jta.postTopic != null && l.this.jta.getForum() != null) {
                if (l.this.jyC == null || l.this.jyC.cGg()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.jta.getForum().getId(), l.this.jta.getForum().getName(), null, null, 0, l.this.jta.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.jta.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.jta.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.jta.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.jta.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new ar("c13017").al("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.jyC = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jta = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(au.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jyF);
            this.jyB = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyD);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jyD, 100L);
        }
    }

    public void cLv() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyD);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyE);
        cLw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLw() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jyB);
    }
}
