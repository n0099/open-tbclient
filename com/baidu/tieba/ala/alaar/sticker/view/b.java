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
    private AlaStickerDragContentView eXQ;
    private AlaStickerDragDeletePanelView eXR;
    private c eXS;
    private a.InterfaceC0186a eXT;
    private AlaTextStickerEditView eXU;
    private DragTextView eXV;
    private com.baidu.live.g.a eXW;
    private ViewGroup eXX;
    private ViewGroup eXY;
    private ViewGroup eXZ;
    private com.baidu.live.w.b eYb;
    private Context mContext;
    private int eYa = 0;
    private int eJI = 0;
    private boolean emp = true;
    private Handler mHandler = new Handler();
    private boolean eYc = false;
    private c.a eYd = new c.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void a(FuFaceItem fuFaceItem, String str) {
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.eYc) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.eXQ != null && b.this.eXQ.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                    return;
                }
                int i = a.d.sdk_cp_cont_q;
                b.this.bpX();
                b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i);
                b.this.bpW();
            } else if (b.this.eXT != null) {
                b.this.eXT.G(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void bpZ() {
        }
    };
    private Runnable eiI = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.emp = true;
        }
    };
    private e eYe = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.emp) {
                b.this.emp = false;
                b.this.mHandler.postDelayed(b.this.eiI, 600L);
                if (view instanceof DragTextView) {
                    b.this.eXV = (DragTextView) view;
                    if (b.this.eXT != null) {
                        b.this.eXT.Gp();
                    }
                    b.this.AQ(b.this.eXV.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.eXR != null) {
                b.this.eXR.setVisibility(8);
                b.this.eXR.jf(false);
                if (((i4 - i2) / 5) + i2 < b.this.eXR.getTopDeletePanelBottom()) {
                    b.this.bt(view);
                    b.this.bpY();
                    if (b.this.eXW != null) {
                        b.this.eXW.K(view);
                    }
                } else if (b.this.eXW != null && b.this.eXW.J(view)) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_shelter);
                }
                b.this.bpW();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void v(int i, int i2, int i3, int i4) {
            if (b.this.eXR != null) {
                b.this.eXR.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.eXR.getTopDeletePanelBottom()) {
                    b.this.eXR.jf(true);
                } else {
                    b.this.eXR.jf(false);
                }
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void m(ViewGroup viewGroup) {
        this.eXX = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void n(ViewGroup viewGroup) {
        this.eXZ = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void cF(int i) {
        this.eYa = i;
    }

    @Override // com.baidu.live.w.a
    public void cG(int i) {
        this.eJI = i;
    }

    @Override // com.baidu.live.w.a
    public void setStickerCanOperate(boolean z) {
        if (this.eXQ != null) {
            this.eXQ.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.w.a
    public void o(ViewGroup viewGroup) {
        this.eXY = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.g.a aVar) {
        this.eXW = aVar;
    }

    @Override // com.baidu.live.w.a
    public void showDialog() {
        if (this.eXS == null) {
            this.eXS = new c(this.mContext, this.eYd);
        }
        this.eXS.show();
    }

    @Override // com.baidu.live.w.a
    public void bX(boolean z) {
        this.eYc = z;
    }

    @Override // com.baidu.live.w.a
    public void setLiveShowInfo(q qVar) {
        this.aJj = qVar;
    }

    @Override // com.baidu.live.w.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.eXU != null) {
                this.eXU.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eXU.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eXU.setLayoutParams(layoutParams);
                    this.eXU.setBottom(0);
                }
            }
        } else if (this.eXU != null && this.eXY != null) {
            if (this.eXY.indexOfChild(this.eXU) >= 0) {
                this.eXY.removeView(this.eXU);
            }
            this.eXU.setVisibility(8);
            this.eXV = null;
            if (this.eXT != null) {
                this.eXT.Gq();
            }
        }
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.w.a
    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.eXT = interfaceC0186a;
    }

    @Override // com.baidu.live.w.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.eiI);
        }
        if (this.eXU != null) {
            this.eXU.unRegisterListener();
            this.eXU = null;
        }
        if (this.eXS != null) {
            this.eXS.unRegisterListener();
            this.eXS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AQ(String str) {
        if (this.eXU == null) {
            this.eXU = new AlaTextStickerEditView(this.mContext);
            this.eXU.setLiveShowInfo(this.aJj);
            this.eXU.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void AR(String str2) {
                    if (!StringUtils.isNull(str2) && b.this.eXV != null) {
                        b.this.eXV.setText(str2);
                    }
                }
            });
        }
        if (this.eXY != null) {
            if (this.eXY.indexOfChild(this.eXU) >= 0) {
                this.eXY.removeView(this.eXU);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds98));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.eXY.addView(this.eXU, layoutParams);
            this.eXU.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpW() {
        if (this.eXQ != null) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.live.w.b();
            }
            this.eXQ.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.eXQ.getChildCount() <= 0 || b.this.eXQ.getVisibility() != 0) {
                        b.this.eYb.aZe = false;
                        b.this.eYb.bitmap = b.this.eXQ.getVisibleBitmap();
                    } else {
                        b.this.eYb.aZe = true;
                        b.this.eYb.bitmap = b.this.eXQ.getVisibleBitmap();
                    }
                    if (b.this.eXT != null) {
                        b.this.eXT.a(b.this.eYb);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpX() {
        if (this.eXQ == null) {
            this.eXQ = new AlaStickerDragContentView(this.mContext);
        }
        if (this.eXR == null) {
            this.eXR = new AlaStickerDragDeletePanelView(this.mContext);
            this.eXR.setVisibility(8);
        }
        if (this.eXQ.getParent() == null) {
            this.eXQ.bl(this.eXX.getWidth(), this.eXX.getHeight() - this.eJI);
            this.eXX.addView(this.eXQ, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.eXR.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.eXR.setDeleteBottomHeight(this.eJI);
            this.eXR.setTopDeletePanelHeight(this.eYa);
            this.eXZ.addView(this.eXR, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpY() {
        if (this.eXQ.getChildCount() == 0) {
            if (this.eXQ != null) {
                ((ViewGroup) this.eXQ.getParent()).removeView(this.eXQ);
            }
            if (this.eXR != null) {
                ((ViewGroup) this.eXR.getParent()).removeView(this.eXR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap, int i2) {
        if (this.eXQ != null) {
            this.eXQ.a(i, bitmap, i2, this.eYe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(View view) {
        if (this.eXQ != null) {
            this.eXQ.bu(view);
        }
    }
}
