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
    private static final int flI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
    private LinearLayout Lu;
    protected AlaLiveRecorder flJ;
    protected EditText flK;
    private LinearLayout flL;
    private CheckBox flM;
    private CheckBox flN;
    private TextView flO;
    protected Button flP;
    protected d flQ;
    public boolean flR;
    protected e.b flT;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean flS = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.flK) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.flK);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.flK);
                }
            }
        }
    };

    protected abstract int blN();

    protected abstract int bqQ();

    protected abstract boolean bqR();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.flQ = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqI() {
        this.flK = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.flK.setOnFocusChangeListener(this.focusChangeListener);
        this.flL = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.flQ.an(this.flL);
        this.flM = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.flN = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.flO = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.Lu = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.flP = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        sf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.flJ = alaLiveRecorder;
    }

    protected void bqJ() {
        this.flJ.setVideoConfig(LiveRecorderConfigHelper.zg().d(bqQ(), blN(), bqR()));
    }

    protected boolean bqK() {
        return false;
    }

    protected boolean bqL() {
        return false;
    }

    public String bqM() {
        return com.baidu.live.c.pr().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bqN() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.flK.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bqM())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bqL = bqL();
        boolean bqK = bqK();
        if (bqL || bqK) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.flT != null) {
            this.flR = true;
            bqJ();
            this.flT.boE();
            if (!TextUtils.isEmpty(this.flK.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void sf() {
        this.flM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bqP();
                if (z) {
                    a.this.flM.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.flM.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.flN != null) {
            this.flN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bqP();
                    if (z) {
                        a.this.flN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.flN.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.flO != null) {
            this.flO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.flT.boH();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqO() {
        if (this.flS) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bqP() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.flK.getText().toString();
    }

    public boolean blG() {
        return this.flQ.isShowLocation();
    }

    public void a(e.b bVar) {
        this.flT = bVar;
    }

    public void jn(boolean z) {
        this.flM.setVisibility(8);
        this.flM.setChecked(false);
    }

    public boolean blD() {
        return this.flM.isChecked();
    }

    public boolean blE() {
        return this.flN.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.flS != z) {
            this.flS = z;
        }
    }

    public void destroy() {
        if (this.flQ != null) {
            this.flQ.destroy();
        }
    }
}
