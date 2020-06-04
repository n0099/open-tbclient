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
    private boolean[] eFV;
    private WheelView.DividerType eGF;
    private WheelView eHb;
    private WheelView eHc;
    private WheelView eHd;
    private WheelView eHe;
    private WheelView eHf;
    private WheelView eHg;
    private int eHl;
    private com.baidu.tbadk.widget.timepicker.a.d.b eHm;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int eFZ = FeatureCodes.SKY_SEG;
    private int eGa = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int eHh = 1;
    private int eHi = 12;
    private int eHj = 1;
    private int eHk = 31;
    private boolean eGc = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.eFV = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void iO(boolean z) {
        this.eGc = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.eGc) {
            int[] C = com.baidu.tbadk.widget.timepicker.a.e.b.C(i, i2 + 1, i3);
            a(C[0], C[1] - 1, C[2], C[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.eHb = (WheelView) this.view.findViewById(R.id.year);
        this.eHb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bf(this.eFZ, this.eGa)));
        this.eHb.setLabel("");
        this.eHb.setCurrentItem(i - this.eFZ);
        this.eHb.setGravity(this.gravity);
        this.eHc = (WheelView) this.view.findViewById(R.id.month);
        this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oG(i)));
        this.eHc.setLabel("");
        int oD = com.baidu.tbadk.widget.timepicker.a.e.a.oD(i);
        if (oD != 0 && (i2 > oD - 1 || z)) {
            this.eHc.setCurrentItem(i2 + 1);
        } else {
            this.eHc.setCurrentItem(i2);
        }
        this.eHc.setGravity(this.gravity);
        this.eHd = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.oD(i) == 0) {
            this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.be(i, i2))));
        } else {
            this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.oC(i))));
        }
        this.eHd.setLabel("");
        this.eHd.setCurrentItem(i3 - 1);
        this.eHd.setGravity(this.gravity);
        this.eHe = (WheelView) this.view.findViewById(R.id.hour);
        this.eHe.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eHe.setCurrentItem(i4);
        this.eHe.setGravity(this.gravity);
        this.eHf = (WheelView) this.view.findViewById(R.id.min);
        this.eHf.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eHf.setCurrentItem(i5);
        this.eHf.setGravity(this.gravity);
        this.eHg = (WheelView) this.view.findViewById(R.id.second);
        this.eHg.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eHg.setCurrentItem(i5);
        this.eHg.setGravity(this.gravity);
        this.eHb.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int be;
                int i8 = c.this.eFZ + i7;
                c.this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oG(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.oD(i8) == 0 || c.this.eHc.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.oD(i8) - 1) {
                    c.this.eHc.setCurrentItem(c.this.eHc.getCurrentItem());
                } else {
                    c.this.eHc.setCurrentItem(c.this.eHc.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.oD(i8) == 0 || c.this.eHc.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.oD(i8) - 1) {
                    c.this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eHc.getCurrentItem() + 1))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eHc.getCurrentItem() + 1);
                } else if (c.this.eHc.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.oD(i8) + 1) {
                    c.this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.oC(i8))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.oC(i8);
                } else {
                    c.this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eHc.getCurrentItem()))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(i8, c.this.eHc.getCurrentItem());
                }
                if (c.this.eHd.getCurrentItem() > be - 1) {
                    c.this.eHd.setCurrentItem(be - 1);
                }
                if (c.this.eHm != null) {
                    c.this.eHm.bjs();
                }
            }
        });
        this.eHc.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int be;
                int currentItem = c.this.eHb.getCurrentItem() + c.this.eFZ;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.oD(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.oD(currentItem) - 1) {
                    c.this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7 + 1))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7 + 1);
                } else if (c.this.eHc.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.oD(currentItem) + 1) {
                    c.this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.oC(currentItem))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.oC(currentItem);
                } else {
                    c.this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oH(com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7))));
                    be = com.baidu.tbadk.widget.timepicker.a.e.a.be(currentItem, i7);
                }
                if (c.this.eHd.getCurrentItem() > be - 1) {
                    c.this.eHd.setCurrentItem(be - 1);
                }
                if (c.this.eHm != null) {
                    c.this.eHm.bjs();
                }
            }
        });
        a(this.eHd);
        a(this.eHe);
        a(this.eHf);
        a(this.eHg);
        if (this.eFV.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.eHb.setVisibility(this.eFV[0] ? 0 : 8);
        this.eHc.setVisibility(this.eFV[1] ? 0 : 8);
        this.eHd.setVisibility(this.eFV[2] ? 0 : 8);
        this.eHe.setVisibility(this.eFV[3] ? 0 : 8);
        this.eHf.setVisibility(this.eFV[4] ? 0 : 8);
        this.eHg.setVisibility(this.eFV[5] ? 0 : 8);
        bjA();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.eHl = i;
        this.eHb = (WheelView) this.view.findViewById(R.id.year);
        this.eHb.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eFZ, this.eGa));
        this.eHb.setCurrentItem(i - this.eFZ);
        this.eHb.setGravity(this.gravity);
        this.eHc = (WheelView) this.view.findViewById(R.id.month);
        if (this.eFZ == this.eGa) {
            this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHh, this.eHi));
            this.eHc.setCurrentItem((i2 + 1) - this.eHh);
        } else if (i == this.eFZ) {
            this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHh, 12));
            this.eHc.setCurrentItem((i2 + 1) - this.eHh);
        } else if (i == this.eGa) {
            this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eHi));
            this.eHc.setCurrentItem(i2);
        } else {
            this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.eHc.setCurrentItem(i2);
        }
        this.eHc.setGravity(this.gravity);
        this.eHd = (WheelView) this.view.findViewById(R.id.day);
        if (this.eFZ == this.eGa && this.eHh == this.eHi) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eHk > 31) {
                    this.eHk = 31;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, this.eHk));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eHk > 30) {
                    this.eHk = 30;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, this.eHk));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eHk > 29) {
                    this.eHk = 29;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, this.eHk));
            } else {
                if (this.eHk > 28) {
                    this.eHk = 28;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, this.eHk));
            }
            this.eHd.setCurrentItem(i3 - this.eHj);
        } else if (i == this.eFZ && i2 + 1 == this.eHh) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, 29));
            } else {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eHj, 28));
            }
            this.eHd.setCurrentItem(i3 - this.eHj);
        } else if (i == this.eGa && i2 + 1 == this.eHi) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.eHk > 31) {
                    this.eHk = 31;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eHk));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.eHk > 30) {
                    this.eHk = 30;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eHk));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.eHk > 29) {
                    this.eHk = 29;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eHk));
            } else {
                if (this.eHk > 28) {
                    this.eHk = 28;
                }
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.eHk));
            }
            this.eHd.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.eHd.setCurrentItem(i3 - 1);
        }
        this.eHd.setGravity(this.gravity);
        this.eHe = (WheelView) this.view.findViewById(R.id.hour);
        this.eHe.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eHe.setCurrentItem(i4);
        this.eHe.setGravity(this.gravity);
        this.eHf = (WheelView) this.view.findViewById(R.id.min);
        this.eHf.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eHf.setCurrentItem(i5);
        this.eHf.setGravity(this.gravity);
        this.eHg = (WheelView) this.view.findViewById(R.id.second);
        this.eHg.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.eHg.setCurrentItem(i6);
        this.eHg.setGravity(this.gravity);
        this.eHb.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.eFZ;
                c.this.eHl = i8;
                int currentItem = c.this.eHc.getCurrentItem();
                if (c.this.eFZ == c.this.eGa) {
                    c.this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eHh, c.this.eHi));
                    if (currentItem > c.this.eHc.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eHc.getAdapter().getItemsCount() - 1;
                        c.this.eHc.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.eHh + currentItem;
                    if (c.this.eHh == c.this.eHi) {
                        c.this.a(i8, i9, c.this.eHj, c.this.eHk, asList, asList2);
                    } else if (i9 == c.this.eHh) {
                        c.this.a(i8, i9, c.this.eHj, 31, asList, asList2);
                    } else if (i9 == c.this.eHi) {
                        c.this.a(i8, i9, 1, c.this.eHk, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eFZ) {
                    c.this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.eHh, 12));
                    if (currentItem > c.this.eHc.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eHc.getAdapter().getItemsCount() - 1;
                        c.this.eHc.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.eHh + currentItem;
                    if (i10 == c.this.eHh) {
                        c.this.a(i8, i10, c.this.eHj, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eGa) {
                    c.this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.eHi));
                    if (currentItem > c.this.eHc.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.eHc.getAdapter().getItemsCount() - 1;
                        c.this.eHc.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.eHi) {
                        c.this.a(i8, i11, 1, c.this.eHk, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.eHc.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.eHc.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.eHm != null) {
                    c.this.eHm.bjs();
                }
            }
        });
        this.eHc.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.eFZ == c.this.eGa) {
                    int i9 = (c.this.eHh + i8) - 1;
                    if (c.this.eHh == c.this.eHi) {
                        c.this.a(c.this.eHl, i9, c.this.eHj, c.this.eHk, asList, asList2);
                    } else if (c.this.eHh == i9) {
                        c.this.a(c.this.eHl, i9, c.this.eHj, 31, asList, asList2);
                    } else if (c.this.eHi == i9) {
                        c.this.a(c.this.eHl, i9, 1, c.this.eHk, asList, asList2);
                    } else {
                        c.this.a(c.this.eHl, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.eHl == c.this.eFZ) {
                    int i10 = (c.this.eHh + i8) - 1;
                    if (i10 == c.this.eHh) {
                        c.this.a(c.this.eHl, i10, c.this.eHj, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.eHl, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.eHl == c.this.eGa) {
                    if (i8 == c.this.eHi) {
                        c.this.a(c.this.eHl, c.this.eHc.getCurrentItem() + 1, 1, c.this.eHk, asList, asList2);
                    } else {
                        c.this.a(c.this.eHl, c.this.eHc.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.eHl, i8, 1, 31, asList, asList2);
                }
                if (c.this.eHm != null) {
                    c.this.eHm.bjs();
                }
            }
        });
        a(this.eHd);
        a(this.eHe);
        a(this.eHf);
        a(this.eHg);
        if (this.eFV.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.eHb.setVisibility(this.eFV[0] ? 0 : 8);
        this.eHc.setVisibility(this.eFV[1] ? 0 : 8);
        this.eHd.setVisibility(this.eFV[2] ? 0 : 8);
        this.eHe.setVisibility(this.eFV[3] ? 0 : 8);
        this.eHf.setVisibility(this.eFV[4] ? 0 : 8);
        this.eHg.setVisibility(this.eFV[5] ? 0 : 8);
        bjA();
    }

    private void a(WheelView wheelView) {
        if (this.eHm != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.eHm.bjs();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.eHd.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.eHd.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.eHd.getAdapter().getItemsCount() - 1) {
            this.eHd.setCurrentItem(this.eHd.getAdapter().getItemsCount() - 1);
        }
    }

    private void bjA() {
        this.eHd.setTextSize(this.textSize);
        this.eHc.setTextSize(this.textSize);
        this.eHb.setTextSize(this.textSize);
        this.eHe.setTextSize(this.textSize);
        this.eHf.setTextSize(this.textSize);
        this.eHg.setTextSize(this.textSize);
    }

    private void bjB() {
        this.eHd.setTextColorOut(this.textColorOut);
        this.eHc.setTextColorOut(this.textColorOut);
        this.eHb.setTextColorOut(this.textColorOut);
        this.eHe.setTextColorOut(this.textColorOut);
        this.eHf.setTextColorOut(this.textColorOut);
        this.eHg.setTextColorOut(this.textColorOut);
    }

    private void bjC() {
        this.eHd.setTextColorCenter(this.textColorCenter);
        this.eHc.setTextColorCenter(this.textColorCenter);
        this.eHb.setTextColorCenter(this.textColorCenter);
        this.eHe.setTextColorCenter(this.textColorCenter);
        this.eHf.setTextColorCenter(this.textColorCenter);
        this.eHg.setTextColorCenter(this.textColorCenter);
    }

    private void bjD() {
        this.eHd.setDividerColor(this.dividerColor);
        this.eHc.setDividerColor(this.dividerColor);
        this.eHb.setDividerColor(this.dividerColor);
        this.eHe.setDividerColor(this.dividerColor);
        this.eHf.setDividerColor(this.dividerColor);
        this.eHg.setDividerColor(this.dividerColor);
    }

    private void bjE() {
        this.eHd.setDividerType(this.eGF);
        this.eHc.setDividerType(this.eGF);
        this.eHb.setDividerType(this.eGF);
        this.eHe.setDividerType(this.eGF);
        this.eHf.setDividerType(this.eGF);
        this.eHg.setDividerType(this.eGF);
    }

    private void bjF() {
        this.eHd.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eHc.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eHb.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eHe.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eHf.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eHg.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.eGc) {
            if (str != null) {
                this.eHb.setLabel(str);
            } else {
                this.eHb.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.eHc.setLabel(str2);
            } else {
                this.eHc.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.eHd.setLabel(str3);
            } else {
                this.eHd.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.eHe.setLabel(str4);
            } else {
                this.eHe.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.eHf.setLabel(str5);
            } else {
                this.eHf.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.eHg.setLabel(str6);
            } else {
                this.eHg.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eHd.setTextXOffset(i);
        this.eHc.setTextXOffset(i2);
        this.eHb.setTextXOffset(i3);
        this.eHe.setTextXOffset(i4);
        this.eHf.setTextXOffset(i5);
        this.eHg.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.eHb.setCyclic(z);
        this.eHc.setCyclic(z);
        this.eHd.setCyclic(z);
        this.eHe.setCyclic(z);
        this.eHf.setCyclic(z);
        this.eHg.setCyclic(z);
    }

    public String getTime() {
        if (this.eGc) {
            return bjG();
        }
        StringBuilder sb = new StringBuilder();
        if (this.eHl == this.eFZ) {
            if (this.eHc.getCurrentItem() + this.eHh == this.eHh) {
                sb.append(this.eHb.getCurrentItem() + this.eFZ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eHc.getCurrentItem() + this.eHh).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eHd.getCurrentItem() + this.eHj).append(" ").append(this.eHe.getCurrentItem()).append(":").append(this.eHf.getCurrentItem()).append(":").append(this.eHg.getCurrentItem());
            } else {
                sb.append(this.eHb.getCurrentItem() + this.eFZ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eHc.getCurrentItem() + this.eHh).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eHd.getCurrentItem() + 1).append(" ").append(this.eHe.getCurrentItem()).append(":").append(this.eHf.getCurrentItem()).append(":").append(this.eHg.getCurrentItem());
            }
        } else {
            sb.append(this.eHb.getCurrentItem() + this.eFZ).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eHc.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.eHd.getCurrentItem() + 1).append(" ").append(this.eHe.getCurrentItem()).append(":").append(this.eHf.getCurrentItem()).append(":").append(this.eHg.getCurrentItem());
        }
        return sb.toString();
    }

    private String bjG() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.eHb.getCurrentItem() + this.eFZ;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.oD(currentItem2) == 0) {
            currentItem = this.eHc.getCurrentItem() + 1;
            z = false;
        } else if ((this.eHc.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.oD(currentItem2) <= 0) {
            currentItem = this.eHc.getCurrentItem() + 1;
            z = false;
        } else if ((this.eHc.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.oD(currentItem2) == 1) {
            currentItem = this.eHc.getCurrentItem();
            z = true;
        } else {
            currentItem = this.eHc.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.eHd.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.eHe.getCurrentItem()).append(":").append(this.eHf.getCurrentItem()).append(":").append(this.eHg.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void oI(int i) {
        this.eFZ = i;
    }

    public void oJ(int i) {
        this.eGa = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.eFZ) {
                this.eGa = i;
                this.eHi = i2;
                this.eHk = i3;
            } else if (i == this.eFZ) {
                if (i2 > this.eHh) {
                    this.eGa = i;
                    this.eHi = i2;
                    this.eHk = i3;
                } else if (i2 == this.eHh && i3 > this.eHj) {
                    this.eGa = i;
                    this.eHi = i2;
                    this.eHk = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.eGa) {
                this.eHh = i5;
                this.eHj = i6;
                this.eFZ = i4;
            } else if (i4 == this.eGa) {
                if (i5 < this.eHi) {
                    this.eHh = i5;
                    this.eHj = i6;
                    this.eFZ = i4;
                } else if (i5 == this.eHi && i6 < this.eHk) {
                    this.eHh = i5;
                    this.eHj = i6;
                    this.eFZ = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.eFZ = calendar.get(1);
            this.eGa = calendar2.get(1);
            this.eHh = calendar.get(2) + 1;
            this.eHi = calendar2.get(2) + 1;
            this.eHj = calendar.get(5);
            this.eHk = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bjF();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bjD();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.eGF = dividerType;
        bjE();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bjC();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bjB();
    }

    public void isCenterLabel(boolean z) {
        this.eHd.isCenterLabel(z);
        this.eHc.isCenterLabel(z);
        this.eHb.isCenterLabel(z);
        this.eHe.isCenterLabel(z);
        this.eHf.isCenterLabel(z);
        this.eHg.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.eHm = bVar;
    }
}
