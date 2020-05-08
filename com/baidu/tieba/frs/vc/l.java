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
    private PopupWindow hyH;
    private com.baidu.tieba.frs.entelechy.b.d hyI;
    private Runnable hyJ = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.hyH != null && l.this.hyH.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.hyH.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.hyH, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.lb().postDelayed(l.this.hyK, 5000L);
                TiebaStatic.log(new an("c13016").af("obj_locate", 2));
            }
        }
    };
    private Runnable hyK = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.bVZ();
        }
    };
    private View.OnClickListener hyL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.bVY();
            if (l.this.hyh != null && l.this.hyh.postTopic != null && l.this.hyh.getForum() != null) {
                if (l.this.hyI == null || l.this.hyI.bSa()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.hyh.getForum().getId(), l.this.hyh.getForum().getName(), null, null, 0, l.this.hyh.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.hyh.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.hyh.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.hyh.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.hyh.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").af("obj_locate", 2));
                }
            }
        }
    };
    private FrsViewData hyh;
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.hyI = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.hyh = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.hyL);
            this.hyH = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyJ);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hyJ, 100L);
        }
    }

    public void bVY() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyJ);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyK);
        bVZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVZ() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.hyH);
    }
}
