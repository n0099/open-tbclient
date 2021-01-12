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
    private FrsViewData jAR;
    private PopupWindow jGw;
    private com.baidu.tieba.frs.entelechy.a.d jGx;
    private Activity mActivity;
    private View mAnchorView;
    private Runnable jGy = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jGw != null && l.this.jGw.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jGw.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jGw, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mB().postDelayed(l.this.jGz, 5000L);
                TiebaStatic.log(new aq("c13016").an("obj_locate", 2));
            }
        }
    };
    private Runnable jGz = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cKJ();
        }
    };
    private View.OnClickListener jGA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cKI();
            if (l.this.jAR != null && l.this.jAR.postTopic != null && l.this.jAR.getForum() != null) {
                if ((l.this.jGx == null || l.this.jGx.cFp()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(l.this.mActivity).setType(9).setForumData(l.this.jAR.getForum()).setAntiData(l.this.jAR.getAnti()).setTitle(l.this.jAR.postTopic.recom_topic).send();
                    TiebaStatic.log(new aq("c13017").an("obj_locate", 2));
                }
            }
        }
    };

    public l(Activity activity, com.baidu.tieba.frs.entelechy.a.d dVar) {
        this.mActivity = activity;
        this.jGx = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jAR = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(at.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jGA);
            this.jGw = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jGy);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jGy, 100L);
        }
    }

    public void cKI() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jGy);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jGz);
        cKJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jGw);
    }
}
