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
    private static final int flu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout Lu;
    private TextView flA;
    protected Button flB;
    protected d flC;
    public boolean flD;
    protected e.b flF;
    protected AlaLiveRecorder flv;
    protected EditText flw;
    private LinearLayout flx;
    private CheckBox fly;
    private CheckBox flz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean flE = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.flw) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.flw);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.flw);
                }
            }
        }
    };

    protected abstract int blK();

    protected abstract int bqN();

    protected abstract boolean bqO();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.flC = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqF() {
        this.flw = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.flw.setOnFocusChangeListener(this.focusChangeListener);
        this.flx = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.flC.an(this.flx);
        this.fly = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.flz = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.flA = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.Lu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.flB = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        sf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.flv = alaLiveRecorder;
    }

    protected void bqG() {
        this.flv.setVideoConfig(LiveRecorderConfigHelper.ze().d(bqN(), blK(), bqO()));
    }

    protected boolean bqH() {
        return false;
    }

    protected boolean bqI() {
        return false;
    }

    public String bqJ() {
        return com.baidu.live.c.pr().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqK() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.flw.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bqJ())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bqI = bqI();
        boolean bqH = bqH();
        if (bqI || bqH) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.flF != null) {
            this.flD = true;
            bqG();
            this.flF.boB();
            if (!TextUtils.isEmpty(this.flw.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void sf() {
        this.fly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bqM();
                if (z) {
                    a.this.fly.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.fly.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.flz != null) {
            this.flz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bqM();
                    if (z) {
                        a.this.flz.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.flz.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.flA != null) {
            this.flA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.flF.boE();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqL() {
        if (this.flE) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bqM() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.flw.getText().toString();
    }

    public boolean blD() {
        return this.flC.isShowLocation();
    }

    public void a(e.b bVar) {
        this.flF = bVar;
    }

    public void jn(boolean z) {
        this.fly.setVisibility(8);
        this.fly.setChecked(false);
    }

    public boolean blA() {
        return this.fly.isChecked();
    }

    public boolean blB() {
        return this.flz.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.flE != z) {
            this.flE = z;
        }
    }

    public void destroy() {
        if (this.flC != null) {
            this.flC.destroy();
        }
    }
}
