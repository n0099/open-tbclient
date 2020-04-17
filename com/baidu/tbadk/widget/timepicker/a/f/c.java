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
    private WheelView.DividerType erP;
    private boolean[] ere;
    private WheelView esl;
    private WheelView esm;
    private WheelView esn;
    private WheelView eso;
    private WheelView esp;
    private WheelView esq;
    private int esv;
    private com.baidu.tbadk.widget.timepicker.a.d.b esw;
    private int gravity;
    private float lineSpacingMultiplier;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private View view;
    private int eri = FeatureCodes.SKY_SEG;
    private int erj = PushConstants.BROADCAST_MESSAGE_ARRIVE;
    private int esr = 1;
    private int ess = 12;
    private int est = 1;
    private int esu = 31;
    private boolean erl = false;

    public c(View view, boolean[] zArr, int i, int i2) {
        this.view = view;
        this.ere = zArr;
        this.gravity = i;
        this.textSize = i2;
        setView(view);
    }

    public void ir(boolean z) {
        this.erl = z;
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.erl) {
            int[] D = com.baidu.tbadk.widget.timepicker.a.e.b.D(i, i2 + 1, i3);
            a(D[0], D[1] - 1, D[2], D[3] == 1, i4, i5, i6);
            return;
        }
        i(i, i2, i3, i4, i5, i6);
    }

    private void a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.esl = (WheelView) this.view.findViewById(R.id.year);
        this.esl.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.bb(this.eri, this.erj)));
        this.esl.setLabel("");
        this.esl.setCurrentItem(i - this.eri);
        this.esl.setGravity(this.gravity);
        this.esm = (WheelView) this.view.findViewById(R.id.month);
        this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nZ(i)));
        this.esm.setLabel("");
        int nW = com.baidu.tbadk.widget.timepicker.a.e.a.nW(i);
        if (nW != 0 && (i2 > nW - 1 || z)) {
            this.esm.setCurrentItem(i2 + 1);
        } else {
            this.esm.setCurrentItem(i2);
        }
        this.esm.setGravity(this.gravity);
        this.esn = (WheelView) this.view.findViewById(R.id.day);
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(i) == 0) {
            this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(i, i2))));
        } else {
            this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.nV(i))));
        }
        this.esn.setLabel("");
        this.esn.setCurrentItem(i3 - 1);
        this.esn.setGravity(this.gravity);
        this.eso = (WheelView) this.view.findViewById(R.id.hour);
        this.eso.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eso.setCurrentItem(i4);
        this.eso.setGravity(this.gravity);
        this.esp = (WheelView) this.view.findViewById(R.id.min);
        this.esp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esp.setCurrentItem(i5);
        this.esp.setGravity(this.gravity);
        this.esq = (WheelView) this.view.findViewById(R.id.second);
        this.esq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esq.setCurrentItem(i5);
        this.esq.setGravity(this.gravity);
        this.esl.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.1
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int ba;
                int i8 = c.this.eri + i7;
                c.this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.nZ(i8)));
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) == 0 || c.this.esm.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) - 1) {
                    c.this.esm.setCurrentItem(c.this.esm.getCurrentItem());
                } else {
                    c.this.esm.setCurrentItem(c.this.esm.getCurrentItem() + 1);
                }
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) == 0 || c.this.esm.getCurrentItem() <= com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) - 1) {
                    c.this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esm.getCurrentItem() + 1))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esm.getCurrentItem() + 1);
                } else if (c.this.esm.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nW(i8) + 1) {
                    c.this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.nV(i8))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.nV(i8);
                } else {
                    c.this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esm.getCurrentItem()))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(i8, c.this.esm.getCurrentItem());
                }
                if (c.this.esn.getCurrentItem() > ba - 1) {
                    c.this.esn.setCurrentItem(ba - 1);
                }
                if (c.this.esw != null) {
                    c.this.esw.bdh();
                }
            }
        });
        this.esm.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.2
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int ba;
                int currentItem = c.this.esl.getCurrentItem() + c.this.eri;
                if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem) == 0 || i7 <= com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem) - 1) {
                    c.this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7 + 1))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7 + 1);
                } else if (c.this.esm.getCurrentItem() == com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem) + 1) {
                    c.this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.nV(currentItem))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.nV(currentItem);
                } else {
                    c.this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.a(com.baidu.tbadk.widget.timepicker.a.e.a.oa(com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7))));
                    ba = com.baidu.tbadk.widget.timepicker.a.e.a.ba(currentItem, i7);
                }
                if (c.this.esn.getCurrentItem() > ba - 1) {
                    c.this.esn.setCurrentItem(ba - 1);
                }
                if (c.this.esw != null) {
                    c.this.esw.bdh();
                }
            }
        });
        a(this.esn);
        a(this.eso);
        a(this.esp);
        a(this.esq);
        if (this.ere.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.esl.setVisibility(this.ere[0] ? 0 : 8);
        this.esm.setVisibility(this.ere[1] ? 0 : 8);
        this.esn.setVisibility(this.ere[2] ? 0 : 8);
        this.eso.setVisibility(this.ere[3] ? 0 : 8);
        this.esp.setVisibility(this.ere[4] ? 0 : 8);
        this.esq.setVisibility(this.ere[5] ? 0 : 8);
        bdp();
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) {
        final List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        final List asList2 = Arrays.asList("4", "6", "9", "11");
        this.esv = i;
        this.esl = (WheelView) this.view.findViewById(R.id.year);
        this.esl.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.eri, this.erj));
        this.esl.setCurrentItem(i - this.eri);
        this.esl.setGravity(this.gravity);
        this.esm = (WheelView) this.view.findViewById(R.id.month);
        if (this.eri == this.erj) {
            this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esr, this.ess));
            this.esm.setCurrentItem((i2 + 1) - this.esr);
        } else if (i == this.eri) {
            this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.esr, 12));
            this.esm.setCurrentItem((i2 + 1) - this.esr);
        } else if (i == this.erj) {
            this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.ess));
            this.esm.setCurrentItem(i2);
        } else {
            this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
            this.esm.setCurrentItem(i2);
        }
        this.esm.setGravity(this.gravity);
        this.esn = (WheelView) this.view.findViewById(R.id.day);
        if (this.eri == this.erj && this.esr == this.ess) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.esu > 31) {
                    this.esu = 31;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, this.esu));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.esu > 30) {
                    this.esu = 30;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, this.esu));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.esu > 29) {
                    this.esu = 29;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, this.esu));
            } else {
                if (this.esu > 28) {
                    this.esu = 28;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, this.esu));
            }
            this.esn.setCurrentItem(i3 - this.est);
        } else if (i == this.eri && i2 + 1 == this.esr) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, 29));
            } else {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(this.est, 28));
            }
            this.esn.setCurrentItem(i3 - this.est);
        } else if (i == this.erj && i2 + 1 == this.ess) {
            if (asList.contains(String.valueOf(i2 + 1))) {
                if (this.esu > 31) {
                    this.esu = 31;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esu));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                if (this.esu > 30) {
                    this.esu = 30;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esu));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (this.esu > 29) {
                    this.esu = 29;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esu));
            } else {
                if (this.esu > 28) {
                    this.esu = 28;
                }
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, this.esu));
            }
            this.esn.setCurrentItem(i3 - 1);
        } else {
            if (asList.contains(String.valueOf(i2 + 1))) {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 31));
            } else if (asList2.contains(String.valueOf(i2 + 1))) {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 30));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 29));
            } else {
                this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 28));
            }
            this.esn.setCurrentItem(i3 - 1);
        }
        this.esn.setGravity(this.gravity);
        this.eso = (WheelView) this.view.findViewById(R.id.hour);
        this.eso.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 23));
        this.eso.setCurrentItem(i4);
        this.eso.setGravity(this.gravity);
        this.esp = (WheelView) this.view.findViewById(R.id.min);
        this.esp.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esp.setCurrentItem(i5);
        this.esp.setGravity(this.gravity);
        this.esq = (WheelView) this.view.findViewById(R.id.second);
        this.esq.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(0, 59));
        this.esq.setCurrentItem(i6);
        this.esq.setGravity(this.gravity);
        this.esl.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.3
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + c.this.eri;
                c.this.esv = i8;
                int currentItem = c.this.esm.getCurrentItem();
                if (c.this.eri == c.this.erj) {
                    c.this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.esr, c.this.ess));
                    if (currentItem > c.this.esm.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.esm.getAdapter().getItemsCount() - 1;
                        c.this.esm.setCurrentItem(currentItem);
                    }
                    int i9 = c.this.esr + currentItem;
                    if (c.this.esr == c.this.ess) {
                        c.this.a(i8, i9, c.this.est, c.this.esu, asList, asList2);
                    } else if (i9 == c.this.esr) {
                        c.this.a(i8, i9, c.this.est, 31, asList, asList2);
                    } else if (i9 == c.this.ess) {
                        c.this.a(i8, i9, 1, c.this.esu, asList, asList2);
                    } else {
                        c.this.a(i8, i9, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.eri) {
                    c.this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(c.this.esr, 12));
                    if (currentItem > c.this.esm.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.esm.getAdapter().getItemsCount() - 1;
                        c.this.esm.setCurrentItem(currentItem);
                    }
                    int i10 = c.this.esr + currentItem;
                    if (i10 == c.this.esr) {
                        c.this.a(i8, i10, c.this.est, 31, asList, asList2);
                    } else {
                        c.this.a(i8, i10, 1, 31, asList, asList2);
                    }
                } else if (i8 == c.this.erj) {
                    c.this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, c.this.ess));
                    if (currentItem > c.this.esm.getAdapter().getItemsCount() - 1) {
                        currentItem = c.this.esm.getAdapter().getItemsCount() - 1;
                        c.this.esm.setCurrentItem(currentItem);
                    }
                    int i11 = currentItem + 1;
                    if (i11 == c.this.ess) {
                        c.this.a(i8, i11, 1, c.this.esu, asList, asList2);
                    } else {
                        c.this.a(i8, i11, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.esm.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(1, 12));
                    c.this.a(i8, c.this.esm.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (c.this.esw != null) {
                    c.this.esw.bdh();
                }
            }
        });
        this.esm.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.4
            @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
            public void onItemSelected(int i7) {
                int i8 = i7 + 1;
                if (c.this.eri == c.this.erj) {
                    int i9 = (c.this.esr + i8) - 1;
                    if (c.this.esr == c.this.ess) {
                        c.this.a(c.this.esv, i9, c.this.est, c.this.esu, asList, asList2);
                    } else if (c.this.esr == i9) {
                        c.this.a(c.this.esv, i9, c.this.est, 31, asList, asList2);
                    } else if (c.this.ess == i9) {
                        c.this.a(c.this.esv, i9, 1, c.this.esu, asList, asList2);
                    } else {
                        c.this.a(c.this.esv, i9, 1, 31, asList, asList2);
                    }
                } else if (c.this.esv == c.this.eri) {
                    int i10 = (c.this.esr + i8) - 1;
                    if (i10 == c.this.esr) {
                        c.this.a(c.this.esv, i10, c.this.est, 31, asList, asList2);
                    } else {
                        c.this.a(c.this.esv, i10, 1, 31, asList, asList2);
                    }
                } else if (c.this.esv == c.this.erj) {
                    if (i8 == c.this.ess) {
                        c.this.a(c.this.esv, c.this.esm.getCurrentItem() + 1, 1, c.this.esu, asList, asList2);
                    } else {
                        c.this.a(c.this.esv, c.this.esm.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                } else {
                    c.this.a(c.this.esv, i8, 1, 31, asList, asList2);
                }
                if (c.this.esw != null) {
                    c.this.esw.bdh();
                }
            }
        });
        a(this.esn);
        a(this.eso);
        a(this.esp);
        a(this.esq);
        if (this.ere.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.esl.setVisibility(this.ere[0] ? 0 : 8);
        this.esm.setVisibility(this.ere[1] ? 0 : 8);
        this.esn.setVisibility(this.ere[2] ? 0 : 8);
        this.eso.setVisibility(this.ere[3] ? 0 : 8);
        this.esp.setVisibility(this.ere[4] ? 0 : 8);
        this.esq.setVisibility(this.ere[5] ? 0 : 8);
        bdp();
    }

    private void a(WheelView wheelView) {
        if (this.esw != null) {
            wheelView.setOnItemSelectedListener(new com.baidu.tbadk.widget.timepicker.wheel.c.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.c.5
                @Override // com.baidu.tbadk.widget.timepicker.wheel.c.b
                public void onItemSelected(int i) {
                    c.this.esw.bdh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.esn.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
            if (i4 > 29) {
                i4 = 29;
            }
            this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        } else {
            if (i4 > 28) {
                i4 = 28;
            }
            this.esn.setAdapter(new com.baidu.tbadk.widget.timepicker.a.a.b(i3, i4));
        }
        if (currentItem > this.esn.getAdapter().getItemsCount() - 1) {
            this.esn.setCurrentItem(this.esn.getAdapter().getItemsCount() - 1);
        }
    }

    private void bdp() {
        this.esn.setTextSize(this.textSize);
        this.esm.setTextSize(this.textSize);
        this.esl.setTextSize(this.textSize);
        this.eso.setTextSize(this.textSize);
        this.esp.setTextSize(this.textSize);
        this.esq.setTextSize(this.textSize);
    }

    private void bdq() {
        this.esn.setTextColorOut(this.textColorOut);
        this.esm.setTextColorOut(this.textColorOut);
        this.esl.setTextColorOut(this.textColorOut);
        this.eso.setTextColorOut(this.textColorOut);
        this.esp.setTextColorOut(this.textColorOut);
        this.esq.setTextColorOut(this.textColorOut);
    }

    private void bdr() {
        this.esn.setTextColorCenter(this.textColorCenter);
        this.esm.setTextColorCenter(this.textColorCenter);
        this.esl.setTextColorCenter(this.textColorCenter);
        this.eso.setTextColorCenter(this.textColorCenter);
        this.esp.setTextColorCenter(this.textColorCenter);
        this.esq.setTextColorCenter(this.textColorCenter);
    }

    private void bds() {
        this.esn.setDividerColor(this.dividerColor);
        this.esm.setDividerColor(this.dividerColor);
        this.esl.setDividerColor(this.dividerColor);
        this.eso.setDividerColor(this.dividerColor);
        this.esp.setDividerColor(this.dividerColor);
        this.esq.setDividerColor(this.dividerColor);
    }

    private void bdt() {
        this.esn.setDividerType(this.erP);
        this.esm.setDividerType(this.erP);
        this.esl.setDividerType(this.erP);
        this.eso.setDividerType(this.erP);
        this.esp.setDividerType(this.erP);
        this.esq.setDividerType(this.erP);
    }

    private void bdu() {
        this.esn.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esm.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esl.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.eso.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esp.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.esq.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.erl) {
            if (str != null) {
                this.esl.setLabel(str);
            } else {
                this.esl.setLabel(this.view.getContext().getString(R.string.pickerview_year));
            }
            if (str2 != null) {
                this.esm.setLabel(str2);
            } else {
                this.esm.setLabel(this.view.getContext().getString(R.string.pickerview_month));
            }
            if (str3 != null) {
                this.esn.setLabel(str3);
            } else {
                this.esn.setLabel(this.view.getContext().getString(R.string.pickerview_day));
            }
            if (str4 != null) {
                this.eso.setLabel(str4);
            } else {
                this.eso.setLabel(this.view.getContext().getString(R.string.pickerview_hours));
            }
            if (str5 != null) {
                this.esp.setLabel(str5);
            } else {
                this.esp.setLabel(this.view.getContext().getString(R.string.pickerview_minutes));
            }
            if (str6 != null) {
                this.esq.setLabel(str6);
            } else {
                this.esq.setLabel(this.view.getContext().getString(R.string.pickerview_seconds));
            }
        }
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.esn.setTextXOffset(i);
        this.esm.setTextXOffset(i2);
        this.esl.setTextXOffset(i3);
        this.eso.setTextXOffset(i4);
        this.esp.setTextXOffset(i5);
        this.esq.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.esl.setCyclic(z);
        this.esm.setCyclic(z);
        this.esn.setCyclic(z);
        this.eso.setCyclic(z);
        this.esp.setCyclic(z);
        this.esq.setCyclic(z);
    }

    public String getTime() {
        if (this.erl) {
            return bdv();
        }
        StringBuilder sb = new StringBuilder();
        if (this.esv == this.eri) {
            if (this.esm.getCurrentItem() + this.esr == this.esr) {
                sb.append(this.esl.getCurrentItem() + this.eri).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esm.getCurrentItem() + this.esr).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esn.getCurrentItem() + this.est).append(" ").append(this.eso.getCurrentItem()).append(":").append(this.esp.getCurrentItem()).append(":").append(this.esq.getCurrentItem());
            } else {
                sb.append(this.esl.getCurrentItem() + this.eri).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esm.getCurrentItem() + this.esr).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esn.getCurrentItem() + 1).append(" ").append(this.eso.getCurrentItem()).append(":").append(this.esp.getCurrentItem()).append(":").append(this.esq.getCurrentItem());
            }
        } else {
            sb.append(this.esl.getCurrentItem() + this.eri).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esm.getCurrentItem() + 1).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(this.esn.getCurrentItem() + 1).append(" ").append(this.eso.getCurrentItem()).append(":").append(this.esp.getCurrentItem()).append(":").append(this.esq.getCurrentItem());
        }
        return sb.toString();
    }

    private String bdv() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.esl.getCurrentItem() + this.eri;
        if (com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem2) == 0) {
            currentItem = this.esm.getCurrentItem() + 1;
            z = false;
        } else if ((this.esm.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem2) <= 0) {
            currentItem = this.esm.getCurrentItem() + 1;
            z = false;
        } else if ((this.esm.getCurrentItem() + 1) - com.baidu.tbadk.widget.timepicker.a.e.a.nW(currentItem2) == 1) {
            currentItem = this.esm.getCurrentItem();
            z = true;
        } else {
            currentItem = this.esm.getCurrentItem();
            z = false;
        }
        int[] c = com.baidu.tbadk.widget.timepicker.a.e.b.c(currentItem2, currentItem, this.esn.getCurrentItem() + 1, z);
        sb.append(c[0]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[1]).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(c[2]).append(" ").append(this.eso.getCurrentItem()).append(":").append(this.esp.getCurrentItem()).append(":").append(this.esq.getCurrentItem());
        return sb.toString();
    }

    public void setView(View view) {
        this.view = view;
    }

    public void ob(int i) {
        this.eri = i;
    }

    public void oc(int i) {
        this.erj = i;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            if (i > this.eri) {
                this.erj = i;
                this.ess = i2;
                this.esu = i3;
            } else if (i == this.eri) {
                if (i2 > this.esr) {
                    this.erj = i;
                    this.ess = i2;
                    this.esu = i3;
                } else if (i2 == this.esr && i3 > this.est) {
                    this.erj = i;
                    this.ess = i2;
                    this.esu = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i4 = calendar.get(1);
            int i5 = calendar.get(2) + 1;
            int i6 = calendar.get(5);
            if (i4 < this.erj) {
                this.esr = i5;
                this.est = i6;
                this.eri = i4;
            } else if (i4 == this.erj) {
                if (i5 < this.ess) {
                    this.esr = i5;
                    this.est = i6;
                    this.eri = i4;
                } else if (i5 == this.ess && i6 < this.esu) {
                    this.esr = i5;
                    this.est = i6;
                    this.eri = i4;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.eri = calendar.get(1);
            this.erj = calendar2.get(1);
            this.esr = calendar.get(2) + 1;
            this.ess = calendar2.get(2) + 1;
            this.est = calendar.get(5);
            this.esu = calendar2.get(5);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        bdu();
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        bds();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.erP = dividerType;
        bdt();
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        bdr();
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        bdq();
    }

    public void isCenterLabel(boolean z) {
        this.esn.isCenterLabel(z);
        this.esm.isCenterLabel(z);
        this.esl.isCenterLabel(z);
        this.eso.isCenterLabel(z);
        this.esp.isCenterLabel(z);
        this.esq.isCenterLabel(z);
    }

    public void a(com.baidu.tbadk.widget.timepicker.a.d.b bVar) {
        this.esw = bVar;
    }
}
