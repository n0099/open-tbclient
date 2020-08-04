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
    private FrsViewData igX;
    private PopupWindow ihx;
    private com.baidu.tieba.frs.entelechy.b.d ihy;
    private Activity mActivity;
    private View mAnchorView;
    private Runnable ihz = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.ihx != null && l.this.ihx.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.ihx.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.ihx, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.lt().postDelayed(l.this.ihA, 5000L);
                TiebaStatic.log(new ap("c13016").ah("obj_locate", 2));
            }
        }
    };
    private Runnable ihA = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cjz();
        }
    };
    private View.OnClickListener ihB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cjy();
            if (l.this.igX != null && l.this.igX.postTopic != null && l.this.igX.getForum() != null) {
                if (l.this.ihy == null || l.this.ihy.cfm()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.igX.getForum().getId(), l.this.igX.getForum().getName(), null, null, 0, l.this.igX.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.igX.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.igX.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.igX.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.igX.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new ap("c13017").ah("obj_locate", 2));
                }
            }
        }
    };

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.ihy = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.igX = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(as.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.ihB);
            this.ihx = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihz);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ihz, 100L);
        }
    }

    public void cjy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihz);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihA);
        cjz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ihx);
    }
}
