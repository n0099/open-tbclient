package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes10.dex */
public class DragTextView extends TextView {
    private float bIH;
    private float cBP;
    private float duh;
    private int gsA;
    private int gsB;
    private e gsC;
    private GestureDetector gsD;
    private boolean gsE;
    private boolean gsF;
    private TbImageView gsG;
    private final int gsH;
    private int gsI;
    private int gsJ;
    private boolean gsK;
    private float gsL;
    private float gsM;
    private CharSequence gsN;
    int gsO;
    int gsP;
    int gsQ;
    private GestureDetector.OnGestureListener gsR;
    private int gsv;
    private int gsw;
    private int gsx;
    private int gsy;
    private int gsz;
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
        this.gsE = false;
        this.gsF = true;
        this.gsH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gsI = this.gsH;
        this.gsJ = this.gsH;
        this.gsK = false;
        this.type = 2;
        this.gsR = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gsK = true;
                if (DragTextView.this.gsC != null && DragTextView.this.gsE) {
                    DragTextView.this.gsC.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gsK = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
                if (DragTextView.this.gsC != null) {
                    DragTextView.this.gsC.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gsK = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gsE = false;
        this.gsF = true;
        this.gsH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gsI = this.gsH;
        this.gsJ = this.gsH;
        this.gsK = false;
        this.type = 2;
        this.gsR = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gsK = true;
                if (DragTextView.this.gsC != null && DragTextView.this.gsE) {
                    DragTextView.this.gsC.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gsK = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
                if (DragTextView.this.gsC != null) {
                    DragTextView.this.gsC.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gsK = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gsE = false;
        this.gsF = true;
        this.gsH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gsI = this.gsH;
        this.gsJ = this.gsH;
        this.gsK = false;
        this.type = 2;
        this.gsR = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gsK = true;
                if (DragTextView.this.gsC != null && DragTextView.this.gsE) {
                    DragTextView.this.gsC.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gsK = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gsK = false;
                if (DragTextView.this.gsC != null) {
                    DragTextView.this.gsC.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gsK = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gsv = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.gsD = new GestureDetector(context, this.gsR);
        this.gsO = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.gsP = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.gsQ = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.gsE = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.gsF = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.gsA = this.gsP;
        } else {
            this.gsA = this.gsO;
        }
        this.gsB = this.gsQ;
        this.gsw = i;
        this.gsy = i3;
        this.gsx = i2;
        this.gsz = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.gsI = i;
        this.gsJ = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gsF) {
            return super.onTouchEvent(motionEvent);
        }
        this.gsD.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.gsK = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cBP = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.duh = getX();
                    this.bIH = getY();
                    if (this.gsC != null && this.gsC.bPG()) {
                        this.gsL = getTranslationX();
                        this.gsM = getTranslationY();
                        this.gsN = getText();
                    }
                    if (this.gsC != null) {
                        this.gsC.bPF();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.gsC != null && !this.gsK) {
                    this.gsC.g(this, (int) this.duh, (int) this.bIH, getWidth() + ((int) this.duh), getHeight() + ((int) this.bIH));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.gsC == null || this.gsC.bPG())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i = this.gsx;
                        int i2 = this.gsw - this.gsA;
                        int i3 = this.gsy + this.gsA;
                        int i4 = this.gsy - this.gsI;
                        int i5 = (this.gsz - this.gsJ) + this.gsB;
                        int i6 = this.gsB + this.gsz;
                        int i7 = i4 - this.gsA;
                        if (y < i) {
                            height = getHeight() + i;
                        } else {
                            i = y;
                        }
                        if (x < i2) {
                            width = getWidth() + i2;
                        } else {
                            i2 = x;
                        }
                        if (width > i3) {
                            i2 = i3 - getWidth();
                        } else {
                            i3 = width;
                        }
                        if (height > i6) {
                            i = i6 - getHeight();
                        } else {
                            i6 = height;
                        }
                        if (i3 < i4 && i6 > i5) {
                            i = i5 - getHeight();
                            i6 = i5;
                        }
                        if (i2 >= i7 || i6 <= i5) {
                            i7 = i2;
                        } else {
                            int width2 = getWidth() + i7;
                        }
                        this.duh = i7;
                        this.bIH = i;
                        setTranslationX(i7);
                        setTranslationY(i);
                        setAlpha(0.7f);
                        if (this.gsC != null) {
                            this.gsC.C((int) this.duh, (int) this.bIH, ((int) this.duh) + getWidth(), ((int) this.bIH) + getHeight());
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
        if (this.gsG == null) {
            this.gsG = new TbImageView(getContext());
        }
        this.gsG.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.gsv || abs2 > this.gsv) {
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cBP);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.gsC = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bPO() {
        setTranslationX(this.gsL);
        setTranslationY(this.gsM);
        if (this.type == 2) {
            setText(this.gsN);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
