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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes22.dex */
public class l {
    private FrsViewData jtc;
    private PopupWindow jyD;
    private com.baidu.tieba.frs.entelechy.b.d jyE;
    private Runnable jyF = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jyD != null && l.this.jyD.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jyD.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jyD, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mY().postDelayed(l.this.jyG, 5000L);
                TiebaStatic.log(new ar("c13016").al("obj_locate", 2));
            }
        }
    };
    private Runnable jyG = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cLx();
        }
    };
    private View.OnClickListener jyH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cLw();
            if (l.this.jtc != null && l.this.jtc.postTopic != null && l.this.jtc.getForum() != null) {
                if (l.this.jyE == null || l.this.jyE.cGh()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.jtc.getForum().getId(), l.this.jtc.getForum().getName(), null, null, 0, l.this.jtc.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.jtc.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.jtc.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.jtc.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.jtc.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new ar("c13017").al("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.jyE = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jtc = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(au.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jyH);
            this.jyD = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyF);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jyF, 100L);
        }
    }

    public void cLw() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyF);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyG);
        cLx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLx() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jyD);
    }
}
