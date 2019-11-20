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
/* loaded from: classes4.dex */
public class i {
    private FrsViewData fSW;
    private PopupWindow fTw;
    private com.baidu.tieba.frs.entelechy.b.d fTx;
    private Activity mActivity;
    private View mAnchorView;
    private Runnable fTy = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.fTw != null && i.this.fTw.getContentView() != null) {
                int dimens = l.getDimens(i.this.mActivity, R.dimen.ds270);
                i.this.fTw.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.fTw, i.this.mAnchorView, (-l.getDimens(i.this.mActivity, R.dimen.ds430)) + (i.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.g.e.fZ().postDelayed(i.this.fTz, 5000L);
                TiebaStatic.log(new an("c13016").O("obj_locate", 2));
            }
        }
    };
    private Runnable fTz = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.bra();
        }
    };
    private View.OnClickListener fTA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.bqZ();
            if (i.this.fSW != null && i.this.fSW.postTopic != null && i.this.fSW.getForum() != null) {
                if (i.this.fTx == null || i.this.fTx.bnj()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.fSW.getForum().getId(), i.this.fSW.getForum().getName(), null, null, 0, i.this.fSW.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, i.this.fSW.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.fSW.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.fSW.postTopic.recom_topic, true);
                    }
                    ForumData forum = i.this.fSW.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").O("obj_locate", 2));
                }
            }
        }
    };

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.fTx = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.fSW = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.fTA);
            this.fTw = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fTy);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.fTy, 100L);
        }
    }

    public void bqZ() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fTy);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fTz);
        bra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        com.baidu.adp.lib.g.g.dismissPopupWindow(this.fTw);
    }
}
