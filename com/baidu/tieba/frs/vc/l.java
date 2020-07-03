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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class l {
    private FrsViewData iaT;
    private PopupWindow ibt;
    private com.baidu.tieba.frs.entelechy.b.d ibu;
    private Runnable ibv = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.ibt != null && l.this.ibt.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.ibt.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.ibt, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.lt().postDelayed(l.this.ibw, 5000L);
                TiebaStatic.log(new ao("c13016").ag("obj_locate", 2));
            }
        }
    };
    private Runnable ibw = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cfZ();
        }
    };
    private View.OnClickListener ibx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cfY();
            if (l.this.iaT != null && l.this.iaT.postTopic != null && l.this.iaT.getForum() != null) {
                if (l.this.ibu == null || l.this.ibu.cbN()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.iaT.getForum().getId(), l.this.iaT.getForum().getName(), null, null, 0, l.this.iaT.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.iaT.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.iaT.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.iaT.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.iaT.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new ao("c13017").ag("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.ibu = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.iaT = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(ar.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.ibx);
            this.ibt = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ibv);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ibv, 100L);
        }
    }

    public void cfY() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ibv);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ibw);
        cfZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfZ() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ibt);
    }
}
