package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes4.dex */
public class DragTextView extends TextView {
    private float bke;
    private float cDf;
    private int foH;
    private int foI;
    private int foJ;
    private int foK;
    private int foL;
    private int foM;
    private int foN;
    private e foO;
    private GestureDetector foP;
    private boolean foQ;
    private boolean foR;
    private TbImageView foS;
    private final int foT;
    private int foU;
    private int foV;
    private boolean foW;
    private float foX;
    private float foY;
    private CharSequence foZ;
    int fpa;
    int fpb;
    int fpc;
    private GestureDetector.OnGestureListener fpd;
    private int mActivePointerId;
    private float mDownX;
    private float mDownY;
    private boolean mIsSilding;
    private float mLastMotionX;
    private float mLastMotionY;
    private int type;

    public DragTextView(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.foQ = false;
        this.foR = true;
        this.foT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.foU = this.foT;
        this.foV = this.foT;
        this.foW = false;
        this.type = 2;
        this.fpd = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.foW = true;
                if (DragTextView.this.foO != null && DragTextView.this.foQ) {
                    DragTextView.this.foO.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.foW = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
                if (DragTextView.this.foO != null) {
                    DragTextView.this.foO.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.foW = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.foQ = false;
        this.foR = true;
        this.foT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.foU = this.foT;
        this.foV = this.foT;
        this.foW = false;
        this.type = 2;
        this.fpd = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.foW = true;
                if (DragTextView.this.foO != null && DragTextView.this.foQ) {
                    DragTextView.this.foO.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.foW = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
                if (DragTextView.this.foO != null) {
                    DragTextView.this.foO.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.foW = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.foQ = false;
        this.foR = true;
        this.foT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.foU = this.foT;
        this.foV = this.foT;
        this.foW = false;
        this.type = 2;
        this.fpd = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.foW = true;
                if (DragTextView.this.foO != null && DragTextView.this.foQ) {
                    DragTextView.this.foO.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.foW = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.foW = false;
                if (DragTextView.this.foO != null) {
                    DragTextView.this.foO.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.foW = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.foH = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.foP = new GestureDetector(context, this.fpd);
        this.fpa = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.fpb = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.fpc = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.foQ = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.foR = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.foM = this.fpb;
        } else {
            this.foM = this.fpa;
        }
        this.foN = this.fpc;
        this.foI = i;
        this.foK = i3;
        this.foJ = i2;
        this.foL = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.foU = i;
        this.foV = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.foR) {
            return super.onTouchEvent(motionEvent);
        }
        this.foP.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.foW = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mDownY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.cDf = getX();
                    this.bke = getY();
                    if (this.foO != null && this.foO.bvX()) {
                        this.foX = getTranslationX();
                        this.foY = getTranslationY();
                        this.foZ = getText();
                    }
                    if (this.foO != null) {
                        this.foO.bvW();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.foO != null && !this.foW) {
                    this.foO.e(this, (int) this.cDf, (int) this.bke, getWidth() + ((int) this.cDf), getHeight() + ((int) this.bke));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.foO == null || this.foO.bvX())) {
                        int diffX = getDiffX(motionEvent);
                        int x = x(motionEvent);
                        int x2 = ((int) getX()) + diffX;
                        int y = ((int) getY()) + x;
                        int width = x2 + getWidth();
                        int height = y + getHeight();
                        int i3 = this.foJ;
                        int i4 = this.foI - this.foM;
                        int i5 = this.foM + this.foK;
                        int i6 = this.foK - this.foU;
                        int i7 = (this.foL - this.foV) + this.foN;
                        int i8 = this.foN + this.foL;
                        int i9 = i6 - this.foM;
                        if (y < i3) {
                            height = getHeight() + i3;
                        } else {
                            i3 = y;
                        }
                        if (x2 < i4) {
                            width = getWidth() + i4;
                        } else {
                            i4 = x2;
                        }
                        if (width > i5) {
                            i = i5 - getWidth();
                            width = i5;
                        } else {
                            i = i4;
                        }
                        if (height > i8) {
                            i2 = i8 - getHeight();
                        } else {
                            i8 = height;
                            i2 = i3;
                        }
                        if (width < i6 && i8 > i7) {
                            i2 = i7 - getHeight();
                            i8 = i7;
                        }
                        if (i >= i9 || i8 <= i7) {
                            i9 = i;
                        } else {
                            int width2 = getWidth() + i9;
                        }
                        this.cDf = i9;
                        this.bke = i2;
                        setTranslationX(i9);
                        setTranslationY(i2);
                        setAlpha(0.7f);
                        if (this.foO != null) {
                            this.foO.w((int) this.cDf, (int) this.bke, ((int) this.cDf) + getWidth(), ((int) this.bke) + getHeight());
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    public void setBackground(PicStickerItem picStickerItem) {
        if (this.foS == null) {
            this.foS = new TbImageView(getContext());
        }
        this.foS.startLoad(picStickerItem.url, 10, false);
    }

    private void endDrag() {
        this.mIsSilding = false;
        this.mActivePointerId = -1;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!isInvalidEvent(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (abs > this.foH || abs2 > this.foH) {
                this.mIsSilding = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private int getDiffX(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private int x(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.mDownY);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.foO = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bwc() {
        setTranslationX(this.foX);
        setTranslationY(this.foY);
        if (this.type == 2) {
            setText(this.foZ);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
