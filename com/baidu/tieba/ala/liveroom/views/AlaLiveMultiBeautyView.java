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
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private HListView fmF;
    private com.baidu.tieba.ala.liveroom.g.c fmG;
    private LinearLayout fmH;
    private LinearLayout fmI;
    private Button fmJ;
    private Button fmK;
    private Button fmL;
    private View fmM;
    private GridView fmN;
    private boolean fmO;
    private com.baidu.tieba.ala.liveroom.data.d fmP;
    private SeekBar fmQ;
    private SeekBar fmR;
    private SeekBar fmS;
    private SeekBar fmT;
    private SeekBar fmU;
    private com.baidu.live.ar.e fmV;
    private BdPageContext fmW;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fmO = true;
        this.fmP = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmO = true;
        this.fmP = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmO = true;
        this.fmP = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.fmF = (HListView) findViewById(a.g.filter_list_view);
        if (this.fmF != null) {
            this.fmG = new com.baidu.tieba.ala.liveroom.g.c(this.fmF);
            this.fmG.pW(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fmF.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fmF.setAdapter((ListAdapter) this.fmG);
            this.fmF.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fmN = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fmN != null) {
            this.fmG = new com.baidu.tieba.ala.liveroom.g.c(this.fmN);
            this.fmN.setAdapter((ListAdapter) this.fmG);
        }
        this.fmG.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fmP.mFilterName = AlaLiveMultiBeautyView.this.fmG.fae[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.onFilterSelected(AlaLiveMultiBeautyView.this.fmG.fae[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fmL = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fmL.setOnClickListener(this);
        this.fmJ = (Button) findViewById(a.g.btn_choose_filter);
        this.fmJ.setOnClickListener(this);
        this.fmK = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fmK.setOnClickListener(this);
        this.fmH = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fmI = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fmQ = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fmQ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmP.faG = i;
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmR = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fmR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmP.faH = i;
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.r(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmS = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fmS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmP.faI = i;
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmT = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fmT.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmP.faK = i;
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmU = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fmU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmP.faJ = i;
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmM = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.pC();
                if (AlaLiveMultiBeautyView.this.fmV != null) {
                    AlaLiveMultiBeautyView.this.fmV.pD();
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
    public void pB() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void pC() {
        if (this.fmP != null) {
            com.baidu.live.c.pr().putString("ala_beauty_5.4_config_str", this.fmP.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.c cVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.fmW = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fmO && this.fmJ.getWidth() != 0) {
            f(this.fmJ, false);
            this.fmO = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmJ) {
            f(this.fmJ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fmJ);
            if (this.fmF != null) {
                setEffectFilterBeautyChooseBlock(this.fmF);
            } else if (this.fmN != null) {
                setEffectFilterBeautyChooseBlock(this.fmN);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fmK) {
            f(this.fmK, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fmK);
            setEffectFilterBeautyChooseBlock(this.fmH);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fmL) {
            f(this.fmL, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fmL);
            setEffectFilterBeautyChooseBlock(this.fmI);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fmF != null) {
            this.fmF.setVisibility(4);
        }
        if (this.fmN != null) {
            this.fmN.setVisibility(4);
        }
        this.fmH.setVisibility(4);
        this.fmI.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fmJ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fmK.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fmL.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.e eVar) {
        this.fmV = eVar;
    }

    private void f(View view, boolean z) {
        this.fmM.clearAnimation();
        int width = (this.fmM.getWidth() / 2) + this.fmM.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmM.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fmM.getWidth() / 2);
        this.fmM.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fmM.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.live.ar.d dVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (dVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar2 = (com.baidu.tieba.ala.liveroom.data.d) dVar;
            this.fmQ.setProgress(dVar2.faG);
            this.fmR.setProgress(dVar2.faH);
            this.fmS.setProgress(dVar2.faI);
            this.fmT.setProgress(dVar2.faK);
            this.fmU.setProgress(dVar2.faJ);
            this.fmG.yU(dVar2.mFilterName);
            this.fmG.notifyDataSetChanged();
            this.fmP = dVar2;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fmK.setVisibility(0);
            } else {
                this.fmK.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
