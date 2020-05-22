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
    protected Button gfA;
    protected d gfB;
    public boolean gfC;
    protected e.b gfE;
    protected EditText gfv;
    private LinearLayout gfw;
    private CheckBox gfx;
    private CheckBox gfy;
    private TextView gfz;
    protected TbPageContext mPageContext;
    protected ViewGroup mRootView;
    private boolean gfD = false;
    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == a.this.gfv) {
                if (z) {
                    BdUtilHelper.showSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gfv);
                } else {
                    BdUtilHelper.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.gfv);
                }
            }
        }
    };

    protected abstract int bBg();

    protected abstract com.baidu.tieba.ala.category.b.a bGE();

    protected abstract int bGH();

    protected abstract boolean bGI();

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gfB = new d(this.mPageContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGx() {
        this.gfv = (EditText) this.mRootView.findViewById(a.g.ala_liveroom_prepare_title);
        this.gfv.setOnFocusChangeListener(this.focusChangeListener);
        this.gfw = (LinearLayout) this.mRootView.findViewById(a.g.ala_live_prepare_locate_layout);
        this.gfB.ay(this.gfw);
        this.gfx = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_personal_check);
        this.gfy = (CheckBox) this.mRootView.findViewById(a.g.ala_live_prepare_licence);
        this.gfz = (TextView) this.mRootView.findViewById(a.g.ala_live_prepare_licence_detail);
        this.aeP = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_main_layout);
        this.gfA = (Button) this.mRootView.findViewById(a.g.ala_live_prepare_start);
        xT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AlaLiveRecorder alaLiveRecorder) {
        this.bfx = alaLiveRecorder;
    }

    protected void bGy() {
        this.bfx.setVideoConfig(LiveRecorderConfigHelper.FX().d(bGH(), bBg(), bGI()));
    }

    protected boolean bGz() {
        return false;
    }

    protected boolean bGA() {
        return false;
    }

    public String bGB() {
        return com.baidu.live.c.uN().getString(com.baidu.live.c.getSharedPrefKeyWithAccount("key_default_cover"), "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bGC() {
        if (TextUtils.isEmpty(getLiveTitle().trim())) {
            this.gfv.setText(this.mPageContext.getString(a.i.ala_live_prepare_title));
        }
        if (TextUtils.isEmpty(bGB())) {
            this.mPageContext.showToast(a.i.hk_live_upload_cover);
            return false;
        }
        boolean bGA = bGA();
        boolean bGz = bGz();
        if (bGA || bGz) {
            return false;
        }
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.mPageContext.showToast(a.i.ala_create_to_retry);
            return false;
        } else if (!z.wg()) {
            return bGD();
        } else if (bGE() == null || bGE().bsL() == null || bGE().bsM() == null) {
            this.mPageContext.showToast(a.i.ala_live_prepare_select_livetype_tips);
            return false;
        } else if (this.gfE != null) {
            this.gfE.d(bGE());
            return false;
        } else {
            return false;
        }
    }

    private boolean bGD() {
        if (this.gfE != null) {
            this.gfC = true;
            bGy();
            this.gfE.bEc();
            if (TextUtils.isEmpty(this.gfv.getText().toString())) {
                return true;
            }
            TiebaInitialize.log(new StatisticItem("c11869").param("uid", TbadkCoreApplication.getCurrentAccount()));
            return true;
        }
        return false;
    }

    public void kL(boolean z) {
        if (z) {
            bGD();
        } else {
            this.mPageContext.showToast(a.i.ala_live_prepare_add_category_fail);
        }
    }

    private void xT() {
        this.gfx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.bGG();
                if (z) {
                    a.this.gfx.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    a.this.gfx.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                }
            }
        });
        if (this.gfy != null) {
            this.gfy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.bGG();
                    if (z) {
                        a.this.gfy.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_s), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        a.this.gfy.setCompoundDrawablesWithIntrinsicBounds(a.this.mPageContext.getResources().getDrawable(a.f.icon_live_video_choose_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
            });
        }
        if (this.gfz != null) {
            this.gfz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gfE.bEf();
                    LogManager.getLiveRecordLogger().doClickLiveRulesButtonLog("");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGF() {
        if (this.gfD) {
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.mRootView);
        }
    }

    protected void bGG() {
    }

    public View getView() {
        return this.mRootView;
    }

    public String getLiveTitle() {
        return this.gfv.getText().toString();
    }

    public boolean bAZ() {
        return this.gfB.isShowLocation();
    }

    public void a(e.b bVar) {
        this.gfE = bVar;
    }

    public void kK(boolean z) {
        this.gfx.setVisibility(8);
        this.gfx.setChecked(false);
    }

    public boolean bAW() {
        return this.gfx.isChecked();
    }

    public boolean bAX() {
        return this.gfy.isChecked();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gfD != z) {
            this.gfD = z;
        }
    }

    public void destroy() {
        if (this.gfB != null) {
            this.gfB.destroy();
        }
    }
}
