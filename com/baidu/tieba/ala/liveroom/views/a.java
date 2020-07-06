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
/* loaded from: classes3.dex */
public abstract class a implements e {
    private LinearLayout afy;
    protected AlaLiveRecorder bkF;
    protected EditText gsD;
    private LinearLayout gsE;
    private CheckBox gsF;
    private CheckBox gsG;
    private TextView gsH;
    protected Button gsI;
    protected d gsJ;
    public boolean gsK;
    protected e.b gsM;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gsL = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gsD) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gsD);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gsD);
                }
            }
        }
    };

    protected abstract int bEl();

    protected abstract com.baidu.tieba.ala.category.b.a bJO();

    protected abstract int bJR();

    protected abstract boolean bJS();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gsJ = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJH() {
        this.gsD = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gsD.setOnFocusChangeListener(this.focusChangeListener);
        this.gsE = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gsJ.aC(this.gsE);
        this.gsF = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gsG = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gsH = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.afy = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gsI = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        yt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.bkF = alaLiveRecorder;
    }

    protected void bJI() {
        this.bkF.setVideoConfig(LiveRecorderConfigHelper.GG().d(bJR(), bEl(), bJS()));
    }

    protected boolean bJJ() {
        return false;
    }

    protected boolean bJK() {
        return false;
    }

    public String bJL() {
        return com.baidu.live.c.vf().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bJM() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.gsD.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bJL())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bJK = bJK();
        boolean bJJ = bJJ();
        if (bJK || bJJ) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (!aa.wE()) {
            return bJN();
        } else if (bJO() == null || bJO().bvJ() == null || bJO().bvK() == null) {
            this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
            return false;
        } else if (this.gsM != null) {
            this.gsM.d(bJO());
            return false;
        } else {
            return false;
        }
    }

    private boolean bJN() {
        if (this.gsM != null) {
            this.gsK = true;
            bJI();
            this.gsM.bHm();
            if (TextUtils.isEmpty(this.gsD.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void kW(boolean z) {
        if (z) {
            bJN();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void yt() {
        this.gsF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bJQ();
                if (z) {
                    a.this.gsF.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gsF.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gsG != null) {
            this.gsG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bJQ();
                    if (z) {
                        a.this.gsG.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gsG.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gsH != null) {
            this.gsH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gsM.bHp();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bJP() {
        if (this.gsL) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bJQ() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gsD.getText().toString();
    }

    public boolean bEe() {
        return this.gsJ.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gsM = bVar;
    }

    public void kV(boolean z) {
        this.gsF.setVisibility(8);
        this.gsF.setChecked(false);
    }

    public boolean bEb() {
        return this.gsF.isChecked();
    }

    public boolean bEc() {
        return this.gsG.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gsL != z) {
            this.gsL = z;
        }
    }

    public void destroy() {
        if (this.gsJ != null) {
            this.gsJ.destroy();
        }
    }
}
