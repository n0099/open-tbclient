package com.baidu.tieba.frs.vc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes2.dex */
public class l {
    private FrsViewData jFx;
    private PopupWindow jLc;
    private com.baidu.tieba.frs.entelechy.a.d jLd;
    private Runnable jLe = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jLc != null && l.this.jLc.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jLc.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jLc, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mB().postDelayed(l.this.jLf, 5000L);
                TiebaStatic.log(new aq("c13016").an("obj_locate", 2));
            }
        }
    };
    private Runnable jLf = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cOA();
        }
    };
    private View.OnClickListener jLg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cOz();
            if (l.this.jFx != null && l.this.jFx.postTopic != null && l.this.jFx.getForum() != null) {
                if ((l.this.jLd == null || l.this.jLd.cJg()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(l.this.mActivity).setType(9).setForumData(l.this.jFx.getForum()).setAntiData(l.this.jFx.getAnti()).setTitle(l.this.jFx.postTopic.recom_topic).send();
                    TiebaStatic.log(new aq("c13017").an("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.a.d dVar) {
        this.mActivity = activity;
        this.jLd = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jFx = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(at.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jLg);
            this.jLc = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLe);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jLe, 100L);
        }
    }

    public void cOz() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLe);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLf);
        cOA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOA() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jLc);
    }
}
