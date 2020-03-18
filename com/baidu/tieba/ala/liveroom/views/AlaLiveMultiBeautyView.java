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
    private HListView fne;
    private com.baidu.tieba.ala.liveroom.g.c fnf;
    private LinearLayout fng;
    private LinearLayout fnh;
    private Button fni;
    private Button fnj;
    private Button fnk;
    private View fnl;
    private GridView fnm;
    private boolean fnn;
    private com.baidu.tieba.ala.liveroom.data.d fno;
    private SeekBar fnp;
    private SeekBar fnq;
    private SeekBar fnr;
    private SeekBar fns;
    private SeekBar fnt;
    private com.baidu.live.ar.e fnu;
    private BdPageContext fnv;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fnn = true;
        this.fno = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnn = true;
        this.fno = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnn = true;
        this.fno = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.fne = (HListView) findViewById(a.g.filter_list_view);
        if (this.fne != null) {
            this.fnf = new com.baidu.tieba.ala.liveroom.g.c(this.fne);
            this.fnf.pY(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fne.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fne.setAdapter((ListAdapter) this.fnf);
            this.fne.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fnm = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fnm != null) {
            this.fnf = new com.baidu.tieba.ala.liveroom.g.c(this.fnm);
            this.fnm.setAdapter((ListAdapter) this.fnf);
        }
        this.fnf.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fno.mFilterName = AlaLiveMultiBeautyView.this.fnf.faC[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.onFilterSelected(AlaLiveMultiBeautyView.this.fnf.faC[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fnk = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fnk.setOnClickListener(this);
        this.fni = (Button) findViewById(a.g.btn_choose_filter);
        this.fni.setOnClickListener(this);
        this.fnj = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fnj.setOnClickListener(this);
        this.fng = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fnh = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fnp = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fnp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fno.fbe = i;
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fnq = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fnq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fno.fbf = i;
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.r(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fnr = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fnr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fno.fbg = i;
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fns = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fns.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fno.fbi = i;
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fnt = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fnt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fno.fbh = i;
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fnl = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.pH();
                if (AlaLiveMultiBeautyView.this.fnu != null) {
                    AlaLiveMultiBeautyView.this.fnu.pI();
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
    public void pG() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void pH() {
        if (this.fno != null) {
            com.baidu.live.c.pw().putString("ala_beauty_5.4_config_str", this.fno.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.c cVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.fnv = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fnn && this.fni.getWidth() != 0) {
            f(this.fni, false);
            this.fnn = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fni) {
            f(this.fni, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fni);
            if (this.fne != null) {
                setEffectFilterBeautyChooseBlock(this.fne);
            } else if (this.fnm != null) {
                setEffectFilterBeautyChooseBlock(this.fnm);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fnj) {
            f(this.fnj, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fnj);
            setEffectFilterBeautyChooseBlock(this.fng);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fnk) {
            f(this.fnk, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fnk);
            setEffectFilterBeautyChooseBlock(this.fnh);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fne != null) {
            this.fne.setVisibility(4);
        }
        if (this.fnm != null) {
            this.fnm.setVisibility(4);
        }
        this.fng.setVisibility(4);
        this.fnh.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fni.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fnj.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fnk.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.e eVar) {
        this.fnu = eVar;
    }

    private void f(View view, boolean z) {
        this.fnl.clearAnimation();
        int width = (this.fnl.getWidth() / 2) + this.fnl.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fnl.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fnl.getWidth() / 2);
        this.fnl.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fnl.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.live.ar.d dVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (dVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar2 = (com.baidu.tieba.ala.liveroom.data.d) dVar;
            this.fnp.setProgress(dVar2.fbe);
            this.fnq.setProgress(dVar2.fbf);
            this.fnr.setProgress(dVar2.fbg);
            this.fns.setProgress(dVar2.fbi);
            this.fnt.setProgress(dVar2.fbh);
            this.fnf.yU(dVar2.mFilterName);
            this.fnf.notifyDataSetChanged();
            this.fno = dVar2;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fnj.setVisibility(0);
            } else {
                this.fnj.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
