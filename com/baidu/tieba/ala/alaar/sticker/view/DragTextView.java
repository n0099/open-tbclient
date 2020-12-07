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
    private float bIF;
    private float cBL;
    private float dtt;
    private int gmD;
    private int gmE;
    private int gmF;
    private int gmG;
    private int gmH;
    private int gmI;
    private int gmJ;
    private e gmK;
    private GestureDetector gmL;
    private boolean gmM;
    private boolean gmN;
    private TbImageView gmO;
    private final int gmP;
    private int gmQ;
    private int gmR;
    private boolean gmS;
    private float gmT;
    private float gmU;
    private CharSequence gmV;
    int gmW;
    int gmX;
    int gmY;
    private GestureDetector.OnGestureListener gmZ;
    private int mActivePointerId;
    private float mDownX;
    private boolean mIsSilding;
    private float mLastMotionX;
    private float mLastMotionY;
    private int type;

    public DragTextView(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gmM = false;
        this.gmN = true;
        this.gmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gmQ = this.gmP;
        this.gmR = this.gmP;
        this.gmS = false;
        this.type = 2;
        this.gmZ = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gmS = true;
                if (DragTextView.this.gmK != null && DragTextView.this.gmM) {
                    DragTextView.this.gmK.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gmS = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
                if (DragTextView.this.gmK != null) {
                    DragTextView.this.gmK.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gmS = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gmM = false;
        this.gmN = true;
        this.gmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gmQ = this.gmP;
        this.gmR = this.gmP;
        this.gmS = false;
        this.type = 2;
        this.gmZ = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gmS = true;
                if (DragTextView.this.gmK != null && DragTextView.this.gmM) {
                    DragTextView.this.gmK.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gmS = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
                if (DragTextView.this.gmK != null) {
                    DragTextView.this.gmK.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gmS = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gmM = false;
        this.gmN = true;
        this.gmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gmQ = this.gmP;
        this.gmR = this.gmP;
        this.gmS = false;
        this.type = 2;
        this.gmZ = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gmS = true;
                if (DragTextView.this.gmK != null && DragTextView.this.gmM) {
                    DragTextView.this.gmK.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gmS = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gmS = false;
                if (DragTextView.this.gmK != null) {
                    DragTextView.this.gmK.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gmS = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gmD = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.gmL = new GestureDetector(context, this.gmZ);
        this.gmW = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.gmX = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.gmY = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.gmM = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.gmN = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.gmI = this.gmX;
        } else {
            this.gmI = this.gmW;
        }
        this.gmJ = this.gmY;
        this.gmE = i;
        this.gmG = i3;
        this.gmF = i2;
        this.gmH = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.gmQ = i;
        this.gmR = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.gmN) {
            return super.onTouchEvent(motionEvent);
        }
        this.gmL.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.gmS = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cBL = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.dtt = getX();
                    this.bIF = getY();
                    if (this.gmK != null && this.gmK.bQY()) {
                        this.gmT = getTranslationX();
                        this.gmU = getTranslationY();
                        this.gmV = getText();
                    }
                    if (this.gmK != null) {
                        this.gmK.bQX();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.gmK != null && !this.gmS) {
                    this.gmK.e(this, (int) this.dtt, (int) this.bIF, getWidth() + ((int) this.dtt), getHeight() + ((int) this.bIF));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.gmK == null || this.gmK.bQY())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i3 = this.gmF;
                        int i4 = this.gmE - this.gmI;
                        int i5 = this.gmI + this.gmG;
                        int i6 = this.gmG - this.gmQ;
                        int i7 = (this.gmH - this.gmR) + this.gmJ;
                        int i8 = this.gmJ + this.gmH;
                        int i9 = i6 - this.gmI;
                        if (y < i3) {
                            height = getHeight() + i3;
                        } else {
                            i3 = y;
                        }
                        if (x < i4) {
                            width = getWidth() + i4;
                        } else {
                            i4 = x;
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
                        this.dtt = i9;
                        this.bIF = i2;
                        setTranslationX(i9);
                        setTranslationY(i2);
                        setAlpha(0.7f);
                        if (this.gmK != null) {
                            this.gmK.B((int) this.dtt, (int) this.bIF, ((int) this.dtt) + getWidth(), ((int) this.bIF) + getHeight());
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
        if (this.gmO == null) {
            this.gmO = new TbImageView(getContext());
        }
        this.gmO.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.gmD || abs2 > this.gmD) {
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

    private int M(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cBL);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.gmK = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bRg() {
        setTranslationX(this.gmT);
        setTranslationY(this.gmU);
        if (this.type == 2) {
            setText(this.gmV);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
