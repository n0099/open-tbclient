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
/* loaded from: classes6.dex */
public class k {
    private PopupWindow gHV;
    private com.baidu.tieba.frs.entelechy.b.d gHW;
    private Runnable gHX = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.1
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.mActivity != null && k.this.mAnchorView != null && k.this.gHV != null && k.this.gHV.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(k.this.mActivity, R.dimen.ds270);
                k.this.gHV.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(k.this.gHV, k.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(k.this.mActivity, R.dimen.ds430)) + (k.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.gy().postDelayed(k.this.gHY, 5000L);
                TiebaStatic.log(new an("c13016").Z("obj_locate", 2));
            }
        }
    };
    private Runnable gHY = new Runnable() { // from class: com.baidu.tieba.frs.vc.k.2
        @Override // java.lang.Runnable
        public void run() {
            k.this.bIB();
        }
    };
    private View.OnClickListener gHZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.bIA();
            if (k.this.gHv != null && k.this.gHv.postTopic != null && k.this.gHv.getForum() != null) {
                if (k.this.gHW == null || k.this.gHW.bEH()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(k.this.mActivity, 9, k.this.gHv.getForum().getId(), k.this.gHv.getForum().getName(), null, null, 0, k.this.gHv.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, k.this.gHv.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(k.this.gHv.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(k.this.gHv.postTopic.recom_topic, true);
                    }
                    ForumData forum = k.this.gHv.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").Z("obj_locate", 2));
                }
            }
        }
    };
    private FrsViewData gHv;
    private Activity mActivity;
    private View mAnchorView;

    public k(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.gHW = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.gHv = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.gHZ);
            this.gHV = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gHX);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.gHX, 100L);
        }
    }

    public void bIA() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gHX);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gHY);
        bIB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.gHV);
    }
}
