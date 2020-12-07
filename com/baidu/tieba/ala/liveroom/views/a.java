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
    protected EditText hDo;
    private LinearLayout hDp;
    private CheckBox hDq;
    private CheckBox hDr;
    private TextView hDs;
    protected Button hDt;
    protected d hDu;
    public boolean hDv;
    protected e.b hDx;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hDw = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hDo) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hDo);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hDo);
                }
            }
        }
    };

    protected abstract int ceF();

    protected abstract com.baidu.tieba.ala.category.b.a ckT();

    protected abstract int ckW();

    protected abstract boolean ckX();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hDu = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckM() {
        this.hDo = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hDo.setOnFocusChangeListener(this.focusChangeListener);
        this.hDp = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hDu.aC(this.hDp);
        this.hDq = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hDr = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hDs = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.aio = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hDt = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        HH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bya = alaLiveRecorder;
    }

    protected void ckN() {
        this.bya.setVideoConfig(LiveRecorderConfigHelper.QY().d(ckW(), ceF(), ckX()));
    }

    protected boolean ckO() {
        return false;
    }

    protected boolean ckP() {
        return false;
    }

    public String ckQ() {
        return com.baidu.live.d.BM().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ckR() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(ckQ())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean ckP = ckP();
            boolean ckO = ckO();
            if (ckP || ckO) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!am.FD()) {
                return ckS();
            } else if (ckT() == null || ckT().bTT() == null || ckT().bTU() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hDx != null) {
                this.hDx.d(ckT());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean ckS() {
        if (this.hDx != null) {
            this.hDv = true;
            ckN();
            this.hDx.ciu();
            if (TextUtils.isEmpty(this.hDo.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void nC(boolean z) {
        if (z) {
            ckS();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void HH() {
        this.hDq.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.ckV();
                if (z) {
                    a.this.hDq.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hDq.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hDr != null) {
            this.hDr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.ckV();
                    if (z) {
                        a.this.hDr.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hDr.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hDs != null) {
            this.hDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hDx.cix();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckU() {
        if (this.hDw) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void ckV() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hDo.getText().toString();
    }

    public boolean cey() {
        return this.hDu.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hDx = bVar;
    }

    public void nB(boolean z) {
        this.hDq.setVisibility(8);
        this.hDq.setChecked(false);
    }

    public boolean cev() {
        return this.hDq.isChecked();
    }

    public boolean cew() {
        return this.hDr.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hDw != z) {
            this.hDw = z;
        }
    }

    public void destroy() {
        if (this.hDu != null) {
            this.hDu.destroy();
        }
    }
}
