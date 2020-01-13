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
/* loaded from: classes6.dex */
public class c {
    public static DateFormat dNB = new SimpleDateFormat(DateTimeUtil.TIME_FORMAT);
    private boolean[] dMv;
    private WheelView dNC;
    private WheelView dND;
    private WheelView dNE;
    private WheelView dNF;
    private WheelView dNG;
    private WheelView dNH;
    private int dNM;
    private com.baidu.tbadk.widget.timepicker.a.d.b dNN;
    private WheelView.DividerType dNf;
    private int dividerColor;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int dMz = 1900;
    private int dMA = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int dNI = 1;
    private int dNJ = 12;
    private int dNK = 1;
    private int dNL = 31;
    private boolean dMC = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.dMv = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void hl(boolean z) {
        this.dMC = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.dMC) {
            int[] A = com.baidu.tbadk.widget.timepicker.a.e.b.A(i, i2 + 1, i3);
            a(A[0], A[1] - 1, A[2], A[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.dNC = (WheelView) this.view.findViewById(R.id.year);
        this.dNC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aW(this.dMz, this.dMA)));
        this.dNC.setLabel("");
        this.dNC.setCurrentItem(i - this.dMz);
        this.dNC.setGravity(this.gravity);
        this.dND = (WheelView) this.view.findViewById(R.id.month);
        this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nt(i)));
        this.dND.setLabel("");
        int nq = com.baidu.tbadk.widget.timepicker.a.e.a.nq(i);
        if (nq != 0 && (i2 > nq - 1 || z)) {
            this.dND.setCurrentItem(i2 + 1);
        } else {
            this.dND.setCurrentItem(i2);
        }
        this.dND.setGravity(this.gravity);
        this.dNE = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(i) == 0) {
            this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i, i2))));
        } else {
            this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.np(i))));
        }
        this.dNE.setLabel("");
        this.dNE.setCurrentItem(i3 - 1);
        this.dNE.setGravity(this.gravity);
        this.dNF = (WheelView) this.view.findViewById(R.id.hour);
        this.dNF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dNF.setCurrentItem(i4);
        this.dNF.setGravity(this.gravity);
        this.dNG = (WheelView) this.view.findViewById(R.id.min);
        this.dNG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNG.setCurrentItem(i5);
        this.dNG.setGravity(this.gravity);
        this.dNH = (WheelView) this.view.findViewById(R.id.second);
        this.dNH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNH.setCurrentItem(i5);
        this.dNH.setGravity(this.gravity);
        this.dNC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int i8 = c.this.dMz + i7;
                c.this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nt(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) == 0 || c.this.dND.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) - 1) {
                    c.this.dND.setCurrentItem(c.this.dND.getCurrentItem());
                } else {
                    c.this.dND.setCurrentItem(c.this.dND.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) == 0 || c.this.dND.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) - 1) {
                    c.this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dND.getCurrentItem() + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dND.getCurrentItem() + 1);
                } else if (c.this.dND.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nq(i8) + 1) {
                    c.this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.np(i8))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.np(i8);
                } else {
                    c.this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dND.getCurrentItem()))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dND.getCurrentItem());
                }
                if (c.this.dNE.getCurrentItem() > aV - 1) {
                    c.this.dNE.setCurrentItem(aV - 1);
                }
                if (c.this.dNN != null) {
                    c.this.dNN.aSz();
                }
            }
        });
        this.dND.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int currentItem = c.this.dNC.getCurrentItem() + c.this.dMz;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem) - 1) {
                    c.this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1);
                } else if (c.this.dND.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem) + 1) {
                    c.this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.np(currentItem))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.np(currentItem);
                } else {
                    c.this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nu(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7);
                }
                if (c.this.dNE.getCurrentItem() > aV - 1) {
                    c.this.dNE.setCurrentItem(aV - 1);
                }
                if (c.this.dNN != null) {
                    c.this.dNN.aSz();
                }
            }
        });
        a(this.dNE);
        a(this.dNF);
        a(this.dNG);
        a(this.dNH);
        if (this.dMv.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.dNC.setVisibility(this.dMv[0] ? 0 : 8);
        this.dND.setVisibility(this.dMv[1] ? 0 : 8);
        this.dNE.setVisibility(this.dMv[2] ? 0 : 8);
        this.dNF.setVisibility(this.dMv[3] ? 0 : 8);
        this.dNG.setVisibility(this.dMv[4] ? 0 : 8);
        this.dNH.setVisibility(this.dMv[5] ? 0 : 8);
        aSH();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.dNM = i;
        this.dNC = (WheelView) this.view.findViewById(R.id.year);
        this.dNC.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dMz, this.dMA));
        this.dNC.setCurrentItem(i - this.dMz);
        this.dNC.setGravity(this.gravity);
        this.dND = (WheelView) this.view.findViewById(R.id.month);
        if (this.dMz == this.dMA) {
            this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNI, this.dNJ));
            this.dND.setCurrentItem((i2 + 1) - this.dNI);
        } else if (i == this.dMz) {
            this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNI, 12));
            this.dND.setCurrentItem((i2 + 1) - this.dNI);
        } else if (i == this.dMA) {
            this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dNJ));
            this.dND.setCurrentItem(i2);
        } else {
            this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.dND.setCurrentItem(i2);
        }
        this.dND.setGravity(this.gravity);
        this.dNE = (WheelView) this.view.findViewById(R.id.day);
        if (this.dMz == this.dMA && this.dNI == this.dNJ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dNL > 31) {
                    this.dNL = 31;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, this.dNL));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dNL > 30) {
                    this.dNL = 30;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, this.dNL));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dNL > 29) {
                    this.dNL = 29;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, this.dNL));
            } else {
                if (this.dNL > 28) {
                    this.dNL = 28;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, this.dNL));
            }
            this.dNE.setCurrentItem(i3 - this.dNK);
        } else if (i == this.dMz && i2 + 1 == this.dNI) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, 29));
            } else {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dNK, 28));
            }
            this.dNE.setCurrentItem(i3 - this.dNK);
        } else if (i == this.dMA && i2 + 1 == this.dNJ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dNL > 31) {
                    this.dNL = 31;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dNL));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dNL > 30) {
                    this.dNL = 30;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dNL));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dNL > 29) {
                    this.dNL = 29;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dNL));
            } else {
                if (this.dNL > 28) {
                    this.dNL = 28;
                }
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dNL));
            }
            this.dNE.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.dNE.setCurrentItem(i3 - 1);
        }
        this.dNE.setGravity(this.gravity);
        this.dNF = (WheelView) this.view.findViewById(R.id.hour);
        this.dNF.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dNF.setCurrentItem(i4);
        this.dNF.setGravity(this.gravity);
        this.dNG = (WheelView) this.view.findViewById(R.id.min);
        this.dNG.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNG.setCurrentItem(i5);
        this.dNG.setGravity(this.gravity);
        this.dNH = (WheelView) this.view.findViewById(R.id.second);
        this.dNH.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dNH.setCurrentItem(i6);
        this.dNH.setGravity(this.gravity);
        this.dNC.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.dMz;
                c.this.dNM = i8;
                int currentItem = c.this.dND.getCurrentItem();
                if (c.this.dMz == c.this.dMA) {
                    c.this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dNI, c.this.dNJ));
                    if (currentItem > c.this.dND.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dND.getAdapter().getItemsCount() - 1;
                        c.this.dND.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.dNI + currentItem;
                    if (c.this.dNI == c.this.dNJ) {
                        c.this.a(i8, i9, c.this.dNK, c.this.dNL, asList, asList2);
                    } else if (i9 == c.this.dNI) {
                        c.this.a(i8, i9, c.this.dNK, 31, asList, asList2);
                    } else if (i9 == c.this.dNJ) {
                        c.this.a(i8, i9, 1, c.this.dNL, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dMz) {
                    c.this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dNI, 12));
                    if (currentItem > c.this.dND.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dND.getAdapter().getItemsCount() - 1;
                        c.this.dND.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.dNI + currentItem;
                    if (i10 == c.this.dNI) {
                        c.this.a(i8, i10, c.this.dNK, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dMA) {
                    c.this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.dNJ));
                    if (currentItem > c.this.dND.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dND.getAdapter().getItemsCount() - 1;
                        c.this.dND.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.dNJ) {
                        c.this.a(i8, i11, 1, c.this.dNL, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.dND.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.dND.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.dNN != null) {
                    c.this.dNN.aSz();
                }
            }
        });
        this.dND.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.dMz == c.this.dMA) {
                    int i9 = (c.this.dNI + i8) - 1;
                    if (c.this.dNI == c.this.dNJ) {
                        c.this.a(c.this.dNM, i9, c.this.dNK, c.this.dNL, asList, asList2);
                    } else if (c.this.dNI == i9) {
                        c.this.a(c.this.dNM, i9, c.this.dNK, 31, asList, asList2);
                    } else if (c.this.dNJ == i9) {
                        c.this.a(c.this.dNM, i9, 1, c.this.dNL, asList, asList2);
                    } else {
                        c.this.a(c.this.dNM, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.dNM == c.this.dMz) {
                    int i10 = (c.this.dNI + i8) - 1;
                    if (i10 == c.this.dNI) {
                        c.this.a(c.this.dNM, i10, c.this.dNK, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.dNM, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.dNM == c.this.dMA) {
                    if (i8 == c.this.dNJ) {
                        c.this.a(c.this.dNM, c.this.dND.getCurrentItem() + 1, 1, c.this.dNL, asList, asList2);
                    } else {
                        c.this.a(c.this.dNM, c.this.dND.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.dNM, i8, 1, 31, asList, asList2);
                }
                if (c.this.dNN != null) {
                    c.this.dNN.aSz();
                }
            }
        });
        a(this.dNE);
        a(this.dNF);
        a(this.dNG);
        a(this.dNH);
        if (this.dMv.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.dNC.setVisibility(this.dMv[0] ? 0 : 8);
        this.dND.setVisibility(this.dMv[1] ? 0 : 8);
        this.dNE.setVisibility(this.dMv[2] ? 0 : 8);
        this.dNF.setVisibility(this.dMv[3] ? 0 : 8);
        this.dNG.setVisibility(this.dMv[4] ? 0 : 8);
        this.dNH.setVisibility(this.dMv[5] ? 0 : 8);
        aSH();
    }

    private void a(WheelView wheelView) {
        if (this.dNN != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.dNN.aSz();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.dNE.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.dNE.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.dNE.getAdapter().getItemsCount() - 1) {
            this.dNE.setCurrentItem(this.dNE.getAdapter().getItemsCount() - 1);
        }
    }

    private void aSH() {
        this.dNE.setTextSize(this.textSize);
        this.dND.setTextSize(this.textSize);
        this.dNC.setTextSize(this.textSize);
        this.dNF.setTextSize(this.textSize);
        this.dNG.setTextSize(this.textSize);
        this.dNH.setTextSize(this.textSize);
    }

    private void aSI() {
        this.dNE.setTextColorOut(this.textColorOut);
        this.dND.setTextColorOut(this.textColorOut);
        this.dNC.setTextColorOut(this.textColorOut);
        this.dNF.setTextColorOut(this.textColorOut);
        this.dNG.setTextColorOut(this.textColorOut);
        this.dNH.setTextColorOut(this.textColorOut);
    }

    private void aSJ() {
        this.dNE.setTextColorCenter(this.textColorCenter);
        this.dND.setTextColorCenter(this.textColorCenter);
        this.dNC.setTextColorCenter(this.textColorCenter);
        this.dNF.setTextColorCenter(this.textColorCenter);
        this.dNG.setTextColorCenter(this.textColorCenter);
        this.dNH.setTextColorCenter(this.textColorCenter);
    }

    private void aSK() {
        this.dNE.setDividerColor(this.dividerColor);
        this.dND.setDividerColor(this.dividerColor);
        this.dNC.setDividerColor(this.dividerColor);
        this.dNF.setDividerColor(this.dividerColor);
        this.dNG.setDividerColor(this.dividerColor);
        this.dNH.setDividerColor(this.dividerColor);
    }

    private void aSL() {
        this.dNE.setDividerType(this.dNf);
        this.dND.setDividerType(this.dNf);
        this.dNC.setDividerType(this.dNf);
        this.dNF.setDividerType(this.dNf);
        this.dNG.setDividerType(this.dNf);
        this.dNH.setDividerType(this.dNf);
    }

    private void aSM() {
        this.dNE.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dND.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNC.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNF.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNG.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dNH.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.dMC) {
            if (str != null) {
                this.dNC.setLabel(str);
            } else {
                this.dNC.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.dND.setLabel(str2);
            } else {
                this.dND.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.dNE.setLabel(str3);
            } else {
                this.dNE.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.dNF.setLabel(str4);
            } else {
                this.dNF.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.dNG.setLabel(str5);
            } else {
                this.dNG.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.dNH.setLabel(str6);
            } else {
                this.dNH.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dNE.setTextXOffset(i);
        this.dND.setTextXOffset(i2);
        this.dNC.setTextXOffset(i3);
        this.dNF.setTextXOffset(i4);
        this.dNG.setTextXOffset(i5);
        this.dNH.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.dNC.setCyclic(z);
        this.dND.setCyclic(z);
        this.dNE.setCyclic(z);
        this.dNF.setCyclic(z);
        this.dNG.setCyclic(z);
        this.dNH.setCyclic(z);
    }

    public String getTime() {
        if (this.dMC) {
            return aSN();
        }
        StringBuilder sb = new StringBuilder();
        if (this.dNM == this.dMz) {
            if (this.dND.getCurrentItem() + this.dNI == this.dNI) {
                sb.append(this.dNC.getCurrentItem() + this.dMz).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dND.getCurrentItem() + this.dNI).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNE.getCurrentItem() + this.dNK).append(HanziToPinyin.Token.SEPARATOR).append(this.dNF.getCurrentItem()).append(":").append(this.dNG.getCurrentItem()).append(":").append(this.dNH.getCurrentItem());
            } else {
                sb.append(this.dNC.getCurrentItem() + this.dMz).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dND.getCurrentItem() + this.dNI).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNE.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dNF.getCurrentItem()).append(":").append(this.dNG.getCurrentItem()).append(":").append(this.dNH.getCurrentItem());
            }
        } else {
            sb.append(this.dNC.getCurrentItem() + this.dMz).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dND.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dNE.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dNF.getCurrentItem()).append(":").append(this.dNG.getCurrentItem()).append(":").append(this.dNH.getCurrentItem());
        }
        return sb.toString();
    }

    private String aSN() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.dNC.getCurrentItem() + this.dMz;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem2) == 0) {
            currentItem = this.dND.getCurrentItem() + 1;
            z = false;
        } else if ((this.dND.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem2) <= 0) {
            currentItem = this.dND.getCurrentItem() + 1;
            z = false;
        } else if ((this.dND.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nq(currentItem2) == 1) {
            currentItem = this.dND.getCurrentItem();
            z = true;
        } else {
            currentItem = this.dND.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.dNE.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.dNF.getCurrentItem()).append(":").append(this.dNG.getCurrentItem()).append(":").append(this.dNH.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nv(int i) {
        this.dMz = i;
    }

    public void nw(int i) {
        this.dMA = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.dMz) {
                this.dMA = i;
                this.dNJ = i2;
                this.dNL = i3;
            } else if (i == this.dMz) {
                if (i2 > this.dNI) {
                    this.dMA = i;
                    this.dNJ = i2;
                    this.dNL = i3;
                } else if (i2 == this.dNI && i3 > this.dNK) {
                    this.dMA = i;
                    this.dNJ = i2;
                    this.dNL = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.dMA) {
                this.dNI = i5;
                this.dNK = i6;
                this.dMz = i4;
            } else if (i4 == this.dMA) {
                if (i5 < this.dNJ) {
                    this.dNI = i5;
                    this.dNK = i6;
                    this.dMz = i4;
                } else if (i5 == this.dNJ && i6 < this.dNL) {
                    this.dNI = i5;
                    this.dNK = i6;
                    this.dMz = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.dMz = calendar.get(1);
            this.dMA = calendar2.get(1);
            this.dNI = calendar.get(2) + 1;
            this.dNJ = calendar2.get(2) + 1;
            this.dNK = calendar.get(5);
            this.dNL = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        aSM();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        aSK();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dNf = dividerType;
        aSL();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        aSJ();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        aSI();
    }

    public void isCenterLabel(boolean z) {
        this.dNE.isCenterLabel(z);
        this.dND.isCenterLabel(z);
        this.dNC.isCenterLabel(z);
        this.dNF.isCenterLabel(z);
        this.dNG.isCenterLabel(z);
        this.dNH.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.dNN = bVar;
    }
}
