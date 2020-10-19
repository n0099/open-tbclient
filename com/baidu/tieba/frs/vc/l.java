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
/* loaded from: classes22.dex */
public class l {
    private PopupWindow iRU;
    private com.baidu.tieba.frs.entelechy.b.d iRV;
    private Runnable iRW = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.iRU != null && l.this.iRU.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.iRU.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.iRU, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mY().postDelayed(l.this.iRX, 5000L);
                TiebaStatic.log(new aq("c13016").aj("obj_locate", 2));
            }
        }
    };
    private Runnable iRX = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cAU();
        }
    };
    private View.OnClickListener iRY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cAT();
            if (l.this.iRt != null && l.this.iRt.postTopic != null && l.this.iRt.getForum() != null) {
                if (l.this.iRV == null || l.this.iRV.cwC()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.iRt.getForum().getId(), l.this.iRt.getForum().getName(), null, null, 0, l.this.iRt.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.iRt.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.iRt.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.iRt.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.iRt.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new aq("c13017").aj("obj_locate", 2));
                }
            }
        }
    };
    private FrsViewData iRt;
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.iRV = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.iRt = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(at.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.iRY);
            this.iRU = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRW);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iRW, 100L);
        }
    }

    public void cAT() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRW);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRX);
        cAU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAU() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.iRU);
    }
}
