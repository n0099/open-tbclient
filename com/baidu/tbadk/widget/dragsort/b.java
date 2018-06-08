package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int aZA;
    private int aZB;
    private int aZC;
    private boolean aZD;
    private float aZE;
    private int aZF;
    private int aZG;
    private int aZH;
    private boolean aZI;
    private a aZJ;
    private int aZK;
    private GestureDetector.OnGestureListener aZL;
    private int aZp;
    private boolean aZq;
    private int aZr;
    private boolean aZs;
    private boolean aZt;
    private GestureDetector aZu;
    private GestureDetector aZv;
    private int aZw;
    private int aZx;
    private int aZy;
    private int aZz;
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
        this.aZp = 0;
        this.aZq = true;
        this.aZs = false;
        this.aZt = false;
        this.aZw = -1;
        this.aZx = -1;
        this.aZy = -1;
        this.mTempLoc = new int[2];
        this.aZD = false;
        this.aZE = 500.0f;
        this.aZL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.aZs && b.this.aZt) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.aZE) {
                        if (b.this.aZK > (-width)) {
                            b.this.aZJ.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.aZE) && b.this.aZK < width) {
                        b.this.aZJ.stopDragWithVelocity(true, f);
                    }
                    b.this.aZt = false;
                }
                return false;
            }
        };
        this.aZJ = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.aZu = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.aZJ.isDragEnabled() || b.this.aZJ.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.aZB = (int) motionEvent.getX();
                b.this.aZC = (int) motionEvent.getY();
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
        this.aZv = new GestureDetector(listView.getContext(), this.aZL);
        this.aZv.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.aZF = i;
        this.aZG = i4;
        this.aZH = i5;
        fC(i3);
        fB(i2);
    }

    public GestureDetector Me() {
        return this.aZu;
    }

    public void fB(int i) {
        this.aZp = i;
    }

    public void cg(boolean z) {
        this.aZq = z;
    }

    public void fC(int i) {
        this.aZr = i;
    }

    public void ch(boolean z) {
        this.aZs = z;
    }

    public boolean n(int i, int i2, int i3) {
        int i4 = 0;
        if (this.aZq && !this.aZt) {
            i4 = 12;
        }
        if (this.aZs && this.aZt) {
            i4 = i4 | 1 | 2;
        }
        this.aZD = this.aZJ.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.aZD;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.aZJ.isDragEnabled() && !this.aZJ.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.aZs && this.aZD && this.aZr == 1) {
                this.aZv.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.aZB = (int) motionEvent.getX();
                    this.aZC = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.aZs && this.aZt) {
                        if ((this.aZK >= 0 ? this.aZK : -this.aZK) > this.mListView.getWidth() / 2) {
                            this.aZJ.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.aZt = false;
                    this.aZD = false;
                    break;
                case 3:
                    this.aZt = false;
                    this.aZD = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.aZs && this.aZt) {
            this.aZK = point.x;
        }
    }

    public int u(MotionEvent motionEvent) {
        return w(motionEvent);
    }

    public int v(MotionEvent motionEvent) {
        if (this.aZr == 1) {
            return x(motionEvent);
        }
        return -1;
    }

    public int w(MotionEvent motionEvent) {
        return b(motionEvent, this.aZF);
    }

    public int x(MotionEvent motionEvent) {
        return b(motionEvent, this.aZH);
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
                findViewById.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[0] && rawY > this.mTempLoc[1] && rawX < this.mTempLoc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.mTempLoc[1]) {
                        this.aZz = childAt.getLeft();
                        this.aZA = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.aZs && this.aZr == 0) {
            this.aZy = b(motionEvent, this.aZG);
        }
        this.aZw = u(motionEvent);
        if (this.aZw != -1 && this.aZp == 0) {
            n(this.aZw, ((int) motionEvent.getX()) - this.aZz, ((int) motionEvent.getY()) - this.aZA);
        }
        this.aZt = false;
        this.aZI = true;
        this.aZK = 0;
        this.aZx = v(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.aZz;
            int i2 = y2 - this.aZA;
            if (this.aZI && !this.aZD && (this.aZw != -1 || this.aZx != -1)) {
                if (this.aZw != -1) {
                    if (this.aZp == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.aZq) {
                        n(this.aZw, i, i2);
                    } else if (this.aZp != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.aZs) {
                        this.aZt = true;
                        n(this.aZx, i, i2);
                    }
                } else if (this.aZx != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.aZs) {
                        this.aZt = true;
                        n(this.aZx, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.aZI = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aZw != -1 && this.aZp == 2) {
            this.mListView.performHapticFeedback(0);
            n(this.aZw, this.aZB - this.aZz, this.aZC - this.aZA);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aZs && this.aZr == 0 && this.aZy != -1) {
            this.aZJ.removeItem(this.aZy - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
