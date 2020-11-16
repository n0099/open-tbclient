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
/* loaded from: classes21.dex */
public class l {
    private FrsViewData jfx;
    private PopupWindow jkY;
    private com.baidu.tieba.frs.entelechy.b.d jkZ;
    private Runnable jla = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jkY != null && l.this.jkY.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jkY.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jkY, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mY().postDelayed(l.this.jlb, 5000L);
                TiebaStatic.log(new ar("c13016").ak("obj_locate", 2));
            }
        }
    };
    private Runnable jlb = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cGh();
        }
    };
    private View.OnClickListener jlc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cGg();
            if (l.this.jfx != null && l.this.jfx.postTopic != null && l.this.jfx.getForum() != null) {
                if (l.this.jkZ == null || l.this.jkZ.cBN()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(l.this.mActivity, 9, l.this.jfx.getForum().getId(), l.this.jfx.getForum().getName(), null, null, 0, l.this.jfx.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, l.this.jfx.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(l.this.jfx.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(l.this.jfx.postTopic.recom_topic, true);
                    }
                    ForumData forum = l.this.jfx.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                    TiebaStatic.log(new ar("c13017").ak("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.jkZ = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jfx = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(au.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jlc);
            this.jkY = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jla);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jla, 100L);
        }
    }

    public void cGg() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jla);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jlb);
        cGh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jkY);
    }
}
