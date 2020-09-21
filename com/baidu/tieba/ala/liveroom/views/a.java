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
import com.baidu.live.data.ah;
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
    private LinearLayout agU;
    protected AlaLiveRecorder btW;
    public boolean gNA;
    protected e.b gNC;
    protected EditText gNt;
    private LinearLayout gNu;
    private CheckBox gNv;
    private CheckBox gNw;
    private TextView gNx;
    protected Button gNy;
    protected d gNz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gNB = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gNt) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gNt);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gNt);
                }
            }
        }
    };

    protected abstract int bSx();

    protected abstract int bYC();

    protected abstract boolean bYD();

    protected abstract com.baidu.tieba.ala.category.b.a bYz();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gNz = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYs() {
        this.gNt = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gNt.setOnFocusChangeListener(this.focusChangeListener);
        this.gNu = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gNz.aD(this.gNu);
        this.gNv = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gNw = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gNx = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.agU = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gNy = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        EP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.btW = alaLiveRecorder;
    }

    protected void bYt() {
        this.btW.setVideoConfig(LiveRecorderConfigHelper.Nk().d(bYC(), bSx(), bYD()));
    }

    protected boolean bYu() {
        return false;
    }

    protected boolean bYv() {
        return false;
    }

    public String bYw() {
        return com.baidu.live.c.AR().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bYx() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.ala_live_please_input_title);
            return false;
        } else if (TextUtils.isEmpty(bYw())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        } else {
            boolean bYv = bYv();
            boolean bYu = bYu();
            if (bYv || bYu) {
                return false;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.i.ala_create_to_retry);
                return false;
            } else if (!ah.CZ()) {
                return bYy();
            } else if (bYz() == null || bYz().bJe() == null || bYz().bJf() == null) {
                this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
                return false;
            } else if (this.gNC != null) {
                this.gNC.d(bYz());
                return false;
            } else {
                return false;
            }
        }
    }

    private boolean bYy() {
        if (this.gNC != null) {
            this.gNA = true;
            bYt();
            this.gNC.bWg();
            if (TextUtils.isEmpty(this.gNt.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void mf(boolean z) {
        if (z) {
            bYy();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void EP() {
        this.gNv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bYB();
                if (z) {
                    a.this.gNv.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gNv.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gNw != null) {
            this.gNw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bYB();
                    if (z) {
                        a.this.gNw.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gNw.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gNx != null) {
            this.gNx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gNC.bWj();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYA() {
        if (this.gNB) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bYB() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gNt.getText().toString();
    }

    public boolean bSq() {
        return this.gNz.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gNC = bVar;
    }

    public void me(boolean z) {
        this.gNv.setVisibility(8);
        this.gNv.setChecked(false);
    }

    public boolean bSn() {
        return this.gNv.isChecked();
    }

    public boolean bSo() {
        return this.gNw.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gNB != z) {
            this.gNB = z;
        }
    }

    public void destroy() {
        if (this.gNz != null) {
            this.gNz.destroy();
        }
    }
}
