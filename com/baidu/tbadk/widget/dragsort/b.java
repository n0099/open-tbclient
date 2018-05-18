package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector aRA;
    private int aRB;
    private int aRC;
    private int aRD;
    private int[] aRE;
    private int aRF;
    private int aRG;
    private int aRH;
    private int aRI;
    private boolean aRJ;
    private float aRK;
    private int aRL;
    private int aRM;
    private int aRN;
    private boolean aRO;
    private a aRP;
    private int aRQ;
    private GestureDetector.OnGestureListener aRR;
    private int aRu;
    private boolean aRv;
    private int aRw;
    private boolean aRx;
    private boolean aRy;
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
        this.aRu = 0;
        this.aRv = true;
        this.aRx = false;
        this.aRy = false;
        this.aRB = -1;
        this.aRC = -1;
        this.aRD = -1;
        this.aRE = new int[2];
        this.aRJ = false;
        this.aRK = 500.0f;
        this.aRR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.aRx && b.this.aRy) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.aRK) {
                        if (b.this.aRQ > (-width)) {
                            b.this.aRP.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.aRK) && b.this.aRQ < width) {
                        b.this.aRP.stopDragWithVelocity(true, f);
                    }
                    b.this.aRy = false;
                }
                return false;
            }
        };
        this.aRP = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.aRz = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.aRP.isDragEnabled() || b.this.aRP.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.aRH = (int) motionEvent.getX();
                b.this.aRI = (int) motionEvent.getY();
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
        this.aRA = new GestureDetector(listView.getContext(), this.aRR);
        this.aRA.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.aRL = i;
        this.aRM = i4;
        this.aRN = i5;
        fB(i3);
        fA(i2);
    }

    public GestureDetector II() {
        return this.aRz;
    }

    public void fA(int i) {
        this.aRu = i;
    }

    public void cb(boolean z) {
        this.aRv = z;
    }

    public void fB(int i) {
        this.aRw = i;
    }

    public void cc(boolean z) {
        this.aRx = z;
    }

    public boolean n(int i, int i2, int i3) {
        int i4 = 0;
        if (this.aRv && !this.aRy) {
            i4 = 12;
        }
        if (this.aRx && this.aRy) {
            i4 = i4 | 1 | 2;
        }
        this.aRJ = this.aRP.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.aRJ;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (this.aRP.isDragEnabled() && !this.aRP.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.aRx && this.aRJ && this.aRw == 1) {
                this.aRA.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aRH = (int) motionEvent.getX();
                    this.aRI = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.aRx && this.aRy) {
                        if ((this.aRQ >= 0 ? this.aRQ : -this.aRQ) > this.mListView.getWidth() / 2) {
                            this.aRP.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.aRy = false;
                    this.aRJ = false;
                    break;
                case 3:
                    this.aRy = false;
                    this.aRJ = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view2, Point point, Point point2) {
        if (this.aRx && this.aRy) {
            this.aRQ = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.aRw == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return b(motionEvent, this.aRL);
    }

    public int w(MotionEvent motionEvent) {
        return b(motionEvent, this.aRN);
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
                findViewById.getLocationOnScreen(this.aRE);
                if (rawX > this.aRE[0] && rawY > this.aRE[1] && rawX < this.aRE[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.aRE[1]) {
                        this.aRF = childAt.getLeft();
                        this.aRG = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.aRx && this.aRw == 0) {
            this.aRD = b(motionEvent, this.aRM);
        }
        this.aRB = t(motionEvent);
        if (this.aRB != -1 && this.aRu == 0) {
            n(this.aRB, ((int) motionEvent.getX()) - this.aRF, ((int) motionEvent.getY()) - this.aRG);
        }
        this.aRy = false;
        this.aRO = true;
        this.aRQ = 0;
        this.aRC = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.aRF;
            int i2 = y2 - this.aRG;
            if (this.aRO && !this.aRJ && (this.aRB != -1 || this.aRC != -1)) {
                if (this.aRB != -1) {
                    if (this.aRu == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.aRv) {
                        n(this.aRB, i, i2);
                    } else if (this.aRu != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.aRx) {
                        this.aRy = true;
                        n(this.aRC, i, i2);
                    }
                } else if (this.aRC != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.aRx) {
                        this.aRy = true;
                        n(this.aRC, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.aRO = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aRB != -1 && this.aRu == 2) {
            this.mListView.performHapticFeedback(0);
            n(this.aRB, this.aRH - this.aRF, this.aRI - this.aRG);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aRx && this.aRw == 0 && this.aRD != -1) {
            this.aRP.removeItem(this.aRD - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
