package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.x;
import com.google.gson.Gson;
/* loaded from: classes16.dex */
public abstract class a implements View.OnClickListener {
    protected Gson gson = new Gson();
    protected View hVo;
    protected final BaseFragmentActivity hwQ;
    protected final ForumWriteData ifP;
    protected TextView ifQ;
    protected SerializableItemInfo ifR;
    protected final c ifS;
    private i ifT;
    private SaveDraftDialogView ifU;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bsv();

    protected abstract void cpZ();

    public abstract void cqb();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.hwQ = baseFragmentActivity;
        this.ifP = forumWriteData;
        this.ifR = serializableItemInfo;
        this.ifS = new c(this.hwQ, this.hwQ.getUniqueId(), this.ifP, this.ifR);
        initUI();
        buO();
        cpZ();
    }

    protected void buO() {
        if (this.mNavigationBar != null) {
            this.ifQ = new TextView(this.hwQ);
            this.ifQ.setAlpha(0.5f);
            this.ifQ.setText(this.hwQ.getString(R.string.send_post));
            this.ifQ.setTextSize(0, l.getDimens(this.hwQ, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.hwQ, R.dimen.tbds44);
            this.ifQ.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ifQ, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.hwQ.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.hwQ, R.dimen.tbds44));
            this.hVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqa() {
        if (this.ifU == null) {
            this.ifU = new SaveDraftDialogView(this.hwQ);
            this.ifU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cqc();
                            a.this.hwQ.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bsv();
                            a.this.hwQ.finish();
                        }
                        a.this.ifT.dismiss();
                    }
                }
            });
        }
        if (this.ifT == null) {
            this.ifT = new i(this.hwQ.getPageContext());
            this.ifT.setContentView(this.ifU);
        }
        this.ifU.setText(this.hwQ.getString(R.string.write_save_draft_dialog_normal_title), null, this.hwQ.getString(R.string.save));
        this.ifT.Nv();
    }

    protected void cqc() {
        if (this.ifP != null) {
            x.c(String.valueOf(this.ifP.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.ifT, this.hwQ);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.ifQ != null) {
            ap.setViewTextColor(this.ifQ, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
