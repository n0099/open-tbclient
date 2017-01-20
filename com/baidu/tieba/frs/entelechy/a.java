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
    private TextView bKa;
    private TextView bKb;
    private ViewGroup bKc;
    private TextView bKd;
    private com.baidu.tbadk.core.data.r bKe;
    private int bKf;
    private View.OnClickListener bKg;
    private View.OnClickListener bKh;
    private View.OnClickListener bKi;
    private CustomMessageListener bKj;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bKe = null;
        this.bKf = 1;
        this.bKg = new b(this);
        this.bKh = new c(this);
        this.bKi = new d(this);
        this.bKj = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aPq != null) {
            this.aPq.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.f.ds142), 0, 0);
        }
        this.bKa = (TextView) this.Fo.findViewById(r.h.book_author);
        this.bKb = (TextView) this.Fo.findViewById(r.h.start_to_read);
        this.bKc = (ViewGroup) this.bWM.findViewById(r.h.frs_header_final_chapter);
        this.bKd = (TextView) this.bWM.findViewById(r.h.book_final_chapter_title);
        this.bHh.registerListener(this.bKj);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bKj);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View Zu() {
        return LayoutInflater.from(this.bHh.getPageContext().getPageActivity()).inflate(r.j.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Zv() {
        this.bKe = this.bMf.bgj();
        super.Zv();
        if (this.bKe != null && !StringUtils.isNull(this.bKe.getBookId(), true) && !this.bKe.getBookId().equals("0")) {
            this.bWT = null;
            if (this.bKe.pu() == 3) {
                int intValue = this.bMf.bgq().intValue();
                if (intValue > 0) {
                    this.bKf = intValue;
                    this.bKb.setText(this.Fp.getString(r.l.continue_read));
                } else {
                    this.bKb.setText(this.Fp.getString(r.l.book_start_read));
                }
            } else if (this.bKe.px() > 0) {
                this.bKb.setText(this.Fp.getString(r.l.continue_read));
            } else {
                this.bKb.setText(this.Fp.getString(r.l.book_start_read));
            }
            this.bKa.setText(this.bKe.pw());
            this.Fj.setOnClickListener(this.bKg);
            this.bXj.setOnClickListener(this.bKg);
            if (this.bKc != null) {
                if (!StringUtils.isNull(this.bKe.pA(), true) && !this.bKe.pA().equals("0")) {
                    this.bKc.setVisibility(0);
                    this.bKd.setText(this.bKe.py());
                } else {
                    this.bKc.setVisibility(8);
                }
            }
            if (this.bKe.pu() == 3) {
                this.bKb.setOnClickListener(this.bKh);
                if (this.bKc != null) {
                    this.bKc.setOnClickListener(this.bKh);
                    return;
                }
                return;
            }
            this.bKb.setOnClickListener(this.bKi);
            if (this.bKc != null) {
                this.bKc.setOnClickListener(this.bKi);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void Zw() {
        if (this.bKe != null && !StringUtils.isNull(this.bKe.pv(), true)) {
            this.bXj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bXj.c(this.bKe.pv(), 15, false);
            if (this.bXj.getBdImage() == null || this.bXj.getBdImage().jT() == null) {
                Mm();
                return;
            }
            if (this.aVM == null) {
                this.aVM = new f(this);
            }
            this.bXj.postDelayed(this.aVM, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Zx() {
        this.bKn.er(false);
        if (this.bKc.getVisibility() != 0) {
            super.Zx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, int i) {
        an anVar = new an();
        anVar.pageContext = this.bHh.getPageContext();
        anVar.bookId = str;
        anVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bHh.getPageContext().getPageActivity(), j, i, 2)));
    }
}
