package com.baidu.tieba.ala.liveroom.views;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.as;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes11.dex */
public abstract class a implements e {
    private LinearLayout ahW;
    protected AlaLiveRecorder bBG;
    protected EditText hPe;
    private LinearLayout hPf;
    private CheckBox hPg;
    private CheckBox hPh;
    private TextView hPi;
    protected Button hPj;
    protected d hPk;
    public boolean hPl;
    protected e.b hPn;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hPm = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hPe) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hPe);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hPe);
                }
            }
        }
    };

    protected abstract int bQY();

    protected abstract com.baidu.tieba.ala.category.b.a ckS();

    protected abstract int ckV();

    protected abstract boolean ckW();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hPk = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckL() {
        this.hPe = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hPe.setOnFocusChangeListener(this.focusChangeListener);
        this.hPf = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hPk.aO(this.hPf);
        this.hPg = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hPh = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hPi = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.ahW = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hPj = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        ED();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bBG = alaLiveRecorder;
    }

    protected void ckM() {
        this.bBG.setVideoConfig(com.baidu.live.z.a.b.PF().d(ckV(), bQY(), ckW()));
    }

    protected boolean ckN() {
        return false;
    }

    protected boolean ckO() {
        return false;
    }

    public String ckP() {
        return com.baidu.live.d.xc().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ckQ() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(ckP())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean ckO = ckO();
            boolean ckN = ckN();
            if (ckO || ckN) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!as.Cl()) {
                return ckR();
            } else if (ckS() == null || ckS().bTl() == null || ckS().bTm() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hPn != null) {
                this.hPn.d(ckS());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean ckR() {
        if (this.hPn != null) {
            this.hPl = true;
            ckM();
            this.hPn.cik();
            if (TextUtils.isEmpty(this.hPe.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void oj(boolean z) {
        if (z) {
            ckR();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void ED() {
        this.hPg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.ckU();
                if (z) {
                    a.this.hPg.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hPg.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hPh != null) {
            this.hPh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.ckU();
                    if (z) {
                        a.this.hPh.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hPh.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hPi != null) {
            this.hPi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hPn.cin();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckT() {
        if (this.hPm) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void ckU() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hPe.getText().toString();
    }

    public boolean cet() {
        return this.hPk.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hPn = bVar;
    }

    public void oi(boolean z) {
        this.hPg.setVisibility(8);
        this.hPg.setChecked(false);
    }

    public boolean ceq() {
        return this.hPg.isChecked();
    }

    public boolean cer() {
        return this.hPh.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hPm != z) {
            this.hPm = z;
        }
    }

    public void destroy() {
        if (this.hPk != null) {
            this.hPk.destroy();
        }
    }
}
