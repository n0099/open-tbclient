package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int cHA;
    private int cHB;
    private int cHC;
    private int cHD;
    private boolean cHE;
    private float cHF;
    private int cHG;
    private int cHH;
    private int cHI;
    private boolean cHJ;
    private a cHK;
    private int cHL;
    private GestureDetector.OnGestureListener cHM;
    private int cHq;
    private boolean cHr;
    private int cHs;
    private boolean cHt;
    private boolean cHu;
    private GestureDetector cHv;
    private GestureDetector cHw;
    private int cHx;
    private int cHy;
    private int cHz;
    private GestureDetector mDetector;
    private ListView mListView;
    private int[] mTempLoc;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.cHq = 0;
        this.cHr = true;
        this.cHt = false;
        this.cHu = false;
        this.cHx = -1;
        this.cHy = -1;
        this.cHz = -1;
        this.mTempLoc = new int[2];
        this.cHE = false;
        this.cHF = 500.0f;
        this.cHM = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cHt && b.this.cHu) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cHF) {
                        if (b.this.cHL > (-width)) {
                            b.this.cHK.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cHF) && b.this.cHL < width) {
                        b.this.cHK.stopDragWithVelocity(true, f);
                    }
                    b.this.cHu = false;
                }
                return false;
            }
        };
        this.cHK = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cHv = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cHK.isDragEnabled() || b.this.cHK.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cHC = (int) motionEvent.getX();
                b.this.cHD = (int) motionEvent.getY();
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                b.this.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
        this.cHw = new GestureDetector(listView.getContext(), this.cHM);
        this.cHw.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cHG = i;
        this.cHH = i4;
        this.cHI = i5;
        lk(i3);
        lj(i2);
    }

    public GestureDetector axK() {
        return this.cHv;
    }

    public void lj(int i) {
        this.cHq = i;
    }

    public void fP(boolean z) {
        this.cHr = z;
    }

    public void lk(int i) {
        this.cHs = i;
    }

    public void fQ(boolean z) {
        this.cHt = z;
    }

    public boolean t(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cHr && !this.cHu) {
            i4 = 12;
        }
        if (this.cHt && this.cHu) {
            i4 = i4 | 1 | 2;
        }
        this.cHE = this.cHK.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cHE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cHK.isDragEnabled() && !this.cHK.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cHt && this.cHE && this.cHs == 1) {
                this.cHw.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cHC = (int) motionEvent.getX();
                    this.cHD = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cHt && this.cHu) {
                        if ((this.cHL >= 0 ? this.cHL : -this.cHL) > this.mListView.getWidth() / 2) {
                            this.cHK.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cHu = false;
                    this.cHE = false;
                    break;
                case 3:
                    this.cHu = false;
                    this.cHE = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cHt && this.cHu) {
            this.cHL = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cHs == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cHG);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cHI);
    }

    public int c(MotionEvent motionEvent, int i) {
        int pointToPosition = this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int count = this.mListView.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.mListView.getChildAt(pointToPosition - this.mListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[0] && rawY > this.mTempLoc[1] && rawX < this.mTempLoc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.mTempLoc[1]) {
                        this.cHA = childAt.getLeft();
                        this.cHB = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cHt && this.cHs == 0) {
            this.cHz = c(motionEvent, this.cHH);
        }
        this.cHx = z(motionEvent);
        if (this.cHx != -1 && this.cHq == 0) {
            t(this.cHx, ((int) motionEvent.getX()) - this.cHA, ((int) motionEvent.getY()) - this.cHB);
        }
        this.cHu = false;
        this.cHJ = true;
        this.cHL = 0;
        this.cHy = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cHA;
            int i2 = y2 - this.cHB;
            if (this.cHJ && !this.cHE && (this.cHx != -1 || this.cHy != -1)) {
                if (this.cHx != -1) {
                    if (this.cHq == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cHr) {
                        t(this.cHx, i, i2);
                    } else if (this.cHq != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cHt) {
                        this.cHu = true;
                        t(this.cHy, i, i2);
                    }
                } else if (this.cHy != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cHt) {
                        this.cHu = true;
                        t(this.cHy, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cHJ = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cHx != -1 && this.cHq == 2) {
            this.mListView.performHapticFeedback(0);
            t(this.cHx, this.cHC - this.cHA, this.cHD - this.cHB);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cHt && this.cHs == 0 && this.cHz != -1) {
            this.cHK.removeItem(this.cHz - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
