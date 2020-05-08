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
    protected AlaLiveRecorder aYb;
    private LinearLayout aet;
    protected EditText fQK;
    private LinearLayout fQL;
    private CheckBox fQM;
    private CheckBox fQN;
    private TextView fQO;
    protected Button fQP;
    protected d fQQ;
    public boolean fQR;
    protected e.b fQT;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean fQS = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.fQK) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fQK);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fQK);
                }
            }
        }
    };

    protected abstract int bAs();

    protected abstract boolean bAt();

    protected abstract int bvh();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fQQ = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAk() {
        this.fQK = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.fQK.setOnFocusChangeListener(this.focusChangeListener);
        this.fQL = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.fQQ.ap(this.fQL);
        this.fQM = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.fQN = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.fQO = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.aet = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.fQP = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        wC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.aYb = alaLiveRecorder;
    }

    protected void bAl() {
        this.aYb.setVideoConfig(LiveRecorderConfigHelper.Eh().d(bAs(), bvh(), bAt()));
    }

    protected boolean bAm() {
        return false;
    }

    protected boolean bAn() {
        return false;
    }

    public String bAo() {
        return com.baidu.live.c.tG().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bAp() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.fQK.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bAo())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bAn = bAn();
        boolean bAm = bAm();
        if (bAn || bAm) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.fQT != null) {
            this.fQR = true;
            bAl();
            this.fQT.bxZ();
            if (!TextUtils.isEmpty(this.fQK.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void wC() {
        this.fQM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bAr();
                if (z) {
                    a.this.fQM.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.fQM.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.fQN != null) {
            this.fQN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bAr();
                    if (z) {
                        a.this.fQN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.fQN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.fQO != null) {
            this.fQO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fQT.byc();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAq() {
        if (this.fQS) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bAr() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.fQK.getText().toString();
    }

    public boolean bva() {
        return this.fQQ.isShowLocation();
    }

    public void a(e.b bVar) {
        this.fQT = bVar;
    }

    public void kq(boolean z) {
        this.fQM.setVisibility(8);
        this.fQM.setChecked(false);
    }

    public boolean buX() {
        return this.fQM.isChecked();
    }

    public boolean buY() {
        return this.fQN.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fQS != z) {
            this.fQS = z;
        }
    }

    public void destroy() {
        if (this.fQQ != null) {
            this.fQQ.destroy();
        }
    }
}
