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
/* loaded from: classes11.dex */
public abstract class a implements e {
    private LinearLayout aja;
    protected AlaLiveRecorder bCM;
    protected EditText hPq;
    private LinearLayout hPr;
    private CheckBox hPs;
    private CheckBox hPt;
    private TextView hPu;
    protected Button hPv;
    protected d hPw;
    public boolean hPx;
    protected e.b hPz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hPy = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hPq) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hPq);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hPq);
                }
            }
        }
    };

    protected abstract int bUm();

    protected abstract com.baidu.tieba.ala.category.b.a cnM();

    protected abstract int cnP();

    protected abstract boolean cnQ();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hPw = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cnF() {
        this.hPq = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hPq.setOnFocusChangeListener(this.focusChangeListener);
        this.hPr = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hPw.aO(this.hPr);
        this.hPs = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hPt = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hPu = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.aja = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hPv = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        Hi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bCM = alaLiveRecorder;
    }

    protected void cnG() {
        this.bCM.setVideoConfig(LiveRecorderConfigHelper.Sb().d(cnP(), bUm(), cnQ()));
    }

    protected boolean cnH() {
        return false;
    }

    protected boolean cnI() {
        return false;
    }

    public String cnJ() {
        return com.baidu.live.d.Ba().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cnK() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(cnJ())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean cnI = cnI();
            boolean cnH = cnH();
            if (cnI || cnH) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!ao.ET()) {
                return cnL();
            } else if (cnM() == null || cnM().bWA() == null || cnM().bWB() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hPz != null) {
                this.hPz.d(cnM());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean cnL() {
        if (this.hPz != null) {
            this.hPx = true;
            cnG();
            this.hPz.clj();
            if (TextUtils.isEmpty(this.hPq.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void oc(boolean z) {
        if (z) {
            cnL();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void Hi() {
        this.hPs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cnO();
                if (z) {
                    a.this.hPs.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hPs.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hPt != null) {
            this.hPt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.cnO();
                    if (z) {
                        a.this.hPt.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hPt.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hPu != null) {
            this.hPu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hPz.clm();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cnN() {
        if (this.hPy) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void cnO() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hPq.getText().toString();
    }

    public boolean chq() {
        return this.hPw.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hPz = bVar;
    }

    public void ob(boolean z) {
        this.hPs.setVisibility(8);
        this.hPs.setChecked(false);
    }

    public boolean chn() {
        return this.hPs.isChecked();
    }

    public boolean cho() {
        return this.hPt.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hPy != z) {
            this.hPy = z;
        }
    }

    public void destroy() {
        if (this.hPw != null) {
            this.hPw.destroy();
        }
    }
}
