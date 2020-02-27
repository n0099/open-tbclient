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
    private boolean[] dQC;
    private WheelView dRI;
    private WheelView dRJ;
    private WheelView dRK;
    private WheelView dRL;
    private WheelView dRM;
    private WheelView dRN;
    private int dRS;
    private com.baidu.tbadk.widget.timepicker.a.d.b dRT;
    private WheelView.DividerType dRm;
    private int dividerColor;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int dQG = 1900;
    private int dQH = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int dRO = 1;
    private int dRP = 12;
    private int dRQ = 1;
    private int dRR = 31;
    private boolean dQJ = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.dQC = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void hs(boolean z) {
        this.dQJ = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.dQJ) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.dRI = (WheelView) this.view.findViewById(R.id.year);
        this.dRI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aW(this.dQG, this.dQH)));
        this.dRI.setLabel("");
        this.dRI.setCurrentItem(i - this.dQG);
        this.dRI.setGravity(this.gravity);
        this.dRJ = (WheelView) this.view.findViewById(R.id.month);
        this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nK(i)));
        this.dRJ.setLabel("");
        int nH = com.baidu.tbadk.widget.timepicker.a.e.a.nH(i);
        if (nH != 0 && (i2 > nH - 1 || z)) {
            this.dRJ.setCurrentItem(i2 + 1);
        } else {
            this.dRJ.setCurrentItem(i2);
        }
        this.dRJ.setGravity(this.gravity);
        this.dRK = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i) == 0) {
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i, i2))));
        } else {
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(i))));
        }
        this.dRK.setLabel("");
        this.dRK.setCurrentItem(i3 - 1);
        this.dRK.setGravity(this.gravity);
        this.dRL = (WheelView) this.view.findViewById(R.id.hour);
        this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dRL.setCurrentItem(i4);
        this.dRL.setGravity(this.gravity);
        this.dRM = (WheelView) this.view.findViewById(R.id.min);
        this.dRM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRM.setCurrentItem(i5);
        this.dRM.setGravity(this.gravity);
        this.dRN = (WheelView) this.view.findViewById(R.id.second);
        this.dRN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRN.setCurrentItem(i5);
        this.dRN.setGravity(this.gravity);
        this.dRI.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int i8 = c.this.dQG + i7;
                c.this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nK(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) == 0 || c.this.dRJ.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) - 1) {
                    c.this.dRJ.setCurrentItem(c.this.dRJ.getCurrentItem());
                } else {
                    c.this.dRJ.setCurrentItem(c.this.dRJ.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) == 0 || c.this.dRJ.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) - 1) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRJ.getCurrentItem() + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRJ.getCurrentItem() + 1);
                } else if (c.this.dRJ.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) + 1) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(i8))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.nG(i8);
                } else {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRJ.getCurrentItem()))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRJ.getCurrentItem());
                }
                if (c.this.dRK.getCurrentItem() > aV - 1) {
                    c.this.dRK.setCurrentItem(aV - 1);
                }
                if (c.this.dRT != null) {
                    c.this.dRT.aUQ();
                }
            }
        });
        this.dRJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int currentItem = c.this.dRI.getCurrentItem() + c.this.dQG;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) - 1) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1);
                } else if (c.this.dRJ.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) + 1) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(currentItem))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.nG(currentItem);
                } else {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7);
                }
                if (c.this.dRK.getCurrentItem() > aV - 1) {
                    c.this.dRK.setCurrentItem(aV - 1);
                }
                if (c.this.dRT != null) {
                    c.this.dRT.aUQ();
                }
            }
        });
        a(this.dRK);
        a(this.dRL);
        a(this.dRM);
        a(this.dRN);
        if (this.dQC.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.dRI.setVisibility(this.dQC[0] ? 0 : 8);
        this.dRJ.setVisibility(this.dQC[1] ? 0 : 8);
        this.dRK.setVisibility(this.dQC[2] ? 0 : 8);
        this.dRL.setVisibility(this.dQC[3] ? 0 : 8);
        this.dRM.setVisibility(this.dQC[4] ? 0 : 8);
        this.dRN.setVisibility(this.dQC[5] ? 0 : 8);
        aUY();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.dRS = i;
        this.dRI = (WheelView) this.view.findViewById(R.id.year);
        this.dRI.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dQG, this.dQH));
        this.dRI.setCurrentItem(i - this.dQG);
        this.dRI.setGravity(this.gravity);
        this.dRJ = (WheelView) this.view.findViewById(R.id.month);
        if (this.dQG == this.dQH) {
            this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRO, this.dRP));
            this.dRJ.setCurrentItem((i2 + 1) - this.dRO);
        } else if (i == this.dQG) {
            this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRO, 12));
            this.dRJ.setCurrentItem((i2 + 1) - this.dRO);
        } else if (i == this.dQH) {
            this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRP));
            this.dRJ.setCurrentItem(i2);
        } else {
            this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.dRJ.setCurrentItem(i2);
        }
        this.dRJ.setGravity(this.gravity);
        this.dRK = (WheelView) this.view.findViewById(R.id.day);
        if (this.dQG == this.dQH && this.dRO == this.dRP) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dRR > 31) {
                    this.dRR = 31;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, this.dRR));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dRR > 30) {
                    this.dRR = 30;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, this.dRR));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dRR > 29) {
                    this.dRR = 29;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, this.dRR));
            } else {
                if (this.dRR > 28) {
                    this.dRR = 28;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, this.dRR));
            }
            this.dRK.setCurrentItem(i3 - this.dRQ);
        } else if (i == this.dQG && i2 + 1 == this.dRO) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, 29));
            } else {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRQ, 28));
            }
            this.dRK.setCurrentItem(i3 - this.dRQ);
        } else if (i == this.dQH && i2 + 1 == this.dRP) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dRR > 31) {
                    this.dRR = 31;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRR));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dRR > 30) {
                    this.dRR = 30;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRR));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dRR > 29) {
                    this.dRR = 29;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRR));
            } else {
                if (this.dRR > 28) {
                    this.dRR = 28;
                }
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRR));
            }
            this.dRK.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.dRK.setCurrentItem(i3 - 1);
        }
        this.dRK.setGravity(this.gravity);
        this.dRL = (WheelView) this.view.findViewById(R.id.hour);
        this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dRL.setCurrentItem(i4);
        this.dRL.setGravity(this.gravity);
        this.dRM = (WheelView) this.view.findViewById(R.id.min);
        this.dRM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRM.setCurrentItem(i5);
        this.dRM.setGravity(this.gravity);
        this.dRN = (WheelView) this.view.findViewById(R.id.second);
        this.dRN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRN.setCurrentItem(i6);
        this.dRN.setGravity(this.gravity);
        this.dRI.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.dQG;
                c.this.dRS = i8;
                int currentItem = c.this.dRJ.getCurrentItem();
                if (c.this.dQG == c.this.dQH) {
                    c.this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dRO, c.this.dRP));
                    if (currentItem > c.this.dRJ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRJ.getAdapter().getItemsCount() - 1;
                        c.this.dRJ.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.dRO + currentItem;
                    if (c.this.dRO == c.this.dRP) {
                        c.this.a(i8, i9, c.this.dRQ, c.this.dRR, asList, asList2);
                    } else if (i9 == c.this.dRO) {
                        c.this.a(i8, i9, c.this.dRQ, 31, asList, asList2);
                    } else if (i9 == c.this.dRP) {
                        c.this.a(i8, i9, 1, c.this.dRR, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dQG) {
                    c.this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dRO, 12));
                    if (currentItem > c.this.dRJ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRJ.getAdapter().getItemsCount() - 1;
                        c.this.dRJ.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.dRO + currentItem;
                    if (i10 == c.this.dRO) {
                        c.this.a(i8, i10, c.this.dRQ, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dQH) {
                    c.this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.dRP));
                    if (currentItem > c.this.dRJ.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRJ.getAdapter().getItemsCount() - 1;
                        c.this.dRJ.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.dRP) {
                        c.this.a(i8, i11, 1, c.this.dRR, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.dRJ.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.dRT != null) {
                    c.this.dRT.aUQ();
                }
            }
        });
        this.dRJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.dQG == c.this.dQH) {
                    int i9 = (c.this.dRO + i8) - 1;
                    if (c.this.dRO == c.this.dRP) {
                        c.this.a(c.this.dRS, i9, c.this.dRQ, c.this.dRR, asList, asList2);
                    } else if (c.this.dRO == i9) {
                        c.this.a(c.this.dRS, i9, c.this.dRQ, 31, asList, asList2);
                    } else if (c.this.dRP == i9) {
                        c.this.a(c.this.dRS, i9, 1, c.this.dRR, asList, asList2);
                    } else {
                        c.this.a(c.this.dRS, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.dRS == c.this.dQG) {
                    int i10 = (c.this.dRO + i8) - 1;
                    if (i10 == c.this.dRO) {
                        c.this.a(c.this.dRS, i10, c.this.dRQ, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.dRS, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.dRS == c.this.dQH) {
                    if (i8 == c.this.dRP) {
                        c.this.a(c.this.dRS, c.this.dRJ.getCurrentItem() + 1, 1, c.this.dRR, asList, asList2);
                    } else {
                        c.this.a(c.this.dRS, c.this.dRJ.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.dRS, i8, 1, 31, asList, asList2);
                }
                if (c.this.dRT != null) {
                    c.this.dRT.aUQ();
                }
            }
        });
        a(this.dRK);
        a(this.dRL);
        a(this.dRM);
        a(this.dRN);
        if (this.dQC.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.dRI.setVisibility(this.dQC[0] ? 0 : 8);
        this.dRJ.setVisibility(this.dQC[1] ? 0 : 8);
        this.dRK.setVisibility(this.dQC[2] ? 0 : 8);
        this.dRL.setVisibility(this.dQC[3] ? 0 : 8);
        this.dRM.setVisibility(this.dQC[4] ? 0 : 8);
        this.dRN.setVisibility(this.dQC[5] ? 0 : 8);
        aUY();
    }

    private void a(WheelView wheelView) {
        if (this.dRT != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.dRT.aUQ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.dRK.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.dRK.getAdapter().getItemsCount() - 1) {
            this.dRK.setCurrentItem(this.dRK.getAdapter().getItemsCount() - 1);
        }
    }

    private void aUY() {
        this.dRK.setTextSize(this.textSize);
        this.dRJ.setTextSize(this.textSize);
        this.dRI.setTextSize(this.textSize);
        this.dRL.setTextSize(this.textSize);
        this.dRM.setTextSize(this.textSize);
        this.dRN.setTextSize(this.textSize);
    }

    private void aUZ() {
        this.dRK.setTextColorOut(this.textColorOut);
        this.dRJ.setTextColorOut(this.textColorOut);
        this.dRI.setTextColorOut(this.textColorOut);
        this.dRL.setTextColorOut(this.textColorOut);
        this.dRM.setTextColorOut(this.textColorOut);
        this.dRN.setTextColorOut(this.textColorOut);
    }

    private void aVa() {
        this.dRK.setTextColorCenter(this.textColorCenter);
        this.dRJ.setTextColorCenter(this.textColorCenter);
        this.dRI.setTextColorCenter(this.textColorCenter);
        this.dRL.setTextColorCenter(this.textColorCenter);
        this.dRM.setTextColorCenter(this.textColorCenter);
        this.dRN.setTextColorCenter(this.textColorCenter);
    }

    private void aVb() {
        this.dRK.setDividerColor(this.dividerColor);
        this.dRJ.setDividerColor(this.dividerColor);
        this.dRI.setDividerColor(this.dividerColor);
        this.dRL.setDividerColor(this.dividerColor);
        this.dRM.setDividerColor(this.dividerColor);
        this.dRN.setDividerColor(this.dividerColor);
    }

    private void aVc() {
        this.dRK.setDividerType(this.dRm);
        this.dRJ.setDividerType(this.dRm);
        this.dRI.setDividerType(this.dRm);
        this.dRL.setDividerType(this.dRm);
        this.dRM.setDividerType(this.dRm);
        this.dRN.setDividerType(this.dRm);
    }

    private void aVd() {
        this.dRK.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRJ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRI.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRL.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRM.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRN.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.dQJ) {
            if (str != null) {
                this.dRI.setLabel(str);
            } else {
                this.dRI.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.dRJ.setLabel(str2);
            } else {
                this.dRJ.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.dRK.setLabel(str3);
            } else {
                this.dRK.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.dRL.setLabel(str4);
            } else {
                this.dRL.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.dRM.setLabel(str5);
            } else {
                this.dRM.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.dRN.setLabel(str6);
            } else {
                this.dRN.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dRK.setTextXOffset(i);
        this.dRJ.setTextXOffset(i2);
        this.dRI.setTextXOffset(i3);
        this.dRL.setTextXOffset(i4);
        this.dRM.setTextXOffset(i5);
        this.dRN.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.dRI.setCyclic(z);
        this.dRJ.setCyclic(z);
        this.dRK.setCyclic(z);
        this.dRL.setCyclic(z);
        this.dRM.setCyclic(z);
        this.dRN.setCyclic(z);
    }

    public String getTime() {
        if (this.dQJ) {
            return aVe();
        }
        StringBuilder sb = new StringBuilder();
        if (this.dRS == this.dQG) {
            if (this.dRJ.getCurrentItem() + this.dRO == this.dRO) {
                sb.append(this.dRI.getCurrentItem() + this.dQG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRJ.getCurrentItem() + this.dRO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRK.getCurrentItem() + this.dRQ).append(HanziToPinyin.Token.SEPARATOR).append(this.dRL.getCurrentItem()).append(":").append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem());
            } else {
                sb.append(this.dRI.getCurrentItem() + this.dQG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRJ.getCurrentItem() + this.dRO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRK.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dRL.getCurrentItem()).append(":").append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem());
            }
        } else {
            sb.append(this.dRI.getCurrentItem() + this.dQG).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRJ.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRK.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dRL.getCurrentItem()).append(":").append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem());
        }
        return sb.toString();
    }

    private String aVe() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.dRI.getCurrentItem() + this.dQG;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) == 0) {
            currentItem = this.dRJ.getCurrentItem() + 1;
            z = false;
        } else if ((this.dRJ.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) <= 0) {
            currentItem = this.dRJ.getCurrentItem() + 1;
            z = false;
        } else if ((this.dRJ.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) == 1) {
            currentItem = this.dRJ.getCurrentItem();
            z = true;
        } else {
            currentItem = this.dRJ.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.dRK.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.dRL.getCurrentItem()).append(":").append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nM(int i) {
        this.dQG = i;
    }

    public void nN(int i) {
        this.dQH = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.dQG) {
                this.dQH = i;
                this.dRP = i2;
                this.dRR = i3;
            } else if (i == this.dQG) {
                if (i2 > this.dRO) {
                    this.dQH = i;
                    this.dRP = i2;
                    this.dRR = i3;
                } else if (i2 == this.dRO && i3 > this.dRQ) {
                    this.dQH = i;
                    this.dRP = i2;
                    this.dRR = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.dQH) {
                this.dRO = i5;
                this.dRQ = i6;
                this.dQG = i4;
            } else if (i4 == this.dQH) {
                if (i5 < this.dRP) {
                    this.dRO = i5;
                    this.dRQ = i6;
                    this.dQG = i4;
                } else if (i5 == this.dRP && i6 < this.dRR) {
                    this.dRO = i5;
                    this.dRQ = i6;
                    this.dQG = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.dQG = calendar.get(1);
            this.dQH = calendar2.get(1);
            this.dRO = calendar.get(2) + 1;
            this.dRP = calendar2.get(2) + 1;
            this.dRQ = calendar.get(5);
            this.dRR = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        aVd();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        aVb();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dRm = dividerType;
        aVc();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        aVa();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        aUZ();
    }

    public void isCenterLabel(boolean z) {
        this.dRK.isCenterLabel(z);
        this.dRJ.isCenterLabel(z);
        this.dRI.isCenterLabel(z);
        this.dRL.isCenterLabel(z);
        this.dRM.isCenterLabel(z);
        this.dRN.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.dRT = bVar;
    }
}
