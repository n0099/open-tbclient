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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends j {
    private TextView bDB;
    private TextView bDC;
    private ViewGroup bDD;
    private TextView bDE;
    private com.baidu.tbadk.core.data.q bDF;
    private int bDG;
    private View.OnClickListener bDH;
    private View.OnClickListener bDI;
    private View.OnClickListener bDJ;
    private CustomMessageListener bDK;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bDF = null;
        this.bDG = 1;
        this.bDH = new b(this);
        this.bDI = new c(this);
        this.bDJ = new d(this);
        this.bDK = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aTY != null) {
            this.aTY.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds142), 0, 0);
        }
        this.bDB = (TextView) this.Ge.findViewById(r.g.book_author);
        this.bDC = (TextView) this.Ge.findViewById(r.g.start_to_read);
        this.bDD = (ViewGroup) this.bQh.findViewById(r.g.frs_header_final_chapter);
        this.bDE = (TextView) this.bQh.findViewById(r.g.book_final_chapter_title);
        this.bzH.registerListener(this.bDK);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bDK);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View Yq() {
        return LayoutInflater.from(this.bzH.getPageContext().getPageActivity()).inflate(r.h.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Yr() {
        this.bDF = this.bFO.bev();
        super.Yr();
        if (this.bDF != null && !StringUtils.isNull(this.bDF.getBookId(), true) && !this.bDF.getBookId().equals("0")) {
            this.bQp = null;
            if (this.bDF.pB() == 3) {
                int intValue = this.bFO.beC().intValue();
                if (intValue > 0) {
                    this.bDG = intValue;
                    this.bDC.setText(this.Gf.getString(r.j.book_continue_read));
                } else {
                    this.bDC.setText(this.Gf.getString(r.j.book_start_read));
                }
            } else if (this.bDF.pE() > 0) {
                this.bDC.setText(this.Gf.getString(r.j.book_continue_read));
            } else {
                this.bDC.setText(this.Gf.getString(r.j.book_start_read));
            }
            this.bDB.setText(this.bDF.pD());
            this.FZ.setOnClickListener(this.bDH);
            this.bQF.setOnClickListener(this.bDH);
            if (this.bDD != null) {
                if (!StringUtils.isNull(this.bDF.pH(), true) && !this.bDF.pH().equals("0")) {
                    this.bDD.setVisibility(0);
                    this.bDE.setText(this.bDF.pF());
                } else {
                    this.bDD.setVisibility(8);
                }
            }
            if (this.bDF.pB() == 3) {
                this.bDC.setOnClickListener(this.bDI);
                if (this.bDD != null) {
                    this.bDD.setOnClickListener(this.bDI);
                    return;
                }
                return;
            }
            this.bDC.setOnClickListener(this.bDJ);
            if (this.bDD != null) {
                this.bDD.setOnClickListener(this.bDJ);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void Ys() {
        if (this.bDF != null && !StringUtils.isNull(this.bDF.pC(), true)) {
            this.bQF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bQF.c(this.bDF.pC(), 15, false);
            if (this.bQF.getBdImage() == null || this.bQF.getBdImage().jV() == null) {
                YI();
                return;
            }
            if (this.bEa == null) {
                this.bEa = new f(this);
            }
            this.bQF.postDelayed(this.bEa, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Yt() {
        this.bDO.en(false);
        if (this.bDD.getVisibility() != 0) {
            super.Yt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, int i) {
        am amVar = new am();
        amVar.pageContext = this.bzH.getPageContext();
        amVar.bookId = str;
        amVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bzH.getPageContext().getPageActivity(), j, i, 2)));
    }
}
