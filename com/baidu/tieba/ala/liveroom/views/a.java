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
import com.baidu.live.data.am;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes4.dex */
public abstract class a implements e {
    private LinearLayout aio;
    protected AlaLiveRecorder bya;
    protected EditText hDq;
    private LinearLayout hDr;
    private CheckBox hDs;
    private CheckBox hDt;
    private TextView hDu;
    protected Button hDv;
    protected d hDw;
    public boolean hDx;
    protected e.b hDz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hDy = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hDq) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hDq);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hDq);
                }
            }
        }
    };

    protected abstract int ceG();

    protected abstract com.baidu.tieba.ala.category.b.a ckU();

    protected abstract int ckX();

    protected abstract boolean ckY();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hDw = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckN() {
        this.hDq = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hDq.setOnFocusChangeListener(this.focusChangeListener);
        this.hDr = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hDw.aC(this.hDr);
        this.hDs = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hDt = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hDu = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.aio = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hDv = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        HH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bya = alaLiveRecorder;
    }

    protected void ckO() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.QY().d(ckX(), ceG(), ckY()));
    }

    protected boolean ckP() {
        return false;
    }

    protected boolean ckQ() {
        return false;
    }

    public String ckR() {
        return com.baidu.live.d.BM().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ckS() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(ckR())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean ckQ = ckQ();
            boolean ckP = ckP();
            if (ckQ || ckP) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!am.FD()) {
                return ckT();
            } else if (ckU() == null || ckU().bTU() == null || ckU().bTV() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hDz != null) {
                this.hDz.d(ckU());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean ckT() {
        if (this.hDz != null) {
            this.hDx = true;
            ckO();
            this.hDz.civ();
            if (TextUtils.isEmpty(this.hDq.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void nC(boolean z) {
        if (z) {
            ckT();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void HH() {
        this.hDs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.ckW();
                if (z) {
                    a.this.hDs.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hDs.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hDt != null) {
            this.hDt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.ckW();
                    if (z) {
                        a.this.hDt.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hDt.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hDu != null) {
            this.hDu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hDz.ciy();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckV() {
        if (this.hDy) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void ckW() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hDq.getText().toString();
    }

    public boolean cez() {
        return this.hDw.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hDz = bVar;
    }

    public void nB(boolean z) {
        this.hDs.setVisibility(8);
        this.hDs.setChecked(false);
    }

    public boolean cew() {
        return this.hDs.isChecked();
    }

    public boolean cex() {
        return this.hDt.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hDy != z) {
            this.hDy = z;
        }
    }

    public void destroy() {
        if (this.hDw != null) {
            this.hDw.destroy();
        }
    }
}
