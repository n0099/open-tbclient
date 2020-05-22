package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.live.w.a;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
import com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView;
import com.baidu.tieba.ala.alaar.sticker.view.c;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.w.a {
    private q aJj;
    private AlaStickerDragContentView eXF;
    private AlaStickerDragDeletePanelView eXG;
    private c eXH;
    private a.InterfaceC0186a eXI;
    private AlaTextStickerEditView eXJ;
    private DragTextView eXK;
    private com.baidu.live.g.a eXL;
    private ViewGroup eXM;
    private ViewGroup eXN;
    private ViewGroup eXO;
    private com.baidu.live.w.b eXQ;
    private Context mContext;
    private int eXP = 0;
    private int eJx = 0;
    private boolean emp = true;
    private Handler mHandler = new Handler();
    private boolean eXR = false;
    private c.a eXS = new c.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void a(FuFaceItem fuFaceItem, String str) {
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.eXR) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.eXF != null && b.this.eXF.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                    return;
                }
                int i = a.d.sdk_cp_cont_q;
                b.this.bpV();
                b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i);
                b.this.bpU();
            } else if (b.this.eXI != null) {
                b.this.eXI.G(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void bpX() {
        }
    };
    private Runnable eiI = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.emp = true;
        }
    };
    private e eXT = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.emp) {
                b.this.emp = false;
                b.this.mHandler.postDelayed(b.this.eiI, 600L);
                if (view instanceof DragTextView) {
                    b.this.eXK = (DragTextView) view;
                    if (b.this.eXI != null) {
                        b.this.eXI.Gp();
                    }
                    b.this.AQ(b.this.eXK.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.eXG != null) {
                b.this.eXG.setVisibility(8);
                b.this.eXG.jf(false);
                if (((i4 - i2) / 5) + i2 < b.this.eXG.getTopDeletePanelBottom()) {
                    b.this.bt(view);
                    b.this.bpW();
                    if (b.this.eXL != null) {
                        b.this.eXL.K(view);
                    }
                } else if (b.this.eXL != null && b.this.eXL.J(view)) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_shelter);
                }
                b.this.bpU();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void v(int i, int i2, int i3, int i4) {
            if (b.this.eXG != null) {
                b.this.eXG.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.eXG.getTopDeletePanelBottom()) {
                    b.this.eXG.jf(true);
                } else {
                    b.this.eXG.jf(false);
                }
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void m(ViewGroup viewGroup) {
        this.eXM = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void n(ViewGroup viewGroup) {
        this.eXO = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void cD(int i) {
        this.eXP = i;
    }

    @Override // com.baidu.live.w.a
    public void cE(int i) {
        this.eJx = i;
    }

    @Override // com.baidu.live.w.a
    public void setStickerCanOperate(boolean z) {
        if (this.eXF != null) {
            this.eXF.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.w.a
    public void o(ViewGroup viewGroup) {
        this.eXN = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.g.a aVar) {
        this.eXL = aVar;
    }

    @Override // com.baidu.live.w.a
    public void showDialog() {
        if (this.eXH == null) {
            this.eXH = new c(this.mContext, this.eXS);
        }
        this.eXH.show();
    }

    @Override // com.baidu.live.w.a
    public void bX(boolean z) {
        this.eXR = z;
    }

    @Override // com.baidu.live.w.a
    public void setLiveShowInfo(q qVar) {
        this.aJj = qVar;
    }

    @Override // com.baidu.live.w.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.eXJ != null) {
                this.eXJ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eXJ.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eXJ.setLayoutParams(layoutParams);
                    this.eXJ.setBottom(0);
                }
            }
        } else if (this.eXJ != null && this.eXN != null) {
            if (this.eXN.indexOfChild(this.eXJ) >= 0) {
                this.eXN.removeView(this.eXJ);
            }
            this.eXJ.setVisibility(8);
            this.eXK = null;
            if (this.eXI != null) {
                this.eXI.Gq();
            }
        }
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.w.a
    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.eXI = interfaceC0186a;
    }

    @Override // com.baidu.live.w.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eiI);
        }
        if (this.eXJ != null) {
            this.eXJ.unRegisterListener();
            this.eXJ = null;
        }
        if (this.eXH != null) {
            this.eXH.unRegisterListener();
            this.eXH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AQ(String str) {
        if (this.eXJ == null) {
            this.eXJ = new AlaTextStickerEditView(this.mContext);
            this.eXJ.setLiveShowInfo(this.aJj);
            this.eXJ.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void AR(String str2) {
                    if (!StringUtils.isNull(str2) && b.this.eXK != null) {
                        b.this.eXK.setText(str2);
                    }
                }
            });
        }
        if (this.eXN != null) {
            if (this.eXN.indexOfChild(this.eXJ) >= 0) {
                this.eXN.removeView(this.eXJ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds98));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.eXN.addView(this.eXJ, layoutParams);
            this.eXJ.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpU() {
        if (this.eXF != null) {
            if (this.eXQ == null) {
                this.eXQ = new com.baidu.live.w.b();
            }
            this.eXF.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.eXF.getChildCount() <= 0 || b.this.eXF.getVisibility() != 0) {
                        b.this.eXQ.aZe = false;
                        b.this.eXQ.bitmap = b.this.eXF.getVisibleBitmap();
                    } else {
                        b.this.eXQ.aZe = true;
                        b.this.eXQ.bitmap = b.this.eXF.getVisibleBitmap();
                    }
                    if (b.this.eXI != null) {
                        b.this.eXI.a(b.this.eXQ);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpV() {
        if (this.eXF == null) {
            this.eXF = new AlaStickerDragContentView(this.mContext);
        }
        if (this.eXG == null) {
            this.eXG = new AlaStickerDragDeletePanelView(this.mContext);
            this.eXG.setVisibility(8);
        }
        if (this.eXF.getParent() == null) {
            this.eXF.bl(this.eXM.getWidth(), this.eXM.getHeight() - this.eJx);
            this.eXM.addView(this.eXF, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.eXG.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.eXG.setDeleteBottomHeight(this.eJx);
            this.eXG.setTopDeletePanelHeight(this.eXP);
            this.eXO.addView(this.eXG, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpW() {
        if (this.eXF.getChildCount() == 0) {
            if (this.eXF != null) {
                ((ViewGroup) this.eXF.getParent()).removeView(this.eXF);
            }
            if (this.eXG != null) {
                ((ViewGroup) this.eXG.getParent()).removeView(this.eXG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap, int i2) {
        if (this.eXF != null) {
            this.eXF.a(i, bitmap, i2, this.eXT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(View view) {
        if (this.eXF != null) {
            this.eXF.bu(view);
        }
    }
}
