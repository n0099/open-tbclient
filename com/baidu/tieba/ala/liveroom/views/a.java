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
    private static final int flv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout Lu;
    private CheckBox flA;
    private TextView flB;
    protected Button flC;
    protected d flD;
    public boolean flE;
    protected e.b flG;
    protected AlaLiveRecorder flw;
    protected EditText flx;
    private LinearLayout fly;
    private CheckBox flz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean flF = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.flx) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.flx);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.flx);
                }
            }
        }
    };

    protected abstract int blM();

    protected abstract int bqP();

    protected abstract boolean bqQ();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.flD = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqH() {
        this.flx = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.flx.setOnFocusChangeListener(this.focusChangeListener);
        this.fly = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.flD.an(this.fly);
        this.flz = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.flA = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.flB = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.Lu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.flC = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        sf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.flw = alaLiveRecorder;
    }

    protected void bqI() {
        this.flw.setVideoConfig(LiveRecorderConfigHelper.zg().d(bqP(), blM(), bqQ()));
    }

    protected boolean bqJ() {
        return false;
    }

    protected boolean bqK() {
        return false;
    }

    public String bqL() {
        return com.baidu.live.c.pr().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqM() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.flx.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bqL())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bqK = bqK();
        boolean bqJ = bqJ();
        if (bqK || bqJ) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.flG != null) {
            this.flE = true;
            bqI();
            this.flG.boD();
            if (!TextUtils.isEmpty(this.flx.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void sf() {
        this.flz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bqO();
                if (z) {
                    a.this.flz.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.flz.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.flA != null) {
            this.flA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bqO();
                    if (z) {
                        a.this.flA.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.flA.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.flB != null) {
            this.flB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.flG.boG();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqN() {
        if (this.flF) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bqO() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.flx.getText().toString();
    }

    public boolean blF() {
        return this.flD.isShowLocation();
    }

    public void a(e.b bVar) {
        this.flG = bVar;
    }

    public void jn(boolean z) {
        this.flz.setVisibility(8);
        this.flz.setChecked(false);
    }

    public boolean blC() {
        return this.flz.isChecked();
    }

    public boolean blD() {
        return this.flA.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.flF != z) {
            this.flF = z;
        }
    }

    public void destroy() {
        if (this.flD != null) {
            this.flD.destroy();
        }
    }
}
