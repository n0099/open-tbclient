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
import com.baidu.live.data.ac;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes7.dex */
public abstract class a implements e {
    private LinearLayout agB;
    protected AlaLiveRecorder bqI;
    protected EditText gKd;
    private LinearLayout gKe;
    private CheckBox gKf;
    private CheckBox gKg;
    private TextView gKh;
    protected Button gKi;
    protected d gKj;
    public boolean gKk;
    protected e.b gKm;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gKl = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gKd) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gKd);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gKd);
                }
            }
        }
    };

    protected abstract int bRb();

    protected abstract com.baidu.tieba.ala.category.b.a bWS();

    protected abstract int bWV();

    protected abstract boolean bWW();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gKj = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWL() {
        this.gKd = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gKd.setOnFocusChangeListener(this.focusChangeListener);
        this.gKe = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gKj.aC(this.gKe);
        this.gKf = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gKg = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gKh = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.agB = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gKi = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        Ey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.bqI = alaLiveRecorder;
    }

    protected void bWM() {
        this.bqI.setVideoConfig(LiveRecorderConfigHelper.MC().d(bWV(), bRb(), bWW()));
    }

    protected boolean bWN() {
        return false;
    }

    protected boolean bWO() {
        return false;
    }

    public String bWP() {
        return com.baidu.live.c.AD().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bWQ() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(bWP())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        } else {
            boolean bWO = bWO();
            boolean bWN = bWN();
            if (bWO || bWN) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.i.ala_create_to_retry);
                return false;
            } else if (!ac.CJ()) {
                return bWR();
            } else if (bWS() == null || bWS().bHW() == null || bWS().bHX() == null) {
                this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.gKm != null) {
                this.gKm.d(bWS());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean bWR() {
        if (this.gKm != null) {
            this.gKk = true;
            bWM();
            this.gKm.bUw();
            if (TextUtils.isEmpty(this.gKd.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void mc(boolean z) {
        if (z) {
            bWR();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void Ey() {
        this.gKf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bWU();
                if (z) {
                    a.this.gKf.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gKf.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gKg != null) {
            this.gKg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bWU();
                    if (z) {
                        a.this.gKg.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gKg.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gKh != null) {
            this.gKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gKm.bUz();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWT() {
        if (this.gKl) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bWU() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gKd.getText().toString();
    }

    public boolean bQU() {
        return this.gKj.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gKm = bVar;
    }

    public void mb(boolean z) {
        this.gKf.setVisibility(8);
        this.gKf.setChecked(false);
    }

    public boolean bQR() {
        return this.gKf.isChecked();
    }

    public boolean bQS() {
        return this.gKg.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gKl != z) {
            this.gKl = z;
        }
    }

    public void destroy() {
        if (this.gKj != null) {
            this.gKj.destroy();
        }
    }
}
