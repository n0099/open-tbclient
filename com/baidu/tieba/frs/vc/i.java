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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class i {
    private PopupWindow fUT;
    private com.baidu.tieba.frs.entelechy.b.d fUU;
    private Runnable fUV = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.fUT != null && i.this.fUT.getContentView() != null) {
                int g = l.g(i.this.mActivity, R.dimen.ds270);
                i.this.fUT.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.fUT, i.this.mAnchorView, (-l.g(i.this.mActivity, R.dimen.ds430)) + (i.this.mAnchorView.getMeasuredWidth() / 2) + 30, -g);
                com.baidu.adp.lib.g.e.iK().postDelayed(i.this.fUW, 5000L);
                TiebaStatic.log(new an("c13016").P("obj_locate", 2));
            }
        }
    };
    private Runnable fUW = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.btZ();
        }
    };
    private View.OnClickListener fUX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.btY();
            if (i.this.fUt != null && i.this.fUt.postTopic != null && i.this.fUt.getForum() != null) {
                if (i.this.fUU == null || i.this.fUU.bqg()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.fUt.getForum().getId(), i.this.fUt.getForum().getName(), null, null, 0, i.this.fUt.getAnti(), 13003, false, false, null, false, false, null, null, i.this.fUt.getForum().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.fUt.postTopic.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.fUt.postTopic.recom_topic, true);
                    }
                    ForumData forum = i.this.fUt.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new an("c13017").P("obj_locate", 2));
                }
            }
        }
    };
    private FrsViewData fUt;
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.fUU = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.fUt = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(aq.l(frsViewData.postTopic.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.fUX);
            this.fUT = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fUV);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.fUV, 100L);
        }
    }

    public void btY() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fUV);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fUW);
        btZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btZ() {
        com.baidu.adp.lib.g.g.a(this.fUT);
    }
}
