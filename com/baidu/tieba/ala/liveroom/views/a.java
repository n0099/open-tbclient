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
import com.baidu.live.data.z;
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
    private LinearLayout aeP;
    protected AlaLiveRecorder bfx;
    protected EditText gfG;
    private LinearLayout gfH;
    private CheckBox gfI;
    private CheckBox gfJ;
    private TextView gfK;
    protected Button gfL;
    protected d gfM;
    public boolean gfN;
    protected e.b gfP;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gfO = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gfG) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gfG);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gfG);
                }
            }
        }
    };

    protected abstract int bBi();

    protected abstract com.baidu.tieba.ala.category.b.a bGG();

    protected abstract int bGJ();

    protected abstract boolean bGK();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gfM = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGz() {
        this.gfG = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gfG.setOnFocusChangeListener(this.focusChangeListener);
        this.gfH = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gfM.ay(this.gfH);
        this.gfI = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gfJ = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gfK = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.aeP = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gfL = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        xT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.bfx = alaLiveRecorder;
    }

    protected void bGA() {
        this.bfx.setVideoConfig(LiveRecorderConfigHelper.FX().d(bGJ(), bBi(), bGK()));
    }

    protected boolean bGB() {
        return false;
    }

    protected boolean bGC() {
        return false;
    }

    public String bGD() {
        return com.baidu.live.c.uN().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bGE() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.gfG.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bGD())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bGC = bGC();
        boolean bGB = bGB();
        if (bGC || bGB) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (!z.wg()) {
            return bGF();
        } else if (bGG() == null || bGG().bsN() == null || bGG().bsO() == null) {
            this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
            return false;
        } else if (this.gfP != null) {
            this.gfP.d(bGG());
            return false;
        } else {
            return false;
        }
    }

    private boolean bGF() {
        if (this.gfP != null) {
            this.gfN = true;
            bGA();
            this.gfP.bEe();
            if (TextUtils.isEmpty(this.gfG.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void kL(boolean z) {
        if (z) {
            bGF();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void xT() {
        this.gfI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bGI();
                if (z) {
                    a.this.gfI.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gfI.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gfJ != null) {
            this.gfJ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bGI();
                    if (z) {
                        a.this.gfJ.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gfJ.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gfK != null) {
            this.gfK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gfP.bEh();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGH() {
        if (this.gfO) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bGI() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gfG.getText().toString();
    }

    public boolean bBb() {
        return this.gfM.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gfP = bVar;
    }

    public void kK(boolean z) {
        this.gfI.setVisibility(8);
        this.gfI.setChecked(false);
    }

    public boolean bAY() {
        return this.gfI.isChecked();
    }

    public boolean bAZ() {
        return this.gfJ.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gfO != z) {
            this.gfO = z;
        }
    }

    public void destroy() {
        if (this.gfM != null) {
            this.gfM.destroy();
        }
    }
}
