package com.baidu.tbadk.widget.timepicker.a.f;

import android.view.View;
import com.baidu.ar.auth.FeatureCodes;
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
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int dividerColor;
    private boolean[] eFK;
    private WheelView eGQ;
    private WheelView eGR;
    private WheelView eGS;
    private WheelView eGT;
    private WheelView eGU;
    private WheelView eGV;
    private WheelView.DividerType eGu;
    private int eHa;
    private com.baidu.tbadk.widget.timepicker.a.d.b eHb;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int eFO = FeatureCodes.SKY_SEG;
    private int eFP = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int eGW = 1;
    private int eGX = 12;
    private int eGY = 1;
    private int eGZ = 31;
    private boolean eFR = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.eFK = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void iO(boolean z) {
        this.eFR = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.eFR) {
            int[] C = com.baidu.tbadk.widget.timepicker.a.e.b.C(i, i2 + 1, i3);
            a(C[0], C[1] - 1, C[2], C[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.eGQ = (WheelView) this.view.findViewById(R.id.year);
        this.eGQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bf(this.eFO, this.eFP)));
        this.eGQ.setLabel("");
        this.eGQ.setCurrentItem(i - this.eFO);
        this.eGQ.setGravity(this.gravity);
        this.eGR = (WheelView) this.view.findViewById(R.id.month);
        this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oE(i)));
        this.eGR.setLabel("");
        int oB = com.baidu.tbadk.widget.timepicker.a.e.a.oB(i);
        if (oB != 0 && (i2 > oB - 1 || z)) {
            this.eGR.setCurrentItem(i2 + 1);
        } else {
            this.eGR.setCurrentItem(i2);
        }
        this.eGR.setGravity(this.gravity);
        this.eGS = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.oB(i) == 0) {
            this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.be(i, i2))));
        } else {
            this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.oA(i))));
        }
        this.eGS.setLabel("");
        this.eGS.setCurrentItem(i3 - 1);
        this.eGS.setGravity(this.gravity);
        this.eGT = (WheelView) this.view.findViewById(R.id.hour);
        this.eGT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eGT.setCurrentItem(i4);
        this.eGT.setGravity(this.gravity);
        this.eGU = (WheelView) this.view.findViewById(R.id.min);
        this.eGU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eGU.setCurrentItem(i5);
        this.eGU.setGravity(this.gravity);
        this.eGV = (WheelView) this.view.findViewById(R.id.second);
        this.eGV.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eGV.setCurrentItem(i5);
        this.eGV.setGravity(this.gravity);
        this.eGQ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int be;
                int i8 = c.this.eFO + i7;
                c.this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oE(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.oB(i8) == 0 || c.this.eGR.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.oB(i8) - 1) {
                    c.this.eGR.setCurrentItem(c.this.eGR.getCurrentItem());
                } else {
                    c.this.eGR.setCurrentItem(c.this.eGR.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.oB(i8) == 0 || c.this.eGR.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.oB(i8) - 1) {
                    c.this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eGR.getCurrentItem() + 1))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eGR.getCurrentItem() + 1);
                } else if (c.this.eGR.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.oB(i8) + 1) {
                    c.this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.oA(i8))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.oA(i8);
                } else {
                    c.this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eGR.getCurrentItem()))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eGR.getCurrentItem());
                }
                if (c.this.eGS.getCurrentItem() > be - 1) {
                    c.this.eGS.setCurrentItem(be - 1);
                }
                if (c.this.eHb != null) {
                    c.this.eHb.bjq();
                }
            }
        });
        this.eGR.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int be;
                int currentItem = c.this.eGQ.getCurrentItem() + c.this.eFO;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.oB(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.oB(currentItem) - 1) {
                    c.this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7 + 1))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7 + 1);
                } else if (c.this.eGR.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.oB(currentItem) + 1) {
                    c.this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.oA(currentItem))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.oA(currentItem);
                } else {
                    c.this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oF(com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7);
                }
                if (c.this.eGS.getCurrentItem() > be - 1) {
                    c.this.eGS.setCurrentItem(be - 1);
                }
                if (c.this.eHb != null) {
                    c.this.eHb.bjq();
                }
            }
        });
        a(this.eGS);
        a(this.eGT);
        a(this.eGU);
        a(this.eGV);
        if (this.eFK.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.eGQ.setVisibility(this.eFK[0] ? 0 : 8);
        this.eGR.setVisibility(this.eFK[1] ? 0 : 8);
        this.eGS.setVisibility(this.eFK[2] ? 0 : 8);
        this.eGT.setVisibility(this.eFK[3] ? 0 : 8);
        this.eGU.setVisibility(this.eFK[4] ? 0 : 8);
        this.eGV.setVisibility(this.eFK[5] ? 0 : 8);
        bjy();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.eHa = i;
        this.eGQ = (WheelView) this.view.findViewById(R.id.year);
        this.eGQ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eFO, this.eFP));
        this.eGQ.setCurrentItem(i - this.eFO);
        this.eGQ.setGravity(this.gravity);
        this.eGR = (WheelView) this.view.findViewById(R.id.month);
        if (this.eFO == this.eFP) {
            this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGW, this.eGX));
            this.eGR.setCurrentItem((i2 + 1) - this.eGW);
        } else if (i == this.eFO) {
            this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGW, 12));
            this.eGR.setCurrentItem((i2 + 1) - this.eGW);
        } else if (i == this.eFP) {
            this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eGX));
            this.eGR.setCurrentItem(i2);
        } else {
            this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.eGR.setCurrentItem(i2);
        }
        this.eGR.setGravity(this.gravity);
        this.eGS = (WheelView) this.view.findViewById(R.id.day);
        if (this.eFO == this.eFP && this.eGW == this.eGX) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eGZ > 31) {
                    this.eGZ = 31;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, this.eGZ));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eGZ > 30) {
                    this.eGZ = 30;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, this.eGZ));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eGZ > 29) {
                    this.eGZ = 29;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, this.eGZ));
            } else {
                if (this.eGZ > 28) {
                    this.eGZ = 28;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, this.eGZ));
            }
            this.eGS.setCurrentItem(i3 - this.eGY);
        } else if (i == this.eFO && i2 + 1 == this.eGW) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, 29));
            } else {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eGY, 28));
            }
            this.eGS.setCurrentItem(i3 - this.eGY);
        } else if (i == this.eFP && i2 + 1 == this.eGX) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eGZ > 31) {
                    this.eGZ = 31;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eGZ));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eGZ > 30) {
                    this.eGZ = 30;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eGZ));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eGZ > 29) {
                    this.eGZ = 29;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eGZ));
            } else {
                if (this.eGZ > 28) {
                    this.eGZ = 28;
                }
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eGZ));
            }
            this.eGS.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.eGS.setCurrentItem(i3 - 1);
        }
        this.eGS.setGravity(this.gravity);
        this.eGT = (WheelView) this.view.findViewById(R.id.hour);
        this.eGT.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eGT.setCurrentItem(i4);
        this.eGT.setGravity(this.gravity);
        this.eGU = (WheelView) this.view.findViewById(R.id.min);
        this.eGU.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eGU.setCurrentItem(i5);
        this.eGU.setGravity(this.gravity);
        this.eGV = (WheelView) this.view.findViewById(R.id.second);
        this.eGV.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eGV.setCurrentItem(i6);
        this.eGV.setGravity(this.gravity);
        this.eGQ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.eFO;
                c.this.eHa = i8;
                int currentItem = c.this.eGR.getCurrentItem();
                if (c.this.eFO == c.this.eFP) {
                    c.this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eGW, c.this.eGX));
                    if (currentItem > c.this.eGR.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eGR.getAdapter().getItemsCount() - 1;
                        c.this.eGR.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.eGW + currentItem;
                    if (c.this.eGW == c.this.eGX) {
                        c.this.a(i8, i9, c.this.eGY, c.this.eGZ, asList, asList2);
                    } else if (i9 == c.this.eGW) {
                        c.this.a(i8, i9, c.this.eGY, 31, asList, asList2);
                    } else if (i9 == c.this.eGX) {
                        c.this.a(i8, i9, 1, c.this.eGZ, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eFO) {
                    c.this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eGW, 12));
                    if (currentItem > c.this.eGR.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eGR.getAdapter().getItemsCount() - 1;
                        c.this.eGR.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.eGW + currentItem;
                    if (i10 == c.this.eGW) {
                        c.this.a(i8, i10, c.this.eGY, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eFP) {
                    c.this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.eGX));
                    if (currentItem > c.this.eGR.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eGR.getAdapter().getItemsCount() - 1;
                        c.this.eGR.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.eGX) {
                        c.this.a(i8, i11, 1, c.this.eGZ, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.eGR.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.eGR.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.eHb != null) {
                    c.this.eHb.bjq();
                }
            }
        });
        this.eGR.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.eFO == c.this.eFP) {
                    int i9 = (c.this.eGW + i8) - 1;
                    if (c.this.eGW == c.this.eGX) {
                        c.this.a(c.this.eHa, i9, c.this.eGY, c.this.eGZ, asList, asList2);
                    } else if (c.this.eGW == i9) {
                        c.this.a(c.this.eHa, i9, c.this.eGY, 31, asList, asList2);
                    } else if (c.this.eGX == i9) {
                        c.this.a(c.this.eHa, i9, 1, c.this.eGZ, asList, asList2);
                    } else {
                        c.this.a(c.this.eHa, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.eHa == c.this.eFO) {
                    int i10 = (c.this.eGW + i8) - 1;
                    if (i10 == c.this.eGW) {
                        c.this.a(c.this.eHa, i10, c.this.eGY, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.eHa, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.eHa == c.this.eFP) {
                    if (i8 == c.this.eGX) {
                        c.this.a(c.this.eHa, c.this.eGR.getCurrentItem() + 1, 1, c.this.eGZ, asList, asList2);
                    } else {
                        c.this.a(c.this.eHa, c.this.eGR.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.eHa, i8, 1, 31, asList, asList2);
                }
                if (c.this.eHb != null) {
                    c.this.eHb.bjq();
                }
            }
        });
        a(this.eGS);
        a(this.eGT);
        a(this.eGU);
        a(this.eGV);
        if (this.eFK.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.eGQ.setVisibility(this.eFK[0] ? 0 : 8);
        this.eGR.setVisibility(this.eFK[1] ? 0 : 8);
        this.eGS.setVisibility(this.eFK[2] ? 0 : 8);
        this.eGT.setVisibility(this.eFK[3] ? 0 : 8);
        this.eGU.setVisibility(this.eFK[4] ? 0 : 8);
        this.eGV.setVisibility(this.eFK[5] ? 0 : 8);
        bjy();
    }

    private void a(WheelView wheelView) {
        if (this.eHb != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.eHb.bjq();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.eGS.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.eGS.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.eGS.getAdapter().getItemsCount() - 1) {
            this.eGS.setCurrentItem(this.eGS.getAdapter().getItemsCount() - 1);
        }
    }

    private void bjy() {
        this.eGS.setTextSize(this.textSize);
        this.eGR.setTextSize(this.textSize);
        this.eGQ.setTextSize(this.textSize);
        this.eGT.setTextSize(this.textSize);
        this.eGU.setTextSize(this.textSize);
        this.eGV.setTextSize(this.textSize);
    }

    private void bjz() {
        this.eGS.setTextColorOut(this.textColorOut);
        this.eGR.setTextColorOut(this.textColorOut);
        this.eGQ.setTextColorOut(this.textColorOut);
        this.eGT.setTextColorOut(this.textColorOut);
        this.eGU.setTextColorOut(this.textColorOut);
        this.eGV.setTextColorOut(this.textColorOut);
    }

    private void bjA() {
        this.eGS.setTextColorCenter(this.textColorCenter);
        this.eGR.setTextColorCenter(this.textColorCenter);
        this.eGQ.setTextColorCenter(this.textColorCenter);
        this.eGT.setTextColorCenter(this.textColorCenter);
        this.eGU.setTextColorCenter(this.textColorCenter);
        this.eGV.setTextColorCenter(this.textColorCenter);
    }

    private void bjB() {
        this.eGS.setDividerColor(this.dividerColor);
        this.eGR.setDividerColor(this.dividerColor);
        this.eGQ.setDividerColor(this.dividerColor);
        this.eGT.setDividerColor(this.dividerColor);
        this.eGU.setDividerColor(this.dividerColor);
        this.eGV.setDividerColor(this.dividerColor);
    }

    private void bjC() {
        this.eGS.setDividerType(this.eGu);
        this.eGR.setDividerType(this.eGu);
        this.eGQ.setDividerType(this.eGu);
        this.eGT.setDividerType(this.eGu);
        this.eGU.setDividerType(this.eGu);
        this.eGV.setDividerType(this.eGu);
    }

    private void bjD() {
        this.eGS.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eGR.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eGQ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eGT.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eGU.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eGV.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.eFR) {
            if (str != null) {
                this.eGQ.setLabel(str);
            } else {
                this.eGQ.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.eGR.setLabel(str2);
            } else {
                this.eGR.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.eGS.setLabel(str3);
            } else {
                this.eGS.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.eGT.setLabel(str4);
            } else {
                this.eGT.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.eGU.setLabel(str5);
            } else {
                this.eGU.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.eGV.setLabel(str6);
            } else {
                this.eGV.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eGS.setTextXOffset(i);
        this.eGR.setTextXOffset(i2);
        this.eGQ.setTextXOffset(i3);
        this.eGT.setTextXOffset(i4);
        this.eGU.setTextXOffset(i5);
        this.eGV.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.eGQ.setCyclic(z);
        this.eGR.setCyclic(z);
        this.eGS.setCyclic(z);
        this.eGT.setCyclic(z);
        this.eGU.setCyclic(z);
        this.eGV.setCyclic(z);
    }

    public String getTime() {
        if (this.eFR) {
            return bjE();
        }
        StringBuilder sb = new StringBuilder();
        if (this.eHa == this.eFO) {
            if (this.eGR.getCurrentItem() + this.eGW == this.eGW) {
                sb.append(this.eGQ.getCurrentItem() + this.eFO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eGR.getCurrentItem() + this.eGW).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eGS.getCurrentItem() + this.eGY).append(" ").append(this.eGT.getCurrentItem()).append(":").append(this.eGU.getCurrentItem()).append(":").append(this.eGV.getCurrentItem());
            } else {
                sb.append(this.eGQ.getCurrentItem() + this.eFO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eGR.getCurrentItem() + this.eGW).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eGS.getCurrentItem() + 1).append(" ").append(this.eGT.getCurrentItem()).append(":").append(this.eGU.getCurrentItem()).append(":").append(this.eGV.getCurrentItem());
            }
        } else {
            sb.append(this.eGQ.getCurrentItem() + this.eFO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eGR.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eGS.getCurrentItem() + 1).append(" ").append(this.eGT.getCurrentItem()).append(":").append(this.eGU.getCurrentItem()).append(":").append(this.eGV.getCurrentItem());
        }
        return sb.toString();
    }

    private String bjE() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.eGQ.getCurrentItem() + this.eFO;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.oB(currentItem2) == 0) {
            currentItem = this.eGR.getCurrentItem() + 1;
            z = false;
        } else if ((this.eGR.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.oB(currentItem2) <= 0) {
            currentItem = this.eGR.getCurrentItem() + 1;
            z = false;
        } else if ((this.eGR.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.oB(currentItem2) == 1) {
            currentItem = this.eGR.getCurrentItem();
            z = true;
        } else {
            currentItem = this.eGR.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.eGS.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.eGT.getCurrentItem()).append(":").append(this.eGU.getCurrentItem()).append(":").append(this.eGV.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void oG(int i) {
        this.eFO = i;
    }

    public void oH(int i) {
        this.eFP = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.eFO) {
                this.eFP = i;
                this.eGX = i2;
                this.eGZ = i3;
            } else if (i == this.eFO) {
                if (i2 > this.eGW) {
                    this.eFP = i;
                    this.eGX = i2;
                    this.eGZ = i3;
                } else if (i2 == this.eGW && i3 > this.eGY) {
                    this.eFP = i;
                    this.eGX = i2;
                    this.eGZ = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.eFP) {
                this.eGW = i5;
                this.eGY = i6;
                this.eFO = i4;
            } else if (i4 == this.eFP) {
                if (i5 < this.eGX) {
                    this.eGW = i5;
                    this.eGY = i6;
                    this.eFO = i4;
                } else if (i5 == this.eGX && i6 < this.eGZ) {
                    this.eGW = i5;
                    this.eGY = i6;
                    this.eFO = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.eFO = calendar.get(1);
            this.eFP = calendar2.get(1);
            this.eGW = calendar.get(2) + 1;
            this.eGX = calendar2.get(2) + 1;
            this.eGY = calendar.get(5);
            this.eGZ = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bjD();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bjB();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.eGu = dividerType;
        bjC();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bjA();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bjz();
    }

    public void isCenterLabel(boolean z) {
        this.eGS.isCenterLabel(z);
        this.eGR.isCenterLabel(z);
        this.eGQ.isCenterLabel(z);
        this.eGT.isCenterLabel(z);
        this.eGU.isCenterLabel(z);
        this.eGV.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.eHb = bVar;
    }
}
