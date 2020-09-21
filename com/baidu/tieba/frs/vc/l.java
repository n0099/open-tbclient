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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes21.dex */
public class l {
    private FrsViewData iCD;
    private PopupWindow iDe;
    private com.baidu.tieba.frs.entelechy.b.d iDf;
    private Runnable iDg = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.iDe != null && l.this.iDe.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.iDe.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.iDe, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mX().postDelayed(l.this.iDh, 5000L);
                TiebaStatic.log(new aq("c13016").ai("obj_locate", 2));
            }
        }
    };
    private Runnable iDh = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cxx();
        }
    };
    private View.OnClickListener iDi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cxw();
            if (l.this.iCD != null && l.this.iCD.postTopic != null && l.this.iCD.getForum() != null) {
                if (l.this.iDf == null || l.this.iDf.ctf()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.iCD.getForum().getId(), l.this.iCD.getForum().getName(), null, null, 0, l.this.iCD.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.iCD.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.iCD.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.iCD.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.iCD.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new aq("c13017").ai("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.iDf = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.iCD = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(at.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.iDi);
            this.iDe = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDg);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.iDg, 100L);
        }
    }

    public void cxw() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDg);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDh);
        cxx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxx() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.iDe);
    }
}
