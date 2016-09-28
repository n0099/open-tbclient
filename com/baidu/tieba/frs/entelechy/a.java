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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends j {
    private TextView bUF;
    private TextView bUG;
    private ViewGroup bUH;
    private TextView bUI;
    private com.baidu.tbadk.core.data.q bUJ;
    private int bUK;
    private View.OnClickListener bUL;
    private View.OnClickListener bUM;
    private View.OnClickListener bUN;
    private CustomMessageListener bUO;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bUJ = null;
        this.bUK = 1;
        this.bUL = new b(this);
        this.bUM = new c(this);
        this.bUN = new d(this);
        this.bUO = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aSG != null) {
            this.aSG.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds142), 0, 0);
        }
        this.bUF = (TextView) this.Gc.findViewById(r.g.book_author);
        this.bUG = (TextView) this.Gc.findViewById(r.g.start_to_read);
        this.bUH = (ViewGroup) this.cfU.findViewById(r.g.frs_header_final_chapter);
        this.bUI = (TextView) this.cfU.findViewById(r.g.book_final_chapter_title);
        this.bRi.registerListener(this.bUO);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bUO);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View acK() {
        return LayoutInflater.from(this.bRi.getPageContext().getPageActivity()).inflate(r.h.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void acL() {
        this.bUJ = this.bWN.bik();
        super.acL();
        if (this.bUJ != null && !StringUtils.isNull(this.bUJ.getBookId(), true) && !this.bUJ.getBookId().equals("0")) {
            this.cga = null;
            if (this.bUJ.py() == 3) {
                int intValue = this.bWN.bir().intValue();
                if (intValue > 0) {
                    this.bUK = intValue;
                    this.bUG.setText(this.Gd.getString(r.j.book_continue_read));
                } else {
                    this.bUG.setText(this.Gd.getString(r.j.book_start_read));
                }
            } else if (this.bUJ.pB() > 0) {
                this.bUG.setText(this.Gd.getString(r.j.book_continue_read));
            } else {
                this.bUG.setText(this.Gd.getString(r.j.book_start_read));
            }
            this.bUF.setText(this.bUJ.pA());
            this.FX.setOnClickListener(this.bUL);
            this.cgp.setOnClickListener(this.bUL);
            if (this.bUH != null) {
                if (!StringUtils.isNull(this.bUJ.pE(), true) && !this.bUJ.pE().equals("0")) {
                    this.bUH.setVisibility(0);
                    this.bUI.setText(this.bUJ.pC());
                } else {
                    this.bUH.setVisibility(8);
                }
            }
            if (this.bUJ.py() == 3) {
                this.bUG.setOnClickListener(this.bUM);
                if (this.bUH != null) {
                    this.bUH.setOnClickListener(this.bUM);
                    return;
                }
                return;
            }
            this.bUG.setOnClickListener(this.bUN);
            if (this.bUH != null) {
                this.bUH.setOnClickListener(this.bUN);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acM() {
        if (this.bUJ != null && !StringUtils.isNull(this.bUJ.pz(), true)) {
            this.cgp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cgp.c(this.bUJ.pz(), 15, false);
            if (this.cgp.getBdImage() == null || this.cgp.getBdImage().jV() == null) {
                adc();
                return;
            }
            if (this.bVe == null) {
                this.bVe = new f(this);
            }
            this.cgp.postDelayed(this.bVe, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void acN() {
        this.bUS.eo(false);
        if (this.bUH.getVisibility() != 0) {
            super.acN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, int i) {
        al alVar = new al();
        alVar.pageContext = this.bRi.getPageContext();
        alVar.bookId = str;
        alVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bRi.getPageContext().getPageActivity(), j, i, 2)));
    }
}
