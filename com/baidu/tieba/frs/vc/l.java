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
    private FrsViewData jGv;
    private PopupWindow jMa;
    private com.baidu.tieba.frs.entelechy.a.d jMb;
    private Runnable jMc = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.1
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.mActivity != null && l.this.mAnchorView != null && l.this.jMa != null && l.this.jMa.getContentView() != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds270);
                l.this.jMa.getContentView().measure(0, 0);
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(l.this.jMa, l.this.mAnchorView, (-com.baidu.adp.lib.util.l.getDimens(l.this.mActivity, R.dimen.ds430)) + (l.this.mAnchorView.getMeasuredWidth() / 2) + 30, -dimens);
                com.baidu.adp.lib.f.e.mA().postDelayed(l.this.jMd, 5000L);
                TiebaStatic.log(new ar("c13016").ap("obj_locate", 2));
            }
        }
    };
    private Runnable jMd = new Runnable() { // from class: com.baidu.tieba.frs.vc.l.2
        @Override // java.lang.Runnable
        public void run() {
            l.this.cLX();
        }
    };
    private View.OnClickListener jMe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.cLW();
            if (l.this.jGv != null && l.this.jGv.postTopic != null && l.this.jGv.getForum() != null) {
                if ((l.this.jMb == null || l.this.jMb.cGC()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(l.this.mActivity).setType(9).setForumData(l.this.jGv.getForum()).setAntiData(l.this.jGv.getAnti()).setTitle(l.this.jGv.postTopic.recom_topic).send();
                    TiebaStatic.log(new ar("c13017").ap("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public l(Activity activity, com.baidu.tieba.frs.entelechy.a.d dVar) {
        this.mActivity = activity;
        this.jMb = dVar;
    }

    public void b(View view, FrsViewData frsViewData) {
        if (view != null && frsViewData != null && frsViewData.postTopic != null && this.mActivity != null) {
            this.jGv = frsViewData;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(au.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
            ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
            inflate.setOnClickListener(this.jMe);
            this.jMa = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMc);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jMc, 100L);
        }
    }

    public void cLW() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMd);
        cLX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLX() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jMa);
    }
}
