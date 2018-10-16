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
    public static DateFormat bpA = new SimpleDateFormat(AiAppDateTimeUtil.TIME_FORMAT);
    private int boT;
    private int boU;
    private int boV;
    private float boW;
    private boolean[] boo;
    private WheelView bpB;
    private WheelView bpC;
    private WheelView bpD;
    private WheelView bpE;
    private WheelView bpF;
    private WheelView bpG;
    private int bpL;
    private com.baidu.tbadk.widget.timepicker.a.d.b bpM;
    private WheelView.DividerType bpb;
    private int gravity;
    private int textSize;
    private View view;
    private int startYear = BdDatePicker.START_YEAR;
    private int endYear = 2100;
    private int bpH = 1;
    private int bpI = 12;
    private int bpJ = 1;
    private int bpK = 31;
    private boolean bot = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.boo = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void cN(boolean z) {
        this.bot = z;
    }

    public void e(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.bot) {
            int[] v = com.baidu.tbadk.widget.timepicker.a.e.b.v(i, i2 + 1, i3);
            a(v[0], v[1] - 1, v[2], v[3] == 1, i4, i5, i6);
            return;
        }
        f(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.bpB = (WheelView) this.view.findViewById(e.g.year);
        this.bpB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.V(this.startYear, this.endYear)));
        this.bpB.setLabel("");
        this.bpB.setCurrentItem(i - this.startYear);
        this.bpB.setGravity(this.gravity);
        this.bpC = (WheelView) this.view.findViewById(e.g.month);
        this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gH(i)));
        this.bpC.setLabel("");
        int gE = com.baidu.tbadk.widget.timepicker.a.e.a.gE(i);
        if (gE != 0 && (i2 > gE - 1 || z)) {
            this.bpC.setCurrentItem(i2 + 1);
        } else {
            this.bpC.setCurrentItem(i2);
        }
        this.bpC.setGravity(this.gravity);
        this.bpD = (WheelView) this.view.findViewById(e.g.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.gE(i) == 0) {
            this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.U(i, i2))));
        } else {
            this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.gD(i))));
        }
        this.bpD.setLabel("");
        this.bpD.setCurrentItem(i3 - 1);
        this.bpD.setGravity(this.gravity);
        this.bpE = (WheelView) this.view.findViewById(e.g.hour);
        this.bpE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.bpE.setCurrentItem(i4);
        this.bpE.setGravity(this.gravity);
        this.bpF = (WheelView) this.view.findViewById(e.g.min);
        this.bpF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bpF.setCurrentItem(i5);
        this.bpF.setGravity(this.gravity);
        this.bpG = (WheelView) this.view.findViewById(e.g.second);
        this.bpG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bpG.setCurrentItem(i5);
        this.bpG.setGravity(this.gravity);
        this.bpB.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gK(int i7) {
                int U;
                int i8 = c.this.startYear + i7;
                c.this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gH(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gE(i8) == 0 || c.this.bpC.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.gE(i8) - 1) {
                    c.this.bpC.setCurrentItem(c.this.bpC.getCurrentItem());
                } else {
                    c.this.bpC.setCurrentItem(c.this.bpC.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gE(i8) == 0 || c.this.bpC.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.gE(i8) - 1) {
                    c.this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.bpC.getCurrentItem() + 1))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.bpC.getCurrentItem() + 1);
                } else if (c.this.bpC.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.gE(i8) + 1) {
                    c.this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.gD(i8))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.gD(i8);
                } else {
                    c.this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.bpC.getCurrentItem()))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(i8, c.this.bpC.getCurrentItem());
                }
                if (c.this.bpD.getCurrentItem() > U - 1) {
                    c.this.bpD.setCurrentItem(U - 1);
                }
                if (c.this.bpM != null) {
                    c.this.bpM.RJ();
                }
            }
        });
        this.bpC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gK(int i7) {
                int U;
                int currentItem = c.this.bpB.getCurrentItem() + c.this.startYear;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.gE(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.gE(currentItem) - 1) {
                    c.this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7 + 1))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7 + 1);
                } else if (c.this.bpC.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.gE(currentItem) + 1) {
                    c.this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.gD(currentItem))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.gD(currentItem);
                } else {
                    c.this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.gI(com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7))));
                    U = com.baidu.tbadk.widget.timepicker.a.e.a.U(currentItem, i7);
                }
                if (c.this.bpD.getCurrentItem() > U - 1) {
                    c.this.bpD.setCurrentItem(U - 1);
                }
                if (c.this.bpM != null) {
                    c.this.bpM.RJ();
                }
            }
        });
        a(this.bpD);
        a(this.bpE);
        a(this.bpF);
        a(this.bpG);
        if (this.boo.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.bpB.setVisibility(this.boo[0] ? 0 : 8);
        this.bpC.setVisibility(this.boo[1] ? 0 : 8);
        this.bpD.setVisibility(this.boo[2] ? 0 : 8);
        this.bpE.setVisibility(this.boo[3] ? 0 : 8);
        this.bpF.setVisibility(this.boo[4] ? 0 : 8);
        this.bpG.setVisibility(this.boo[5] ? 0 : 8);
        RT();
    }

    private void f(int i, int i2, int i3, int i4, int i5, int i6) {
        String[] strArr = {"1", "3", "5", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR};
        String[] strArr2 = {"4", Constants.VIA_SHARE_TYPE_INFO, "9", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.bpL = i;
        this.bpB = (WheelView) this.view.findViewById(e.g.year);
        this.bpB.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.startYear, this.endYear));
        this.bpB.setCurrentItem(i - this.startYear);
        this.bpB.setGravity(this.gravity);
        this.bpC = (WheelView) this.view.findViewById(e.g.month);
        if (this.startYear == this.endYear) {
            this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpH, this.bpI));
            this.bpC.setCurrentItem((i2 + 1) - this.bpH);
        } else if (i == this.startYear) {
            this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpH, 12));
            this.bpC.setCurrentItem((i2 + 1) - this.bpH);
        } else if (i == this.endYear) {
            this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bpI));
            this.bpC.setCurrentItem(i2);
        } else {
            this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.bpC.setCurrentItem(i2);
        }
        this.bpC.setGravity(this.gravity);
        this.bpD = (WheelView) this.view.findViewById(e.g.day);
        if (this.startYear == this.endYear && this.bpH == this.bpI) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.bpK > 31) {
                    this.bpK = 31;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, this.bpK));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.bpK > 30) {
                    this.bpK = 30;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, this.bpK));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.bpK > 29) {
                    this.bpK = 29;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, this.bpK));
            } else {
                if (this.bpK > 28) {
                    this.bpK = 28;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, this.bpK));
            }
            this.bpD.setCurrentItem(i3 - this.bpJ);
        } else if (i == this.startYear && i2 + 1 == this.bpH) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, 29));
            } else {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.bpJ, 28));
            }
            this.bpD.setCurrentItem(i3 - this.bpJ);
        } else if (i == this.endYear && i2 + 1 == this.bpI) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.bpK > 31) {
                    this.bpK = 31;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bpK));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.bpK > 30) {
                    this.bpK = 30;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bpK));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.bpK > 29) {
                    this.bpK = 29;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bpK));
            } else {
                if (this.bpK > 28) {
                    this.bpK = 28;
                }
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.bpK));
            }
            this.bpD.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.bpD.setCurrentItem(i3 - 1);
        }
        this.bpD.setGravity(this.gravity);
        this.bpE = (WheelView) this.view.findViewById(e.g.hour);
        this.bpE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.bpE.setCurrentItem(i4);
        this.bpE.setGravity(this.gravity);
        this.bpF = (WheelView) this.view.findViewById(e.g.min);
        this.bpF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bpF.setCurrentItem(i5);
        this.bpF.setGravity(this.gravity);
        this.bpG = (WheelView) this.view.findViewById(e.g.second);
        this.bpG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.bpG.setCurrentItem(i6);
        this.bpG.setGravity(this.gravity);
        this.bpB.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gK(int i7) {
                int i8 = i7 + c.this.startYear;
                c.this.bpL = i8;
                int currentItem = c.this.bpC.getCurrentItem();
                if (c.this.startYear == c.this.endYear) {
                    c.this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.bpH, c.this.bpI));
                    if (currentItem > c.this.bpC.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.bpC.getAdapter().getItemsCount() - 1;
                        c.this.bpC.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.bpH + currentItem;
                    if (c.this.bpH == c.this.bpI) {
                        c.this.a(i8, i9, c.this.bpJ, c.this.bpK, asList, asList2);
                    } else if (i9 == c.this.bpH) {
                        c.this.a(i8, i9, c.this.bpJ, 31, asList, asList2);
                    } else if (i9 == c.this.bpI) {
                        c.this.a(i8, i9, 1, c.this.bpK, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.startYear) {
                    c.this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.bpH, 12));
                    if (currentItem > c.this.bpC.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.bpC.getAdapter().getItemsCount() - 1;
                        c.this.bpC.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.bpH + currentItem;
                    if (i10 == c.this.bpH) {
                        c.this.a(i8, i10, c.this.bpJ, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.endYear) {
                    c.this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.bpI));
                    if (currentItem > c.this.bpC.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.bpC.getAdapter().getItemsCount() - 1;
                        c.this.bpC.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.bpI) {
                        c.this.a(i8, i11, 1, c.this.bpK, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.bpC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.bpC.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.bpM != null) {
                    c.this.bpM.RJ();
                }
            }
        });
        this.bpC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void gK(int i7) {
                int i8 = i7 + 1;
                if (c.this.startYear == c.this.endYear) {
                    int i9 = (c.this.bpH + i8) - 1;
                    if (c.this.bpH == c.this.bpI) {
                        c.this.a(c.this.bpL, i9, c.this.bpJ, c.this.bpK, asList, asList2);
                    } else if (c.this.bpH == i9) {
                        c.this.a(c.this.bpL, i9, c.this.bpJ, 31, asList, asList2);
                    } else if (c.this.bpI == i9) {
                        c.this.a(c.this.bpL, i9, 1, c.this.bpK, asList, asList2);
                    } else {
                        c.this.a(c.this.bpL, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.bpL == c.this.startYear) {
                    int i10 = (c.this.bpH + i8) - 1;
                    if (i10 == c.this.bpH) {
                        c.this.a(c.this.bpL, i10, c.this.bpJ, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.bpL, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.bpL == c.this.endYear) {
                    if (i8 == c.this.bpI) {
                        c.this.a(c.this.bpL, c.this.bpC.getCurrentItem() + 1, 1, c.this.bpK, asList, asList2);
                    } else {
                        c.this.a(c.this.bpL, c.this.bpC.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.bpL, i8, 1, 31, asList, asList2);
                }
                if (c.this.bpM != null) {
                    c.this.bpM.RJ();
                }
            }
        });
        a(this.bpD);
        a(this.bpE);
        a(this.bpF);
        a(this.bpG);
        if (this.boo.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.bpB.setVisibility(this.boo[0] ? 0 : 8);
        this.bpC.setVisibility(this.boo[1] ? 0 : 8);
        this.bpD.setVisibility(this.boo[2] ? 0 : 8);
        this.bpE.setVisibility(this.boo[3] ? 0 : 8);
        this.bpF.setVisibility(this.boo[4] ? 0 : 8);
        this.bpG.setVisibility(this.boo[5] ? 0 : 8);
        RT();
    }

    private void a(WheelView wheelView) {
        if (this.bpM != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void gK(int i) {
                    c.this.bpM.RJ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.bpD.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.bpD.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.bpD.getAdapter().getItemsCount() - 1) {
            this.bpD.setCurrentItem(this.bpD.getAdapter().getItemsCount() - 1);
        }
    }

    private void RT() {
        this.bpD.setTextSize(this.textSize);
        this.bpC.setTextSize(this.textSize);
        this.bpB.setTextSize(this.textSize);
        this.bpE.setTextSize(this.textSize);
        this.bpF.setTextSize(this.textSize);
        this.bpG.setTextSize(this.textSize);
    }

    private void RU() {
        this.bpD.setTextColorOut(this.boT);
        this.bpC.setTextColorOut(this.boT);
        this.bpB.setTextColorOut(this.boT);
        this.bpE.setTextColorOut(this.boT);
        this.bpF.setTextColorOut(this.boT);
        this.bpG.setTextColorOut(this.boT);
    }

    private void RV() {
        this.bpD.setTextColorCenter(this.boU);
        this.bpC.setTextColorCenter(this.boU);
        this.bpB.setTextColorCenter(this.boU);
        this.bpE.setTextColorCenter(this.boU);
        this.bpF.setTextColorCenter(this.boU);
        this.bpG.setTextColorCenter(this.boU);
    }

    private void RW() {
        this.bpD.setDividerColor(this.boV);
        this.bpC.setDividerColor(this.boV);
        this.bpB.setDividerColor(this.boV);
        this.bpE.setDividerColor(this.boV);
        this.bpF.setDividerColor(this.boV);
        this.bpG.setDividerColor(this.boV);
    }

    private void RX() {
        this.bpD.setDividerType(this.bpb);
        this.bpC.setDividerType(this.bpb);
        this.bpB.setDividerType(this.bpb);
        this.bpE.setDividerType(this.bpb);
        this.bpF.setDividerType(this.bpb);
        this.bpG.setDividerType(this.bpb);
    }

    private void RY() {
        this.bpD.setLineSpacingMultiplier(this.boW);
        this.bpC.setLineSpacingMultiplier(this.boW);
        this.bpB.setLineSpacingMultiplier(this.boW);
        this.bpE.setLineSpacingMultiplier(this.boW);
        this.bpF.setLineSpacingMultiplier(this.boW);
        this.bpG.setLineSpacingMultiplier(this.boW);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.bot) {
            if (str != null) {
                this.bpB.setLabel(str);
            } else {
                this.bpB.setLabel(this.view.getContext().getString(e.j.pickerview_year));
            }
            if (str2 != null) {
                this.bpC.setLabel(str2);
            } else {
                this.bpC.setLabel(this.view.getContext().getString(e.j.pickerview_month));
            }
            if (str3 != null) {
                this.bpD.setLabel(str3);
            } else {
                this.bpD.setLabel(this.view.getContext().getString(e.j.pickerview_day));
            }
            if (str4 != null) {
                this.bpE.setLabel(str4);
            } else {
                this.bpE.setLabel(this.view.getContext().getString(e.j.pickerview_hours));
            }
            if (str5 != null) {
                this.bpF.setLabel(str5);
            } else {
                this.bpF.setLabel(this.view.getContext().getString(e.j.pickerview_minutes));
            }
            if (str6 != null) {
                this.bpG.setLabel(str6);
            } else {
                this.bpG.setLabel(this.view.getContext().getString(e.j.pickerview_seconds));
            }
        }
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bpD.setTextXOffset(i);
        this.bpC.setTextXOffset(i2);
        this.bpB.setTextXOffset(i3);
        this.bpE.setTextXOffset(i4);
        this.bpF.setTextXOffset(i5);
        this.bpG.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.bpB.setCyclic(z);
        this.bpC.setCyclic(z);
        this.bpD.setCyclic(z);
        this.bpE.setCyclic(z);
        this.bpF.setCyclic(z);
        this.bpG.setCyclic(z);
    }

    public String getTime() {
        if (this.bot) {
            return RZ();
        }
        StringBuilder sb = new StringBuilder();
        if (this.bpL == this.startYear) {
            if (this.bpC.getCurrentItem() + this.bpH == this.bpH) {
                sb.append(this.bpB.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bpC.getCurrentItem() + this.bpH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bpD.getCurrentItem() + this.bpJ).append(" ").append(this.bpE.getCurrentItem()).append(":").append(this.bpF.getCurrentItem()).append(":").append(this.bpG.getCurrentItem());
            } else {
                sb.append(this.bpB.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bpC.getCurrentItem() + this.bpH).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bpD.getCurrentItem() + 1).append(" ").append(this.bpE.getCurrentItem()).append(":").append(this.bpF.getCurrentItem()).append(":").append(this.bpG.getCurrentItem());
            }
        } else {
            sb.append(this.bpB.getCurrentItem() + this.startYear).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bpC.getCurrentItem() + 1).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.bpD.getCurrentItem() + 1).append(" ").append(this.bpE.getCurrentItem()).append(":").append(this.bpF.getCurrentItem()).append(":").append(this.bpG.getCurrentItem());
        }
        return sb.toString();
    }

    private String RZ() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.bpB.getCurrentItem() + this.startYear;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.gE(currentItem2) == 0) {
            currentItem = this.bpC.getCurrentItem() + 1;
            z = false;
        } else if ((this.bpC.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.gE(currentItem2) <= 0) {
            currentItem = this.bpC.getCurrentItem() + 1;
            z = false;
        } else if ((this.bpC.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.gE(currentItem2) == 1) {
            currentItem = this.bpC.getCurrentItem();
            z = true;
        } else {
            currentItem = this.bpC.getCurrentItem();
            z = false;
        }
        int[] b = com.baidu.tbadk.widget.timepicker.a.e.b.b(currentItem2, currentItem, this.bpD.getCurrentItem() + 1, z);
        sb.append(b[0]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[1]).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(b[2]).append(" ").append(this.bpE.getCurrentItem()).append(":").append(this.bpF.getCurrentItem()).append(":").append(this.bpG.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public void gJ(int i) {
        this.endYear = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.startYear) {
                this.endYear = i;
                this.bpI = i2;
                this.bpK = i3;
            } else if (i == this.startYear) {
                if (i2 > this.bpH) {
                    this.endYear = i;
                    this.bpI = i2;
                    this.bpK = i3;
                } else if (i2 == this.bpH && i3 > this.bpJ) {
                    this.endYear = i;
                    this.bpI = i2;
                    this.bpK = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.endYear) {
                this.bpH = i5;
                this.bpJ = i6;
                this.startYear = i4;
            } else if (i4 == this.endYear) {
                if (i5 < this.bpI) {
                    this.bpH = i5;
                    this.bpJ = i6;
                    this.startYear = i4;
                } else if (i5 == this.bpI && i6 < this.bpK) {
                    this.bpH = i5;
                    this.bpJ = i6;
                    this.startYear = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.bpH = calendar.get(2) + 1;
            this.bpI = calendar2.get(2) + 1;
            this.bpJ = calendar.get(5);
            this.bpK = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.boW = f;
        RY();
    }

    public void setDividerColor(int i) {
        this.boV = i;
        RW();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.bpb = dividerType;
        RX();
    }

    public void setTextColorCenter(int i) {
        this.boU = i;
        RV();
    }

    public void setTextColorOut(int i) {
        this.boT = i;
        RU();
    }

    public void cO(boolean z) {
        this.bpD.cO(z);
        this.bpC.cO(z);
        this.bpB.cO(z);
        this.bpE.cO(z);
        this.bpF.cO(z);
        this.bpG.cO(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.bpM = bVar;
    }
}
