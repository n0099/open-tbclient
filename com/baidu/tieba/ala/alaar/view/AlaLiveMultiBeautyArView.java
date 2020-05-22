package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.d;
import com.baidu.live.ar.f;
import com.baidu.live.ar.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.a.e;
import com.baidu.tieba.ala.alaar.view.a;
import com.baidu.tieba.ala.alaar.view.b;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aUs;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private Button eZA;
    private View eZB;
    private boolean eZC;
    private com.baidu.live.ar.c eZD;
    private h eZE;
    private int eZF;
    private TextView eZG;
    private HListView eZd;
    private a eZe;
    private int eZf;
    private int eZg;
    private HListView eZh;
    private b eZi;
    private int eZj;
    private int eZk;
    private FrameLayout eZl;
    private TopTipSeekBar eZm;
    private TextView eZn;
    private TextView eZo;
    private View eZp;
    private int eZq;
    private FrameLayout eZr;
    private TopTipSeekBar eZs;
    private TextView eZt;
    private TextView eZu;
    private BdAlertDialog eZv;
    private f eZw;
    private LinearLayout eZx;
    private Button eZy;
    private Button eZz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.eZf = -1;
        this.eZg = -1;
        this.eZj = -1;
        this.eZk = -1;
        this.eZq = 0;
        this.eZC = true;
        this.eZD = com.baidu.live.ar.c.atc;
        this.eZF = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZf = -1;
        this.eZg = -1;
        this.eZj = -1;
        this.eZk = -1;
        this.eZq = 0;
        this.eZC = true;
        this.eZD = com.baidu.live.ar.c.atc;
        this.eZF = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZf = -1;
        this.eZg = -1;
        this.eZj = -1;
        this.eZk = -1;
        this.eZq = 0;
        this.eZC = true;
        this.eZD = com.baidu.live.ar.c.atc;
        this.eZF = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bqb();
        this.eZd = (HListView) findViewById(a.g.filter_list_view);
        if (this.eZd != null) {
            this.eZe = new a(this.eZd);
            this.eZe.pw(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eZd.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eZd.setAdapter((ListAdapter) this.eZe);
            this.eZd.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eZd.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eZf = i;
                AlaLiveMultiBeautyArView.this.eZg = i2;
            }
        });
        this.eZe.a(new a.InterfaceC0522a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0522a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.eZg > 0) {
                            AlaLiveMultiBeautyArView.this.eZd.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eZf, AlaLiveMultiBeautyArView.this.eZg, iArr, AlaLiveMultiBeautyArView.this.eZe.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                d dVar = AlaLiveMultiBeautyArView.this.eZe.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.eZD.asU.equals(e.AG(dVar.uX()))) {
                    AlaLiveMultiBeautyArView.this.AS(dVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName())) {
                    com.baidu.live.ar.c cVar = AlaLiveMultiBeautyArView.this.eZD;
                    com.baidu.minivideo.arface.b.LQ();
                    cVar.asU = com.baidu.minivideo.arface.c.LT();
                } else {
                    AlaLiveMultiBeautyArView.this.eZD.asU = e.AG(dVar.uX());
                }
                AlaLiveMultiBeautyArView.this.eZD.asV = dVar;
                if (AlaLiveMultiBeautyArView.this.eZE != null && AlaLiveMultiBeautyArView.this.eZw.va() != null) {
                    int a = AlaLiveMultiBeautyArView.this.eZD.a(dVar, AlaLiveMultiBeautyArView.this.eZw.va().asJ);
                    int ei = AlaLiveMultiBeautyArView.this.eZD.ei(AlaLiveMultiBeautyArView.this.eZD.asU);
                    float f = (((ei * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + ei + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eZE.onFilterSelected(AlaLiveMultiBeautyArView.this.eZD.asV.getName(), AlaLiveMultiBeautyArView.this.eZD.asU, f);
                }
                AlaLiveMultiBeautyArView.this.pu(AlaLiveMultiBeautyArView.this.eZD.ei(AlaLiveMultiBeautyArView.this.eZD.asU));
            }
        });
        this.eZr = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.eZt = (TextView) findViewById(a.g.filter_progress_tv);
        this.eZs = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.eZs.setMax(100);
        this.eZs.setTipView(this.eZt);
        this.eZu = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.eZs.setDefThumb(this.eZu);
        this.eZs.setDefThumbPos(100);
        this.eZs.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eZD.x(AlaLiveMultiBeautyArView.this.eZD.asU, i);
                if (AlaLiveMultiBeautyArView.this.eZE != null) {
                    int a = AlaLiveMultiBeautyArView.this.eZD.a(AlaLiveMultiBeautyArView.this.eZD.asV, AlaLiveMultiBeautyArView.this.eZw.va().asJ);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eZE.onFilterSelected(AlaLiveMultiBeautyArView.this.eZD.asV.getName(), AlaLiveMultiBeautyArView.this.eZD.asU, f);
                }
                if (z) {
                    com.baidu.live.c.uN().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eZl = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.eZn = (TextView) findViewById(a.g.progress_tv);
        this.eZo = (TextView) findViewById(a.g.def_thumb_tv);
        this.eZm = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.eZp = findViewById(a.g.effect_diff_btn);
        this.eZh = (HListView) findViewById(a.g.beauty_list_view);
        this.eZm.setMax(100);
        this.eZm.setTipView(this.eZn);
        this.eZm.setDefThumb(this.eZo);
        if (this.eZh != null) {
            this.eZi = new b(this.eZh);
            this.eZi.pw(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eZh.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eZh.setAdapter((ListAdapter) this.eZi);
            this.eZh.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eZh.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eZj = i;
                AlaLiveMultiBeautyArView.this.eZk = i2;
            }
        });
        this.eZi.a(new b.InterfaceC0523b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0523b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bqc();
                    return;
                }
                AlaLiveMultiBeautyArView.this.eZh.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eZj, AlaLiveMultiBeautyArView.this.eZk, iArr, AlaLiveMultiBeautyArView.this.eZi.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.eZD.asW = AlaLiveMultiBeautyArView.this.eZi.eZX[i].fac;
                AlaLiveMultiBeautyArView.this.eZq = AlaLiveMultiBeautyArView.this.eZi.eZX[i].fad;
                AlaLiveMultiBeautyArView.this.pt(AlaLiveMultiBeautyArView.this.eZD.ej(AlaLiveMultiBeautyArView.this.eZD.asW) + AlaLiveMultiBeautyArView.this.eZq);
                AlaLiveMultiBeautyArView.this.eZm.setProcessDiff(AlaLiveMultiBeautyArView.this.eZi.eZX[i].fad);
            }
        });
        this.eZm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eZD.y(AlaLiveMultiBeautyArView.this.eZD.asW, i - AlaLiveMultiBeautyArView.this.eZq);
                if (AlaLiveMultiBeautyArView.this.eZE != null) {
                    AlaLiveMultiBeautyArView.this.eZE.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.eg(AlaLiveMultiBeautyArView.this.eZD.asW));
                }
                if (z) {
                    com.baidu.live.c.uN().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eZp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.eZE != null) {
                            AlaLiveMultiBeautyArView.this.eZE.vf();
                            return true;
                        }
                        return true;
                    case 1:
                    case 3:
                    case 4:
                        AlaLiveMultiBeautyArView.this.bqd();
                        return true;
                    case 2:
                    default:
                        return true;
                }
            }
        });
        this.eZA = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eZA.setOnClickListener(this);
        this.eZy = (Button) findViewById(a.g.btn_choose_filter);
        this.eZy.setOnClickListener(this);
        this.eZz = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eZz.setOnClickListener(this);
        this.eZx = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.eZB = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.vc();
                if (AlaLiveMultiBeautyArView.this.eZE != null) {
                    AlaLiveMultiBeautyArView.this.eZE.vd();
                }
            }
        });
        this.eZG = (TextView) findViewById(a.g.filter_select_anim);
    }

    private void bqb() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vc() {
        if (this.eZD != null) {
            com.baidu.live.c.uN().putString("ala_beauty_config_ar", this.eZD.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
        this.eZw = fVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aUs = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eZm.setProgress(i, true);
        } else {
            this.eZm.setProgress(i);
        }
        this.eZm.setDefThumbPos(com.baidu.live.ar.c.atb.ej(this.eZD.asW) + this.eZq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eZs.setProgress(i, true);
        } else {
            this.eZs.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2, int i3, int[] iArr, int i4, boolean z) {
        int i5;
        int i6 = (i3 / 2) + i2;
        if (i >= i2 + i3) {
            i5 = (((i - i6) + 1) * this.ds120) + this.ds28;
        } else {
            i5 = ((i - i6) * this.ds120) + this.ds28 + (this.ds120 / 2);
        }
        int i7 = BdUtilHelper.getScreenSize(this.aUs.getPageActivity()).widthPixels;
        if (iArr != null) {
            int i8 = iArr[0] - ((i7 - this.ds120) / 2);
            int i9 = z ? ((i - 1) * (this.ds120 + this.ds20)) + this.ds28 + this.ds3 + this.ds20 : ((this.ds120 + this.ds20) * i) + this.ds28;
            int i10 = ((i4 - i) - 1) * (this.ds120 + this.ds20);
            if ((i7 - this.ds120) / 2 > i9) {
                return (((i7 - this.ds120) / 2) - i9) + i8;
            }
            return (i7 - this.ds120) / 2 > i10 ? i8 - (((i7 - this.ds120) / 2) - i10) : i8;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqc() {
        if (this.eZv != null) {
            this.eZv.dismiss();
            this.eZv = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.eZv = new BdAlertDialog((Activity) getContext());
        this.eZv.setAutoNight(false);
        this.eZv.setMessage(string);
        this.eZv.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (AlaLiveMultiBeautyArView.this.eZE != null) {
                    AlaLiveMultiBeautyArView.this.eZE.ve();
                }
                String str = com.baidu.live.ar.c.atc.asW;
                com.baidu.live.ar.c.atc.eh(com.baidu.live.ar.c.atb.toJsonString());
                com.baidu.live.ar.c.atc.asW = str;
                AlaLiveMultiBeautyArView.this.eZD = com.baidu.live.ar.c.atc;
                AlaLiveMultiBeautyArView.this.pt(AlaLiveMultiBeautyArView.this.eZD.ej(AlaLiveMultiBeautyArView.this.eZD.asW) + AlaLiveMultiBeautyArView.this.eZq);
                AlaLiveMultiBeautyArView.this.yy();
            }
        });
        this.eZv.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.yy();
            }
        });
        this.eZv.setCancelable(false);
        this.eZv.setCanceledOnTouchOutside(false);
        this.eZv.setTitleShowCenter(true);
        this.eZv.setMessageShowCenter(true);
        this.eZv.isShowTitleAndMessage();
        this.eZv.create(this.aUs);
        this.eZv.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy() {
        if (this.eZv != null) {
            this.eZv.dismiss();
            this.eZv = null;
        }
        this.eZv = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eZC && this.eZy.getWidth() != 0) {
            h(this.eZy, false);
            this.eZC = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eZy) {
            h(this.eZy, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZy);
            if (this.eZd != null) {
                setEffectFilterBeautyChooseBlock(this.eZd);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.eZF = 0;
            this.eZl.setVisibility(8);
            this.eZr.setVisibility(0);
        } else if (view == this.eZz) {
            h(this.eZz, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZz);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eZA) {
            h(this.eZA, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZA);
            setEffectFilterBeautyChooseBlock(this.eZh);
            this.eZl.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.eZF = 1;
            this.eZl.setVisibility(0);
            this.eZr.setVisibility(8);
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.eZd != null) {
            this.eZd.setVisibility(4);
        }
        if (this.eZh != null) {
            this.eZh.setVisibility(4);
        }
        this.eZx.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eZy.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZz.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZA.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eZE = hVar;
    }

    private void h(View view, boolean z) {
        this.eZB.clearAnimation();
        int width = (this.eZB.getWidth() / 2) + this.eZB.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eZB.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eZB.getWidth() / 2);
        this.eZB.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eZB.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.c.atc.eh(com.baidu.live.c.uN().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.c.atc.asU) && com.baidu.minivideo.arface.b.LQ() != null) {
            com.baidu.live.ar.c cVar = com.baidu.live.ar.c.atc;
            com.baidu.minivideo.arface.b.LQ();
            cVar.asU = com.baidu.minivideo.arface.c.LT();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.e.atf)) {
            com.baidu.minivideo.arface.b.LQ();
            com.baidu.live.ar.e.ek(com.baidu.minivideo.arface.c.LT());
        }
        this.eZD = com.baidu.live.ar.c.atc;
        bqd();
        pt(this.eZD.ej(this.eZD.asW) + this.eZq);
        this.eZi.AU(this.eZD.asW);
        this.eZi.notifyDataSetChanged();
        if (this.eZw != null && this.eZw.va() != null && this.eZw.va().asJ != null) {
            this.eZe.setDatas(this.eZw.va().asJ);
        }
        if (!TextUtils.isEmpty(this.eZD.asU)) {
            this.eZe.AT(this.eZD.asU);
        }
        this.eZe.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqd() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.eZE != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.eZi != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.eZi.eZX.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.eZi.eZX[i2].fac)) {
                            i = this.eZi.eZX[i2].fad;
                        }
                    }
                } else {
                    i = 0;
                }
                this.eZE.a(((this.eZD.ej(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS(String str) {
        this.eZG.setText(str);
        this.eZG.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eZG, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eZG, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eZG, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.eZG, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vb() {
        if (this.eZi != null) {
            this.eZi.notifyDataSetChanged();
        }
        if (this.eZe != null) {
            this.eZe.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
