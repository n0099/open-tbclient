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
    private TextView bTm;
    private TextView bTn;
    private ViewGroup bTo;
    private TextView bTp;
    private com.baidu.tbadk.core.data.s bTq;
    private int bTr;
    private View.OnClickListener bTs;
    private View.OnClickListener bTt;
    private View.OnClickListener bTu;
    private CustomMessageListener bTv;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bTq = null;
        this.bTr = 1;
        this.bTs = new b(this);
        this.bTt = new c(this);
        this.bTu = new d(this);
        this.bTv = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aVr != null) {
            this.aVr.setPadding(0, com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds142), 0, 0);
        }
        this.bTm = (TextView) this.aXo.findViewById(w.h.book_author);
        this.bTn = (TextView) this.aXo.findViewById(w.h.start_to_read);
        this.bTo = (ViewGroup) this.cfc.findViewById(w.h.frs_header_final_chapter);
        this.bTp = (TextView) this.cfc.findViewById(w.h.book_final_chapter_title);
        this.bQw.registerListener(this.bTv);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bTv);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View abQ() {
        return LayoutInflater.from(this.bQw.getPageContext().getPageActivity()).inflate(w.j.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void abR() {
        this.bTq = this.bVq.bhL();
        super.abR();
        if (this.bTq != null && !StringUtils.isNull(this.bTq.getBookId(), true) && !this.bTq.getBookId().equals("0")) {
            this.cfj = null;
            if (this.bTq.qk() == 3) {
                int intValue = this.bVq.bhR().intValue();
                if (intValue > 0) {
                    this.bTr = intValue;
                    this.bTn.setText(this.aaY.getString(w.l.continue_read));
                } else {
                    this.bTn.setText(this.aaY.getString(w.l.book_start_read));
                }
            } else if (this.bTq.qn() > 0) {
                this.bTn.setText(this.aaY.getString(w.l.continue_read));
            } else {
                this.bTn.setText(this.aaY.getString(w.l.book_start_read));
            }
            this.bTm.setText(this.bTq.qm());
            this.bKX.setOnClickListener(this.bTs);
            this.cfy.setOnClickListener(this.bTs);
            if (this.bTo != null) {
                if (!StringUtils.isNull(this.bTq.qq(), true) && !this.bTq.qq().equals("0")) {
                    this.bTo.setVisibility(0);
                    this.bTp.setText(this.bTq.qo());
                } else {
                    this.bTo.setVisibility(8);
                }
            }
            if (this.bTq.qk() == 3) {
                this.bTn.setOnClickListener(this.bTt);
                if (this.bTo != null) {
                    this.bTo.setOnClickListener(this.bTt);
                    return;
                }
                return;
            }
            this.bTn.setOnClickListener(this.bTu);
            if (this.bTo != null) {
                this.bTo.setOnClickListener(this.bTu);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void abS() {
        if (this.bTq != null && !StringUtils.isNull(this.bTq.ql(), true)) {
            this.cfy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cfy.c(this.bTq.ql(), 15, false);
            if (this.cfy.getBdImage() == null || this.cfy.getBdImage().kS() == null) {
                NE();
                return;
            }
            if (this.bcQ == null) {
                this.bcQ = new f(this);
            }
            this.cfy.postDelayed(this.bcQ, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void abT() {
        this.bTz.eB(false);
        if (this.bTo.getVisibility() != 0) {
            super.abT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, int i) {
        ao aoVar = new ao();
        aoVar.pageContext = this.bQw.getPageContext();
        aoVar.bookId = str;
        aoVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bQw.getPageContext().getPageActivity(), j, i, 2)));
    }
}
