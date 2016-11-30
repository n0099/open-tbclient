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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends j {
    private TextView bXN;
    private TextView bXO;
    private ViewGroup bXP;
    private TextView bXQ;
    private com.baidu.tbadk.core.data.r bXR;
    private int bXS;
    private View.OnClickListener bXT;
    private View.OnClickListener bXU;
    private View.OnClickListener bXV;
    private CustomMessageListener bXW;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bXR = null;
        this.bXS = 1;
        this.bXT = new b(this);
        this.bXU = new c(this);
        this.bXV = new d(this);
        this.bXW = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aUH != null) {
            this.aUH.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds142), 0, 0);
        }
        this.bXN = (TextView) this.Ge.findViewById(r.g.book_author);
        this.bXO = (TextView) this.Ge.findViewById(r.g.start_to_read);
        this.bXP = (ViewGroup) this.ckX.findViewById(r.g.frs_header_final_chapter);
        this.bXQ = (TextView) this.ckX.findViewById(r.g.book_final_chapter_title);
        this.bTA.registerListener(this.bXW);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bXW);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View adX() {
        return LayoutInflater.from(this.bTA.getPageContext().getPageActivity()).inflate(r.h.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void adY() {
        this.bXR = this.cae.bkF();
        super.adY();
        if (this.bXR != null && !StringUtils.isNull(this.bXR.getBookId(), true) && !this.bXR.getBookId().equals("0")) {
            this.cle = null;
            if (this.bXR.pB() == 3) {
                int intValue = this.cae.bkM().intValue();
                if (intValue > 0) {
                    this.bXS = intValue;
                    this.bXO.setText(this.Gf.getString(r.j.book_continue_read));
                } else {
                    this.bXO.setText(this.Gf.getString(r.j.book_start_read));
                }
            } else if (this.bXR.pE() > 0) {
                this.bXO.setText(this.Gf.getString(r.j.book_continue_read));
            } else {
                this.bXO.setText(this.Gf.getString(r.j.book_start_read));
            }
            this.bXN.setText(this.bXR.pD());
            this.FZ.setOnClickListener(this.bXT);
            this.clu.setOnClickListener(this.bXT);
            if (this.bXP != null) {
                if (!StringUtils.isNull(this.bXR.pH(), true) && !this.bXR.pH().equals("0")) {
                    this.bXP.setVisibility(0);
                    this.bXQ.setText(this.bXR.pF());
                } else {
                    this.bXP.setVisibility(8);
                }
            }
            if (this.bXR.pB() == 3) {
                this.bXO.setOnClickListener(this.bXU);
                if (this.bXP != null) {
                    this.bXP.setOnClickListener(this.bXU);
                    return;
                }
                return;
            }
            this.bXO.setOnClickListener(this.bXV);
            if (this.bXP != null) {
                this.bXP.setOnClickListener(this.bXV);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void adZ() {
        if (this.bXR != null && !StringUtils.isNull(this.bXR.pC(), true)) {
            this.clu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.clu.c(this.bXR.pC(), 15, false);
            if (this.clu.getBdImage() == null || this.clu.getBdImage().jV() == null) {
                aep();
                return;
            }
            if (this.bYm == null) {
                this.bYm = new f(this);
            }
            this.clu.postDelayed(this.bYm, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void aea() {
        this.bYa.eD(false);
        if (this.bXP.getVisibility() != 0) {
            super.aea();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, int i) {
        an anVar = new an();
        anVar.pageContext = this.bTA.getPageContext();
        anVar.bookId = str;
        anVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bTA.getPageContext().getPageActivity(), j, i, 2)));
    }
}
