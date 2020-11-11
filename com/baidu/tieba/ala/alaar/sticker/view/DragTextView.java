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
    private float bFi;
    private float cwD;
    private float dnY;
    private int geO;
    private int geP;
    private int geQ;
    private int geR;
    private int geS;
    private int geT;
    private int geU;
    private e geV;
    private GestureDetector geW;
    private boolean geX;
    private boolean geY;
    private TbImageView geZ;
    private final int gfa;
    private int gfb;
    private int gfc;
    private boolean gfd;
    private float gfe;
    private float gff;
    private CharSequence gfg;
    int gfh;
    int gfi;
    int gfj;
    private GestureDetector.OnGestureListener gfk;
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
        this.geX = false;
        this.geY = true;
        this.gfa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gfb = this.gfa;
        this.gfc = this.gfa;
        this.gfd = false;
        this.type = 2;
        this.gfk = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gfd = true;
                if (DragTextView.this.geV != null && DragTextView.this.geX) {
                    DragTextView.this.geV.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gfd = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
                if (DragTextView.this.geV != null) {
                    DragTextView.this.geV.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gfd = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.geX = false;
        this.geY = true;
        this.gfa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gfb = this.gfa;
        this.gfc = this.gfa;
        this.gfd = false;
        this.type = 2;
        this.gfk = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gfd = true;
                if (DragTextView.this.geV != null && DragTextView.this.geX) {
                    DragTextView.this.geV.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gfd = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
                if (DragTextView.this.geV != null) {
                    DragTextView.this.geV.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gfd = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.geX = false;
        this.geY = true;
        this.gfa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gfb = this.gfa;
        this.gfc = this.gfa;
        this.gfd = false;
        this.type = 2;
        this.gfk = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gfd = true;
                if (DragTextView.this.geV != null && DragTextView.this.geX) {
                    DragTextView.this.geV.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gfd = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gfd = false;
                if (DragTextView.this.geV != null) {
                    DragTextView.this.geV.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gfd = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.geO = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.geW = new GestureDetector(context, this.gfk);
        this.gfh = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.gfi = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.gfj = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.geX = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.geY = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.geT = this.gfi;
        } else {
            this.geT = this.gfh;
        }
        this.geU = this.gfj;
        this.geP = i;
        this.geR = i3;
        this.geQ = i2;
        this.geS = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.gfb = i;
        this.gfc = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.geY) {
            return super.onTouchEvent(motionEvent);
        }
        this.geW.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.gfd = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cwD = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.dnY = getX();
                    this.bFi = getY();
                    if (this.geV != null && this.geV.bNU()) {
                        this.gfe = getTranslationX();
                        this.gff = getTranslationY();
                        this.gfg = getText();
                    }
                    if (this.geV != null) {
                        this.geV.bNT();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.geV != null && !this.gfd) {
                    this.geV.e(this, (int) this.dnY, (int) this.bFi, getWidth() + ((int) this.dnY), getHeight() + ((int) this.bFi));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.geV == null || this.geV.bNU())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i3 = this.geQ;
                        int i4 = this.geP - this.geT;
                        int i5 = this.geT + this.geR;
                        int i6 = this.geR - this.gfb;
                        int i7 = (this.geS - this.gfc) + this.geU;
                        int i8 = this.geU + this.geS;
                        int i9 = i6 - this.geT;
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
                        this.dnY = i9;
                        this.bFi = i2;
                        setTranslationX(i9);
                        setTranslationY(i2);
                        setAlpha(0.7f);
                        if (this.geV != null) {
                            this.geV.w((int) this.dnY, (int) this.bFi, ((int) this.dnY) + getWidth(), ((int) this.bFi) + getHeight());
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
        if (this.geZ == null) {
            this.geZ = new TbImageView(getContext());
        }
        this.geZ.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.geO || abs2 > this.geO) {
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cwD);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.geV = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bOc() {
        setTranslationX(this.gfe);
        setTranslationY(this.gff);
        if (this.type == 2) {
            setText(this.gfg);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
