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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes6.dex */
public class i {
    private l egI;
    private PopupWindow egV;
    private com.baidu.tieba.frs.entelechy.b.d egW;
    private Runnable egX = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.mActivity != null && i.this.mAnchorView != null && i.this.egV != null && i.this.egV.getContentView() != null) {
                int h = com.baidu.adp.lib.util.l.h(i.this.mActivity, e.C0210e.ds252);
                i.this.egV.getContentView().measure(0, 0);
                com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(i.this.egV, i.this.mAnchorView, (-(com.baidu.adp.lib.util.l.h(i.this.mActivity, e.C0210e.ds430) - i.this.mAnchorView.getMeasuredWidth())) / 2, -h);
                com.baidu.adp.lib.g.e.jG().postDelayed(i.this.egY, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 2));
            }
        }
    };
    private Runnable egY = new Runnable() { // from class: com.baidu.tieba.frs.vc.i.2
        @Override // java.lang.Runnable
        public void run() {
            i.this.aIp();
        }
    };
    private View.OnClickListener egZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.i.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.aIo();
            if (i.this.egI != null && i.this.egI.hmf != null && i.this.egI.bgT() != null) {
                if (i.this.egW == null || i.this.egW.aES()) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(i.this.mActivity, 9, i.this.egI.bgT().getId(), i.this.egI.bgT().getName(), null, null, 0, i.this.egI.yE(), 13003, false, false, null, false, false, null, null, i.this.egI.bgT().getPrefixData(), 0);
                    if (!StringUtils.isNull(i.this.egI.hmf.recom_topic)) {
                        writeActivityConfig.setTitle(i.this.egI.hmf.recom_topic, true);
                    }
                    ForumData bgT = i.this.egI.bgT();
                    writeActivityConfig.setForumDir(bgT.getFirst_class(), bgT.getSecond_class());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
                    TiebaStatic.log(new am("c13017").x("obj_locate", 2));
                }
            }
        }
    };
    private Activity mActivity;
    private View mAnchorView;

    public i(Activity activity, com.baidu.tieba.frs.entelechy.b.d dVar) {
        this.mActivity = activity;
        this.egW = dVar;
    }

    public void b(View view, l lVar) {
        if (view != null && lVar != null && lVar.hmf != null && this.mActivity != null) {
            this.egI = lVar;
            this.mAnchorView = view;
            View inflate = LayoutInflater.from(this.mActivity).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
            ((TextView) inflate.findViewById(e.g.tips)).setText(ao.f(lVar.hmf.recom_title, 24, "..."));
            ((TextView) inflate.findViewById(e.g.tips_content)).setText(e.j.topic_join);
            inflate.setOnClickListener(this.egZ);
            this.egV = new PopupWindow(inflate, -2, -2);
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egX);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.egX, 100L);
        }
    }

    public void aIo() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egX);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egY);
        aIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        com.baidu.adp.lib.g.g.a(this.egV);
    }
}
