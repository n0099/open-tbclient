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
import com.baidu.live.data.aa;
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
    private LinearLayout afp;
    protected AlaLiveRecorder bkZ;
    protected EditText gya;
    private LinearLayout gyb;
    private CheckBox gyc;
    private CheckBox gyd;
    private TextView gye;
    protected Button gyf;
    protected d gyg;
    public boolean gyh;
    protected e.b gyj;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gyi = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gya) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gya);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gya);
                }
            }
        }
    };

    protected abstract int bHw();

    protected abstract com.baidu.tieba.ala.category.b.a bMU();

    protected abstract int bMX();

    protected abstract boolean bMY();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gyg = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMN() {
        this.gya = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gya.setOnFocusChangeListener(this.focusChangeListener);
        this.gyb = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gyg.aD(this.gyb);
        this.gyc = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gyd = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gye = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.afp = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gyf = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        yV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.bkZ = alaLiveRecorder;
    }

    protected void bMO() {
        this.bkZ.setVideoConfig(LiveRecorderConfigHelper.GN().d(bMX(), bHw(), bMY()));
    }

    protected boolean bMP() {
        return false;
    }

    protected boolean bMQ() {
        return false;
    }

    public String bMR() {
        return com.baidu.live.c.vf().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bMS() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.gya.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bMR())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bMQ = bMQ();
        boolean bMP = bMP();
        if (bMQ || bMP) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (!aa.xg()) {
            return bMT();
        } else if (bMU() == null || bMU().byS() == null || bMU().byT() == null) {
            this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
            return false;
        } else if (this.gyj != null) {
            this.gyj.d(bMU());
            return false;
        } else {
            return false;
        }
    }

    private boolean bMT() {
        if (this.gyj != null) {
            this.gyh = true;
            bMO();
            this.gyj.bKs();
            if (TextUtils.isEmpty(this.gya.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void lz(boolean z) {
        if (z) {
            bMT();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void yV() {
        this.gyc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bMW();
                if (z) {
                    a.this.gyc.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gyc.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gyd != null) {
            this.gyd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bMW();
                    if (z) {
                        a.this.gyd.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gyd.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gye != null) {
            this.gye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gyj.bKv();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMV() {
        if (this.gyi) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bMW() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gya.getText().toString();
    }

    public boolean bHp() {
        return this.gyg.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gyj = bVar;
    }

    public void ly(boolean z) {
        this.gyc.setVisibility(8);
        this.gyc.setChecked(false);
    }

    public boolean bHm() {
        return this.gyc.isChecked();
    }

    public boolean bHn() {
        return this.gyd.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gyi != z) {
            this.gyi = z;
        }
    }

    public void destroy() {
        if (this.gyg != null) {
            this.gyg.destroy();
        }
    }
}
