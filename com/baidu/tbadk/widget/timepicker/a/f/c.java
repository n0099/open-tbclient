package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes21.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private boolean[] fKH;
    private WheelView fLN;
    private WheelView fLO;
    private WheelView fLP;
    private WheelView fLQ;
    private WheelView fLR;
    private WheelView fLS;
    private int fLX;
    private com.baidu.tbadk.widget.timepicker.a.d.b fLY;
    private WheelView.DividerType fLr;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int fKL = FeatureCodes.SKY_SEG;
    private int fKM = 2100;
    private int fLT = 1;
    private int fLU = 12;
    private int fLV = 1;
    private int fLW = 31;
    private boolean fKO = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.fKH = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void la(boolean z) {
        this.fKO = z;
    }

    public void g(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.fKO) {
            int[] C = com.baidu.tbadk.widget.timepicker.a.e.b.C(i, i2 + 1, i3);
            a(C[0], C[1] - 1, C[2], C[3] == 1, i4, i5, i6);
            return;
        }
        h(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.fLN = (WheelView) this.view.findViewById(R.id.year);
        this.fLN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bv(this.fKL, this.fKM)));
        this.fLN.setLabel("");
        this.fLN.setCurrentItem(i - this.fKL);
        this.fLN.setGravity(this.gravity);
        this.fLO = (WheelView) this.view.findViewById(R.id.month);
        this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sR(i)));
        this.fLO.setLabel("");
        int sO = com.baidu.tbadk.widget.timepicker.a.e.a.sO(i);
        if (sO != 0 && (i2 > sO - 1 || z)) {
            this.fLO.setCurrentItem(i2 + 1);
        } else {
            this.fLO.setCurrentItem(i2);
        }
        this.fLO.setGravity(this.gravity);
        this.fLP = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sO(i) == 0) {
            this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i, i2))));
        } else {
            this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.sN(i))));
        }
        this.fLP.setLabel("");
        this.fLP.setCurrentItem(i3 - 1);
        this.fLP.setGravity(this.gravity);
        this.fLQ = (WheelView) this.view.findViewById(R.id.hour);
        this.fLQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fLQ.setCurrentItem(i4);
        this.fLQ.setGravity(this.gravity);
        this.fLR = (WheelView) this.view.findViewById(R.id.min);
        this.fLR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLR.setCurrentItem(i5);
        this.fLR.setGravity(this.gravity);
        this.fLS = (WheelView) this.view.findViewById(R.id.second);
        this.fLS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLS.setCurrentItem(i5);
        this.fLS.setGravity(this.gravity);
        this.fLN.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int i8 = c.this.fKL + i7;
                c.this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sR(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sO(i8) == 0 || c.this.fLO.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sO(i8) - 1) {
                    c.this.fLO.setCurrentItem(c.this.fLO.getCurrentItem());
                } else {
                    c.this.fLO.setCurrentItem(c.this.fLO.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sO(i8) == 0 || c.this.fLO.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.sO(i8) - 1) {
                    c.this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLO.getCurrentItem() + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLO.getCurrentItem() + 1);
                } else if (c.this.fLO.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sO(i8) + 1) {
                    c.this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.sN(i8))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.sN(i8);
                } else {
                    c.this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLO.getCurrentItem()))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(i8, c.this.fLO.getCurrentItem());
                }
                if (c.this.fLP.getCurrentItem() > bu - 1) {
                    c.this.fLP.setCurrentItem(bu - 1);
                }
                if (c.this.fLY != null) {
                    c.this.fLY.bGM();
                }
            }
        });
        this.fLO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bu;
                int currentItem = c.this.fLN.getCurrentItem() + c.this.fKL;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.sO(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.sO(currentItem) - 1) {
                    c.this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7 + 1);
                } else if (c.this.fLO.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.sO(currentItem) + 1) {
                    c.this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.sN(currentItem))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.sN(currentItem);
                } else {
                    c.this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.sS(com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7))));
                    bu = com.baidu.tbadk.widget.timepicker.a.e.a.bu(currentItem, i7);
                }
                if (c.this.fLP.getCurrentItem() > bu - 1) {
                    c.this.fLP.setCurrentItem(bu - 1);
                }
                if (c.this.fLY != null) {
                    c.this.fLY.bGM();
                }
            }
        });
        a(this.fLP);
        a(this.fLQ);
        a(this.fLR);
        a(this.fLS);
        if (this.fKH.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.fLN.setVisibility(this.fKH[0] ? 0 : 8);
        this.fLO.setVisibility(this.fKH[1] ? 0 : 8);
        this.fLP.setVisibility(this.fKH[2] ? 0 : 8);
        this.fLQ.setVisibility(this.fKH[3] ? 0 : 8);
        this.fLR.setVisibility(this.fKH[4] ? 0 : 8);
        this.fLS.setVisibility(this.fKH[5] ? 0 : 8);
        bGU();
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.fLX = i;
        this.fLN = (WheelView) this.view.findViewById(R.id.year);
        this.fLN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fKL, this.fKM));
        this.fLN.setCurrentItem(i - this.fKL);
        this.fLN.setGravity(this.gravity);
        this.fLO = (WheelView) this.view.findViewById(R.id.month);
        if (this.fKL == this.fKM) {
            this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLT, this.fLU));
            this.fLO.setCurrentItem((i2 + 1) - this.fLT);
        } else if (i == this.fKL) {
            this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLT, 12));
            this.fLO.setCurrentItem((i2 + 1) - this.fLT);
        } else if (i == this.fKM) {
            this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLU));
            this.fLO.setCurrentItem(i2);
        } else {
            this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.fLO.setCurrentItem(i2);
        }
        this.fLO.setGravity(this.gravity);
        this.fLP = (WheelView) this.view.findViewById(R.id.day);
        if (this.fKL == this.fKM && this.fLT == this.fLU) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fLW > 31) {
                    this.fLW = 31;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, this.fLW));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fLW > 30) {
                    this.fLW = 30;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, this.fLW));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fLW > 29) {
                    this.fLW = 29;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, this.fLW));
            } else {
                if (this.fLW > 28) {
                    this.fLW = 28;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, this.fLW));
            }
            this.fLP.setCurrentItem(i3 - this.fLV);
        } else if (i == this.fKL && i2 + 1 == this.fLT) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, 29));
            } else {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.fLV, 28));
            }
            this.fLP.setCurrentItem(i3 - this.fLV);
        } else if (i == this.fKM && i2 + 1 == this.fLU) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.fLW > 31) {
                    this.fLW = 31;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLW));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.fLW > 30) {
                    this.fLW = 30;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLW));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.fLW > 29) {
                    this.fLW = 29;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLW));
            } else {
                if (this.fLW > 28) {
                    this.fLW = 28;
                }
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.fLW));
            }
            this.fLP.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.fLP.setCurrentItem(i3 - 1);
        }
        this.fLP.setGravity(this.gravity);
        this.fLQ = (WheelView) this.view.findViewById(R.id.hour);
        this.fLQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.fLQ.setCurrentItem(i4);
        this.fLQ.setGravity(this.gravity);
        this.fLR = (WheelView) this.view.findViewById(R.id.min);
        this.fLR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLR.setCurrentItem(i5);
        this.fLR.setGravity(this.gravity);
        this.fLS = (WheelView) this.view.findViewById(R.id.second);
        this.fLS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.fLS.setCurrentItem(i6);
        this.fLS.setGravity(this.gravity);
        this.fLN.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.fKL;
                c.this.fLX = i8;
                int currentItem = c.this.fLO.getCurrentItem();
                if (c.this.fKL == c.this.fKM) {
                    c.this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fLT, c.this.fLU));
                    if (currentItem > c.this.fLO.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fLO.getAdapter().getItemsCount() - 1;
                        c.this.fLO.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.fLT + currentItem;
                    if (c.this.fLT == c.this.fLU) {
                        c.this.a(i8, i9, c.this.fLV, c.this.fLW, asList, asList2);
                    } else if (i9 == c.this.fLT) {
                        c.this.a(i8, i9, c.this.fLV, 31, asList, asList2);
                    } else if (i9 == c.this.fLU) {
                        c.this.a(i8, i9, 1, c.this.fLW, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fKL) {
                    c.this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.fLT, 12));
                    if (currentItem > c.this.fLO.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fLO.getAdapter().getItemsCount() - 1;
                        c.this.fLO.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.fLT + currentItem;
                    if (i10 == c.this.fLT) {
                        c.this.a(i8, i10, c.this.fLV, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.fKM) {
                    c.this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.fLU));
                    if (currentItem > c.this.fLO.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.fLO.getAdapter().getItemsCount() - 1;
                        c.this.fLO.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.fLU) {
                        c.this.a(i8, i11, 1, c.this.fLW, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.fLO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.fLO.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.fLY != null) {
                    c.this.fLY.bGM();
                }
            }
        });
        this.fLO.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.fKL == c.this.fKM) {
                    int i9 = (c.this.fLT + i8) - 1;
                    if (c.this.fLT == c.this.fLU) {
                        c.this.a(c.this.fLX, i9, c.this.fLV, c.this.fLW, asList, asList2);
                    } else if (c.this.fLT == i9) {
                        c.this.a(c.this.fLX, i9, c.this.fLV, 31, asList, asList2);
                    } else if (c.this.fLU == i9) {
                        c.this.a(c.this.fLX, i9, 1, c.this.fLW, asList, asList2);
                    } else {
                        c.this.a(c.this.fLX, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.fLX == c.this.fKL) {
                    int i10 = (c.this.fLT + i8) - 1;
                    if (i10 == c.this.fLT) {
                        c.this.a(c.this.fLX, i10, c.this.fLV, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.fLX, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.fLX == c.this.fKM) {
                    if (i8 == c.this.fLU) {
                        c.this.a(c.this.fLX, c.this.fLO.getCurrentItem() + 1, 1, c.this.fLW, asList, asList2);
                    } else {
                        c.this.a(c.this.fLX, c.this.fLO.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.fLX, i8, 1, 31, asList, asList2);
                }
                if (c.this.fLY != null) {
                    c.this.fLY.bGM();
                }
            }
        });
        a(this.fLP);
        a(this.fLQ);
        a(this.fLR);
        a(this.fLS);
        if (this.fKH.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.fLN.setVisibility(this.fKH[0] ? 0 : 8);
        this.fLO.setVisibility(this.fKH[1] ? 0 : 8);
        this.fLP.setVisibility(this.fKH[2] ? 0 : 8);
        this.fLQ.setVisibility(this.fKH[3] ? 0 : 8);
        this.fLR.setVisibility(this.fKH[4] ? 0 : 8);
        this.fLS.setVisibility(this.fKH[5] ? 0 : 8);
        bGU();
    }

    private void a(WheelView wheelView) {
        if (this.fLY != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.fLY.bGM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.fLP.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.fLP.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.fLP.getAdapter().getItemsCount() - 1) {
            this.fLP.setCurrentItem(this.fLP.getAdapter().getItemsCount() - 1);
        }
    }

    private void bGU() {
        this.fLP.setTextSize(this.textSize);
        this.fLO.setTextSize(this.textSize);
        this.fLN.setTextSize(this.textSize);
        this.fLQ.setTextSize(this.textSize);
        this.fLR.setTextSize(this.textSize);
        this.fLS.setTextSize(this.textSize);
    }

    private void bGV() {
        this.fLP.setTextColorOut(this.textColorOut);
        this.fLO.setTextColorOut(this.textColorOut);
        this.fLN.setTextColorOut(this.textColorOut);
        this.fLQ.setTextColorOut(this.textColorOut);
        this.fLR.setTextColorOut(this.textColorOut);
        this.fLS.setTextColorOut(this.textColorOut);
    }

    private void bGW() {
        this.fLP.setTextColorCenter(this.textColorCenter);
        this.fLO.setTextColorCenter(this.textColorCenter);
        this.fLN.setTextColorCenter(this.textColorCenter);
        this.fLQ.setTextColorCenter(this.textColorCenter);
        this.fLR.setTextColorCenter(this.textColorCenter);
        this.fLS.setTextColorCenter(this.textColorCenter);
    }

    private void bGX() {
        this.fLP.setDividerColor(this.dividerColor);
        this.fLO.setDividerColor(this.dividerColor);
        this.fLN.setDividerColor(this.dividerColor);
        this.fLQ.setDividerColor(this.dividerColor);
        this.fLR.setDividerColor(this.dividerColor);
        this.fLS.setDividerColor(this.dividerColor);
    }

    private void bGY() {
        this.fLP.setDividerType(this.fLr);
        this.fLO.setDividerType(this.fLr);
        this.fLN.setDividerType(this.fLr);
        this.fLQ.setDividerType(this.fLr);
        this.fLR.setDividerType(this.fLr);
        this.fLS.setDividerType(this.fLr);
    }

    private void bGZ() {
        this.fLP.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLO.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLN.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLQ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLR.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.fLS.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void d(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.fKO) {
            if (str != null) {
                this.fLN.setLabel(str);
            } else {
                this.fLN.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.fLO.setLabel(str2);
            } else {
                this.fLO.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.fLP.setLabel(str3);
            } else {
                this.fLP.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.fLQ.setLabel(str4);
            } else {
                this.fLQ.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.fLR.setLabel(str5);
            } else {
                this.fLR.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.fLS.setLabel(str6);
            } else {
                this.fLS.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void i(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fLP.setTextXOffset(i);
        this.fLO.setTextXOffset(i2);
        this.fLN.setTextXOffset(i3);
        this.fLQ.setTextXOffset(i4);
        this.fLR.setTextXOffset(i5);
        this.fLS.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.fLN.setCyclic(z);
        this.fLO.setCyclic(z);
        this.fLP.setCyclic(z);
        this.fLQ.setCyclic(z);
        this.fLR.setCyclic(z);
        this.fLS.setCyclic(z);
    }

    public String getTime() {
        if (this.fKO) {
            return bHa();
        }
        StringBuilder sb = new StringBuilder();
        if (this.fLX == this.fKL) {
            if (this.fLO.getCurrentItem() + this.fLT == this.fLT) {
                sb.append(this.fLN.getCurrentItem() + this.fKL).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLO.getCurrentItem() + this.fLT).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLP.getCurrentItem() + this.fLV).append(" ").append(this.fLQ.getCurrentItem()).append(":").append(this.fLR.getCurrentItem()).append(":").append(this.fLS.getCurrentItem());
            } else {
                sb.append(this.fLN.getCurrentItem() + this.fKL).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLO.getCurrentItem() + this.fLT).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLP.getCurrentItem() + 1).append(" ").append(this.fLQ.getCurrentItem()).append(":").append(this.fLR.getCurrentItem()).append(":").append(this.fLS.getCurrentItem());
            }
        } else {
            sb.append(this.fLN.getCurrentItem() + this.fKL).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLO.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.fLP.getCurrentItem() + 1).append(" ").append(this.fLQ.getCurrentItem()).append(":").append(this.fLR.getCurrentItem()).append(":").append(this.fLS.getCurrentItem());
        }
        return sb.toString();
    }

    private String bHa() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.fLN.getCurrentItem() + this.fKL;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.sO(currentItem2) == 0) {
            currentItem = this.fLO.getCurrentItem() + 1;
            z = false;
        } else if ((this.fLO.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sO(currentItem2) <= 0) {
            currentItem = this.fLO.getCurrentItem() + 1;
            z = false;
        } else if ((this.fLO.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.sO(currentItem2) == 1) {
            currentItem = this.fLO.getCurrentItem();
            z = true;
        } else {
            currentItem = this.fLO.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.fLP.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.fLQ.getCurrentItem()).append(":").append(this.fLR.getCurrentItem()).append(":").append(this.fLS.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void sT(int i) {
        this.fKL = i;
    }

    public void sU(int i) {
        this.fKM = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.fKL) {
                this.fKM = i;
                this.fLU = i2;
                this.fLW = i3;
            } else if (i == this.fKL) {
                if (i2 > this.fLT) {
                    this.fKM = i;
                    this.fLU = i2;
                    this.fLW = i3;
                } else if (i2 == this.fLT && i3 > this.fLV) {
                    this.fKM = i;
                    this.fLU = i2;
                    this.fLW = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.fKM) {
                this.fLT = i5;
                this.fLV = i6;
                this.fKL = i4;
            } else if (i4 == this.fKM) {
                if (i5 < this.fLU) {
                    this.fLT = i5;
                    this.fLV = i6;
                    this.fKL = i4;
                } else if (i5 == this.fLU && i6 < this.fLW) {
                    this.fLT = i5;
                    this.fLV = i6;
                    this.fKL = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.fKL = calendar.get(1);
            this.fKM = calendar2.get(1);
            this.fLT = calendar.get(2) + 1;
            this.fLU = calendar2.get(2) + 1;
            this.fLV = calendar.get(5);
            this.fLW = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bGZ();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bGX();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.fLr = dividerType;
        bGY();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bGW();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bGV();
    }

    public void isCenterLabel(boolean z) {
        this.fLP.isCenterLabel(z);
        this.fLO.isCenterLabel(z);
        this.fLN.isCenterLabel(z);
        this.fLQ.isCenterLabel(z);
        this.fLR.isCenterLabel(z);
        this.fLS.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.fLY = bVar;
    }
}
