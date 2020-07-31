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
/* loaded from: classes15.dex */
public class c {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private boolean[] eWC;
    private WheelView eXI;
    private WheelView eXJ;
    private WheelView eXK;
    private WheelView eXL;
    private WheelView eXM;
    private WheelView eXN;
    private int eXS;
    private com.baidu.tbadk.widget.timepicker.a.d.b eXT;
    private WheelView.DividerType eXm;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int eWG = FeatureCodes.SKY_SEG;
    private int eWH = 2100;
    private int eXO = 1;
    private int eXP = 12;
    private int eXQ = 1;
    private int eXR = 31;
    private boolean eWJ = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.eWC = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void jF(boolean z) {
        this.eWJ = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.eWJ) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.eXI = (WheelView) this.view.findViewById(R.id.year);
        this.eXI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bm(this.eWG, this.eWH)));
        this.eXI.setLabel("");
        this.eXI.setCurrentItem(i - this.eWG);
        this.eXI.setGravity(this.gravity);
        this.eXJ = (WheelView) this.view.findViewById(R.id.month);
        this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pw(i)));
        this.eXJ.setLabel("");
        int pt = com.baidu.tbadk.widget.timepicker.a.e.a.pt(i);
        if (pt != 0 && (i2 > pt - 1 || z)) {
            this.eXJ.setCurrentItem(i2 + 1);
        } else {
            this.eXJ.setCurrentItem(i2);
        }
        this.eXJ.setGravity(this.gravity);
        this.eXK = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.pt(i) == 0) {
            this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.bl(i, i2))));
        } else {
            this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.ps(i))));
        }
        this.eXK.setLabel("");
        this.eXK.setCurrentItem(i3 - 1);
        this.eXK.setGravity(this.gravity);
        this.eXL = (WheelView) this.view.findViewById(R.id.hour);
        this.eXL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eXL.setCurrentItem(i4);
        this.eXL.setGravity(this.gravity);
        this.eXM = (WheelView) this.view.findViewById(R.id.min);
        this.eXM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eXM.setCurrentItem(i5);
        this.eXM.setGravity(this.gravity);
        this.eXN = (WheelView) this.view.findViewById(R.id.second);
        this.eXN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eXN.setCurrentItem(i5);
        this.eXN.setGravity(this.gravity);
        this.eXI.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bl;
                int i8 = c.this.eWG + i7;
                c.this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.pw(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.pt(i8) == 0 || c.this.eXJ.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.pt(i8) - 1) {
                    c.this.eXJ.setCurrentItem(c.this.eXJ.getCurrentItem());
                } else {
                    c.this.eXJ.setCurrentItem(c.this.eXJ.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.pt(i8) == 0 || c.this.eXJ.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.pt(i8) - 1) {
                    c.this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.bl(i8, c.this.eXJ.getCurrentItem() + 1))));
                    bl = com.baidu.tbadk.widget.timepicker.a.e.a.bl(i8, c.this.eXJ.getCurrentItem() + 1);
                } else if (c.this.eXJ.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.pt(i8) + 1) {
                    c.this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.ps(i8))));
                    bl = com.baidu.tbadk.widget.timepicker.a.e.a.ps(i8);
                } else {
                    c.this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.bl(i8, c.this.eXJ.getCurrentItem()))));
                    bl = com.baidu.tbadk.widget.timepicker.a.e.a.bl(i8, c.this.eXJ.getCurrentItem());
                }
                if (c.this.eXK.getCurrentItem() > bl - 1) {
                    c.this.eXK.setCurrentItem(bl - 1);
                }
                if (c.this.eXT != null) {
                    c.this.eXT.bpM();
                }
            }
        });
        this.eXJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int bl;
                int currentItem = c.this.eXI.getCurrentItem() + c.this.eWG;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.pt(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.pt(currentItem) - 1) {
                    c.this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.bl(currentItem, i7 + 1))));
                    bl = com.baidu.tbadk.widget.timepicker.a.e.a.bl(currentItem, i7 + 1);
                } else if (c.this.eXJ.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.pt(currentItem) + 1) {
                    c.this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.ps(currentItem))));
                    bl = com.baidu.tbadk.widget.timepicker.a.e.a.ps(currentItem);
                } else {
                    c.this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.px(com.baidu.tbadk.widget.timepicker.a.e.a.bl(currentItem, i7))));
                    bl = com.baidu.tbadk.widget.timepicker.a.e.a.bl(currentItem, i7);
                }
                if (c.this.eXK.getCurrentItem() > bl - 1) {
                    c.this.eXK.setCurrentItem(bl - 1);
                }
                if (c.this.eXT != null) {
                    c.this.eXT.bpM();
                }
            }
        });
        a(this.eXK);
        a(this.eXL);
        a(this.eXM);
        a(this.eXN);
        if (this.eWC.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.eXI.setVisibility(this.eWC[0] ? 0 : 8);
        this.eXJ.setVisibility(this.eWC[1] ? 0 : 8);
        this.eXK.setVisibility(this.eWC[2] ? 0 : 8);
        this.eXL.setVisibility(this.eWC[3] ? 0 : 8);
        this.eXM.setVisibility(this.eWC[4] ? 0 : 8);
        this.eXN.setVisibility(this.eWC[5] ? 0 : 8);
        bpU();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.eXS = i;
        this.eXI = (WheelView) this.view.findViewById(R.id.year);
        this.eXI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eWG, this.eWH));
        this.eXI.setCurrentItem(i - this.eWG);
        this.eXI.setGravity(this.gravity);
        this.eXJ = (WheelView) this.view.findViewById(R.id.month);
        if (this.eWG == this.eWH) {
            this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXO, this.eXP));
            this.eXJ.setCurrentItem((i2 + 1) - this.eXO);
        } else if (i == this.eWG) {
            this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXO, 12));
            this.eXJ.setCurrentItem((i2 + 1) - this.eXO);
        } else if (i == this.eWH) {
            this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eXP));
            this.eXJ.setCurrentItem(i2);
        } else {
            this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.eXJ.setCurrentItem(i2);
        }
        this.eXJ.setGravity(this.gravity);
        this.eXK = (WheelView) this.view.findViewById(R.id.day);
        if (this.eWG == this.eWH && this.eXO == this.eXP) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eXR > 31) {
                    this.eXR = 31;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, this.eXR));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eXR > 30) {
                    this.eXR = 30;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, this.eXR));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eXR > 29) {
                    this.eXR = 29;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, this.eXR));
            } else {
                if (this.eXR > 28) {
                    this.eXR = 28;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, this.eXR));
            }
            this.eXK.setCurrentItem(i3 - this.eXQ);
        } else if (i == this.eWG && i2 + 1 == this.eXO) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, 29));
            } else {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eXQ, 28));
            }
            this.eXK.setCurrentItem(i3 - this.eXQ);
        } else if (i == this.eWH && i2 + 1 == this.eXP) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eXR > 31) {
                    this.eXR = 31;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eXR));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eXR > 30) {
                    this.eXR = 30;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eXR));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eXR > 29) {
                    this.eXR = 29;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eXR));
            } else {
                if (this.eXR > 28) {
                    this.eXR = 28;
                }
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eXR));
            }
            this.eXK.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.eXK.setCurrentItem(i3 - 1);
        }
        this.eXK.setGravity(this.gravity);
        this.eXL = (WheelView) this.view.findViewById(R.id.hour);
        this.eXL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eXL.setCurrentItem(i4);
        this.eXL.setGravity(this.gravity);
        this.eXM = (WheelView) this.view.findViewById(R.id.min);
        this.eXM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eXM.setCurrentItem(i5);
        this.eXM.setGravity(this.gravity);
        this.eXN = (WheelView) this.view.findViewById(R.id.second);
        this.eXN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eXN.setCurrentItem(i6);
        this.eXN.setGravity(this.gravity);
        this.eXI.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.eWG;
                c.this.eXS = i8;
                int currentItem = c.this.eXJ.getCurrentItem();
                if (c.this.eWG == c.this.eWH) {
                    c.this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eXO, c.this.eXP));
                    if (currentItem > c.this.eXJ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eXJ.getAdapter().getItemsCount() - 1;
                        c.this.eXJ.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.eXO + currentItem;
                    if (c.this.eXO == c.this.eXP) {
                        c.this.a(i8, i9, c.this.eXQ, c.this.eXR, asList, asList2);
                    } else if (i9 == c.this.eXO) {
                        c.this.a(i8, i9, c.this.eXQ, 31, asList, asList2);
                    } else if (i9 == c.this.eXP) {
                        c.this.a(i8, i9, 1, c.this.eXR, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eWG) {
                    c.this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eXO, 12));
                    if (currentItem > c.this.eXJ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eXJ.getAdapter().getItemsCount() - 1;
                        c.this.eXJ.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.eXO + currentItem;
                    if (i10 == c.this.eXO) {
                        c.this.a(i8, i10, c.this.eXQ, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eWH) {
                    c.this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.eXP));
                    if (currentItem > c.this.eXJ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eXJ.getAdapter().getItemsCount() - 1;
                        c.this.eXJ.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.eXP) {
                        c.this.a(i8, i11, 1, c.this.eXR, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.eXJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.eXJ.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.eXT != null) {
                    c.this.eXT.bpM();
                }
            }
        });
        this.eXJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.eWG == c.this.eWH) {
                    int i9 = (c.this.eXO + i8) - 1;
                    if (c.this.eXO == c.this.eXP) {
                        c.this.a(c.this.eXS, i9, c.this.eXQ, c.this.eXR, asList, asList2);
                    } else if (c.this.eXO == i9) {
                        c.this.a(c.this.eXS, i9, c.this.eXQ, 31, asList, asList2);
                    } else if (c.this.eXP == i9) {
                        c.this.a(c.this.eXS, i9, 1, c.this.eXR, asList, asList2);
                    } else {
                        c.this.a(c.this.eXS, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.eXS == c.this.eWG) {
                    int i10 = (c.this.eXO + i8) - 1;
                    if (i10 == c.this.eXO) {
                        c.this.a(c.this.eXS, i10, c.this.eXQ, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.eXS, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.eXS == c.this.eWH) {
                    if (i8 == c.this.eXP) {
                        c.this.a(c.this.eXS, c.this.eXJ.getCurrentItem() + 1, 1, c.this.eXR, asList, asList2);
                    } else {
                        c.this.a(c.this.eXS, c.this.eXJ.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.eXS, i8, 1, 31, asList, asList2);
                }
                if (c.this.eXT != null) {
                    c.this.eXT.bpM();
                }
            }
        });
        a(this.eXK);
        a(this.eXL);
        a(this.eXM);
        a(this.eXN);
        if (this.eWC.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.eXI.setVisibility(this.eWC[0] ? 0 : 8);
        this.eXJ.setVisibility(this.eWC[1] ? 0 : 8);
        this.eXK.setVisibility(this.eWC[2] ? 0 : 8);
        this.eXL.setVisibility(this.eWC[3] ? 0 : 8);
        this.eXM.setVisibility(this.eWC[4] ? 0 : 8);
        this.eXN.setVisibility(this.eWC[5] ? 0 : 8);
        bpU();
    }

    private void a(WheelView wheelView) {
        if (this.eXT != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.eXT.bpM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.eXK.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.eXK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.eXK.getAdapter().getItemsCount() - 1) {
            this.eXK.setCurrentItem(this.eXK.getAdapter().getItemsCount() - 1);
        }
    }

    private void bpU() {
        this.eXK.setTextSize(this.textSize);
        this.eXJ.setTextSize(this.textSize);
        this.eXI.setTextSize(this.textSize);
        this.eXL.setTextSize(this.textSize);
        this.eXM.setTextSize(this.textSize);
        this.eXN.setTextSize(this.textSize);
    }

    private void bpV() {
        this.eXK.setTextColorOut(this.textColorOut);
        this.eXJ.setTextColorOut(this.textColorOut);
        this.eXI.setTextColorOut(this.textColorOut);
        this.eXL.setTextColorOut(this.textColorOut);
        this.eXM.setTextColorOut(this.textColorOut);
        this.eXN.setTextColorOut(this.textColorOut);
    }

    private void bpW() {
        this.eXK.setTextColorCenter(this.textColorCenter);
        this.eXJ.setTextColorCenter(this.textColorCenter);
        this.eXI.setTextColorCenter(this.textColorCenter);
        this.eXL.setTextColorCenter(this.textColorCenter);
        this.eXM.setTextColorCenter(this.textColorCenter);
        this.eXN.setTextColorCenter(this.textColorCenter);
    }

    private void bpX() {
        this.eXK.setDividerColor(this.dividerColor);
        this.eXJ.setDividerColor(this.dividerColor);
        this.eXI.setDividerColor(this.dividerColor);
        this.eXL.setDividerColor(this.dividerColor);
        this.eXM.setDividerColor(this.dividerColor);
        this.eXN.setDividerColor(this.dividerColor);
    }

    private void bpY() {
        this.eXK.setDividerType(this.eXm);
        this.eXJ.setDividerType(this.eXm);
        this.eXI.setDividerType(this.eXm);
        this.eXL.setDividerType(this.eXm);
        this.eXM.setDividerType(this.eXm);
        this.eXN.setDividerType(this.eXm);
    }

    private void bpZ() {
        this.eXK.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eXJ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eXI.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eXL.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eXM.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eXN.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.eWJ) {
            if (str != null) {
                this.eXI.setLabel(str);
            } else {
                this.eXI.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.eXJ.setLabel(str2);
            } else {
                this.eXJ.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.eXK.setLabel(str3);
            } else {
                this.eXK.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.eXL.setLabel(str4);
            } else {
                this.eXL.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.eXM.setLabel(str5);
            } else {
                this.eXM.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.eXN.setLabel(str6);
            } else {
                this.eXN.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eXK.setTextXOffset(i);
        this.eXJ.setTextXOffset(i2);
        this.eXI.setTextXOffset(i3);
        this.eXL.setTextXOffset(i4);
        this.eXM.setTextXOffset(i5);
        this.eXN.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.eXI.setCyclic(z);
        this.eXJ.setCyclic(z);
        this.eXK.setCyclic(z);
        this.eXL.setCyclic(z);
        this.eXM.setCyclic(z);
        this.eXN.setCyclic(z);
    }

    public String getTime() {
        if (this.eWJ) {
            return bqa();
        }
        StringBuilder sb = new StringBuilder();
        if (this.eXS == this.eWG) {
            if (this.eXJ.getCurrentItem() + this.eXO == this.eXO) {
                sb.append(this.eXI.getCurrentItem() + this.eWG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eXJ.getCurrentItem() + this.eXO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eXK.getCurrentItem() + this.eXQ).append(" ").append(this.eXL.getCurrentItem()).append(":").append(this.eXM.getCurrentItem()).append(":").append(this.eXN.getCurrentItem());
            } else {
                sb.append(this.eXI.getCurrentItem() + this.eWG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eXJ.getCurrentItem() + this.eXO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eXK.getCurrentItem() + 1).append(" ").append(this.eXL.getCurrentItem()).append(":").append(this.eXM.getCurrentItem()).append(":").append(this.eXN.getCurrentItem());
            }
        } else {
            sb.append(this.eXI.getCurrentItem() + this.eWG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eXJ.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eXK.getCurrentItem() + 1).append(" ").append(this.eXL.getCurrentItem()).append(":").append(this.eXM.getCurrentItem()).append(":").append(this.eXN.getCurrentItem());
        }
        return sb.toString();
    }

    private String bqa() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.eXI.getCurrentItem() + this.eWG;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.pt(currentItem2) == 0) {
            currentItem = this.eXJ.getCurrentItem() + 1;
            z = false;
        } else if ((this.eXJ.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.pt(currentItem2) <= 0) {
            currentItem = this.eXJ.getCurrentItem() + 1;
            z = false;
        } else if ((this.eXJ.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.pt(currentItem2) == 1) {
            currentItem = this.eXJ.getCurrentItem();
            z = true;
        } else {
            currentItem = this.eXJ.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.eXK.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.eXL.getCurrentItem()).append(":").append(this.eXM.getCurrentItem()).append(":").append(this.eXN.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void py(int i) {
        this.eWG = i;
    }

    public void pz(int i) {
        this.eWH = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.eWG) {
                this.eWH = i;
                this.eXP = i2;
                this.eXR = i3;
            } else if (i == this.eWG) {
                if (i2 > this.eXO) {
                    this.eWH = i;
                    this.eXP = i2;
                    this.eXR = i3;
                } else if (i2 == this.eXO && i3 > this.eXQ) {
                    this.eWH = i;
                    this.eXP = i2;
                    this.eXR = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.eWH) {
                this.eXO = i5;
                this.eXQ = i6;
                this.eWG = i4;
            } else if (i4 == this.eWH) {
                if (i5 < this.eXP) {
                    this.eXO = i5;
                    this.eXQ = i6;
                    this.eWG = i4;
                } else if (i5 == this.eXP && i6 < this.eXR) {
                    this.eXO = i5;
                    this.eXQ = i6;
                    this.eWG = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.eWG = calendar.get(1);
            this.eWH = calendar2.get(1);
            this.eXO = calendar.get(2) + 1;
            this.eXP = calendar2.get(2) + 1;
            this.eXQ = calendar.get(5);
            this.eXR = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bpZ();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bpX();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.eXm = dividerType;
        bpY();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bpW();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bpV();
    }

    public void isCenterLabel(boolean z) {
        this.eXK.isCenterLabel(z);
        this.eXJ.isCenterLabel(z);
        this.eXI.isCenterLabel(z);
        this.eXL.isCenterLabel(z);
        this.eXM.isCenterLabel(z);
        this.eXN.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.eXT = bVar;
    }
}
