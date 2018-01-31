package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends g implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int bEZ;
    private boolean bFa;
    private int bFb;
    private boolean bFc;
    private boolean bFd;
    private GestureDetector bFe;
    private GestureDetector bFf;
    private int bFg;
    private int bFh;
    private int bFi;
    private int[] bFj;
    private int bFk;
    private int bFl;
    private int bFm;
    private int bFn;
    private boolean bFo;
    private float bFp;
    private int bFq;
    private int bFr;
    private int bFs;
    private boolean bFt;
    private a bFu;
    private int bFv;
    private GestureDetector.OnGestureListener bFw;
    private GestureDetector mDetector;
    private ListView mListView;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.bEZ = 0;
        this.bFa = true;
        this.bFc = false;
        this.bFd = false;
        this.bFg = -1;
        this.bFh = -1;
        this.bFi = -1;
        this.bFj = new int[2];
        this.bFo = false;
        this.bFp = 500.0f;
        this.bFw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.bFc && b.this.bFd) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.bFp) {
                        if (b.this.bFv > (-width)) {
                            b.this.bFu.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.bFp) && b.this.bFv < width) {
                        b.this.bFu.stopDragWithVelocity(true, f);
                    }
                    b.this.bFd = false;
                }
                return false;
            }
        };
        this.bFu = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.bFe = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.bFu.isDragEnabled() || b.this.bFu.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.bFm = (int) motionEvent.getX();
                b.this.bFn = (int) motionEvent.getY();
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
        this.bFf = new GestureDetector(listView.getContext(), this.bFw);
        this.bFf.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.bFq = i;
        this.bFr = i4;
        this.bFs = i5;
        iD(i3);
        iC(i2);
    }

    public GestureDetector PE() {
        return this.bFe;
    }

    public void iC(int i) {
        this.bEZ = i;
    }

    public void cF(boolean z) {
        this.bFa = z;
    }

    public void iD(int i) {
        this.bFb = i;
    }

    public void cG(boolean z) {
        this.bFc = z;
    }

    public boolean x(int i, int i2, int i3) {
        int i4 = 0;
        if (this.bFa && !this.bFd) {
            i4 = 12;
        }
        if (this.bFc && this.bFd) {
            i4 = i4 | 1 | 2;
        }
        this.bFo = this.bFu.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.bFo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.bFu.isDragEnabled() && !this.bFu.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.bFc && this.bFo && this.bFb == 1) {
                this.bFf.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.bFm = (int) motionEvent.getX();
                    this.bFn = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.bFc && this.bFd) {
                        if ((this.bFv >= 0 ? this.bFv : -this.bFv) > this.mListView.getWidth() / 2) {
                            this.bFu.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.bFd = false;
                    this.bFo = false;
                    break;
                case 3:
                    this.bFd = false;
                    this.bFo = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.g, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.bFc && this.bFd) {
            this.bFv = point.x;
        }
    }

    public int x(MotionEvent motionEvent) {
        return z(motionEvent);
    }

    public int y(MotionEvent motionEvent) {
        if (this.bFb == 1) {
            return A(motionEvent);
        }
        return -1;
    }

    public int z(MotionEvent motionEvent) {
        return c(motionEvent, this.bFq);
    }

    public int A(MotionEvent motionEvent) {
        return c(motionEvent, this.bFs);
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
                findViewById.getLocationOnScreen(this.bFj);
                if (rawX > this.bFj[0] && rawY > this.bFj[1] && rawX < this.bFj[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.bFj[1]) {
                        this.bFk = childAt.getLeft();
                        this.bFl = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.bFc && this.bFb == 0) {
            this.bFi = c(motionEvent, this.bFr);
        }
        this.bFg = x(motionEvent);
        if (this.bFg != -1 && this.bEZ == 0) {
            x(this.bFg, ((int) motionEvent.getX()) - this.bFk, ((int) motionEvent.getY()) - this.bFl);
        }
        this.bFd = false;
        this.bFt = true;
        this.bFv = 0;
        this.bFh = y(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.bFk;
            int i2 = y2 - this.bFl;
            if (this.bFt && !this.bFo && (this.bFg != -1 || this.bFh != -1)) {
                if (this.bFg != -1) {
                    if (this.bEZ == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.bFa) {
                        x(this.bFg, i, i2);
                    } else if (this.bEZ != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.bFc) {
                        this.bFd = true;
                        x(this.bFh, i, i2);
                    }
                } else if (this.bFh != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.bFc) {
                        this.bFd = true;
                        x(this.bFh, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.bFt = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bFg != -1 && this.bEZ == 2) {
            this.mListView.performHapticFeedback(0);
            x(this.bFg, this.bFm - this.bFk, this.bFn - this.bFl);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bFc && this.bFb == 0 && this.bFi != -1) {
            this.bFu.removeItem(this.bFi - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
