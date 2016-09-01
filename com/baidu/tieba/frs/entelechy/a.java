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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends j {
    private TextView bUM;
    private TextView bUN;
    private ViewGroup bUO;
    private TextView bUP;
    private com.baidu.tbadk.core.data.q bUQ;
    private int bUR;
    private View.OnClickListener bUS;
    private View.OnClickListener bUT;
    private View.OnClickListener bUU;
    private CustomMessageListener bUV;

    public a(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bUQ = null;
        this.bUR = 1;
        this.bUS = new b(this);
        this.bUT = new c(this);
        this.bUU = new d(this);
        this.bUV = new e(this, CmdConfigCustom.CMD_SEND_BOOK_READ_RECORD_TO_FRS);
        if (this.aRB != null) {
            this.aRB.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), t.e.ds142), 0, 0);
        }
        this.bUM = (TextView) this.Gc.findViewById(t.g.book_author);
        this.bUN = (TextView) this.Gc.findViewById(t.g.start_to_read);
        this.bUO = (ViewGroup) this.cfX.findViewById(t.g.frs_header_final_chapter);
        this.bUP = (TextView) this.cfX.findViewById(t.g.book_final_chapter_title);
        this.bRp.registerListener(this.bUV);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bUV);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View acy() {
        return LayoutInflater.from(this.bRp.getPageContext().getPageActivity()).inflate(t.h.frs_book_header, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void acz() {
        this.bUQ = this.bWN.bhB();
        super.acz();
        if (this.bUQ != null && !StringUtils.isNull(this.bUQ.getBookId(), true) && !this.bUQ.getBookId().equals("0")) {
            this.cgd = null;
            if (this.bUQ.px() == 3) {
                int intValue = this.bWN.bhH().intValue();
                if (intValue > 0) {
                    this.bUR = intValue;
                    this.bUN.setText(this.Gd.getString(t.j.book_continue_read));
                } else {
                    this.bUN.setText(this.Gd.getString(t.j.book_start_read));
                }
            } else if (this.bUQ.pA() > 0) {
                this.bUN.setText(this.Gd.getString(t.j.book_continue_read));
            } else {
                this.bUN.setText(this.Gd.getString(t.j.book_start_read));
            }
            this.bUM.setText(this.bUQ.pz());
            this.FX.setOnClickListener(this.bUS);
            this.cgr.setOnClickListener(this.bUS);
            if (this.bUO != null && !StringUtils.isNull(this.bUQ.pD(), true) && !this.bUQ.pD().equals("0")) {
                this.bUO.setVisibility(0);
                this.bUP.setText(this.bUQ.pB());
            } else {
                this.bUO.setVisibility(8);
            }
            if (this.bUQ.px() == 3) {
                this.bUN.setOnClickListener(this.bUT);
                this.bUO.setOnClickListener(this.bUT);
                return;
            }
            this.bUN.setOnClickListener(this.bUU);
            this.bUO.setOnClickListener(this.bUU);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acA() {
        if (this.bUQ != null && !StringUtils.isNull(this.bUQ.py(), true)) {
            this.cgr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.cgr.c(this.bUQ.py(), 15, false);
            if (this.cgr.getBdImage() == null || this.cgr.getBdImage().jV() == null) {
                acQ();
                return;
            }
            if (this.bVl == null) {
                this.bVl = new f(this);
            }
            this.cgr.postDelayed(this.bVl, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void acB() {
        this.bUZ.en(false);
        if (this.bUO.getVisibility() != 0) {
            super.acB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, int i) {
        aj ajVar = new aj();
        ajVar.pageContext = this.bRp.getPageContext();
        ajVar.bookId = str;
        ajVar.chapterId = i;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ajVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(this.bRp.getPageContext().getPageActivity(), j, i, 2)));
    }
}
