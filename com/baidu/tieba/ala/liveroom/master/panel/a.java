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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private int[] hIV;
    private short[] hIW;
    private int[] hIX;
    private InterfaceC0670a hIY;
    private Context mContext;
    private final int hIS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds160);
    public final int hIT = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds152);
    public final int hIU = (BdUtilHelper.getScreenDimensions(TbadkCoreApplication.getInst())[1] - (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) * 2)) / 4;
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.panel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = 0;
            boolean z = true;
            if (view instanceof AlaMasterOperationSwitchItemView) {
                int itemId = ((AlaMasterOperationSwitchItemView) view).getItemId();
                int vV = a.this.vV(itemId);
                if (vV >= 0) {
                    if (a.this.hIW[vV] == 1) {
                        a.this.hIW[vV] = 2;
                    } else if (a.this.hIW[vV] == 2) {
                        a.this.hIW[vV] = 1;
                    }
                    a.this.notifyDataSetChanged();
                    if (a.this.hIW[vV] != 1) {
                        z = false;
                    }
                }
                i = itemId;
            } else if (view instanceof AlaMasterOperationEntryItemView) {
                i = ((AlaMasterOperationEntryItemView) view).getItemId();
            }
            if (a.this.hIY != null) {
                a.this.hIY.L(i, z);
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.liveroom.master.panel.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0670a {
        void L(int i, boolean z);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                this.hIV = new int[]{a.h.ala_operation_panel_text_mute, 0, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hIX = new int[]{4, 0, 5, 6};
            } else {
                this.hIV = new int[]{a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
                this.hIX = new int[]{4, 5, 6};
            }
            this.hIW = new short[]{1, 1, 1};
            return;
        }
        this.hIV = new int[]{a.h.ala_operation_panel_text_camera, a.h.ala_operation_panel_text_falshing, a.h.ala_operation_panel_text_mirror_off, a.h.ala_operation_panel_text_mute, a.h.ala_operation_panel_text_admin, a.h.ala_operation_panel_text_black};
        this.hIW = new short[]{1, 1, 1, 1, 1, 1};
        this.hIX = new int[]{1, 2, 3, 4, 5, 6};
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPP != null && bvVar.aPP.aSx) {
            int[] iArr = new int[this.hIV.length + 1];
            System.arraycopy(this.hIV, 0, iArr, 0, this.hIV.length);
            iArr[this.hIV.length] = a.h.ala_operation_panel_text_redpacket;
            this.hIV = iArr;
            short[] sArr = new short[this.hIW.length + 1];
            System.arraycopy(this.hIW, 0, sArr, 0, this.hIW.length);
            sArr[this.hIW.length] = 1;
            this.hIW = sArr;
            int[] iArr2 = new int[this.hIX.length + 1];
            System.arraycopy(this.hIX, 0, iArr2, 0, this.hIX.length);
            iArr2[this.hIX.length] = 7;
            this.hIX = iArr2;
        }
        if (bvVar != null && bvVar.aPK != null && bvVar.aPK.CB()) {
            int[] iArr3 = new int[this.hIV.length + 1];
            System.arraycopy(this.hIV, 0, iArr3, 0, this.hIV.length);
            iArr3[this.hIV.length] = a.h.ala_operation_panel_text_host_wish;
            this.hIV = iArr3;
            short[] sArr2 = new short[this.hIW.length + 1];
            System.arraycopy(this.hIW, 0, sArr2, 0, this.hIW.length);
            sArr2[this.hIW.length] = 1;
            this.hIW = sArr2;
            int[] iArr4 = new int[this.hIX.length + 1];
            System.arraycopy(this.hIX, 0, iArr4, 0, this.hIX.length);
            iArr4[this.hIX.length] = 8;
            this.hIX = iArr4;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hIX.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.hIX.length) {
            return -1L;
        }
        return this.hIX[i];
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return vR(this.hIX[i]) ? 0 : 1;
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
        if (i < 0 || i >= this.hIX.length) {
            return null;
        }
        int i2 = this.hIX[i];
        int i3 = this.hIV[i];
        if (vR(i2)) {
            if (view instanceof AlaMasterOperationSwitchItemView) {
                alaMasterOperationSwitchItemView2 = (AlaMasterOperationSwitchItemView) view;
            } else {
                AlaMasterOperationSwitchItemView alaMasterOperationSwitchItemView3 = new AlaMasterOperationSwitchItemView(this.mContext, i2);
                alaMasterOperationSwitchItemView3.setLayoutParams(new AbsListView.LayoutParams(ciE(), ciF()));
                alaMasterOperationSwitchItemView2 = alaMasterOperationSwitchItemView3;
            }
            alaMasterOperationSwitchItemView2.setTextResIdAndOnIconIdAndOffIconId(i3, vS(i2), vT(i2));
            alaMasterOperationSwitchItemView2.i(this.hIW[i]);
            alaMasterOperationSwitchItemView = alaMasterOperationSwitchItemView2;
        } else {
            if (view instanceof AlaMasterOperationEntryItemView) {
                alaMasterOperationEntryItemView = (AlaMasterOperationEntryItemView) view;
            } else {
                AlaMasterOperationEntryItemView alaMasterOperationEntryItemView2 = new AlaMasterOperationEntryItemView(this.mContext, i2);
                alaMasterOperationEntryItemView2.setLayoutParams(new AbsListView.LayoutParams(ciE(), ciF()));
                alaMasterOperationEntryItemView = alaMasterOperationEntryItemView2;
            }
            alaMasterOperationEntryItemView.setTextResIdAndIconResId(i3, vU(i2));
            alaMasterOperationSwitchItemView = alaMasterOperationEntryItemView;
        }
        alaMasterOperationSwitchItemView.setOnClickListener(this.fml);
        return alaMasterOperationSwitchItemView;
    }

    private boolean vR(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private int ciE() {
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            return this.hIS;
        }
        return -1;
    }

    private int ciF() {
        return UtilHelper.getRealScreenOrientation(this.mContext) == 2 ? this.hIU : this.hIT;
    }

    private int vS(int i) {
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

    private int vT(int i) {
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

    private int vU(int i) {
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
    public int vV(int i) {
        for (int i2 = 0; i2 < this.hIX.length; i2++) {
            if (this.hIX[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a(int i, short s) {
        int vV = vV(i);
        if (vV >= 0) {
            this.hIW[vV] = s;
        }
    }

    public void a(InterfaceC0670a interfaceC0670a) {
        this.hIY = interfaceC0670a;
    }
}
