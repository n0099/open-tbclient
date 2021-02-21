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
import com.baidu.live.data.as;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.views.e;
/* loaded from: classes11.dex */
public abstract class a implements e {
    private LinearLayout ahW;
    protected AlaLiveRecorder bBG;
    protected e.b hPB;
    protected EditText hPs;
    private LinearLayout hPt;
    private CheckBox hPu;
    private CheckBox hPv;
    private TextView hPw;
    protected Button hPx;
    protected d hPy;
    public boolean hPz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean hPA = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.hPs) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hPs);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.hPs);
                }
            }
        }
    };

    protected abstract int bRf();

    protected abstract com.baidu.tieba.ala.category.b.a ckZ();

    protected abstract int clc();

    protected abstract boolean cld();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hPy = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckS() {
        this.hPs = (EditText) this.mRootView.findViewById(a.f.ala_liveroom_prepare_title);
        this.hPs.setOnFocusChangeListener(this.focusChangeListener);
        this.hPt = (LinearLayout) this.mRootView.findViewById(a.f.ala_live_prepare_locate_layout);
        this.hPy.aO(this.hPt);
        this.hPu = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_personal_check);
        this.hPv = (CheckBox) this.mRootView.findViewById(a.f.ala_live_prepare_licence);
        this.hPw = (TextView) this.mRootView.findViewById(a.f.ala_live_prepare_licence_detail);
        this.ahW = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_main_layout);
        this.hPx = (Button) this.mRootView.findViewById(a.f.ala_live_prepare_start);
        ED();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLiveRecorder alaLiveRecorder) {
        this.bBG = alaLiveRecorder;
    }

    protected void ckT() {
        this.bBG.setVideoConfig(com.baidu.live.z.a.b.PF().d(clc(), bRf(), cld()));
    }

    protected boolean ckU() {
        return false;
    }

    protected boolean ckV() {
        return false;
    }

    public String ckW() {
        return com.baidu.live.d.xc().getString(com.baidu.live.d.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ckX() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(ckW())) {
            this.mPageContext.showToast(a.h.hk_live_upload_cover);
            return false;
        } else {
            boolean ckV = ckV();
            boolean ckU = ckU();
            if (ckV || ckU) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.ala_create_to_retry);
                return false;
            } else if (!as.Cl()) {
                return ckY();
            } else if (ckZ() == null || ckZ().bTs() == null || ckZ().bTt() == null) {
                this.mPageContext.showToast(a.h.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.hPB != null) {
                this.hPB.d(ckZ());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean ckY() {
        if (this.hPB != null) {
            this.hPz = true;
            ckT();
            this.hPB.cir();
            if (TextUtils.isEmpty(this.hPs.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void oj(boolean z) {
        if (z) {
            ckY();
        } else {
            this.mPageContext.showToast(a.h.ala_live_prepare_add_category_fail);
        }
    }

    private void ED() {
        this.hPu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.clb();
                if (z) {
                    a.this.hPu.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.hPu.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.hPv != null) {
            this.hPv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.clb();
                    if (z) {
                        a.this.hPv.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.hPv.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.e.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.hPw != null) {
            this.hPw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hPB.ciu();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cla() {
        if (this.hPA) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void clb() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.hPs.getText().toString();
    }

    public boolean ceA() {
        return this.hPy.isShowLocation();
    }

    public void a(e.b bVar) {
        this.hPB = bVar;
    }

    public void oi(boolean z) {
        this.hPu.setVisibility(8);
        this.hPu.setChecked(false);
    }

    public boolean cex() {
        return this.hPu.isChecked();
    }

    public boolean cey() {
        return this.hPv.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hPA != z) {
            this.hPA = z;
        }
    }

    public void destroy() {
        if (this.hPy != null) {
            this.hPy.destroy();
        }
    }
}
