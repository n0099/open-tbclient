package com.baidu.tieba.frs.entelechy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends j {
    private TextView bQV;
    private TextView bQW;
    private ViewGroup bQX;
    private TextView bQY;
    private com.baidu.tbadk.core.data.s bQZ;
    private int bRa;
    private View.OnClickListener bRb;
    private View.OnClickListener bRc;
    private View.OnClickListener bRd;
    private CustomMessageListener bRe;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bQZ = null;
        this.bRa = 1;
        this.bRb = new b(this);
        this.bRc = new c(this);
        this.bRd = new d(this);
        this.bRe = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aVp != null) {
            this.aVp.setPadding(0, com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds142), 0, 0);
        }
        this.bQV = (TextView) this.aXl.findViewById(w.h.book_author);
        this.bQW = (TextView) this.aXl.findViewById(w.h.start_to_read);
        this.bQX = (ViewGroup) this.ccL.findViewById(w.h.frs_header_final_chapter);
        this.bQY = (TextView) this.ccL.findViewById(w.h.book_final_chapter_title);
        this.bOf.registerListener(this.bRe);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bRe);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View aaP() {
        return LayoutInflater.from(this.bOf.getPageContext().getPageActivity()).inflate(w.j.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aaQ() {
        this.bQZ = this.bSZ.bgJ();
        super.aaQ();
        if (this.bQZ != null && !StringUtils.isNull(this.bQZ.getBookId(), true) && !this.bQZ.getBookId().equals("0")) {
            this.ccS = null;
            if (this.bQZ.qk() == 3) {
                int intValue = this.bSZ.bgQ().intValue();
                if (intValue > 0) {
                    this.bRa = intValue;
                    this.bQW.setText(this.aaX.getString(w.l.continue_read));
                } else {
                    this.bQW.setText(this.aaX.getString(w.l.book_start_read));
                }
            } else if (this.bQZ.qn() > 0) {
                this.bQW.setText(this.aaX.getString(w.l.continue_read));
            } else {
                this.bQW.setText(this.aaX.getString(w.l.book_start_read));
            }
            this.bQV.setText(this.bQZ.qm());
            this.bIG.setOnClickListener(this.bRb);
            this.cdh.setOnClickListener(this.bRb);
            if (this.bQX != null) {
                if (!StringUtils.isNull(this.bQZ.qq(), true) && !this.bQZ.qq().equals("0")) {
                    this.bQX.setVisibility(0);
                    this.bQY.setText(this.bQZ.qo());
                } else {
                    this.bQX.setVisibility(8);
                }
            }
            if (this.bQZ.qk() == 3) {
                this.bQW.setOnClickListener(this.bRc);
                if (this.bQX != null) {
                    this.bQX.setOnClickListener(this.bRc);
                    return;
                }
                return;
            }
            this.bQW.setOnClickListener(this.bRd);
            if (this.bQX != null) {
                this.bQX.setOnClickListener(this.bRd);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aaR() {
        if (this.bQZ != null && !StringUtils.isNull(this.bQZ.ql(), true)) {
            this.cdh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cdh.c(this.bQZ.ql(), 15, false);
            if (this.cdh.getBdImage() == null || this.cdh.getBdImage().kR() == null) {
                Nw();
                return;
            }
            if (this.bbS == null) {
                this.bbS = new f(this);
            }
            this.cdh.postDelayed(this.bbS, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aaS() {
        this.bRi.er(false);
        if (this.bQX.getVisibility() != 0) {
            super.aaS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, int i) {
        ao aoVar = new ao();
        aoVar.pageContext = this.bOf.getPageContext();
        aoVar.bookId = str;
        aoVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bOf.getPageContext().getPageActivity(), j, i, 2)));
    }
}
