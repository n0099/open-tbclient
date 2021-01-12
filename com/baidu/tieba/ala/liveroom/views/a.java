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
import com.baidu.live.data.ao;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes10.dex */
public abstract class a implements e {
    private LinearLayout aij;
    protected AlaLiveRecorder bya;
    protected EditText hKK;
    private LinearLayout hKL;
    private CheckBox hKM;
    private CheckBox hKN;
    private TextView hKO;
    protected Button hKP;
    protected d hKQ;
    public boolean hKR;
    protected e.b hKT;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hKS = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hKK) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hKK);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hKK);
                }
            }
        }
    };

    protected abstract int bQu();

    protected abstract com.baidu.tieba.ala.category.b.a cjU();

    protected abstract int cjX();

    protected abstract boolean cjY();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hKQ = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cjN() {
        this.hKK = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hKK.setOnFocusChangeListener(this.focusChangeListener);
        this.hKL = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hKQ.aO(this.hKL);
        this.hKM = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hKN = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hKO = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.aij = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hKP = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        Dn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bya = alaLiveRecorder;
    }

    protected void cjO() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.Og().d(cjX(), bQu(), cjY()));
    }

    protected boolean cjP() {
        return false;
    }

    protected boolean cjQ() {
        return false;
    }

    public String cjR() {
        return com.baidu.live.d.xf().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cjS() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(cjR())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean cjQ = cjQ();
            boolean cjP = cjP();
            if (cjQ || cjP) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!ao.AY()) {
                return cjT();
            } else if (cjU() == null || cjU().bSI() == null || cjU().bSJ() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hKT != null) {
                this.hKT.d(cjU());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean cjT() {
        if (this.hKT != null) {
            this.hKR = true;
            cjO();
            this.hKT.chr();
            if (TextUtils.isEmpty(this.hKK.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void nY(boolean z) {
        if (z) {
            cjT();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void Dn() {
        this.hKM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cjW();
                if (z) {
                    a.this.hKM.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hKM.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hKN != null) {
            this.hKN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.cjW();
                    if (z) {
                        a.this.hKN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hKN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hKO != null) {
            this.hKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hKT.chu();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cjV() {
        if (this.hKS) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void cjW() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hKK.getText().toString();
    }

    public boolean cdy() {
        return this.hKQ.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hKT = bVar;
    }

    public void nX(boolean z) {
        this.hKM.setVisibility(8);
        this.hKM.setChecked(false);
    }

    public boolean cdv() {
        return this.hKM.isChecked();
    }

    public boolean cdw() {
        return this.hKN.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hKS != z) {
            this.hKS = z;
        }
    }

    public void destroy() {
        if (this.hKQ != null) {
            this.hKQ.destroy();
        }
    }
}
