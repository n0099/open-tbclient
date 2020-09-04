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
    protected View hVu;
    protected final BaseFragmentActivity hwW;
    protected final ForumWriteData ifV;
    protected TextView ifW;
    protected SerializableItemInfo ifX;
    protected final c ifY;
    private i ifZ;
    private SaveDraftDialogView iga;
    protected TextView mCenterText;
    protected NavigationBar mNavigationBar;
    protected View mRoot;

    public abstract void bsw();

    protected abstract void cqa();

    public abstract void cqc();

    protected abstract void initUI();

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.hwW = baseFragmentActivity;
        this.ifV = forumWriteData;
        this.ifX = serializableItemInfo;
        this.ifY = new c(this.hwW, this.hwW.getUniqueId(), this.ifV, this.ifX);
        initUI();
        buP();
        cqa();
    }

    protected void buP() {
        if (this.mNavigationBar != null) {
            this.ifW = new TextView(this.hwW);
            this.ifW.setAlpha(0.5f);
            this.ifW.setText(this.hwW.getString(R.string.send_post));
            this.ifW.setTextSize(0, l.getDimens(this.hwW, R.dimen.tbds44));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = l.getDimens(this.hwW, R.dimen.tbds44);
            this.ifW.setLayoutParams(layoutParams);
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ifW, this);
            this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.hwW.getString(R.string.publish_comment));
            this.mCenterText.setTextSize(0, l.getDimens(this.hwW, R.dimen.tbds44));
            this.hVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        }
    }

    public View getView() {
        return this.mRoot;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqb() {
        if (this.iga == null) {
            this.iga = new SaveDraftDialogView(this.hwW);
            this.iga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.examination.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            a.this.cqd();
                            a.this.hwW.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            a.this.bsw();
                            a.this.hwW.finish();
                        }
                        a.this.ifZ.dismiss();
                    }
                }
            });
        }
        if (this.ifZ == null) {
            this.ifZ = new i(this.hwW.getPageContext());
            this.ifZ.setContentView(this.iga);
        }
        this.iga.setText(this.hwW.getString(R.string.write_save_draft_dialog_normal_title), null, this.hwW.getString(R.string.save));
        this.ifZ.Nv();
    }

    protected void cqd() {
        if (this.ifV != null) {
            x.c(String.valueOf(this.ifV.forumId), (WriteData) null);
        }
    }

    public void onDestroy() {
        g.dismissDialog(this.ifZ, this.hwW);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        if (this.mCenterText != null) {
            ap.setViewTextColor(this.mCenterText, R.color.cp_cont_b);
        }
        if (this.ifW != null) {
            ap.setViewTextColor(this.ifW, R.color.cp_link_tip_c);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onBackBtnOnChangeSkin();
        }
    }
}
