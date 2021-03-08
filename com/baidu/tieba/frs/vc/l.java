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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes2.dex */
public class l {
    private FrsViewData jIs;
    private PopupWindow jNX;
    private com.baidu.tieba.frs.entelechy.a.d jNY;
    private Runnable jNZ = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jNX != null && l.this.jNX.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jNX.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jNX, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mA().postDelayed(l.this.jOa, 5000L);
                TiebaStatic.log(new ar("c13016").aq("obj_locate", 2));
            }
        }
    };
    private Runnable jOa = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cMk();
        }
    };
    private View.OnClickListener jOb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cMj();
            if (l.this.jIs != null && l.this.jIs.postTopic != null && l.this.jIs.getForum() != null) {
                if ((l.this.jNY == null || l.this.jNY.cGP()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(l.this.mActivity).setType(9).setForumData(l.this.jIs.getForum()).setAntiData(l.this.jIs.getAnti()).setTitle(l.this.jIs.postTopic.recom_topic).send();
                    TiebaStatic.log(new ar("c13017").aq("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.a.d dVar) {
        this.mActivity = activity;
        this.jNY = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jIs = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(au.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jOb);
            this.jNX = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNZ);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jNZ, 100L);
        }
    }

    public void cMj() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNZ);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jOa);
        cMk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMk() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jNX);
    }
}
