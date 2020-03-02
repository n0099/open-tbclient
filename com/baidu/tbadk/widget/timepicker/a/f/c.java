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
    private boolean[] dQD;
    private WheelView dRJ;
    private WheelView dRK;
    private WheelView dRL;
    private WheelView dRM;
    private WheelView dRN;
    private WheelView dRO;
    private int dRT;
    private com.baidu.tbadk.widget.timepicker.a.d.b dRU;
    private WheelView.DividerType dRn;
    private int dividerColor;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int dQH = 1900;
    private int dQI = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int dRP = 1;
    private int dRQ = 12;
    private int dRR = 1;
    private int dRS = 31;
    private boolean dQK = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.dQD = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void hs(boolean z) {
        this.dQK = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.dQK) {
            int[] B = com.baidu.tbadk.widget.timepicker.a.e.b.B(i, i2 + 1, i3);
            a(B[0], B[1] - 1, B[2], B[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.dRJ = (WheelView) this.view.findViewById(R.id.year);
        this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.aW(this.dQH, this.dQI)));
        this.dRJ.setLabel("");
        this.dRJ.setCurrentItem(i - this.dQH);
        this.dRJ.setGravity(this.gravity);
        this.dRK = (WheelView) this.view.findViewById(R.id.month);
        this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nK(i)));
        this.dRK.setLabel("");
        int nH = com.baidu.tbadk.widget.timepicker.a.e.a.nH(i);
        if (nH != 0 && (i2 > nH - 1 || z)) {
            this.dRK.setCurrentItem(i2 + 1);
        } else {
            this.dRK.setCurrentItem(i2);
        }
        this.dRK.setGravity(this.gravity);
        this.dRL = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i) == 0) {
            this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i, i2))));
        } else {
            this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(i))));
        }
        this.dRL.setLabel("");
        this.dRL.setCurrentItem(i3 - 1);
        this.dRL.setGravity(this.gravity);
        this.dRM = (WheelView) this.view.findViewById(R.id.hour);
        this.dRM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dRM.setCurrentItem(i4);
        this.dRM.setGravity(this.gravity);
        this.dRN = (WheelView) this.view.findViewById(R.id.min);
        this.dRN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRN.setCurrentItem(i5);
        this.dRN.setGravity(this.gravity);
        this.dRO = (WheelView) this.view.findViewById(R.id.second);
        this.dRO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRO.setCurrentItem(i5);
        this.dRO.setGravity(this.gravity);
        this.dRJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int i8 = c.this.dQH + i7;
                c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nK(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) == 0 || c.this.dRK.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) - 1) {
                    c.this.dRK.setCurrentItem(c.this.dRK.getCurrentItem());
                } else {
                    c.this.dRK.setCurrentItem(c.this.dRK.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) == 0 || c.this.dRK.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) - 1) {
                    c.this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRK.getCurrentItem() + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRK.getCurrentItem() + 1);
                } else if (c.this.dRK.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nH(i8) + 1) {
                    c.this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(i8))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.nG(i8);
                } else {
                    c.this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRK.getCurrentItem()))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(i8, c.this.dRK.getCurrentItem());
                }
                if (c.this.dRL.getCurrentItem() > aV - 1) {
                    c.this.dRL.setCurrentItem(aV - 1);
                }
                if (c.this.dRU != null) {
                    c.this.dRU.aUS();
                }
            }
        });
        this.dRK.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int aV;
                int currentItem = c.this.dRJ.getCurrentItem() + c.this.dQH;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) - 1) {
                    c.this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7 + 1);
                } else if (c.this.dRK.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem) + 1) {
                    c.this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.nG(currentItem))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.nG(currentItem);
                } else {
                    c.this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nL(com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7))));
                    aV = com.baidu.tbadk.widget.timepicker.a.e.a.aV(currentItem, i7);
                }
                if (c.this.dRL.getCurrentItem() > aV - 1) {
                    c.this.dRL.setCurrentItem(aV - 1);
                }
                if (c.this.dRU != null) {
                    c.this.dRU.aUS();
                }
            }
        });
        a(this.dRL);
        a(this.dRM);
        a(this.dRN);
        a(this.dRO);
        if (this.dQD.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.dRJ.setVisibility(this.dQD[0] ? 0 : 8);
        this.dRK.setVisibility(this.dQD[1] ? 0 : 8);
        this.dRL.setVisibility(this.dQD[2] ? 0 : 8);
        this.dRM.setVisibility(this.dQD[3] ? 0 : 8);
        this.dRN.setVisibility(this.dQD[4] ? 0 : 8);
        this.dRO.setVisibility(this.dQD[5] ? 0 : 8);
        aVa();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.dRT = i;
        this.dRJ = (WheelView) this.view.findViewById(R.id.year);
        this.dRJ.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dQH, this.dQI));
        this.dRJ.setCurrentItem(i - this.dQH);
        this.dRJ.setGravity(this.gravity);
        this.dRK = (WheelView) this.view.findViewById(R.id.month);
        if (this.dQH == this.dQI) {
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRP, this.dRQ));
            this.dRK.setCurrentItem((i2 + 1) - this.dRP);
        } else if (i == this.dQH) {
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRP, 12));
            this.dRK.setCurrentItem((i2 + 1) - this.dRP);
        } else if (i == this.dQI) {
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRQ));
            this.dRK.setCurrentItem(i2);
        } else {
            this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.dRK.setCurrentItem(i2);
        }
        this.dRK.setGravity(this.gravity);
        this.dRL = (WheelView) this.view.findViewById(R.id.day);
        if (this.dQH == this.dQI && this.dRP == this.dRQ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dRS > 31) {
                    this.dRS = 31;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, this.dRS));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dRS > 30) {
                    this.dRS = 30;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, this.dRS));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dRS > 29) {
                    this.dRS = 29;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, this.dRS));
            } else {
                if (this.dRS > 28) {
                    this.dRS = 28;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, this.dRS));
            }
            this.dRL.setCurrentItem(i3 - this.dRR);
        } else if (i == this.dQH && i2 + 1 == this.dRP) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, 29));
            } else {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.dRR, 28));
            }
            this.dRL.setCurrentItem(i3 - this.dRR);
        } else if (i == this.dQI && i2 + 1 == this.dRQ) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.dRS > 31) {
                    this.dRS = 31;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRS));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.dRS > 30) {
                    this.dRS = 30;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRS));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.dRS > 29) {
                    this.dRS = 29;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRS));
            } else {
                if (this.dRS > 28) {
                    this.dRS = 28;
                }
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.dRS));
            }
            this.dRL.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.dRL.setCurrentItem(i3 - 1);
        }
        this.dRL.setGravity(this.gravity);
        this.dRM = (WheelView) this.view.findViewById(R.id.hour);
        this.dRM.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.dRM.setCurrentItem(i4);
        this.dRM.setGravity(this.gravity);
        this.dRN = (WheelView) this.view.findViewById(R.id.min);
        this.dRN.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRN.setCurrentItem(i5);
        this.dRN.setGravity(this.gravity);
        this.dRO = (WheelView) this.view.findViewById(R.id.second);
        this.dRO.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.dRO.setCurrentItem(i6);
        this.dRO.setGravity(this.gravity);
        this.dRJ.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.dQH;
                c.this.dRT = i8;
                int currentItem = c.this.dRK.getCurrentItem();
                if (c.this.dQH == c.this.dQI) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dRP, c.this.dRQ));
                    if (currentItem > c.this.dRK.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRK.getAdapter().getItemsCount() - 1;
                        c.this.dRK.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.dRP + currentItem;
                    if (c.this.dRP == c.this.dRQ) {
                        c.this.a(i8, i9, c.this.dRR, c.this.dRS, asList, asList2);
                    } else if (i9 == c.this.dRP) {
                        c.this.a(i8, i9, c.this.dRR, 31, asList, asList2);
                    } else if (i9 == c.this.dRQ) {
                        c.this.a(i8, i9, 1, c.this.dRS, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dQH) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.dRP, 12));
                    if (currentItem > c.this.dRK.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRK.getAdapter().getItemsCount() - 1;
                        c.this.dRK.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.dRP + currentItem;
                    if (i10 == c.this.dRP) {
                        c.this.a(i8, i10, c.this.dRR, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.dQI) {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.dRQ));
                    if (currentItem > c.this.dRK.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.dRK.getAdapter().getItemsCount() - 1;
                        c.this.dRK.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.dRQ) {
                        c.this.a(i8, i11, 1, c.this.dRS, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.dRK.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.dRK.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.dRU != null) {
                    c.this.dRU.aUS();
                }
            }
        });
        this.dRK.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.dQH == c.this.dQI) {
                    int i9 = (c.this.dRP + i8) - 1;
                    if (c.this.dRP == c.this.dRQ) {
                        c.this.a(c.this.dRT, i9, c.this.dRR, c.this.dRS, asList, asList2);
                    } else if (c.this.dRP == i9) {
                        c.this.a(c.this.dRT, i9, c.this.dRR, 31, asList, asList2);
                    } else if (c.this.dRQ == i9) {
                        c.this.a(c.this.dRT, i9, 1, c.this.dRS, asList, asList2);
                    } else {
                        c.this.a(c.this.dRT, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.dRT == c.this.dQH) {
                    int i10 = (c.this.dRP + i8) - 1;
                    if (i10 == c.this.dRP) {
                        c.this.a(c.this.dRT, i10, c.this.dRR, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.dRT, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.dRT == c.this.dQI) {
                    if (i8 == c.this.dRQ) {
                        c.this.a(c.this.dRT, c.this.dRK.getCurrentItem() + 1, 1, c.this.dRS, asList, asList2);
                    } else {
                        c.this.a(c.this.dRT, c.this.dRK.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.dRT, i8, 1, 31, asList, asList2);
                }
                if (c.this.dRU != null) {
                    c.this.dRU.aUS();
                }
            }
        });
        a(this.dRL);
        a(this.dRM);
        a(this.dRN);
        a(this.dRO);
        if (this.dQD.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.dRJ.setVisibility(this.dQD[0] ? 0 : 8);
        this.dRK.setVisibility(this.dQD[1] ? 0 : 8);
        this.dRL.setVisibility(this.dQD[2] ? 0 : 8);
        this.dRM.setVisibility(this.dQD[3] ? 0 : 8);
        this.dRN.setVisibility(this.dQD[4] ? 0 : 8);
        this.dRO.setVisibility(this.dQD[5] ? 0 : 8);
        aVa();
    }

    private void a(WheelView wheelView) {
        if (this.dRU != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.dRU.aUS();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.dRL.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.dRL.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.dRL.getAdapter().getItemsCount() - 1) {
            this.dRL.setCurrentItem(this.dRL.getAdapter().getItemsCount() - 1);
        }
    }

    private void aVa() {
        this.dRL.setTextSize(this.textSize);
        this.dRK.setTextSize(this.textSize);
        this.dRJ.setTextSize(this.textSize);
        this.dRM.setTextSize(this.textSize);
        this.dRN.setTextSize(this.textSize);
        this.dRO.setTextSize(this.textSize);
    }

    private void aVb() {
        this.dRL.setTextColorOut(this.textColorOut);
        this.dRK.setTextColorOut(this.textColorOut);
        this.dRJ.setTextColorOut(this.textColorOut);
        this.dRM.setTextColorOut(this.textColorOut);
        this.dRN.setTextColorOut(this.textColorOut);
        this.dRO.setTextColorOut(this.textColorOut);
    }

    private void aVc() {
        this.dRL.setTextColorCenter(this.textColorCenter);
        this.dRK.setTextColorCenter(this.textColorCenter);
        this.dRJ.setTextColorCenter(this.textColorCenter);
        this.dRM.setTextColorCenter(this.textColorCenter);
        this.dRN.setTextColorCenter(this.textColorCenter);
        this.dRO.setTextColorCenter(this.textColorCenter);
    }

    private void aVd() {
        this.dRL.setDividerColor(this.dividerColor);
        this.dRK.setDividerColor(this.dividerColor);
        this.dRJ.setDividerColor(this.dividerColor);
        this.dRM.setDividerColor(this.dividerColor);
        this.dRN.setDividerColor(this.dividerColor);
        this.dRO.setDividerColor(this.dividerColor);
    }

    private void aVe() {
        this.dRL.setDividerType(this.dRn);
        this.dRK.setDividerType(this.dRn);
        this.dRJ.setDividerType(this.dRn);
        this.dRM.setDividerType(this.dRn);
        this.dRN.setDividerType(this.dRn);
        this.dRO.setDividerType(this.dRn);
    }

    private void aVf() {
        this.dRL.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRK.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRJ.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRM.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRN.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.dRO.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.dQK) {
            if (str != null) {
                this.dRJ.setLabel(str);
            } else {
                this.dRJ.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.dRK.setLabel(str2);
            } else {
                this.dRK.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.dRL.setLabel(str3);
            } else {
                this.dRL.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.dRM.setLabel(str4);
            } else {
                this.dRM.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.dRN.setLabel(str5);
            } else {
                this.dRN.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.dRO.setLabel(str6);
            } else {
                this.dRO.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dRL.setTextXOffset(i);
        this.dRK.setTextXOffset(i2);
        this.dRJ.setTextXOffset(i3);
        this.dRM.setTextXOffset(i4);
        this.dRN.setTextXOffset(i5);
        this.dRO.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.dRJ.setCyclic(z);
        this.dRK.setCyclic(z);
        this.dRL.setCyclic(z);
        this.dRM.setCyclic(z);
        this.dRN.setCyclic(z);
        this.dRO.setCyclic(z);
    }

    public String getTime() {
        if (this.dQK) {
            return aVg();
        }
        StringBuilder sb = new StringBuilder();
        if (this.dRT == this.dQH) {
            if (this.dRK.getCurrentItem() + this.dRP == this.dRP) {
                sb.append(this.dRJ.getCurrentItem() + this.dQH).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRK.getCurrentItem() + this.dRP).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRL.getCurrentItem() + this.dRR).append(HanziToPinyin.Token.SEPARATOR).append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem()).append(":").append(this.dRO.getCurrentItem());
            } else {
                sb.append(this.dRJ.getCurrentItem() + this.dQH).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRK.getCurrentItem() + this.dRP).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRL.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem()).append(":").append(this.dRO.getCurrentItem());
            }
        } else {
            sb.append(this.dRJ.getCurrentItem() + this.dQH).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRK.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.dRL.getCurrentItem() + 1).append(HanziToPinyin.Token.SEPARATOR).append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem()).append(":").append(this.dRO.getCurrentItem());
        }
        return sb.toString();
    }

    private String aVg() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.dRJ.getCurrentItem() + this.dQH;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) == 0) {
            currentItem = this.dRK.getCurrentItem() + 1;
            z = false;
        } else if ((this.dRK.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) <= 0) {
            currentItem = this.dRK.getCurrentItem() + 1;
            z = false;
        } else if ((this.dRK.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nH(currentItem2) == 1) {
            currentItem = this.dRK.getCurrentItem();
            z = true;
        } else {
            currentItem = this.dRK.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.dRL.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(HanziToPinyin.Token.SEPARATOR).append(this.dRM.getCurrentItem()).append(":").append(this.dRN.getCurrentItem()).append(":").append(this.dRO.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void nM(int i) {
        this.dQH = i;
    }

    public void nN(int i) {
        this.dQI = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.dQH) {
                this.dQI = i;
                this.dRQ = i2;
                this.dRS = i3;
            } else if (i == this.dQH) {
                if (i2 > this.dRP) {
                    this.dQI = i;
                    this.dRQ = i2;
                    this.dRS = i3;
                } else if (i2 == this.dRP && i3 > this.dRR) {
                    this.dQI = i;
                    this.dRQ = i2;
                    this.dRS = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.dQI) {
                this.dRP = i5;
                this.dRR = i6;
                this.dQH = i4;
            } else if (i4 == this.dQI) {
                if (i5 < this.dRQ) {
                    this.dRP = i5;
                    this.dRR = i6;
                    this.dQH = i4;
                } else if (i5 == this.dRQ && i6 < this.dRS) {
                    this.dRP = i5;
                    this.dRR = i6;
                    this.dQH = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.dQH = calendar.get(1);
            this.dQI = calendar2.get(1);
            this.dRP = calendar.get(2) + 1;
            this.dRQ = calendar2.get(2) + 1;
            this.dRR = calendar.get(5);
            this.dRS = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        aVf();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        aVd();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dRn = dividerType;
        aVe();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        aVc();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        aVb();
    }

    public void isCenterLabel(boolean z) {
        this.dRL.isCenterLabel(z);
        this.dRK.isCenterLabel(z);
        this.dRJ.isCenterLabel(z);
        this.dRM.isCenterLabel(z);
        this.dRN.isCenterLabel(z);
        this.dRO.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.dRU = bVar;
    }
}
