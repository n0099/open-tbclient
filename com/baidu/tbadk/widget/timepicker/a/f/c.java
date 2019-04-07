package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static DateFormat cFM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cEA;
    private WheelView cFN;
    private WheelView cFO;
    private WheelView cFP;
    private WheelView cFQ;
    private WheelView cFR;
    private WheelView cFS;
    private int cFX;
    private com.baidu.tbadk.widget.timepicker.a.d.b cFY;
    private int cFf;
    private int cFg;
    private int cFh;
    private float cFi;
    private WheelView.DividerType cFn;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = 1900;
    private int endYear = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cFT = 1;
    private int cFU = 12;
    private int cFV = 1;
    private int cFW = 31;
    private boolean cEF = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cEA = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fy(boolean z) {
        this.cEF = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cEF) {
            int[] y = com.baidu.tbadk.widget.timepicker.a.e.b.y(i, i2 + 1, i3);
            a(y[0], y[1] - 1, y[2], y[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cFN = (WheelView) this.view.findViewById(d.g.year);
        this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.av(this.startYear, this.endYear)));
        this.cFN.setLabel("");
        this.cFN.setCurrentItem(i - this.startYear);
        this.cFN.setGravity(this.gravity);
        this.cFO = (WheelView) this.view.findViewById(d.g.month);
        this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i)));
        this.cFO.setLabel("");
        int kW = com.baidu.tbadk.widget.timepicker.a.e.a.kW(i);
        if (kW != 0 && (i2 > kW - 1 || z)) {
            this.cFO.setCurrentItem(i2 + 1);
        } else {
            this.cFO.setCurrentItem(i2);
        }
        this.cFO.setGravity(this.gravity);
        this.cFP = (WheelView) this.view.findViewById(d.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(i) == 0) {
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(i, i2))));
        } else {
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.kV(i))));
        }
        this.cFP.setLabel("");
        this.cFP.setCurrentItem(i3 - 1);
        this.cFP.setGravity(this.gravity);
        this.cFQ = (WheelView) this.view.findViewById(d.g.hour);
        this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cFQ.setCurrentItem(i4);
        this.cFQ.setGravity(this.gravity);
        this.cFR = (WheelView) this.view.findViewById(d.g.min);
        this.cFR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFR.setCurrentItem(i5);
        this.cFR.setGravity(this.gravity);
        this.cFS = (WheelView) this.view.findViewById(d.g.second);
        this.cFS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFS.setCurrentItem(i5);
        this.cFS.setGravity(this.gravity);
        this.cFN.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int au;
                int i8 = c.this.startYear + i7;
                c.this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) == 0 || c.this.cFO.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) - 1) {
                    c.this.cFO.setCurrentItem(c.this.cFO.getCurrentItem());
                } else {
                    c.this.cFO.setCurrentItem(c.this.cFO.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) == 0 || c.this.cFO.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) - 1) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFO.getCurrentItem() + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFO.getCurrentItem() + 1);
                } else if (c.this.cFO.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) + 1) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.kV(i8))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.kV(i8);
                } else {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFO.getCurrentItem()))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFO.getCurrentItem());
                }
                if (c.this.cFP.getCurrentItem() > au - 1) {
                    c.this.cFP.setCurrentItem(au - 1);
                }
                if (c.this.cFY != null) {
                    c.this.cFY.ats();
                }
            }
        });
        this.cFO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int au;
                int currentItem = c.this.cFN.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem) - 1) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1);
                } else if (c.this.cFO.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem) + 1) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.kV(currentItem))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.kV(currentItem);
                } else {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7);
                }
                if (c.this.cFP.getCurrentItem() > au - 1) {
                    c.this.cFP.setCurrentItem(au - 1);
                }
                if (c.this.cFY != null) {
                    c.this.cFY.ats();
                }
            }
        });
        a(this.cFP);
        a(this.cFQ);
        a(this.cFR);
        a(this.cFS);
        if (this.cEA.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cFN.setVisibility(this.cEA[0] ? 0 : 8);
        this.cFO.setVisibility(this.cEA[1] ? 0 : 8);
        this.cFP.setVisibility(this.cEA[2] ? 0 : 8);
        this.cFQ.setVisibility(this.cEA[3] ? 0 : 8);
        this.cFR.setVisibility(this.cEA[4] ? 0 : 8);
        this.cFS.setVisibility(this.cEA[5] ? 0 : 8);
        atC();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cFX = i;
        this.cFN = (WheelView) this.view.findViewById(d.g.year);
        this.cFN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.cFN.setCurrentItem(i - this.startYear);
        this.cFN.setGravity(this.gravity);
        this.cFO = (WheelView) this.view.findViewById(d.g.month);
        if (this.startYear == this.endYear) {
            this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, this.cFU));
            this.cFO.setCurrentItem((i2 + 1) - this.cFT);
        } else if (i == this.startYear) {
            this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFT, 12));
            this.cFO.setCurrentItem((i2 + 1) - this.cFT);
        } else if (i == this.endYear) {
            this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFU));
            this.cFO.setCurrentItem(i2);
        } else {
            this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cFO.setCurrentItem(i2);
        }
        this.cFO.setGravity(this.gravity);
        this.cFP = (WheelView) this.view.findViewById(d.g.day);
        if (this.startYear == this.endYear && this.cFT == this.cFU) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cFW > 31) {
                    this.cFW = 31;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, this.cFW));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cFW > 30) {
                    this.cFW = 30;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, this.cFW));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cFW > 29) {
                    this.cFW = 29;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, this.cFW));
            } else {
                if (this.cFW > 28) {
                    this.cFW = 28;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, this.cFW));
            }
            this.cFP.setCurrentItem(i3 - this.cFV);
        } else if (i == this.startYear && i2 + 1 == this.cFT) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, 29));
            } else {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFV, 28));
            }
            this.cFP.setCurrentItem(i3 - this.cFV);
        } else if (i == this.endYear && i2 + 1 == this.cFU) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cFW > 31) {
                    this.cFW = 31;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFW));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cFW > 30) {
                    this.cFW = 30;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFW));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cFW > 29) {
                    this.cFW = 29;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFW));
            } else {
                if (this.cFW > 28) {
                    this.cFW = 28;
                }
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFW));
            }
            this.cFP.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cFP.setCurrentItem(i3 - 1);
        }
        this.cFP.setGravity(this.gravity);
        this.cFQ = (WheelView) this.view.findViewById(d.g.hour);
        this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cFQ.setCurrentItem(i4);
        this.cFQ.setGravity(this.gravity);
        this.cFR = (WheelView) this.view.findViewById(d.g.min);
        this.cFR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFR.setCurrentItem(i5);
        this.cFR.setGravity(this.gravity);
        this.cFS = (WheelView) this.view.findViewById(d.g.second);
        this.cFS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFS.setCurrentItem(i6);
        this.cFS.setGravity(this.gravity);
        this.cFN.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.cFX = i8;
                int currentItem = c.this.cFO.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cFT, c.this.cFU));
                    if (currentItem > c.this.cFO.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFO.getAdapter().getItemsCount() - 1;
                        c.this.cFO.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cFT + currentItem;
                    if (c.this.cFT == c.this.cFU) {
                        c.this.a(i8, i9, c.this.cFV, c.this.cFW, asList, asList2);
                    } else if (i9 == c.this.cFT) {
                        c.this.a(i8, i9, c.this.cFV, 31, asList, asList2);
                    } else if (i9 == c.this.cFU) {
                        c.this.a(i8, i9, 1, c.this.cFW, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cFT, 12));
                    if (currentItem > c.this.cFO.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFO.getAdapter().getItemsCount() - 1;
                        c.this.cFO.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cFT + currentItem;
                    if (i10 == c.this.cFT) {
                        c.this.a(i8, i10, c.this.cFV, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cFU));
                    if (currentItem > c.this.cFO.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFO.getAdapter().getItemsCount() - 1;
                        c.this.cFO.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cFU) {
                        c.this.a(i8, i11, 1, c.this.cFW, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cFO.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cFY != null) {
                    c.this.cFY.ats();
                }
            }
        });
        this.cFO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.cFT + i8) - 1;
                    if (c.this.cFT == c.this.cFU) {
                        c.this.a(c.this.cFX, i9, c.this.cFV, c.this.cFW, asList, asList2);
                    } else if (c.this.cFT == i9) {
                        c.this.a(c.this.cFX, i9, c.this.cFV, 31, asList, asList2);
                    } else if (c.this.cFU == i9) {
                        c.this.a(c.this.cFX, i9, 1, c.this.cFW, asList, asList2);
                    } else {
                        c.this.a(c.this.cFX, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cFX == c.this.startYear) {
                    int i10 = (c.this.cFT + i8) - 1;
                    if (i10 == c.this.cFT) {
                        c.this.a(c.this.cFX, i10, c.this.cFV, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cFX, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cFX == c.this.endYear) {
                    if (i8 == c.this.cFU) {
                        c.this.a(c.this.cFX, c.this.cFO.getCurrentItem() + 1, 1, c.this.cFW, asList, asList2);
                    } else {
                        c.this.a(c.this.cFX, c.this.cFO.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cFX, i8, 1, 31, asList, asList2);
                }
                if (c.this.cFY != null) {
                    c.this.cFY.ats();
                }
            }
        });
        a(this.cFP);
        a(this.cFQ);
        a(this.cFR);
        a(this.cFS);
        if (this.cEA.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cFN.setVisibility(this.cEA[0] ? 0 : 8);
        this.cFO.setVisibility(this.cEA[1] ? 0 : 8);
        this.cFP.setVisibility(this.cEA[2] ? 0 : 8);
        this.cFQ.setVisibility(this.cEA[3] ? 0 : 8);
        this.cFR.setVisibility(this.cEA[4] ? 0 : 8);
        this.cFS.setVisibility(this.cEA[5] ? 0 : 8);
        atC();
    }

    private void a(WheelView wheelView) {
        if (this.cFY != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lc(int i) {
                    c.this.cFY.ats();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cFP.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cFP.getAdapter().getItemsCount() - 1) {
            this.cFP.setCurrentItem(this.cFP.getAdapter().getItemsCount() - 1);
        }
    }

    private void atC() {
        this.cFP.setTextSize(this.textSize);
        this.cFO.setTextSize(this.textSize);
        this.cFN.setTextSize(this.textSize);
        this.cFQ.setTextSize(this.textSize);
        this.cFR.setTextSize(this.textSize);
        this.cFS.setTextSize(this.textSize);
    }

    private void atD() {
        this.cFP.setTextColorOut(this.cFf);
        this.cFO.setTextColorOut(this.cFf);
        this.cFN.setTextColorOut(this.cFf);
        this.cFQ.setTextColorOut(this.cFf);
        this.cFR.setTextColorOut(this.cFf);
        this.cFS.setTextColorOut(this.cFf);
    }

    private void atE() {
        this.cFP.setTextColorCenter(this.cFg);
        this.cFO.setTextColorCenter(this.cFg);
        this.cFN.setTextColorCenter(this.cFg);
        this.cFQ.setTextColorCenter(this.cFg);
        this.cFR.setTextColorCenter(this.cFg);
        this.cFS.setTextColorCenter(this.cFg);
    }

    private void atF() {
        this.cFP.setDividerColor(this.cFh);
        this.cFO.setDividerColor(this.cFh);
        this.cFN.setDividerColor(this.cFh);
        this.cFQ.setDividerColor(this.cFh);
        this.cFR.setDividerColor(this.cFh);
        this.cFS.setDividerColor(this.cFh);
    }

    private void atG() {
        this.cFP.setDividerType(this.cFn);
        this.cFO.setDividerType(this.cFn);
        this.cFN.setDividerType(this.cFn);
        this.cFQ.setDividerType(this.cFn);
        this.cFR.setDividerType(this.cFn);
        this.cFS.setDividerType(this.cFn);
    }

    private void atH() {
        this.cFP.setLineSpacingMultiplier(this.cFi);
        this.cFO.setLineSpacingMultiplier(this.cFi);
        this.cFN.setLineSpacingMultiplier(this.cFi);
        this.cFQ.setLineSpacingMultiplier(this.cFi);
        this.cFR.setLineSpacingMultiplier(this.cFi);
        this.cFS.setLineSpacingMultiplier(this.cFi);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cEF) {
            if (str != null) {
                this.cFN.setLabel(str);
            } else {
                this.cFN.setLabel(this.view.getContext().getString(d.j.pickerview_year));
            }
            if (str2 != null) {
                this.cFO.setLabel(str2);
            } else {
                this.cFO.setLabel(this.view.getContext().getString(d.j.pickerview_month));
            }
            if (str3 != null) {
                this.cFP.setLabel(str3);
            } else {
                this.cFP.setLabel(this.view.getContext().getString(d.j.pickerview_day));
            }
            if (str4 != null) {
                this.cFQ.setLabel(str4);
            } else {
                this.cFQ.setLabel(this.view.getContext().getString(d.j.pickerview_hours));
            }
            if (str5 != null) {
                this.cFR.setLabel(str5);
            } else {
                this.cFR.setLabel(this.view.getContext().getString(d.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.cFS.setLabel(str6);
            } else {
                this.cFS.setLabel(this.view.getContext().getString(d.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cFP.setTextXOffset(i);
        this.cFO.setTextXOffset(i2);
        this.cFN.setTextXOffset(i3);
        this.cFQ.setTextXOffset(i4);
        this.cFR.setTextXOffset(i5);
        this.cFS.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cFN.setCyclic(z);
        this.cFO.setCyclic(z);
        this.cFP.setCyclic(z);
        this.cFQ.setCyclic(z);
        this.cFR.setCyclic(z);
        this.cFS.setCyclic(z);
    }

    public String getTime() {
        if (this.cEF) {
            return atI();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cFX == this.startYear) {
            if (this.cFO.getCurrentItem() + this.cFT == this.cFT) {
                sb.append(this.cFN.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFO.getCurrentItem() + this.cFT).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFP.getCurrentItem() + this.cFV).append(" ").append(this.cFQ.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem());
            } else {
                sb.append(this.cFN.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFO.getCurrentItem() + this.cFT).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFP.getCurrentItem() + 1).append(" ").append(this.cFQ.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem());
            }
        } else {
            sb.append(this.cFN.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFO.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFP.getCurrentItem() + 1).append(" ").append(this.cFQ.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem());
        }
        return sb.toString();
    }

    private String atI() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cFN.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem2) == 0) {
            currentItem = this.cFO.getCurrentItem() + 1;
            z = false;
        } else if ((this.cFO.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem2) <= 0) {
            currentItem = this.cFO.getCurrentItem() + 1;
            z = false;
        } else if ((this.cFO.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem2) == 1) {
            currentItem = this.cFO.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cFO.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cFP.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cFQ.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void lb(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.cFU = i2;
                this.cFW = i3;
            } else if (i == this.startYear) {
                if (i2 > this.cFT) {
                    this.endYear = i;
                    this.cFU = i2;
                    this.cFW = i3;
                } else if (i2 == this.cFT && i3 > this.cFV) {
                    this.endYear = i;
                    this.cFU = i2;
                    this.cFW = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.cFT = i5;
                this.cFV = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.cFU) {
                    this.cFT = i5;
                    this.cFV = i6;
                    this.startYear = i4;
                } else if (i5 == this.cFU && i6 < this.cFW) {
                    this.cFT = i5;
                    this.cFV = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.cFT = calendar.get(2) + 1;
            this.cFU = calendar2.get(2) + 1;
            this.cFV = calendar.get(5);
            this.cFW = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cFi = f;
        atH();
    }

    public void setDividerColor(int i) {
        this.cFh = i;
        atF();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cFn = dividerType;
        atG();
    }

    public void setTextColorCenter(int i) {
        this.cFg = i;
        atE();
    }

    public void setTextColorOut(int i) {
        this.cFf = i;
        atD();
    }

    public void fz(boolean z) {
        this.cFP.fz(z);
        this.cFO.fz(z);
        this.cFN.fz(z);
        this.cFQ.fz(z);
        this.cFR.fz(z);
        this.cFS.fz(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cFY = bVar;
    }
}
