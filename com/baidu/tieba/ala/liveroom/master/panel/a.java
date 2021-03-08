package com.baidu.tieba.ala.liveroom.master.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bv;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private int[] hKE;
    private short[] hKF;
    private int[] hKG;
    private InterfaceC0676a hKH;
    private Context mContext;
    private final int hKB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hKC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hKD = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fnL = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int vX = a.this.vX(itemId);
                if (vX >= 0) {
                    if (a.this.hKF[vX] == 1) {
                        a.this.hKF[vX] = 2;
                    } else if (a.this.hKF[vX] == 2) {
                        a.this.hKF[vX] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hKF[vX] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hKH != null) {
                a.this.hKH.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0676a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hKE = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hKG = new int[]{4, 0, 5, 6};
            } else {
                this.hKE = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hKG = new int[]{4, 5, 6};
            }
            this.hKF = new short[]{1, 1, 1};
            return;
        }
        this.hKE = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hKF = new short[]{1, 1, 1, 1, 1, 1};
        this.hKG = new int[]{1, 2, 3, 4, 5, 6};
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar != null && bvVar.aRp != null && bvVar.aRp.aTX) {
            int[] iArr = new int[this.hKE.length + 1];
            System.arraycopy(this.hKE, 0, iArr, 0, this.hKE.length);
            iArr[this.hKE.length] = a.h.ala_operation_panel_text_redpacket;
            this.hKE = iArr;
            short[] sArr = new short[this.hKF.length + 1];
            System.arraycopy(this.hKF, 0, sArr, 0, this.hKF.length);
            sArr[this.hKF.length] = 1;
            this.hKF = sArr;
            int[] iArr2 = new int[this.hKG.length + 1];
            System.arraycopy(this.hKG, 0, iArr2, 0, this.hKG.length);
            iArr2[this.hKG.length] = 7;
            this.hKG = iArr2;
        }
        if (bvVar != null && bvVar.aRk != null && bvVar.aRk.CE()) {
            int[] iArr3 = new int[this.hKE.length + 1];
            System.arraycopy(this.hKE, 0, iArr3, 0, this.hKE.length);
            iArr3[this.hKE.length] = a.h.ala_operation_panel_text_host_wish;
            this.hKE = iArr3;
            short[] sArr2 = new short[this.hKF.length + 1];
            System.arraycopy(this.hKF, 0, sArr2, 0, this.hKF.length);
            sArr2[this.hKF.length] = 1;
            this.hKF = sArr2;
            int[] iArr4 = new int[this.hKG.length + 1];
            System.arraycopy(this.hKG, 0, iArr4, 0, this.hKG.length);
            iArr4[this.hKG.length] = 8;
            this.hKG = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hKG.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hKG.length) {
            return -1L;
        }
        return this.hKG[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vT(this.hKG[i]) ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return e(i, view);
    }

    private AlaMasterOperationBaseItemView e(int i, View view) {
        AlaMasterOperationEntryItemView alaMasterOperationEntryItemView;
        AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView;
        AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView2;
        if (i < 0 || i >= this.hKG.length) {
            return null;
        }
        int i2 = this.hKG[i];
        int i3 = this.hKE[i];
        if (vT(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(ciK(), ciL()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vU(i2), vV(i2));
            alaMasterOperationSwitchItemView2.i(this.hKF[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(ciK(), ciL()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, vW(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fnL);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vT(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int ciK() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hKB;
        }
        return -1;
    }

    private int ciL() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hKD : this.hKC;
    }

    private int vU(int i) {
        if (i == 1) {
            return a.e.btn_camera_exchange_white;
        }
        if (i == 2) {
            return a.e.btn_camera_light_switch_on;
        }
        if (i == 3) {
            return a.e.btn_camera_mirror;
        }
        if (i == 4) {
            return a.e.btn_audio_close;
        }
        return 0;
    }

    private int vV(int i) {
        if (i == 1) {
            return a.e.btn_camera_exchange_white;
        }
        if (i == 2) {
            return a.e.btn_camera_light_switch_off;
        }
        if (i == 3) {
            return a.e.btn_camera_mirror;
        }
        if (i == 4) {
            return a.e.btn_audio_open;
        }
        return 0;
    }

    private int vW(int i) {
        if (i == 5) {
            return a.e.btn_live_admin;
        }
        if (i == 6) {
            return a.e.btn_live_blacklist;
        }
        if (i == 7) {
            return a.e.icon_live_redpacket;
        }
        if (i == 8) {
            return a.e.icon_live_anchor_wish;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int vX(int i) {
        for (int i2 = 0; i2 < this.hKG.length; i2++) {
            if (this.hKG[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int vX = vX(i);
        if (vX >= 0) {
            this.hKF[vX] = s;
        }
    }

    public void a(InterfaceC0676a interfaceC0676a) {
        this.hKH = interfaceC0676a;
    }
}
