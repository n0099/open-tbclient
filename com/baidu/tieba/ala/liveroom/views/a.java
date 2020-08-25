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
    private LinearLayout agz;
    protected AlaLiveRecorder bqF;
    protected EditText gJZ;
    private LinearLayout gKa;
    private CheckBox gKb;
    private CheckBox gKc;
    private TextView gKd;
    protected Button gKe;
    protected d gKf;
    public boolean gKg;
    protected e.b gKi;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gKh = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gJZ) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gJZ);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gJZ);
                }
            }
        }
    };

    protected abstract int bRa();

    protected abstract com.baidu.tieba.ala.category.b.a bWR();

    protected abstract int bWU();

    protected abstract boolean bWV();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gKf = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWK() {
        this.gJZ = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gJZ.setOnFocusChangeListener(this.focusChangeListener);
        this.gKa = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gKf.aC(this.gKa);
        this.gKb = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gKc = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gKd = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.agz = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gKe = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        Ey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.bqF = alaLiveRecorder;
    }

    protected void bWL() {
        this.bqF.setVideoConfig(LiveRecorderConfigHelper.MC().d(bWU(), bRa(), bWV()));
    }

    protected boolean bWM() {
        return false;
    }

    protected boolean bWN() {
        return false;
    }

    public String bWO() {
        return com.baidu.live.c.AD().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bWP() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(bWO())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        } else {
            boolean bWN = bWN();
            boolean bWM = bWM();
            if (bWN || bWM) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.i.ala_create_to_retry);
                return false;
            } else if (!ac.CJ()) {
                return bWQ();
            } else if (bWR() == null || bWR().bHV() == null || bWR().bHW() == null) {
                this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.gKi != null) {
                this.gKi.d(bWR());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean bWQ() {
        if (this.gKi != null) {
            this.gKg = true;
            bWL();
            this.gKi.bUv();
            if (TextUtils.isEmpty(this.gJZ.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void ma(boolean z) {
        if (z) {
            bWQ();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void Ey() {
        this.gKb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bWT();
                if (z) {
                    a.this.gKb.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gKb.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gKc != null) {
            this.gKc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bWT();
                    if (z) {
                        a.this.gKc.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gKc.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gKd != null) {
            this.gKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gKi.bUy();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWS() {
        if (this.gKh) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bWT() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gJZ.getText().toString();
    }

    public boolean bQT() {
        return this.gKf.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gKi = bVar;
    }

    public void lZ(boolean z) {
        this.gKb.setVisibility(8);
        this.gKb.setChecked(false);
    }

    public boolean bQQ() {
        return this.gKb.isChecked();
    }

    public boolean bQR() {
        return this.gKc.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gKh != z) {
            this.gKh = z;
        }
    }

    public void destroy() {
        if (this.gKf != null) {
            this.gKf.destroy();
        }
    }
}
