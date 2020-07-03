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
import com.baidu.live.ar.h;
import com.baidu.live.ar.i;
import com.baidu.live.ar.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aWZ;
    private LinearLayout fkJ;
    private Button fkN;
    private Button fkO;
    private Button fkP;
    private View fkQ;
    private boolean fkR;
    private j fkT;
    private LinearLayout gtA;
    private GridView gtB;
    private com.baidu.tieba.ala.liveroom.data.d gtC;
    private SeekBar gtD;
    private SeekBar gtE;
    private SeekBar gtF;
    private SeekBar gtG;
    private SeekBar gtH;
    private HListView gty;
    private com.baidu.tieba.ala.liveroom.g.c gtz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fkR = true;
        this.gtC = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkR = true;
        this.gtC = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkR = true;
        this.gtC = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.gty = (HListView) findViewById(a.g.filter_list_view);
        if (this.gty != null) {
            this.gtz = new com.baidu.tieba.ala.liveroom.g.c(this.gty);
            this.gtz.pW(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gty.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gty.setAdapter((ListAdapter) this.gtz);
            this.gty.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.gtB = (GridView) findViewById(a.g.filter_grid_view);
        if (this.gtB != null) {
            this.gtz = new com.baidu.tieba.ala.liveroom.g.c(this.gtB);
            this.gtB.setAdapter((ListAdapter) this.gtz);
        }
        this.gtz.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.gtC.mFilterName = AlaLiveMultiBeautyView.this.gtz.gfF[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.onFilterSelected(AlaLiveMultiBeautyView.this.gtz.gfF[i].mShowName, AlaLiveMultiBeautyView.this.gtz.gfF[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fkP = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fkP.setOnClickListener(this);
        this.fkN = (Button) findViewById(a.g.btn_choose_filter);
        this.fkN.setOnClickListener(this);
        this.fkO = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fkO.setOnClickListener(this);
        this.gtA = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fkJ = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.gtD = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.gtD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gtC.ggd = i;
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gtE = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.gtE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gtC.gge = i;
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gtF = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.gtF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gtC.ggf = i;
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gtG = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.gtG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gtC.ggh = i;
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gtH = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.gtH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gtC.ggg = i;
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.r(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fkQ = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.vx();
                if (AlaLiveMultiBeautyView.this.fkT != null) {
                    AlaLiveMultiBeautyView.this.fkT.vy();
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
    public void vw() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vx() {
        if (this.gtC != null) {
            com.baidu.live.c.vf().putString("ala_beauty_5.4_config_str", this.gtC.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aWZ = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fkR && this.fkN.getWidth() != 0) {
            h(this.fkN, false);
            this.fkR = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fkN) {
            h(this.fkN, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fkN);
            if (this.gty != null) {
                setEffectFilterBeautyChooseBlock(this.gty);
            } else if (this.gtB != null) {
                setEffectFilterBeautyChooseBlock(this.gtB);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fkO) {
            h(this.fkO, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fkO);
            setEffectFilterBeautyChooseBlock(this.gtA);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fkP) {
            h(this.fkP, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fkP);
            setEffectFilterBeautyChooseBlock(this.fkJ);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.gty != null) {
            this.gty.setVisibility(4);
        }
        if (this.gtB != null) {
            this.gtB.setVisibility(4);
        }
        this.gtA.setVisibility(4);
        this.fkJ.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fkN.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fkO.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fkP.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fkT = jVar;
    }

    private void h(View view, boolean z) {
        this.fkQ.clearAnimation();
        int width = (this.fkQ.getWidth() / 2) + this.fkQ.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkQ.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fkQ.getWidth() / 2);
        this.fkQ.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fkQ.startAnimation(translateAnimation);
        }
    }

    public void setViewData(i iVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (iVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) iVar;
            this.gtD.setProgress(dVar.ggd);
            this.gtE.setProgress(dVar.gge);
            this.gtF.setProgress(dVar.ggf);
            this.gtG.setProgress(dVar.ggh);
            this.gtH.setProgress(dVar.ggg);
            this.gtz.Bm(dVar.mFilterName);
            this.gtz.notifyDataSetChanged();
            this.gtC = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fkO.setVisibility(0);
            } else {
                this.fkO.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
