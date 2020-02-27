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
public class k {
    private FrsViewData gMH;
    private PopupWindow gNh;
    private com.baidu.tieba.frs.entelechy.b.d gNi;
    private Runnable gNj = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.mActivity != null && k.this.mAnchorView != null && k.this.gNh != null && k.this.gNh.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(k.this.mActivity, R.dimen.ds270);
                k.this.gNh.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(k.this.gNh, k.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(k.this.mActivity, R.dimen.ds430)) + (k.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.gx().postDelayed(k.this.gNk, 5000L);
                TiebaStatic.log(new an("c13016").X("obj_locate", 2));
            }
        }
    };
    private Runnable gNk = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // java.lang.Runnable
        public void run() {
            k.this.bLe();
        }
    };
    private View.OnClickListener gNl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.bLd();
            if (k.this.gMH != null && k.this.gMH.postTopic != null && k.this.gMH.getForum() != null) {
                if (k.this.gNi == null || k.this.gNi.bHl()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(k.this.mActivity, 9, k.this.gMH.getForum().getId(), k.this.gMH.getForum().getName(), null, null, 0, k.this.gMH.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, k.this.gMH.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(k.this.gMH.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(k.this.gMH.postTopic.recom_topic, true);
                    }
                    ForumData forum = k.this.gMH.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").X("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public k(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gNi = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.gMH = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.gNl);
            this.gNh = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNj);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gNj, 100L);
        }
    }

    public void bLd() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNj);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNk);
        bLe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLe() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gNh);
    }
}
