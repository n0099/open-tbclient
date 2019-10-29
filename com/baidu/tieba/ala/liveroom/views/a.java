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
import com.baidu.ala.liveRecorder.AlaLiveRecorder;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.config.AlaLiveRecordConfigHelper;
import com.baidu.tieba.ala.liveroom.views.f;
/* loaded from: classes6.dex */
public abstract class a implements f {
    private static final int epD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout Gu;
    protected AlaLiveRecorder epE;
    protected EditText epF;
    private LinearLayout epG;
    private CheckBox epH;
    private CheckBox epI;
    private TextView epJ;
    protected Button epK;
    protected e epL;
    public boolean epM;
    protected f.b epO;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean epN = false;
    private View.OnFocusChangeListener epP = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.epF) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.epF);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.epF);
                }
            }
        }
    };

    protected abstract int aRL();

    protected abstract int aWu();

    protected abstract boolean aWv();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.epL = new e(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWm() {
        this.epF = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.epF.setOnFocusChangeListener(this.epP);
        this.epG = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.epL.ak(this.epG);
        this.epH = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.epI = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.epJ = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.Gu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.epK = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        pv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.epE = alaLiveRecorder;
    }

    protected void aWn() {
        this.epE.setVideoConfig(AlaLiveRecordConfigHelper.aRw().i(aWu(), aRL(), aWv()));
    }

    protected boolean aWo() {
        return false;
    }

    protected boolean aWp() {
        return false;
    }

    public String aWq() {
        return com.baidu.live.c.np().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aWr() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.epF.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(aWq())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean aWp = aWp();
        boolean aWo = aWo();
        if (aWp || aWo) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.epO != null) {
            this.epM = true;
            aWn();
            this.epO.aUe();
            if (!TextUtils.isEmpty(this.epF.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void pv() {
        this.epH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.aWt();
                if (z) {
                    a.this.epH.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.epH.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.epI != null) {
            this.epI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.aWt();
                    if (z) {
                        a.this.epI.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.epI.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.epJ != null) {
            this.epJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.epO.aUh();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWs() {
        if (this.epN) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void aWt() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.epF.getText().toString();
    }

    public boolean aRE() {
        return this.epL.isShowLocation();
    }

    public void a(f.b bVar) {
        this.epO = bVar;
    }

    public void hM(boolean z) {
        this.epH.setVisibility(8);
        this.epH.setChecked(false);
    }

    public boolean aRB() {
        return this.epH.isChecked();
    }

    public boolean aRC() {
        return this.epI.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.epN != z) {
            this.epN = z;
        }
    }

    public void destroy() {
        if (this.epL != null) {
            this.epL.destroy();
        }
    }
}
