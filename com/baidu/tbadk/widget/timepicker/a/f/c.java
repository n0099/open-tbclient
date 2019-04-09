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
    public static DateFormat cFN = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean[] cEB;
    private WheelView cFO;
    private WheelView cFP;
    private WheelView cFQ;
    private WheelView cFR;
    private WheelView cFS;
    private WheelView cFT;
    private int cFY;
    private com.baidu.tbadk.widget.timepicker.a.d.b cFZ;
    private int cFg;
    private int cFh;
    private int cFi;
    private float cFj;
    private WheelView.DividerType cFo;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = 1900;
    private int endYear = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int cFU = 1;
    private int cFV = 12;
    private int cFW = 1;
    private int cFX = 31;
    private boolean cEG = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.cEB = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void fy(boolean z) {
        this.cEG = z;
    }

    public void f(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.cEG) {
            int[] y = com.baidu.tbadk.widget.timepicker.a.e.b.y(i, i2 + 1, i3);
            a(y[0], y[1] - 1, y[2], y[3] == 1, i4, i5, i6);
            return;
        }
        g(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.cFO = (WheelView) this.view.findViewById(d.g.year);
        this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.av(this.startYear, this.endYear)));
        this.cFO.setLabel("");
        this.cFO.setCurrentItem(i - this.startYear);
        this.cFO.setGravity(this.gravity);
        this.cFP = (WheelView) this.view.findViewById(d.g.month);
        this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i)));
        this.cFP.setLabel("");
        int kW = com.baidu.tbadk.widget.timepicker.a.e.a.kW(i);
        if (kW != 0 && (i2 > kW - 1 || z)) {
            this.cFP.setCurrentItem(i2 + 1);
        } else {
            this.cFP.setCurrentItem(i2);
        }
        this.cFP.setGravity(this.gravity);
        this.cFQ = (WheelView) this.view.findViewById(d.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(i) == 0) {
            this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(i, i2))));
        } else {
            this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.kV(i))));
        }
        this.cFQ.setLabel("");
        this.cFQ.setCurrentItem(i3 - 1);
        this.cFQ.setGravity(this.gravity);
        this.cFR = (WheelView) this.view.findViewById(d.g.hour);
        this.cFR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cFR.setCurrentItem(i4);
        this.cFR.setGravity(this.gravity);
        this.cFS = (WheelView) this.view.findViewById(d.g.min);
        this.cFS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFS.setCurrentItem(i5);
        this.cFS.setGravity(this.gravity);
        this.cFT = (WheelView) this.view.findViewById(d.g.second);
        this.cFT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFT.setCurrentItem(i5);
        this.cFT.setGravity(this.gravity);
        this.cFO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int au;
                int i8 = c.this.startYear + i7;
                c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.kZ(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) == 0 || c.this.cFP.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) - 1) {
                    c.this.cFP.setCurrentItem(c.this.cFP.getCurrentItem());
                } else {
                    c.this.cFP.setCurrentItem(c.this.cFP.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) == 0 || c.this.cFP.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) - 1) {
                    c.this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFP.getCurrentItem() + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFP.getCurrentItem() + 1);
                } else if (c.this.cFP.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.kW(i8) + 1) {
                    c.this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.kV(i8))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.kV(i8);
                } else {
                    c.this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFP.getCurrentItem()))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(i8, c.this.cFP.getCurrentItem());
                }
                if (c.this.cFQ.getCurrentItem() > au - 1) {
                    c.this.cFQ.setCurrentItem(au - 1);
                }
                if (c.this.cFZ != null) {
                    c.this.cFZ.ats();
                }
            }
        });
        this.cFP.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int au;
                int currentItem = c.this.cFO.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem) - 1) {
                    c.this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7 + 1);
                } else if (c.this.cFP.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem) + 1) {
                    c.this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.kV(currentItem))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.kV(currentItem);
                } else {
                    c.this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.la(com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7))));
                    au = com.baidu.tbadk.widget.timepicker.a.e.a.au(currentItem, i7);
                }
                if (c.this.cFQ.getCurrentItem() > au - 1) {
                    c.this.cFQ.setCurrentItem(au - 1);
                }
                if (c.this.cFZ != null) {
                    c.this.cFZ.ats();
                }
            }
        });
        a(this.cFQ);
        a(this.cFR);
        a(this.cFS);
        a(this.cFT);
        if (this.cEB.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.cFO.setVisibility(this.cEB[0] ? 0 : 8);
        this.cFP.setVisibility(this.cEB[1] ? 0 : 8);
        this.cFQ.setVisibility(this.cEB[2] ? 0 : 8);
        this.cFR.setVisibility(this.cEB[3] ? 0 : 8);
        this.cFS.setVisibility(this.cEB[4] ? 0 : 8);
        this.cFT.setVisibility(this.cEB[5] ? 0 : 8);
        atC();
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.cFY = i;
        this.cFO = (WheelView) this.view.findViewById(d.g.year);
        this.cFO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.cFO.setCurrentItem(i - this.startYear);
        this.cFO.setGravity(this.gravity);
        this.cFP = (WheelView) this.view.findViewById(d.g.month);
        if (this.startYear == this.endYear) {
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFU, this.cFV));
            this.cFP.setCurrentItem((i2 + 1) - this.cFU);
        } else if (i == this.startYear) {
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFU, 12));
            this.cFP.setCurrentItem((i2 + 1) - this.cFU);
        } else if (i == this.endYear) {
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFV));
            this.cFP.setCurrentItem(i2);
        } else {
            this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.cFP.setCurrentItem(i2);
        }
        this.cFP.setGravity(this.gravity);
        this.cFQ = (WheelView) this.view.findViewById(d.g.day);
        if (this.startYear == this.endYear && this.cFU == this.cFV) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cFX > 31) {
                    this.cFX = 31;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, this.cFX));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cFX > 30) {
                    this.cFX = 30;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, this.cFX));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cFX > 29) {
                    this.cFX = 29;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, this.cFX));
            } else {
                if (this.cFX > 28) {
                    this.cFX = 28;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, this.cFX));
            }
            this.cFQ.setCurrentItem(i3 - this.cFW);
        } else if (i == this.startYear && i2 + 1 == this.cFU) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, 29));
            } else {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.cFW, 28));
            }
            this.cFQ.setCurrentItem(i3 - this.cFW);
        } else if (i == this.endYear && i2 + 1 == this.cFV) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.cFX > 31) {
                    this.cFX = 31;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFX));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.cFX > 30) {
                    this.cFX = 30;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFX));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.cFX > 29) {
                    this.cFX = 29;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFX));
            } else {
                if (this.cFX > 28) {
                    this.cFX = 28;
                }
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.cFX));
            }
            this.cFQ.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.cFQ.setCurrentItem(i3 - 1);
        }
        this.cFQ.setGravity(this.gravity);
        this.cFR = (WheelView) this.view.findViewById(d.g.hour);
        this.cFR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.cFR.setCurrentItem(i4);
        this.cFR.setGravity(this.gravity);
        this.cFS = (WheelView) this.view.findViewById(d.g.min);
        this.cFS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFS.setCurrentItem(i5);
        this.cFS.setGravity(this.gravity);
        this.cFT = (WheelView) this.view.findViewById(d.g.second);
        this.cFT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.cFT.setCurrentItem(i6);
        this.cFT.setGravity(this.gravity);
        this.cFO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.cFY = i8;
                int currentItem = c.this.cFP.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cFU, c.this.cFV));
                    if (currentItem > c.this.cFP.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFP.getAdapter().getItemsCount() - 1;
                        c.this.cFP.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.cFU + currentItem;
                    if (c.this.cFU == c.this.cFV) {
                        c.this.a(i8, i9, c.this.cFW, c.this.cFX, asList, asList2);
                    } else if (i9 == c.this.cFU) {
                        c.this.a(i8, i9, c.this.cFW, 31, asList, asList2);
                    } else if (i9 == c.this.cFV) {
                        c.this.a(i8, i9, 1, c.this.cFX, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.cFU, 12));
                    if (currentItem > c.this.cFP.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFP.getAdapter().getItemsCount() - 1;
                        c.this.cFP.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.cFU + currentItem;
                    if (i10 == c.this.cFU) {
                        c.this.a(i8, i10, c.this.cFW, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.cFV));
                    if (currentItem > c.this.cFP.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.cFP.getAdapter().getItemsCount() - 1;
                        c.this.cFP.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.cFV) {
                        c.this.a(i8, i11, 1, c.this.cFX, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.cFP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.cFP.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.cFZ != null) {
                    c.this.cFZ.ats();
                }
            }
        });
        this.cFP.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void lc(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.cFU + i8) - 1;
                    if (c.this.cFU == c.this.cFV) {
                        c.this.a(c.this.cFY, i9, c.this.cFW, c.this.cFX, asList, asList2);
                    } else if (c.this.cFU == i9) {
                        c.this.a(c.this.cFY, i9, c.this.cFW, 31, asList, asList2);
                    } else if (c.this.cFV == i9) {
                        c.this.a(c.this.cFY, i9, 1, c.this.cFX, asList, asList2);
                    } else {
                        c.this.a(c.this.cFY, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.cFY == c.this.startYear) {
                    int i10 = (c.this.cFU + i8) - 1;
                    if (i10 == c.this.cFU) {
                        c.this.a(c.this.cFY, i10, c.this.cFW, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.cFY, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.cFY == c.this.endYear) {
                    if (i8 == c.this.cFV) {
                        c.this.a(c.this.cFY, c.this.cFP.getCurrentItem() + 1, 1, c.this.cFX, asList, asList2);
                    } else {
                        c.this.a(c.this.cFY, c.this.cFP.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.cFY, i8, 1, 31, asList, asList2);
                }
                if (c.this.cFZ != null) {
                    c.this.cFZ.ats();
                }
            }
        });
        a(this.cFQ);
        a(this.cFR);
        a(this.cFS);
        a(this.cFT);
        if (this.cEB.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.cFO.setVisibility(this.cEB[0] ? 0 : 8);
        this.cFP.setVisibility(this.cEB[1] ? 0 : 8);
        this.cFQ.setVisibility(this.cEB[2] ? 0 : 8);
        this.cFR.setVisibility(this.cEB[3] ? 0 : 8);
        this.cFS.setVisibility(this.cEB[4] ? 0 : 8);
        this.cFT.setVisibility(this.cEB[5] ? 0 : 8);
        atC();
    }

    private void a(WheelView wheelView) {
        if (this.cFZ != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void lc(int i) {
                    c.this.cFZ.ats();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.cFQ.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.cFQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.cFQ.getAdapter().getItemsCount() - 1) {
            this.cFQ.setCurrentItem(this.cFQ.getAdapter().getItemsCount() - 1);
        }
    }

    private void atC() {
        this.cFQ.setTextSize(this.textSize);
        this.cFP.setTextSize(this.textSize);
        this.cFO.setTextSize(this.textSize);
        this.cFR.setTextSize(this.textSize);
        this.cFS.setTextSize(this.textSize);
        this.cFT.setTextSize(this.textSize);
    }

    private void atD() {
        this.cFQ.setTextColorOut(this.cFg);
        this.cFP.setTextColorOut(this.cFg);
        this.cFO.setTextColorOut(this.cFg);
        this.cFR.setTextColorOut(this.cFg);
        this.cFS.setTextColorOut(this.cFg);
        this.cFT.setTextColorOut(this.cFg);
    }

    private void atE() {
        this.cFQ.setTextColorCenter(this.cFh);
        this.cFP.setTextColorCenter(this.cFh);
        this.cFO.setTextColorCenter(this.cFh);
        this.cFR.setTextColorCenter(this.cFh);
        this.cFS.setTextColorCenter(this.cFh);
        this.cFT.setTextColorCenter(this.cFh);
    }

    private void atF() {
        this.cFQ.setDividerColor(this.cFi);
        this.cFP.setDividerColor(this.cFi);
        this.cFO.setDividerColor(this.cFi);
        this.cFR.setDividerColor(this.cFi);
        this.cFS.setDividerColor(this.cFi);
        this.cFT.setDividerColor(this.cFi);
    }

    private void atG() {
        this.cFQ.setDividerType(this.cFo);
        this.cFP.setDividerType(this.cFo);
        this.cFO.setDividerType(this.cFo);
        this.cFR.setDividerType(this.cFo);
        this.cFS.setDividerType(this.cFo);
        this.cFT.setDividerType(this.cFo);
    }

    private void atH() {
        this.cFQ.setLineSpacingMultiplier(this.cFj);
        this.cFP.setLineSpacingMultiplier(this.cFj);
        this.cFO.setLineSpacingMultiplier(this.cFj);
        this.cFR.setLineSpacingMultiplier(this.cFj);
        this.cFS.setLineSpacingMultiplier(this.cFj);
        this.cFT.setLineSpacingMultiplier(this.cFj);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.cEG) {
            if (str != null) {
                this.cFO.setLabel(str);
            } else {
                this.cFO.setLabel(this.view.getContext().getString(d.j.pickerview_year));
            }
            if (str2 != null) {
                this.cFP.setLabel(str2);
            } else {
                this.cFP.setLabel(this.view.getContext().getString(d.j.pickerview_month));
            }
            if (str3 != null) {
                this.cFQ.setLabel(str3);
            } else {
                this.cFQ.setLabel(this.view.getContext().getString(d.j.pickerview_day));
            }
            if (str4 != null) {
                this.cFR.setLabel(str4);
            } else {
                this.cFR.setLabel(this.view.getContext().getString(d.j.pickerview_hours));
            }
            if (str5 != null) {
                this.cFS.setLabel(str5);
            } else {
                this.cFS.setLabel(this.view.getContext().getString(d.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.cFT.setLabel(str6);
            } else {
                this.cFT.setLabel(this.view.getContext().getString(d.j.pickerview_seconds));
            }
        }
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cFQ.setTextXOffset(i);
        this.cFP.setTextXOffset(i2);
        this.cFO.setTextXOffset(i3);
        this.cFR.setTextXOffset(i4);
        this.cFS.setTextXOffset(i5);
        this.cFT.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.cFO.setCyclic(z);
        this.cFP.setCyclic(z);
        this.cFQ.setCyclic(z);
        this.cFR.setCyclic(z);
        this.cFS.setCyclic(z);
        this.cFT.setCyclic(z);
    }

    public String getTime() {
        if (this.cEG) {
            return atI();
        }
        StringBuilder sb = new StringBuilder();
        if (this.cFY == this.startYear) {
            if (this.cFP.getCurrentItem() + this.cFU == this.cFU) {
                sb.append(this.cFO.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFP.getCurrentItem() + this.cFU).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFQ.getCurrentItem() + this.cFW).append(" ").append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFT.getCurrentItem());
            } else {
                sb.append(this.cFO.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFP.getCurrentItem() + this.cFU).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFQ.getCurrentItem() + 1).append(" ").append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFT.getCurrentItem());
            }
        } else {
            sb.append(this.cFO.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFP.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.cFQ.getCurrentItem() + 1).append(" ").append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFT.getCurrentItem());
        }
        return sb.toString();
    }

    private String atI() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.cFO.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem2) == 0) {
            currentItem = this.cFP.getCurrentItem() + 1;
            z = false;
        } else if ((this.cFP.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem2) <= 0) {
            currentItem = this.cFP.getCurrentItem() + 1;
            z = false;
        } else if ((this.cFP.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.kW(currentItem2) == 1) {
            currentItem = this.cFP.getCurrentItem();
            z = true;
        } else {
            currentItem = this.cFP.getCurrentItem();
            z = false;
        }
        int[] e = com.baidu.tbadk.widget.timepicker.a.e.b.e(currentItem2, currentItem, this.cFQ.getCurrentItem() + 1, z);
        sb.append(e[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(e[2]).append(" ").append(this.cFR.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFS.getCurrentItem()).append(Config.TRACE_TODAY_VISIT_SPLIT).append(this.cFT.getCurrentItem());
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
                this.cFV = i2;
                this.cFX = i3;
            } else if (i == this.startYear) {
                if (i2 > this.cFU) {
                    this.endYear = i;
                    this.cFV = i2;
                    this.cFX = i3;
                } else if (i2 == this.cFU && i3 > this.cFW) {
                    this.endYear = i;
                    this.cFV = i2;
                    this.cFX = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.cFU = i5;
                this.cFW = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.cFV) {
                    this.cFU = i5;
                    this.cFW = i6;
                    this.startYear = i4;
                } else if (i5 == this.cFV && i6 < this.cFX) {
                    this.cFU = i5;
                    this.cFW = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.cFU = calendar.get(2) + 1;
            this.cFV = calendar2.get(2) + 1;
            this.cFW = calendar.get(5);
            this.cFX = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.cFj = f;
        atH();
    }

    public void setDividerColor(int i) {
        this.cFi = i;
        atF();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.cFo = dividerType;
        atG();
    }

    public void setTextColorCenter(int i) {
        this.cFh = i;
        atE();
    }

    public void setTextColorOut(int i) {
        this.cFg = i;
        atD();
    }

    public void fz(boolean z) {
        this.cFQ.fz(z);
        this.cFP.fz(z);
        this.cFO.fz(z);
        this.cFR.fz(z);
        this.cFS.fz(z);
        this.cFT.fz(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.cFZ = bVar;
    }
}
