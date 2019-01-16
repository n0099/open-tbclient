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
    private PopupWindow ehB;
    private com.baidu.tieba.frs.entelechy.b.d ehC;
    private Runnable ehD = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.ehB != null && i.this.ehB.getContentView() != null) {
                int h = l.h(i.this.mActivity, e.C0210e.ds252);
                i.this.ehB.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.ehB, i.this.mAnchorView, (-(l.h(i.this.mActivity, e.C0210e.ds430) - i.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jG().postDelayed(i.this.ehE, 5000L);
                TiebaStatic.log(new am("c13016").y("obj_locate", 2));
            }
        }
    };
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.aIM();
        }
    };
    private View.OnClickListener ehF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.aIL();
            if (i.this.eho != null && i.this.eho.hnk != null && i.this.eho.bhx() != null) {
                if (i.this.ehC == null || i.this.ehC.aFp()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.eho.bhx().getId(), i.this.eho.bhx().getName(), null, null, 0, i.this.eho.yR(), 13003, false, false, null, false, false, null, null, i.this.eho.bhx().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.eho.hnk.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.eho.hnk.recom_topic, true);
                    }
                    ForumData bhx = i.this.eho.bhx();
                    writeActivityConfig.setForumDir(bhx.getFirst_class(), bhx.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").y("obj_locate", 2));
                }
            }
        }
    };
    private com.baidu.tieba.tbadkCore.l eho;
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.ehC = dVar;
    }

    public void b(View view, com.baidu.tieba.tbadkCore.l lVar) {
        if (view != null && lVar != null && lVar.hnk != null && this.mActivity != null) {
            this.eho = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.hnk.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.ehF);
            this.ehB = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehD);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ehD, 100L);
        }
    }

    public void aIL() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehD);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
        aIM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIM() {
        com.baidu.adp.lib.g.g.a(this.ehB);
    }
}
