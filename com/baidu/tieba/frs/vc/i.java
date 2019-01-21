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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class i {
    private PopupWindow ehC;
    private com.baidu.tieba.frs.entelechy.b.d ehD;
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.ehC != null && i.this.ehC.getContentView() != null) {
                int h = l.h(i.this.mActivity, e.C0210e.ds252);
                i.this.ehC.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.ehC, i.this.mAnchorView, (-(l.h(i.this.mActivity, e.C0210e.ds430) - i.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jG().postDelayed(i.this.ehF, 5000L);
                TiebaStatic.log(new am("c13016").y("obj_locate", 2));
            }
        }
    };
    private Runnable ehF = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.aIM();
        }
    };
    private View.OnClickListener ehG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.aIL();
            if (i.this.ehp != null && i.this.ehp.hnl != null && i.this.ehp.bhx() != null) {
                if (i.this.ehD == null || i.this.ehD.aFp()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.ehp.bhx().getId(), i.this.ehp.bhx().getName(), null, null, 0, i.this.ehp.yR(), 13003, false, false, null, false, false, null, null, i.this.ehp.bhx().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.ehp.hnl.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.ehp.hnl.recom_topic, true);
                    }
                    ForumData bhx = i.this.ehp.bhx();
                    writeActivityConfig.setForumDir(bhx.getFirst_class(), bhx.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").y("obj_locate", 2));
                }
            }
        }
    };
    private com.baidu.tieba.tbadkCore.l ehp;
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.ehD = dVar;
    }

    public void b(View view, com.baidu.tieba.tbadkCore.l lVar) {
        if (view != null && lVar != null && lVar.hnl != null && this.mActivity != null) {
            this.ehp = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.hnl.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.ehG);
            this.ehC = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ehE, 100L);
        }
    }

    public void aIL() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehF);
        aIM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIM() {
        com.baidu.adp.lib.g.g.a(this.ehC);
    }
}
