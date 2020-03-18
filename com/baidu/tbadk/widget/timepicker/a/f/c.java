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
    private WheelView.DividerType dRR;
    private boolean[] dRh;
    private WheelView dSn;
    private WheelView dSo;
    private WheelView dSp;
    private WheelView dSq;
    private WheelView dSr;
    private WheelView dSs;
    private int dSx;
    private com.baidu.tbadk.widget.timepicker.a.d.b dSy;
    private int dividerColor;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int dRl = 1900;
    private int dRm = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int dSt = 1;
    private int dSu = 12;
    private int dSv = 1;
    private int dSw = 31;
    private boolean dRo = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.dRh = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void ht(boolean z) {
        this.dRo = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.dRo) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.dSn = (WheelView) this.view.findViewById(R.id.year);
        this.dSn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aX(this.dRl, this.dRm)));
        this.dSn.setLabel("");
        this.dSn.setCurrentItem(i - this.dRl);
        this.dSn.setGravity(this.gravity);
        this.dSo = (WheelView) this.view.findViewById(R.id.month);
        this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nM(i)));
        this.dSo.setLabel("");
        int nJ = com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i);
        if (nJ != 0 && (i2 > nJ - 1 || z)) {
            this.dSo.setCurrentItem(i2 + 1);
        } else {
            this.dSo.setCurrentItem(i2);
        }
        this.dSo.setGravity(this.gravity);
        this.dSp = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i) == 0) {
            this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.aW(i, i2))));
        } else {
            this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.nI(i))));
        }
        this.dSp.setLabel("");
        this.dSp.setCurrentItem(i3 - 1);
        this.dSp.setGravity(this.gravity);
        this.dSq = (WheelView) this.view.findViewById(R.id.hour);
        this.dSq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dSq.setCurrentItem(i4);
        this.dSq.setGravity(this.gravity);
        this.dSr = (WheelView) this.view.findViewById(R.id.min);
        this.dSr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSr.setCurrentItem(i5);
        this.dSr.setGravity(this.gravity);
        this.dSs = (WheelView) this.view.findViewById(R.id.second);
        this.dSs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSs.setCurrentItem(i5);
        this.dSs.setGravity(this.gravity);
        this.dSn.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aW;
                int i8 = c.this.dRl + i7;
                c.this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nM(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i8) == 0 || c.this.dSo.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i8) - 1) {
                    c.this.dSo.setCurrentItem(c.this.dSo.getCurrentItem());
                } else {
                    c.this.dSo.setCurrentItem(c.this.dSo.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i8) == 0 || c.this.dSo.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i8) - 1) {
                    c.this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.aW(i8, c.this.dSo.getCurrentItem() + 1))));
                    aW = com.baidu.tbadk.widget.timepicker.a.e.a.aW(i8, c.this.dSo.getCurrentItem() + 1);
                } else if (c.this.dSo.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nJ(i8) + 1) {
                    c.this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.nI(i8))));
                    aW = com.baidu.tbadk.widget.timepicker.a.e.a.nI(i8);
                } else {
                    c.this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.aW(i8, c.this.dSo.getCurrentItem()))));
                    aW = com.baidu.tbadk.widget.timepicker.a.e.a.aW(i8, c.this.dSo.getCurrentItem());
                }
                if (c.this.dSp.getCurrentItem() > aW - 1) {
                    c.this.dSp.setCurrentItem(aW - 1);
                }
                if (c.this.dSy != null) {
                    c.this.dSy.aUX();
                }
            }
        });
        this.dSo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aW;
                int currentItem = c.this.dSn.getCurrentItem() + c.this.dRl;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nJ(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nJ(currentItem) - 1) {
                    c.this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.aW(currentItem, i7 + 1))));
                    aW = com.baidu.tbadk.widget.timepicker.a.e.a.aW(currentItem, i7 + 1);
                } else if (c.this.dSo.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nJ(currentItem) + 1) {
                    c.this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.nI(currentItem))));
                    aW = com.baidu.tbadk.widget.timepicker.a.e.a.nI(currentItem);
                } else {
                    c.this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nN(com.baidu.tbadk.widget.timepicker.a.e.a.aW(currentItem, i7))));
                    aW = com.baidu.tbadk.widget.timepicker.a.e.a.aW(currentItem, i7);
                }
                if (c.this.dSp.getCurrentItem() > aW - 1) {
                    c.this.dSp.setCurrentItem(aW - 1);
                }
                if (c.this.dSy != null) {
                    c.this.dSy.aUX();
                }
            }
        });
        a(this.dSp);
        a(this.dSq);
        a(this.dSr);
        a(this.dSs);
        if (this.dRh.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.dSn.setVisibility(this.dRh[0] ? 0 : 8);
        this.dSo.setVisibility(this.dRh[1] ? 0 : 8);
        this.dSp.setVisibility(this.dRh[2] ? 0 : 8);
        this.dSq.setVisibility(this.dRh[3] ? 0 : 8);
        this.dSr.setVisibility(this.dRh[4] ? 0 : 8);
        this.dSs.setVisibility(this.dRh[5] ? 0 : 8);
        aVf();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.dSx = i;
        this.dSn = (WheelView) this.view.findViewById(R.id.year);
        this.dSn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRl, this.dRm));
        this.dSn.setCurrentItem(i - this.dRl);
        this.dSn.setGravity(this.gravity);
        this.dSo = (WheelView) this.view.findViewById(R.id.month);
        if (this.dRl == this.dRm) {
            this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSt, this.dSu));
            this.dSo.setCurrentItem((i2 + 1) - this.dSt);
        } else if (i == this.dRl) {
            this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSt, 12));
            this.dSo.setCurrentItem((i2 + 1) - this.dSt);
        } else if (i == this.dRm) {
            this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSu));
            this.dSo.setCurrentItem(i2);
        } else {
            this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.dSo.setCurrentItem(i2);
        }
        this.dSo.setGravity(this.gravity);
        this.dSp = (WheelView) this.view.findViewById(R.id.day);
        if (this.dRl == this.dRm && this.dSt == this.dSu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dSw > 31) {
                    this.dSw = 31;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, this.dSw));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dSw > 30) {
                    this.dSw = 30;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, this.dSw));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dSw > 29) {
                    this.dSw = 29;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, this.dSw));
            } else {
                if (this.dSw > 28) {
                    this.dSw = 28;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, this.dSw));
            }
            this.dSp.setCurrentItem(i3 - this.dSv);
        } else if (i == this.dRl && i2 + 1 == this.dSt) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, 29));
            } else {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dSv, 28));
            }
            this.dSp.setCurrentItem(i3 - this.dSv);
        } else if (i == this.dRm && i2 + 1 == this.dSu) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dSw > 31) {
                    this.dSw = 31;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSw));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dSw > 30) {
                    this.dSw = 30;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSw));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dSw > 29) {
                    this.dSw = 29;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSw));
            } else {
                if (this.dSw > 28) {
                    this.dSw = 28;
                }
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dSw));
            }
            this.dSp.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.dSp.setCurrentItem(i3 - 1);
        }
        this.dSp.setGravity(this.gravity);
        this.dSq = (WheelView) this.view.findViewById(R.id.hour);
        this.dSq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dSq.setCurrentItem(i4);
        this.dSq.setGravity(this.gravity);
        this.dSr = (WheelView) this.view.findViewById(R.id.min);
        this.dSr.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSr.setCurrentItem(i5);
        this.dSr.setGravity(this.gravity);
        this.dSs = (WheelView) this.view.findViewById(R.id.second);
        this.dSs.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dSs.setCurrentItem(i6);
        this.dSs.setGravity(this.gravity);
        this.dSn.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.dRl;
                c.this.dSx = i8;
                int currentItem = c.this.dSo.getCurrentItem();
                if (c.this.dRl == c.this.dRm) {
                    c.this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dSt, c.this.dSu));
                    if (currentItem > c.this.dSo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dSo.getAdapter().getItemsCount() - 1;
                        c.this.dSo.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.dSt + currentItem;
                    if (c.this.dSt == c.this.dSu) {
                        c.this.a(i8, i9, c.this.dSv, c.this.dSw, asList, asList2);
                    } else if (i9 == c.this.dSt) {
                        c.this.a(i8, i9, c.this.dSv, 31, asList, asList2);
                    } else if (i9 == c.this.dSu) {
                        c.this.a(i8, i9, 1, c.this.dSw, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dRl) {
                    c.this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dSt, 12));
                    if (currentItem > c.this.dSo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dSo.getAdapter().getItemsCount() - 1;
                        c.this.dSo.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.dSt + currentItem;
                    if (i10 == c.this.dSt) {
                        c.this.a(i8, i10, c.this.dSv, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dRm) {
                    c.this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.dSu));
                    if (currentItem > c.this.dSo.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dSo.getAdapter().getItemsCount() - 1;
                        c.this.dSo.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.dSu) {
                        c.this.a(i8, i11, 1, c.this.dSw, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.dSo.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.dSo.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.dSy != null) {
                    c.this.dSy.aUX();
                }
            }
        });
        this.dSo.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.dRl == c.this.dRm) {
                    int i9 = (c.this.dSt + i8) - 1;
                    if (c.this.dSt == c.this.dSu) {
                        c.this.a(c.this.dSx, i9, c.this.dSv, c.this.dSw, asList, asList2);
                    } else if (c.this.dSt == i9) {
                        c.this.a(c.this.dSx, i9, c.this.dSv, 31, asList, asList2);
                    } else if (c.this.dSu == i9) {
                        c.this.a(c.this.dSx, i9, 1, c.this.dSw, asList, asList2);
                    } else {
                        c.this.a(c.this.dSx, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.dSx == c.this.dRl) {
                    int i10 = (c.this.dSt + i8) - 1;
                    if (i10 == c.this.dSt) {
                        c.this.a(c.this.dSx, i10, c.this.dSv, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.dSx, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.dSx == c.this.dRm) {
                    if (i8 == c.this.dSu) {
                        c.this.a(c.this.dSx, c.this.dSo.getCurrentItem() + 1, 1, c.this.dSw, asList, asList2);
                    } else {
                        c.this.a(c.this.dSx, c.this.dSo.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.dSx, i8, 1, 31, asList, asList2);
                }
                if (c.this.dSy != null) {
                    c.this.dSy.aUX();
                }
            }
        });
        a(this.dSp);
        a(this.dSq);
        a(this.dSr);
        a(this.dSs);
        if (this.dRh.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.dSn.setVisibility(this.dRh[0] ? 0 : 8);
        this.dSo.setVisibility(this.dRh[1] ? 0 : 8);
        this.dSp.setVisibility(this.dRh[2] ? 0 : 8);
        this.dSq.setVisibility(this.dRh[3] ? 0 : 8);
        this.dSr.setVisibility(this.dRh[4] ? 0 : 8);
        this.dSs.setVisibility(this.dRh[5] ? 0 : 8);
        aVf();
    }

    private void a(WheelView wheelView) {
        if (this.dSy != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.dSy.aUX();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.dSp.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.dSp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.dSp.getAdapter().getItemsCount() - 1) {
            this.dSp.setCurrentItem(this.dSp.getAdapter().getItemsCount() - 1);
        }
    }

    private void aVf() {
        this.dSp.setTextSize(this.textSize);
        this.dSo.setTextSize(this.textSize);
        this.dSn.setTextSize(this.textSize);
        this.dSq.setTextSize(this.textSize);
        this.dSr.setTextSize(this.textSize);
        this.dSs.setTextSize(this.textSize);
    }

    private void aVg() {
        this.dSp.setTextColorOut(this.textColorOut);
        this.dSo.setTextColorOut(this.textColorOut);
        this.dSn.setTextColorOut(this.textColorOut);
        this.dSq.setTextColorOut(this.textColorOut);
        this.dSr.setTextColorOut(this.textColorOut);
        this.dSs.setTextColorOut(this.textColorOut);
    }

    private void aVh() {
        this.dSp.setTextColorCenter(this.textColorCenter);
        this.dSo.setTextColorCenter(this.textColorCenter);
        this.dSn.setTextColorCenter(this.textColorCenter);
        this.dSq.setTextColorCenter(this.textColorCenter);
        this.dSr.setTextColorCenter(this.textColorCenter);
        this.dSs.setTextColorCenter(this.textColorCenter);
    }

    private void aVi() {
        this.dSp.setDividerColor(this.dividerColor);
        this.dSo.setDividerColor(this.dividerColor);
        this.dSn.setDividerColor(this.dividerColor);
        this.dSq.setDividerColor(this.dividerColor);
        this.dSr.setDividerColor(this.dividerColor);
        this.dSs.setDividerColor(this.dividerColor);
    }

    private void aVj() {
        this.dSp.setDividerType(this.dRR);
        this.dSo.setDividerType(this.dRR);
        this.dSn.setDividerType(this.dRR);
        this.dSq.setDividerType(this.dRR);
        this.dSr.setDividerType(this.dRR);
        this.dSs.setDividerType(this.dRR);
    }

    private void aVk() {
        this.dSp.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSo.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSn.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSq.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSr.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dSs.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.dRo) {
            if (str != null) {
                this.dSn.setLabel(str);
            } else {
                this.dSn.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.dSo.setLabel(str2);
            } else {
                this.dSo.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.dSp.setLabel(str3);
            } else {
                this.dSp.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.dSq.setLabel(str4);
            } else {
                this.dSq.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.dSr.setLabel(str5);
            } else {
                this.dSr.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.dSs.setLabel(str6);
            } else {
                this.dSs.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dSp.setTextXOffset(i);
        this.dSo.setTextXOffset(i2);
        this.dSn.setTextXOffset(i3);
        this.dSq.setTextXOffset(i4);
        this.dSr.setTextXOffset(i5);
        this.dSs.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.dSn.setCyclic(z);
        this.dSo.setCyclic(z);
        this.dSp.setCyclic(z);
        this.dSq.setCyclic(z);
        this.dSr.setCyclic(z);
        this.dSs.setCyclic(z);
    }

    public String getTime() {
        if (this.dRo) {
            return aVl();
        }
        StringBuilder sb = new StringBuilder();
        if (this.dSx == this.dRl) {
            if (this.dSo.getCurrentItem() + this.dSt == this.dSt) {
                sb.append(this.dSn.getCurrentItem() + this.dRl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dSo.getCurrentItem() + this.dSt).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dSp.getCurrentItem() + this.dSv).append(HanziToPinyin.Token.SEPARATOR).append(this.dSq.getCurrentItem()).append(":").append(this.dSr.getCurrentItem()).append(":").append(this.dSs.getCurrentItem());
            } else {
                sb.append(this.dSn.getCurrentItem() + this.dRl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dSo.getCurrentItem() + this.dSt).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dSp.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dSq.getCurrentItem()).append(":").append(this.dSr.getCurrentItem()).append(":").append(this.dSs.getCurrentItem());
            }
        } else {
            sb.append(this.dSn.getCurrentItem() + this.dRl).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dSo.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dSp.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dSq.getCurrentItem()).append(":").append(this.dSr.getCurrentItem()).append(":").append(this.dSs.getCurrentItem());
        }
        return sb.toString();
    }

    private String aVl() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.dSn.getCurrentItem() + this.dRl;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nJ(currentItem2) == 0) {
            currentItem = this.dSo.getCurrentItem() + 1;
            z = false;
        } else if ((this.dSo.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nJ(currentItem2) <= 0) {
            currentItem = this.dSo.getCurrentItem() + 1;
            z = false;
        } else if ((this.dSo.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nJ(currentItem2) == 1) {
            currentItem = this.dSo.getCurrentItem();
            z = true;
        } else {
            currentItem = this.dSo.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.dSp.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.dSq.getCurrentItem()).append(":").append(this.dSr.getCurrentItem()).append(":").append(this.dSs.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nO(int i) {
        this.dRl = i;
    }

    public void nP(int i) {
        this.dRm = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.dRl) {
                this.dRm = i;
                this.dSu = i2;
                this.dSw = i3;
            } else if (i == this.dRl) {
                if (i2 > this.dSt) {
                    this.dRm = i;
                    this.dSu = i2;
                    this.dSw = i3;
                } else if (i2 == this.dSt && i3 > this.dSv) {
                    this.dRm = i;
                    this.dSu = i2;
                    this.dSw = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.dRm) {
                this.dSt = i5;
                this.dSv = i6;
                this.dRl = i4;
            } else if (i4 == this.dRm) {
                if (i5 < this.dSu) {
                    this.dSt = i5;
                    this.dSv = i6;
                    this.dRl = i4;
                } else if (i5 == this.dSu && i6 < this.dSw) {
                    this.dSt = i5;
                    this.dSv = i6;
                    this.dRl = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.dRl = calendar.get(1);
            this.dRm = calendar2.get(1);
            this.dSt = calendar.get(2) + 1;
            this.dSu = calendar2.get(2) + 1;
            this.dSv = calendar.get(5);
            this.dSw = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        aVk();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        aVi();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dRR = dividerType;
        aVj();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        aVh();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        aVg();
    }

    public void isCenterLabel(boolean z) {
        this.dSp.isCenterLabel(z);
        this.dSo.isCenterLabel(z);
        this.dSn.isCenterLabel(z);
        this.dSq.isCenterLabel(z);
        this.dSr.isCenterLabel(z);
        this.dSs.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.dSy = bVar;
    }
}
