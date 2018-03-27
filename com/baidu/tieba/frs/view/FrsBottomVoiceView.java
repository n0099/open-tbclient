package com.baidu.tieba.frs.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.l;
/* loaded from: classes2.dex */
public class FrsBottomVoiceView extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View aRs;
    private TextView aSb;
    private VoiceManager dEn;
    private HeadImageView dYK;
    private ImageView dYL;
    private LinearLayout dYM;
    private TextView dYN;
    private int dYO;
    private int dYP;
    private VoiceData.VoiceModel dYQ;
    private ObjectAnimator dYR;
    private ValueAnimator dYS;
    private l dYT;
    private float mAngle;
    private Runnable mRunnable;
    private int mSkinType;
    private BdUniqueId mTag;
    private TextView mTitleView;

    public FrsBottomVoiceView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsBottomVoiceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBottomVoiceView.this.dYP != 0) {
                    FrsBottomVoiceView.this.dYS.setIntValues(FrsBottomVoiceView.this.dYO, 0);
                    FrsBottomVoiceView.this.dYS.start();
                }
            }
        };
        init(context);
    }

    public FrsBottomVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsBottomVoiceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBottomVoiceView.this.dYP != 0) {
                    FrsBottomVoiceView.this.dYS.setIntValues(FrsBottomVoiceView.this.dYO, 0);
                    FrsBottomVoiceView.this.dYS.start();
                }
            }
        };
        init(context);
    }

    public FrsBottomVoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.frs.view.FrsBottomVoiceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrsBottomVoiceView.this.dYP != 0) {
                    FrsBottomVoiceView.this.dYS.setIntValues(FrsBottomVoiceView.this.dYO, 0);
                    FrsBottomVoiceView.this.dYS.start();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_bottom_voice_view, (ViewGroup) this, true);
        this.dYK = (HeadImageView) findViewById(d.g.frs_bottom_voice_headimg);
        this.dYK.setIsRound(true);
        this.dYK.setDrawBorder(false);
        this.dYK.setDefaultResource(17170445);
        this.dYK.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dYK.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dYK.setRadius(com.baidu.adp.lib.util.l.t(context, d.e.ds70));
        this.dYK.setOnDrawListener(new TbImageView.b() { // from class: com.baidu.tieba.frs.view.FrsBottomVoiceView.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
                if (FrsBottomVoiceView.this.dYT != null) {
                    if (tbImageView.getBdImage() == null || tbImageView.getBdImage().sh() == null) {
                        FrsBottomVoiceView.this.dYK.startLoad(FrsBottomVoiceView.this.dYT.avatar, 10, false);
                    }
                }
            }
        });
        this.dYL = (ImageView) findViewById(d.g.frs_bottom_voice_headicon);
        this.dYM = (LinearLayout) findViewById(d.g.frs_bottom_voice_content);
        this.mTitleView = (TextView) findViewById(d.g.frs_bottom_voice_title);
        this.aSb = (TextView) findViewById(d.g.frs_bottom_voice_desc);
        this.aRs = findViewById(d.g.frs_bottom_voice_line);
        this.dYN = (TextView) findViewById(d.g.frs_bottom_voice_btn);
        this.dYR = ObjectAnimator.ofFloat(this.dYK, "rotation", this.mAngle, this.mAngle + 360.0f);
        this.dYR.setDuration(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.dYR.setRepeatCount(-1);
        this.dYR.setInterpolator(new LinearInterpolator());
        this.dYR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.view.FrsBottomVoiceView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrsBottomVoiceView.this.mAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.dYS = ValueAnimator.ofInt(this.dYO, 0);
        this.dYS.setDuration(500L);
        this.dYS.setInterpolator(new LinearInterpolator());
        this.dYS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.view.FrsBottomVoiceView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrsBottomVoiceView.this.dYP = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (FrsBottomVoiceView.this.dYP == FrsBottomVoiceView.this.dYO) {
                    FrsBottomVoiceView.this.dYM.setVisibility(0);
                } else {
                    FrsBottomVoiceView.this.dYM.setVisibility(4);
                }
                FrsBottomVoiceView.this.dYM.getLayoutParams().width = FrsBottomVoiceView.this.dYP;
                FrsBottomVoiceView.this.requestLayout();
            }
        });
        this.dYN.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
        postDelayed(this.mRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        VoiceManager.setVoiceUseSoftDecoder(false);
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEn = voiceManager;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(l lVar) {
        if (lVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dYT = lVar;
        this.dYK.startLoad(this.dYT.avatar, 10, false);
        this.mTitleView.setText(this.dYT.title);
        this.aSb.setText(this.dYT.desc);
        setVoiceModel(this.dYT.haV);
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            this.dYQ = voiceModel;
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.dYO == 0) {
            this.dYO = this.dYM.getMeasuredWidth();
            this.dYP = this.dYO;
        }
    }

    public void of(int i) {
        if (i == 3) {
            this.dYL.setVisibility(8);
            if (this.dYP != this.dYO) {
                this.dYS.setIntValues(0, this.dYO);
                this.dYS.start();
            }
            this.dYR.setFloatValues(this.mAngle, this.mAngle + 360.0f);
            this.dYR.start();
        } else if (i == 4) {
            this.dYL.setVisibility(0);
            this.dYR.cancel();
        } else if (i == 1) {
            this.dYL.setVisibility(0);
            this.dYR.cancel();
            this.mAngle = 0.0f;
            this.dYK.setRotation(this.mAngle);
            postDelayed(this.mRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gD(boolean z) {
        if (this.dYN != null) {
            this.dYN.setText(z ? d.j.frs_bottom_voice_text : d.j.frs_bottom_voice_text_dark);
        }
    }

    public void onResume() {
        removeCallbacks(this.mRunnable);
        postDelayed(this.mRunnable, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void onPause() {
        removeCallbacks(this.mRunnable);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dYQ != voiceModel) {
                of(1);
            } else {
                of(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (this.dYQ != null) {
            this.dYQ.elapse = i;
        }
    }

    public void pausePlay() {
        VoiceManager voiceManager;
        if (this.dYQ != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.pausePlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dYQ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dYQ);
        }
        if ((com.baidu.adp.base.i.ak(context) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dYQ);
        }
        return this;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.i.ak(context) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dEn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.dYN == view) {
            CustomMessage customMessage = new CustomMessage(2921334);
            customMessage.setTag(this.mTag);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921334);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        } else if (this.dYQ != null && (voiceManager = getVoiceManager()) != null) {
            TiebaStatic.log(new ak("c13037"));
            removeCallbacks(this.mRunnable);
            if (voiceManager.isPlaying(this.dYQ)) {
                pausePlay();
            } else if (voiceManager.isPause()) {
                voiceManager.startPlay();
            } else {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.s(this, d.f.frs_bottom_voice_view_bg);
            aj.c(this.dYL, d.f.icon_temporary_voice_n);
            aj.r(this.mTitleView, d.C0141d.cp_cont_i);
            aj.r(this.aSb, d.C0141d.cp_cont_i_alpha50);
            aj.s(this.aRs, d.C0141d.cp_cont_i_alpha60);
            aj.r(this.dYN, d.C0141d.cp_cont_i_alpha60);
        }
    }

    public void onDestroy() {
        this.dYR.cancel();
        this.dYR.removeAllListeners();
        this.dYK.clearAnimation();
        this.dYS.cancel();
        this.dYS.removeAllUpdateListeners();
        clearAnimation();
        removeCallbacks(this.mRunnable);
        VoiceManager.setVoiceUseSoftDecoder(true);
    }
}
