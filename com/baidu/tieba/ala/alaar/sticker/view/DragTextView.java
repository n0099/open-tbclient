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
    private float bVQ;
    private float bsV;
    private float cNy;
    private int fDA;
    private e fDB;
    private GestureDetector fDC;
    private boolean fDD;
    private boolean fDE;
    private TbImageView fDF;
    private final int fDG;
    private int fDH;
    private int fDI;
    private boolean fDJ;
    private float fDK;
    private float fDL;
    private CharSequence fDM;
    int fDN;
    int fDO;
    int fDP;
    private GestureDetector.OnGestureListener fDQ;
    private int fDu;
    private int fDv;
    private int fDw;
    private int fDx;
    private int fDy;
    private int fDz;
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
        this.fDD = false;
        this.fDE = true;
        this.fDG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fDH = this.fDG;
        this.fDI = this.fDG;
        this.fDJ = false;
        this.type = 2;
        this.fDQ = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fDJ = true;
                if (DragTextView.this.fDB != null && DragTextView.this.fDD) {
                    DragTextView.this.fDB.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fDJ = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
                if (DragTextView.this.fDB != null) {
                    DragTextView.this.fDB.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fDJ = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fDD = false;
        this.fDE = true;
        this.fDG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fDH = this.fDG;
        this.fDI = this.fDG;
        this.fDJ = false;
        this.type = 2;
        this.fDQ = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fDJ = true;
                if (DragTextView.this.fDB != null && DragTextView.this.fDD) {
                    DragTextView.this.fDB.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fDJ = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
                if (DragTextView.this.fDB != null) {
                    DragTextView.this.fDB.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fDJ = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fDD = false;
        this.fDE = true;
        this.fDG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fDH = this.fDG;
        this.fDI = this.fDG;
        this.fDJ = false;
        this.type = 2;
        this.fDQ = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fDJ = true;
                if (DragTextView.this.fDB != null && DragTextView.this.fDD) {
                    DragTextView.this.fDB.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fDJ = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fDJ = false;
                if (DragTextView.this.fDB != null) {
                    DragTextView.this.fDB.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fDJ = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fDu = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.fDC = new GestureDetector(context, this.fDQ);
        this.fDN = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.fDO = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.fDP = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.fDD = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.fDE = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.fDz = this.fDO;
        } else {
            this.fDz = this.fDN;
        }
        this.fDA = this.fDP;
        this.fDv = i;
        this.fDx = i3;
        this.fDw = i2;
        this.fDy = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.fDH = i;
        this.fDI = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.fDE) {
            return super.onTouchEvent(motionEvent);
        }
        this.fDC.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.fDJ = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.bVQ = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.cNy = getX();
                    this.bsV = getY();
                    if (this.fDB != null && this.fDB.bGj()) {
                        this.fDK = getTranslationX();
                        this.fDL = getTranslationY();
                        this.fDM = getText();
                    }
                    if (this.fDB != null) {
                        this.fDB.bGi();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.fDB != null && !this.fDJ) {
                    this.fDB.e(this, (int) this.cNy, (int) this.bsV, getWidth() + ((int) this.cNy), getHeight() + ((int) this.bsV));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.fDB == null || this.fDB.bGj())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i3 = this.fDw;
                        int i4 = this.fDv - this.fDz;
                        int i5 = this.fDz + this.fDx;
                        int i6 = this.fDx - this.fDH;
                        int i7 = (this.fDy - this.fDI) + this.fDA;
                        int i8 = this.fDA + this.fDy;
                        int i9 = i6 - this.fDz;
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
                        this.cNy = i9;
                        this.bsV = i2;
                        setTranslationX(i9);
                        setTranslationY(i2);
                        setAlpha(0.7f);
                        if (this.fDB != null) {
                            this.fDB.w((int) this.cNy, (int) this.bsV, ((int) this.cNy) + getWidth(), ((int) this.bsV) + getHeight());
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
        if (this.fDF == null) {
            this.fDF = new TbImageView(getContext());
        }
        this.fDF.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.fDu || abs2 > this.fDu) {
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.bVQ);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.fDB = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bGr() {
        setTranslationX(this.fDK);
        setTranslationY(this.fDL);
        if (this.type == 2) {
            setText(this.fDM);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
