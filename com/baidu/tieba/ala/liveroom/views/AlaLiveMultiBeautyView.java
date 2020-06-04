package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.f;
import com.baidu.live.ar.g;
import com.baidu.live.ar.h;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aUs;
    private LinearLayout eZI;
    private Button eZJ;
    private Button eZK;
    private Button eZL;
    private View eZM;
    private boolean eZN;
    private h eZP;
    private HListView ggC;
    private com.baidu.tieba.ala.liveroom.g.c ggD;
    private LinearLayout ggE;
    private GridView ggF;
    private com.baidu.tieba.ala.liveroom.data.d ggG;
    private SeekBar ggH;
    private SeekBar ggI;
    private SeekBar ggJ;
    private SeekBar ggK;
    private SeekBar ggL;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.eZN = true;
        this.ggG = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZN = true;
        this.ggG = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZN = true;
        this.ggG = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
        }
        this.ggC = (HListView) findViewById(a.g.filter_list_view);
        if (this.ggC != null) {
            this.ggD = new com.baidu.tieba.ala.liveroom.g.c(this.ggC);
            this.ggD.py(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.ggC.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.ggC.setAdapter((ListAdapter) this.ggD);
            this.ggC.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.ggF = (GridView) findViewById(a.g.filter_grid_view);
        if (this.ggF != null) {
            this.ggD = new com.baidu.tieba.ala.liveroom.g.c(this.ggF);
            this.ggF.setAdapter((ListAdapter) this.ggD);
        }
        this.ggD.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.ggG.mFilterName = AlaLiveMultiBeautyView.this.ggD.fSZ[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.onFilterSelected(AlaLiveMultiBeautyView.this.ggD.fSZ[i].mShowName, AlaLiveMultiBeautyView.this.ggD.fSZ[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.eZL = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eZL.setOnClickListener(this);
        this.eZJ = (Button) findViewById(a.g.btn_choose_filter);
        this.eZJ.setOnClickListener(this);
        this.eZK = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eZK.setOnClickListener(this);
        this.ggE = (LinearLayout) findViewById(a.g.live_face_shape);
        this.eZI = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.ggH = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.ggH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggG.fTx = i;
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.n(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggI = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.ggI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggG.fTy = i;
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggJ = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.ggJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggG.fTz = i;
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggK = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.ggK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggG.fTB = i;
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.ggL = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.ggL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.ggG.fTA = i;
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eZM = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.vc();
                if (AlaLiveMultiBeautyView.this.eZP != null) {
                    AlaLiveMultiBeautyView.this.eZP.vd();
                    return true;
                }
                return true;
            }
        });
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vb() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vc() {
        if (this.ggG != null) {
            com.baidu.live.c.uN().putString("ala_beauty_5.4_config_str", this.ggG.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aUs = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eZN && this.eZJ.getWidth() != 0) {
            h(this.eZJ, false);
            this.eZN = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eZJ) {
            h(this.eZJ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZJ);
            if (this.ggC != null) {
                setEffectFilterBeautyChooseBlock(this.ggC);
            } else if (this.ggF != null) {
                setEffectFilterBeautyChooseBlock(this.ggF);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.eZK) {
            h(this.eZK, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZK);
            setEffectFilterBeautyChooseBlock(this.ggE);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eZL) {
            h(this.eZL, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZL);
            setEffectFilterBeautyChooseBlock(this.eZI);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.ggC != null) {
            this.ggC.setVisibility(4);
        }
        if (this.ggF != null) {
            this.ggF.setVisibility(4);
        }
        this.ggE.setVisibility(4);
        this.eZI.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eZJ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZK.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZL.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eZP = hVar;
    }

    private void h(View view, boolean z) {
        this.eZM.clearAnimation();
        int width = (this.eZM.getWidth() / 2) + this.eZM.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eZM.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eZM.getWidth() / 2);
        this.eZM.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eZM.startAnimation(translateAnimation);
        }
    }

    public void setViewData(g gVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (gVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) gVar;
            this.ggH.setProgress(dVar.fTx);
            this.ggI.setProgress(dVar.fTy);
            this.ggJ.setProgress(dVar.fTz);
            this.ggK.setProgress(dVar.fTB);
            this.ggL.setProgress(dVar.fTA);
            this.ggD.AT(dVar.mFilterName);
            this.ggD.notifyDataSetChanged();
            this.ggG = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.eZK.setVisibility(0);
            } else {
                this.eZK.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
