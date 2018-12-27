package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.e;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static DateFormat btN = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT);
    private boolean[] bsA;
    private WheelView btO;
    private WheelView btP;
    private WheelView btQ;
    private WheelView btR;
    private WheelView btS;
    private WheelView btT;
    private int btY;
    private com.baidu.tbadk.widget.timepicker.a.d.b btZ;
    private int btf;
    private int btg;
    private int bth;
    private float bti;
    private WheelView.DividerType bto;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = BdDatePicker.START_YEAR;
    private int endYear = 2100;
    private int btU = 1;
    private int btV = 12;
    private int btW = 1;
    private int btX = 31;
    private boolean bsF = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.bsA = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void df(boolean z) {
        this.bsF = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.bsF) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.btO = (WheelView) this.view.findViewById(e.g.year);
        this.btO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.X(this.startYear, this.endYear)));
        this.btO.setLabel("");
        this.btO.setCurrentItem(i - this.startYear);
        this.btO.setGravity(this.gravity);
        this.btP = (WheelView) this.view.findViewById(e.g.month);
        this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(i)));
        this.btP.setLabel("");
        int hh = com.baidu.tbadk.widget.timepicker.a.e.a.hh(i);
        if (hh != 0 && (i2 > hh - 1 || z)) {
            this.btP.setCurrentItem(i2 + 1);
        } else {
            this.btP.setCurrentItem(i2);
        }
        this.btP.setGravity(this.gravity);
        this.btQ = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i) == 0) {
            this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i, i2))));
        } else {
            this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(i))));
        }
        this.btQ.setLabel("");
        this.btQ.setCurrentItem(i3 - 1);
        this.btQ.setGravity(this.gravity);
        this.btR = (WheelView) this.view.findViewById(e.g.hour);
        this.btR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.btR.setCurrentItem(i4);
        this.btR.setGravity(this.gravity);
        this.btS = (WheelView) this.view.findViewById(e.g.min);
        this.btS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btS.setCurrentItem(i5);
        this.btS.setGravity(this.gravity);
        this.btT = (WheelView) this.view.findViewById(e.g.second);
        this.btT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btT.setCurrentItem(i5);
        this.btT.setGravity(this.gravity);
        this.btO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int W;
                int i8 = c.this.startYear + i7;
                c.this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hk(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) == 0 || c.this.btP.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) - 1) {
                    c.this.btP.setCurrentItem(c.this.btP.getCurrentItem());
                } else {
                    c.this.btP.setCurrentItem(c.this.btP.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) == 0 || c.this.btP.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) - 1) {
                    c.this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btP.getCurrentItem() + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btP.getCurrentItem() + 1);
                } else if (c.this.btP.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hh(i8) + 1) {
                    c.this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hg(i8);
                } else {
                    c.this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btP.getCurrentItem()))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(i8, c.this.btP.getCurrentItem());
                }
                if (c.this.btQ.getCurrentItem() > W - 1) {
                    c.this.btQ.setCurrentItem(W - 1);
                }
                if (c.this.btZ != null) {
                    c.this.btZ.Ta();
                }
            }
        });
        this.btP.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int W;
                int currentItem = c.this.btO.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) - 1) {
                    c.this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7 + 1);
                } else if (c.this.btP.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem) + 1) {
                    c.this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.hg(currentItem);
                } else {
                    c.this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.hl(com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7))));
                    W = com.baidu.tbadk.widget.timepicker.a.e.a.W(currentItem, i7);
                }
                if (c.this.btQ.getCurrentItem() > W - 1) {
                    c.this.btQ.setCurrentItem(W - 1);
                }
                if (c.this.btZ != null) {
                    c.this.btZ.Ta();
                }
            }
        });
        a(this.btQ);
        a(this.btR);
        a(this.btS);
        a(this.btT);
        if (this.bsA.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.btO.setVisibility(this.bsA[0] ? 0 : 8);
        this.btP.setVisibility(this.bsA[1] ? 0 : 8);
        this.btQ.setVisibility(this.bsA[2] ? 0 : 8);
        this.btR.setVisibility(this.bsA[3] ? 0 : 8);
        this.btS.setVisibility(this.bsA[4] ? 0 : 8);
        this.btT.setVisibility(this.bsA[5] ? 0 : 8);
        Tk();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.btY = i;
        this.btO = (WheelView) this.view.findViewById(e.g.year);
        this.btO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.btO.setCurrentItem(i - this.startYear);
        this.btO.setGravity(this.gravity);
        this.btP = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btU, this.btV));
            this.btP.setCurrentItem((i2 + 1) - this.btU);
        } else if (i == this.startYear) {
            this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btU, 12));
            this.btP.setCurrentItem((i2 + 1) - this.btU);
        } else if (i == this.endYear) {
            this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btV));
            this.btP.setCurrentItem(i2);
        } else {
            this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.btP.setCurrentItem(i2);
        }
        this.btP.setGravity(this.gravity);
        this.btQ = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.btU == this.btV) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.btX > 31) {
                    this.btX = 31;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, this.btX));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.btX > 30) {
                    this.btX = 30;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, this.btX));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.btX > 29) {
                    this.btX = 29;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, this.btX));
            } else {
                if (this.btX > 28) {
                    this.btX = 28;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, this.btX));
            }
            this.btQ.setCurrentItem(i3 - this.btW);
        } else if (i == this.startYear && i2 + 1 == this.btU) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, 29));
            } else {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.btW, 28));
            }
            this.btQ.setCurrentItem(i3 - this.btW);
        } else if (i == this.endYear && i2 + 1 == this.btV) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.btX > 31) {
                    this.btX = 31;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btX));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.btX > 30) {
                    this.btX = 30;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btX));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.btX > 29) {
                    this.btX = 29;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btX));
            } else {
                if (this.btX > 28) {
                    this.btX = 28;
                }
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.btX));
            }
            this.btQ.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.btQ.setCurrentItem(i3 - 1);
        }
        this.btQ.setGravity(this.gravity);
        this.btR = (WheelView) this.view.findViewById(e.g.hour);
        this.btR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.btR.setCurrentItem(i4);
        this.btR.setGravity(this.gravity);
        this.btS = (WheelView) this.view.findViewById(e.g.min);
        this.btS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btS.setCurrentItem(i5);
        this.btS.setGravity(this.gravity);
        this.btT = (WheelView) this.view.findViewById(e.g.second);
        this.btT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.btT.setCurrentItem(i6);
        this.btT.setGravity(this.gravity);
        this.btO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.btY = i8;
                int currentItem = c.this.btP.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.btU, c.this.btV));
                    if (currentItem > c.this.btP.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.btP.getAdapter().getItemsCount() - 1;
                        c.this.btP.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.btU + currentItem;
                    if (c.this.btU == c.this.btV) {
                        c.this.a(i8, i9, c.this.btW, c.this.btX, asList, asList2);
                    } else if (i9 == c.this.btU) {
                        c.this.a(i8, i9, c.this.btW, 31, asList, asList2);
                    } else if (i9 == c.this.btV) {
                        c.this.a(i8, i9, 1, c.this.btX, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.btU, 12));
                    if (currentItem > c.this.btP.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.btP.getAdapter().getItemsCount() - 1;
                        c.this.btP.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.btU + currentItem;
                    if (i10 == c.this.btU) {
                        c.this.a(i8, i10, c.this.btW, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.btV));
                    if (currentItem > c.this.btP.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.btP.getAdapter().getItemsCount() - 1;
                        c.this.btP.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.btV) {
                        c.this.a(i8, i11, 1, c.this.btX, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.btP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.btP.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.btZ != null) {
                    c.this.btZ.Ta();
                }
            }
        });
        this.btP.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void hn(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.btU + i8) - 1;
                    if (c.this.btU == c.this.btV) {
                        c.this.a(c.this.btY, i9, c.this.btW, c.this.btX, asList, asList2);
                    } else if (c.this.btU == i9) {
                        c.this.a(c.this.btY, i9, c.this.btW, 31, asList, asList2);
                    } else if (c.this.btV == i9) {
                        c.this.a(c.this.btY, i9, 1, c.this.btX, asList, asList2);
                    } else {
                        c.this.a(c.this.btY, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.btY == c.this.startYear) {
                    int i10 = (c.this.btU + i8) - 1;
                    if (i10 == c.this.btU) {
                        c.this.a(c.this.btY, i10, c.this.btW, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.btY, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.btY == c.this.endYear) {
                    if (i8 == c.this.btV) {
                        c.this.a(c.this.btY, c.this.btP.getCurrentItem() + 1, 1, c.this.btX, asList, asList2);
                    } else {
                        c.this.a(c.this.btY, c.this.btP.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.btY, i8, 1, 31, asList, asList2);
                }
                if (c.this.btZ != null) {
                    c.this.btZ.Ta();
                }
            }
        });
        a(this.btQ);
        a(this.btR);
        a(this.btS);
        a(this.btT);
        if (this.bsA.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.btO.setVisibility(this.bsA[0] ? 0 : 8);
        this.btP.setVisibility(this.bsA[1] ? 0 : 8);
        this.btQ.setVisibility(this.bsA[2] ? 0 : 8);
        this.btR.setVisibility(this.bsA[3] ? 0 : 8);
        this.btS.setVisibility(this.bsA[4] ? 0 : 8);
        this.btT.setVisibility(this.bsA[5] ? 0 : 8);
        Tk();
    }

    private void a(WheelView wheelView) {
        if (this.btZ != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void hn(int i) {
                    c.this.btZ.Ta();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.btQ.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.btQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.btQ.getAdapter().getItemsCount() - 1) {
            this.btQ.setCurrentItem(this.btQ.getAdapter().getItemsCount() - 1);
        }
    }

    private void Tk() {
        this.btQ.setTextSize(this.textSize);
        this.btP.setTextSize(this.textSize);
        this.btO.setTextSize(this.textSize);
        this.btR.setTextSize(this.textSize);
        this.btS.setTextSize(this.textSize);
        this.btT.setTextSize(this.textSize);
    }

    private void Tl() {
        this.btQ.setTextColorOut(this.btf);
        this.btP.setTextColorOut(this.btf);
        this.btO.setTextColorOut(this.btf);
        this.btR.setTextColorOut(this.btf);
        this.btS.setTextColorOut(this.btf);
        this.btT.setTextColorOut(this.btf);
    }

    private void Tm() {
        this.btQ.setTextColorCenter(this.btg);
        this.btP.setTextColorCenter(this.btg);
        this.btO.setTextColorCenter(this.btg);
        this.btR.setTextColorCenter(this.btg);
        this.btS.setTextColorCenter(this.btg);
        this.btT.setTextColorCenter(this.btg);
    }

    private void Tn() {
        this.btQ.setDividerColor(this.bth);
        this.btP.setDividerColor(this.bth);
        this.btO.setDividerColor(this.bth);
        this.btR.setDividerColor(this.bth);
        this.btS.setDividerColor(this.bth);
        this.btT.setDividerColor(this.bth);
    }

    private void To() {
        this.btQ.setDividerType(this.bto);
        this.btP.setDividerType(this.bto);
        this.btO.setDividerType(this.bto);
        this.btR.setDividerType(this.bto);
        this.btS.setDividerType(this.bto);
        this.btT.setDividerType(this.bto);
    }

    private void Tp() {
        this.btQ.setLineSpacingMultiplier(this.bti);
        this.btP.setLineSpacingMultiplier(this.bti);
        this.btO.setLineSpacingMultiplier(this.bti);
        this.btR.setLineSpacingMultiplier(this.bti);
        this.btS.setLineSpacingMultiplier(this.bti);
        this.btT.setLineSpacingMultiplier(this.bti);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.bsF) {
            if (str != null) {
                this.btO.setLabel(str);
            } else {
                this.btO.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.btP.setLabel(str2);
            } else {
                this.btP.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.btQ.setLabel(str3);
            } else {
                this.btQ.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.btR.setLabel(str4);
            } else {
                this.btR.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.btS.setLabel(str5);
            } else {
                this.btS.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.btT.setLabel(str6);
            } else {
                this.btT.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.btQ.setTextXOffset(i);
        this.btP.setTextXOffset(i2);
        this.btO.setTextXOffset(i3);
        this.btR.setTextXOffset(i4);
        this.btS.setTextXOffset(i5);
        this.btT.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.btO.setCyclic(z);
        this.btP.setCyclic(z);
        this.btQ.setCyclic(z);
        this.btR.setCyclic(z);
        this.btS.setCyclic(z);
        this.btT.setCyclic(z);
    }

    public String getTime() {
        if (this.bsF) {
            return Tq();
        }
        StringBuilder sb = new StringBuilder();
        if (this.btY == this.startYear) {
            if (this.btP.getCurrentItem() + this.btU == this.btU) {
                sb.append(this.btO.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btP.getCurrentItem() + this.btU).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btQ.getCurrentItem() + this.btW).append(" ").append(this.btR.getCurrentItem()).append(":").append(this.btS.getCurrentItem()).append(":").append(this.btT.getCurrentItem());
            } else {
                sb.append(this.btO.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btP.getCurrentItem() + this.btU).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btQ.getCurrentItem() + 1).append(" ").append(this.btR.getCurrentItem()).append(":").append(this.btS.getCurrentItem()).append(":").append(this.btT.getCurrentItem());
            }
        } else {
            sb.append(this.btO.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btP.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.btQ.getCurrentItem() + 1).append(" ").append(this.btR.getCurrentItem()).append(":").append(this.btS.getCurrentItem()).append(":").append(this.btT.getCurrentItem());
        }
        return sb.toString();
    }

    private String Tq() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.btO.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) == 0) {
            currentItem = this.btP.getCurrentItem() + 1;
            z = false;
        } else if ((this.btP.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) <= 0) {
            currentItem = this.btP.getCurrentItem() + 1;
            z = false;
        } else if ((this.btP.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.hh(currentItem2) == 1) {
            currentItem = this.btP.getCurrentItem();
            z = true;
        } else {
            currentItem = this.btP.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.btQ.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.btR.getCurrentItem()).append(":").append(this.btS.getCurrentItem()).append(":").append(this.btT.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void hm(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.btV = i2;
                this.btX = i3;
            } else if (i == this.startYear) {
                if (i2 > this.btU) {
                    this.endYear = i;
                    this.btV = i2;
                    this.btX = i3;
                } else if (i2 == this.btU && i3 > this.btW) {
                    this.endYear = i;
                    this.btV = i2;
                    this.btX = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.btU = i5;
                this.btW = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.btV) {
                    this.btU = i5;
                    this.btW = i6;
                    this.startYear = i4;
                } else if (i5 == this.btV && i6 < this.btX) {
                    this.btU = i5;
                    this.btW = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.btU = calendar.get(2) + 1;
            this.btV = calendar2.get(2) + 1;
            this.btW = calendar.get(5);
            this.btX = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.bti = f;
        Tp();
    }

    public void setDividerColor(int i) {
        this.bth = i;
        Tn();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.bto = dividerType;
        To();
    }

    public void setTextColorCenter(int i) {
        this.btg = i;
        Tm();
    }

    public void setTextColorOut(int i) {
        this.btf = i;
        Tl();
    }

    public void dg(boolean z) {
        this.btQ.dg(z);
        this.btP.dg(z);
        this.btO.dg(z);
        this.btR.dg(z);
        this.btS.dg(z);
        this.btT.dg(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.btZ = bVar;
    }
}
