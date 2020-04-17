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
    protected AlaLiveRecorder aXW;
    private LinearLayout aeq;
    protected EditText fQF;
    private LinearLayout fQG;
    private CheckBox fQH;
    private CheckBox fQI;
    private TextView fQJ;
    protected Button fQK;
    protected d fQL;
    public boolean fQM;
    protected e.b fQO;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean fQN = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.fQF) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fQF);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.fQF);
                }
            }
        }
    };

    protected abstract int bAu();

    protected abstract boolean bAv();

    protected abstract int bvj();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fQL = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAm() {
        this.fQF = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.fQF.setOnFocusChangeListener(this.focusChangeListener);
        this.fQG = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.fQL.ap(this.fQG);
        this.fQH = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.fQI = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.fQJ = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.aeq = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.fQK = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        wD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.aXW = alaLiveRecorder;
    }

    protected void bAn() {
        this.aXW.setVideoConfig(LiveRecorderConfigHelper.Ei().d(bAu(), bvj(), bAv()));
    }

    protected boolean bAo() {
        return false;
    }

    protected boolean bAp() {
        return false;
    }

    public String bAq() {
        return com.baidu.live.c.tH().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bAr() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.fQF.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bAq())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bAp = bAp();
        boolean bAo = bAo();
        if (bAp || bAo) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (this.fQO != null) {
            this.fQM = true;
            bAn();
            this.fQO.byb();
            if (!TextUtils.isEmpty(this.fQF.getText().toString())) {
                TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
            return true;
        } else {
            return false;
        }
    }

    private void wD() {
        this.fQH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bAt();
                if (z) {
                    a.this.fQH.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.fQH.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.fQI != null) {
            this.fQI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bAt();
                    if (z) {
                        a.this.fQI.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.fQI.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.fQJ != null) {
            this.fQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fQO.bye();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bAs() {
        if (this.fQN) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bAt() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.fQF.getText().toString();
    }

    public boolean bvc() {
        return this.fQL.isShowLocation();
    }

    public void a(e.b bVar) {
        this.fQO = bVar;
    }

    public void kq(boolean z) {
        this.fQH.setVisibility(8);
        this.fQH.setChecked(false);
    }

    public boolean buZ() {
        return this.fQH.isChecked();
    }

    public boolean bva() {
        return this.fQI.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fQN != z) {
            this.fQN = z;
        }
    }

    public void destroy() {
        if (this.fQL != null) {
            this.fQL.destroy();
        }
    }
}
