package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int aRA;
    private int aRB;
    private int aRC;
    private int[] aRD;
    private int aRE;
    private int aRF;
    private int aRG;
    private int aRH;
    private boolean aRI;
    private float aRJ;
    private int aRK;
    private int aRL;
    private int aRM;
    private boolean aRN;
    private a aRO;
    private int aRP;
    private GestureDetector.OnGestureListener aRQ;
    private int aRt;
    private boolean aRu;
    private int aRv;
    private boolean aRw;
    private boolean aRx;
    private GestureDetector aRy;
    private GestureDetector aRz;
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
        this.aRt = 0;
        this.aRu = true;
        this.aRw = false;
        this.aRx = false;
        this.aRA = -1;
        this.aRB = -1;
        this.aRC = -1;
        this.aRD = new int[2];
        this.aRI = false;
        this.aRJ = 500.0f;
        this.aRQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.aRw && b.this.aRx) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.aRJ) {
                        if (b.this.aRP > (-width)) {
                            b.this.aRO.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.aRJ) && b.this.aRP < width) {
                        b.this.aRO.stopDragWithVelocity(true, f);
                    }
                    b.this.aRx = false;
                }
                return false;
            }
        };
        this.aRO = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.aRy = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.aRO.isDragEnabled() || b.this.aRO.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.aRG = (int) motionEvent.getX();
                b.this.aRH = (int) motionEvent.getY();
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
        this.aRz = new GestureDetector(listView.getContext(), this.aRQ);
        this.aRz.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.aRK = i;
        this.aRL = i4;
        this.aRM = i5;
        fB(i3);
        fA(i2);
    }

    public GestureDetector IK() {
        return this.aRy;
    }

    public void fA(int i) {
        this.aRt = i;
    }

    public void cb(boolean z) {
        this.aRu = z;
    }

    public void fB(int i) {
        this.aRv = i;
    }

    public void cc(boolean z) {
        this.aRw = z;
    }

    public boolean n(int i, int i2, int i3) {
        int i4 = 0;
        if (this.aRu && !this.aRx) {
            i4 = 12;
        }
        if (this.aRw && this.aRx) {
            i4 = i4 | 1 | 2;
        }
        this.aRI = this.aRO.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.aRI;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.aRO.isDragEnabled() && !this.aRO.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.aRw && this.aRI && this.aRv == 1) {
                this.aRz.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aRG = (int) motionEvent.getX();
                    this.aRH = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.aRw && this.aRx) {
                        if ((this.aRP >= 0 ? this.aRP : -this.aRP) > this.mListView.getWidth() / 2) {
                            this.aRO.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.aRx = false;
                    this.aRI = false;
                    break;
                case 3:
                    this.aRx = false;
                    this.aRI = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view2, Point point, Point point2) {
        if (this.aRw && this.aRx) {
            this.aRP = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.aRv == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return b(motionEvent, this.aRK);
    }

    public int w(MotionEvent motionEvent) {
        return b(motionEvent, this.aRM);
    }

    public int b(MotionEvent motionEvent, int i) {
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
                findViewById.getLocationOnScreen(this.aRD);
                if (rawX > this.aRD[0] && rawY > this.aRD[1] && rawX < this.aRD[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.aRD[1]) {
                        this.aRE = childAt.getLeft();
                        this.aRF = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.aRw && this.aRv == 0) {
            this.aRC = b(motionEvent, this.aRL);
        }
        this.aRA = t(motionEvent);
        if (this.aRA != -1 && this.aRt == 0) {
            n(this.aRA, ((int) motionEvent.getX()) - this.aRE, ((int) motionEvent.getY()) - this.aRF);
        }
        this.aRx = false;
        this.aRN = true;
        this.aRP = 0;
        this.aRB = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.aRE;
            int i2 = y2 - this.aRF;
            if (this.aRN && !this.aRI && (this.aRA != -1 || this.aRB != -1)) {
                if (this.aRA != -1) {
                    if (this.aRt == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.aRu) {
                        n(this.aRA, i, i2);
                    } else if (this.aRt != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.aRw) {
                        this.aRx = true;
                        n(this.aRB, i, i2);
                    }
                } else if (this.aRB != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.aRw) {
                        this.aRx = true;
                        n(this.aRB, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.aRN = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aRA != -1 && this.aRt == 2) {
            this.mListView.performHapticFeedback(0);
            n(this.aRA, this.aRG - this.aRE, this.aRH - this.aRF);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aRw && this.aRv == 0 && this.aRC != -1) {
            this.aRO.removeItem(this.aRC - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
