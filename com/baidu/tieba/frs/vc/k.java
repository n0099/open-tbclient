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
    private FrsViewData gMJ;
    private PopupWindow gNj;
    private com.baidu.tieba.frs.entelechy.b.d gNk;
    private Runnable gNl = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.mActivity != null && k.this.mAnchorView != null && k.this.gNj != null && k.this.gNj.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(k.this.mActivity, R.dimen.ds270);
                k.this.gNj.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(k.this.gNj, k.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(k.this.mActivity, R.dimen.ds430)) + (k.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.gx().postDelayed(k.this.gNm, 5000L);
                TiebaStatic.log(new an("c13016").X("obj_locate", 2));
            }
        }
    };
    private Runnable gNm = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // java.lang.Runnable
        public void run() {
            k.this.bLg();
        }
    };
    private View.OnClickListener gNn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.bLf();
            if (k.this.gMJ != null && k.this.gMJ.postTopic != null && k.this.gMJ.getForum() != null) {
                if (k.this.gNk == null || k.this.gNk.bHn()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(k.this.mActivity, 9, k.this.gMJ.getForum().getId(), k.this.gMJ.getForum().getName(), null, null, 0, k.this.gMJ.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, k.this.gMJ.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(k.this.gMJ.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(k.this.gMJ.postTopic.recom_topic, true);
                    }
                    ForumData forum = k.this.gMJ.getForum();
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
        this.gNk = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.gMJ = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.gNn);
            this.gNj = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNl);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gNl, 100L);
        }
    }

    public void bLf() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNl);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gNm);
        bLg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLg() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gNj);
    }
}
