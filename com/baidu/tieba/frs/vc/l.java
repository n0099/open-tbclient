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
    private FrsViewData jGJ;
    private PopupWindow jMo;
    private com.baidu.tieba.frs.entelechy.a.d jMp;
    private Runnable jMq = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jMo != null && l.this.jMo.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jMo.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jMo, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mA().postDelayed(l.this.jMr, 5000L);
                TiebaStatic.log(new ar("c13016").ap("obj_locate", 2));
            }
        }
    };
    private Runnable jMr = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cMe();
        }
    };
    private View.OnClickListener jMs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cMd();
            if (l.this.jGJ != null && l.this.jGJ.postTopic != null && l.this.jGJ.getForum() != null) {
                if ((l.this.jMp == null || l.this.jMp.cGJ()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(l.this.mActivity).setType(9).setForumData(l.this.jGJ.getForum()).setAntiData(l.this.jGJ.getAnti()).setTitle(l.this.jGJ.postTopic.recom_topic).send();
                    TiebaStatic.log(new ar("c13017").ap("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.a.d dVar) {
        this.mActivity = activity;
        this.jMp = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jGJ = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(au.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jMs);
            this.jMo = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMq);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jMq, 100L);
        }
    }

    public void cMd() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMq);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMr);
        cMe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMe() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jMo);
    }
}
