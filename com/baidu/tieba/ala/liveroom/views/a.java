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
    private static final int eoM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout FU;
    protected AlaLiveRecorder eoN;
    protected EditText eoO;
    private LinearLayout eoP;
    private CheckBox eoQ;
    private CheckBox eoR;
    private TextView eoS;
    protected Button eoT;
    protected e eoU;
    public boolean eoV;
    protected f.b eoX;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean eoW = false;
    private View.OnFocusChangeListener eoY = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.eoO) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.eoO);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.eoO);
                }
            }
        }
    };

    protected abstract int aRJ();

    protected abstract int aWs();

    protected abstract boolean aWt();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.eoU = new e(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWk() {
        this.eoO = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.eoO.setOnFocusChangeListener(this.eoY);
        this.eoP = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.eoU.ak(this.eoP);
        this.eoQ = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.eoR = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.eoS = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.FU = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.eoT = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        pv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.eoN = alaLiveRecorder;
    }

    protected void aWl() {
        this.eoN.setVideoConfig(AlaLiveRecordConfigHelper.aRu().i(aWs(), aRJ(), aWt()));
    }

    protected boolean aWm() {
        return false;
    }

    protected boolean aWn() {
        return false;
    }

    public String aWo() {
        return com.baidu.live.c.np().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aWp() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.eoO.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(aWo())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean aWn = aWn();
        boolean aWm = aWm();
        if (aWn || aWm) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.eoX != null) {
            this.eoV = true;
            aWl();
            this.eoX.aUc();
            if (!TextUtils.isEmpty(this.eoO.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void pv() {
        this.eoQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.aWr();
                if (z) {
                    a.this.eoQ.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.eoQ.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.eoR != null) {
            this.eoR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.aWr();
                    if (z) {
                        a.this.eoR.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.eoR.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.eoS != null) {
            this.eoS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.eoX.aUf();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aWq() {
        if (this.eoW) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void aWr() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.eoO.getText().toString();
    }

    public boolean aRC() {
        return this.eoU.isShowLocation();
    }

    public void a(f.b bVar) {
        this.eoX = bVar;
    }

    public void hM(boolean z) {
        this.eoQ.setVisibility(8);
        this.eoQ.setChecked(false);
    }

    public boolean aRz() {
        return this.eoQ.isChecked();
    }

    public boolean aRA() {
        return this.eoR.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.eoW != z) {
            this.eoW = z;
        }
    }

    public void destroy() {
        if (this.eoU != null) {
            this.eoU.destroy();
        }
    }
}
