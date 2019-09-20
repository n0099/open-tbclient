package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private boolean cIA;
    private a cIB;
    private int cIC;
    private GestureDetector.OnGestureListener cID;
    private int cIh;
    private boolean cIi;
    private int cIj;
    private boolean cIk;
    private boolean cIl;
    private GestureDetector cIm;
    private GestureDetector cIn;
    private int cIo;
    private int cIp;
    private int cIq;
    private int cIr;
    private int cIs;
    private int cIt;
    private int cIu;
    private boolean cIv;
    private float cIw;
    private int cIx;
    private int cIy;
    private int cIz;
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
        this.cIh = 0;
        this.cIi = true;
        this.cIk = false;
        this.cIl = false;
        this.cIo = -1;
        this.cIp = -1;
        this.cIq = -1;
        this.mTempLoc = new int[2];
        this.cIv = false;
        this.cIw = 500.0f;
        this.cID = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.cIk && b.this.cIl) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.cIw) {
                        if (b.this.cIC > (-width)) {
                            b.this.cIB.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.cIw) && b.this.cIC < width) {
                        b.this.cIB.stopDragWithVelocity(true, f);
                    }
                    b.this.cIl = false;
                }
                return false;
            }
        };
        this.cIB = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.cIm = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.cIB.isDragEnabled() || b.this.cIB.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.cIt = (int) motionEvent.getX();
                b.this.cIu = (int) motionEvent.getY();
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
        this.cIn = new GestureDetector(listView.getContext(), this.cID);
        this.cIn.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.cIx = i;
        this.cIy = i4;
        this.cIz = i5;
        lo(i3);
        ln(i2);
    }

    public GestureDetector axW() {
        return this.cIm;
    }

    public void ln(int i) {
        this.cIh = i;
    }

    public void fS(boolean z) {
        this.cIi = z;
    }

    public void lo(int i) {
        this.cIj = i;
    }

    public void fT(boolean z) {
        this.cIk = z;
    }

    public boolean u(int i, int i2, int i3) {
        int i4 = 0;
        if (this.cIi && !this.cIl) {
            i4 = 12;
        }
        if (this.cIk && this.cIl) {
            i4 = i4 | 1 | 2;
        }
        this.cIv = this.cIB.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.cIv;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.cIB.isDragEnabled() && !this.cIB.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.cIk && this.cIv && this.cIj == 1) {
                this.cIn.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.cIt = (int) motionEvent.getX();
                    this.cIu = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.cIk && this.cIl) {
                        if ((this.cIC >= 0 ? this.cIC : -this.cIC) > this.mListView.getWidth() / 2) {
                            this.cIB.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.cIl = false;
                    this.cIv = false;
                    break;
                case 3:
                    this.cIl = false;
                    this.cIv = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.cIk && this.cIl) {
            this.cIC = point.x;
        }
    }

    public int z(MotionEvent motionEvent) {
        return B(motionEvent);
    }

    public int A(MotionEvent motionEvent) {
        if (this.cIj == 1) {
            return C(motionEvent);
        }
        return -1;
    }

    public int B(MotionEvent motionEvent) {
        return c(motionEvent, this.cIx);
    }

    public int C(MotionEvent motionEvent) {
        return c(motionEvent, this.cIz);
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
                        this.cIr = childAt.getLeft();
                        this.cIs = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.cIk && this.cIj == 0) {
            this.cIq = c(motionEvent, this.cIy);
        }
        this.cIo = z(motionEvent);
        if (this.cIo != -1 && this.cIh == 0) {
            u(this.cIo, ((int) motionEvent.getX()) - this.cIr, ((int) motionEvent.getY()) - this.cIs);
        }
        this.cIl = false;
        this.cIA = true;
        this.cIC = 0;
        this.cIp = A(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.cIr;
            int i2 = y2 - this.cIs;
            if (this.cIA && !this.cIv && (this.cIo != -1 || this.cIp != -1)) {
                if (this.cIo != -1) {
                    if (this.cIh == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.cIi) {
                        u(this.cIo, i, i2);
                    } else if (this.cIh != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.cIk) {
                        this.cIl = true;
                        u(this.cIp, i, i2);
                    }
                } else if (this.cIp != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.cIk) {
                        this.cIl = true;
                        u(this.cIp, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.cIA = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.cIo != -1 && this.cIh == 2) {
            this.mListView.performHapticFeedback(0);
            u(this.cIo, this.cIt - this.cIr, this.cIu - this.cIs);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.cIk && this.cIj == 0 && this.cIq != -1) {
            this.cIB.removeItem(this.cIq - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
