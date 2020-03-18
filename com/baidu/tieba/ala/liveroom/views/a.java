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
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes3.dex */
public abstract class a implements e {
    private static final int fmh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout Lu;
    protected AlaLiveRecorder fmi;
    protected EditText fmj;
    private LinearLayout fmk;
    private CheckBox fml;
    private CheckBox fmm;
    private TextView fmn;
    protected Button fmo;
    protected d fmp;
    public boolean fmq;
    protected e.b fms;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean fmr = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.fmj) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fmj);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fmj);
                }
            }
        }
    };

    protected abstract int blS();

    protected abstract int bqV();

    protected abstract boolean bqW();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fmp = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqN() {
        this.fmj = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.fmj.setOnFocusChangeListener(this.focusChangeListener);
        this.fmk = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.fmp.ao(this.fmk);
        this.fml = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.fmm = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.fmn = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.Lu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.fmo = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        sk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.fmi = alaLiveRecorder;
    }

    protected void bqO() {
        this.fmi.setVideoConfig(LiveRecorderConfigHelper.zn().d(bqV(), blS(), bqW()));
    }

    protected boolean bqP() {
        return false;
    }

    protected boolean bqQ() {
        return false;
    }

    public String bqR() {
        return com.baidu.live.c.pw().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqS() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.fmj.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bqR())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bqQ = bqQ();
        boolean bqP = bqP();
        if (bqQ || bqP) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.fms != null) {
            this.fmq = true;
            bqO();
            this.fms.boJ();
            if (!TextUtils.isEmpty(this.fmj.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void sk() {
        this.fml.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bqU();
                if (z) {
                    a.this.fml.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.fml.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.fmm != null) {
            this.fmm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bqU();
                    if (z) {
                        a.this.fmm.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.fmm.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.fmn != null) {
            this.fmn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fms.boM();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqT() {
        if (this.fmr) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bqU() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.fmj.getText().toString();
    }

    public boolean blL() {
        return this.fmp.isShowLocation();
    }

    public void a(e.b bVar) {
        this.fms = bVar;
    }

    public void jp(boolean z) {
        this.fml.setVisibility(8);
        this.fml.setChecked(false);
    }

    public boolean blI() {
        return this.fml.isChecked();
    }

    public boolean blJ() {
        return this.fmm.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fmr != z) {
            this.fmr = z;
        }
    }

    public void destroy() {
        if (this.fmp != null) {
            this.fmp.destroy();
        }
    }
}
