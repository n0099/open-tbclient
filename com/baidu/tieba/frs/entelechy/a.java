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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends j {
    private TextView bRg;
    private TextView bRh;
    private ViewGroup bRi;
    private TextView bRj;
    private com.baidu.tbadk.core.data.s bRk;
    private int bRl;
    private View.OnClickListener bRm;
    private View.OnClickListener bRn;
    private View.OnClickListener bRo;
    private CustomMessageListener bRp;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bRk = null;
        this.bRl = 1;
        this.bRm = new b(this);
        this.bRn = new c(this);
        this.bRo = new d(this);
        this.bRp = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aVc != null) {
            this.aVc.setPadding(0, com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds142), 0, 0);
        }
        this.bRg = (TextView) this.aWX.findViewById(w.h.book_author);
        this.bRh = (TextView) this.aWX.findViewById(w.h.start_to_read);
        this.bRi = (ViewGroup) this.cek.findViewById(w.h.frs_header_final_chapter);
        this.bRj = (TextView) this.cek.findViewById(w.h.book_final_chapter_title);
        this.bOq.registerListener(this.bRp);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bRp);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View aar() {
        return LayoutInflater.from(this.bOq.getPageContext().getPageActivity()).inflate(w.j.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aas() {
        this.bRk = this.bTl.bfW();
        super.aas();
        if (this.bRk != null && !StringUtils.isNull(this.bRk.getBookId(), true) && !this.bRk.getBookId().equals("0")) {
            this.cer = null;
            if (this.bRk.pM() == 3) {
                int intValue = this.bTl.bgd().intValue();
                if (intValue > 0) {
                    this.bRl = intValue;
                    this.bRh.setText(this.aaI.getString(w.l.continue_read));
                } else {
                    this.bRh.setText(this.aaI.getString(w.l.book_start_read));
                }
            } else if (this.bRk.pP() > 0) {
                this.bRh.setText(this.aaI.getString(w.l.continue_read));
            } else {
                this.bRh.setText(this.aaI.getString(w.l.book_start_read));
            }
            this.bRg.setText(this.bRk.pO());
            this.bIN.setOnClickListener(this.bRm);
            this.ceH.setOnClickListener(this.bRm);
            if (this.bRi != null) {
                if (!StringUtils.isNull(this.bRk.pS(), true) && !this.bRk.pS().equals("0")) {
                    this.bRi.setVisibility(0);
                    this.bRj.setText(this.bRk.pQ());
                } else {
                    this.bRi.setVisibility(8);
                }
            }
            if (this.bRk.pM() == 3) {
                this.bRh.setOnClickListener(this.bRn);
                if (this.bRi != null) {
                    this.bRi.setOnClickListener(this.bRn);
                    return;
                }
                return;
            }
            this.bRh.setOnClickListener(this.bRo);
            if (this.bRi != null) {
                this.bRi.setOnClickListener(this.bRo);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aat() {
        if (this.bRk != null && !StringUtils.isNull(this.bRk.pN(), true)) {
            this.ceH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ceH.c(this.bRk.pN(), 15, false);
            if (this.ceH.getBdImage() == null || this.ceH.getBdImage().kN() == null) {
                MY();
                return;
            }
            if (this.bbZ == null) {
                this.bbZ = new f(this);
            }
            this.ceH.postDelayed(this.bbZ, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aau() {
        this.bRt.er(false);
        if (this.bRi.getVisibility() != 0) {
            super.aau();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, int i) {
        ap apVar = new ap();
        apVar.pageContext = this.bOq.getPageContext();
        apVar.bookId = str;
        apVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, apVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bOq.getPageContext().getPageActivity(), j, i, 2)));
    }
}
