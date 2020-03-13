package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat(DateTimeUtil.TIME_FORMAT);
    private boolean[] dQQ;
    private WheelView.DividerType dRA;
    private WheelView dRW;
    private WheelView dRX;
    private WheelView dRY;
    private WheelView dRZ;
    private WheelView dSa;
    private WheelView dSb;
    private int dSg;
    private com.baidu.tbadk.widget.timepicker.a.d.b dSh;
    private int dividerColor;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int dQU = 1900;
    private int dQV = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int dSc = 1;
    private int dSd = 12;
    private int dSe = 1;
    private int dSf = 31;
    private boolean dQX = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.dQQ = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void hs(boolean z) {
        this.dQX = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.dQX) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.dRW = (WheelView) this.view.findViewById(R.id.year);
        this.dRW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aW(this.dQU, this.dQV)));
        this.dRW.setLabel("");
        this.dRW.setCurrentItem(i - this.dQU);
        this.dRW.setGravity(this.gravity);
        this.dRX = (WheelView) this.view.findViewById(R.id.month);
        this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nK(i)));
        this.dRX.setLabel("");
        int nH = com.baidu.tbadk.widget.timepicker.a.e.a.nH(i);
        if (nH != 0 && (i2 > nH - 1 || z)) {
            this.dRX.setCurrentItem(i2 + 1);
        } else {
            this.dRX.setCurrentItem(i2);
        }
        this.dRX.setGravity(this.gravity);
        this.dRY = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i) == 0) {
            this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i, i2))));
        } else {
            this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(i))));
        }
        this.dRY.setLabel("");
        this.dRY.setCurrentItem(i3 - 1);
        this.dRY.setGravity(this.gravity);
        this.dRZ = (WheelView) this.view.findViewById(R.id.hour);
        this.dRZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dRZ.setCurrentItem(i4);
        this.dRZ.setGravity(this.gravity);
        this.dSa = (WheelView) this.view.findViewById(R.id.min);
        this.dSa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSa.setCurrentItem(i5);
        this.dSa.setGravity(this.gravity);
        this.dSb = (WheelView) this.view.findViewById(R.id.second);
        this.dSb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSb.setCurrentItem(i5);
        this.dSb.setGravity(this.gravity);
        this.dRW.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int i8 = c.this.dQU + i7;
                c.this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nK(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) == 0 || c.this.dRX.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) - 1) {
                    c.this.dRX.setCurrentItem(c.this.dRX.getCurrentItem());
                } else {
                    c.this.dRX.setCurrentItem(c.this.dRX.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) == 0 || c.this.dRX.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) - 1) {
                    c.this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRX.getCurrentItem() + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRX.getCurrentItem() + 1);
                } else if (c.this.dRX.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) + 1) {
                    c.this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(i8))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.nG(i8);
                } else {
                    c.this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRX.getCurrentItem()))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRX.getCurrentItem());
                }
                if (c.this.dRY.getCurrentItem() > aV - 1) {
                    c.this.dRY.setCurrentItem(aV - 1);
                }
                if (c.this.dSh != null) {
                    c.this.dSh.aUT();
                }
            }
        });
        this.dRX.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int currentItem = c.this.dRW.getCurrentItem() + c.this.dQU;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) - 1) {
                    c.this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1);
                } else if (c.this.dRX.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) + 1) {
                    c.this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(currentItem))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.nG(currentItem);
                } else {
                    c.this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7);
                }
                if (c.this.dRY.getCurrentItem() > aV - 1) {
                    c.this.dRY.setCurrentItem(aV - 1);
                }
                if (c.this.dSh != null) {
                    c.this.dSh.aUT();
                }
            }
        });
        a(this.dRY);
        a(this.dRZ);
        a(this.dSa);
        a(this.dSb);
        if (this.dQQ.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.dRW.setVisibility(this.dQQ[0] ? 0 : 8);
        this.dRX.setVisibility(this.dQQ[1] ? 0 : 8);
        this.dRY.setVisibility(this.dQQ[2] ? 0 : 8);
        this.dRZ.setVisibility(this.dQQ[3] ? 0 : 8);
        this.dSa.setVisibility(this.dQQ[4] ? 0 : 8);
        this.dSb.setVisibility(this.dQQ[5] ? 0 : 8);
        aVb();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.dSg = i;
        this.dRW = (WheelView) this.view.findViewById(R.id.year);
        this.dRW.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dQU, this.dQV));
        this.dRW.setCurrentItem(i - this.dQU);
        this.dRW.setGravity(this.gravity);
        this.dRX = (WheelView) this.view.findViewById(R.id.month);
        if (this.dQU == this.dQV) {
            this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSc, this.dSd));
            this.dRX.setCurrentItem((i2 + 1) - this.dSc);
        } else if (i == this.dQU) {
            this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSc, 12));
            this.dRX.setCurrentItem((i2 + 1) - this.dSc);
        } else if (i == this.dQV) {
            this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSd));
            this.dRX.setCurrentItem(i2);
        } else {
            this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.dRX.setCurrentItem(i2);
        }
        this.dRX.setGravity(this.gravity);
        this.dRY = (WheelView) this.view.findViewById(R.id.day);
        if (this.dQU == this.dQV && this.dSc == this.dSd) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dSf > 31) {
                    this.dSf = 31;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, this.dSf));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dSf > 30) {
                    this.dSf = 30;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, this.dSf));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dSf > 29) {
                    this.dSf = 29;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, this.dSf));
            } else {
                if (this.dSf > 28) {
                    this.dSf = 28;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, this.dSf));
            }
            this.dRY.setCurrentItem(i3 - this.dSe);
        } else if (i == this.dQU && i2 + 1 == this.dSc) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, 29));
            } else {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSe, 28));
            }
            this.dRY.setCurrentItem(i3 - this.dSe);
        } else if (i == this.dQV && i2 + 1 == this.dSd) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dSf > 31) {
                    this.dSf = 31;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSf));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dSf > 30) {
                    this.dSf = 30;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSf));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dSf > 29) {
                    this.dSf = 29;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSf));
            } else {
                if (this.dSf > 28) {
                    this.dSf = 28;
                }
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSf));
            }
            this.dRY.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.dRY.setCurrentItem(i3 - 1);
        }
        this.dRY.setGravity(this.gravity);
        this.dRZ = (WheelView) this.view.findViewById(R.id.hour);
        this.dRZ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dRZ.setCurrentItem(i4);
        this.dRZ.setGravity(this.gravity);
        this.dSa = (WheelView) this.view.findViewById(R.id.min);
        this.dSa.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSa.setCurrentItem(i5);
        this.dSa.setGravity(this.gravity);
        this.dSb = (WheelView) this.view.findViewById(R.id.second);
        this.dSb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSb.setCurrentItem(i6);
        this.dSb.setGravity(this.gravity);
        this.dRW.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.dQU;
                c.this.dSg = i8;
                int currentItem = c.this.dRX.getCurrentItem();
                if (c.this.dQU == c.this.dQV) {
                    c.this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dSc, c.this.dSd));
                    if (currentItem > c.this.dRX.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRX.getAdapter().getItemsCount() - 1;
                        c.this.dRX.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.dSc + currentItem;
                    if (c.this.dSc == c.this.dSd) {
                        c.this.a(i8, i9, c.this.dSe, c.this.dSf, asList, asList2);
                    } else if (i9 == c.this.dSc) {
                        c.this.a(i8, i9, c.this.dSe, 31, asList, asList2);
                    } else if (i9 == c.this.dSd) {
                        c.this.a(i8, i9, 1, c.this.dSf, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dQU) {
                    c.this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dSc, 12));
                    if (currentItem > c.this.dRX.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRX.getAdapter().getItemsCount() - 1;
                        c.this.dRX.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.dSc + currentItem;
                    if (i10 == c.this.dSc) {
                        c.this.a(i8, i10, c.this.dSe, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dQV) {
                    c.this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.dSd));
                    if (currentItem > c.this.dRX.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRX.getAdapter().getItemsCount() - 1;
                        c.this.dRX.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.dSd) {
                        c.this.a(i8, i11, 1, c.this.dSf, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.dRX.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.dRX.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.dSh != null) {
                    c.this.dSh.aUT();
                }
            }
        });
        this.dRX.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.dQU == c.this.dQV) {
                    int i9 = (c.this.dSc + i8) - 1;
                    if (c.this.dSc == c.this.dSd) {
                        c.this.a(c.this.dSg, i9, c.this.dSe, c.this.dSf, asList, asList2);
                    } else if (c.this.dSc == i9) {
                        c.this.a(c.this.dSg, i9, c.this.dSe, 31, asList, asList2);
                    } else if (c.this.dSd == i9) {
                        c.this.a(c.this.dSg, i9, 1, c.this.dSf, asList, asList2);
                    } else {
                        c.this.a(c.this.dSg, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.dSg == c.this.dQU) {
                    int i10 = (c.this.dSc + i8) - 1;
                    if (i10 == c.this.dSc) {
                        c.this.a(c.this.dSg, i10, c.this.dSe, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.dSg, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.dSg == c.this.dQV) {
                    if (i8 == c.this.dSd) {
                        c.this.a(c.this.dSg, c.this.dRX.getCurrentItem() + 1, 1, c.this.dSf, asList, asList2);
                    } else {
                        c.this.a(c.this.dSg, c.this.dRX.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.dSg, i8, 1, 31, asList, asList2);
                }
                if (c.this.dSh != null) {
                    c.this.dSh.aUT();
                }
            }
        });
        a(this.dRY);
        a(this.dRZ);
        a(this.dSa);
        a(this.dSb);
        if (this.dQQ.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.dRW.setVisibility(this.dQQ[0] ? 0 : 8);
        this.dRX.setVisibility(this.dQQ[1] ? 0 : 8);
        this.dRY.setVisibility(this.dQQ[2] ? 0 : 8);
        this.dRZ.setVisibility(this.dQQ[3] ? 0 : 8);
        this.dSa.setVisibility(this.dQQ[4] ? 0 : 8);
        this.dSb.setVisibility(this.dQQ[5] ? 0 : 8);
        aVb();
    }

    private void a(WheelView wheelView) {
        if (this.dSh != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.dSh.aUT();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.dRY.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.dRY.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.dRY.getAdapter().getItemsCount() - 1) {
            this.dRY.setCurrentItem(this.dRY.getAdapter().getItemsCount() - 1);
        }
    }

    private void aVb() {
        this.dRY.setTextSize(this.textSize);
        this.dRX.setTextSize(this.textSize);
        this.dRW.setTextSize(this.textSize);
        this.dRZ.setTextSize(this.textSize);
        this.dSa.setTextSize(this.textSize);
        this.dSb.setTextSize(this.textSize);
    }

    private void aVc() {
        this.dRY.setTextColorOut(this.textColorOut);
        this.dRX.setTextColorOut(this.textColorOut);
        this.dRW.setTextColorOut(this.textColorOut);
        this.dRZ.setTextColorOut(this.textColorOut);
        this.dSa.setTextColorOut(this.textColorOut);
        this.dSb.setTextColorOut(this.textColorOut);
    }

    private void aVd() {
        this.dRY.setTextColorCenter(this.textColorCenter);
        this.dRX.setTextColorCenter(this.textColorCenter);
        this.dRW.setTextColorCenter(this.textColorCenter);
        this.dRZ.setTextColorCenter(this.textColorCenter);
        this.dSa.setTextColorCenter(this.textColorCenter);
        this.dSb.setTextColorCenter(this.textColorCenter);
    }

    private void aVe() {
        this.dRY.setDividerColor(this.dividerColor);
        this.dRX.setDividerColor(this.dividerColor);
        this.dRW.setDividerColor(this.dividerColor);
        this.dRZ.setDividerColor(this.dividerColor);
        this.dSa.setDividerColor(this.dividerColor);
        this.dSb.setDividerColor(this.dividerColor);
    }

    private void aVf() {
        this.dRY.setDividerType(this.dRA);
        this.dRX.setDividerType(this.dRA);
        this.dRW.setDividerType(this.dRA);
        this.dRZ.setDividerType(this.dRA);
        this.dSa.setDividerType(this.dRA);
        this.dSb.setDividerType(this.dRA);
    }

    private void aVg() {
        this.dRY.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRX.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRW.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRZ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSa.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSb.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.dQX) {
            if (str != null) {
                this.dRW.setLabel(str);
            } else {
                this.dRW.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.dRX.setLabel(str2);
            } else {
                this.dRX.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.dRY.setLabel(str3);
            } else {
                this.dRY.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.dRZ.setLabel(str4);
            } else {
                this.dRZ.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.dSa.setLabel(str5);
            } else {
                this.dSa.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.dSb.setLabel(str6);
            } else {
                this.dSb.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dRY.setTextXOffset(i);
        this.dRX.setTextXOffset(i2);
        this.dRW.setTextXOffset(i3);
        this.dRZ.setTextXOffset(i4);
        this.dSa.setTextXOffset(i5);
        this.dSb.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.dRW.setCyclic(z);
        this.dRX.setCyclic(z);
        this.dRY.setCyclic(z);
        this.dRZ.setCyclic(z);
        this.dSa.setCyclic(z);
        this.dSb.setCyclic(z);
    }

    public String getTime() {
        if (this.dQX) {
            return aVh();
        }
        StringBuilder sb = new StringBuilder();
        if (this.dSg == this.dQU) {
            if (this.dRX.getCurrentItem() + this.dSc == this.dSc) {
                sb.append(this.dRW.getCurrentItem() + this.dQU).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRX.getCurrentItem() + this.dSc).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRY.getCurrentItem() + this.dSe).append(HanziToPinyin.Token.SEPARATOR).append(this.dRZ.getCurrentItem()).append(":").append(this.dSa.getCurrentItem()).append(":").append(this.dSb.getCurrentItem());
            } else {
                sb.append(this.dRW.getCurrentItem() + this.dQU).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRX.getCurrentItem() + this.dSc).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRY.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dRZ.getCurrentItem()).append(":").append(this.dSa.getCurrentItem()).append(":").append(this.dSb.getCurrentItem());
            }
        } else {
            sb.append(this.dRW.getCurrentItem() + this.dQU).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRX.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRY.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dRZ.getCurrentItem()).append(":").append(this.dSa.getCurrentItem()).append(":").append(this.dSb.getCurrentItem());
        }
        return sb.toString();
    }

    private String aVh() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.dRW.getCurrentItem() + this.dQU;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) == 0) {
            currentItem = this.dRX.getCurrentItem() + 1;
            z = false;
        } else if ((this.dRX.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) <= 0) {
            currentItem = this.dRX.getCurrentItem() + 1;
            z = false;
        } else if ((this.dRX.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) == 1) {
            currentItem = this.dRX.getCurrentItem();
            z = true;
        } else {
            currentItem = this.dRX.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.dRY.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.dRZ.getCurrentItem()).append(":").append(this.dSa.getCurrentItem()).append(":").append(this.dSb.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nM(int i) {
        this.dQU = i;
    }

    public void nN(int i) {
        this.dQV = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.dQU) {
                this.dQV = i;
                this.dSd = i2;
                this.dSf = i3;
            } else if (i == this.dQU) {
                if (i2 > this.dSc) {
                    this.dQV = i;
                    this.dSd = i2;
                    this.dSf = i3;
                } else if (i2 == this.dSc && i3 > this.dSe) {
                    this.dQV = i;
                    this.dSd = i2;
                    this.dSf = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.dQV) {
                this.dSc = i5;
                this.dSe = i6;
                this.dQU = i4;
            } else if (i4 == this.dQV) {
                if (i5 < this.dSd) {
                    this.dSc = i5;
                    this.dSe = i6;
                    this.dQU = i4;
                } else if (i5 == this.dSd && i6 < this.dSf) {
                    this.dSc = i5;
                    this.dSe = i6;
                    this.dQU = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.dQU = calendar.get(1);
            this.dQV = calendar2.get(1);
            this.dSc = calendar.get(2) + 1;
            this.dSd = calendar2.get(2) + 1;
            this.dSe = calendar.get(5);
            this.dSf = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        aVg();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        aVe();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dRA = dividerType;
        aVf();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        aVd();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        aVc();
    }

    public void isCenterLabel(boolean z) {
        this.dRY.isCenterLabel(z);
        this.dRX.isCenterLabel(z);
        this.dRW.isCenterLabel(z);
        this.dRZ.isCenterLabel(z);
        this.dSa.isCenterLabel(z);
        this.dSb.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.dSh = bVar;
    }
}
