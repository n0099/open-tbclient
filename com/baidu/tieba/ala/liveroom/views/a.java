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
import com.baidu.live.data.al;
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
    private LinearLayout aho;
    protected AlaLiveRecorder bsP;
    protected EditText htL;
    private LinearLayout htM;
    private CheckBox htN;
    private CheckBox htO;
    private TextView htP;
    protected Button htQ;
    protected d htR;
    public boolean htS;
    protected e.b htU;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean htT = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.htL) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.htL);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.htL);
                }
            }
        }
    };

    protected abstract int caK();

    protected abstract com.baidu.tieba.ala.category.b.a cgZ();

    protected abstract int chc();

    protected abstract boolean chd();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.htR = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgS() {
        this.htL = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.htL.setOnFocusChangeListener(this.focusChangeListener);
        this.htM = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.htR.aC(this.htM);
        this.htN = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.htO = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.htP = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.aho = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.htQ = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        FS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bsP = alaLiveRecorder;
    }

    protected void cgT() {
        this.bsP.setVideoConfig(LiveRecorderConfigHelper.OE().d(chc(), caK(), chd()));
    }

    protected boolean cgU() {
        return false;
    }

    protected boolean cgV() {
        return false;
    }

    public String cgW() {
        return com.baidu.live.d.Aq().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cgX() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(cgW())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean cgV = cgV();
            boolean cgU = cgU();
            if (cgV || cgU) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!al.DS()) {
                return cgY();
            } else if (cgZ() == null || cgZ().bQj() == null || cgZ().bQk() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.htU != null) {
                this.htU.d(cgZ());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean cgY() {
        if (this.htU != null) {
            this.htS = true;
            cgT();
            this.htU.cez();
            if (TextUtils.isEmpty(this.htL.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void nh(boolean z) {
        if (z) {
            cgY();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void FS() {
        this.htN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.chb();
                if (z) {
                    a.this.htN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.htN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.htO != null) {
            this.htO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.chb();
                    if (z) {
                        a.this.htO.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.htO.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.htP != null) {
            this.htP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.htU.ceC();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cha() {
        if (this.htT) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void chb() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.htL.getText().toString();
    }

    public boolean caD() {
        return this.htR.isShowLocation();
    }

    public void a(e.b bVar) {
        this.htU = bVar;
    }

    public void ng(boolean z) {
        this.htN.setVisibility(8);
        this.htN.setChecked(false);
    }

    public boolean caA() {
        return this.htN.isChecked();
    }

    public boolean caB() {
        return this.htO.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.htT != z) {
            this.htT = z;
        }
    }

    public void destroy() {
        if (this.htR != null) {
            this.htR.destroy();
        }
    }
}
