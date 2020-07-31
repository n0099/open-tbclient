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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes16.dex */
public class l {
    private FrsViewData igV;
    private PopupWindow ihv;
    private com.baidu.tieba.frs.entelechy.b.d ihw;
    private Runnable ihx = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.ihv != null && l.this.ihv.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.ihv.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.ihv, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.lt().postDelayed(l.this.ihy, 5000L);
                TiebaStatic.log(new ap("c13016").ah("obj_locate", 2));
            }
        }
    };
    private Runnable ihy = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cjz();
        }
    };
    private View.OnClickListener ihz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cjy();
            if (l.this.igV != null && l.this.igV.postTopic != null && l.this.igV.getForum() != null) {
                if (l.this.ihw == null || l.this.ihw.cfm()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.igV.getForum().getId(), l.this.igV.getForum().getName(), null, null, 0, l.this.igV.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.igV.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.igV.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.igV.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.igV.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new ap("c13017").ah("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.ihw = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.igV = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(as.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.ihz);
            this.ihv = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihx);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ihx, 100L);
        }
    }

    public void cjy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihx);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihy);
        cjz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ihv);
    }
}
